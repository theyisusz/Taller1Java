/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.pagos.p.plug.in;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Yisus
 */
public class PagoCriptomonedaTest {
    
    @Test
    public void testValidarConDireccionValida() {
        PagoCriptomoneda instance = new PagoCriptomoneda("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", 300.0);
        assertTrue(instance.validar(), "La dirección de la billetera debería ser válida.");
    }

    @Test
    public void testValidarConDireccionInvalida() {
        PagoCriptomoneda instance = new PagoCriptomoneda("1234", 300.0);
        assertFalse(instance.validar(), "La dirección de la billetera debería ser inválida.");
    }

    @Test
    public void testProcesarConDireccionValida() {
        PagoCriptomoneda instance = new PagoCriptomoneda("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", 300.0);
        instance.procesar();
        assertTrue(instance.validar(), "El procesamiento debería validar la dirección.");
    }

    @Test
    public void testProcesarConDireccionInvalida() {
        PagoCriptomoneda instance = new PagoCriptomoneda("abcd", 300.0);
        instance.procesar();
        assertFalse(instance.validar(), "El procesamiento debería fallar por dirección inválida.");
    }

    @Test
    public void testObtenerDetalle() {
        PagoCriptomoneda instance = new PagoCriptomoneda("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", 300.0);
        String expResult = "Pago con criptomonedas - Monto: 300.0";
        assertEquals(expResult, instance.obtenerDetalle(), "El detalle del pago no coincide con el esperado.");
    }
}
