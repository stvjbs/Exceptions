package org.ProgramPeopleNotebook.Controller.Interfaces;

import org.ProgramPeopleNotebook.Exceptions.NullFieldException;
import org.ProgramPeopleNotebook.Model.Note;

public interface Checkable {

    boolean isNumber(String s);
    boolean isDate(String s);
    boolean isSex(String s);
    void checkNull(Note note) throws NullFieldException;
}
