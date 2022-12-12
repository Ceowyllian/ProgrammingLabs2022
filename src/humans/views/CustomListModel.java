package humans.views;

import javax.swing.DefaultListModel;
import java.util.Arrays;
import java.util.List;


public class CustomListModel<E> extends DefaultListModel<E> {

    public List<String> toList() {
        String[] values = (String[]) this.toArray();
        return Arrays.asList(values);
    }
}
