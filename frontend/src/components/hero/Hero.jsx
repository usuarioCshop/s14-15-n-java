import React from 'react';
import Image from 'next/image';
import HeroSearchBar from './HeroSearchBar'


export const Hero = () => {
  return (
    <section className="p-5 mt-16 md:mt-0 relative mx-auto max-w-[1366px] h-[706px] bg-[#180828] flex flex-col items-center justify-evenly">
      <section className="z-1 absolute right-0 bottom-24 flex w-[750px] h-[700px] rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] "></section>
      <section className="z-10 md:w-[742px] lg:w-[942px] h-[313px] flex flex-col md:flex-row items-center">
        <div className=" w-full lg:w-[618px] h-[242px] flex justify-center items-center">
          <h1 className="text-white text-[45px] text-center">
            Adquirí nuevas
            <strong className="text-[#7828C8]"> habilidades</strong> sin salir de
            tu <strong className="text-[#7828C8]">casa</strong>
          </h1>
        </div>
        <div>
          <Image
            src="/images/heroImg.png"
            width={307}
            height={307}
            alt="hero"
            className="flex justify-end"
          />
        </div>
      </section>
      <HeroSearchBar />
    </section>
  );
};