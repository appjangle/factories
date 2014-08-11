package de.mxro.factories;

import de.mxro.factories.internal.FactoryCollectionImpl;

/**
 * Entry point for factories module. Allows to create new {@link FactoryCollection}s.
 * @author Max
 *
 */
public class Factories {

	public static FactoryCollection create() {
		return new FactoryCollectionImpl();
	}

	
	
}
