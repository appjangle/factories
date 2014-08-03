package de.mxro.factories.internal;

import java.util.ArrayList;
import java.util.List;

import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.factories.FactoryCollection;

@SuppressWarnings("rawtypes")
public class FactoryCollectionImpl implements FactoryCollection {

	private final boolean ENABLE_LOG = false;

	private final List<Factory> factories;

	@Override
	public boolean canInstantiate(Configuration conf) {

		for (Factory factory : factories) {

			if (factory.canInstantiate(conf)) {
				return true;
			}

		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object create(Configuration conf, Dependencies dependencies) {
		for (Factory factory : factories) {

			if (factory.canInstantiate(conf)) {
				if (ENABLE_LOG) {
					System.out.println(this + ": Factory " + factory
							+ " instantiates " + conf);
				}
				return factory.create(conf, dependencies);
			}

		}

		throw new RuntimeException(
				"Cannot instantiate objects for configuration: "
						+ conf.getClass() + " " + conf);
	}

	@Override
	public void register(Factory f) {
		factories.add(f);
	}

	public FactoryCollectionImpl() {
		super();
		this.factories = new ArrayList<Factory>();
	}

}
