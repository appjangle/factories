package de.mxro.factories;

public interface FactoryCollection 
		extends Factory<Object, Configuration,Dependencies> {

	public void register(Factory<?,?,?> f);

}
