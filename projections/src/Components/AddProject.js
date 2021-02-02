import React, {useState, useEffect} from 'react'; 
import {v1 as uuid} from "uuid"; 
import "./AddProject.css"
import { Label } from 'office-ui-fabric-react/lib/Label';
import { TextField, PrimaryButton, Stack, IStackTokens } from 'office-ui-fabric-react';
import { DatePicker, DayOfWeek, IDatePickerStrings, mergeStyleSets } from 'office-ui-fabric-react';

	const AddProject = () => {
        const [state, setState] = useState({
            projName : "",
            description : "",
            startDate : new Date(),
            endDate : new Date(),
            indicatorText: ""
          });

        function setProperty(e) {
            console.log("asdasdasdasdasdasdasdas")
            var name  = e.target.name;
            var val = e.target.value;

            console.log(name + "-" + val)
                setState(prevstate => {
                    return {...prevstate, [name]:  val };
                });
        } 

        function setStartDate(date){
            setState(prevstate => {
                return {...prevstate, "startDate":  date };
            });
        }
    
        function setEndDate(date) {
            setState(prevstate => {
                return {...prevstate, "endDate":  date };
            });
        }

        function onSubmit(e) {
            e.preventDefault();
            console.log(state.startDate + " ---- "+ state.endDate);
            const url = "https://projectionsazurefunctions.azurewebsites.net/api/AddProject?code=aRwmurbZKy0napFo3BPImB79fgC3Hx5Ejk4FZGPmUuNWbR2bZIbdZg==";
            //const url = "http://localhost:7071/api/AddProject";
            fetch(url, {
                  method : "POST",
                  headers: {
                      'Content-Type': 'application/json'
                      // 'Content-Type': 'application/x-www-form-urlencoded',
                    },
                  body:  JSON.stringify({
                      "ProjectID": uuid(),
                      "ProjectName": state.projName,
                      "Description": state.description,
                      "StartDate": state.startDate,
                      "EndDate": state.endDate,
                  })
              }).then(response => {
                  setState({indicatorText: "Added new Project"});
              }).catch(err => {setState({indicatorText: "Ran into an error while adding project" + err})});
          }


		return (
            <div>
            <form onSubmit={onSubmit} >
            <React.Fragment>
                <Label className="Label"> Enter the details of the project below</Label>
                <TextField className="field" label="Name" name="projName" value={state.projName} onChange={setProperty}/>
                <TextField className="field" label="Description" name="description" value={state.description} onChange={setProperty}/>
                <DatePicker className="field" label="Start Date" placeholder="Select a date..." name="startDate" value={state.startDate} onSelectDate={setStartDate} ariaLabel="Select a date"/>
                <DatePicker className="field" label="End Date" placeholder="Select a date..." name="endDate" value={state.endDate} onSelectDate={setEndDate} ariaLabel="Select a date"/>
                <PrimaryButton className="Add" text="Add" onClick={onSubmit} allowDisabledFocus />
                {/* <button id="AddProject"> Add </button> */}
                <br/>
                <Label className="Indicator">{state.indicatorText}</Label>
            </React.Fragment>
            </form>
            </div>
        );
	}

export default AddProject; 
