package de.mxro.factories.tests;

import junit.framework.Assert;

import org.junit.Test;

import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factories;
import de.mxro.factories.Factory;
import de.mxro.factories.FactoryCollection;

public class TestFactoryCreationAndLookup {

	private static class MyConfiguration implements Configuration {}
	
	private static class MyDependencies implements Dependencies {}
	
	private static class MyOtherConfiguration implements Configuration {}
	
	@Test
	public void test_factory_creation_and_lookup() {
		
		FactoryCollection factories = Factories.create();
		
		factories.register(new Factory<String, MyOtherConfiguration, Dependencies>() {

			@Override
			public boolean canInstantiate(Configuration conf) {
				return (conf instanceof MyOtherConfiguration);
			}

			@Override
			public String create(MyOtherConfiguration conf, Dependencies dependencies) {
				
				return "Hello, World again!";
			}
			
		});
		
		factories.register(new Factory<String, MyConfiguration, MyDependencies>() {

			@Override
			public boolean canInstantiate(Configuration conf) {
				return conf instanceof MyConfiguration;
			}

			@Override
			public String create(MyConfiguration conf, MyDependencies dependencies) {
				
				return "Hello, World!";
			}
			
		});
		
		Object created = factories.create(new MyConfiguration(), new MyDependencies());
		Assert.assertEquals("Hello, World!", created);
		
		
		Object created2 = factories.create(new MyOtherConfiguration(), new MyDependencies());
		Assert.assertEquals("Hello, World again!", created2);
		
	}
	
}
