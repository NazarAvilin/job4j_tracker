package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    @Override
    public String name() {
        return "==== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] temp = tracker.findByName(name);
        if (temp.length == 0) {
            System.out.println("Items with this name not found");
        } else {
            for (Item item : temp) {
                System.out.println(String.format("%s %s", item.getId(), item.getName()));
            }
        }
        return true;
    }

//    @Override
//    public boolean execute(Input input, Tracker tracker) {
//        System.out.println("==== Find items by name ====");
//        String name = input.askStr("Enter name: ");
//        Item[] tempName = tracker.findByName(name);
//        if (tempName.length > 0) {
//            for (Item item : tempName) {
//                System.out.println(String.format("%s %s", item.getId(), item.getName()));
//            }
//        } else {
//            System.out.println("Items with this name not found");
//        }
//        return true;
//    }
}


