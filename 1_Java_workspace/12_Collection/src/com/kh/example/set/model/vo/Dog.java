package com.kh.example.set.model.vo;

import java.util.Objects;

public class Dog {
	private String name;
	private double weight;
	
	public Dog() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Dog(String name, double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", weight=" + weight + "]";
				
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, Double.valueOf(weight));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

}
