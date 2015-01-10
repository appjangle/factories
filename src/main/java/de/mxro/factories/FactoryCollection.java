package de.mxro.factories;

/**
 * <p>
 * A collection of factories. It supports the full {@link Factory} interface but
 * instead of trying to instantiate objects from one factory, it automatically
 * forwards calls to all registered factories.
 * 
 * 
 * @author Max Rohde
 *
 */
public interface FactoryCollection extends Factory<Object, Configuration, Dependencies> {

    /**
     * <p>Registers a new factory for this collection.
     * <p>If a {@link Configuration} compatible with this factory is passed to subsequent calls of {@link FactoryCollection#create(Configuration, Dependencies), 
     *  this factory will be used to instantiate the object.
     *  <p>The collection will always use the <b>first</b> factory registered to instantate objects. 
     * 
     * @param factory The factory to be added to the collection.
     */
    public void register(Factory<?, ?, ?> factory);

    /**
     * <p>
     * Attempts to find a factory in this collection, which is capable of
     * instantiating the provided configuration.
     * <p>
     * If such a factory is found, it is replaced with the provided factory.
     * 
     * @param factory
     */
    public void replace(Configuration configuration, Factory<?, ?, ?> factory);

}
