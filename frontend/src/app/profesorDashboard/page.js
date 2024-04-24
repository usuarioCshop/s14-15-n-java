'use client'
import React, { useState } from 'react';
import { useRouter } from 'next/navigation.js';
import { checkAuth } from '@/services/checkRole.js';
import { ProfeCursos, ProfeMensajes, ProfePerfil, ProfeResenas, ProfeSideBar } from '@/components';



const ProfesorDashboard = () => {
  const auth = checkAuth('TEACHER')
  const router = useRouter()
  if(auth == false) return router.push('/')

  const [selectedItem, setSelectedItem] = useState(null);

  const handleMenuItemClick = (index) => {
    setSelectedItem(index);
    console.log(index)
  };

  return (
    <>   
      <ProfeSideBar onMenuItemClick={handleMenuItemClick} />
      {selectedItem===0 && <ProfePerfil/>}
      {selectedItem===1 && <ProfeCursos/>}
      {selectedItem===2 && <ProfeResenas/>}
      {selectedItem===3 && <ProfeMensajes/>}
    </>
  );
};

export default ProfesorDashboard;