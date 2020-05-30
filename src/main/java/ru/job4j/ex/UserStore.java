package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User wanted = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                wanted = user;
                break;
            }
        }
        if (wanted == null) {
            throw new UserNotFoundException("User not found");
        }
        return wanted;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Nazar Avilin", false)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ex) {
            System.out.println(ex.getMessage());
        } catch (UserNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}