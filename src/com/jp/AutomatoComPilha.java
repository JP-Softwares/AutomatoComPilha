/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.jp;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Aluno
 */
public class AutomatoComPilha {

    private static Stack<Character> pilha = new Stack();
    
    private static int posicao = 0;
    
    // Cadeias: {aabc}, {aaaabcc}, {aaaaaabccc}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia = new Scanner(System.in);
        
        System.out.print("Digite a cadeia: ");
        
        String cadeia = leia.next();
        
        iniciar(cadeia);
    }
    
    public static void iniciar(String cadeia) {
        pilha.add('#');
        aImpar(cadeia);
    }
    
    public static char lerProximo(String cadeia){
        if (posicao == cadeia.length()) {
            return ' ';
        }
        
        posicao++;
        return cadeia.charAt(posicao-1);
    }
    
    public static void resultado(boolean ganhou) {
        if (ganhou) {
            System.out.println("Você ganhou!");
            return;
        }
        System.out.println("Você perdeu!");
    }
    
    public static void aImpar(String cadeia) {
        char letra = lerProximo(cadeia);
        
        switch (letra) {
            case 'a':
                aPar(cadeia);
                break;
            case 'b':
                if (pilha.size() == 1) {
                    resultado(false);
                }else {
                    b(cadeia);
                }
                break;
            case 'c':
                resultado(false);
                break;
            case ' ':
                resultado(false);
                break;
        }
    }
    
    public static void aPar(String cadeia) {
        char letra = lerProximo(cadeia);
        
        switch (letra) {
            case 'a':
                pilha.add(letra);
                aImpar(cadeia);
                break;
            case 'b':
                resultado(false);
                break;
            case 'c':
                resultado(false);
                break;
            case ' ':
                resultado(false);
                break;
        }
    }
    
    public static void b(String cadeia) {
        char letra = lerProximo(cadeia);
        
        switch (letra) {
            case 'a':
                resultado(false);
                break;
            case 'b':
                resultado(false);
                break;
            case 'c':
                if (pilha.remove(pilha.size() - 1) == '#') {
                    resultado(false);
                }else {
                    c(cadeia);
                }
                break;
            case ' ':
                resultado(false);
                break;
        }
    }
    
    public static void c(String cadeia) {
        char letra = lerProximo(cadeia);
        
        switch (letra) {
            case 'a':
                resultado(false);
                break;
            case 'b':
                resultado(false);
                break;
            case 'c':
                if (pilha.remove(pilha.size() - 1) == '#') {
                    resultado(false);
                }else {
                    c(cadeia);
                }
                break;
            case ' ':
                resultado(pilha.size() == 1);
                break;
        }
    }
    
}
