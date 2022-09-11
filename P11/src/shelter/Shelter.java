package src.shelter;

import java.io.BufferedWriter;
import java.io.IOException;

import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ListIterator;
import java.util.Set;
import java.util.Iterator;

public class Shelter{
	private String name;
	private ArrayList<Animal> animals = new ArrayList<>();
	private ArrayList<Client> clients = new ArrayList<>();
	private HashMap<Animal,Client> adoptions = new HashMap<>();


	String newLine = System.getProperty("line.separator");


	public Shelter(String name){
		this.name = name;
	}
	
	public Shelter(BufferedReader br) throws IOException {
		br.readLine();
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			String animalType = br.readLine();
			String name = br.readLine();
			Gender gen = Gender.valueOf(br.readLine());
			int age = Integer.parseInt(br.readLine());
			
			if (animalType.equals("Cat")) {
				CatBreed breed = CatBreed.valueOf(br.readLine());
				Cat c1 = new Cat(breed,name,gen,age);
				animals.add(c1);

			}
			else if(animalType.equals("Dog")){
				DogBreed breed = DogBreed.valueOf(br.readLine());
				Dog d1 = new Dog(breed,name,gen,age);
				animals.add(d1);
			}
			else if(animalType.equals("GuineaPig")) {
				GuineaPigBreed breed = GuineaPigBreed.valueOf(br.readLine());
				GuineaPig d1 = new GuineaPig(breed,name,gen,age);
				animals.add(d1);
			}
		}
		String bufferString;
		if ((bufferString = br.readLine()) != null) {
			size = Integer.parseInt(bufferString);
			for (int i = 0; i < size; i++) {
				String clientName = br.readLine();
				String clientPhone = br.readLine();
				Client client1 = new Client(clientName,clientPhone);
				clients.add(client1);
			}

			if ((bufferString = br.readLine()) != null) {
				size = Integer.parseInt(bufferString);
				for (int i = 0; i < size; i++) {
					String animalType = br.readLine();
					String name = br.readLine();
					Gender gen = Gender.valueOf(br.readLine());
					int age = Integer.parseInt(br.readLine());
					
					if (animalType.equals("Cat")) {
						CatBreed breed = CatBreed.valueOf(br.readLine());
						Cat c1 = new Cat(breed,name,gen,age);
						String clientName = br.readLine();
						String clientPhone = br.readLine();
						Client client1 = new Client(clientName,clientPhone);
						this.adopt(c1,client1);


					}
					else if(animalType.equals("Dog")){
						DogBreed breed = DogBreed.valueOf(br.readLine());
						Dog d1 = new Dog(breed,name,gen,age);
						String clientName = br.readLine();
						String clientPhone = br.readLine();
						Client client1 = new Client(clientName,clientPhone);
						this.adopt(d1,client1);

					}
					else if(animalType.equals("GuineaPig")) {
						GuineaPigBreed breed = GuineaPigBreed.valueOf(br.readLine());
						GuineaPig gp1 = new GuineaPig(breed,name,gen,age);
						String clientName = br.readLine();
						String clientPhone = br.readLine();
						Client client1 = new Client(clientName,clientPhone);
						this.adopt(gp1,client1);
					} 
				}
			}
		}

	}
	public void adopt(Animal animal, Client client){
		adoptions.put(animal,client);
		animals.remove(animal);
	}

	public void save(BufferedWriter bw) throws IOException {
			bw.write("" + "Mav's Animal Shelter" + '\n');
			bw.write("" + numAnimals() + '\n');

		for (Animal a : animals) {
			a.save(bw);
		}
		bw.write("" + numClients() + "\n");
		for (Client a : clients) {
			a.save(bw);
		}
		bw.write("" + numAdoptions() + "\n");
		Iterator<Animal> adopt = adoptionListIterator();
		while(adopt.hasNext()) {
			Animal key = adopt.next();
			Client value = adoptions.get(key);
			key.save(bw);
			value.save(bw);
		}

	}
	public void empty() {
		animals.clear();
		clients.clear();
	}

	public void addAnimal(Animal animal){
		animals.add(animal);
	}
	public void addClient(Client client) {
		clients.add(client);
	}
	public String clientsToString() {
		String result = "";
		ListIterator<Client> client = this.clientListIterator();
		while(client.hasNext()){
			result += client.next() + newLine;
		}
		return result;
	}
	@Override
	public String toString(){
		String result = "";

		ListIterator<Animal> animal = this.animalListIterator();
		while(animal.hasNext()){
			result += animal.next() + newLine;
		}
		return result;
	}
	
	public String adoptionsToString() {
		String result = "";
		Iterator<Animal> adopt = adoptionListIterator();
		while(adopt.hasNext()) {
			Animal key = adopt.next();
			Client value = adoptions.get(key);
			result += key + " to " + value + newLine;
			//String s = key.getClass().getName();
			//System.out.println(s);
		}
		return result;
	}

	public ListIterator<Animal> animalListIterator() {return animals.listIterator();}
	public ListIterator<Client> clientListIterator() {return clients.listIterator();}
	public Iterator<Animal> adoptionListIterator() {
		Iterator<Animal> itr = adoptions.keySet().iterator();
		return itr;
	}
	
	public boolean isAnimalEmpty() {
		return animals.isEmpty();
	}


	public int numAnimals(){
		return animals.size();
	}
	public int numClients() {
		return clients.size();
	}
	public Animal getAnimal(int index){
		return animals.get(index);
	}
	public int numAdoptions() {
		return adoptions.size();
	}
}