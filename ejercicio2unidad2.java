/*La empresa municipal de agua potable de Loja desea cobrar y calcular mensualmente 
elEl costo de las llamadas telefónicas internacionales depende de la zona geográfica
en la que se encuentre el país destino y del número de minutos hablados. En la siguiente
tabla se presenta el costo del minuto por hora. Cada zona se le ha asociado con una clave
(Use tipos de datos ENUMERADOS PARA LA ZONA).

ZONA  /  CODIGO  /  PRECIO MINUTO (USD)
AMÉRICA DEL NORTE/12/2.75
AMÉRICA CENTRAL/15/1.89
AMÉRICA DEL SUR/18/1.60
EUROPA/19/3.5
ASIA/23/4.5
ÁFRICA/25/3.1
OCEANÍA/29/3
RESTO DEL MUNDO/31/6*/
package com.mycompany.practicasprogramacionaplicada.controller;

import java.util.Scanner;

public class ejercicio2unidad2 {

    public static enum Zona {
        AMERICA_DEL_NORTE(12, 2.75),
        AMERICA_CENTRAL(15, 1.89),
        AMERICA_DEL_SUR(18, 1.60),
        EUROPA(19, 3.5),
        ASIA(23, 4.5),
        AFRICA(25, 3.1),
        OCEANIA(29, 3),
        RESTO_DEL_MUNDO(31, 6);

        private final int codigo;
        private final double tarifaPorMinutoUSD;

        Zona(int codigo, double tarifaPorMinutoUSD) {
            this.codigo = codigo;
            this.tarifaPorMinutoUSD = tarifaPorMinutoUSD;
        }
        
        public int getCodigo() {
            return codigo;
        }

        public double getTarifaPorMinutoUSD() {
            return tarifaPorMinutoUSD;
        }

        public static Zona buscarPorCodigo(int codigo) {
            for (Zona zona : Zona.values()) {
                if (zona.getCodigo() == codigo) {
                    return zona;
                }
            }
            return null;
        }
    }

    public static void calcularTarifaTotal(int codigoZona, int minutosHablados) {
        Zona zona = Zona.buscarPorCodigo(codigoZona);
        if (zona == null) {
            System.out.println("El código ingresado no corresponde a ninguna zona.");
            return;
        }

        System.out.println("Su tarifa final es: " + minutosHablados * zona.tarifaPorMinutoUSD);
    }

    public void ejecutar() {
        int codigoZona, minutosHablados; 
        Scanner valor = new Scanner(System.in);

        System.out.println("-- LISTA PARA LLAMADAS TELEFÓNICAS EXTRAJERAS --");

        for (Zona zona : Zona.values()) {
            System.out.println(zona.toString() + " " + " " + zona.codigo + " " + " " + zona.tarifaPorMinutoUSD);
        }

        String mensajeSolicitarCodigo = "Ingrese el código de la zona: ";
        System.out.println(mensajeSolicitarCodigo);
        codigoZona = valor.nextInt();

        String mensajeSolicitarMinutos = "Ingrese el tiempo hablado en minutos: ";
        System.out.println(mensajeSolicitarMinutos);
        minutosHablados = valor.nextInt();

        calcularTarifaTotal(codigoZona, minutosHablados);
    }
}

       

    

