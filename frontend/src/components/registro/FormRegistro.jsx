"use client";
import React from "react";
import { Input, Button, RadioGroup, Radio } from "@nextui-org/react";
import { useRegistro } from "@/hook/useRegistro";
import Image from "next/image";

export const FormRegistro = ({className}) => {
  const { error, handleRegistro, handleChange, newUser } = useRegistro();

  return (
    <section className={className}>
      <form
        className="flex flex-col items-center justify-center space-y-5 w-96 md:w-[450px] rounded-lg p-5 backdrop-blur-sm bg-secondary-800/60 lg:w-full h-full mx-auto py-5"
        onSubmit={handleRegistro}
      >
        {error.state && (
          <p className="text-center p-5 rounded-md bg-secondary-300/80 text-white">
            {error.msg}
          </p>
        )}
        <h1 className="text-secondary-100 text-4xl">Regístrate</h1>
        <RadioGroup
          label="Selecciona tu rol"
          onValueChange={handleChange}
          orientation="horizontal"
          color="warning"
        >
          <Radio 
            className="text-secondary-100 m-2" 
            value="STUDENT"
            name='role'>
            <span className="text-secondary-100">Estudiante</span>
          </Radio>
          <Radio 
            className="text-secondary-100 m-2" 
            value="TEACHER"
            name='role'>
            <span className="text-secondary-100">Docente</span>
          </Radio>
        </RadioGroup>
        <Input
          className="p-5 bg-transparent text-default-50"
          color="warning"
          placeholder="Juan Martin del Potro"
          variant="underlined"
          value={newUser.fullName}
          type="text"
          onChange={handleChange}
          name="fullName"
          id="fullName"
        />
        <Input
          className="p-5 bg-transparent text-default-50"
          color="warning"
          placeholder="tuemail@email.com"
          variant="underlined"
          value={newUser.email}
          type="email"
          onChange={handleChange}
          name="email"
        />
        <Input
          className="p-5 bg-transparent text-slate-50"
          color="warning"
          placeholder="********"
          variant="underlined"
          onChange={handleChange}
          value={newUser.password}
          type="password"
          name="password"
          id="password"
        />
        <Input
          className="p-5 bg-transparent text-slate-50"
          color="warning"
          placeholder="********"
          variant="underlined"
          onChange={handleChange}
          value={newUser.password2}
          type="password"
          name="password2"
        />
        <div className="w-full flex place-content-center">
          <Button
            type="submit"
            variant="flat"
            className="text-default-50 bg-secondary-400 w-3/5 mx-auto rounded-none font-semibold"
          >
            Registrarse
          </Button>
        </div>
      </form>
      <article className="hidden lg:w-1/2 border-secondary-200 rounded-md h-auto">
        <figure className="w-full">
          <Image height={500} width={500} alt="imagen registro" src={""} />
        </figure>
      </article>
    </section>
  );
};
