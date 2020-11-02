import React from 'react';
import {Ilabel,  Items, IHash } from '../../container/OrderItems/OrderItems'
import './OrderPreview.css'
//import { IProps } from '../ItemSelector/MenuItem/MenuItem';

interface Iprops {
    menu : Ilabel[];
    price : Items;
    quant : IHash;
    totalprice : number;
    }


const orderpreview = (props : Iprops) => (
   // return (
    <div>
    <strong className="title">ORDER SUMMARY</strong>   <br/> <br/>
    {
    props.menu.map(item => (
           props.quant[item.label] > 0 ? (<div className="text"> {props.quant[item.label]} - {item.label}  - ${props.quant[item.label] * item.price}</div>): (null)
    ))
    }
    <br/>
    <strong className="total"> Total Price: {props.totalprice.toFixed(2)}</strong>
    </div>
    //);
)
    
export default orderpreview;