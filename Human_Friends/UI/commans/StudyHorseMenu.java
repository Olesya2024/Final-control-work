package UI.commans;

import Presenters.StudyHorsePresenter;
import UI.ConsoleUi;
import Operation.servise.IEducable;
import UI.menu.MenuItem;
import UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHorseMenu extends Menu {

    private final StudyHorsePresenter presenter = new StudyHorsePresenter();

    public StudyHorseMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyTrot, "Обучить бегу рысью"));
        menuItems.add(new MenuItem(this::studyCanter, "Обучить шагу"));
        menuItems.add(new MenuItem(this::studyGallop, "Обучить галопу"));
        menuItems.add(new MenuItem(this::studyJump, "Обучить прыжку"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHorseNames();
        if (names.isEmpty()) {
            ConsoleUi.println("Не найдено ни одного коня/лошади для обучения");
        }
        ConsoleUi.println("Доступные кони/лошади: " + names);
        ConsoleUi.println("Введите имя: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyTrot() {
        educate(presenter::learnCommandTrot);
    }

    public void studyCanter() {
        educate(presenter::learnCommandCanter);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void studyGallop() {
        educate(presenter::learnCommandGallop);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}