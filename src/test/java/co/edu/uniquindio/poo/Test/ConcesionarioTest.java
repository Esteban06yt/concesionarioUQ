package co.edu.uniquindio.poo.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.MotoElectrico;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Transmision;
import co.edu.uniquindio.poo.model.Venta;


/**
 * Unit test for simple App.
 */
public class ConcesionarioTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
public void CRUDTransaccionTest() {
    LOG.info("Iniciado test ");
    
    Concesionario concesionario = new Concesionario("MicarroUQ");
    
    // Intentar agregar una transacción nula
    assertThrows(IllegalArgumentException.class, () -> concesionario.AgregarTransaccion(null)); // Lanza IllegalArgumentException si transacción = null

    // Crear cliente y agregarlo al concesionario
    Cliente cliente = new Cliente("Juan", "1094901954", "Juanito@gmail.com", "546548", LocalDate.of(2004, 2, 12), "Juanito123", "1234", "¿Color de pelo?", "Rojo");
    String respuesta = concesionario.AgregarPersona(cliente);
    assertEquals("La persona se añadió correctamente", respuesta); // Cliente no existe, así que se agrega

    // Crear empleado y agregarlo al concesionario
    Empleado empleado = new Empleado("Paco", "2135446", "Paco213@gmail.com", "54654564", LocalDate.of(1994, 3, 6), "Paco576", "0000", "¿Color de pelo?", "Azul", "2");
    respuesta = concesionario.AgregarPersona(empleado);
    assertEquals("La persona se añadió correctamente", respuesta); // Empleado no existe, así que se agrega

    // Intentar agregar al mismo empleado nuevamente
    respuesta = concesionario.AgregarPersona(empleado);
    assertEquals("Esta persona ya existe", respuesta); // Empleado ya existente, no se agrega

    // Crear y agregar vehículo
    MotoElectrico motoElectrico = new MotoElectrico("12", "Yamaha", "2024", 7, 300f, 200f, Transmision.MANUAL, Estado.NUEVO, 3f, 2f);
    respuesta = concesionario.AgregarVehiculo(motoElectrico);
    assertEquals("El vehículo se añadió correctamente", respuesta); // Vehículo no existe, así que se agrega

    // Crear y agregar transacción
    Venta venta = new Venta("54", LocalDate.of(1994, 5, 30), 500000f, cliente, empleado, motoElectrico, "Tarjeta" , true);
    respuesta = concesionario.AgregarTransaccion(venta);
    assertEquals("La transaccion se añadió correctamente", respuesta); // Transacción no existe, así que se agrega

    // Verificar que la transacción se asocia automáticamente al cliente, empleado y vehículo
    LinkedList<Transaccion> listaaux = new LinkedList<>();
    listaaux.add(venta);
    assertEquals(listaaux, cliente.getListatransacciones()); // Transacción asociada al cliente
    assertEquals(listaaux, empleado.getListatransacciones()); // Transacción asociada al empleado
    assertEquals(listaaux, motoElectrico.getListatransacciones()); // Transacción asociada al vehículo

    // Buscar transacción
    Transaccion transaccionaux = concesionario.BuscarTransaccion(venta.getIdtransaccion());
    assertEquals(venta, transaccionaux); // Encuentra la transacción en el sistema

    // Actualizar transacción
    venta.setIdtransaccion("99"); // Cambiar ID de la transacción
    respuesta = concesionario.ActualizarTransaccion(transaccionaux, venta);
    assertEquals("La transacción ha sido actualizada", respuesta); // Transacción actualizada correctamente

    // Verificar que la actualización se refleja en cliente, empleado y vehículo
    listaaux.clear();
    listaaux.add(venta);
    assertEquals(listaaux, cliente.getListatransacciones()); // Transacción actualizada en cliente
    assertEquals(listaaux, empleado.getListatransacciones()); // Transacción actualizada en empleado
    assertEquals(listaaux, motoElectrico.getListatransacciones()); // Transacción actualizada en vehículo

    // Eliminar transacción
    respuesta = concesionario.EliminarTransaccion(venta);
    assertEquals("La transaccion se eliminó correctamente", respuesta); // Transacción eliminada correctamente

    // Verificar que la transacción se elimina de cliente, empleado y vehículo
    listaaux.clear();
    assertEquals(listaaux, cliente.getListatransacciones()); // Transacción eliminada del cliente
    assertEquals(listaaux, empleado.getListatransacciones()); // Transacción eliminada del empleado
    assertEquals(listaaux, motoElectrico.getListatransacciones()); // Transacción eliminada del vehículo

    // Intentar eliminar una transacción que ya no existe
    respuesta = concesionario.EliminarTransaccion(venta);
    assertEquals("Esta transaccion no existe", respuesta); // Transacción no existe, no se puede eliminar

    // Buscar transacción eliminada
    transaccionaux = concesionario.BuscarTransaccion(venta.getIdtransaccion());
    assertNull(transaccionaux); // No encuentra la transacción, devuelve null

    LOG.info("Finalizando test ");
}
}
