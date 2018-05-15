package com.siemens.ct.bam.users;

public class UserNotExistException extends Throwable {
    public UserNotExistException(String s) {
        super(s);
    }
}
