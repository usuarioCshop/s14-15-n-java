import React from 'react'
import Image from 'next/image'
import { FormRegistro } from '@/components'

export default function Registro(){
  return (
    <div className='w-full mx-auto flex items-center justify-center'>
        <FormRegistro className='flex w-full lg:w-1/2 p-5' />
        <article className='lg:flex items-center justify-center hidden w-1/2 h-screen'>
          <Image src='/images/heroImg.png' width={100} height={100} alt='registro logo'className='w-96 h-full object-contain' priority/>
        </article>
    </div>
  )
}
