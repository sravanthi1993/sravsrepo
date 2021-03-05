import React, { useState } from 'react';
import {v1 as uuid} from "uuid"; 
import { TextField, PrimaryButton, Stack, IStackTokens } from 'office-ui-fabric-react';

function AddResource() 
{ 
    const [state, setState] = useState({
        resName : "",
        skils : "",
        billing : "",
        projectId : "",
        resourceprojectstartdate : new Date(),//added new
        indicatorText: ""
      });

    //setState( { "projName" : "asadsa" });
    function setProperty(e) {
        setState(prevState => {
            return {...prevState, [e.target.name] : e.target.value };
        });
    }


    function onSubmit(e){
      e.preventDefault();
      const url = "https://projectionsazurefunctions.azurewebsites.net/api/AddResource?code=20KXEmWE7j4hdDDcfYzaqH0fU48lLMxM8ufMP5xKZe5HaLqmMAq3fw==";
      //const url = "http://localhost:7071/api/AddResource";
      fetch(url, {
            method : "POST",
            mode: "no-cors",
            body:  JSON.stringify({
                "ResourceID": uuid(),
                "ResourceName": state.resName,
                "Skills": state.skills,
                "Billing": parseInt(state.billing) || 0,
                "ProjectID": state.projectId,
                
            })
        })
        .then(response => {
            setState({indicatorText: "Added new Resource"});
        }).catch(err => {setState({indicatorText: "Ran into an error while adding Resource" + err})});
    }

		return (
            <form onSubmit={onSubmit} >
            <React.Fragment>
            <div>
                <h1> Add Resource</h1>
                <h3> Enter the details of the project below</h3>

                <TextField className="field" label="Name" name="resName" value={state.resName} onChange={setProperty}/>
                <TextField className="field" label="Skills" name="skills" value={state.skills} onChange={setProperty}/>
                <TextField className="field" label="Billing (/hr)" name="billing" value={state.billing} onChange={setProperty}/>
                <TextField className="field" label="Project ID" name="projectId" value={state.projectId} onChange={setProperty}/>
                <PrimaryButton className="Add" text="Add" onClick={onSubmit} allowDisabledFocus />

                <br/>
                <label className="Indicator">{state.indicatorText}</label>
            
            </div>
            </React.Fragment>
            </form>
            
        );
} 

export default AddResource; 
