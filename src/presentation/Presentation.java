package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Presentation extends JFrame{
	JButton ajouter = new JButton("Ajouter", new ImageIcon("C:\\Users\\Ahmed\\Pictures\\ajoute.png"));
	JButton recherche = new JButton("Rechercher", new ImageIcon("C:\\Users\\Ahmed\\Pictures\\find.png"));
	JButton quitter = new JButton("Quitter",new ImageIcon("C:\\Users\\Ahmed\\Pictures\\quitter.png"));
	JPanel p = new JPanel(new GridLayout(3, 1, 10, 10));
	public Presentation() {
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("Scolarite");
		this.setLayout(new BorderLayout());
		p.add(ajouter);
		p.add(recherche);
		p.add(quitter);
		this.add(p, BorderLayout.CENTER);
		this.setSize(300, 400);
		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new AddPresentation();
				dispose();
			}
			
		});
		recherche.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new FindPresentation();
				dispose();
			}
			
		});
		quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new Presentation();
			}
			
		});
	}
	public static void main(String[] args) {
		new Presentation();
	}
}
