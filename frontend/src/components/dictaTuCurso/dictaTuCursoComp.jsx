import React from 'react'
import { Link } from "@nextui-org/react";
import { Button } from "@nextui-org/react";
import Image from 'next/image';

export const DictaTuCursoComp = () => {
    return (
        <div className='flex align-middle min-h-96 bg-[#E4E4E7]/[.2] my-24'>
            <div className="flex w-9/12 mx-auto h-[90%] my-24">
                <div className='w-3/5'>
                    <Image
                        src="/images/Online learning.png"
                        width={350}
                        height={350}
                        alt="dicta tu curso"
                        className="mx-auto"
                        href="https://storyset.com/online"
                    />
                </div>
                <div className='flex w-2/5'>
                    <div className='h-[80%] my-auto flex flex-col align-middle justify-center space-y-16'>
                        <h2 className='text-white text-5xl text-center'>Dicta tu Curso</h2>
                        <span className='text-white text-center'>
                            Hacelo como mas te guste y compartí tus conocimientos con una comunidad de mas de 2000 estudiantes, profesionales y entuciastas.
                        </span>
                        <Button className="bg-[#E4E4E7]/[.2] text-white text-xl w-3/5 mx-auto" radius="large">
                            <Link color="foreground" href="/dictaTuCurso" className="text-default-50">
                                Comenzá Ahora
                            </Link>
                        </Button>
                    </div>
                </div>
            </div>
        </div>
    )
}
