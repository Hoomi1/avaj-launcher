package ft.school21.avaj.simulator;

import ft.school21.avaj.aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable)
    {
        observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        List<Flyable> list = new ArrayList<>(observers);
        for (Flyable flyable : list) {
            flyable.updateConditions();
        }
    }
}
