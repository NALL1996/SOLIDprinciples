package com.sivasoft;

/**
 * The principle defines that objects of a superclass shall be replaceable with
 * objects of its subclasses without breaking the application Functions that use
 * references to base classes must be able to use objects of the derived class
 * without knowing it [Class A extends Class B] = [Class B extends Class A]
 * Objects of your subclasses to behave in the same way as the objects of your
 * superclass An overridden method of a subclass needs to accept the same input
 * parameter values as the method of the superclass.
 */
public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		Machine coffee = new CoffeeMachine();
		coffee.prepareDrink();
		Machine tea = new TeaMachine();
		tea.addMilk();
		tea.prepareDrink();
		Machine milkShake = new MilkShake();
		milkShake.addMilk();
		milkShake.prepareDrink();
	}
}

abstract class Machine {
	public abstract void prepareDrink();

	public void addMilk() {
		System.out.println("Milk Added");
	}
}

class CoffeeMachine extends Machine {
	@Override
	public void prepareDrink() {
		System.out.println("Coffee has been prepared");
	}
}

class TeaMachine extends Machine {

	@Override
	public void prepareDrink() {
		System.out.println("Tea has been prepared");
	}

	@Override
	public void addMilk() {
		System.out.println("Milk Added in Tea");
	}
}

class MilkShake extends Machine {

	@Override
	public void addMilk() {
		System.out.println("Milk Added in Milk Shake");
	}

	@Override
	public void prepareDrink() {
		System.out.println("Milk Shake has been prepared");
	}

}
