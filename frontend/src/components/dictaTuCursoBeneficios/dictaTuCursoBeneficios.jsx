'use client'
import Image from 'next/image'
import React from 'react'

export const DictaTuCursoBeneficios = () => {
  return (
    <div className='flex flex-col align-middle justify-center w-11/12 mx-auto my-24'>
      <h2 className="text-white text-center text-4xl py-8">Beneficios</h2>
      <div className='flex align-middle justify-center space-x-16 py-12'>
        <div className='flex flex-col align-middle justify-center text-white text-center space-y-6 w-1/4'>
          <Image
            src="/icons/Teach.svg"
            width={125}
            height={125}
            alt="Teach"
            className="mx-auto h-1/2"
          />
          <div className="flex flex-col mx-auto h-1/2">
            <h3 className='font-bold'>Enseña a tu manera</h3>
            <span className='mt-4'>Arma el curso de la forma que tu creas mejor e incluyendo el contenido que prefieras.</span>
          </div>
        </div>

        <div className='flex flex-col align-middle justify-center text-white text-center space-y-6 w-1/4'>
          <Image
            src="/icons/Inspiration.svg"
            width={125}
            height={125}
            alt="Inspire"
            className="mx-auto h-1/2"
          />
          <div className="flex flex-col mx-auto h-1/2">
            <h3 className='font-bold'>Conviertete en una inspiración</h3>
            <span className='mt-4'>Ispira a tus alumnos a perseguir sus pasiones con tus cursos.</span>
          </div>
        </div>

        <div className='flex flex-col align-middle justify-center text-white text-center space-y-6 w-1/4'>
          <Image
            src="/icons/Reward.svg"
            width={125}
            height={125}
            alt="Grow"
            className="mx-auto h-1/2"
          />
          <div className="flex flex-col mx-auto h-1/2">
            <h3 className='font-bold'>Crece profesionalmente</h3>
            <span className='mt-4'>Expande tu red, establece autoridad en tu area y gana dinero mientras lo haces.</span>
          </div>
        </div>
      </div>
    </div>
  )
}
