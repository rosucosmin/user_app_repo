package com.siemens.ct.bam.users;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersRegisterTest {

    @Test
    public void getUser() throws UserNotExistException, UserExistException {
        UsersRegister regUsers = new UsersRegister();
        regUsers.addUser(new User("Cosmin", 1960725142591L, 21));
        regUsers.addUser(new User("Dorel", 1870725142547L, 30));

        User expectedUser = new User("Cosmin", 1960725142591L, 21);
        User actualUser = regUsers.getUser(1960725142591L);

        assertEquals(expectedUser.toString(),actualUser.toString());


    }

    @Test
    public void deleteUser() throws UserNotExistException, UserExistException {
        UsersRegister regUsers = new UsersRegister();
        regUsers.addUser(new User("Cosmin", 1960725142591L, 21));
        regUsers.addUser(new User("Dorel", 1870725142547L, 30));
        regUsers.addUser(new User("Femeie", 2940515215467L, 23));


            regUsers.deleteUser(regUsers.getUser(1870725142547L));


        Integer expectedResult = 2;
        Integer actualResult = regUsers.sizeUsers();
        assertEquals(expectedResult,actualResult);

    }

    @Test

    public void deleteUserIfNotExists() throws UserExistException {
        UsersRegister regUsers = new UsersRegister();
        regUsers.addUser(new User("Cosmin", 1960725142591L, 21));
        regUsers.addUser(new User("Dorel", 1870725142547L, 30));
        regUsers.addUser(new User("Femeie", 2940515215467L, 23));


        try {
            regUsers.deleteUser(regUsers.getUser(1870725612547L));
            assertEquals(true,false);
        } catch (UserNotExistException e) {
            String result = e.getMessage();
            Boolean expectedResult = true;
            Boolean receivedResult = e.getMessage().startsWith("User does not");
            assertEquals(expectedResult,receivedResult);

        }

    }

    @Test
    public void getUsersWithAgeHigherThan() throws UserExistException {
        UsersRegister regUsers = new UsersRegister();
        regUsers.addUser(new User("Cosmin", 1960725142591L, 21));
        regUsers.addUser(new User("Dorel", 1870725142547L, 30));
        regUsers.addUser(new User("Femeie", 2940515215467L, 23));

        Integer expectedResult = 2;
        Integer actualResult = regUsers.getUsersWithAgeHigherThan(21).size();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void userDoesntExist() throws UserExistException {
        UsersRegister regUsers = new UsersRegister();
        regUsers.addUser(new User("Cosmin", 1960725142591L, 21));
        regUsers.addUser(new User("Dorel", 1870725142547L, 30));
        regUsers.addUser(new User("Femeie", 2940515215467L, 23));

        boolean expectedResult = false;
        boolean actualResult = regUsers.userExist(1960625142591L);
        assertEquals(expectedResult,actualResult);

    }

    @Test
    public void addUserAlreadyExists() {
        
    }

    @Test
    public void getInexistentUser()
    {
    }
}