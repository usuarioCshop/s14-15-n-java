export const getCursos = async (email, token) => {
    try {
      const response = await fetch(`https://s14-15-n-java.onrender.com/api/v1/user/getcourses/${email}/true`, {
        method: 'GET',
        headers: {
          authorization: `Bearer ${token}`
        }
      });
      const result = await response.json();
      // Obtenemos los detalles adicionales de cada curso
      const cursosConDetalles = await Promise.all(result.map(async (curso) => {
        const cursoDetailsResponse = await fetch(`https://s14-15-n-java.onrender.com/api/v1/course/${curso.courseId}`, {
          method: 'GET'
        });
        const cursoDetails = await cursoDetailsResponse.json();
        // Combinamos los detalles adicionales con el curso
        return { ...curso, description: cursoDetails.description, category: cursoDetails.category, thumbnailUrl: cursoDetails.thumbnailUrl };
      }));
      return cursosConDetalles
    } catch (error) {
      console.error('Error al obtener los cursos:', error);
    }
  };

export const formatCategory = (category) => {
    switch (category) {
      case "DESARROLLO_WEB":
        return "Desarrollo web";
      case "PROGRAMACION":
        return "Programación";
      case "DISENIO_GRAFICO":
        return "Diseño gráfico";
      case "MARKETING_DIGITAL":
        return "Marketing digital";
      case "FINANZAS_PERSONALES":
        return "Finanzas personales";
      case "IDIOMAS":
        return "Idiomas";
      case "FOTOGRAFIA":
        return "Fotografía";
      case "MUSICA":
        return "Música";
      case "SALUD_Y_BIENESTAR":
        return "Salud y bienestar";
      case "COCINA_Y_GASTRONOMIA":
        return "Cocina y gastronomía";
      case "ARTE_Y_MANUALIDADES":
        return "Arte y manualidades";
      case "NEGOCIOS_Y_EMPRENDIMIENTO":
        return "Negocios y emprendimiento";
      case "CIENCIAS_DE_DATOS":
        return "Ciencias de datos";
      case "DESARROLLO_PERSONAL":
        return "Desarrollo personal";
      case "EDUCACION_INFANTIL":
        return "Educación infantil";
      case "CIENCIAS_NATURALES":
        return "Ciencias naturales";
      default:
        return category;
    }
  };