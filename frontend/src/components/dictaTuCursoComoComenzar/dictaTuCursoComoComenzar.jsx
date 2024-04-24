'use client'
import React from 'react'
import { Tabs, Tab, Card, CardBody } from "@nextui-org/react";
import Image from 'next/image';

export const DictaTuCursoComoComenzar = () => {
    return (
        <div className='flex flex-col align-middle justify-center w-11/12 mx-auto my-24'>
            <h2 className="text-white text-center text-4xl py-8">Como Comenzar</h2>
            <Tabs className='w-1/2 mx-auto' aria-label="Options"
                classNames={{
                    tabList: "w-full bg-[#301050] ",
                    cursor: "bg-[#481878]",
                    tab: "",
                    tabContent: "group-data-[selected=true]:text-[#F4F4F5]"
                }}
            >
                <Tab key="planea" title="Planea tu programa">
                    <Card className='w-4/5 mx-auto align-middle justify-center items-center bg-[#301050] text-white py-12 h-96'>
                        <CardBody className='flex flex-row align-middle justify-center items-center'>
                            <div className='w-2/3 flex align-middle justify-center items-center'>
                                <span className='w-4/5 px-8 mx-auto'>¡Es hora de convertir tus ideas en realidad! En esta etapa, te invitamos a dar forma a tu curso desde cero. Desde la creación de los objetivos hasta la organización del contenido, te brindamos la inspiración y las herramientas necesarias para diseñar un programa único que cautivará a tus futuros estudiantes.</span>
                            </div>
                            <div className='w-1/3 flex items-center'>
                                <Image
                                    src="/images/Processing.png"
                                    width={260}
                                    height={260}
                                    alt="Processing"
                                    className=""
                                />
                            </div>
                        </CardBody>
                    </Card>
                </Tab>
                <Tab key="graba" title="Graba tu material">
                    <Card className='w-4/5 mx-auto align-middle justify-center items-center bg-[#301050] text-white py-12 h-96'>
                        <CardBody className='flex flex-row align-middle justify-center items-center'>
                            <div className='w-2/3 flex align-middle justify-center items-center'>
                                <span className='w-4/5 px-8 mx-auto'>¡Prepárate para ser el protagonista de tu curso! En esta fase, te animamos a dar rienda suelta a tu creatividad y compartir tus conocimientos con el mundo. Con consejos prácticos y recursos útiles, te ayudaremos a crear material que no solo eduque, ¡sino que también inspire a tus alumnos a alcanzar sus metas!</span>
                            </div>
                            <div className='w-1/3 flex items-center'>
                                <Image
                                    src="/images/Record.png"
                                    width={260}
                                    height={260}
                                    alt="Record"
                                    className=""
                                />
                            </div>
                        </CardBody>
                    </Card>
                </Tab>
                <Tab key="lanza" title="Lanza tu Curso">
                    <Card className='w-4/5 mx-auto align-middle justify-center items-center bg-[#301050] text-white py-12 h-96'>
                        <CardBody className='flex flex-row align-middle justify-center items-center'>
                            <div className='w-2/3 flex align-middle justify-center items-center'>
                                <span className='w-4/5 px-8 mx-auto'>¡Es momento de brillar! En esta etapa emocionante, te acompañamos en el emocionante viaje de lanzar tu curso al mundo. Desde la creación de una estrategia de marketing hasta la conexión con tu audiencia ideal, te proporcionamos las herramientas y la motivación necesarias para que tu curso sea un éxito rotundo. ¡No esperes más, el mundo está esperando tus conocimientos!</span>
                            </div>
                            <div className='w-1/3 flex items-center'>
                                <Image
                                    src="/images/Curso.png"
                                    width={260}
                                    height={260}
                                    alt="Curso"
                                    className=""
                                />
                            </div>
                        </CardBody>
                    </Card>
                </Tab>
            </Tabs>
        </div>
    )
}
