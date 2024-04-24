'use client'
import React from "react";
import {Card, Skeleton} from "@nextui-org/react";

export function CourseCardSkeleton() {
  return (
    <Card className="w-[300px] h-[350px] space-y-5 p-4" radius="lg">
      <Skeleton className="rounded-lg">
        <div className=" h-[170px] rounded-lg bg-default-500"></div>
      </Skeleton>
      <div className="space-y-3">
        <Skeleton className="w-3/5 rounded-lg">
          <div className="h-3 w-3/5 rounded-lg bg-default-400"></div>
        </Skeleton>
        <Skeleton className="w-4/5 rounded-lg">
          <div className="h-3 w-4/5 rounded-lg bg-default-400"></div>
        </Skeleton>
        <Skeleton className="w-2/5 rounded-lg">  
          <div className="h-3 w-2/5 rounded-lg bg-default-400"></div>
        </Skeleton>
      </div>
    </Card>
  );
}