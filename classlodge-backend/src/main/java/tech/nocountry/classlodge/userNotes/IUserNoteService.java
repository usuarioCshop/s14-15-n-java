package tech.nocountry.classlodge.userNotes;

import java.util.List;

/**
 *
 * @author Angelina
 *
 */

public interface IUserNoteService {

    UserNote saveUserNote(UserNote userNote);

    void modifyUserNote(UserNote userNote);

    List<UserNoteDTO> getAllUserNoteById(Integer contentId);

    UserNoteDTO getUserNoteById(Integer noteId);

    void deleteUserNote(Integer noteId);


}
