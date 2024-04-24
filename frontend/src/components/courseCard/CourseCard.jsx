import { Card, CardHeader, CardBody, Image, Button } from '@nextui-org/react';

export const CourseCard = ({
  nombre_docente,
  categoria_curso,
  titulo_curso,
  descripcion,
  urlImage
}) => {
  return (
    <Card className="p-2 w-[340px] bg-white bg-opacity-10 rounded-2xl text-white">
      <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
        <p className="text-tiny uppercase font-bold">{nombre_docente}</p>
        <small className="text-default-500">{categoria_curso}</small>
        <h4 className="font-bold text-large">{titulo_curso}</h4>
      </CardHeader>
      <CardBody className="overflow-visible py-2">
        <Image
          alt="Card background"
          className="object-cover rounded-xl"
          src={urlImage}
          width={300}
        />
        <p className="text-sm pt-2">{descripcion}</p>
        <Button className="bg-secondary-500 w-10 text-white ml-56 mt-6">
          + Info
        </Button>
      </CardBody>
    </Card>
  );
};
