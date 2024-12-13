/*Una compañía de autos usados paga $2,500.00 de sueldo a sus empleados por mes, Además agrega pagos
extras a sus sueldos como: una comisión de $250.00 por cada automóvil vendido cuyo valor de venta 
supere el $10,000.00 y el 5% de utilidad del valor total de ventas.  La compañía necesita emitir un 
informe desglosado por empleado donde indique el número total de autos vendidos, el valor total de 
los autos que vendió, el monto total que se le debería pagar al final del mes, indicando: el sueldo 
mensual, la comisión por cada automóvil y la utilidad por el valor total de la venta. También debe 
permitir ingresar la venta de los automóviles hasta que se desee y luego emitir el respectivo informe.*/

package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio1unidad2 {

    public static class Informe {
        public int totalVehiculos = 0;
        public double ventasTotales = 0;
        public double salarioFinal = 0;
        public double comisionesPorVehiculo = 0;
        public double comisionesTotales = 0;
    }

    public static double calcularComisionesVehiculo(double precioVehiculo){
        double comisionFija = 250;
        double umbralComision = 10000;
        if(precioVehiculo > umbralComision){
            return comisionFija;
        }
        return 0;
    }

    public static double calcularComisionesPorVentas(double ventasTotales){
        return ventasTotales * 0.05;
    }

    public void ejecutar() {
        double salarioBase = 2500;      

        Informe informe = new Informe();        
        
        Scanner valor = new Scanner(System.in);
        int contador = 1;
        String mensaje = "Ingrese el precio final del vehículo " + contador;
        System.out.println(mensaje);
        while (valor.hasNextDouble()){            
            double precioVehiculo = valor.nextDouble();            

            informe.ventasTotales += precioVehiculo;
            informe.comisionesPorVehiculo += calcularComisionesVehiculo(precioVehiculo);

            System.out.println("Vehículo registrado con éxito. ¿Desea registrar otro? (sí/no)");
            String respuesta = valor.next();
            if (!respuesta.equalsIgnoreCase("si")) {
                break;
            }            
            contador++;            
            System.out.println("Ingrese el precio final del vehículo " + contador);
        }            

        informe.totalVehiculos = contador;        
        informe.comisionesTotales = calcularComisionesPorVentas(informe.ventasTotales);
        informe.salarioFinal = salarioBase + informe.comisionesPorVehiculo + informe.comisionesTotales;

        System.out.println("Total de vehículos vendidos: " + informe.totalVehiculos);
        System.out.println("Ventas totales: " + informe.ventasTotales);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Total de comisiones por vehículos: " + informe.comisionesPorVehiculo);
        System.out.println("Total de comisiones por ventas: " + informe.comisionesTotales);
        System.out.println("Salario final: " + informe.salarioFinal);
    }
}
