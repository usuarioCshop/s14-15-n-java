import React from "react";
import {Card, CardHeader, CardBody, CardFooter, Image, Button} from "@nextui-org/react";
import { handleDelete } from "./deleteEventById";
import { userStore } from "@/store/userStore";
import Link from "next/link";



export function CursosProfeCard({ teacherName, courseName, id, setAllCursos }) {

  const { token } = userStore();

  return (
    <Card isFooterBlurred className=" h-[300px]">
      <CardHeader className="absolute z-10 top-1 flex-col  ">
        <section className="flex w-full  justify-between">
          <div>
            <h4 className="text-white/90 font-medium text-2xl">{courseName}</h4>
          </div>
          <div className=" flex gap-4">
            <div className="flex gap-4 items-center">
              <Button isIconOnly color="warning" aria-label="edit">
                <Image
                  alt="Edit icon"
                  className="rounded-full"
                  src="/icons/pencilIcon.svg"
                  width={30}
                />
              </Button>
              <Button
                isIconOnly
                color="danger"
                aria-label="trash"
                onClick={() => handleDelete(id, token, setAllCursos)}
              >
                <Image
                  alt="Delete icon"
                  className="rounded-full"
                  src="/icons/trashIcon.svg"
                  width={30}
                />
              </Button>
            </div>
          </div>
        </section>
      </CardHeader>
      <Image
        removeWrapper
        alt="Relaxing app background"
        className="z-0 w-full h-full object-cover"
        src="/images/imgCursoTest.jpg"
      />
      <CardFooter className="absolute bg-black/40 bottom-0 z-10 border-t-1 border-default-600 dark:border-default-100">
        <div className="flex flex-grow gap-2 items-center">
          <Image
            alt="Breathing app icon"
            className="rounded-full w-10 h-11 bg-black"
            src="/images/breathing-app-icon.jpeg"
          />
          <div className="flex flex-col">
            <p className="text-sm text-white/60">Docente:</p>
            <p className="text-sm text-white/60">{teacherName}</p>
          </div>
        </div>
        <Link href={`/profesorDashboard/curseDetails/${id}`} className="text-sm text-white font-bold bg-secondary-500 hover:bg-secondary-400 p-3 rounded-xl">
          Ver Detalles
        </Link>
      </CardFooter>
    </Card>
  );
}
