'use client'
import {Navbar, NavbarBrand, NavbarContent, NavbarItem, NavbarMenuToggle, NavbarMenu, NavbarMenuItem, Link, Button, useDisclosure} from "@nextui-org/react";
import { Login } from "../login/Login";
import { useState } from "react";
import Image from 'next/image'
import { userStore } from "@/store/userStore";

export const Header = () => {
  let user;
  if(typeof window !== "undefined"){
    user = JSON.parse(window.localStorage.getItem('user'))
  }

  const {isOpen, onOpen, onClose} = useDisclosure();
  const [isMenuOpen, setIsMenuOpen] = useState(false);
  const {logout} = userStore()
  return (
    <Navbar onMenuOpenChange={setIsMenuOpen} className="bg-slate-950" suppressHydrationWarning>
      <NavbarContent>
        <NavbarMenuToggle
          aria-label={isMenuOpen ? "Close menu" : "Open menu"}
          className="sm:hidden border-4 bg-secondary-100 w-1/4 h-2/3"
        />
        <NavbarBrand>
          <Link href="/">
            <Image src='/icons/logo_blanco_lila.webp'
              height={50}
              width={200}
              alt='logo' />
          </Link>         
        </NavbarBrand>
      </NavbarContent>

      <NavbarContent className="hidden sm:flex gap-4 " justify="center">
        <NavbarItem>
          <Button as={Link} color="foreground" href="/catalogo" className="text-default-50">
            Catálogo
          </Button>
        </NavbarItem>

      </NavbarContent>
      <NavbarContent justify="end">
        {
          !user?.email || user == null
            ?
          <>
            <NavbarItem className="hidden sm:flex">
              <Button onPress={onOpen} className="text-white font-bold border-2 bg-secondary-600 border-secondary-600 hover:bg-secondary-100 hover:text-secondary-700">Ingresa</Button>
            </NavbarItem>
            <NavbarItem className="hidden sm:flex">
              <Button as={Link} className="border-2 border-secondary-300 text-white font-semibold hover:text-secondary-200" href="/registro" variant="flat">
                Registrate
              </Button>
            </NavbarItem>
          </>
            :
          <>
            <NavbarItem className="hidden sm:flex">
              <Link href={`${user.role == 'STUDENT' ? '/alumnoDashboard' : '/profesorDashboard'}`} className="text-white font-bold border-2 bg-secondary-600 border-secondary-600 hover:bg-secondary-50 hover:text-secondary-500 py-2 px-6 rounded-xl">Mi Perfil</Link>
            </NavbarItem>
            <NavbarItem className="hidden sm:flex">
              <Button className="border-2 border-secondary-300 text-white font-semibold hover:text-secondary-200" onClick={logout} variant="flat">
                Cerrar Sesión
              </Button>
            </NavbarItem>
          </>
        }
      </NavbarContent>
      <NavbarMenu className="bg-secondary-950/70">
        <NavbarContent className="flex flex-col w-full items-center space-y-5">
          {
            user?.email
            ? <>
                <NavbarItem className="w-full text-center">
                  <Button as={Link} href={`${user.role == 'STUDENT' ? '/alumnoDashboard' : '/profesorDashboard'}`} className="text-lg w-full text-center font-bold text-default-50 bg-secondary-900 active:bg-secondary-500 rounded-none py-10 flex items-center justify-center">Mi Perfil</Button>
                </NavbarItem>
                <NavbarItem className="w-full text-center">
                  <Button as={Link} href="/catalogo" className="text-lg w-full text-center font-bold text-default-50 bg-secondary-900 active:bg-secondary-500 rounded-none py-10 flex items-center justify-center">Catálogo</Button>
                </NavbarItem>
                <NavbarItem className="w-full text-center">
                  <Button className="text-white font-semibold hover:text-secondary-200 rounded-none py-10 w-full bg-secondary-300" onClick={logout} variant="flat">
                    Cerrar Sesión
                  </Button>
                </NavbarItem>
            </>
            :<>
                <NavbarMenuItem className="w-full">
                    <Button onPress={onOpen} className="text-lg w-full font-bold text-default-50 bg-secondary-500 active:bg-secondary-500 rounded-none py-10 mt-5"> Ingresa </Button>
                </NavbarMenuItem>
                <NavbarMenuItem className="w-full">
                    <Button as={Link} className="w-full font-bold text-default-50 bg-secondary-900 active:bg-secondary-500 rounded-none py-10 mt-5" href="/registro" size="lg">
                      Regístrate
                    </Button>
                </NavbarMenuItem>
                <NavbarMenuItem className="w-full">
                    <Button as={Link} className="w-full font-bold text-default-50 bg-secondary-900 active:bg-secondary-500 rounded-none py-10 mt-5" href="/catalogo" size="lg">
                      Catálogo
                    </Button>
                </NavbarMenuItem>
              </>
          }
        </NavbarContent>
      </NavbarMenu>
      <Login isOpen={isOpen} onClose={onClose}/>
    </Navbar>
  )
}
