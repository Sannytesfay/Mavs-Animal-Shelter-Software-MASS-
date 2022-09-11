
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
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;




import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;





public class MainWin extends JFrame{
	
	private Shelter shelter1 = new Shelter("Arlington Loves Animal Companions");
	private JTextArea displayAnimal;
	private File filename;
	enum dataview {ANIMALS,CLIENTS}

	public MainWin(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 400);

		//adding MENU
		JMenuBar menubar = new JMenuBar();

		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		JMenuItem new_shelter = new JMenuItem("New Shelter");
		JMenuItem open_shelter = new JMenuItem("Open Shelter");
		JMenuItem save_shelter = new JMenuItem("Save Shelter");
		JMenuItem save_shelterAs = new JMenuItem("Save Shelter As");

		JMenu animal = new JMenu("Animal");
		JMenuItem animal_dog = new JMenuItem("Dog");
		JMenuItem animal_cat = new JMenuItem("Cat");
		JMenuItem animal_guineapig = new JMenuItem("GuineaPig");
		JMenuItem list_animal = new JMenuItem("List Available");
		JMenuItem list_adopted = new JMenuItem("List Adopted");

		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");

		JMenu client = new JMenu("Client");
		JMenuItem new_Client = new JMenuItem("New Client");
		JMenuItem list_Client = new JMenuItem("List Clients");
		JMenuItem adopt_animal = new JMenuItem("Adopt Animal");


