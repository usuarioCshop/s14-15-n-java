"use client";
import { useState, useEffect } from "react";
import CurseInfo from "@/components/curseInfo/curseInfo";

export default function CurseDetails({ params }) {
  const { id } = params;
  const [curseData, setCurseData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `https://s14-15-n-java.onrender.com/api/v1/course/${id}`,
          {
            method: "GET", 
            headers: {
              "Content-Type": "application/json",

            },
          }
        );
        if (!response.ok) {
          throw new Error("Error al obtener los datos del curso");
        }
        const data = await response.json();
        setCurseData(data);
      } catch (error) {
        console.error("Error al obtener la información del curso:", error);
      }
    };

    fetchData();
  }, [curseData]);

  return (
    <>
     <CurseInfo curseData={curseData} />
    </>
  );
}
