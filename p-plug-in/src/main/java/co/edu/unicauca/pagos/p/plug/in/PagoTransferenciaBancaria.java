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
public class PagoTransferenciaBancaria implements IPago{

    private String numeroCuenta;
    private double monto;

    public PagoTransferenciaBancaria(String numeroCuenta, double monto) {
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
    }

    @Override
    public boolean validar() {
        return getNumeroCuenta() != null && getNumeroCuenta().matches("\\d{10,12}"); // Cuenta de 10 a 12 dígitos
    }

    @Override
    public void procesar() {
        if (validar()) {
            System.out.println("Procesando transferencia bancaria por: " + getMonto());
        } else {
            System.out.println("Número de cuenta bancaria inválido.");
        }
    }

    @Override
    public String obtenerDetalle() {
        return "Pago por transferencia bancaria - Monto: " + getMonto();
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
}
