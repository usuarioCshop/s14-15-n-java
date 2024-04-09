package tech.nocountry.classlodge.course;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name="courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 150)
    @NotNull
    private String name;

    @Column(nullable = false,length = 1000)
    @NotNull
    private String description;

    @Column(nullable = false,length = 150)
    @NotNull
    private String teacherEmail;

    @NotNull
    @Positive
    private Integer totalHours;

    @NotNull
    @Positive
    //@Digits(integer = 7, fraction = 2)  Esta linea me produjo errores de ejecucion
    //la cambie por la que esta abajo
    @Column(columnDefinition = "DOUBLE(6,2)")
    private Double price;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 50)
    private CurrencyEnum currency;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false, length = 50)
    private CategoryEnum category;

    @Column(nullable = false,length = 500)
    @NotNull
    private String thumbnailUrl;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean isPublished;

    @Column(nullable = false, columnDefinition = "TINYINT")
    @NotNull
    private Boolean hasCertification;

}
