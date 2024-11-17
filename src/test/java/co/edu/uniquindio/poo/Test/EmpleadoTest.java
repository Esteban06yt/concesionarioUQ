package co.edu.uniquindio.poo.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;
import co.edu.uniquindio.poo.model.Estado;
import co.edu.uniquindio.poo.model.MotoElectrico;
import co.edu.uniquindio.poo.model.Transmision;


/**
 * Unit test for simple App.
 */
public class EmpleadoTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void CRUDVehiculoTest() {
        LOG.info("Iniciado test ");
        
        // Crear concesionario y empleado
        Concesionario concesionario = new Concesionario("MicarroUQ");
        Empleado empleado = new Empleado(
            "Paco", "2135446", "Paco213@gmail.com", "54654564",
            LocalDate.of(1994, 3, 6), "Paco576", "0000",
            "¿Color de pelo?", "Azul", "2"
        );
        String respuesta = concesionario.AgregarPersona(empleado);
        assertEquals("La persona se añadió correctamente", respuesta); // Empleado no existe, así que se agrega
    
        // Crear vehículo y agregarlo
        MotoElectrico motoElectrico = new MotoElectrico(
            "12", "Yamaha", "2024", 7, 300f, 200f,
            Transmision.MANUAL, Estado.NUEVO, 3f, 2f
        );
        respuesta = empleado.AgregarVehiculo(motoElectrico);
        assertEquals("El vehículo se añadió correctamente", respuesta); // Vehículo no existe, así que se agrega
    
        // Intentar agregar el mismo vehículo nuevamente
        respuesta = empleado.AgregarVehiculo(motoElectrico);
        assertEquals("Este vehículo ya existe", respuesta); // No se puede agregar un vehículo duplicado
    
        // Actualizar vehículo
        MotoElectrico motoaux = motoElectrico; // Crear referencia al vehículo original
        motoElectrico.setIdVehiculo("54"); // Cambiar ID del vehículo
        respuesta = empleado.ActualizarVehiculo(motoaux, motoElectrico);
        assertEquals("El vehículo ha sido actualizado", respuesta); // Vehículo actualizado correctamente
    
        // Buscar vehículo actualizado
        motoaux = (MotoElectrico) empleado.BuscarVehiculo(motoElectrico.getIdVehiculo());
        assertEquals(motoElectrico, motoaux); // Verificar que se obtuvo el vehículo correctamente por su ID
    
        // Eliminar vehículo
        respuesta = empleado.EliminarVehiculo(motoElectrico);
        assertEquals("El vehículo se eliminó correctamente", respuesta); // Vehículo eliminado correctamente
    
        // Intentar eliminar un vehículo que ya no existe
        respuesta = empleado.EliminarVehiculo(motoElectrico);
        assertEquals("Este vehículo no existe", respuesta); // Vehículo ya eliminado, no se puede eliminar nuevamente
    
        // Intentar eliminar un vehículo nulo
        assertThrows(IllegalArgumentException.class, () -> empleado.EliminarVehiculo(null)); // Lanza IllegalArgumentException
    
        // Buscar vehículo eliminado
        motoaux = (MotoElectrico) empleado.BuscarVehiculo(motoElectrico.getIdVehiculo());
        assertNull(motoaux); // Como el vehículo fue eliminado, debe retornar null
    
        LOG.info("Finalizando test ");
    }
    

    /**
     * Rigorous Test :-)
     */
    @Test
    public void CRUDClienteTest() {
        LOG.info("Iniciado test ");
        
        // Crear concesionario y empleado
        Concesionario concesionario = new Concesionario("MicarroUQ");
        Empleado empleado = new Empleado(
            "Paco", "2135446", "Paco213@gmail.com", "54654564",
            LocalDate.of(1994, 3, 6), "Paco576", "0000",
            "¿Color de pelo?", "Azul", "2"
        );
        String respuesta = concesionario.AgregarPersona(empleado);
        assertEquals("La persona se añadió correctamente", respuesta); // El empleado no existe, se agrega correctamente
        
        // Crear cliente
        Cliente cliente = new Cliente(
            "Juan", "1094901954", "Juanito@gmail.com", "546548",
            LocalDate.of(2004, 2, 12), "Juanito123", "1234",
            "¿Color de pelo?", "Rojo"
        );
        
        // Agregar cliente
        respuesta = empleado.AgregarCliente(cliente);
        assertEquals("El cliente se añadió correctamente", respuesta); // Cliente agregado correctamente
    
        // Intentar agregar un cliente existente
        respuesta = empleado.AgregarCliente(cliente);
        assertEquals("Este cliente ya existe", respuesta); // El cliente ya está registrado, no se puede duplicar
        
        // Actualizar cliente
        Cliente clienteActualizado = new Cliente(
            "Juan Actualizado", "1094901954", "JuanitoNuevo@gmail.com", "123456",
            LocalDate.of(2004, 2, 12), "Juanito123", "5678",
            "¿Color de pelo?", "Verde"
        );
        respuesta = empleado.ActualizarCliente(cliente, clienteActualizado);
        assertEquals("El cliente ha sido actualizado", respuesta); // Cliente actualizado correctamente
        
        // Buscar cliente actualizado
        Cliente clienteBuscado = empleado.BuscarCliente(clienteActualizado.getCedula());
        assertEquals(clienteActualizado, clienteBuscado); // Cliente encontrado correctamente con la información actualizada
        
        // Eliminar cliente
        respuesta = empleado.EliminarCliente(clienteActualizado);
        assertEquals("El cliente se eliminó correctamente", respuesta); // Cliente eliminado correctamente
        
        // Intentar eliminar un cliente que ya no existe
        respuesta = empleado.EliminarCliente(clienteActualizado);
        assertEquals("Este cliente no existe", respuesta); // Cliente ya eliminado, no se puede eliminar nuevamente
        
        // Intentar eliminar un cliente nulo
        assertThrows(IllegalArgumentException.class, () -> empleado.EliminarCliente(null)); // Lanzar excepción al intentar eliminar un cliente nulo
        
        // Verificar que el cliente ya no está en el sistema
        clienteBuscado = empleado.BuscarCliente(clienteActualizado.getCedula());
        assertNull(clienteBuscado); // Como el cliente fue eliminado, debe retornar null
        
        LOG.info("Finalizando test ");
    }
    
}