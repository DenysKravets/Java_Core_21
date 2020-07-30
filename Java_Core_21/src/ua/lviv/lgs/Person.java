package ua.lviv.lgs;

import java.io.Serializable;

public class Person implements Serializable
{
	@MyAnnotation(value = true)
	public String name;
	@MyAnnotation(value = true)
	public int age;
	@MyAnnotation()
	public int salary;
	
	public Person(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
	
}
