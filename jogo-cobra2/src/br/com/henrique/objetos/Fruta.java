package br.com.henrique.objetos;

import java.util.Random;

import br.com.henrique.modelo.Tela;

public class Fruta {
	public int frutaEixoX;
	public int frutaEixoY;
	
	
	public void setPosicao() {
		this.frutaEixoX = new Random().nextInt(Tela.LARGURA_TELA / Tela.TAMANHO_BLOCO) * Tela.TAMANHO_BLOCO;
		this.frutaEixoY = new Random().nextInt(Tela.ALTURA_TELA / Tela.TAMANHO_BLOCO) * Tela.TAMANHO_BLOCO;
		
	}

}
