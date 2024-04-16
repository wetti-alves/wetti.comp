package Engine;

/**
 *
 * @author Weverton n_USP: 11917326
 */
import java.util.Random;
import java.util.Scanner;
import Interface_Grafica.Tela;
import Elementos_Sistema.Fantasmas;
import Elementos_Sistema.Pacman;

public class Main {
    
    public static void main(String[] args) {

        Random aleat = new Random();
        int aleatorio1=0, aleatorio2=0, repeat=0;
        
        Scanner carrega = new Scanner(System.in);
        Tela tabuleiro = new Tela();
        tabuleiro.criaTabuleiro();
        tabuleiro.printaTela();

        System.out.println("Pressione uma tecla para o jogo começar:");
        carrega.next();

        
        
        Pacman p = new Pacman();
        p.setaPonto('P');
        
        int flag=0;
        
        //Gerando valores aleatorios no tabuleiro
        while(flag==0)
        {
            aleatorio1 = aleat.nextInt((28 - 1) + 1) + 1;
            aleatorio2 = aleat.nextInt((29 - 1) + 1) + 1;
            
            //Testa para sair do while
            flag = tabuleiro.checandoLocal(aleatorio1, aleatorio2);
        } 
        
        //Iniciando os elementos aleatorios no tabuleiro
        p.move(aleatorio1, aleatorio2);
        int i = p.coordenadaX();
        int j = p.coordenadaY();
        tabuleiro.iniciaElemento(i, j, p.pegaPonto());
        
        //Criando o Blink
        Fantasmas a = new Fantasmas();
        a.setaPonto('B');
        a.criaNome("Blinky");
        a.includeColor("Vermelho");
        
        flag =0;
        while(flag==0)
        {
            aleatorio1 = aleat.nextInt((30 - 1) + 1) + 1;
            aleatorio2 = aleat.nextInt((30 - 1) + 1) + 1;
            
            //Teste para sair do While
            flag = tabuleiro.checandoLocal(aleatorio1, aleatorio2);
        }
        
        //Movimentos do Blink
        a.move(aleatorio1, aleatorio2);
        tabuleiro.iniciaElemento(a.coordenadaX(),a.coordenadaY(),a.pegaPonto());
              
        //Printando
        tabuleiro.printaTela();

        //Posicao do Pacman:
        int posx_Pac_ant, posy_Pac_Ant, valor = 0, rodadas = 0;

        //Variaveis de posicao dos fantasmas:
        int posx_Fant, posy_Fant, posx_Fant_Ant, posy_Fant_Ant;

        char entrada;
                
        //Enquanto houver vidas o jogo corre:
        while (p.pegaVidas()!= 0) 
        {

            //Posição atual Pacman:
            posx_Pac_ant = p.coordenadaX();
            posy_Pac_Ant = p.coordenadaY();

            //Movendo Pac-Man
            entrada = carrega.next().charAt(0);
            
            //Trantando possibilidades de entrada do usuario
            switch (entrada) 
            {
                case 'w':
                {
                    i--;
                    break;
                }
                    
                case 's':
                {
                    i++;
                    break;
                }
                    
                case 'a':
                {
                    j--;
                    break;
                }
                    
                case 'd':
                {
                    j++;
                    break;
                }
                    
                default:
                {
                    System.out.println("Entrada invalida, favor insira uma entrada valida:");
                    break;
                }
                    
            }

            if(tabuleiro.checandoLocal(i, j)==1)
            {
                p.move(i, j);
                valor = tabuleiro.iniciaElemento(i,j, p.pegaPonto());
                p.criaDevoraBolinha(valor);
                tabuleiro.iniciaElemento(posx_Pac_ant, posy_Pac_Ant, ' ');
             } 
            else 
            {
                i = posx_Pac_ant;
                j = posy_Pac_Ant;
            }
            
            //Armazena posicao e substitui por um *.
            posx_Fant = posx_Fant_Ant = a.coordenadaX();
            posy_Fant = posy_Fant_Ant = a.coordenadaY();
            
            
            //Movimentando o fantasma
            
            boolean up, down, left, right;
            up = down = left = right = true;
            
            int Shortest_Path = a.Distancia(a.coordenadaX(), a.coordenadaY(),p.coordenadaX(), p.coordenadaY());
            
            if((tabuleiro.checandoLocal(a.coordenadaX()-1,a.coordenadaY()) == 1)) //&& (a.Distancia(a.coordenadaX()-1, a.coordenadaY(),p.coordenadaX(), p.coordenadaY()) < Shortest_Path))
            {
                //repeat=0;
                //Aqui
                if(a.Distancia(a.coordenadaX()-1, a.coordenadaY(),p.coordenadaX(), p.coordenadaY()) < Shortest_Path)
                {
                    posx_Fant = a.coordenadaX()-1;
                }
                
               // posy_Fant = a.coordenadaY();
            }
            else
            {
                up = false;
            }
            if((tabuleiro.checandoLocal(a.coordenadaX()+1, a.coordenadaY()) == 1))// && (a.Distancia(a.coordenadaX()+1, a.coordenadaY(), p.coordenadaX(), p.coordenadaY()) < Shortest_Path))
            {
                //repeat=0;
                if(a.Distancia(a.coordenadaX()+1, a.coordenadaY(), p.coordenadaX(), p.coordenadaY()) < Shortest_Path)
                {
                    posx_Fant = a.coordenadaX()+1;
                }
                //posx_Fant = a.coordenadaX()+1;
                //posy_Fant = a.coordenadaY();
            }
            else
            {
                down = false;
            }
            
            if((tabuleiro.checandoLocal(a.coordenadaX(), a.coordenadaY()-1) == 1)) //&& (a.Distancia(a.coordenadaX(), a.coordenadaY()-1, p.coordenadaX(), p.coordenadaY()) < Shortest_Path))
            {
                //repeat=0;
                if(a.Distancia(a.coordenadaX(), a.coordenadaY()-1, p.coordenadaX(), p.coordenadaY()) < Shortest_Path)
                {
                    posy_Fant = a.coordenadaY()-1;
                }
                //posx_Fant = a.coordenadaX();
                //posy_Fant = a.coordenadaY()-1;
            }
            else
            {
                left =false;
            }
            
            
            if((tabuleiro.checandoLocal(a.coordenadaX(), a.coordenadaY()+1) == 1))// && (a.Distancia(a.coordenadaX(), a.coordenadaY()+1, p.coordenadaX(), p.coordenadaY()) < Shortest_Path))
            {
                //repeat=0;
                if(a.Distancia(a.coordenadaX(), a.coordenadaY()+1, p.coordenadaX(), p.coordenadaY()) < Shortest_Path)
                {
                    posy_Fant = a.coordenadaY()+1;
                }
                //posx_Fant = a.coordenadaX();
                //posy_Fant = a.coordenadaY()+1;
            }
            else
            {
                right = false;
            }   
            
            
            if(a.coordenadaX() == posx_Fant && a.coordenadaY() == posy_Fant)
            {
                
                
                if((up) && tabuleiro.checandoLocal(a.coordenadaX()-1, a.coordenadaY()) != 'B')
                {
                    
                        repeat =0;
                        posx_Fant = a.coordenadaX()-1;
                        posy_Fant = a.coordenadaY();
                        
                       
                    
                    
                }
                              
                else if((left)&&tabuleiro.checandoLocal(a.coordenadaX(),a.coordenadaY()-1) != 'B')
                {
                   
                        posx_Fant = a.coordenadaX();
                        posy_Fant = a.coordenadaY()-1;
                        
                       
                    
                }   
                
                else if((right) && tabuleiro.checandoLocal(a.coordenadaX(), a.coordenadaY()+1) != 'B')
                {
                   
                        repeat =0;
                      posx_Fant = a.coordenadaX();
                      posy_Fant = a.coordenadaY()+1;
                      
                       
                    
                }
                    
                
                else if((down) && tabuleiro.checandoLocal(a.coordenadaX()+1, a.coordenadaY())!= 'B')
                {
                   
                        posx_Fant = a.coordenadaX()+1;
                        posy_Fant = a.coordenadaY();
                        
                    
                }  
                
         
            }
            
            a.move(posx_Fant, posy_Fant);
            tabuleiro.iniciaElemento(posx_Fant, posy_Fant, a.pegaPonto());
            
            if(p.coordenadaX() == a.coordenadaX() && p.coordenadaY() == a.coordenadaY())
            {
                p.insereVidas(0);
            }
            tabuleiro.printaTela();
        }
        System.out.println("Fim do jogo.\n Pontos: \n");
    }
    
}

