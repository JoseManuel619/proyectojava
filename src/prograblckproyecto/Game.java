/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package prograblckproyecto;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USUARIO
 */
public class Game extends javax.swing.JFrame {

     private Jugar juego;

    public Game() {
        initComponents();
        configurarEventos();
        nuevoJuego(); // Configura el juego al inicio
    }

    private void configurarEventos() {
        Pedircart1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pedirCarta();
            }
        });

        quedarse1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plantarse();
            }
        });

        nuevojuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nuevoJuego();
            }
        });
    }

    private void pedirCarta() {
        juego.pedirCartaJugador();
        actualizarInterfaz();
        if (juego.getPuntosJugador() > 21) {
            finalizarJuego();
        }
    }

    private void plantarse() {
        juego.turnoCasa();
        finalizarJuego();
    }

    private void nuevoJuego() {
        // Crear una nueva instancia de Jugar para reiniciar el mazo
        juego = new Jugar();
        juego.iniciarJuego();
        actualizarInterfaz();
        Pedircart1.setEnabled(true);
        quedarse1.setEnabled(true);
        labelResultado.setText("");
    }

    private void finalizarJuego() {
        Pedircart1.setEnabled(false);
        quedarse1.setEnabled(false);
        juego.determinarGanador();
        actualizarInterfaz();
    }

    private void actualizarInterfaz() {
        String manoJugador = "";
        for (Carta carta : juego.getManoJugador()) {
            manoJugador += carta + ", ";
        }
        labelJugador.setText("Jugador: " + manoJugador + "Puntos: " + juego.getPuntosJugador());

        String manoCasa = "";
        for (Carta carta : juego.getManoCasa()) {
            manoCasa += carta + ", ";
        }
        labelCasa.setText("Casa: " + manoCasa + "Puntos: " + juego.getPuntosCasa());

        labelResultado.setText(juego.getResultado());
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Pedircart1 = new javax.swing.JButton();
        quedarse1 = new javax.swing.JButton();
        nuevojuego = new javax.swing.JButton();
        labelCasa = new javax.swing.JLabel();
        labelJugador = new javax.swing.JLabel();
        labelResultado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo1.setBackground(new java.awt.Color(0, 153, 51));

        jPanel2.setBackground(new java.awt.Color(206, 163, 4));

        Pedircart1.setBackground(new java.awt.Color(211, 201, 6));
        Pedircart1.setText("Pedir");
        Pedircart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pedircart1ActionPerformed(evt);
            }
        });

        quedarse1.setBackground(new java.awt.Color(206, 196, 7));
        quedarse1.setText("quedarse");
        quedarse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quedarse1ActionPerformed(evt);
            }
        });

        nuevojuego.setBackground(new java.awt.Color(211, 188, 4));
        nuevojuego.setText("nuevo");
        nuevojuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevojuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevojuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quedarse1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(Pedircart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Pedircart1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(quedarse1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(nuevojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        labelCasa.setText("jLabel1");

        labelJugador.setText("jLabel2");

        labelResultado.setText("jLabel3");

        javax.swing.GroupLayout fondo1Layout = new javax.swing.GroupLayout(fondo1);
        fondo1.setLayout(fondo1Layout);
        fondo1Layout.setHorizontalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondo1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJugador)
                    .addComponent(labelCasa)
                    .addComponent(labelResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fondo1Layout.setVerticalGroup(
            fondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(fondo1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(labelCasa)
                .addGap(47, 47, 47)
                .addComponent(labelJugador)
                .addGap(61, 61, 61)
                .addComponent(labelResultado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void nuevojuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevojuegoActionPerformed
        // TODO add your handling code here:
          nuevoJuego();
    }//GEN-LAST:event_nuevojuegoActionPerformed

    private void Pedircart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pedircart1ActionPerformed
        // TODO add your handling code here:
        pedirCarta();
    }//GEN-LAST:event_Pedircart1ActionPerformed

    private void quedarse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quedarse1ActionPerformed
        // TODO add your handling code here:
        plantarse();
    }//GEN-LAST:event_quedarse1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pedircart1;
    private javax.swing.JPanel fondo1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCasa;
    private javax.swing.JLabel labelJugador;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JButton nuevojuego;
    private javax.swing.JButton quedarse1;
    // End of variables declaration//GEN-END:variables

   }
