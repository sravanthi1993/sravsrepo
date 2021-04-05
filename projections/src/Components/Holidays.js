import React, {useState, useEffect} from 'react';
import { Label } from 'office-ui-fabric-react/lib/Label';
import { TextField, PrimaryButton, ChoiceGroup, Stack, IStackTokens, DetailsList } from 'office-ui-fabric-react';
import { DatePicker, DayOfWeek, IDatePickerStrings, mergeStyleSets } from 'office-ui-fabric-react';
import {DetailsListLayoutMode, SelectionMode, Selection, IColumn } from 'office-ui-fabric-react/lib/DetailsList';

const Holidays = () => {
    const[state,setState] = useState ({
        HolDate : new Date(),
        Occasion : ""
    });


    function setHolDate(date){
        setState(prevstate => {
            return {...prevstate, "HolDate":  date };
        });
    }

    function setProperty(e) {
        var name  = e.target.name;
        var val = e.target.value ;

        console.log(name + "--" + val)
                setState(prevstate => {
                    return {...prevstate, [name]: val};
                });
    }

    const [Holidaysdetails, setHolidaysdetails ] = useState([]);
    //var listofholidays = []
    
    useEffect(() => {
        //getholidayslist();
        });

    function getholidayslist() {
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/GetHolidays?code=IGZG4SdEVqbHWYhV32asIb8junLY3IttJDVB4KjCjL3aNGyr0L1rOg=="
        fetch(url, {
            method: "GET"
        }).then(response => response.json()
        ).then(holidays => {
            console.log(holidays);
            /*holidays.map(holiday =>  
              {
                  listofholidays.push(new Date(Date.parse(holiday.holidayDate)))
              });*/
            //console.log(listofholidays)
            setHolidaysdetails(holidays);
        })
    }
    

    function onSubmit(e) {
        e.preventDefault();
        console.log(state.HolDate + " ---- "+ state.Occasion);
        //const url = "https://projectionsazurefunctions.azurewebsites.net/api/AddProject?code=aRwmurbZKy0napFo3BPImB79fgC3Hx5Ejk4FZGPmUuNWbR2bZIbdZg==";
        const url = "http://localhost:7071/api/Holidays";
        fetch(url, {
              method : "POST",
              mode: "no-cors",
              headers: {
                  'Content-Type': 'application/json',
                  // 'Content-Type': 'application/x-www-form-urlencoded',
                },
              body:  JSON.stringify({
                  
                  "HolidayDate": state.HolDate,
                  "Occasion" : state.Occasion,
                  
              })
          }).then(response => {
              setState({indicatorText: "Added Holidays"});
              getholidayslist();
          }).catch(err => {setState({indicatorText: "Ran into an error while adding project " + err})});
      }





    return (
        <div>
        <form onSubmit={onSubmit} >
        <React.Fragment>
        <Label className="Label"> Enter Holidays</Label>
        
        <DatePicker className="field" label="Pick Holidays" placeholder="Select a date..." name="HolDate" value={state.HolDate} onSelectDate={setHolDate} ariaLabel="Select a date"/>
        <TextField className="field" label="Name of Occasion" name="Occasion" value={state.Occasion} onChange={setProperty}/>
        <DetailsList 
                        items={Holidaysdetails}
                        setKey="set"
                        layoutMode={DetailsListLayoutMode.justified}
                        selectionMode={SelectionMode.none}
        /> 
        <PrimaryButton className="Add" text="Add Holidays" onClick={onSubmit} allowDisabledFocus />
        </React.Fragment>
            </form>
            </div>
    );
}


export default Holidays;