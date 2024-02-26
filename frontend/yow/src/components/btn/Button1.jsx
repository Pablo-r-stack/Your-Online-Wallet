

const Button1 = ({text, onClick}) => {

    return (
      <button className='bg-white py-2 px-4 mt-7 h-12 w-80 text-lg font-medium tracking-wide cursor-pointer rounded hover:bg-black hover:text-white hover:border-solid hover:border-2 hover:border-white' onClick={onClick}>{text}
      </button>
    );
};
  
export default Button1;