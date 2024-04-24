import React from 'react';
import {Input} from "@nextui-org/react";
import Image from 'next/image';

const HeroSearchBar = () => {
  return (
    <section className="mt-52 md:mt-0 z-10 md:w-[550px] h-[140px] flex flex-col justify-evenly">
      <h1 className="text-white text-center text-[25px] md:text-[27px]">
        ¿Qué quieres aprender hoy?
      </h1>
      <div>
        <Input
          placeholder="Busca un curso"
          className="w-[300px] mx-auto border border-[#7828C8] rounded-lg"
          classNames={{
            input: ["text-white"],
            inputWrapper: ["bg-white bg-opacity-10 rounded-lg"],
          }}
          endContent={
            <Image
              src="icons/searchIcon.svg"
              width={25}
              height={25}
              alt="hero"
              className="flex justify-end"
            />
          }
        />
      </div>
    </section>
  );
};

export default HeroSearchBar;