package tech.nocountry.classlodge.userNotes;

import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 *
 * @author Angelina
 *
 */

@Service
public class UserNoteDTOMapper implements Function<UserNote, UserNoteDTO> {
    @Override
    public UserNoteDTO apply(UserNote userNote){
        return new UserNoteDTO(
                userNote.getDetails(),
                userNote.getNoteContent(),
                userNote.getDateTaken()
        );
    }
}
