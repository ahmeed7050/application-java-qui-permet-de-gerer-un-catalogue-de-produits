package presentation;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.*;
import metier.entity.Categorie;


public class AddCategory extends JFrame implements ActionListener{
	Container container = getContentPane();
    JLabel ajouLabel = new JLabel("ajouter une catégorie:");
    JTextField ajouTextField = new JTextField();
    JButton ajouterButton = new JButton("AJOUTER");
    JButton retourButton = new JButton("RETOUR");
    
    IDaoCatalogue action = new CatalogueImp();
    
    JPanel p1 = new JPanel();
    
    public AddCategory() {
    	super("Ajouter à la liste");
		
		
		
		container.setLayout(null);
		ajouLabel.setBounds(30, 20, 200, 90);
		ajouTextField.setBounds(200, 50, 150, 30);
		ajouterButton.setBounds(100, 100, 100, 30);
		retourButton.setBounds(200, 100, 100, 30);
		
		container.add(ajouLabel);
		container.add(ajouTextField);
		
		container.add(ajouterButton);
		container.add(retourButton);
		
		
		ajouterButton.addActionListener(this);
		retourButton.addActionListener(this);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(620,530,400,200);
		setVisible(true);
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ajouterButton) {
            String txt = ajouTextField.getText();
            if (action.addCategory(new Categorie(txt))) {
                JOptionPane.showMessageDialog(this, "Ajout réussi!!");
                ajouTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Cette categorie existe déjà");
            }

        }
        if (e.getSource() == retourButton) {
        	dispose();
        }
    }
    public static void main(String[] args) {
		new AddCategory();
	}

}
