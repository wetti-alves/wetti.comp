#include <iostream>
#include <stdio.h>
#include <string.h>
#include "../headers/grafo.h"


void funcionalidade7(){
  string nome_arquivo;
	cin >> nome_arquivo;

}

void funcionalidade8(){
	string nome_arquivo;
	char nomeEstacaoOrigem[80], nomeEstacaoDestino[80];
  char valorOrigem[80], valorDestino[80];

	cin >> nome_arquivo;

  scanf(" %s ", nomeEstacaoOrigem);
  scanf(" \"%[^\"]s", valorOrigem);

  fgetc(stdin); //entao captura o \n
	
	scanf(" %s ", nomeEstacaoDestino);
  scanf(" \"%[^\"]s", valorDestino);

	cout << nomeEstacaoOrigem << " - " << valorOrigem << endl;
	cout << nomeEstacaoDestino << " - " << valorDestino << endl;

}

void funcionalidade9(){
	string nome_arquivo;
	char nomeEstacaoOrigem[80], valorOrigem[80];

	cin >> nome_arquivo;

	scanf(" %s ", nomeEstacaoOrigem);
  scanf(" \"%[^\"]s", valorOrigem);
	fgetc(stdin);

	cout << nomeEstacaoOrigem << " - " << valorOrigem << endl;

}

void funcionalidade10(){
	string nome_arquivo;
	char nomeEstacaoOrigem[80], valorOrigem[80];

	cin >> nome_arquivo;

	scanf(" %s ", nomeEstacaoOrigem);
  scanf(" \"%[^\"]s", valorOrigem);
	fgetc(stdin);

	cout << nomeEstacaoOrigem << " - " << valorOrigem << endl;

}

void funcionalidade11(){
	string nome_arquivo;
	char nomeEstacaoOrigem[80], nomeEstacaoDestino[80];
  char valorOrigem[80], valorDestino[80];

	cin >> nome_arquivo;
	
  scanf(" %s ", nomeEstacaoOrigem);
  scanf(" \"%[^\"]s", valorOrigem);

  fgetc(stdin); //entao captura o \n
	
	scanf(" %s ", nomeEstacaoDestino);
  scanf(" \"%[^\"]s", valorDestino);

	cout << nomeEstacaoOrigem << " - " << valorOrigem << endl;
	cout << nomeEstacaoDestino << " - " << valorDestino << endl;
}


int main() {
  int opc;
	cin >> opc;

	switch(opc){
    case 7:
			funcionalidade7();
			break;
		case 8:
			funcionalidade8();
			break;
		case 9:
			funcionalidade9();
			break;
		case 10:
			funcionalidade10();
			break;
		case 11:
			funcionalidade11();
			break;
		default:
			break;
  }
} 