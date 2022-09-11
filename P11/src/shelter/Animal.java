package src.shelter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public abstract class Animal{
	protected String name;
	protected Gender gender;
	protected int age;
	public Animal(){} 
	public Animal(String name, Gender gender, int age){
		if (age < 0){
			throw new IllegalArgumentException("invalid age");
		}
		this.gender = gender;
		this.name = name;
		this.age = age;
	}

	public Animal(BufferedReader br) throws IOException {
		name = br.readLine();
		gender = Gender.valueOf(br.readLine());
		age = Integer.parseInt(br.readLine());
	}

	public String getName(){
		return name;
	}
	public String getGender(){
		return gender.name();
	}
	public int getAge(){
		return age;
	}
	public abstract String family();
	public abstract String breed();
	public abstract void create(Object breed, String name, Gender gender, int age);

	public void save(BufferedWriter bw) throws IOException {
		bw.write("" + name + '\n');
		bw.write("" + gender + '\n');
		bw.write("" + age + '\n');
	}

	@Override
	public String toString(){
		String x;
		x = name + "(" + age + " year old " + gender;
		return x;
	}

}