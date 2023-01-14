package com.pucem.prias;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class BingoUI extends JFrame {

    private ArrayList<Integer> bolaList; 
    
    private Tablero tablero;
   
    private JLabel lblNumeroSacado;
    
    private JButton btnSacarBola;
    

    public BingoUI() {
    	getContentPane().setBackground(new Color(255, 255, 255));
        setTitle("Bingo");
        
        setSize(833, 676);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setLayout(null);

        bolaList = new ArrayList<Integer>();
        for (int i = 1; i <= 90; i++) {
        	bolaList.add(i);
        }
        Collections.shuffle(bolaList);
        
        tablero = new Tablero();
        tablero.setBackground(new Color(252, 252, 252));
        tablero.setBounds(116, 161, 556, 465);
        tablero.setSacados(bolaList);
        
        getContentPane().add(tablero);

        lblNumeroSacado = new JLabel();
        lblNumeroSacado.setBackground(new Color(128, 0, 255));
        lblNumeroSacado.setForeground(new Color(0, 0, 0));
        lblNumeroSacado.setFont(new Font("Dialog", Font.PLAIN, 45));
        lblNumeroSacado.setBounds(10, 77, 400, 118);
        getContentPane().add(lblNumeroSacado);
        

        btnSacarBola = new JButton("sortear bola");
        btnSacarBola.setForeground(new Color(0, 0, 0));
        btnSacarBola.setBackground(new Color(244, 244, 244));
        btnSacarBola.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
        btnSacarBola.setBounds(587, 32, 209, 95);
        btnSacarBola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (bolaList.size() > 0 && !tablero.tablaLlena()) {
                    int numero = bolaList.remove(0);
                    
                    lblNumeroSacado.setText(Integer.toString(numero));
                    tablero.marcarNumero(numero);
                 
                } else {
                lblNumeroSacado.setText("Juego a terminado");
                btnSacarBola.setEnabled(false);
                
                }
                }
                });
                getContentPane().add(btnSacarBola);
                

                JLabel lblNewLabel = new JLabel("Bingo 90");
                lblNewLabel.setForeground(new Color(128, 0, 255));
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 90));
                lblNewLabel.setBounds(151, -7, 400, 116);
                getContentPane().add(lblNewLabel);
               
                
                JLabel lblNewLabel_1 = new JLabel("");
                lblNewLabel_1.setBackground(new Color(255, 255, 255));
                lblNewLabel_1.setIcon(new ImageIcon(""));
                lblNewLabel_1.setBounds(20, -22, 787, 648);
                getContentPane().add(lblNewLabel_1);
                
            }


            public static void main(String[] args) {
            	BingoUI bingo = new BingoUI();
            	bingo.setVisible(true);
            	
            	}
            	}