package tech.nocountry.classlodge.userNotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.nocountry.classlodge.user.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public UserNote createUserNote(UserNote userNote){

        return userNoteRepository.save(userNote);
    }

    @Override
    public Boolean exists(Integer noteId) {
        return this.userNoteRepository.existsById(noteId);
    }

    // Recibe los atributos del nuevo objeto y los setea al objeto ya existente.

    @Override
    public UserNote modifyUserNote(Integer contentId, UserNoteDTO userNoteDTO){
        Optional<UserNote> optionalUserNote = userNoteRepository.findById(contentId);
        if (optionalUserNote.isPresent()){
            UserNote newUserNote = optionalUserNote.get();
            if (!userNoteDTO.details().isBlank()){newUserNote.setDetails(userNoteDTO.details());}
            if (!userNoteDTO.noteContent().isBlank()){newUserNote.setNoteContent(userNoteDTO.noteContent());}
            newUserNote.setDateTaken(new Date());
            newUserNote.setModified(Boolean.TRUE);
            return userNoteRepository.save(newUserNote);
        }else {
            return null;
        }
    }

    @Override //La idea es buscar el listado de apuntes segun el curso
    public List<UserNoteDTO> getAllUserNoteById(Integer courseId){
        return userNoteRepository.findAllById(courseId);
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
