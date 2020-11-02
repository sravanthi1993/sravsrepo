import React from 'react'

export interface IProps
{
    name : string
}

export const menuitem = (props : IProps)  => (   
    <div>
    <div>{props.name}</div>
    <button >Less
        </button>
    <button>More
        </button>
    </div>
)