
import React from 'react'
import { QuestionsList } from "./QuestionsList";
import questions from './questions.json'

export const FreqAsks = () => {
    
  return (
    <section className='flex justify-center items-center flex-col gap-5 p-5 space-y-5 my-10'>
        <h2 className='text-default-100 text-3xl'>Preguntas Frecuentes</h2>
        <p className='text-default-100'>Preguntas generales referentes a nuestro sistema y medios de pagos.</p>
        <QuestionsList questions={questions}/>
    </section>
  )
}
