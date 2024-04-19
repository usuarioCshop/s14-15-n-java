package tech.nocountry.classlodge.userContentCompleted;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class UserContentCompletedServiceImpl implements UserContentCompletedService {

    private final UserContentCompletedRepository userContentCompletedRepository;

    @Autowired
    public UserContentCompletedServiceImpl(UserContentCompletedRepository userContentCompletedRepository) {
        this.userContentCompletedRepository = userContentCompletedRepository;
    }

    @Override
    public List<UserContentCompleted> getAllUserContentCompleted() {
        return userContentCompletedRepository.findAll();
    }

    @Override
    public UserContentCompleted getUserContentCompletedById(Integer id) {
        return userContentCompletedRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserContentCompleted(Integer id) {
        userContentCompletedRepository.deleteById(id);
    }

    @Override
    public UserContentCompleted saveUserContentCompleted(UserDTO userDTO) {
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        ModelMapper modelMapper = new ModelMapper();
        UserContentCompleted newContentCompleted = modelMapper.map(userDTO,UserContentCompleted.class);
        newContentCompleted.setDateMarkedAsCompleted(date);
        return userContentCompletedRepository.save(newContentCompleted);
    }

    @Override
    public UserContentCompleted updateUserContentCompleted(UserContentCompleted existingUserContentCompleted) {
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        existingUserContentCompleted.setDateMarkedAsCompleted(date);
        return userContentCompletedRepository.save(existingUserContentCompleted);
    }

    @Override
    public UserContentCompleted getUserContentCompletedByIdAndEmail(Integer id, String email) {
        UserContentCompleted updateUserContentCompleted = userContentCompletedRepository.findByIdAndEmail(id, email);
        return updateUserContentCompleted;
    }
}
