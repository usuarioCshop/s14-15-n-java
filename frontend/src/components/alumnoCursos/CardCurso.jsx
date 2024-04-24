import { Button, Card, CardFooter, CardHeader } from "@nextui-org/react";
import Image from "next/image";

export const CardCurso = ({course}) => {
    
  return (
    <Card isFooterBlurred className=" h-[300px] max-w-xs border-4 border-secondary-600 lg:hover:scale-105 transition-all cursor-default">
      <CardHeader className="absolute z-10 top-1 flex-col  ">
        <section className="flex w-full  justify-between">
            <div className="w-full h-full">
                <h4 className="text-white/90 font-medium text-lg">
                {course.courseName}
                </h4>
            </div>
            <div className="flex gap-4 items-center">
                {/* <Button isIconOnly color="warning" aria-label="edit">
                <Image
                    alt="Edit icon"
                    className=""
                    src="/icons/pencilIcon.svg"
                    width={25}
                    height={25}
                />
                </Button>
                <Button isIconOnly color="danger" aria-label="trash">
                <Image
                    alt="Delete icon"
                    className=""
                    src="/icons/trashIcon.svg"
                    width={25}
                    height={25}
                />
                </Button> */}
            </div>
        </section>
      </CardHeader>
      <figure className="bg-gradient-radial from-[#3C0E69] to-[#180828] h-full w-full">
        <Image
            removeWrapper
            as={Image}
            alt="Relaxing app background"
            className="z-0 w-full h-full object-contain"
            src="/images/imgCursoTest.jpg"
            width={100}
            height={100}
        />
      </figure>
      <CardFooter className="absolute bg-black/70 bottom-0 z-10 border-t-1 border-default-600">
        <div className="flex flex-grow gap-2 items-center">
          <Image
            alt="Breathing app icon"
            className="rounded-full w-10 h-11 bg-black"
            src="/images/Record.png"
            width={100}
            height={100}
          />
          <div className="flex flex-col">
            <p className="text-sm text-white/60">Docente:</p>
            <p className="text-sm text-white/60">Ing. Victoria Heredia</p>
          </div>
        </div>
        <button className="rounded-full text-white border-2 border-secondary-100 p-2 hover:bg-secondary-300 transition-all">
          Ver detalle
        </button>
      </CardFooter>
    </Card>
  );
};
