'use client'
import React from 'react';
import { Card, Skeleton } from '@nextui-org/react';

const CourseDetailSkeleton = () => {
  return (
    <Card
      className=" m-3 md:w-[1128px] md:h-[800px] space-y-5 p-4 mt-20 flex-row"
      radius="lg"
    >
      <div className="p-5 w-2/3 flex h-[800px] flex-col">
        <Skeleton className="rounded-lg w-full h-[400px]">
          <div className="rounded-lg bg-default-300"></div>
        </Skeleton>
        <div className="space-y-3">
          <Skeleton className="w-3/5 rounded-lg mt-10">
            <div className="h-3 w-3/5 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/3 rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/5 rounded-lg">
            <div className="h-3 w-2/5 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
        <div className="space-y-3">
          <Skeleton className="w-3/5 rounded-lg mt-5">
            <div className="h-3 w-3/5 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/3 rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/5 rounded-lg">
            <div className="h-3 w-2/5 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
        <div className="space-y-3">
          <Skeleton className="w-3/5 rounded-lg mt-5">
            <div className="h-3 w-3/5 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/3 rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className="w-2/5 rounded-lg">
            <div className="h-3 w-2/5 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
      </div>
      <div className="w-1/3">
        <div className="space-y-3">
          <Skeleton className=" rounded-lg mt-10">
            <div className="h-3 w-1/3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 w-1/3 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
        <div className="space-y-3">
          <Skeleton className=" rounded-lg mt-10">
            <div className="h-3 w-1/3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 w-1/3 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
        <div className="space-y-3">
          <Skeleton className=" rounded-lg mt-10">
            <div className="h-3 w-1/3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 rounded-lg bg-default-200"></div>
          </Skeleton>
          <Skeleton className=" rounded-lg">
            <div className="h-3 w-1/3 rounded-lg bg-default-300"></div>
          </Skeleton>
        </div>
      </div>
    </Card>
  );
};

export default CourseDetailSkeleton;