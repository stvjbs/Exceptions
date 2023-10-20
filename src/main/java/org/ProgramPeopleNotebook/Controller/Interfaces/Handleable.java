package org.ProgramPeopleNotebook.Controller.Interfaces;

import org.ProgramPeopleNotebook.Exceptions.NullFieldException;
import org.ProgramPeopleNotebook.Model.Note;

import java.io.IOException;

public interface Handleable {

    Note handle(String[] separatedInput) throws NullFieldException;
    void writeNote(Note note) throws IOException;
    Note noteCollector();

}
