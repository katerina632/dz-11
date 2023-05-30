package com.rd.dz11;

public class Woman extends Person {

    private String oldLastName;

    public Woman(String firstName, String lastName, int age, Man partner) {
        super(firstName, lastName, age, partner);
    }

    @Override
    public boolean isRetired() {
        return getAge() >= 60;
    }

 public void changeLastName(Man partner){
     oldLastName = getLastName();
     setLastName(partner.getLastName());
 }
    public void changeOldLastName(boolean isOldLastName) {
        if (isOldLastName) {
            setLastName(oldLastName);
            oldLastName = null;
        }
    }
}
