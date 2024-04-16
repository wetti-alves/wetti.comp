/*Grupo 3
Rafaela Cristina Büll - 11233651
Weverton Samuel Alves - 11917326
Gabriel Sotto Rodrigues - 11800952
Brenno Hissao Serikawa - 11296697
Renan de Almeida Leandro - 11801157
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h> //Necessario para gerar sequencia de numero aleatorios
#include <omp.h>//Necessario para usar programação paralela



int Pivoteamento(int *array,int inferior, int superior)//utilizado para definir o Pivo
{
    int i, j,k, temporario,flag;

    i = inferior+1;
    j= superior;
    k = array[inferior];
    flag =0;

    
    while(flag==0)
    {
	
         while((i < superior)&&(k>=array[i]))
        {
             i++;
        }
         while(k<array[j])
        {
            j--;
        }
        if(i<j)
        {
         	temporario = array[i];
         	array[i] = array[j];
         	array[j] = temporario;
        }
        else
    	{
        	temporario = array[inferior];
        	array[inferior] = array[j];
        	array[j] = temporario;
        	//printf("\nsaiu da funcao %d\n",j);
        	flag = 1;
        	return(j);
    	}
	}

}

void quicksort(int *array,int inferior, int superior)
{
    int pivo;
    if (inferior>= superior) return;//Final do vetor

    pivo = Pivoteamento( array, inferior, superior);

    quicksort(array,inferior, pivo - 1);
    quicksort(array,pivo + 1, superior);
}


int retorna_tam(int vet[], int tam)
{
	int i;
	for(i=0; i<tam; i++)
	{
		if(vet[i]== -1)
		{
			return i;
		}
	}
}


void inserirValor(int vetor[], int tamanho,int inicio, int valor) {
    int i;
    
    // Encontra a primeira posição vazia no vetor
    for (i = inicio; i < tamanho; i++) {
        if (vetor[i] == -1) 
		{
            vetor[i] = valor;
            break;
        }
    }
}

void zeraVetor(int vetor[], int tamanho) 
{
    int i;
    
    // Encontra a primeira posição vazia no vetor
    for (i = 0; i < tamanho; i++) 
	{
            vetor[i] = -1;
           
    }
}

void MenorquePivo(int array[], int tam, int pivo, int aux[], int n, int p)
{
	int i, j,l, fim,range; 
	l=0;
	range = (n/p);
	range = range -1; //Alinhar intervalos
				
			for(i= 0; i< n; i = i + range)//corta os particionamentos com os pivos
			{
				l = l + range;
				if((n-l)<(n/p))//Caso particionamento não seja regular
				{
					l= n-1;
					for(j = i; j <=l; j++)//roda dentro de cada particionamento
					{
						if((array[j] <= pivo)&&(array[j]!= -1))//Se o valor e menor ou igual ao pivo
						{
							inserirValor(aux, n,0, array[j]);
							array[j] = -1; //Garante que não havera repetição dos valores	
						}
					
					}
					i =n;
				}
				else
				{
					for(j = i; j <l; j++)//roda dentro de cada particionamento
					{
						if((array[j] <= pivo)&&(array[j]!= -1))//Se o valor e menor ou igual ao pivo
						{
							inserirValor(aux, n,0, array[j]);
							array[j] = -1; //Garante que não havera repetição dos valores	
						}
					
					}
					
				}
				
				
			}
				fim = retorna_tam(aux, n);
			    quicksort(aux,0, (fim-1)); //Permutando valores para cada partição
}

void MaiorquePivo(int array[], int tam, int pivo, int aux[], int n, int p)
{
	int i, j,l, range; 
	l=0;
	range = (n/p);
	range = range -1; //Alinhar intervalos
				
			for(i= 0; i< n; i = i + range)//corta os particionamentos com os pivos
			{
				l = l + range;
				if((n-l)<(n/p))
				{
					l= n-1;
					for(j = i; j <=l; j++)//roda dentro de cada particionamento
					{
						if((array[j] > pivo)&&(array[j]!= -1))//Se o valor e menor ou igual ao pivo
						{
							inserirValor(aux, n,0, array[j]);
							array[j] = -1; //Garante que não havera repetição dos valores	
						}
					
					}
					i =n;
				}
				else
				{
					for(j = i; j <l; j++)//roda dentro de cada particionamento
					{
						if((array[j] > pivo)&&(array[j]!= -1))//Se o valor e menor ou igual ao pivo
						{
							inserirValor(aux, n,0, array[j]);
							array[j] = -1; //Garante que não havera repetição dos valores	
						}
					
					}
				}
				
				
			}
			
				
			    quicksort(aux,0, (n-1)); //Permutando valores para cada partição
}

void EntrePivo(int array[], int tam, int pivo1,int pivo2, int aux[], int n, int p)
{
	int i, j,l, maior, menor, fim, range; 
	l=0;
	maior = pivo1;
	menor = pivo1;
	
	if(pivo2 > maior)
	{
		maior = pivo2;
	}
	else if(pivo2<menor)
	{
		menor = pivo2;
	}
	
	l=0;
	range = (n/p);
	range = range -1; //Alinhar intervalos
				
	for(i= 0; i< n; i = i + range)//corta os particionamentos com os pivos
	{
		l = l + range;
		if((n-l)<(n/p))
		{
			l= n;
			for(j = i; j <l; j++)//roda dentro de cada particionamento
			{
				if((array[j] > menor)&&(array[j]<=maior)&&(array[j]!= -1))//Se esta entre os pivos
				{
					inserirValor(aux, n,0, array[j]);
					array[j] = -1; //Garante que não havera repetição dos valores	
				}
										
			}
			
			i= n;
		}
		else
		{
			for(j = i; j <l; j++)//roda dentro de cada particionamento
			{
				if((array[j] > menor)&&(array[j]<=maior)&&(array[j]!= -1))//Se esta entre os pivos
				{
					inserirValor(aux, n,0, array[j]);
					array[j] = -1; //Garante que não havera repetição dos valores	
				}
										
			}
		}
	
				
	}
	
	fim = retorna_tam(aux, n);
	quicksort(aux,0, (fim-1)); //Permutando valores para cada partição
}




int psrs_sort(int *array, int n, int p)
{
	int i, j, k,l,m , inicio, fim, value, contador,  teste;
	teste =0;
	k =0;
	l=0;
	value = n/p; //em quantas partes quebraremos o array
	j=0;
	
	int aux[n]; //Vetor que sera usado para fatiar o array
	
		value = n/p; //em quantas partes quebraremos o array	
		fim = value -1;
		inicio = 0;

	//Primeira parte do algoritmo Lista original não ordenada de n elementos é dividida entre p processos
	omp_set_num_threads(p);//Seta o numero de threads que eu desejar
		
	#pragma omp parallel//Gera Zona paralela
	{
		int id = omp_get_thread_num(); //pega o valor id da Thread;
		
		#pragma omp for	
		for(i =0; i< n; i = i+ value)
		{
			
			quicksort(array,inicio, fim);
			inicio = fim+1;
			fim = fim+value;
			
			if((n-fim)< value)
			{
				fim = (n-1);
				i++;
			}
			
					
		}
		
		#pragma omp barrier //Força uma thread a esperar pela outra	
   }
   
	//Parte 2 - criar um vetor de tamanho n/p com amostras regulares de ordem p e depois ordena as amostras com o quicksort serial
	i=0;
	j= 0;
	int amostra[value];//Vetor para coletar amostra no passo 3
	
	
	zeraVetor(amostra, value);
	
	
		//Um único processo coleta essas amostras, as ordena e transmite os elementos de pivô a partir da lista ordenada de amostras para os outros processos. 
		for(i=0; i<n; i = i+ p )//Selecionar amostras
		{
		
			if(array[i]!=0)
			{
				amostra[j] = array[i];
				j++;
				
			}
			else
			{
				amostra[j] = array[i+1];
				j++;
			}
		}
	
		
		quicksort(amostra,0, (value-1));//Ordena as amostras
   
        		
		m = p;//m sera usado para selecionar o p-1 amostras
		m = m-1;
		int pivo[p-1];
		k=0;
		int range = value/m; //para as amostras constantes!
		if(range==0)//Particionamento muito pequeno para gerar divisao
		{
			range = 2;
		}
		
			
		//Selecionar p-1 pivos			  			
			for(i = (range-1); i< value ;i = i + range )//Seleciona pivo no formato p-1 especificado pelo algoritmo
			{
				if(k<m)
				{
					
					pivo[k] = amostra[i];//coleta amostra regular
				
						
					k++;
				}
				
			}	

		//Fim da Segunda parte do Algoritmo
	
	//Terceira Parte do Algoritmo Na fase 3 do algoritmo, cada processo usa os pivôs para dividir sua parte da lista em p seções.
	// Em seguida, os processos realizam uma comunicação de todos-para-todos.	
	
	l = 0;
	

	zeraVetor(aux, n);//Inicializa vetor que sera usado para permutacao de valores

//Fatia Particionamento de acordo com os p-1 pivos selecionados, os particionamentos sao realocados	
	#pragma omp parallel num_threads(p) 
	{
		#pragma omp for private(pivo)
		for(k= 0; k< (p-1); k++)//trava o pivo
		{
			if(k==0)
			{
				MenorquePivo(array, n, pivo[k], aux,  n, p);
			}		
			if(((p-1) - k)>1)//pegar valores entre 1 e outro pivo
			{
				EntrePivo(array, n, pivo[k],pivo[k+1], aux, n, p);
			
			}
			
			else
			{
				MaiorquePivo(array, n,pivo[k], aux, n, p);
			
			}
			
		}
		
		#pragma omp barrier //Força sincronismo das threads
	
	}
	

	for(i=0; i<n; i++)
	{
		array[i] = aux[i];
	}
	
}

int main(int argc, char *argv[])
{

        int n, nthreads;
    int i;
    n = atoi(argv[1]);
    nthreads = atoi(argv[2]);

    //Comentei a parte da entrada, se voce quiser checar os numeros aleatorios gerados 
    //apenas tire os comentarios

    int array[n];

    srand(time(NULL)); //Starta a semente de numero aleatorio

    for(i=0; i<n; i++)
    {
        array[i] = rand() % 100;
        //printf("%d ",array[i]);
    }

    psrs_sort(array, n, nthreads);//Função PSRS

   //imprimindo elementos ordenados
   //printf("\nElementos Ordenados:\n");

        printf("%d",array[0]);
    for(i=1; i<n; i++)
   {
        printf(", %d",array[i]);

   }
   printf(".\n");

}

