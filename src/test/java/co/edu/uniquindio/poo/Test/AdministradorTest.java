package co.edu.uniquindio.poo.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Administrador;
import co.edu.uniquindio.poo.model.Concesionario;
import co.edu.uniquindio.poo.model.Empleado;


/**
 * Unit test for simple App.
 */
public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void CRUDEmpleadoTest() {
        LOG.info("Iniciado test ");
        
        // Crear concesionario y administrador
        Concesionario concesionario = new Concesionario("MicarroUQ");
        Administrador administrador = new Administrador(
            "Juan", "1094901954", "Juanito@gmail.com", "546548",
            LocalDate.of(2004, 2, 12), "Juanito123", "1234",
            "¿Color de pelo?", "Rojo", "1"
        );
        String respuesta = concesionario.AgregarPersona(administrador);
        assertEquals("La persona se añadió correctamente", respuesta); // Administrador no existe, así que se agrega
    
        // Crear empleado y agregarlo mediante el administrador
        Empleado empleado = new Empleado(
            "Paco", "2135446", "Paco213@gmail.com", "54654564",
            LocalDate.of(1994, 3, 6), "Paco576", "0000",
            "¿Color de pelo?", "Azul", "2"
        );
        respuesta = administrador.AgregarEmpleado(empleado);
        assertEquals("El empleado se añadió correctamente", respuesta); // Empleado no existe, así que se agrega
    
        // Actualizar empleado
        Empleado empleadoaux = empleado; // Crear referencia al empleado original
        empleado.setContraseña("0101"); // Cambiar contraseña del empleado
        respuesta = administrador.ActualizarEmpleado(empleadoaux, empleado);
        assertEquals("El empleado ha sido actualizado", respuesta); // Empleado actualizado correctamente
    
        // Buscar empleado actualizado
        empleadoaux = administrador.BuscarEmpleado(empleado.getCedula());
        assertEquals(empleado, empleadoaux); // Verificar que se obtuvo el empleado correctamente por su cédula
    
        // Intentar agregar un empleado nulo
        assertThrows(IllegalArgumentException.class, () -> administrador.AgregarEmpleado(null)); // Lanza IllegalArgumentException
    
        // Eliminar empleado
        respuesta = administrador.EliminarEmpleado(empleado);
        assertEquals("El empleado se eliminó correctamente", respuesta); // Empleado eliminado correctamente
    
        // Intentar eliminar un empleado que ya no existe
        respuesta = administrador.EliminarEmpleado(empleado);
        assertEquals("Este empleado no existe", respuesta); // Empleado ya eliminado, no se puede eliminar nuevamente
    
        // Buscar empleado eliminado
        empleadoaux = administrador.BuscarEmpleado(empleado.getCedula());
        assertNull(empleadoaux); // Como fue eliminado, debe retornar null
    
        LOG.info("Finalizando test ");
    }
    
}