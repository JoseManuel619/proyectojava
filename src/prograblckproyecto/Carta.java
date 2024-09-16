/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prograblckproyecto;

/**
 *
 * @author USUARIO
 */
public class Carta {
   private String palo;
    private String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public int getValorNumerico(boolean asAlto) {
        if (valor.equals("A")) return asAlto ? 11 : 1;
        if (valor.equals("J") || valor.equals("Q") || valor.equals("K")) return 10;
        return Integer.parseInt(valor);
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

}