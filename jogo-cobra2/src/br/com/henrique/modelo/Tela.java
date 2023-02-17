package br.com.henrique.modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import br.com.henrique.objetos.Cobra;
import br.com.henrique.objetos.Fruta;

public class Tela extends JPanel implements ActionListener {
	public static final int LARGURA_TELA = 1300;
	public static final int ALTURA_TELA = 750;
	public static final int TAMANHO_BLOCO = 30;
	public static final int DELAY = 200;
	public static final int UNIDADES = LARGURA_TELA * ALTURA_TELA / (TAMANHO_BLOCO * TAMANHO_BLOCO);
	public boolean statusJogo = false;
	public boolean[] key_states = new boolean[256];
	public Cobra cobra;
	public Fruta fruta;
	Timer time;
	
	
	
	public Tela() {
		setPreferredSize(new Dimension(LARGURA_TELA,ALTURA_TELA));
		setFocusable(true);
		setBackground(Color.WHITE);
		addKeyListener( new KeyboardAdapter());
		iniciarJogo();
		
	}
	
	public void iniciarJogo() {
		statusJogo = true;
		cobra = new Cobra();
		fruta = new Fruta();
		fruta.setPosicao();
		time = new Timer(DELAY,this);
		time.start();
		
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g) {
		for(int i=1;i<cobra.tamanho;i++) {
			g.setColor(Color.RED);
			g.fillOval(fruta.frutaEixoX, fruta.frutaEixoY, TAMANHO_BLOCO, TAMANHO_BLOCO);
			g.setColor(Color.GREEN);
			g.fillRect(cobra.eixoX[0], cobra.eixoY[0], TAMANHO_BLOCO, TAMANHO_BLOCO);
			g.setColor(new Color(45,180,0));
			g.fillRect(cobra.eixoX[i], cobra.eixoY[i], TAMANHO_BLOCO, TAMANHO_BLOCO);
			
		}
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(statusJogo) {
			cobra.andar();
			comida();
			limites();
			if(key_states[KeyEvent.VK_UP]) {
				if(cobra.direcao == 'B') {
					cobra.direcao = 'B';
				}else {
					cobra.direcao = 'C';
				}
				
			}else if(key_states[KeyEvent.VK_DOWN]) {
				if(cobra.direcao == 'C') {
					cobra.direcao = 'C';
				}else {
					cobra.direcao = 'B';
				}
			}else if(key_states[KeyEvent.VK_LEFT]) {
				if(cobra.direcao == 'D') {
					cobra.direcao = 'D';
				}else {
					cobra.direcao = 'E';
				}
			}else if(key_states[KeyEvent.VK_RIGHT]) {
				if(cobra.direcao == 'E') {
					cobra.direcao = 'E';
				}else {
					cobra.direcao = 'D';
				}
			}
		}
		repaint();
	}
	
	public void comida() {
		if((cobra.eixoX[0] == fruta.frutaEixoX) && (cobra.eixoY[0] == fruta.frutaEixoY)) {
			fruta.setPosicao();
		}
	}
	
	public void limites() {
		if(cobra.eixoX[0] > LARGURA_TELA || cobra.eixoY[0] > ALTURA_TELA) {
			this.statusJogo = false;
		}else if(cobra.eixoX[0] < 0 || cobra.eixoY[0] < 0){
			this.statusJogo = false;
		}else {
			this.statusJogo = true;
		}
	}
	
	private class KeyboardAdapter extends KeyAdapter{
		
		@Override
		public void keyReleased(KeyEvent e) {
			key_states[e.getKeyCode()] = false;
		}
		@Override
		public void keyPressed(KeyEvent e) {
			key_states[e.getKeyCode()] = true;
		}
	}
	
	

}
