import React from 'react';
import ItemSelector from '../../components/ItemSelector/ItemSelector';
import OrderPreview from '../../components/OrderPreview/OrderPreview';

export interface Items  {

    Coffee: number;
    Sandwich: number;
    Salad: number;
    Hashbrown: number;
    Pancakes:number;
    Bearclaw:number;
    Friedrice:number;
    Noodles:number;
    Rice:number;
}
export interface Ilabel {
    label : string;
    type : string;
    price: number;
}
export interface IHash {
    [details: string]:  number;
}


let quanitities : IHash = {};
quanitities["Coffee"] = 0;
quanitities["Bearclaw"] = 0;
quanitities["Salad"] = 0;
quanitities["Friedrice"] = 0;
quanitities["Hashbrown"] = 0;
quanitities["Noodles"] = 0;
quanitities["Pancakes"] = 0;
quanitities["Rice"] = 0;
quanitities["Sandwich"] = 0;

/*type label = {
    labels : Ilabel
}

const controls = (props : Ilabel ) : JSX.Element =>{
    const (labels) = props;
}
*/


const prices : Items = {

    Coffee: 2.5,
    Sandwich: 4.0,
    Salad: 10.0,
    Hashbrown: 1.5,
    Pancakes: 3.0,
    Bearclaw: 3.5,
    Friedrice: 10.99,
    Noodles: 9.99,
    Rice: 2.99
}


const controls : Ilabel[] = [
    { label: 'Coffee', type: 'Coffee', price: prices.Coffee },
    { label: 'Bearclaw', type: 'Bearclaw', price: prices.Bearclaw },
    { label: 'Salad', type: 'Salad', price: prices.Salad  },
    { label: 'Friedrice', type: 'Friedrice', price: prices.Friedrice },
    { label: 'Rice', type: 'Rice', price: prices.Rice },
    { label: 'Pancakes', type: 'Pancakes', price: prices.Pancakes },
    { label: 'Sandwich', type: 'Sandwich', price: prices.Sandwich },
    { label: 'Hashbrown', type: 'Hashbrown', price: prices.Hashbrown },
    { label: 'Noodles', type: 'Noodles', price: prices.Noodles },
];

interface Istate {
    quantity : Items;
   // menu : Ilabel[];
    totalprice : number;
    purchasable : boolean;
    quant: IHash;
}

class Orderitems extends React.Component<any, Istate>  {
     constructor(props: any) {
         super(props);
    //     this.state = {...}
    // }
        this.state = {
            quantity: {
                Coffee: 0,
                Sandwich: 0,
                Salad: 0,
                Hashbrown: 0,
                Pancakes:0,
                Bearclaw:0,
                Friedrice:0,
                Noodles:0,
                Rice:0
        },
        totalprice: 0,
        //menu : controls,
        purchasable: false,
        quant: quanitities
    }
    }

    addItemHandler = ( item :Ilabel) => {
        let updatedQuants = {
            ...this.state.quant
        };
        updatedQuants[item.label] = updatedQuants[item.label]+1;
        for(let i=0;i<controls.length;i++)
        {
            if(controls[i].label === item.label)
            {
                this.setState({totalprice : this.state.totalprice+(controls[i].price)}) ;
            }
        }
        
        console.log(updatedQuants);
        this.setState( { quant:updatedQuants} );
    }

    removeItemHandler = ( item :Ilabel) => {
        let updatedQuants = {
            ...this.state.quant
        };
        if(updatedQuants[item.label] > 0)
        {
            updatedQuants[item.label] = updatedQuants[item.label] - 1;

            for (let i = 0; i < controls.length; i++) {
                if (controls[i].label === item.label) {
                    //console.log(item.price);
                    this.setState({ totalprice: this.state.totalprice - (controls[i].price) });
                }
            }
        }
        
        console.log(updatedQuants);
        this.setState( { quant:updatedQuants} );
    }
 render() {
     return (
         <div>
            <ItemSelector
                menu = {controls}
                price = {prices}
                quantities = {this.state.quantity}
                itemremoved={this.removeItemHandler}
                itemAdded={this.addItemHandler}
                quant = {this.state.quant}
                totalprice ={this.state.totalprice}
            />
            <br/><br/>
            <OrderPreview
                menu = {controls}
                price = {prices}
                //quantities = {this.state.quantity}
                quant = {this.state.quant}
                totalprice ={this.state.totalprice}
            />
        </div>
        
     );
 }
}

export default Orderitems;