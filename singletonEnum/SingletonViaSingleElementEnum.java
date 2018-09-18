package singletons.singletonEnum;

/**
 * This class is implemented a singleton. This approach is based on implementation of a singleton as
 * a declaration a single-element enum. This approach is similar to the public field approach.
 * <p>
 * Advantages:
 * <ul>
 * <li> This approach is more concise.</li>
 * <li> It provides the serialization safety itself.</li>
 * <li> It provides a guarantee against multiple instantiation.</li>
 * </ul>
 * <p>
 * Issue: this approach is not been used if this singleton class must extend a superclass other
 * than Enum (though it can be declared an enum to implement interfaces).
 * <p>
 * This approach is described in Joshua Bloch's book "Effective Java" (p.18).
 */
public enum SingletonViaSingleElementEnum {
    INSTANCE
}
