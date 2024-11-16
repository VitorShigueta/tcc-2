import React, { useState, useEffect } from "react";
import { Routes, Route, Link } from "react-router-dom";
import './App.css'
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min";

import AuthService from "./services/auth.service";
import useAuthStore from "./services/useAuthStore";
import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./components/Home";
import Profile from "./components/Profile";
import NavBar from "./components/NavBar";
import Acao from "./components/Acao";

function App() {
  const [currentUser, setCurrentUser] = useState(undefined);
  const { isLoggedIn, login, logout } = useAuthStore();

  useEffect(() => {
    const user = AuthService.getCurrentUser();
    
    if (user) {
      setCurrentUser(user);
      login();  
    }
  }, []);

  const logOut = () => {
    AuthService.logout();
    logout();
  };

  return (
  <div>
      <NavBar currentUser={currentUser} logOut={logOut}/>
      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/acao" element={<Acao/>} />
        </Routes>
      </div>
    </div>
  )
}

export default App
