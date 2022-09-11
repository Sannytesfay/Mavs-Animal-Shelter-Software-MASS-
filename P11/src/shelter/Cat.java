package src.shelter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;


public class Cat extends Animal{
	
	private CatBreed breed;
	
	public Cat(){}
	public Cat(CatBreed breed,String name, Gender gender, int age){
		super(name,gender,age);
		this.breed = breed;
	}

	public Cat(BufferedReader br) throws IOException {
		super(br);
		this.breed = CatBreed.valueOf(br.readLine());
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
		this.breed = (CatBreed) breed;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if (this.getClass() != o.getClass()) return false;
		Cat cat = (Cat) o;
		return (breed.equals(cat.breed) && (age == cat.age) && (gender.equals(cat.gender)) && (name.equals(cat.name)));
		
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
