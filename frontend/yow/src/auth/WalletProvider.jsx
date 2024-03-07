import axios from "axios";
import { createContext, useContext, useState } from "react";
import { API_URL } from "../auth/constants";

const WalletContext = createContext();

export const WalletProvider = ({ children }) => {
  const [wallet, setWallet] = useState({});

  const getAccount = async () => {
    try {
      const token = localStorage.getItem('token');
      console.log('requesting auth to server');
      const config = {
        headers: { Authorization: `Bearer ${token}` }
      };
      const response = await axios.get(`${API_URL}/initiated/dashboard`, config);
      console.log('Servers response succeed');
      if (response) {
        console.log(`Wallet received! ${JSON.stringify(response.data)}`);
        setWallet(response.data);
      }
    } catch (error) {
      console.log('Something went wrong');
    }
  };

  const getWallet = () => {
    return wallet;
  };

  return (
    <WalletContext.Provider value={{ getAccount, getWallet, wallet }}>
      {children}
    </WalletContext.Provider>
  );
};

export const useWallet = () => useContext(WalletContext);
