package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "==== Delete item ========";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameId = input.askStr("Enter id: ");
        if (tracker.delete(nameId)) {
            System.out.print("Completed");
        } else {
            System.out.print("Not completed");
        }
        return true;
    }
}
