package com.siemens.ct.bam.users;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class UsersRegister {

   Map<Long,User> users = new HashMap<>();

    public void addUser(User user) throws UserExistException {
        if(userExist(user.getCnp()))
            throw new UserExistException("User already exists... "+ user);


        users.put(user.getCnp(), user);
    }

    public User getUser( Long cnp) throws UserNotExistException {
        if(!userExist(cnp))
            throw new UserNotExistException("User does not exist!");

        return users.get(cnp);
    }

    public void deleteUser (User user) {
        users.remove(user.getCnp());

    }

    public int sizeUsers()
    {
        return users.size();
    }

    public boolean userExist(Long cnp)
    {
        return users.containsKey(cnp);

    }

    public Map<Long, User> getUsersWithAgeHigherThan(int age)
    {
        Map<Long,User> usersOlder = new HashMap<>();

        for (User user: users.values())
            if(user.getAge() > age)
                usersOlder.put(user.getCnp(),user);

        return usersOlder;
    }
}
