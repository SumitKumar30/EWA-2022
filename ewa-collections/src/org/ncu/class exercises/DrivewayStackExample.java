package StackPrograms;

import java.util.Scanner;
import java.util.Stack;

public class DrivewayStackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner (System.in);
		Stack <Integer> driveway = new Stack <Integer>();
		Stack <Integer> street = new Stack <Integer>();
		int carOwn= 2994;//the owner's car
		System.out.println("Enter the license plate of each car in the driveway: ");
		while(driveway.size()<5)//how many cars are in the driveway right now; 
		{
			driveway.push(in.nextInt()); //"push the cars into the driveway"
		}
		System.out.println("\n");
		System.out.println("The driveway and street before moving cars into the street");
		System.out.println("Driveway: " + driveway);
		System.out.println("Street: " + street);
		System.out.println(driveway.size());
 
		while(!driveway.empty())//if the first integer of the stack is a negative, pop/remove and push it into the street
		{
			if(driveway.peek()<0)
			{
				int top = driveway.pop();
				street.push(-top); //changes the negative license plate numbers of cars moving 
									//out of the driveway to positive numbers once they are "pushed into the street"
			}	
		}
		System.out.println("\n");
		System.out.println("The driveway and street after moving cars into the street");
		System.out.println("Driveway: " + driveway);
		System.out.println("Street: " + street);
 
 
		while(!driveway.empty())//while the streets is still occupied
		{
			if(street.peek()!=carOwn)
			{
				int head = street.pop();
				driveway.push(head); //takes the cars in the street and pushes them back into the driveway
			}
		}
		System.out.println("\n");
		System.out.println("The driveway and street after moving cars back into the driveway ");
		System.out.println("Driveway: " + driveway);
		System.out.println("Street: " +street);
	}

}
