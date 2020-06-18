package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        this.users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> user = this.findByPassport(passport);
        if (user.isPresent()) {
            List<Account> rsl = this.users.get(user.get());
            Optional<Account> findAccount = rsl.stream().filter(a -> a.equals(account)).findAny();
            if (findAccount.isEmpty()) {
                rsl.add(account);
                this.users.put(user.get(), rsl);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return this.users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = this.findByPassport(passport);
        Optional<Account> account = Optional.empty();
        if (user.isPresent()) {
            account = this.users.get(user.get()).stream()
                    .filter(a -> a.getRequisite()
                            .equals(requisite))
                    .findFirst();
        }
        return account;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = this.findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = this.findByRequisite(destPassport, destRequisite);
        boolean rsl =
                srcAccount.isPresent()
                        && destAccount.isPresent()
                        && srcAccount.get().getBalance() - amount >= 0;
        if (rsl) {
            srcAccount.get().setBalance(
                    srcAccount.get().getBalance() - amount
            );
            destAccount.get().setBalance(
                    destAccount.get().getBalance() + amount
            );
        }
        return rsl;
    }
}