import React from 'react';
import Orderitems from '../../container/OrderItems/OrderItems'
import './Layout.css'

const layout = () => {
    return(
    <div className="Background">
        <h1 className = "Header">MENU</h1>
        <Orderitems/>
    </div>)

}

export default layout;

//: JSX,Element