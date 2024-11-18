package co.edu.uniquindio.poo.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Alquiler;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.MotoElectrico;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Transmision;


/**
 * Unit test for simple App.
 */
public class VehiculoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
@Test
public void CRUDTransaccionTest() {
    LOG.info("Iniciado test ");
    
    Concesionario concesionario = new Concesionario("MicarroUQ");

    // Crear cliente 
    Cliente cliente = new Cliente("Juan", "1094901954", "Juanito@gmail.com", "546548", LocalDate.of(2004, 2, 12), "Juanito123", "1234", "¿Color de pelo?", "Rojo");
    concesionario.AgregarPersona(cliente);

    // Crear empleado
    Empleado empleado = new Empleado("Paco", "2135446", "Paco213@gmail.com", "54654564", LocalDate.of(1994, 3, 6), "Paco576", "0000", "¿Color de pelo?", "Azul", "2");
    concesionario.AgregarPersona(empleado);

    // Crear vehículo
    MotoElectrico motoElectrico = new MotoElectrico("12", "Yamaha", "2024", 7, 300f, 200f, Transmision.MANUAL, Estado.NUEVO, 3f, 2f);
    concesionario.AgregarVehiculo(motoElectrico);

    // Crear transaccion y verificar que se agregue automaticamente
    Alquiler alquiler = new Alquiler("54", LocalDate.of(1994, 5, 30), 500000f, cliente, empleado, motoElectrico,LocalDate.of(1994, 6, 5),6);
    concesionario.AgregarTransaccion(alquiler);
    String respuesta = motoElectrico.AgregarTransaccion(alquiler);
    assertEquals("Esta transaccion ya existe", respuesta); // Transacción se agrega automaticamente entonces ya existe.

    // Intentar agregar una transacción nula
    assertThrows(IllegalArgumentException.class, () -> motoElectrico.AgregarTransaccion(null)); // Lanza IllegalArgumentException si transacción = null

    // Buscar transacción
    Transaccion transaccionaux = motoElectrico.BuscarTransaccion(alquiler.getIdtransaccion());
    assertEquals(alquiler, transaccionaux); // Encuentra la transacción en el sistema

    // Actualizar transacción
    alquiler.setIdtransaccion("99"); // Cambiar ID de la transacción
    respuesta = motoElectrico.ActualizarTransaccion(transaccionaux, alquiler);
    assertEquals("La transacción ha sido actualizada", respuesta); // Transacción actualizada correctamente

    // Eliminar transacción
    respuesta = motoElectrico.EliminarTransaccion(alquiler);
    assertEquals("La transaccion se eliminó correctamente", respuesta); // Transacción eliminada correctamentensacción eliminada del vehículo

    // Intentar eliminar una transacción que ya no existe
    respuesta = motoElectrico.EliminarTransaccion(alquiler);
    assertEquals("Esta transaccion no existe", respuesta); // Transacción no existe, no se puede eliminar

    // Buscar transacción eliminada
    transaccionaux = motoElectrico.BuscarTransaccion(alquiler.getIdtransaccion());
    assertNull(transaccionaux); // No encuentra la transacción, devuelve null

    LOG.info("Finalizando test ");
}
}
