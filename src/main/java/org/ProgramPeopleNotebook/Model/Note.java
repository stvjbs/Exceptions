package org.ProgramPeopleNotebook.Model;

import java.time.LocalDate;

public class Note {
    private final String surname;
    private final String firstname;
    private final String secondSurname;
    private final LocalDate dateOfBirth;
    private final Integer phoneNumber;
    private final String sex;

    protected Note(String surname, String firstname, String secondSurname, LocalDate dateOfBirth, Integer phoneNumber, String sex) {
        this.surname = surname;
        this.firstname = firstname;
        this.secondSurname = secondSurname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public static Note create(String surname, String firstname, String secondSurname, LocalDate dateOfBirth, Integer phoneNumber, String sex) {
        return new Note(surname, firstname, secondSurname, dateOfBirth, phoneNumber, sex);
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "\n" + '<' + surname + '>' + '<' + firstname + '>' + '<' + secondSurname + '>' + '<' + dateOfBirth + '>'
                + '<' + phoneNumber + '>' + '<' + sex + '>' + "\n";
    }
}
