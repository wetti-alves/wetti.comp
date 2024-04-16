//grafo não direcionado ponderado
#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <list>
#include<iostream>
#include "../headers/grafo.h"

class Grafos{
	//Quantidade de vertices do Grafo
	int numeroVertices;

	//Ponteiro para a lista de adjacencia com um array
	list<int>  *adjacente;

	//Metodo Construtor
	Grafos(const std::string &nomeArquivo);

	//Insere arestas no Grafo
	void insereArestas(int vertice1, int vertice2);

	//Saber o numero de arestas que saem do vertice (numero de arcos que saem de cada vertice)

	int grauDeSaida(int vertice);

	//Saber se o vertice1 é vizinho do vertice2,3 e etc...
	bool vizinho(int vertice1, int vertice2);
};

//Metodo Construtor
Grafos::Grafos(const std::string &nomeArquivo){
	FILE *file;

	file = fopen(nomeArquivo.c_str(), "rb");
	if(file==NULL)
		printf("Falha no processamento do arquivo.\n");

	//pulando cabeçalho do arquivo
	fseek(file, 17, SEEK_SET);

	int flag =0, n =0, n1=0, n2=0, n3=0, n4=0;
	char estado, nome[100];
	int32_t Tam;//Simula o tamanho de uma linha de arquivo 
	Vertice valor;

	//le as linhas de interesse no arquivo e monta a aresta
	while(flag==0){
		//Lendo o removido se retornar EOF incrementa flag e sai fora do while
		if(fread(&estado, sizeof(char), 1, file)!=EOF){
			//Não ler a linha se o estado for 1 removido
			if(estado=='1'){
				//pula essa linha toda
				fseek(file, Tam, SEEK_CUR);
			}else{
				//Se o removido for igual a 0, leia os campos necessarios e pule os não necessarios
				fseek(file, 8, SEEK_CUR);                    
      	n = fread(&(valor.codEstacao), sizeof(char), 4, file);        
      	fseek(file, 4, SEEK_CUR);                       
      	n1= fread(&(valor.codProxEstacao), sizeof(char), 4, file);//codProxEstacao
    		n2 = fread(&(valor.distProxEstacao),sizeof(char) , 4, file);//distanciaProxEstacao
      	fseek(file, 4, SEEK_CUR);                    
      	n3 = fread(&(valor.codEstacaoIntegra), sizeof(char), 4, file);  //codEstacaoIntegra
      	n4 = fread(nome, sizeof(char), 32, file); //nome

				//Se alguma das linhas não foi lida ou chegou no fim do arquivo retornar mensagem de erro
				if((n==0)||(n1==0)||(n2==0)||(n3==0)||(n4==0)){
					printf("Falha no processamento do arquivo.");
				}else{
					int tamanhoReg = strlen(nome);//coleta o tamanho da string
					tamanhoReg = 100 - tamanhoReg;//diferença do tamanho incial para a quantidade usada	

					//Inserindo /0 no nome
					nome[tamanhoReg] = '\0';					
				}
			}
		}else{
			flag++;
		}

		
		
		//  && fread(&sizeReg, SIZE_FIELD_TAMREG, 1, fr);

	}
	
	// //Atribuindo o numero de vertices
	// this->pVertices=pVertices;

	// //Criando a lista
	// adjacente = new list<int>[pVertices];
	
}

//Adiona as arestas no grafo
void Grafos::insereArestas(int vertice1, int vertice2){
	// adjacente[vertice1].push_back[vertice2];
}


//numero de arestas que saem do vertice

int Grafos::grauDeSaida(int pVertice){
	//Retorna tamanho da lista
	return adjacente[pVertice].size();

}

bool Grafos::vizinho(int vertice1, int vertice2){
	// if(find(adjacente[vertice1].begin(),adjacente[vertice1].end(),vertice2)!= adjacente[vertice1].end());
	return true;
}
