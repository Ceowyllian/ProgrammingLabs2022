package humans.random;

import java.util.List;

public class Random {
    public double getDouble(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }

    public int getInt(int min, int max) {
        return (int) getDouble(min, max);
    }

    public boolean getBool() {
        return getInt(0, 1) == 0;
    }

    public <T> T choose(T[] values) {
        return values[getInt(0, values.length - 1)];
    }

    public <T> T choose(List<T> values) {
        return values.get(getInt(0, values.size() - 1));
    }

}
