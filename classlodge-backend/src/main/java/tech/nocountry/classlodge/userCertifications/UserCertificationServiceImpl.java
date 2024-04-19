package tech.nocountry.classlodge.userCertifications;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.nocountry.classlodge.course.Course;
import tech.nocountry.classlodge.course.ICourseRepository;
import tech.nocountry.classlodge.user.User;
import tech.nocountry.classlodge.user.UserRepository;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserCertificationServiceImpl implements UserCertificationService{

    @Autowired
    private UserCertificationRepository userCertificationRepository;
    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserCertificationDTO> findByUserEmail(String userEmail) {
        List<UserCertification> certifications = userCertificationRepository.findByUserEmail(userEmail);
        if (certifications.isEmpty()) {
            return Collections.emptyList();
        } else {
            return certifications.stream()
                    .map(UserCertificationMapperDTO::toUserCertificationDTO)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<UserCertificationDTO> findByUserEmailAndCourseId(String userEmail, Long courseId) {
        List<UserCertification> certifications = (List<UserCertification>) userCertificationRepository.findByUserEmailAndCourseId(userEmail, courseId);
        if (certifications.isEmpty()) {
            return Collections.emptyList();
        } else {
            List<UserCertificationDTO> certificationDTOs = certifications.stream()
                    .map(UserCertificationMapperDTO::toUserCertificationDTO)
                    .collect(Collectors.toList());
            return certificationDTOs;
        }
    }
   /* @Override
    public UserCertificationDTO createCertification(UserCertificationDTO userCertificationDTO) {
        System.out.println("entra en el metodo yaaaa" );
        // Obtener el usuario y el curso basados en los IDs proporcionados en el DTO
        Optional<User> userOptional = userRepository.findById(String.valueOf(userCertificationDTO.user()));
        Optional<Course> courseOptional = courseRepository.findById(Long.valueOf(userCertificationDTO.id()));
        System.out.println("entra en el metodo " + userOptional.toString() + " " + courseOptional.toString());
        // Verificar si tanto el usuario como el curso existen en la base de datos
        if (userOptional.isPresent() && courseOptional.isPresent()) {
            User user = userOptional.get();
            Course course = courseOptional.get();

            // Crear una nueva instancia de UserCertification
            UserCertification certification = new UserCertification();
            // Asignar el usuario y el curso al objeto UserCertification
            certification.setUser(user);
            certification.setCourse(course);
            certification.setStatus(userCertificationDTO.status());
            certification.setLastAttemptDate(userCertificationDTO.lastAttemptDate());
            certification.setRemainingAttempts(userCertificationDTO.remainingAttempts());
            System.out.println("Se genero la certificacion + " + certification.toString());

            // Guardar el objeto UserCertification en la base de datos y mapear a DTO
            return UserCertificationMapperDTO.toUserCertificationDTO(userCertificationRepository.save(certification));
        } else {
            // Lanzar una excepción si no se encuentra el usuario o el curso
            throw new EntityNotFoundException("User or course not found with ID: " + userCertificationDTO.id());
        }
    }*/



    @Override
    public UserCertificationDTO createCertification(UserCertificationDTO userCertificationDTO) {
        UserCertification certification = new UserCertification();
        certification.setUser(userCertificationDTO.user());
        certification.setCourse(userCertificationDTO.course());
        certification.setStatus(userCertificationDTO.status());
        certification.setLastAttemptDate(userCertificationDTO.lastAttemptDate());
        certification.setRemainingAttempts(userCertificationDTO.remainingAttempts());
        return UserCertificationMapperDTO.toUserCertificationDTO(userCertificationRepository.save(certification));
    }
    public byte[] generatePDF(UserCertificationDTO dto)  {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Certificado de Curso")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(16));

        Table table = new Table(new float[]{1, 2});
        table.addCell("Usuario:");
        table.addCell(dto.user().getFirstName());
        table.addCell(dto.user().getLastName());
        table.addCell("Curso:");
        table.addCell(dto.course().getName());
        table.addCell("Estado:");
        table.addCell(dto.status().toString());
        table.addCell("Fecha del último intento:");
        table.addCell(dto.lastAttemptDate().toString());
        table.addCell("Intentos restantes:");
        table.addCell(String.valueOf(dto.remainingAttempts()));

        document.add(table);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
    public UserCertificationDTO getCertificationById(Long certificationId) throws Exception {
        Optional<UserCertification> certification = userCertificationRepository.findById(certificationId);
        if (!certification.isPresent()) {
            throw new Exception("No se encontró la certificación con ID: " + certificationId);
        }

        return UserCertificationMapperDTO.toUserCertificationDTO(certification.get());
    }


    @Override
    public UserCertificationDTO updateCertification(UserCertificationDTO userCertificationDTO) {
        // Buscar la certificación existente por su ID
        UserCertification existingCertification = userCertificationRepository.findById(userCertificationDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("Certification not found with ID: " + userCertificationDTO.id()));

        // Actualizar los campos de la certificación existente
        existingCertification.setUser(userCertificationDTO.user());
        existingCertification.setCourse(userCertificationDTO.course());
        existingCertification.setStatus(userCertificationDTO.status());
        existingCertification.setLastAttemptDate(userCertificationDTO.lastAttemptDate());
        existingCertification.setRemainingAttempts(userCertificationDTO.remainingAttempts());


        // Guardar los cambios en la base de datos
        UserCertification updatedCertification = userCertificationRepository.save(existingCertification);

        // Convertir la certificación actualizada a DTO
        return UserCertificationMapperDTO.toUserCertificationDTO(updatedCertification);
    }

    @Override
    public void deleteAllCertifications(String userEmail) {
        // Obtener todas las certificaciones del usuario
        List<UserCertification> certifications = userCertificationRepository.findByUserEmail(userEmail);
        // Eliminar todas las certificaciones del usuario
        userCertificationRepository.deleteAll(certifications);
    }

    @Override
    public void deleteByUserEmailAndCourseId(String userEmail, Long courseId) {
        // Verificar si existe la certificación antes de eliminarla
        Optional<UserCertification> optionalCertification = Optional.ofNullable(userCertificationRepository.findByUserEmailAndCourseId(userEmail, courseId));

        if (optionalCertification.isPresent()) {
            // Eliminar la certificación
            userCertificationRepository.delete(optionalCertification.get());
        } else {
            // Lanzar una excepción si no se encuentra la certificación
            throw new EntityNotFoundException("Certification not found for user email: " + userEmail + " and course ID: " + courseId);
        }
    }
}

