'use client'
import Image from 'next/image'
import React from 'react'

export const DictaTuCursoHero = () => {
  return (
    <div className='flex align-middle justify-center w-11/12 mx-auto my-24'>
      <div className='w-2/4 mx-auto'>
        <div className='flex flex-col align-middle justify-center w-3/4 mx-auto'>
          <h1 className="text-white text-[45px] text-left">
            Subí tu curso a
          </h1>
          <span className="text-[#7828C8] text-[45px] text-left"> ClassLodge</span>
          <span className="text-white mt-8">Unite a una comunidad de más de 1000 estudiantes y profesores.</span>
          <span className="text-white text-center mt-8">¿Estás list@ para inspirar a otros?</span>
        </div>
      </div >
      <div className='w-2/4 flex align-middle justify-center'>
        <Image
          src="/images/Freelancer.png"
          width={307}
          height={307}
          alt="hero"
          className="flex justify-end"
        />
      </div>
    </div>
  )
}
