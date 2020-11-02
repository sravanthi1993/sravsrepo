import React, { Component } from 'react';
import PropTypes from 'prop-types';

import classes from './BurgerIngredient.css';

class BurgerIngredient extends Component {
    render () {
        let ingredient = null;

        switch ( this.props.type ) {
            case ( 'bread-bottom' ):
                ingredient = <div className='BreadBottom'>bread-bottom</div>;
                break;
            case ( 'bread-top' ):
                ingredient = (
                    <div className='BreadTop'> 
                    burger-top
                        <div className={classes.Seeds1}></div>
                        <div className={classes.Seeds2}></div>
                    </div>
                );
                break;
            case ( 'meat' ):
                ingredient = <div className='Meat'>Meat</div>;
                break;
            case ( 'cheese' ):
                ingredient = <div className='Cheese'>Cheese</div>;
                break;
            case ( 'bacon' ):
                ingredient = <div className='Bacon'>bacon</div>;
                break;
            case ( 'salad' ):
                ingredient = <div className='Salad'>salad</div>;
                break;
            default:
                ingredient = null;
        }

        return ingredient;
    }
}

BurgerIngredient.propTypes = {
    type: PropTypes.string.isRequired
};

export default BurgerIngredient;