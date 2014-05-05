/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class GeneradorCongruencialMixto {

    public GeneradorCongruencialMixto(){
    }

    public ArrayList<Double> generarNumerosAleatorios(int cMultiplicativa, int cAditiva, int modulo, int semilla){
        ArrayList<Double> lista = new ArrayList<Double>();
        int a = cMultiplicativa;
        int c = cAditiva;
        int m = modulo;
        int xn = semilla;
        int i = 0;
        while(i<m){
            int aux = (a*xn+c)%m;
            double valor = (double)aux/m;
            lista.add(valor);
            //System.out.println(valor);
            xn = aux;
            i++;
        }
        return lista;
    }
}