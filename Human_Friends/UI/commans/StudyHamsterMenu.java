package UI.commans;

import Presenters.StudyHamsterPresenter;
import UI.ConsoleUi;
import Operation.servise.IEducable;
import UI.menu.MenuItem;
import UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHamsterMenu extends Menu {
    private final StudyHamsterPresenter presenter = new StudyHamsterPresenter();

    public StudyHamsterMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить что-либо"));
        menuItems.add(new MenuItem(this::studyHide, "Обучить скрыться"));
        menuItems.add(new MenuItem(this::studySpin, "Обучить вращаться"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHamsterNames();
        if (names.isEmpty()) {
            ConsoleUi.println("Не найдено ни одного хомяка для обучения");
        }
        ConsoleUi.println("Доступные хомяки: " + names);
        ConsoleUi.println("Введите имя: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyHide() {
        educate(presenter::learnCommandHide);
    }

    public void studySpin() {
        educate(presenter::learnCommandSpin);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
