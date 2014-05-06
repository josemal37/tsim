/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Controlador;

/**
 *  
 * @author Jose
 */
public class Modelo {
    
    GeneradorCongruencialMixto gcm;
    GeneradorVariableTriangular gvt;
    int[] cantidadHabitaciones;
    double[] precioActual;
    double[] precioIncrementado;
    double[] preferenciaHabitaciones;
    double[] aceptacionIncremento;
    Controlador c;
    
    public Modelo(Controlador c) {
        gcm = new GeneradorCongruencialMixto();
        gvt = new GeneradorVariableTriangular();
        cantidadHabitaciones = new int[3];
        precioActual = new double[3];
        precioIncrementado = new double[3];
        preferenciaHabitaciones = new double[3];
        aceptacionIncremento = new double[3];
        this.c = c;
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
}
