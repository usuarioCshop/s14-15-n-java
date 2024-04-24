'use client'
import React from 'react'
import { Button } from "@nextui-org/react";
import Link from 'next/link';

export const DictaTuCursoCTA = () => {
    return (
        <div className='flex flex-col items-center align-middle justify-center bg-[#E4E4E7]/[.2]'>
            <div className='flex flex-col text-4xl text-white text-center w-1/2 mx-auto py-24'>
                <h2>
                    Comparte tu <strong className='text-[#7828C8]'>pasión</strong> y
                </h2>
                <h2>
                    <strong className='text-[#7828C8]'>enseña</strong> lo que sabes
                </h2>
                <div className='flex flex-col space-y-8 mt-8'>
                    <span className='text-lg w-4/5 mx-auto'>No necesitas experiencia previa para convertirte en instructor de ClassLodge.  Todo lo que necesitas es pasión por tu tema y la voluntad de compartir  tu conocimiento con los demás</span>
                    <Button className="bg-[#E4E4E7]/[.2] text-white text-xl w-2/5 mx-auto" radius="large">
                        <Link color="foreground" href="/registro" className="text-default-50">
                            Comenzá Ahora
                        </Link>
                    </Button>
                </div>
            </div>
        </div>
    )
}
