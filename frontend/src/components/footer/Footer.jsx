import React from 'react';
import {Divider} from "@nextui-org/react";
import Image from 'next/image';
import Link from 'next/link';

export const Footer = () => {
  return (
    <footer className="mt-20 px-5 bg-[#121212] text-white w-full h-[190px] md:h-[180px] flex items-center justify-center">
      <section className="w-full md:w-[1366px] flex flex-col">
        <section className='flex items-center justify-center md:justify-between p-2'>
          <div className='flex gap-5 md:gap-20'>
            <Link href={'/'}>
              <figure className='hidden md:block'>
                <Image src='/icons/logo_blanco_lila.webp'
                  width={150}
                  height={50}
                  alt='logo' />
              </figure>
            </Link>
            <ul className="flex items-center justify-center gap-10 ">
              <li>
                <Link href='#'>Cursos</Link>
              </li>
              <li>
                <Link href='#'>Categorías</Link>
              </li>
              <li>
                <Link href='#'>Dicta tu Curso</Link>
              </li>
            </ul>
          </div>
          <div>
            <ul className=" hidden md:flex sm:gap-6 lg:gap-10">
              <Image src="/icons/twitter-xLogo.svg" width={25} height={25} alt="Twitter" />
              <Image src="/icons/instagramLogo.svg" width={25} height={25} alt="instagram" />
              <Image src="/icons/youtubeLogo.svg" width={25} height={25} alt="youtube" />
              <Image src="/icons/discordLogo.svg" width={25} height={25} alt="discord" />
            </ul>
          </div>
        </section>
        <Divider className="my-3 bg-slate-300" />
        <section className='p-2 flex flex-col justify-center md:justify-left items-center md:items-start gap-4'>
          <ul className=" flex md:hidden gap-10">
            <Image src="/icons/twitter-xLogo.svg" width={25} height={25} alt="Twitter" />
            <Image src="/icons/instagramLogo.svg" width={25} height={25} alt="instagram" />
            <Image src="/icons/youtubeLogo.svg" width={25} height={25} alt="youtube" />
            <Image src="/icons/discordLogo.svg" width={25} height={25} alt="discord" />
          </ul>
        <section className='mt-3'>
          <p className='flex items-center justify-center text-left md:text-center'>Copyright &copy; 2024 - ClassLodge </p>
        </section>
        </section>
      </section>
    </footer>
  );
};
