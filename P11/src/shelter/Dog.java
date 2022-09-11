package src.shelter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;



public class Dog extends Animal{
	
	private DogBreed breed;

	public Dog(){}
	public Dog(DogBreed breed,String name, Gender gender, int age){
		super(name,gender,age);
		this.breed = breed;
	}
	
	public Dog(BufferedReader br) throws IOException {
		super(br);
			this.breed = DogBreed.valueOf(br.readLine());
	}

	@Override
	public String family(){
		String classname = this.getClass().getSimpleName();
		return classname;
	}
	public void create(Object breed, String name, Gender gender, int age) {
		super.name = name;
		super.gender = gender;
		super.age = age;
		this.breed = (DogBreed) breed;

	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		Dog dog = (Dog) o;
		return (breed.equals(dog.breed) && (age == dog.age) && (gender.equals(dog.gender)) && (name.equals(dog.name)));
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(breed,age,gender,name);
	}

	@Override
	public String breed(){
		return breed.name();
	}
	@Override
	public String toString(){
		return "" + getName() + " (" + getAge() + " year old " + getGender() + " " + breed + " " + family() + ")";
	}

	@Override
	public void save(BufferedWriter bw) throws IOException {
		bw.write("" + family() + '\n');
		bw.write("" + name + '\n');
		bw.write("" + gender + '\n');
		bw.write("" + age + '\n');
		bw.write("" + breed() + '\n');
	}


}