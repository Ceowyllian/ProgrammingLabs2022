package humans.views;

import humans.Writer;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import static javax.swing.JOptionPane.showMessageDialog;


public class MainForm extends JFrame {

    private final ViewModel model;
    private final Writer writer;
    private final JFileChooser directoryChooser = new JFileChooser();
    private JPanel mainPanel;
    private JPanel outputConfigPanel;
    private JTextField outputPathField;
    private JCheckBox useIndentsCheckBox;
    private JSlider amountSlider;
    private JButton generateButton;
    private JTabbedPane generatorConfigPanel;
    private JTabbedPane humanPanel;
    private JPanel humanTab;
    private JPanel otherHumanPropertiesTab;
    private JTabbedPane addressPanel;
    private JPanel addressTab;
    private JPanel otherAddressPropertiesPanel;
    private JSpinner minHouseNumber;
    private JSpinner maxHouseNumber;
    private JSpinner minAge;
    private JSpinner maxAge;
    private JSpinner minHeight;
    private JSpinner maxHeight;
    private JSpinner minWeight;
    private JSpinner maxWeight;
    private JButton chooseDirectoryButton;
    private JLabel amountLabel;


    public MainForm(ViewModel model, Writer writer) {
        super();
        this.writer = writer;
        this.model = model;

        createComponents();
        setEventListeners();
        this.setContentPane(mainPanel);

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void bindModels() {
        amountSlider.setModel(model.amount);
        minAge.setModel(model.minAge);
        maxAge.setModel(model.maxAge);
        minHeight.setModel(model.minHeight);
        maxHeight.setModel(model.maxHeight);
        minWeight.setModel(model.minWeight);
        maxWeight.setModel(model.maxWeight);
        minHouseNumber.setModel(model.minHouseNumber);
        maxHouseNumber.setModel(model.maxHouseNumber);
        useIndentsCheckBox.setModel(model.useIndents);
    }

    private void createComponents() {
        directoryChooser.setCurrentDirectory(new File("."));
        directoryChooser.setDialogTitle("Target directory");
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        directoryChooser.setAcceptAllFileFilterUsed(false);

        createTab(humanPanel, "Name", model.names);
        createTab(humanPanel, "Surname", model.surnames);
        createTab(humanPanel, "Nation", model.nations);
        createTab(addressPanel, "State", model.states);
        createTab(addressPanel, "City", model.cities);
        createTab(addressPanel, "Street", model.streets);
    }

    private void createTab(JTabbedPane parent, String name, CustomListModel<String> model) {
        parent.addTab(name, new PropertyList(model));
    }

    private void setEventListeners() {

        amountSlider.addChangeListener(e -> {
            int amount = amountSlider.getValue();
            String label = String.format("Amount: %d", amount);
            amountLabel.setText(label);
        });

        generateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    model.validate();
                    String directoryPath = outputPathField.getText();
                    String filePath = writer.write(directoryPath);
                    String message = "Path to output file: ".concat(filePath);
                    showMessageDialog(
                        null,
                        message,
                        "Json generated successfully",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
                catch (ViewModel.InvalidStateException |
                       IOException |
                       InvalidPathException ex) {
                    showMessageDialog(
                        null,
                        ex.getMessage(),
                        "Input error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        chooseDirectoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int action = directoryChooser.showDialog(null, "Choose directory");
                if (action == JFileChooser.APPROVE_OPTION) {
                    String path = directoryChooser.getSelectedFile()
                                                  .getPath() + "\\";
                    outputPathField.setText(path);
                }
            }
        });
    }
}
