import React, {useState, useEffect} from 'react'; 
import {v1 as uuid} from "uuid"; 
import "./AddProject.css"
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
                <h1> Add Project {state.projName}</h1>
                <h3> Enter the details of the project below</h3>
                <TextField className="field" label="Name" name="projName" value={state.projName} onChange={setProperty}/>
                <TextField className="field" label="Description" name="description" value={state.description} onChange={setProperty}/>
                <DatePicker className="field" label="Start Date" placeholder="Select a date..." name="startDate" value={state.startDate} onSelectDate={setStartDate} ariaLabel="Select a date"/>
                <DatePicker className="field" label="End Date" placeholder="Select a date..." name="endDate" value={state.endDate} onSelectDate={setEndDate} ariaLabel="Select a date"/>
                <PrimaryButton className="AddProject" text="Add" onClick={onSubmit} allowDisabledFocus />
                {/* <button id="AddProject"> Add </button> */}
                <br/>
                <label className="Indicator">{state.indicatorText}</label>
            </React.Fragment>
            </form>
            </div>
        );
	}

export default AddProject; 
