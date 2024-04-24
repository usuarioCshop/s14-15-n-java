'use client'
import React from 'react';
import { useState, useEffect } from 'react';
import { CourseCardSkeleton, CatalogoCard } from '..';

export const RenderCursosFilters = ({ selectedCategory, selectedPriceRange }) => {
  
  const [allCursos, setAllCursos] = useState([]);

  const getAllCursos = async () => {
    try {
      const response = await fetch(`https://s14-15-n-java.onrender.com/api/v1/course/list`, {
        method: 'GET'
      });
      const result = await response.json();
      setAllCursos(result);
    } catch (error) {
      console.error('Error al obtener los cursos:', error);
    }
  };

  useEffect(() => {
    getAllCursos();
  }, []);

  return (
    <section className="flex flex-wrap mt-20 gap-10 items-center justify-center xl:justify-normal p-4">
      {allCursos.length > 0 ? (
        allCursos.map((curso, index) => {
          const cursoPrice = parseFloat(curso.price);
          if (
            (selectedCategory === "all" || curso.category === selectedCategory) &&
            (selectedPriceRange === "" ||
              (selectedPriceRange === "50" && cursoPrice <= 50) ||
              (selectedPriceRange === "100" && cursoPrice <= 100) ||
              (selectedPriceRange === "150" && cursoPrice <= 150) ||
              (selectedPriceRange === "150plus" && cursoPrice > 150))
          ) {
            if (curso.isPublished) {
              return (
                <CatalogoCard
                  id={curso.id}
                  key={index}
                  name={curso.name}
                  category={curso.category}
                  price={curso.price}
                  currency={curso.currency}
                />
              );
            }
          }
          return null;
        })
      ) : (
        <div className='flex flex-wrap gap-10 items-center justify-center xl:justify-normal'>
          <CourseCardSkeleton />
          <CourseCardSkeleton />
          <CourseCardSkeleton />
          <CourseCardSkeleton />
        </div>
      )}
    </section>
  );
};