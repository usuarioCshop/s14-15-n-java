import React from 'react';
import { Select, SelectItem } from '@nextui-org/react';
import { categories } from './categoryData'
import { prices } from './pricesData'
import {Input} from "@nextui-org/react";
import Image from 'next/image';

export const CursosFiltros = ({ setSelectedCategory, setSelectedPriceRange }) => {

  const handleSelectChange = (e) => {
    setSelectedCategory(e.target.value);
  }

  const handlePriceRangeChange = (e) => {
    setSelectedPriceRange(e.target.value);
  };

  return (
    <main>
      <section className=" flex items-center flex-col md:flex-row p-4 gap-6">
        <Select
          label="Selecciona una categoría"
          placeholder="Cualquier categoría"
          className="max-w-xs"
          color='secondary'
          onChange={handleSelectChange}
        >
          {categories.map((category) => (
            <SelectItem key={category.value} value={category.value}>
              {category.name}
            </SelectItem>
          ))}
        </Select>
        <Select
          items={[
            { value: "", name: "Todos" },
            { value: "50", name: "Hasta 50 USD" },
            { value: "100", name: "Hasta 100 USD" },
            { value: "150", name: "Hasta 150 USD" },
            { value: "150plus", name: "Mayor a 150 USD" },
          ]}
          label="Rango de precios"
          placeholder="Cualquier precio"
          className="max-w-xs"
          color='secondary'
          onChange={handlePriceRangeChange}
        >
          {prices.map((price) => (
            <SelectItem key={price.value} value={price.value}>
              {price.name}
            </SelectItem>
          ))}
        </Select>
        <section className="flex items-center h-14">
          <Input
            placeholder="Busca un curso"
            className=" w-[320px] lg:w-[500px] mx-auto border border-[#7828C8] rounded-lg h-full"
            classNames={{
              input: ["text-white"],
              inputWrapper: ["bg-white bg-opacity-10 rounded-lg h-full"],
            }}
            endContent={
              <Image
                src="icons/searchIcon.svg"
                width={25}
                height={25}
                alt="hero"
                className="flex justify-end"
              />
            }
          />
        </section>
      </section>
    </main>
  );
};

