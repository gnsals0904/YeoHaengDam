/** * v0 by Vercel. * @see https://v0.dev/t/DQGDuq2S7NE * Documentation:
https://v0.dev/docs#integrating-generated-code-into-your-nextjs-app */ import { Button } from
"@/components/ui/button" import { DropdownMenuTrigger, DropdownMenuRadioItem,
DropdownMenuRadioGroup, DropdownMenuContent, DropdownMenu } from "@/components/ui/dropdown-menu"
import { Input } from "@/components/ui/input" import Link from "next/link" import {
PaginationPrevious, PaginationItem, PaginationLink, PaginationNext, PaginationContent, Pagination }
from "@/components/ui/pagination" export default function Component() { return (
<section className="bg-gray-100 dark:bg-gray-950 py-12 md:py-16 lg:py-20">
      <div className="container px-4 md:px-6">
        <div className="flex items-center justify-between mb-8 gap-4">
          <div className="flex items-center gap-4 ml-auto">
            <DropdownMenu>
              <DropdownMenuTrigger asChild>
                <Button className="shrink-0" variant="outline">
                  <SearchIcon className="w-4 h-4 mr-2" />
                  Search by
                </Button>
              </DropdownMenuTrigger>
              <DropdownMenuContent align="end" className="w-[200px]">
                <DropdownMenuRadioGroup value="title">
                  <DropdownMenuRadioItem value="title">Title</DropdownMenuRadioItem>
                  <DropdownMenuRadioItem value="content">Content</DropdownMenuRadioItem>
                </DropdownMenuRadioGroup>
              </DropdownMenuContent>
            </DropdownMenu>
            <div className="relative">
              <Input className="pr-12" placeholder="Search" />
              <Button className="absolute right-2 top-1/2 -translate-y-1/2" size="icon" variant="ghost">
                <SearchIcon className="w-5 h-5" />
              </Button>
            </div>
          </div>
        </div>
        <div className="grid gap-8 md:grid-cols-2 lg:grid-cols-3">
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">Serene Shores of Bali</div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">John Doe</span>
                • May 1, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                250 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                1.2K views{"\n                        "}
              </div>
            </div>
          </Link>
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">
                Enchanting Landscapes of Iceland
              </div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">Jane Smith</span>
                • June 15, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                180 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                900 views{"\n                        "}
              </div>
            </div>
          </Link>
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">Vibrant Vistas of Santorini</div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">Michael Johnson</span>
                • July 10, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                300 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                1.5K views{"\n                        "}
              </div>
            </div>
          </Link>
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">
                Captivating Coastlines of Amalfi
              </div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">Emily Davis</span>
                • August 5, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                400 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                2K views{"\n                        "}
              </div>
            </div>
          </Link>
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">
                Majestic Mountains of Patagonia
              </div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">David Lee</span>
                • September 20, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                150 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                800 views{"\n                        "}
              </div>
            </div>
          </Link>
          <Link
            className="group relative overflow-hidden rounded-lg shadow-lg hover:shadow-xl transition-transform duration-300 ease-in-out hover:-translate-y-2"
            href="#"
          >
            <img
              alt="Travel Destination"
              className="object-cover w-full aspect-[3/2] group-hover:opacity-50 transition-opacity"
              height="240"
              src="/placeholder.svg"
              width="360"
            />
            <div className="absolute inset-0 z-10 flex flex-col justify-end p-4 bg-gradient-to-t from-gray-900/80 to-transparent">
              <div className="text-white text-lg font-semibold group-hover:underline">
                Enchanting Landscapes of Tuscany
              </div>
              <div className="text-gray-300 text-sm">
                <span className="font-medium">Sarah Kim</span>
                • October 1, 2023{"\n                        "}
              </div>
              <div className="text-gray-300 text-sm mt-2">
                <HeartIcon className="w-4 h-4 mr-1 inline" />
                280 likes{"\n                          "}
                <span className="mx-2">•</span>
                <EyeIcon className="w-4 h-4 mr-1 inline" />
                1.3K views{"\n                        "}
              </div>
            </div>
          </Link>
        </div>
        <div className="flex justify-center mt-8">
          <Pagination>
            <PaginationContent>
              <PaginationItem>
                <PaginationPrevious className="hidden" href="#" />
              </PaginationItem>
              <PaginationItem>
                <PaginationLink href="#">1</PaginationLink>
              </PaginationItem>
              <PaginationItem>
                <PaginationLink href="#">2</PaginationLink>
              </PaginationItem>
              <PaginationItem>
                <PaginationLink href="#">3</PaginationLink>
              </PaginationItem>
              <PaginationItem>
                <PaginationLink href="#">4</PaginationLink>
              </PaginationItem>
              <PaginationItem>
                <PaginationLink href="#">5</PaginationLink>
              </PaginationItem>
              <PaginationItem>
                <PaginationNext href="#" />
              </PaginationItem>
            </PaginationContent>
          </Pagination>
        </div>
      </div>
    </section>
) } function EyeIcon(props) { return (
<svg
  {...props}
  xmlns="http://www.w3.org/2000/svg"
  width="24"
  height="24"
  viewBox="0 0 24 24"
  fill="none"
  stroke="currentColor"
  strokeWidth="2"
  strokeLinecap="round"
  strokeLinejoin="round"
>
      <path d="M2 12s3-7 10-7 10 7 10 7-3 7-10 7-10-7-10-7Z" />
      <circle cx="12" cy="12" r="3" />
    </svg>
) } function HeartIcon(props) { return (
<svg
  {...props}
  xmlns="http://www.w3.org/2000/svg"
  width="24"
  height="24"
  viewBox="0 0 24 24"
  fill="none"
  stroke="currentColor"
  strokeWidth="2"
  strokeLinecap="round"
  strokeLinejoin="round"
>
      <path d="M19 14c1.49-1.46 3-3.21 3-5.5A5.5 5.5 0 0 0 16.5 3c-1.76 0-3 .5-4.5 2-1.5-1.5-2.74-2-4.5-2A5.5 5.5 0 0 0 2 8.5c0 2.3 1.5 4.05 3 5.5l7 7Z" />
    </svg>
) } function SearchIcon(props) { return (
<svg
  {...props}
  xmlns="http://www.w3.org/2000/svg"
  width="24"
  height="24"
  viewBox="0 0 24 24"
  fill="none"
  stroke="currentColor"
  strokeWidth="2"
  strokeLinecap="round"
  strokeLinejoin="round"
>
      <circle cx="11" cy="11" r="8" />
      <path d="m21 21-4.3-4.3" />
    </svg>
) }
