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


    /**
     * Declarando vairiaveis de posicao
     */
public class ElementosTela 
{
    

	private int x, y;
	private String cores;
	private char pontos;

	
             /**
             * Setando pontos
             * @param pontos
             */
	public void setaPonto(char pontos)
	{

		this.pontos = pontos; 
	}
	
	    /**
             * pegando pontos
             * @return
             */

	public char pegaPonto()
	{

		return pontos;
	}
        
            /**
             * Setando cores
             */   


	public void includeColor(String cores)
	{

		this.cores = cores;
	}

	     /**
             * Pegando a cor
             * @return 
             */

	public String makeColor()
	{

		return cores;
	}
            /**
             * @param x
             * @param y
             * Movimentos
             */
		
	public void move(int x, int y)
	{

		this.x = x;
		this.y = y;
	}
            /**
             * Pegando Posicoes em X e Y 
             * @return
             */
	

	public int coordenadaX()
	{

		return x;
	}
        
            /**
             * Pegando Posicoes em X e Y 
             * @return
             */
	public int coordenadaY()
	{

		return y;
	}
}
