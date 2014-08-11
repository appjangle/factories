package de.mxro.factories;

/**
 * <p>
 * Configuration to be used for instantiating an object.
 * <p>
 * Configurations should ideally not link to complex objects created during the
 * runtime of the application (such as connections to SQL drivers). Instead,
 * they should contain only simple types (such as {@link String}s and
 * {@link Map}s.).
 * <p>
 * For complex, run-time dependencies use {@link Dependencies} instead.
 * 
 * @author Max
 *
 */
public interface Configuration {

}
