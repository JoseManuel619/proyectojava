/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prograblckproyecto;

/**
 *
 * @author USUARIO
 */
public class Jugar {

    public Jugar(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }
    private String valor;
    private String palo;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return valor + " de " + palo;
    }

    public int obtenerValorEnPuntos() {
        switch (valor) {
            case "J":
            case "Q":
            case "K":
                return 10;
            case "A":
                return 11; 
            default:
                return Integer.parseInt(valor);
        }
    }
}