package com.siemens.ct.bam.users;

import java.util.*;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class UsersRegister {

   Map<Long,User> users = new HashMap<>();

    public void addUser(User user){
        users.put(user.getCnp(), user);
    }

    public User getUser( Long cnp){

//        if(!users.containsKey(cnp))
//                return null;

        return users.get(cnp);
    }

    public void deleteUser (User user) throws UException {

        if(!userExist(user))
            throw new UException("User does not exist!");

        users.remove(user.getCnp());

    }

    public int sizeUsers()
    {
        return users.size();
    }

    public boolean userExist(User user)
    {
        if( users.containsKey(user.getCnp()))
            return TRUE;

        return FALSE;
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
