import * as React from "react";
import { Card, CardHeader, CardBody, Image } from "@nextui-org/react";
import styles from "../../../styles/ProfeResenas.module.css";
import { Progress } from "@nextui-org/react";
import Rating from "@mui/material/Rating";
import ResenaDetalle from "./ResenaDetalle";

export function ProfeResenas() {
  const [allCursos, setAllCursos] = React.useState([]);

  // Array para almacenar las cards de cada curso con comentarios
  const courseCards = [];

  React.useEffect(()=> { 
  fetch("https://s14-15-n-java.onrender.com/api/v1/course/list")
    .then((response) => {
      if (!response.ok) {
        throw new Error("Error al obtener los datos");
      }
      return response.json();
    })
    .then((data) => {
      // Iterar sobre los cursos
      data.forEach((course) => {
        // Verificar si el curso tiene comentarios
        if (course.comments.length > 0) {
          // Objeto para almacenar la cantidad de comentarios para cada nota (1, 2, 3, 4, 5)
          const commentCounts = {
            1: 0,
            2: 0,
            3: 0,
            4: 0,
            5: 0,
          };

          // Variable para almacenar la suma total de las calificaciones
          let totalRating = 0;

          //agrego un count para las resenas para calcular porcentaje en las barras
          let countResenas = 0;

          // Array para almacenar la lista de comentarios
          const commentsList = [];

          //creo id para los comentarios para el map en el modal
          let commentId = 0;

          // Calcular la cantidad de comentarios para cada nota y sumar las calificaciones
          course.comments.forEach((comment) => {
            commentCounts[comment.ratingAwarded]++;
            totalRating += comment.ratingAwarded;
            countResenas ++ ;
            commentId++;
            // Agregar el comentario a la lista con el nombre del usuario
            commentsList.push({
              userName: comment.email,
              comment: comment.comment,
              courseId: comment.courseId,
              id: commentId,
              rating: comment.ratingAwarded
            });
          });

          // Calcular el promedio total de los comentarios
          const averageRating = totalRating / course.comments.length;

          // Crear la card para el curso
          const courseCard = {
            courseId: course.id,
            courseName: course.name,
            commentCounts: commentCounts,
            averageRating: averageRating,
            commentsList: commentsList,
            totalResenas: countResenas
          };

          // Agregar la card del curso al mapa
          courseCards.push(courseCard);
          setAllCursos(courseCards);
        }
      });
    })
    .catch((error) => {
      console.log("Error:", error);
    });
  }, []);

  return (
    <>
      <div className="flex flex-wrap mt-20 gap-10 items-center justify-center xl:justify-normal p-4">
        {allCursos.map((resena) => (
          <Card
            className="py-4 w-72 h-96 bg-default-300 bg-opacity-50"
            key={resena.courseId}
          >
            <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
              <h4 className="font-bold text-large mb-4 text-default-50">
              {resena.courseName}
              </h4>
              <h5 className="text-default-100 mb-4">Resumen de reseñas</h5>
            </CardHeader>
            <CardBody className={styles.cardBody}>

                <div className={styles.contenedor}>
                {/* div para las barras y puntaje */}
                <div className={styles.barras}>
                  <p>
                    <span>5</span>{" "}
                    <Progress
                      color="success"
                      aria-label="Loading..."
                      value={(resena.commentCounts[5])*100/resena.totalResenas}
                    />
                  </p>
                  <p>
                    <span>4</span>{" "}
                    <Progress
                      color="success"
                      aria-label="Loading..."
                      value={(resena.commentCounts[4])*100/resena.totalResenas}
                    />
                  </p>
                  <p>
                    <span>3</span>{" "}
                    <Progress
                      color="success"
                      aria-label="Loading..."
                      value={(resena.commentCounts[3])*100/resena.totalResenas}
                    />
                  </p>
                  <p>
                    <span>2</span>{" "}
                    <Progress
                      color="success"
                      aria-label="Loading..."
                      value={(resena.commentCounts[2])*100/resena.totalResenas}
                    />
                  </p>
                  <p>
                    <span>1</span>{" "}
                    <Progress
                      color="success"
                      aria-label="Loading..."
                      value={(resena.commentCounts[1])*100/resena.totalResenas}
                    />
                  </p>
                </div>
                <div className={styles.numero}>
                  <p>{resena.averageRating}</p>
                </div>
                <div className={styles.estrellas}>
                  <Rating
                    name="read-only"
                    value={resena.averageRating}
                    readOnly
                    size="small"
                  />
                </div>
                <div className={styles.detalle}>
                  <ResenaDetalle comentarios={resena.commentsList}/>
                </div>
              </div>
            </CardBody>
          </Card>
        ))}
      </div>
    </>
  );
}
