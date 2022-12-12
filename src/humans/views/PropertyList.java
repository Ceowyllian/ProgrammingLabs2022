package humans.views;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PropertyList extends JPanel {

    public final CustomListModel<String> model;
    private final GridBagLayout layout = new GridBagLayout();
    private JTextField valueField;
    private JButton addButton;
    private JList<String> valueList;
    private JButton deleteButton;

    public PropertyList(CustomListModel<String> model) {
        super();
        this.model = model;
        setLayout(layout);
        createComponents();
        setEventListeners();
    }

    private void setEventListeners() {
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty() && !value.isBlank()) {
                    model.add(0, value);
                }
            }
        });
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = valueList.getSelectedIndex();
                if (index != -1) {
                    model.remove(index);
                }
            }
        });
    }

    private void createComponents() {
        valueField = new JTextField();
        var c1 = new GridBagConstraints();
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.weightx = 10;
        layout.setConstraints(valueField, c1);
        add(valueField);

        addButton = new JButton("Add");
        add(addButton);

        deleteButton = new JButton("Delete");
        var c2 = new GridBagConstraints();
        c2.gridwidth = GridBagConstraints.REMAINDER;
        layout.setConstraints(deleteButton, c2);
        add(deleteButton);

        valueList = new JList<>(model);
        valueList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(valueList);
        var c4 = new GridBagConstraints();
        c4.fill = GridBagConstraints.BOTH;
        c4.gridwidth = 3;
        c4.weighty = GridBagConstraints.PAGE_END;
        layout.setConstraints(scrollPane, c4);
        add(scrollPane);
    }
}
