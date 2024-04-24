'use client'
import React from "react";
import {Card} from "@nextui-org/react";

import { userStore } from "@/store/userStore";
import { ProfileCard } from "..";

export const ProfePerfil = () => {
  const { user } = userStore(); 

  return (
    <main className="h-screen">
      <div className=" text-white p-4 gap-8 relative">
        <section className="z-[-2] absolute top-0 right-40 flex w-full h-screen rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] "></section>
        <section className="z-10 p-4 gap-8 flex flex-col items-center lg:items-stretch lg:flex-row">
          <section className="rounded-xl z-10 max-w-[400px] lg:h-full">
            <ProfileCard user={user}/>
          </section>
          <section className="max-w-[400px] lg:max-w-none lg:w-2/3 z-10 rounded-xl gap-8  ">
            <Card className=" p-5 h-full rounded-xl flex flex-col gap-5 bg-white bg-opacity-20 text-twhite">
              <h1 className="text-2xl text-[#7828C8] font-bold">Descripción</h1>
              <p>
                dolor sit amet consectetur adipisicing elit. Ab ut
                quibusdam quia, totam excepturi distinctio magnam? Animi,
                voluptas dicta quas reiciendis ipsam, neque, quaerat nulla
                dolore praesentium exerc itationem atque numquam.
              </p>
              <p>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit.
                Asperiores rerum, molestiae atque maxime tenetur quibusdam culpa
                ut! Itaque harum suscipit, corporis, tempora ex fugiat ducimus
                vel sed non ab tenetur. Lorem ipsum dolor sit amet consectetur
                adipisicing elit. Ab ut quibusdam quia, totam excepturi
                distinctio magnam? Animi, voluptas dicta quas reiciendis ipsam,
                neque, quaerat nulla dolore praesentium exercitationem atque
                numquam.
              </p>
              <p>
                Lorem ipsum, dolor sit amet consectetur adipisicing elit. Beatae
                illum odit, enim placeat debitis cumque asperiores tenetur
                perspiciatis fugiat. Atque, illo omnis dolorem veritatis aut
                natus perferendis distinctio cupiditate veniam?
              </p>
            </Card>
          </section>
        </section>
      </div>
    </main>
  );
}
