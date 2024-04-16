/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos_Sistema;

/**
 *
 * @author Weverton n_USP: 11917326
 */
public class Fantasmas extends ElementosTela
{
    private String nome;
    
    /**
     * 
     * @param nome 
     */
    
    //Escrevendo Nome
    public void criaNome(String nome)
    {
        /**
         * @param nome
         */
        this.nome = nome;
    }
    

    public String insereNome()
    {
        /**
         * Retornando o nome
         * @return
         */
        return nome;
    }
    
    
    public int Distancia(int Pacman_x, int Pacman_y, int Fantasma_x, int Fantasma_y)
    {
        /**
     * 
     * @param Pacman_x
     * @param Pacman_y
     * @param Fantasma_x
     * @param Fantasma_y 
     * @return  
     */
        double i, j;
        
        i = Math.pow(Fantasma_x - Pacman_x,2);//Diferença da posicao ao quadrado do Fantasma e do Pacman
        j = Math.pow(Fantasma_y-Pacman_y,2);
        
        return (int) Math.sqrt(i + j);
    }
}
