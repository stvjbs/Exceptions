package org.ProgramPeopleNotebook.Model;

import java.io.FileWriter;
import java.io.IOException;

public class NoteWriter {
    String filename;
    Note note;
    StringBuilder sb = new StringBuilder();

    public NoteWriter(String filename, Note note) throws IOException {
        this.filename = filename;
        this.note = note;
        sb.append(note.toString());
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write(sb.toString());
        }
    }
}
