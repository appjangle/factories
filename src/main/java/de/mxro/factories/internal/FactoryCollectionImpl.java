package de.mxro.factories.internal;

import java.util.ArrayList;
import java.util.List;

import de.mxro.factories.Configuration;
import de.mxro.factories.Dependencies;
import de.mxro.factories.Factory;
import de.mxro.factories.FactoryCollection;

/**
 * <a>A simple implementation of the {@link FactoryCollection} interface. Note
 * that this implementation is not thread-safe.
 * 
 * @author Max
 *
 */
@SuppressWarnings("rawtypes")
public class FactoryCollectionImpl implements FactoryCollection {

    private final boolean ENABLE_LOG = false;

    private final List<Factory> factories;

    @Override
    public boolean canInstantiate(final Configuration conf) {

        for (final Factory factory : factories) {

            if (factory.canInstantiate(conf)) {
                return true;
            }

        }

        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object create(final Configuration conf, final Dependencies dependencies) {
        for (final Factory factory : factories) {

            if (factory.canInstantiate(conf)) {
                if (ENABLE_LOG) {
                    System.out.println(this + ": Factory " + factory + " instantiates " + conf);
                }
                return factory.create(conf, dependencies);
            }

        }

        throw new RuntimeException("Cannot instantiate objects for configuration: " + conf.getClass() + " " + conf);
    }

    @Override
    public void register(final Factory f) {
        factories.add(f);
    }

    @Override
    public void replace(final Configuration configuration, final Factory<?, ?, ?> replacement) {
        int idx = -1;
        boolean found = false;
        for (final Factory factory : factories) {
            idx++;
            if (factory.canInstantiate(configuration)) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("Cannot find factory to instantiate " + configuration);
        }

        factories.set(idx, replacement);

    }

    public FactoryCollectionImpl() {
        super();
        this.factories = new ArrayList<Factory>();
    }

}
