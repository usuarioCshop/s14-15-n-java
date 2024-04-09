package tech.nocountry.classlodge.userNotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Angelina
 *
 */

@Service
public class UserNoteServiceImp implements IUserNoteService {


    private final IUserNoteRepository userNoteRepository;
    private final UserNoteDTOMapper userNoteDTOMapper;

    @Autowired
    public UserNoteServiceImp(IUserNoteRepository userNoteRepository, UserNoteDTOMapper userNoteDTOMapper) {
        this.userNoteRepository = userNoteRepository;
        this.userNoteDTOMapper = userNoteDTOMapper;
    }


    @Override
    public UserNote saveUserNote(UserNote userNote){
        return userNoteRepository.save(userNote);
    }

    @Override
    public void modifyUserNote(UserNote userNote){
        userNoteRepository.save(userNote);
    }

    @Override //La idea es buscar el listado de apuntes segun el curso
    public List<UserNoteDTO> getAllUserNoteById(Integer contentId){
        return userNoteRepository.findAllById(contentId);
    }

    @Override //Acceder a un apunte específico
    public UserNoteDTO getUserNoteById(Integer noteId){
        return userNoteRepository.findById(noteId).map(userNoteDTOMapper).orElse(null);
    }

    @Override
    public void deleteUserNote(Integer noteId){
        userNoteRepository.deleteById(noteId);
    }
}
