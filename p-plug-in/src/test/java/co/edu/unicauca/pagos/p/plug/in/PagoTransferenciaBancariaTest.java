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
public class PagoTransferenciaBancariaTest {
    @Test
    public void testValidarConCuentaValida() {
        PagoTransferenciaBancaria instance = new PagoTransferenciaBancaria("1234567890", 500.0);
        assertTrue(instance.validar(), "La cuenta debería ser válida.");
    }

    @Test
    public void testValidarConCuentaInvalida() {
        PagoTransferenciaBancaria instance = new PagoTransferenciaBancaria("123", 500.0);
        assertFalse(instance.validar(), "La cuenta debería ser inválida.");
    }

    @Test
    public void testProcesarConCuentaValida() {
        PagoTransferenciaBancaria instance = new PagoTransferenciaBancaria("1234567890", 500.0);
        instance.procesar();
        assertTrue(instance.validar(), "El procesamiento debería validar la cuenta.");
    }

    @Test
    public void testProcesarConCuentaInvalida() {
        PagoTransferenciaBancaria instance = new PagoTransferenciaBancaria("12", 500.0);
        instance.procesar();
        assertFalse(instance.validar(), "El procesamiento debería fallar por cuenta inválida.");
    }

    @Test
    public void testObtenerDetalle() {
        PagoTransferenciaBancaria instance = new PagoTransferenciaBancaria("1234567890", 500.0);
        String expResult = "Pago por transferencia bancaria - Monto: 500.0";
        assertEquals(expResult, instance.obtenerDetalle(), "El detalle del pago no coincide con el esperado.");
    }
    
}
