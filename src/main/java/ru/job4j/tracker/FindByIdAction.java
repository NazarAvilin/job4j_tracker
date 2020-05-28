package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "==== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item tempid = tracker.findById(id);
        if (tempid == null) {
            System.out.println("ID not found");
        } else {
            System.out.println(tempid);
        }
        return true;
    }
}
