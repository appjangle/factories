package de.mxro.factories;

/**
 * <p>A collection of factories. It supports the full {@link Factory} interface but
 * instead of trying to instantiate objects from one factory, it automatically
 * forwards calls to all registered factories.
 * 
 * 
 * @author Max
 *
 */
public interface FactoryCollection extends
		Factory<Object, Configuration, Dependencies> {

	public void register(Factory<?, ?, ?> f);

}
