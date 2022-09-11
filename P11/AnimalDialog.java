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

public class AnimalDialog extends JDialog {
	private final static int width = 300;
	private final static int height = 110;

	private JTextField names;		//name of new animal
	private JComboBox genders;		//Gender of new animal
	private JSpinner ages;			//age of new animal
	private JComboBox breeds;		//breed of new animal;
	private boolean canceled;

	AnimalDialog(Frame aFrame,Object animal,JComboBox breeds){
		
		super(aFrame, "Add pet", true); 

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		canceled = true;

		setSize(width,height);

		//setting up gridbag layout
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

		//seting up tpye
		JLabel type = new JLabel("Type");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 0;
		add(type, constraintsLabel);
/*
		if (x == 0) {
			types = new JLabel("Dog");
		}
		else {
			types = new JLabel("Cat");
		}
*/
		String classname = animal.getClass().getSimpleName();
		JLabel types = new JLabel(classname);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weighty = 1;
		add(types,constraints);

		//setting up name
		JLabel name = new JLabel("Name");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 1;
		add(name, constraintsLabel);

		names = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weighty = 1;
		add(names,constraints);

		//setting up gender
		JLabel gender = new JLabel("Gender");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 2;
		add(gender, constraintsLabel);

		genders = new JComboBox(Gender.values());
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.weighty = 0;
		add(genders, constraints);

		//setting up breed
		JLabel breed = new JLabel("Breed");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 3;
		add(breed, constraintsLabel);

		// if x - 0 it is dog else cat
		//if (x == 0) {
		//	breeds = new JComboBox(DogBreed.values());
		//}
		//else {
		//	breeds = new JComboBox(CatBreed.values());
		//}
		this.breeds = breeds;
		constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.weighty = 1;
		add(breeds,constraints);

		//add age
		JLabel age = new JLabel("Age");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 4;
		add(age, constraintsLabel);

		SpinnerModel range = new SpinnerNumberModel(0,0,100,1);
		ages = new JSpinner(range);
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.weighty = 1;
		add(ages,constraints);


		//add oko and cancel
		JPanel panel = new JPanel();

		JButton ok = new JButton("OK");
		ok.addActionListener(event -> {
			canceled = false;
			setVisible(false);
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


	public String getName() {
		return names.getText();
	}

	public int getAge() {
		int value = (Integer) ages.getValue();
		return value;
	}

	public Gender getGender() {
		Gender gen = (Gender) genders.getSelectedItem();
		return gen;
	}

	public String getBreed() {
		String bre = (String) breeds.getSelectedItem().toString();
		return bre;
	}
	public boolean isCanceled() {
		return canceled;
	}
}
