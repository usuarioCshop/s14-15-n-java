package tech.nocountry.classlodge.userCertifications;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/certifications")
@CrossOrigin(origins = "*")
public class UserCertificationController {

    @Autowired
    private UserCertificationService userCertificationService;

    @GetMapping("/user/{userEmail}")
    @Operation(summary = "This endpoint allows the user's certifications to be consulted by email.")
    public ResponseEntity<List<UserCertificationDTO>> findByUserEmail(@PathVariable String userEmail) {
        List<UserCertificationDTO> certifications = userCertificationService.findByUserEmail(userEmail);
        return ResponseEntity.ok(certifications);
    }

    @GetMapping("/user/{userEmail}/course/{courseId}")
    public ResponseEntity<List<UserCertificationDTO>> findByUserEmailAndCourseId(@PathVariable String userEmail, @PathVariable Long courseId) {
        List<UserCertificationDTO> certifications = userCertificationService.findByUserEmailAndCourseId(userEmail, courseId);
        return ResponseEntity.ok(certifications);
    }

    @PostMapping("/create")
    @Operation(summary = "This endpoint allows the creation of a certification within the database")
    public ResponseEntity<UserCertificationDTO> userCreateCertification(@Valid @RequestBody UserCertificationDTO certificationDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Crear una respuesta con los detalles de los errores
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError -> {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body((UserCertificationDTO) errorMap);
        }
        UserCertificationDTO createdCertification = userCertificationService.createCertification(certificationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCertification);
    }
    @GetMapping("/downloadCertification")
    @Operation(summary = "This endpoint allows the download of a certification in PDF format")
    public ResponseEntity<byte[]> downloadCertification(@RequestParam Long certificationId) {
        try {
            UserCertificationPdfDTO dto = userCertificationService.getCertificationById(certificationId);
            byte[] pdfBytes = userCertificationService.generatePDF(dto);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=certificado.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "This endpoint allows the update of a certification within the database")
    public ResponseEntity<UserCertificationDTO> userUpdateCertification(
            @PathVariable Long id,
            @Valid @RequestBody UserCertificationUpdateDTO updateDTO) throws Exception {

        if (userCertificationService.getCertificationById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        // Convertir CertificationUpdateDTO a UserCertificationDTO (esto depende de cómo desees manejarlo en tu servicio)
        UserCertificationDTO certificationDTO = new UserCertificationDTO();
        certificationDTO.setStatus(updateDTO.getStatus());
        certificationDTO.setLastAttemptDate(updateDTO.getLastAttemptDate());
        certificationDTO.setRemainingAttempts(updateDTO.getRemainingAttempts());
        // Asumiendo que necesitas mantener otros campos, deberías cargarlos de la DB antes de actualizar

        UserCertificationDTO updatedCertification = userCertificationService.updateCertification(id, certificationDTO);
        return ResponseEntity.ok(updatedCertification);
    }

    @DeleteMapping("/user/{userEmail}")
    @Operation(summary = "This endpoint allows the deletion of all certifications of a user by email.")
    public ResponseEntity<Void> deleteAllCertifications(@PathVariable String userEmail) {
        userCertificationService.deleteAllCertifications(userEmail);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/user/{userEmail}/course/{courseId}")
    @Operation(summary = "This endpoint allows the deletion of a certification of a user by email and course id.")
    public ResponseEntity<Void> deleteByUserEmailAndCourseId(@PathVariable String userEmail, @PathVariable Long courseId) {
        userCertificationService.deleteByUserEmailAndCourseId(userEmail, courseId);
        return ResponseEntity.noContent().build();
    }

}
