import { Button } from '@nextui-org/react';
import { CourseCard } from '../courseCard/CourseCard';
const db = [
  {
    nombre_docente: 'John Smith',
    categoria_curso: 'Desarrollo Web',
    titulo_curso: 'Introducción a HTML y CSS',
    descripcion:
      'Aprende los fundamentos de HTML y CSS para crear páginas web modernas y responsivas.',
    urlImage: '/images/1.webp',
  },
  {
    nombre_docente: 'David Johnson',
    categoria_curso: 'Diseño Gráfico',
    titulo_curso: 'Adobe Illustrator Avanzado',
    descripcion:
      'Domina las técnicas avanzadas de Adobe Illustrator para crear ilustraciones profesionales y diseños de alta calidad.',
    urlImage: '/images/2.webp',
  },
  {
    nombre_docente: 'Carlos Garcia',
    categoria_curso: 'Idiomas',
    titulo_curso: 'Inglés Conversacional',
    descripcion:
      'Mejora tu fluidez en inglés practicando conversaciones cotidianas sobre temas diversos, desde viajes hasta negocios.',
    urlImage: '/images/3.webp',
  },
];
export const CourseSection = () => {
  return (
    <div className="flex items-center w-full flex-col">
      <h3 className="text-center text-default-50 text-3xl mb-3">Cursos</h3>
      <p className="text-center text-default-50 text-xl">
        Nuestros cursos destacados
      </p>
      <div className="flex flex-wrap mt-14 gap-10 items-center justify-center xl:justify-normal p-4">
        {db.map((data) => (
          <CourseCard key={crypto.randomUUID()} {...data} />
        ))}
      </div>
      <Button className="bg-secondary-500 w-28 text-white m-10">Ver más</Button>
    </div>
  );
};
