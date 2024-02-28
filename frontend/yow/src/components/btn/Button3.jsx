import React from 'react'

export default function Button3({ text, onClick }) {
  return (
    <button className='bg-zinc-900 text-slate-200 rounded-md w-full lg:w-40 h-11 lg:text-xl text-center shadow-lg shadow-slate-900 hover:shadow-xl hover:shadow-slate-700 active:shadow-sm transition-all' onClick={onClick}>
      {text}
    </button>
  );
}