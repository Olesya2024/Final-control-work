package UI.commans;

import Presenters.StudyCatPresenter;
import UI.ConsoleUi;
import Operation.servise.IEducable;
import UI.menu.MenuItem;
import UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCatMenu extends Menu {
    private final StudyCatPresenter presenter = new StudyCatPresenter();

    public StudyCatMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyPounce, "Обучить идти ко мне"));
        menuItems.add(new MenuItem(this::studyScratch, "Обучить царапать"));
        menuItems.add(new MenuItem(this::studyMeow, "Обучить голосу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCatNames();
        if (names.isEmpty()) {
            ConsoleUi.println("Не найдено ни одной кошки для обучения");
        }
        ConsoleUi.println("Доступные коты/кошки: " + names);
        ConsoleUi.println("Введите имя: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyPounce() {
        educate(presenter::learnCommandPounce);
    }

    public void studyScratch() {
        educate(presenter::learnCommandScratch);
    }

    public void studyMeow() {
        educate(presenter::learnCommandMeow);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
