package com.siemens.ct.bam.users;

public class User {
    private String name;
    private Long cnp;
    private Integer age;

    User(String name, Long cnp, Integer age){
        this.name = name;
        this.cnp = cnp;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getCnp() {
        return cnp;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Nume: " + name + "; CNP: " + cnp + "; Varsta: " + age + "; ";
    }


}
