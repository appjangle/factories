package de.mxro.factories;

/**
 * <p>
 * A factory which can instantate objects from a {@link Configuration} and
 * run-time {@link Dependencies}.
 * 
 * 
 * @author Max
 * 
 */
public interface Factory<ObjectType, ConfigurationType extends Configuration, DependenciesType extends Dependencies> {

	/**
	 * <p>
	 * This method tests whether the supplied {@link Configuration} can be
	 * instantiated into an object by this factory.
	 * 
	 * @param conf
	 *            A configuration for an object to be instantated.
	 * @return <code>true</code> when this factory can create an instance for
	 *         the provided configuration.
	 */
	public boolean canInstantiate(Configuration conf);

	public ObjectType create(ConfigurationType conf,
			DependenciesType dependencies);

}
