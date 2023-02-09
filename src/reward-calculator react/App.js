import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import CustomerComponent from './CustomerComponent';

function App() {
const [record, setRecord]= useState({
Customers:[
  {name:"Luwam", months:[
   { monthName: "1/2022", transactions:[12,120]},
   { monthName: "2/2022", transactions:[300,150]},
   { monthName: "3/2022", transactions:[10,100]}
   ], 
  },
  {name:"Mercy", months:[
    { monthName: "1/2022", transactions:[100,160]},
    { monthName: "2/2022", transactions:[190,120]},
    { monthName: "3/2022", transactions:[110,170]}
    ], 
}
],
});

const [points, setPoints]=useState([]);
useEffect(()=>calculatePoints(),[]);
function calculatePoints(){
  let monthlyPoints= record.Customers.map((customer)=>{
    let eachCustomer= customer.months.map((month)=>{
      let monthlyTransaction=month.transactions.reduce((sum, transaction)=>{
        //120,100
        if(transaction<=50){
          return 0+ sum;
        }else if(transaction<=100){
          return (transaction-50)+ sum;
        }else
        return (transaction-100)*2+50+sum
      },0);
      let oneMonth={monthName:month.monthName,
      monthlyPoints:monthlyTransaction}
      return oneMonth;
    });
    //reducing the total
    const total= eachCustomer.reduce((total,monthlyObject)=>{
return total+monthlyObject.monthlyPoints;
    },0);
    return{ name: customer.name, points:eachCustomer, total}
  });
  setPoints(monthlyPoints);
}
  return (
    <div className="App">
      
      <div>Hello</div>
      {points.map((customer)=>{
        return <CustomerComponent 
        props={customer} key={customer.name}/>
               
      })}
    </div>
  );
}

export default App;
