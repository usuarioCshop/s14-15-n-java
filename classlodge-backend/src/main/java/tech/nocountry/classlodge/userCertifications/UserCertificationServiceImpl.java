package tech.nocountry.classlodge.userCertifications;


import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
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
            return certifications.stream()
                    .map(UserCertificationMapperDTO::toUserCertificationDTO)
                    .collect(Collectors.toList());
        }
    }
    @Override
    public UserCertificationDTO createCertification(UserCertificationDTO userCertificationDTO) {
        Optional<User> userOptional = userRepository.findById((userCertificationDTO.getUserEmail()));
        Optional<Course> courseOptional = courseRepository.findById(userCertificationDTO.getCourseId());
        if (userOptional.isPresent() && courseOptional.isPresent()) {
            User user = userOptional.get();
            Course course = courseOptional.get();

            UserCertification certification = new UserCertification();

            certification.setUser(user);
            certification.setCourse(course);
            certification.setStatus(userCertificationDTO.getStatus());
            certification.setLastAttemptDate(userCertificationDTO.getLastAttemptDate());
            certification.setRemainingAttempts(userCertificationDTO.getRemainingAttempts());

            return UserCertificationMapperDTO.toUserCertificationDTO(userCertificationRepository.save(certification));
        } else {
            throw new EntityNotFoundException("User or course not found with ID: " + userCertificationDTO);
        }
    }

    public UserCertificationPdfDTO getCertificationById(Long certificationId) throws Exception {
        Optional<UserCertification> certification = userCertificationRepository.findById(certificationId);
        if (certification.isEmpty()) {
            throw new Exception("No se encontró la certificación con ID: " + certificationId);
        }
        return UserCertificationMapperDTO.toUserCertificationPdfDTO(certification.get());
    }
    @Override
    public byte[] generatePDF(UserCertificationPdfDTO dto) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(byteArrayOutputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph title = new Paragraph("Certificado de Curso")
                .setTextAlignment(TextAlignment.CENTER)
                .setBold()
                .setFontSize(20)
                .setMarginBottom(20);
        document.add(title);

        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 3}))
                .useAllAvailableWidth()
                .setMarginBottom(10);

        addStyledCell(table, "Nombre del Usuario:", true);
        addStyledCell(table, dto.getUserName(), false);
        addStyledCell(table, "Correo Electrónico:", true);
        addStyledCell(table, dto.getUserEmail(), false);
        addStyledCell(table, "Curso:", true);
        addStyledCell(table, dto.getCourseName(), false);
        addStyledCell(table, "Estado:", true);
        addStyledCell(table, dto.getStatus(), false);
        addStyledCell(table, "Fecha del último intento:", true);
        addStyledCell(table, dto.getLastAttemptDate().toString(), false);
        addStyledCell(table, "Intentos restantes:", true);
        addStyledCell(table, String.valueOf(dto.getRemainingAttempts()), false);

        document.add(table);
        // Añadir un pie de página si es necesario
        Paragraph footer = new Paragraph("Este es un documento generado automáticamente, no requiere firma.")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(10)
                .setItalic()
                .setMarginTop(20);
        document.add(footer);

        document.close();
        return byteArrayOutputStream.toByteArray();
    }
    private void addStyledCell(Table table, String content, boolean isHeader) {
        Cell cell = new Cell().add(new Paragraph(content));
        if (isHeader) {
            cell.setBold()
                    .setBackgroundColor(ColorConstants.LIGHT_GRAY) // Cambia el color de fondo para las cabeceras
                    .setFontColor(ColorConstants.BLACK); // Cambia el color del texto
        }
        table.addCell(cell);
    }

   @Override
   public UserCertificationDTO updateCertification(Long id, UserCertificationDTO updatedCertificationDTO) {
       // Find the existing UserCertification entity by id
       UserCertification existingCertification = userCertificationRepository.findById(id)
               .orElseThrow(() -> new EntityNotFoundException("UserCertification not found with id: " + id));

       // Update the existing entity with the new values

       if(updatedCertificationDTO.getStatus() != null){
           existingCertification.setStatus(Status.valueOf(String.valueOf(updatedCertificationDTO.getStatus())));
       }
       if(updatedCertificationDTO.getLastAttemptDate() != null){
           existingCertification.setLastAttemptDate(updatedCertificationDTO.getLastAttemptDate());
       }
       if(updatedCertificationDTO.getRemainingAttempts() != null){
           existingCertification.setRemainingAttempts(updatedCertificationDTO.getRemainingAttempts());
       }
       existingCertification = userCertificationRepository.save(existingCertification);

       // Save the updated entity and map it to the DTO
       return UserCertificationMapperDTO.toUserCertificationDTO(existingCertification);
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

