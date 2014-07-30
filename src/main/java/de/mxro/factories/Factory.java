package de.mxro.factories;

/**
 * The interface to be provided by all factories.
 * 
 * @author Max
 * 
 */
public interface Factory<ObjectType, ConfigurationType extends Configuration,DependenciesType extends Dependencies> {

	public boolean canInstantiate(Configuration conf);

	public ObjectType create(ConfigurationType conf,
			DependenciesType dependencies);

}
