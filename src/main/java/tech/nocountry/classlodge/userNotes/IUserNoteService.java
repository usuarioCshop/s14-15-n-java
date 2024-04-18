package tech.nocountry.classlodge.userNotes;

import java.util.List;

/**
 *
 * @author Angelina
 *
 */

public interface IUserNoteService {

    UserNote createUserNote(UserNote userNote);

    Boolean exists(Integer noteId);

    UserNote modifyUserNote(Integer noteId, UserNoteDTO userNoteDTO);

    List<UserNoteDTO> getAllUserNoteById(Integer couseId);

    UserNoteDTO getUserNoteById(Integer noteId);

    void deleteUserNote(Integer noteId);


}
