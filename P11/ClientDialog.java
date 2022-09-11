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

public class ClientDialog extends JDialog{
	private final static int width = 300;
	private final static int height = 110;

		private JTextField names;
		private JTextField phones;
		private boolean canceled;
	public ClientDialog(Frame aFrame) {

		super(aFrame, "Add Client", true);
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

		JLabel name = new JLabel("Name");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 0;
		add(name, constraintsLabel);

		names = new JTextField(20);
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weighty = 1;
		add(names,constraints);

		JLabel phone = new JLabel("Phone");
		constraintsLabel.gridx = 0;
		constraintsLabel.gridy = 1;
		add(phone, constraintsLabel);

		phones = new JTextField(20);
		constraintsLabel.gridx = 1;
		constraintsLabel.gridy = 1;
		add(phones, constraintsLabel);

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

	public String getPhone() {
		return phones.getText();
	}
	public boolean isCanceled() {
		return canceled;
	}
}