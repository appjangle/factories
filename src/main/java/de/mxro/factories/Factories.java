package de.mxro.factories;

import de.mxro.factories.internal.FactoryCollectionImpl;

public class Factories {

	public static FactoryCollection create() {
		return new FactoryCollectionImpl();
	}

	
	
}
