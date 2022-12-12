package humans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import humans.views.ViewModel;
import humans.generators.AddressGenerator;
import humans.generators.PersonGenerator;
import humans.models.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.List;

public class Writer {

    private final ViewModel model;

    public Writer(ViewModel model) {
        this.model = model;
    }

    private void validatePath(String pathString) throws InvalidPathException {
        if (pathString == null || pathString.isBlank() || pathString.isEmpty())
            throw new InvalidPathException(
                "Empty path",
                "You must specify valid path to output directory."
            );
    }

    private PersonGenerator createPersonGenerator() {
        return new PersonGenerator(
            model.getNames(),
            model.getSurnames(),
            model.getNations(),
            model.getMinAge(),
            model.getMaxAge(),
            model.getMinHeight(),
            model.getMaxHeight(),
            model.getMinWeight(),
            model.getMaxWeight(),
            new AddressGenerator(
                model.getStates(),
                model.getCities(),
                model.getStreets(),
                model.getMinHouseNumber(),
                model.getMaxHouseNumber()
            )
        );
    }

    public String write(String directoryPath) throws IOException, InvalidPathException {
        validatePath(directoryPath);
        PersonGenerator generator = createPersonGenerator();
        List<Person> personList = generator.create(model.getAmount());
        ObjectMapper serializer = new ObjectMapper();
        if (model.useIndents())
            serializer.enable(SerializationFeature.INDENT_OUTPUT);
        File output = new File(directoryPath.concat("output.json"));
        serializer.writeValue(output, personList);
        return output.getAbsoluteFile().toString();
    }

}
