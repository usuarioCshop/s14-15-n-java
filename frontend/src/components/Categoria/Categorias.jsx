import React from "react";
import Image from 'next/image'
import {Card, CardBody, CardFooter} from "@nextui-org/react";
import img1 from '../../../public/images/1.webp' 
import img2 from '../../../public/images/2.webp' 
import img3 from '../../../public/images/3.webp' 
import img4 from '../../../public/images/4.webp' 
import img5 from '../../../public/images/5.webp' 
import img6 from '../../../public/images/6.webp' 
import img7 from '../../../public/images/7.webp' 
import img8 from '../../../public/images/8.webp' 


export const Categorias = () => {

    const list = [
        {
          title: "Desarrollo Web",
          img: img1,
        },
        {
          title: "Programación",
          img: img2,
        },
        {
          title: "Diseño Gráfico",
          img: img3,

        },
        {
          title: "Marketing Digital",
          img: img4,
        },
        {
          title: "Finanzas Personales",
          img: img5,

        },
        {
          title: "Idiomas",
          img: img6,
        },
        {
          title: "Fotografía",
          img: img7,
        },
        {
          title: "Salud y Bienestar",
          img: img8,

        },
      ];

  return (
    <>
    <h1 className="text-center text-default-50 text-3xl">Categorías</h1>
    <p className="text-center text-default-200">Explora los campos de aprendizaje mas demandados</p>

    <div className="flex justify-center flex-wrap max-w-[1128px] mx-auto" style={{ marginTop: '50px'}}>
      {list.map((item, index) => (
        <Card className="w-40 m-4 bg-secondary-100" style={{ minWidth:'209px', overflow: 'hidden', borderRadius: '35px 0 35px 0' }} shadow="sm" key={index} isPressable/*  onPress={() => console.log("item pressed")} */>
          <CardBody className="overflow-visible p-0 w-200px ">
            <Image                     
              shadow="sm"
              radius="lg"
              alt={item.title}
              className="w-full object-cover h-[140px]"
              src={item.img}
              quality={100} 
            />
          </CardBody>
          <CardFooter className="text-xs justify-center">
            <b>{item.title}</b>
          </CardFooter>
        </Card>
      ))}
    </div>
    </>
    
  )
}
