package com.pragma.library.service;

import com.pragma.library.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User findUserByMembershipNumber(int membershipNumber) {
        return users.stream()
               .filter(user -> user.membershipNumber() == membershipNumber)
               .findFirst()
               .orElse(null);
    }
}