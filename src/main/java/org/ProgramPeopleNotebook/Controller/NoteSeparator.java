package org.ProgramPeopleNotebook.Controller;

import org.ProgramPeopleNotebook.Controller.Interfaces.Separable;
import org.ProgramPeopleNotebook.Exceptions.NumberOfStringsException;

public class NoteSeparator implements Separable {
    @Override
    public String[] separateInput(String input) throws NumberOfStringsException {
        String[] separatedInput = input.split(" ");
        if (separatedInput.length != 6) {
            throw new NumberOfStringsException("Not all fields was initialized");
        }
        return separatedInput;
    }
}

