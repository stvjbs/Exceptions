package org.ProgramPeopleNotebook.Controller.Interfaces;

import org.ProgramPeopleNotebook.Exceptions.NumberOfStringsException;

public interface Separable {
    String[] separateInput(String input) throws NumberOfStringsException;
}