		quit.addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());
		animal_cat.addActionListener(event -> addCat());
		animal_dog.addActionListener(event -> addDog());
		animal_guineapig.addActionListener(event -> addGuineaPig());
		list_animal.addActionListener(event-> viewAnimals());
		list_adopted.addActionListener(event -> viewAdoptions());
		new_Client.addActionListener(event -> onAddClientClick());
		adopt_animal.addActionListener(event -> viewAdoptions());
		list_Client.addActionListener(event -> viewClients());
		save_shelter.addActionListener(event -> onSaveGameClick());
		save_shelterAs.addActionListener(event -> onSaveAsGameClick());
		new_shelter.addActionListener(event -> onNewGameClick());
		open_shelter.addActionListener(event -> onOpenGameClick());
		
		file.add(new_shelter);
		file.add(open_shelter);
		file.add(save_shelter);
		file.add(save_shelterAs);
		file.add(quit);
		animal.add(animal_dog);
		animal.add(animal_cat);
		animal.add(animal_guineapig);
		animal.add(list_animal);
		animal.add(list_adopted);
		help.add(about);
		client.add(new_Client);
		client.add(list_Client);
		client.add(adopt_animal);

		menubar.add(file);
		menubar.add(animal);
		menubar.add(client);
		menubar.add(help);
		setJMenuBar(menubar);

		//Adding ToolBar
		JToolBar toolbar = new JToolBar("Adding Animals");

		//Adding buttons to toolbar

		JButton new_shelterButton = new JButton(new ImageIcon(((new ImageIcon("image1.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		new_shelterButton.setToolTipText("Create new shelter");
		new_shelterButton.addActionListener(event -> onNewGameClick());
		toolbar.add(new_shelterButton);

		JButton open_shelterButton = new JButton(new ImageIcon(((new ImageIcon("image2.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		open_shelterButton.setToolTipText("Open shelter");
		open_shelterButton.addActionListener(event -> onOpenGameClick());
		toolbar.add(open_shelterButton);

		JButton save_shelterButton = new JButton(new ImageIcon(((new ImageIcon("image3.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		save_shelterButton.setToolTipText("Save shelter");
		save_shelterButton.addActionListener(event -> onSaveGameClick());
		toolbar.add(save_shelterButton);

		JButton save_shelterAsButton = new JButton(new ImageIcon(((new ImageIcon("image4.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		save_shelterAsButton.setToolTipText("Save shelter as");
		save_shelterAsButton.addActionListener(event -> onSaveAsGameClick());
		toolbar.add(save_shelterAsButton);

        toolbar.add(Box.createHorizontalStrut(24));

		JButton button_dog = new JButton(new ImageIcon(((new ImageIcon("dog2.jpeg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		button_dog.setToolTipText("Add a dog");
		button_dog.addActionListener(event -> addDog());
		toolbar.add(button_dog);
			
		JButton button_cat = new JButton(new ImageIcon(((new ImageIcon("cat.jpeg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		button_cat.setToolTipText("Add a cat");
		button_cat.addActionListener(event -> addCat());
		toolbar.add(button_cat);

		JButton button_guineapig = new JButton(new ImageIcon(((new ImageIcon("guineapig.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		button_guineapig.setToolTipText("Add a Guineapig");
		button_guineapig.addActionListener(event -> addGuineaPig());
		toolbar.add(button_guineapig);

		JButton button_ListAnimal = new JButton(new ImageIcon(((new ImageIcon("listanimalpic.jpeg")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		button_ListAnimal.setToolTipText("List avalable animals");
		button_ListAnimal.addActionListener(event -> viewAnimals());
		toolbar.add(button_ListAnimal);

        toolbar.add(Box.createHorizontalStrut(24));

		JButton new_ClientButton = new JButton(new ImageIcon(((new ImageIcon("newclient.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		new_ClientButton.setToolTipText("Add new client");
		new_ClientButton.addActionListener(event -> onAddClientClick());
		toolbar.add(new_ClientButton);

		JButton new_ListClient = new JButton(new ImageIcon(((new ImageIcon("listclientpic.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		new_ListClient.setToolTipText("List Clients");
		new_ListClient.addActionListener(event -> viewClients());
		toolbar.add(new_ListClient);

        toolbar.add(Box.createHorizontalStrut(24));

		JButton new_AdoptButton = new JButton(new ImageIcon(((new ImageIcon("adoptpic.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		new_AdoptButton.setToolTipText("Adopt an animal");
		new_AdoptButton.addActionListener(event -> onAdoptAnimalClick());
		toolbar.add(new_AdoptButton);

		JButton new_ListAdoptedButton = new JButton(new ImageIcon(((new ImageIcon("listadoptedpic.png")).getImage()).getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH)));
		new_ListAdoptedButton.setToolTipText("List adopted animal");
		new_ListAdoptedButton.addActionListener(event -> viewAdoptions());
		toolbar.add(new_ListAdoptedButton);




		getContentPane().add(toolbar,BorderLayout.PAGE_START);

		displayAnimal = new JTextArea(shelter1.toString());

		displayAnimal.setFont(new Font("SansSerif", Font.BOLD, 10));;
		add(displayAnimal,BorderLayout.CENTER);

	}

	protected void onQuitClick() {System.exit(0);} 

	protected void onAboutClick() {
		String s = "Welcome to the Arligntion Loves Animal Companions Shelter\n\n" + 
		"Our objective is to find a home for every single one of our little compainions\n\n" +
		" With the help of you that is possible by picking a pet to take to your lovely home";

		JOptionPane.showMessageDialog(null,s,"About us",JOptionPane.INFORMATION_MESSAGE);
	}
	private <T extends Animal> void newAnimal(T animal, JComboBox breeds) {
		AnimalDialog ad = new AnimalDialog(this,animal,breeds);
		boolean isCanceled = ad.isCanceled();

		if (!isCanceled) {
			Animal a1 = animal;
			a1.create(breeds.getSelectedItem(),ad.getName(),ad.getGender(),ad.getAge());
			this.shelter1.addAnimal(a1);
			viewAnimals();
		}
		


	}	
	public void addDog(){
		newAnimal(new Dog(), new JComboBox(DogBreed.values()));
	}
	public void addCat(){
		newAnimal(new Cat(), new JComboBox(CatBreed.values()));
	}
	public void addGuineaPig() {
		newAnimal(new GuineaPig(), new JComboBox(GuineaPigBreed.values()));
	}
	

	protected void onAddClientClick() {
		ClientDialog cd = new ClientDialog(this);
		boolean isCanceled = cd.isCanceled();

		if (!isCanceled) {
			String name = cd.getName();
			String phone = cd.getPhone();
			Client c1 = new Client(name,phone);
			shelter1.addClient(c1);
			viewClients();
		}
	}

	protected void onAdoptAnimalClick() {
		if(!shelter1.isAnimalEmpty()) {
			AdoptDialog ad = new AdoptDialog(this,shelter1);
			viewAdoptions();
		} else{
			String s = "There are no more animals left to adopt at this time";
			JOptionPane.showMessageDialog(null,s,"No More Animals To Adopt",JOptionPane.INFORMATION_MESSAGE);
		}
	}


	protected void onSaveAsGameClick() {
		final JFileChooser fc = new JFileChooser(filename);
		FileFilter shelterFiles = new FileNameExtensionFilter("Shelter Files", "sltr");
		fc.addChoosableFileFilter(shelterFiles);
		fc.setFileFilter(shelterFiles);

		int result = fc.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			filename = fc.getSelectedFile();
			if(!filename.getAbsolutePath().endsWith(".sltr")) {
				filename = new File(filename.getAbsolutePath() + ".sltr");
			}
			onSaveGameClick();
		}
	}

	protected void onSaveGameClick() {
		if(filename == null) {
			onSaveAsGameClick();
		}
		else {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
				
				shelter1.save(bw);
				

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Unalbe to open " + filename + '\n' + e,"About us",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	protected void onNewGameClick() {
		shelter1.empty();
		onSaveAsGameClick();
		viewAnimals();
	}

	protected void onOpenGameClick() {
		JFileChooser fc = new JFileChooser(filename);
		FileFilter shelterFiles = new FileNameExtensionFilter("Shelter Files", "sltr");
		fc.addChoosableFileFilter(shelterFiles);
		fc.setFileFilter(shelterFiles);

		int result = fc.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {

			filename = fc.getSelectedFile();
			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				shelter1 = new Shelter(br);
				viewAnimals();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Unalbe to open " + filename + '\n' + e,"About us",JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	void viewAnimals() {
		String s = shelter1.toString();
		displayAnimal.setText(s);
	} 

	void viewClients() {
		String s = shelter1.clientsToString();
		displayAnimal.setText(s);
	}

	void viewAdoptions() {
		String s = shelter1.adoptionsToString();
		displayAnimal.setText(s);
	}





}

