package de.mxro.factories;

/**
 * A factory which can instantate objects from a {@link Configuration} and run-time {@link Dependencies}.
 * 
 * @author Max
 * 
 */
public interface Factory<ObjectType, ConfigurationType extends Configuration,DependenciesType extends Dependencies> {

	public boolean canInstantiate(Configuration conf);

	public ObjectType create(ConfigurationType conf,
			DependenciesType dependencies);

}
