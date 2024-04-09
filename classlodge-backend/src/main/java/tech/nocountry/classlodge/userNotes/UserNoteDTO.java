package tech.nocountry.classlodge.userNotes;

import java.util.Date;

public record UserNoteDTO (
        String details,
        String noteContent,
        Date dateTaken
){}
