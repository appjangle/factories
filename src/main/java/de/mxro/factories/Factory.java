package de.mxro.factories;

/**
 * <p>
 * A factory which can instantiate objects from a {@link Configuration} and
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
	 *            A configuration for an object to be instantiated.
	 * @return <code>true</code> when this factory can create an instance for
	 *         the provided configuration.
	 */
	public boolean canInstantiate(Configuration conf);

	/**
	 * <p>
	 * Creates a new instance based on the provided {@link Configuration}.
	 * <p>
	 * Run-time dependencies can be provided through the dependencies type for
	 * this factory.
	 * 
	 * @param conf
	 *            The configuration used to instantiate the object.
	 * @param dependencies
	 *            Run-time dependencies for this object.
	 * @return
	 */
	public ObjectType create(ConfigurationType conf,
			DependenciesType dependencies);

}
