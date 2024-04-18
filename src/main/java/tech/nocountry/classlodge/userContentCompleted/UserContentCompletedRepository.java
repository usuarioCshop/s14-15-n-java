package tech.nocountry.classlodge.userContentCompleted;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserContentCompletedRepository extends JpaRepository<UserContentCompleted, Integer> {
    UserContentCompleted findByIdAndEmail(Integer id, String email);
}
