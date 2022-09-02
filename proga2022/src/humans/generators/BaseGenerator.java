package humans.generators;

import java.util.List;

import humans.random.Random;

abstract class BaseGenerator<C> {

    protected static Random random = new Random();

    public abstract C create();

    public abstract List<C> create(int amount);

}
