#ifndef GRAFO_H
#define GRAFO_H

using namespace std;

typedef struct Vertice{                           
	int codEstacao;
	int codEstacaoIntegra;
	int codProxEstacao;
	int distProxEstacao;
	string linha;
	string nomeProxEstacao;
} Vertice;



#endif