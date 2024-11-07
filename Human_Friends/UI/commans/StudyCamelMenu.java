package UI.commans;

import Presenters.StudyCamelPresenter;
import UI.ConsoleUi;
import Operation.servise.IEducable;
import UI.menu.MenuItem;
import UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCamelMenu extends Menu {
    private final StudyCamelPresenter presenter = new StudyCamelPresenter();

    public StudyCamelMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Обучить ходить"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Обучить нести груз"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyRun, "Обучить бежать"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCamelNames();
        if (names.isEmpty()) {
            ConsoleUi.println("Не найдено ни одного верблюда для обучения");
        }
        ConsoleUi.println("Доступные верблюды: " + names);
        ConsoleUi.println("Введите имя: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyWalk() {
        educate(presenter::learnCommandWalk);
    }

    public void studyCarryLoad() {
        educate(presenter::learnCommandCarryLoad);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyRun() {
        educate(presenter::learnCommandRun);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}