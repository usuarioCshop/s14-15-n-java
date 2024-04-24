'use client'
import React from "react";
import { Button } from "@nextui-org/react";
import { userStore } from "@/store/userStore"
import { useState, useEffect } from "react";
import { CursosProfeCard, ProfeCursoSkeleton } from "..";


export function ProfeCursos() {

  const { user } = userStore();
  const [allCursos, setAllCursos] = useState([]);

  const getAllCursos = async () => {
    try {
      const response = await fetch(`https://s14-15-n-java.onrender.com/api/v1/course/list`, {
        method: 'GET'
      });
      const result = await response.json();
      setAllCursos(result);
    } catch (error) {
      console.error('Error al obtener los cursos:', error);
    }
  };

  useEffect(() => {
    getAllCursos();
  }, []);


  return (
    <main className="lg:h-[1000px]">
      <div className=" text-white p-4 relative">
        <section className="z-[-2] absolute top-0 right-40 flex w-[1000px] h-[1000px] rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] "></section>
        <Button className="bg-white mb-10">Crear nuevo curso</Button>
        <section>
          <section className="grid md:grid-cols-2 gap-10">
            {allCursos.length > 0 ? (
              allCursos.map((curso) => {
                if (curso.teacherEmail === user.email && curso.isPublished) {
                  return (
                    <CursosProfeCard
                      key={curso.id}
                      teacherName={user.fullName}
                      courseName={curso.name}
                      id={curso.id}
                      setAllCursos={setAllCursos}
                    >
                      {curso.name}
                    </CursosProfeCard>
                  );
                }
                return null; // No renderizar nada si el usuario no tiene cursos
              })
            ) : (
              <>
                <ProfeCursoSkeleton />
                <ProfeCursoSkeleton />
                <ProfeCursoSkeleton />
                <ProfeCursoSkeleton />
              </>
            )}
          </section>
        </section>
      </div>
    </main>
  );
}

