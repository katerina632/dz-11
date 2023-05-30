package com.rd.dz11;
public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Person partner;

    public Person(String firstName, String lastName, int age, Person partner) {
        setLastName(lastName);
        setFirstName(firstName);
        setAge(age);

        if(partner!= null)
            registerPartnership(partner);
        else
            this.partner = null;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.isBlank())
            this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!lastName.isBlank())
            this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120)
            this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        if (partner instanceof Woman) {
            ((Woman) partner).changeLastName((Man) this);
        }
        this.partner = partner;
    }

    public abstract boolean isRetired();

    public void registerPartnership(Person partner) {
        if (this.partner != null) {
            System.out.printf("%s %s is already married!\n", firstName, lastName);
            return;
        }
        setPartner(partner);
        partner.setPartner(this);
    }

    public void deregisterPartnership(boolean isOldSurname) {
        if (partner == null) {
            System.out.printf("%s %s is single.\n", firstName, lastName);
            return;
        }

        if (partner instanceof Woman)
            ((Woman) partner).changeOldLastName(isOldSurname);
        else if (this instanceof Woman)
            ((Woman) this).changeOldLastName(isOldSurname);

        partner.setPartner(null);
        setPartner(null);
    }

    @Override
    public String toString() {
        String partnerName = partner != null ? String.format("married to %s %s", partner.firstName, partner.lastName) : "single";
        return String.format("%s %s, %d years old, %s.\n",
                firstName, lastName, age, partnerName);
    }
}
