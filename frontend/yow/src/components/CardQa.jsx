import React from 'react'

export default function CardQa({question, answer}) {
    return (
        <details class="group rounded-lg [&_summary::-webkit-details-marker]:hidden border border-gray-100 shadow-md shadow-zinc-500
         m-4 p-0 hover:shadow-lg hover:shadow-zinc-500 active:shadow-sm transition-all" open>
            <summary class="rounded-lg flex cursor-pointer items-center justify-between gap-1.5 bg-gray-100  text-zinc-900 px-4 py-2">
                <h2 class="font-semibold text-2xl">{question}</h2>

                <span class="relative size-5 scale-125 shrink-0 ">
                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="absolute inset-0 size-5 opacity-100 group-open:opacity-0"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                        stroke-width="2"
                    >
                        <path
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                    </svg>

                    <svg
                        xmlns="http://www.w3.org/2000/svg"
                        class="absolute inset-0 size-5 opacity-0 group-open:opacity-100"
                        fill="none"
                        viewBox="0 0 24 24"
                        stroke="currentColor"
                        stroke-width="2"
                    >
                        <path
                            stroke-linecap="round"
                            stroke-linejoin="round"
                            d="M15 12H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z"
                        />
                    </svg>
                </span>
            </summary>

            <p class="px-4 py-1 text-md text-zinc-900">
                {answer}
            </p>
        </details>
    )
}
