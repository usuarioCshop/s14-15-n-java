'use client'

import { useRouter } from "next/navigation";
import { checkAuth } from "@/services/checkRole";
import React, { useEffect, useState } from 'react';
import { AlumnoCertificaciones, AlumnoCursos, AlumnoEvaluaciones, AlumnoMensajes, AlumnoPerfil, AlumnoSideBar } from "@/components";
import { userStore } from "@/store/userStore";
import { getCursos } from "@/services/getCoursesUser";

const AlumnoDashboard = () => {
  const router = useRouter()
  const auth = checkAuth('STUDENT')
  if(auth == false) return router.push('/')

  const {user, token} = userStore()
  const [selectedItem, setSelectedItem] = useState(null);
  const [cursos, setCursos] = useState([])
  
  const handleMenuItemClick = (index) => {
    setSelectedItem(index);
  };
  
  useEffect(()=>{
    getCursos(user.email, token).then(data => setCursos(data));
  },[])

  return (
    <section className="h-full">   
      <AlumnoSideBar onMenuItemClick={handleMenuItemClick} />
      {selectedItem===0 && <AlumnoPerfil cursos={cursos}/>}
      {selectedItem===1 && <AlumnoCursos cursos={cursos}/>}
      {selectedItem===2 && <AlumnoCertificaciones/>}
      {selectedItem===3 && <AlumnoEvaluaciones/>}
      {selectedItem===4 && <AlumnoMensajes/>}
    </section>
  );
};

export default AlumnoDashboard;