/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Controlador;
import java.util.ArrayList;

/**
 *  
 * @author Jose
 */
public class Modelo {
    
    private static final GeneradorCongruencialMixto GCM = new GeneradorCongruencialMixto(366,7,365,4);
    private static final GeneradorVariableTriangular GVT = new GeneradorVariableTriangular(43,65,87);
    private static final int[] CA = {77,7,3};
    private static final double[] PA = {63,73,83};
    private static final double[] PI = {78,93,108};
    private static final double[] PH = {0.56,0.15,0.29};
    private static final double[] AI = {0.18,0.22,0.24};
    
    GeneradorCongruencialMixto gcm;
    GeneradorVariableTriangular gvt;
    int[] cantidadHabitaciones;
    double[] precioActual;
    double[] precioIncrementado;
    double[] preferenciaHabitaciones;
    double[] aceptacionIncremento;
    Controlador c;
    
    public Modelo(Controlador c) {
        gcm = GCM;
        gvt = GVT;
        cantidadHabitaciones = CA;
        precioActual = PA;
        precioIncrementado = PI;
        preferenciaHabitaciones = PH;
        aceptacionIncremento = AI;
        this.c = c;
    }
    
    private ArrayList generarTablaVariacionPrecios(){
        
        ArrayList<ArrayList> lista;
        lista = new ArrayList<>();
        int n = gcm.getM();
        int indiceGenerador = 0;
        for(int i=0;i<=12;i++){
            
            int acumSimpleAct = 0;
            int acumDobleAct = 0;
            int acumSuiteAct = 0;
            int acumSimpleInc = 0;
            int acumDobleInc = 0;
            int acumSuiteInc = 0;
            ArrayList tupla = new ArrayList();
            
            int j = 0;
            int diasDelMes = diasDelMes(i,2014);
            while(j<diasDelMes && indiceGenerador<n){
                int demandaDia = gvt.generarValor(gcm.getListaNumerosAleatorios().get(indiceGenerador));
                int demandaSimpleDia = demandaDia*(int)this.preferenciaHabitaciones[0];
                int demandaDobleDia = demandaDia*(int)this.preferenciaHabitaciones[1];
                int demandaSuiteDia = demandaDia*(int)this.preferenciaHabitaciones[2];
                acumSimpleAct = acumSimpleAct + demandaSimpleDia;
                acumDobleAct = acumDobleAct + demandaDobleDia;
                acumSuiteAct = acumSuiteAct + demandaSuiteDia;
                acumSimpleInc = acumSimpleInc + demandaSimpleDia*(int)this.aceptacionIncremento[0];
                acumDobleInc = acumDobleInc + demandaDobleDia*(int)this.aceptacionIncremento[1];
                acumSuiteInc = acumSuiteInc + demandaSuiteDia*(int)this.aceptacionIncremento[2];
                j++;
                indiceGenerador++;
            }
            
            tupla.add(i+1);
            tupla.add(acumSimpleAct);
            tupla.add(acumDobleAct);
            tupla.add(acumSuiteAct);
            tupla.add(acumSimpleAct*this.precioActual[0]);
            tupla.add(acumDobleAct*this.precioActual[1]);
            tupla.add(acumSuiteAct*this.precioActual[2]);
            tupla.add((double)tupla.get(4)+(double)tupla.get(5)+(double)tupla.get(6));
            tupla.add(acumSimpleInc);
            tupla.add(acumDobleInc);
            tupla.add(acumSuiteInc);
            tupla.add(acumSimpleInc*this.precioIncrementado[0]);
            tupla.add(acumDobleInc*this.precioIncrementado[1]);
            tupla.add(acumSuiteInc*this.precioIncrementado[2]);
            tupla.add((double)tupla.get(11)+(double)tupla.get(12)+(double)tupla.get(13));
            
            lista.add(tupla);
            
        }
        return lista;
    }

    public int[] getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public double[] getPrecioActual() {
        return precioActual;
    }

    public double[] getPrecioIncrementado() {
        return precioIncrementado;
    }

    public double[] getPreferenciaHabitaciones() {
        return preferenciaHabitaciones;
    }

    public double[] getAceptacionIncremento() {
        return aceptacionIncremento;
    }
    
    public GeneradorCongruencialMixto getGeneradorCongruencialMixto() {
        return gcm;
    }
    
    public GeneradorVariableTriangular getGeneradorVariableTriangular() {
        return gvt;
    }

    public void setCantidadHabitaciones(int simple, int doble, int suitejr) {
        cantidadHabitaciones[0] = simple;
        cantidadHabitaciones[1] = doble;
        cantidadHabitaciones[2] = suitejr;
    }

    public void setPrecioActual(double simple, double doble, double suitejr) {
        precioActual[0] = simple;
        precioActual[1] = doble;
        precioActual[2] = suitejr;
    }

    public void setPrecioIncrementado(double simple, double doble, double suitejr) {
        precioIncrementado[0] = simple;
        precioIncrementado[1] = doble;
        precioIncrementado[2] = suitejr;
    }

    public void setPreferenciaHabitaciones(double simple, double doble, double suitejr) {
        preferenciaHabitaciones[0] = simple;
        preferenciaHabitaciones[1] = doble;
        preferenciaHabitaciones[2] = suitejr;
    }

    public void setAceptacionIncremento(double simple, double doble, double suitejr) {
        aceptacionIncremento[0] = simple;
        aceptacionIncremento[1] = doble;
        aceptacionIncremento[2] = suitejr;
    }
    
    public void setGeneradorCongruencialMixto(int cMultiplicativa, int cAditiva, int modulo, int semilla) {
        gcm.asignarValores(cMultiplicativa, cAditiva, modulo, semilla);
    }
    
    public void setGeneradorVariableTriangular(int a, int b, int c){
        gvt.asignarValores(a, b, c);
    }
    
    public static int diasDelMes(int mes, int año){
        switch(mes){
            case 0:  // Enero
            case 2:  // Marzo
            case 4:  // Mayo
            case 6:  // Julio
            case 7:  // Agosto
            case 9:  // Octubre
            case 11: // Diciembre
                return 31;
            case 3:  // Abril
            case 5:  // Junio
            case 8:  // Septiembre
            case 10: // Noviembre
                return 30;
            case 1:  // Febrero
                if ( ((año%100 == 0) && (año%400 == 0)) ||
                        ((año%100 != 0) && (año%  4 == 0))   )
                    return 29;  // Año Bisiesto
                else
                    return 28;
            default:
                throw new java.lang.IllegalArgumentException(
                "El mes debe estar entre 0 y 11");
        }
}
}
