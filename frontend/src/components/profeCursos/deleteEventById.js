import Swal from "sweetalert2";

export const handleDelete = async (id, token, setAllCursos) => {
 
  Swal.fire({
    title: "¿Seguro que quieres eliminar este curso?",
    text: "¡Tendrás que volver a crearlo!",
    icon: "warning",
    showCancelButton: true,
    confirmButtonColor: "#3085d6",
    cancelButtonColor: "#d33",
    cancelButtonText: "Cancelar",
    confirmButtonText: "Sí, eliminar curso",
  }).then(async (result) => {
    if (result.isConfirmed) {
      try {
        const response = await fetch(`https://s14-15-n-java.onrender.com/api/v1/course/enable/${id}`, {
          method: 'PUT',
          headers: {
            'Content-Type': 'application/json',
            authorization: `Bearer ${token}`
          },
        });
        if (response.ok) {
          setAllCursos((prevCursos) => prevCursos.filter((curso) => curso.id !== id));
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Curso eliminado exitosamente",
            showConfirmButton: false,
            timer: 1500,
          });
        } else {
          console.error('Error al intentar eliminar el curso');
        }
      } catch (error) {
        console.error('Error de red:', error.message);
      }
    }
  });
};

