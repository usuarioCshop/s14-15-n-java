"use client";

import { userStore } from "@/store/userStore";
import React from "react";
import { ProfileCard } from "..";
import { Card } from "@nextui-org/react";

export function AlumnoPerfil({cursos}) {
  const { user } = userStore();

  return (
    <section className="h-full min-h-screen">
      <article className=" text-white p-4 gap-8 relative">
        <section className="z-[-2] absolute top-0 -right-40 md:flex w-full h-full rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] hidden"></section>
        <section className="z-10 p-4 gap-8 flex flex-col items-center lg:items-stretch lg:flex-row">
          <article className="rounded-xl z-10 max-w-[400px] lg:h-full mx-auto">
            <ProfileCard user={user} />
          </article>
          <article className="max-w-[400px] lg:max-w-none lg:w-2/3 z-10 rounded-xl gap-8">
            <Card className=" p-5 h-full rounded-xl flex flex-col gap-5 bg-white bg-opacity-10 text-twhite">
              <h1 className="text-2xl text-secondary-50 font-bold">Sobre mi</h1>
              
              <p className="text-secondary-100">
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                Asperiores rerum, molestiae atque maxime tenetur quibusdam culpa
                ut! Itaque harum suscipit, corporis, tempora ex fugiat ducimus
                vel sed non ab tenetur. Lorem ipsum dolor sit amet consectetur
                adipisicing elit. Ab ut quibusdam quia, totam excepturi
                distinctio magnam? Animi, voluptas dicta quas reiciendis ipsam,
                neque, quaerat nulla dolore praesentium exercitationem atque
                numquam.
              </p>
              <article className="w-1/2 mx-auto min-h-10 rounded-md bg-secondary-500 p-10 text-center space-y-5">
                <h4 className="text-secondary-50 font-semibold">
                  Cursos en cuenta:
                </h4>
                <p className="font-bold text-3xl">{cursos.length}</p>
              </article>
            </Card>
          </article>
        </section>
      </article>
    </section>
  );
}
