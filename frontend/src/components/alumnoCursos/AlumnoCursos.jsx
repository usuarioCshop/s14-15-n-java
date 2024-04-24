import React from 'react'
import { AlumnoCursosCard } from "..";
import { formatCategory } from "@/services/getCoursesUser";

export const AlumnoCursos = ({cursos}) => {


  return (
    <section className="w-full h-full text-white grid grid-cols-1 gap-10 md:grid-cols-2 place-items-center place-content-start p-10">
      {
        cursos.map((curso) => {
          return (
            <AlumnoCursosCard
              key={curso.courseId}
              id={curso.courseId}
              courseName={curso.courseName}
              description={curso.description}
              category={formatCategory(curso.category)}
              thumbnailUrl={curso.thumbnailUrl}
            />
          )
        })
      }
    </section>
  )
}