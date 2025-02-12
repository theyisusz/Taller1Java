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
public class PagoCriptomoneda implements IPago {
 private String direccionBilletera;
    private double monto;

    public PagoCriptomoneda(String direccionBilletera, double monto) {
        this.direccionBilletera = direccionBilletera;
        this.monto = monto;
    }

    @Override
    public boolean validar() {
        return getDireccionBilletera() != null && getDireccionBilletera().matches("[a-zA-Z0-9]{26,35}"); // Validación básica
    }

    @Override
    public void procesar() {
        if (validar()) {
            System.out.println("Procesando pago con criptomonedas por: " + getMonto());
        } else {
            System.out.println("Dirección de billetera inválida.");
        }
    }

    @Override
    public String obtenerDetalle() {
        return "Pago con criptomonedas - Monto: " + getMonto();
    }

    /**
     * @return the direccionBilletera
     */
    public String getDireccionBilletera() {
        return direccionBilletera;
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
