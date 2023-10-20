package org.ProgramPeopleNotebook.Controller;

import org.ProgramPeopleNotebook.Controller.Interfaces.Checkable;
import org.ProgramPeopleNotebook.Controller.Interfaces.Handleable;
import org.ProgramPeopleNotebook.Exceptions.NullFieldException;
import org.ProgramPeopleNotebook.Model.Note;
import org.ProgramPeopleNotebook.Model.NoteWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NoteHandler implements Handleable, Checkable {
    String surname;
    String firstname;
    String secondSurname;
    LocalDate dateOfBirth;
    Integer phoneNumber;
    String sex;

    @Override
    public Note handle(String[] separatedInput) throws NullFieldException {
        List<String> names = new ArrayList<>();
        for (String s : separatedInput) {
            if (isNumber(s)) {
                phoneNumber = Integer.parseInt(s);
                continue;
            }
            if (isDate(s)) {
                dateOfBirth = LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
                continue;
            }
            if (isSex(s)) sex = s;
            else names.add(s);
        }
        if (names.size() < 3) {
            throw new NullFieldException("One or more of the fields is null. Try again.");
        }
        surname = names.get(0);
        firstname = names.get(1);
        secondSurname = names.get(2);
        return noteCollector();
    }

    @Override
    public void writeNote(Note note) throws IOException {
        new NoteWriter(getSurname(), note);
    }

    @Override
    public Note noteCollector() throws NullFieldException {
        Note note = Note.create(surname, firstname, secondSurname, dateOfBirth, phoneNumber, sex);
        checkNull(note);
        return note;
    }

    @Override
    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public boolean isDate(String s) {
        try {
            LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isSex(String s) {
        return s.equalsIgnoreCase("f") || s.equalsIgnoreCase("m");
    }

    @Override
    public void checkNull(Note note) throws NullFieldException {
        if (note.getSurname() == null || note.getFirstname() == null
                || note.getSecondSurname() == null || note.getDateOfBirth() == null
                || note.getPhoneNumber() == null || note.getSex() == null)
            throw new NullFieldException(" One or more of the fields is null. Try again. ");
    }

    public String getSurname() {
        return surname;
    }
}
