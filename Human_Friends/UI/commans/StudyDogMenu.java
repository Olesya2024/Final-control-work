package UI.commans;

import Presenters.StudyDogPresenter;
import UI.ConsoleUi;
import Operation.servise.IEducable;
import UI.menu.MenuItem;
import UI.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDogMenu extends Menu {
    private final StudyDogPresenter presenter = new StudyDogPresenter();

    public StudyDogMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyBark, "Обучить дать голос"));
        menuItems.add(new MenuItem(this::studyFetch, "Обучить принести"));
        menuItems.add(new MenuItem(this::studyRoll, "Обучить катить"));
        menuItems.add(new MenuItem(this::studyPaw, "Обучить дать лапу"));
        menuItems.add(new MenuItem(this::studySit, "Обучить сидеть"));
        menuItems.add(new MenuItem(this::studyStay, "Обучить стоять на месте"));
        menuItems.add(new MenuItem(this::back, "назад"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableDogNames();
        if (names.isEmpty()) {
            ConsoleUi.println("Не найдено ни одной собаки для обучения");
        }
        ConsoleUi.println("Доступные собаки: " + names);
        ConsoleUi.println("Введите имя: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }


    public void studyBark() {
        educate(presenter::learnCommandBark);
    }

    public void studyPaw() {
        educate(presenter::learnCommandPaw);
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyFetch() {
        educate(presenter::learnCommandFetch);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyStay() {
        educate(presenter::learnCommandStay);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
