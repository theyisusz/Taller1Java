/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.pagos.p.plug.in;

import co.edu.unicauca.pagos.p.common.IPago;

/**
 *
 * @author Yisus
 */
public class PagoTarjetaCredito implements IPago{
  private String numeroTarjeta;
    private double monto;

    public PagoTarjetaCredito(String numero, double monto) {
        this.numeroTarjeta = numero;
        this.monto = monto;
    }
     @Override
    public boolean validar() {
        return numeroTarjeta != null && numeroTarjeta.length() == 16;
    }

    @Override
    public void procesar() {
        if (validar()) {
            System.out.println("Pago procesado: " + monto);
        } else {
            System.out.println("Número de tarjeta inválido.");
        }
    }

    @Override
    public String obtenerDetalle() {
        return "Pago con tarjeta - Monto: " + monto;
    }
    
}
