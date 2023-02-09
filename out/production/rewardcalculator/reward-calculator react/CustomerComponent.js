import React from 'react'

const CustomerComponent = ({props}) => {

  return (
  <div>
    <div>{props.name}</div>
    <div>
        <ul>{props.points.map((item)=>{
          return <li key ={props.name+item.monthName}>
          {item.monthName}: {item.monthlyPoints}</li>
        })}     
        </ul>
        <div>total: {props.total}</div>
    </div>
    </div>
  )
}

export default CustomerComponent