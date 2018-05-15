package com.siemens.ct.bam.users;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class UsersRegister {

   Map<Long,User> users = new HashMap<>();

   private Logger logger = Logger.getLogger("UserLog");
   FileHandler fh;

    {
        try {
            fh = new FileHandler("C:\\Users\\cosmin.rosu\\Desktop\\SiemensBAM\\user_app_repo\\logger\\UserLogger.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setLevel(Level.INFO);
            logger.setUseParentHandlers(false);

            logger.info("Logger has been created... ");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }


    public void addUser(User user) throws UserExistException {
        if(userExist(user.getCnp()))
            throw new UserExistException("User already exists... "+ user);

        users.put(user.getCnp(), user);
        logger.info("User "+ user + " has been added to register...");
   }

    public User getUser( Long cnp) throws UserNotExistException {
        if(!userExist(cnp))
            throw new UserNotExistException("User does not exist! "+users.get(cnp));

        return users.get(cnp);
    }

    public void deleteUser (User user) {
        users.remove(user.getCnp());
        logger.info("User " + user + " has been deleted... ");
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
