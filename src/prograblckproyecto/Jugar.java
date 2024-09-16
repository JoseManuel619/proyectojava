/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prograblckproyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Jugar {

    private ArrayList<Carta> mazo;
    private ArrayList<Carta> manoJugador;
    private ArrayList<Carta> manoCasa;
    private Random random;
    private String resultado;

    public Jugar() {
        mazo = new ArrayList<>();
        manoJugador = new ArrayList<>();
        manoCasa = new ArrayList<>();
        random = new Random();
        inicializarMazo();
    }
    // Inicializa el mazo con 52 cartas, una por cada combinación de palo y valor.

    private void inicializarMazo() {
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            for (String valor : valores) {
                mazo.add(new Carta(palo, valor));
            }
        }
    }
    // Saca una carta al azar del mazo, la elimina del mazo y la devuelve.

    private Carta sacarCartaAlAzar() {

        int indice = random.nextInt(mazo.size());
        return mazo.remove(indice);
    }
// Inicia una nueva partida, reparte 2 cartas tanto al jugador como a la casa.

    public void iniciarJuego() {
        manoJugador.clear();
        manoCasa.clear();
        manoJugador.add(sacarCartaAlAzar());
        manoCasa.add(sacarCartaAlAzar());
        manoJugador.add(sacarCartaAlAzar());
        manoCasa.add(sacarCartaAlAzar());
    }
//agregar una carta a su maso

    public void pedirCartaJugador() {
        manoJugador.add(sacarCartaAlAzar());
    }

    public void turnoCasa() {
        while (calcularPuntos(manoCasa) < 17) {
            manoCasa.add(sacarCartaAlAzar());
        }
    }

    public boolean jugadorSePaso() {
        return calcularPuntos(manoJugador) > 21;
    }
// Determina quién es el ganador al comparar los puntos del jugador y la casa.

    public void determinarGanador() {
        int puntosJugador = calcularPuntos(manoJugador);
        int puntosCasa = calcularPuntos(manoCasa);

        if (puntosJugador > 21) {
            resultado = "Te has pasado. ¡Has perdido!";
        } else if (puntosCasa > 21) {
            resultado = "La casa se ha pasado. ¡Has ganado!";
        } else if (puntosJugador > puntosCasa) {
            resultado = "¡Has ganado!";
        } else if (puntosJugador < puntosCasa) {
            resultado = "Has perdido.";
        } else {
            resultado = "Empate.";
        }
    }

    private int calcularPuntos(ArrayList<Carta> mano) {
        int puntos = 0;
        int ases = 0;

        for (Carta carta : mano) {
            if (carta.getValor().equals("A")) {
                ases++;
            } else {
                puntos += carta.getValorNumerico(true);
            }
        }
// Ajusta los valores de los Ases (1 o 11)
        for (int i = 0; i < ases; i++) {
            if (puntos + 11 <= 21) {
                puntos += 11;
            } else {
                puntos += 1;
            }
        }

        return puntos;
    }

    public ArrayList<Carta> getManoJugador() {
        return manoJugador;
    }

    public ArrayList<Carta> getManoCasa() {
        return manoCasa;
    }

    public int getPuntosJugador() {
        return calcularPuntos(manoJugador);
    }

    public int getPuntosCasa() {
        return calcularPuntos(manoCasa);
    }

    public String getResultado() {
        return resultado;
    }
}
