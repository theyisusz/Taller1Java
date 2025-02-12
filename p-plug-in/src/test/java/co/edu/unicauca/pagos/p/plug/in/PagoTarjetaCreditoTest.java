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
public class PagoTarjetaCreditoTest {
   
    @Test
    public void testValidarConNumeroValido() {
        System.out.println("Validar número de tarjeta válido");
        PagoTarjetaCredito instance = new PagoTarjetaCredito("1234567812345678", 100.0);
        assertTrue(instance.validar(), "La tarjeta debería ser válida.");
    }

    @Test
    public void testValidarConNumeroInvalido() {
        System.out.println("Validar número de tarjeta inválido");
        PagoTarjetaCredito instance = new PagoTarjetaCredito("1234", 100.0);
        assertFalse(instance.validar(), "La tarjeta debería ser inválida.");
    }

    @Test
    public void testProcesarConTarjetaValida() {
        System.out.println("Procesar pago con tarjeta válida");
        PagoTarjetaCredito instance = new PagoTarjetaCredito("1234567812345678", 150.0);
        instance.procesar();
        assertTrue(instance.validar(), "El procesamiento debería validar la tarjeta.");
    }

    @Test
    public void testProcesarConTarjetaInvalida() {
        System.out.println("Procesar pago con tarjeta inválida");
        PagoTarjetaCredito instance = new PagoTarjetaCredito("0000", 150.0);
        instance.procesar();
        assertFalse(instance.validar(), "El procesamiento debería fallar por tarjeta inválida.");
    }

    @Test
    public void testObtenerDetalle() {
        System.out.println("Obtener detalle del pago");
        PagoTarjetaCredito instance = new PagoTarjetaCredito("1234567812345678", 200.0);
        String result = instance.obtenerDetalle();
        System.out.println("Resultado obtenido: " + result); // Agrega esto para depurar
        assertTrue(result.contains("200"), "El detalle del pago debería contener el monto 200.");
}


}
