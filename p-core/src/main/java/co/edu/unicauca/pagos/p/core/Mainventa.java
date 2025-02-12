/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.unicauca.pagos.p.core;

import co.edu.unicauca.pagos.p.common.IPago;
import co.edu.unicauca.pagos.p.plug.in.PagoCriptomoneda;
import co.edu.unicauca.pagos.p.plug.in.PagoTarjetaCredito;
import co.edu.unicauca.pagos.p.plug.in.PagoTransferenciaBancaria;
import java.util.Scanner;

/**
 *
 * @author Yisus
 */
public class Mainventa {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        System.out.println("== Sistema de Procesamiento de Pagos ==");
        System.out.println("Seleccione el tipo de pago:");
        System.out.println("1. Pago con Tarjeta de Crédito");
        System.out.println("2. Pago por Transferencia Bancaria");
        System.out.println("3. Pago con Criptomonedas");
        
        System.out.print("Ingrese su opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        IPago pago = null;
        
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el número de la tarjeta (16 dígitos): ");
                String numeroTarjeta = scanner.nextLine();
                System.out.print("Ingrese el monto: ");
                double montoTarjeta = scanner.nextDouble();
                pago = new PagoTarjetaCredito(numeroTarjeta, montoTarjeta);
                break;

            case 2:
                System.out.print("Ingrese el número de cuenta bancaria (10-12 dígitos): ");
                String numeroCuenta = scanner.nextLine();
                System.out.print("Ingrese el monto: ");
                double montoCuenta = scanner.nextDouble();
                pago = new PagoTransferenciaBancaria(numeroCuenta, montoCuenta);
                break;

            case 3:
                System.out.print("Ingrese la dirección de la billetera (26-35 caracteres): ");
                String direccionBilletera = scanner.nextLine();
                System.out.print("Ingrese el monto: ");
                double montoCripto = scanner.nextDouble();
                pago = new PagoCriptomoneda(direccionBilletera, montoCripto);
                break;

            default:
                System.out.println("Opción inválida.");
                System.exit(0);
        }
       
        System.out.println("\nProcesando el pago...");
        pago.procesar();
        System.out.println(pago.obtenerDetalle());

        scanner.close();
        }   
}
