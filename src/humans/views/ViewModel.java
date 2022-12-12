package humans.views;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ViewModel {

    protected final CustomListModel<String> names = new CustomListModel<>();
    protected final CustomListModel<String> surnames = new CustomListModel<>();
    protected final CustomListModel<String> nations = new CustomListModel<>();
    protected final CustomListModel<String> states = new CustomListModel<>();
    protected final CustomListModel<String> cities = new CustomListModel<>();
    protected final CustomListModel<String> streets = new CustomListModel<>();
    protected final SpinnerModel minAge = new SpinnerNumberModel(18, 0, 100, 1);
    protected final SpinnerModel maxAge = new SpinnerNumberModel(18, 0, 100, 1);
    protected final SpinnerModel minHeight = new SpinnerNumberModel(150, 100, 200, 1);
    protected final SpinnerModel maxHeight = new SpinnerNumberModel(150, 100, 200, 1);
    protected final SpinnerModel minWeight = new SpinnerNumberModel(50, 45, 120, 1);
    protected final SpinnerModel maxWeight = new SpinnerNumberModel(50, 45, 120, 1);
    protected final SpinnerModel minHouseNumber = new SpinnerNumberModel(1, 1, 25, 1);
    protected final SpinnerModel maxHouseNumber = new SpinnerNumberModel(1, 1, 25, 1);
    protected final BoundedRangeModel amount = new DefaultBoundedRangeModel(10, 0, 1, 50);
    protected final ButtonModel useIndents = new JToggleButton.ToggleButtonModel();

    public void validate() throws InvalidStateException {

        Map<String, String> errors = new HashMap<>();

        if ((int) minAge.getValue() > (int) maxAge.getValue())
            errors.put("Age", "Min age must be lesser or equal than max age.");
        if ((int) minWeight.getValue() > (int) maxWeight.getValue())
            errors.put("Weight", "Min weight must be lesser or equal than max weight.");
        if ((int) minHeight.getValue() > (int) maxHeight.getValue())
            errors.put("Height", "Min height must be lesser or equal than max height.");
        if ((int) minHouseNumber.getValue() > (int) maxHouseNumber.getValue()) errors.put(
            "House number",
            "Min house number must be lesser or equal than max house number."
        );

        if (!errors.isEmpty()) {
            String message = makeErrorMessage(errors);
            throw new InvalidStateException(message);
        }
    }

    private String makeErrorMessage(Map<String, String> errors) {
        StringBuilder builder = new StringBuilder();
        for (var entry : errors.entrySet()) {
            builder.append(entry.getKey());
            builder.append(": ");
            builder.append(entry.getValue());
            builder.append("\n\n");
        }
        return builder.toString();
    }

    private int modelToInt(SpinnerModel model) {
        return (int) model.getValue();
    }

    public List<String> getNames() {
        return names.toList();
    }

    public List<String> getSurnames() {
        return surnames.toList();
    }

    public List<String> getNations() {
        return nations.toList();
    }

    public List<String> getStates() {
        return states.toList();
    }

    public List<String> getCities() {
        return cities.toList();
    }

    public List<String> getStreets() {
        return streets.toList();
    }

    public int getMinAge() {
        return modelToInt(minAge);
    }

    public int getMaxAge() {
        return modelToInt(maxAge);
    }

    public int getMinHeight() {
        return modelToInt(minHeight);
    }

    public int getMaxHeight() {
        return modelToInt(maxHeight);
    }

    public int getMinWeight() {
        return modelToInt(minWeight);
    }

    public int getMaxWeight() {
        return modelToInt(maxWeight);
    }

    public int getMinHouseNumber() {
        return modelToInt(minHouseNumber);
    }

    public int getMaxHouseNumber() {
        return modelToInt(maxHouseNumber);
    }

    public int getAmount() {
        return amount.getValue();
    }

    public boolean useIndents() {
        return useIndents.isSelected();
    }


    public static class InvalidStateException extends RuntimeException {

        public InvalidStateException(String message) {
            super(message);
        }
    }
}
