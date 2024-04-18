package tech.nocountry.classlodge.userNotes;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 *
 * @author Angelina
 *
 */

@Repository
public interface IUserNoteRepository extends ListCrudRepository<UserNote, Integer> {
    List<UserNoteDTO> findAllById(Integer contentId);
}
