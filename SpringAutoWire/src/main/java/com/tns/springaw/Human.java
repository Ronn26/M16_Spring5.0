package com.tns.springaw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Human 
{
	private Heart h;
	
	//default constructor
	public Human() {
		super();
		
	}

	//DI using constructors
	public Human(Heart h) {
		super();
		this.h = h;
	}
	@Autowired
	@Qualifier("humanHeart")
	//Dependencies Injection[DI] using setters
	public void setH(Heart h) {
		this.h = h;
	}

	

	public void display()
	{
		h.print();
		System.out.println("The name of Animal is: "+h.getNameOfAnimal()+" and no. of heart is: "+h.getNoOfHeart());
	}
}