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
public class Pacman extends ElementosTela
{
    protected int devoraBolinha;
    protected int vidas;
    
    /**
     * Funcao que inicia o Pac Man
     */
    public Pacman()
    {
        devoraBolinha = 0;
        vidas = 3;
    }
    
    /**
     * Elimina a bolinha do caminho
     * @return 
     */
    public int pegaBolinha()
    {
     
        return devoraBolinha;
    }
    
    /**
     * retorna a quantidade de vidas
     * @return 
     */
    public int pegaVidas(){
        return vidas;
    }
    
    /**
     * retorna o valor atual da vida
     * @param pontoVida 
     */
    public void insereVidas(int pontoVida)
    {
 
        vidas = pontoVida;
    }    

    /**
     * atualiza a quantidade de bolinhas adquiridas
     * @param devoraBolinha 
     */
    public void criaDevoraBolinha(int eatenBalls)
    {
        this.devoraBolinha += devoraBolinha;
    }
}
