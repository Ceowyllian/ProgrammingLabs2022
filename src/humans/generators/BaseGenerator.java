package humans.generators;

import humans.generators.random.Random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


abstract class BaseGenerator<C> {

    protected static Random random = new Random();

    public abstract C create();

    public List<C> create(int amount) {
        LinkedList<C> list = new LinkedList<C>();
        for (int i = 0; i < amount; i++) {list.add(create());}
        return list;
    }

    protected List<String> getDefault(List<String> provided, String[] defaultValues) {
        return provided == null || provided.size() == 0 ?
               Arrays.asList(defaultValues) :
               provided;
    }
}
