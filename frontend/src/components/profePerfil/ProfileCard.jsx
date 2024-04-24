import React from "react";
import Image from 'next/image'
import {Card, CardHeader, CardBody} from "@nextui-org/react";

const normalizeString = (str) => {
  const normalize = str.slice(0,1) + str.slice(1).toLowerCase()
  return normalize
}

export const ProfileCard = ({ user }) => {

  return (
    <Card className="h-full bg-white bg-opacity-10 md:max-w-xs lg:items-center">
      <CardBody className="overflow-visible p-5 pb-0 md:items-center justify-center">
        <Image
          alt="Card background"
          className="object-cover rounded-xl"
          src="/images/profile_placeholder.png"
          width={400}
          height={300}
        />
      </CardBody>
      <CardHeader className="flex-col items-start h-full p-5 lg:mt-3">
        <div className="rounded-xl w-full p-2">
          <label className="text-md text-secondary-50 font-bold">Usuario</label>
          <h2 className=" text-md mb-5 text-secondary-100">{user.fullName}</h2>
          <label className="text-md text-secondary-50 font-bold">
            Correo electrónico
          </label>
          <h2 className="text-md mb-5 text-secondary-100">{user.email}</h2>
          <label className="text-md text-secondary-50 font-bold">Rol</label>
          <h2 className="text-md text-secondary-100">{normalizeString(user.role)}</h2>
        </div>
      </CardHeader>
    </Card>
  );
};
