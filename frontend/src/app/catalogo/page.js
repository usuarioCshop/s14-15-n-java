'use client'
import { CursosFiltros, RenderCursosFilters } from '@/components';
import React, { useState } from 'react';


const Catalogo = () => {

  const [selectedCategory, setSelectedCategory] = useState('all');
  const [selectedPriceRange, setSelectedPriceRange] = useState('');

  
  return (
    <main className="w-full relative max-w-[1366px] mx-auto mt-20 flex flex-col min-h-screen">
      <section className="z-[-2] absolute top-0 right-40 flex w-[1000px] h-[1000px] rounded-full bg-gradient-radial blur-5xl from-[#3C0E69] to-[#180828] "></section>
      <section className="z-10 flex-grow">
        <section>
          <CursosFiltros
            setSelectedCategory={setSelectedCategory}
            setSelectedPriceRange={setSelectedPriceRange}
          />
        </section>
        <section>
          <RenderCursosFilters
            selectedCategory={selectedCategory}
            selectedPriceRange={selectedPriceRange}
          />
        </section>
      </section>
      <footer className="mt-auto">Contenido del footer aquí</footer>
    </main>
  );
}

export default Catalogo