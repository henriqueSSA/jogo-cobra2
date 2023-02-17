package br.com.henrique.objetos;

import br.com.henrique.modelo.Tela;

public class Cobra {
	public int eixoX[] = new int[Tela.UNIDADES];
	public int eixoY[] = new int[Tela.UNIDADES];
	public int tamanho = 2;
	public char direcao = 'D';
	
	
	
	public Cobra() {
		this.eixoX[0] = 60;
		this.eixoY[0] = 60;
		
	}
	
	public void andar() {
		for(int i= this.tamanho;i>0;i--) {
			this.eixoX[i] = this.eixoX[i-1];
			this.eixoY[i] = this.eixoY[i-1];
		}
		
		switch(direcao) {
		
		case 'E':
			this.eixoX[0] = this.eixoX[0] - Tela.TAMANHO_BLOCO;
			break;
		case 'D':
			this.eixoX[0] = this.eixoX[0] + Tela.TAMANHO_BLOCO;
			break;
		case 'C':
			this.eixoY[0] = this.eixoY[0] - Tela.TAMANHO_BLOCO;
			break;
		case 'B':
			this.eixoY[0] = this.eixoY[0] + Tela.TAMANHO_BLOCO;
		default:
			break;
		
		}
	}

}
