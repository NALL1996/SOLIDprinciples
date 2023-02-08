package com.sivasoft;

/**
 * Clients should not be forced to depend upon interfaces that they do not use
 * Reduce the side effects of using larger interfaces by breaking application
 * interfaces into smaller ones It's pretty much similar to single
 * responsibility priciple. It might takes time in the design phase, but much
 * efficient in implementation phase
 */
public class InterfaceSegregationPrinciple {
	public static void main(String[] args) {
		new CoffeeMachineImpl().prepareCoffee();
		new TeaMachineImpl().prepareTea();
		new TeaCoffeeMachine().prepareTea();
	}
}

interface ITeaMachine {
	void prepareTea();
}

interface ICoffeeMachine {
	void prepareCoffee();
}

class CoffeeMachineImpl implements ICoffeeMachine {

	@Override
	public void prepareCoffee() {
		System.out.println("Preparing coffee");
	}
}

class TeaMachineImpl implements ITeaMachine {

	@Override
	public void prepareTea() {
		System.out.println("Preparing Tea");
	}
}

class TeaCoffeeMachine implements ICoffeeMachine, ITeaMachine {
	@Override
	public void prepareTea() {
		System.out.println("Preparing Tea");
	}

	@Override
	public void prepareCoffee() {
		System.out.println("Preparing coffee");
	}
}
