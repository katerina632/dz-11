package com.rd.dz11;
public class Man extends Person {
    public Man(String firstName, String lastName, int age, Woman partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public boolean isRetired() {

        return getAge() >= 65;
    }

}
