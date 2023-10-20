package org.ProgramPeopleNotebook.View;

import org.ProgramPeopleNotebook.Controller.NoteHandler;
import org.ProgramPeopleNotebook.Controller.NoteSeparator;
import org.ProgramPeopleNotebook.Exceptions.NullFieldException;
import org.ProgramPeopleNotebook.Exceptions.NumberOfStringsException;

import java.io.IOException;
import java.util.Scanner;

public class View {
    String input = "";
    NoteSeparator noteSeparator;
    NoteHandler noteHandler;

    public void run() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("""
                    Input next information:
                     1.Surname Name Second surname\s
                     2.Date of birth ( in format "yyyy/MM/dd" )\s
                     3.Phone number (only numbers without any symbols)\s
                     4.Sex (just a letter, 'f' or 'm')\s
                    """);
            System.out.println("Please, input information separated by space");
            if (!input.equalsIgnoreCase("exit")) {
                input = scan.nextLine();
                noteSeparator = new NoteSeparator();
                noteHandler = new NoteHandler();
                noteHandler.writeNote(noteHandler.handle(noteSeparator.separateInput(input)));
                run();
            }
        } catch (NumberOfStringsException | NullFieldException e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
