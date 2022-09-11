import src.shelter.Cat;
import src.shelter.Dog;
import src.shelter.Shelter;
import src.shelter.DogBreed;
import src.shelter.Animal;
import src.shelter.Gender;
import src.shelter.CatBreed;
import src.shelter.GuineaPig;
import src.shelter.GuineaPigBreed;
import src.shelter.Client;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ListIterator;
import java.util.Arrays;
import java.util.ArrayList;


public class AdoptDialog extends JDialog {
	private final static int width = 300;
	private final static int height = 110;

	private JComboBox client;
	private JComboBox animal;
	private boolean canceled;

	public AdoptDialog(Frame aFrame,Shelter shelter) {
		super(aFrame, "Adopt Animal", true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		canceled = true;
		setSize(width,height);

		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.weightx = 0;
		constraints.weighty = 1;
		constraints.insets = new Insets(2, 5, 2, 5);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.LINE_START; 

		GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
		constraintsLabel.weightx = 0;

		JLabel printanimal = new JLabel("Animal");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 0;
		add(printanimal, constraintsLabel);
	
		ListIterator<Animal> it = shelter.animalListIterator();
		ArrayList<Animal> aniarr  = new ArrayList<>();
		while(it.hasNext()){
			aniarr.add(it.next());
		}
		

		JComboBox comboBox = new JComboBox(aniarr.toArray());
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weighty = 1;
		add(comboBox,constraints);

		JLabel printclient = new JLabel("Client");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 1;
		add(printclient, constraintsLabel);

		ListIterator<Client> it1 = shelter.clientListIterator();
		ArrayList<Client> cliarr  = new ArrayList<>();
		while(it1.hasNext()){
			cliarr.add(it1.next());
		}

		JComboBox comboBox1 = new JComboBox(cliarr.toArray());
		constraintsLabel.gridx = 1;
		constraintsLabel.gridy = 1;
		add(comboBox1, constraintsLabel);


		JPanel panel = new JPanel();

		JButton ok = new JButton("OK");
		ok.addActionListener(event -> {
			canceled = false;
			setVisible(false);
			ListIterator<Animal> removeit = shelter.animalListIterator();
			while(removeit.hasNext()){
				if(removeit.next().equals(comboBox.getSelectedItem())) {
					removeit.remove();
				}
			}
			shelter.adopt((Animal)comboBox.getSelectedItem(),(Client)comboBox1.getSelectedItem());
		});
		panel.add(ok);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(event -> {
			canceled = true;
			setVisible(false);
		});
		panel.add(cancel);

		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		add(panel,constraints);

		pack();
		setVisible(true);	

		







	}
}