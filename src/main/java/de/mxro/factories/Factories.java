package de.mxro.factories;

import de.mxro.factories.internal.FactoryCollectionImpl;

/**
 * Entry point for factories module. Allows to create new
 * {@link FactoryCollection}s.
 * 
 * @author Max
 *
 */
public class Factories {

    /**
     * Creates a new collection of factories.
     * 
     * @return A new factory collection.
     */
    public static FactoryCollection create() {
        return new FactoryCollectionImpl();
    }

    public static Dependencies noDependencies() {
        return new Dependencies() {
        };
    }

}
