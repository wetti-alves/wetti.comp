/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface_Grafica;

/**
 *
 * @author Weverton n_USP: 11917326
 */
public class Tela {
  private static final String RESTART_COLLOR = "\u001B[0m";
  private static final String COLLOR_WALL = "\033[1;31m";
  private static final String COLLOR_PONTUACAO = "\033[1;34m";
        
  public char Mapa[][] = new char[30][30];

      /**
      * limpar a tela
      */

  public final static void limpaTela()
  {
         

    int i;    
    for(i=0;i<30; i++){
      System.out.println("");
    }
  }
    
 
        /**
        * Gerando os obstaculos no Mapa do Game
        */
 
  private void Obstaculo()
  {

      int i, j;
    for(i=2; i<4; i++)
    {
      
      for(j=2; j<6; j++)
      {
        Mapa[i][j] = '+';
        Mapa[i][j+20] = '+';
      }
      for(j=7; j<12; j++)
      {
        Mapa[i][j] = '+';
        Mapa[i][j+9] = '+';
      }
       
    }
    
    
                
    for( i=1; i<6; i++)
    {
      Mapa[i][13] = '+';
      Mapa[i][14] = '+';
      
      if(i==5)
      {
        for(i=5; i<6; i++)
        {
            for(j=2; j<6; j++)
            {
                Mapa[i][j] = '+';
                Mapa[i][j+20] = '+';
            }
        }
          
      }
    }
        
  
      
    for(i=7; i<18; i++)
    {
      for(j=1; j<6; j++)
      {
        Mapa[i][j] = '+';
        Mapa[i][j+21] = '+';
      }
      if(i==7)
      {
          for(i=7; i<10; i++)
      {
        Mapa[i][13] = '+';
        Mapa[i][14] = '+';
      }
      }
      
      
    }
      
            for(int k =5; k<13; k++)
            {
                for(int l=7; l<8; l++)
                {
                Mapa[k][l] = '+';
                Mapa[k][l+13] = '+';
                 }
            }
      
      
   
      
          for(int k=8; k<10; k++)
          {
            for(int l=8; l<12; l++)
            {
               Mapa[k][l] = '+';
               Mapa[k][l+8] = '+';
            }
          }
        
    
     
 
    for(i=7; i<10; i++)
    {
      Mapa[i][13] = '+';
      Mapa[i][14] = '+';
    }
    
    for(j=9; j<19; j++){
      Mapa[5][j] = '+';
      Mapa[6][j] = '+';
      Mapa[16][j] = '+';
      Mapa[17][j] = '+';
      Mapa[22][j] = '+';
      Mapa[23][j] = '+';
    }
                 
    for(i=18; i<21; i++){
      Mapa[i][13] = '+';
      Mapa[i][14] = '+';
    } 
       
    for(i=24; i<27; i++){
      Mapa[i][13] = '+';
      Mapa[i][14] = '+';
    } 
                
    for(i=14; i<18; i++){
      Mapa[i][7] = '+';
      Mapa[i][7+13] = '+';
    }

    for(i=11; i<15; i++){
      for(j=9; j<19; j++){
        if(i!=11 && i!=14 && j!=9 && j!=18){
          Mapa[i][j] = ' ';
        }else{
          Mapa[i][j] = '+';
        }   
      }
    }
    
    Mapa[11][13] = ' ';
    Mapa[11][14] = ' ';
    
    for(i=19; i<21; i++){
      for(j=2; j<6; j++){
        Mapa[i][j] = '+';
        Mapa[i][j+20] = '+';
      }
    }
        
    for(i=21; i<24; i++){
      for(j=4; j<6; j++){
        Mapa[i][j] = '+';
        Mapa[i][j+18] = '+';
      }
    }
        
    for(i=22; i<24; i++){
      for(j=1; j<3; j++){
        Mapa[i][j] = '+';
        Mapa[i][j+24] = '+';
      }
    }
        
    for(i=25; i<27; i++){
      for(j=2; j<12; j++){
        Mapa[i][j] = '+';
        Mapa[i][j+14] = '+';
      }
    }
        
    for(i=22; i<25; i++){
      Mapa[i][7] = '+';
      Mapa[i][7+13] = '+';
    }
        
    for(i=19; i<21; i++){
      for(j=7; j<12; j++){
        Mapa[i][j] = '+';
        Mapa[i][j+9] = '+';
      }
    }
  }
  

        /**
        * Escrevendo o Tabuleiro
        */
  public void criaTabuleiro()
  {

      int i,j;
    for(i=0; i < 29; i++)
    {
        for(j=0; j < 30; j++)
        {
            if(i!=0 && i!= 28 && j!=0 && j!= 29)
            {
                if(i<7 || i>15 || j<8 || j>17)
                {
                    Mapa[i][j] = '*';
                }     
                else
                {
                    Mapa[i][j] = ' ';
                }
            }
            else
            {
                Mapa[i][j] = '+';
            }
        }
    }
        
    Obstaculo();
  }
  
        /**
       * Mostrando o conteudo da Tela
       */
  
  public void printaTela()
  {

      int i, j;
    limpaTela();
    for(i=0; i < 30; i++)
    {
      for(j=0; j < 30; j++)
      {
          switch (Mapa[i][j]) 
          {
              case '+':
                  System.out.print(COLLOR_WALL + Mapa[i][j] + " ");
                  break;
              case '*':
                  System.out.print(COLLOR_PONTUACAO + Mapa[i][j] + " ");
                  break;
              default:
                  System.out.print(RESTART_COLLOR + Mapa[i][j] + " ");
                  break;
          }
      }
      System.out.println("");
    }
    System.out.println(RESTART_COLLOR);
  }
 
       /**
       * Pontuacao do pacman no momento
       */

  public void pontucao()
  {
 
    int pontos = 0,i,j;
    for(i=0; i < 29; i++)
    {
      for(j=0; j < 28; j++)
      {
        if(Mapa[i][j] == '*')
          pontos = pontos + 10;
      }
    }
    System.out.println("Pontuação: " +pontos);
  }
    
          /**
         * Checando o local do tabuleiro
         * @param i
         * @param j
         * @return
         */

    public int checandoLocal(int i, int j)
    {

        if(Mapa[i][j] != '+')
        {
            return 1;
        }
        else
        {
            return 0;
        }
        
    }
    
      /**
         * Checa o proximo caractere Caso seja *
         *  @param i
         *  @param j
         * @return
         */

    public int checandoElemento(int i, int j)
    {
      
        if(Mapa[i][j] != '*')
        {
            return 1;
        }
        else
        {
            return 0;
        }
        
    }
    
  /**
       * Iniciando os elemento
       * @param i
       * @param j
       * @param element
       * @return
       */

  public int iniciaElemento(int i, int j, char element)
  {
    
    if(Mapa[i][j]=='*')
    {
      Mapa[i][j] = element;
      return 10;
    }
    else
    {
      Mapa[i][j] = element;
      return 0;
    }
  }
}
