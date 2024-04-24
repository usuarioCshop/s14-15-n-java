'use client'
import { Card, CardHeader, CardBody, CardFooter, Divider, Link, Button, Image } from "@nextui-org/react";

export const AlumnoCursosCard = ({ id, courseName, description, category, thumbnailUrl }) => {
    return (
        <Card className="bg-white bg-opacity-10 min-w-80 max-w-[400px] min-h-56 max-h-56">
            <CardHeader className="flex gap-3">
                <Image
                    alt="ClassLodge logo"
                    height={40}
                    radius="sm"
                    src={'/icons/CL_icon.webp'}
                    width={40}
                />
                <div className="flex flex-col">
                    <p className="text-md text-white">{courseName}</p>
                    <p className="text-small text-default-500">{category}</p>
                </div>
            </CardHeader>
            <Divider />
            <CardBody>
                <p className="text-white">{description}</p>
            </CardBody>
            <Divider />
            <CardFooter className="flex align-middle justify-end">
                <Button className="bg-secondary-500 text-white">
                    <Link
                        className="text-white p-2"
                        href=""
                    >
                        Ver Curso
                    </Link>
                </Button>
            </CardFooter>
        </Card>
    )
}
