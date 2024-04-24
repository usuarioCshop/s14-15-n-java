'use client'
import React from 'react'
import { Accordion, AccordionItem } from "@nextui-org/accordion";

export const QuestionsList = ({questions}) => {
    const itemClasses = {
        base: "py-0 w-full",
        title: "font-normal text-medium text-white",
        trigger: "px-2 py-0 rounded-lg h-14 flex items-center",
        indicator: "text-medium",
        content: "text-small px-2 leading-9",
      };
  return (
    <Accordion variant='light' className='bg-purple-950/30 backdrop-blur-md md:w-[700px] w-full rounded-md p-2' itemClasses={itemClasses}>
        {
            questions.map(question => (
                <AccordionItem key={question.id} title={question.pregunta} aria-label='Que medios de pago aceptan?' className='bg-transparent my-5'>
                    <p className='text-slate-300'>{question.respuesta}</p>
                </AccordionItem>
            ))
        }
    </Accordion>
  )
}
