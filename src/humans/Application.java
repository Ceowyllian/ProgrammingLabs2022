package humans;

import humans.views.MainForm;
import humans.views.ViewModel;

public class Application {

    public static void main(String[] args) {
        ViewModel model = new ViewModel();
        Writer writer = new Writer(model);
        MainForm form = new MainForm(model, writer);
    }
}
