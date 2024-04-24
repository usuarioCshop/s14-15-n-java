import React from 'react';
import CourseDetailSkeleton from '../skeletons/CourseDetailSkeleton';
import Image from 'next/image';
import Link from 'next/link';
import {ScrollShadow} from "@nextui-org/react";

const CurseInfo = ({ curseData }) => {
  return (
    <div>
       {curseData ? (
        <section className=" m-3 relative md:h-[800px] md:flex text-white mt-20 rounded-xl bg-white bg-opacity-10 p-3">
          <section className="z-[-2] absolute top-0 right-40 flex w-[1000px] h-[1000px] rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] "></section>
          <Link href={`/catalogo`} className="absolute bg-secondary-600 p-2 rounded-xl top-10 left-10 hover:bg-secondary-400">
            Volver a Catálogo
          </Link>
          <section className="md:w-2/3">
            <section className="p-5">
              <Image
                src={"/images/imgCursoTest.jpg"}
                width={800}
                height={400}
                alt="Imagen del curso"
                className="object-cover w-full h-full rounded-xl"
              />
            </section>
            <ScrollShadow
              hideScrollBar
              className="p-5 lg:h-[300px] hidden md:block"
            >
              {curseData?.comments?.length > 0 ? (
                <h1 className=" text-xl font-bold mb-4 ">Comentarios:</h1>
              ) : (
                <h1 className=" text-xl font-bold mb-4 ">
                  Aún no hay comentarios
                </h1>
              )}
              <div>
                {curseData?.comments?.map((comment) => (
                  <div
                    key={comment.id}
                    className="rounded-xl bg-white bg-opacity-30 p-2 flex flex-col mb-2"
                  >
                    <div className="flex gap-4">
                      <p>{comment.email}</p>
                      <p>{comment.postDate}</p>
                    </div>
                    <p>{comment.comment}</p>
                  </div>
                ))}
              </div>
            </ScrollShadow>
          </section>
          <section className="md:w-1/3 p-5 flex flex-col gap-5">
            <h1 className="text-2xl font-bold text-center bg-white bg-opacity-80 text-secondary-500 rounded-lg p-2">
              {curseData.name}
            </h1>
            <div className="flex flex-col bg-white text-secondary-500 bg-opacity-80 rounded-lg p-2">
              <h1 className="text-center mb-4 text-xl">
                Información del curso
              </h1>
              <p>Duracion del curso: {curseData.totalHours} horas</p>
              <p>
                Precio del curso: {curseData.price} {curseData.currency}
              </p>
            </div>
            <ScrollShadow
              hideScrollBar
              className="bg-white text-secondary-500 bg-opacity-80 rounded-lg p-2 max-h-[400px]"
            >
              <h1 className="text-center mb-4  text-xl">
                Descripción del curso
              </h1>
              <p>{curseData.description}</p>
            </ScrollShadow>
            <div className="bg-white text-secondary-500 bg-opacity-80 rounded-lg p-2">
              <h1 className="text-center mb-4  text-xl">
                Información del Profesor
              </h1>
              <p>Email: {curseData.teacherEmail}</p>
            </div>
          </section>
          <ScrollShadow className="p-5 md:hidden">
            {curseData?.comments?.length > 0 ? (
              <h1 className=" text-xl font-bold mb-4 ">Comentarios:</h1>
            ) : (
              <h1 className=" text-xl font-bold mb-4 ">
                Aún no hay comentarios
              </h1>
            )}
            <div>
              {curseData?.comments?.map((comment) => (
                <div
                  key={comment.id}
                  className="rounded-xl bg-white bg-opacity-30 p-2 flex flex-col mb-2"
                >
                  <div className="flex gap-4">
                    <p>{comment.email}</p>
                  </div>
                  <p>{comment.comment}</p>
                </div>
              ))}
            </div>
          </ScrollShadow>
        </section>
      ) : (
        <CourseDetailSkeleton />
      )}
    </div>
  );
};

export default CurseInfo;