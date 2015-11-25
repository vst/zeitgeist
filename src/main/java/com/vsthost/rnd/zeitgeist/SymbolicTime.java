package com.vsthost.rnd.zeitgeist;

/**
 * Provides a discrete, symbolic time class which can be represented as <i>Time<sub>t</sub></i>.
 */
public class SymbolicTime extends Time {
    /**
     * Defines the internal discrete value.
     */
    private final long value;

    /**
     * Provides a default constructor.
     *
     * @param value The discrete, symbolic time value.
     */
    private SymbolicTime(final long value) {
        this.value = value;
    }

    @Override
    public long getCanonical() {
        return this.value;
    }

    @Override
    public Time add(final long periods) {
        return new SymbolicTime(this.value + periods);
    }

    /**
     * Constructs and returns a discrete, symbolic time from the given double value.
     *
     * @param value The long value representing the fractional time.
     * @return The {@link SymbolicTime} instance.
     */
    public static SymbolicTime of (final long value) {
        return new SymbolicTime(value);
    }
}
