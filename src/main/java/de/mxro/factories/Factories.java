package de.mxro.factories;

import de.mxro.factories.internal.FactoryCollectionImpl;

/**
 * En
 * @author Max
 *
 */
public class Factories {

	public static FactoryCollection create() {
		return new FactoryCollectionImpl();
	}

	
	
}
