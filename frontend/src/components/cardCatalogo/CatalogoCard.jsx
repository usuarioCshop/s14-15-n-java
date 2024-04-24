import React from "react";
import {Card, CardHeader, CardBody, Image, Button} from "@nextui-org/react";
import Link from "next/link";


export const CatalogoCard = ({ name, category, price, currency, id }) => {

  return (
    <div className="w-[300px]">
      <Card className="py-4 bg-white bg-opacity-30">
        <CardHeader className="pb-0 pt-2 px-4 flex-col items-start">
          <p className="text-tiny uppercase font-bold text-white">
            Docente del curso
          </p>
          <small className="text-default-500">{category}</small>
          <h4 className="font-bold text-large text-white">{name}</h4>
        </CardHeader>
        <CardBody className="overflow-visible py-2">
          <Image
            alt="Card background"
            className="object-cover rounded-xl"
            src="/images/hero-card-complete.jpeg"
            width={270}
          />
          <section className="flex justify-around items-center mt-4">
            <div>
              <p className="text-white text-lg">
                {price} {currency}
              </p>
            </div>
            <Link
              href={`/profesorDashboard/curseDetails/${id}`}
              className=" text-white p-3 rounded-xl font-bold hover:text-white bg-secondary-600 hover:bg-secondary-400"
            >
              + info
            </Link>
          </section>
        </CardBody>
      </Card>
    </div>
  );
};
