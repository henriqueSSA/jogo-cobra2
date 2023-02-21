package br.com.henrique.modelo;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	public Main() {
		add(new Tela());
		setTitle("Jogo cobra - 2 ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public static void main(String[] args) {
		new Main();

	}

}
