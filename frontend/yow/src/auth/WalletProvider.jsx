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

  const addFunds = async (amount, numberDocument) => {
    try {
      const token = localStorage.getItem('token');
      const config = {
        headers: { Authorization: `Bearer ${token}` }
      };
      console.log('Requesting authorization to server');
      console.log('Authorization granted');
      const response = await axios.post(`${API_URL}/initiated/rechargeAccount/${numberDocument}`, null, {
        ...config,
        params: { mount: amount } // Pasar el monto como un parámetro en la URL
      });
      console.log('Server response succeed');
      console.log('Recharge was successful');
      getAccount();
    } catch (error) {
      console.log('Something went wrong');
    }
  }

  const mountTransfer = async (numberDocument, userReciever) => {
    try {
      const token = localStorage.getItem('token');
      const config = {
        headers: { Authorization: `Bearer ${token}` }
      };
      console.log(`Data in transfer ${JSON.stringify(userReciever)}`);
      console.log('Requesting authorization to server');
      console.log('Authorization granted');
      const response = await axios.post(`${API_URL}/initiated/transfer/${numberDocument}`, userReciever, config);
      console.log('Server response succeed');
      console.log('Transfer was successful');
      getAccount();
    } catch (error) {
      console.log('Something went wrong');
    }
  }

  const servicePay = async (amount, numberDocument) => {
    try {
      const token = localStorage.getItem('token');
      const config = {
        headers: { Authorization: `Bearer ${token}` }
      };
      console.log('Requesting authorization to server');
      console.log('Authorization granted');
      const response = await axios.post(`${API_URL}/initiated/service-pay/${numberDocument}`, null, {
        ...config,
        params: { mount: amount } // Pasar el monto como un parámetro en la URL
      });
      console.log('Server response succeed');
      console.log('Payment done');
      getAccount();
    } catch (error) {
      console.log('Something went wrong');
    }
  }

  return (
    <WalletContext.Provider value={{ getAccount, getWallet, wallet, addFunds, mountTransfer, servicePay }}>
      {children}
    </WalletContext.Provider>
  );
};

export const useWallet = () => useContext(WalletContext);
