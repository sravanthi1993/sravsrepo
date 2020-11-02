import React from 'react';
import {Ilabel,  Items, IHash } from '../../container/OrderItems/OrderItems'
import './ItemSelector.css'
import { PrimaryButton } from 'office-ui-fabric-react/lib/Button';  

interface Iprops {
menu : Ilabel[];
quantities : Items;
price : Items;
itemAdded: (item: Ilabel) => void;
itemremoved: (item: Ilabel) => void;
quant : IHash;
totalprice : number;
}

/*

*/
export const itemselector = (props : Iprops)  => (
    <div>   
    { props.menu.map(item => (
        //<menuitem name={item.label} />
        <div className="Main">
        <div className="ItemName">{item.label} </div> 
        <div className="Itemprice">${item.price} </div> 
        <div className="ItemQuant">{props.quant[item.label]}</div>
        <PrimaryButton className="ButtonLess" onClick={() => props.itemremoved(item)}> - </PrimaryButton>
        <PrimaryButton className="ButtonMore" onClick={() => props.itemAdded(item)} > + </PrimaryButton>
    </div>
    ))}
    <br/>
    <br/>
     <PrimaryButton className="orderButton">
        ORDER NOW
    </PrimaryButton>

    </div>
)


export default itemselector;