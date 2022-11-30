import React from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import MainPage from './mainPage/MainPage'
import UserPage from './userPage/UserPage'

function App() {
  
  return (
    <>
      <Router>
        <Routes>
          <Route exact path='/' element={<MainPage/>}></Route>
          <Route exact path='/passengers' element={<UserPage/>}></Route>
        </Routes>
      </Router>
      
    </>    
  );
}

export default App;
