package com.vsthost.rnd.zeitgeist;

/**
 * Provides a discrete time class without time unit semantics.
 */
public abstract class Time implements Comparable<Time> {
    /**
     * Defines the ultimate infinity which can be represented by the underlying data type.
     */
    public static final Time INFINITY = new Time() {
        @Override
        public long getCanonical() {
            return Long.MAX_VALUE;
        }

        @Override
        public Time add(long periods) {
            return Time.INFINITY;
        }

        @Override
        public int compareTo(Time o) {
            return o.equals(Time.INFINITY) ? 0 : +1;
        }
    };

    /**
     * Returns the canonical time as a numeric value.
     *
     * <p>
     *     Note that the numerical value is represented as a natural number. This
     *     does not allow to use fractional time such as half a day, half a year etc.
     *     The real semantics of what the time unit depends on the class
     *     implementing this interface. Therefore, any fractional time must be implemented
     *     by the proper subclass of this class.
     * </p>
     *
     * @return Number which represents the canonical time.
     */
    public abstract long getCanonical();

    /**
     * Adds as many periods as specified in the argument and returns a new
     * {@link Time} instance.
     *
     * <p>
     *     Note that the periods are specified in the same base unit as of the implementation.
     * </p>
     *
     * @param periods The periods to be added.
     * @return A new {@link Time} instance.
     */
    public abstract Time add (final long periods);

    @Override
    public int compareTo(final Time o) {
        // Get the values:
        final long first = this.getCanonical();
        final long second = o.getCanonical();

        // Compare and return the result:
        return first > second ? +1 : first < second ? -1 : 0;
    }

    @Override
    public boolean equals(final Object o) {
        // Are we the same objects?
        if (this == o) {
            return true;
        }

        // Are we both Time objects?
        if (o instanceof Time) {
            return this.getCanonical() == ((Time) o).getCanonical();
        }

        // So sad! Maybe in a parallel universe...
        return false;
    }
}
