import React from 'react';
import {v1 as uuid} from "uuid"; 

class AddResource extends React.Component 
{ 
    uuid = require('uuid');
    state = {
        resName : "",
        skills : "",
        billing : "",
        projectId : "",
        indicatorText : ""
    }

    //this.setState( { "projName" : "asadsa" });
    setProperty = (e) => this.setState({ [e.target.name] : e.target.value });


    onSubmit = (e) => {
      e.preventDefault();
      const url = "https://projectionsazurefunctions.azurewebsites.net/api/AddResource?code=20KXEmWE7j4hdDDcfYzaqH0fU48lLMxM8ufMP5xKZe5HaLqmMAq3fw==";
      //const url = "http://localhost:7071/api/AddResource";
      fetch(url, {
            method : "POST",
            body:  JSON.stringify({
                "ResourceID": uuid(),
                "ResourceName": this.state.resName,
                "Skills": this.state.skills,
                "Billing": parseInt(this.state.billing) || 0,
                "ProjectID": this.state.projectId
            })
        })
        .then(response => {
            this.setState({indicatorText: "Added new Resource"});
        }).catch(err => {this.setState({indicatorText: "Ran into an error while adding Resource" + err})});
    }

	render(){ 
		return (
            <form onSubmit={this.onSubmit} >
            <React.Fragment>
            <div>
                <h1> Add Resource</h1>
                <h3> Enter the details of the project below</h3>
                <table>
                <tr>
                <th><label> Name </label> </th>
                <th><input name="resName" type="text" id="name" value = {this.state.resName} onChange={this.setProperty}/> </th>
                </tr>
                <tr>
                <th><label> Skills </label></th>
                <th><input name="skills" type="text" id="skills" value = {this.state.skills} onChange={this.setProperty}/> </th>
                </tr>
                <tr>
                <th><label> Billing </label></th>
                <th><input name="billing" type="text" id="billing" value = {this.state.billing} onChange={this.setProperty}/> </th>
                </tr>
                <tr>
                <th><label> Project Name </label></th>
                <th><input name="projectId" type="text" id="projectId" value = {this.state.projectId} onChange={this.setProperty}/> </th>
                </tr>
                </table>
                <button id="AddResource"> Add </button>
                <br/>
                <label className="Indicator">{this.state.indicatorText}</label>
            
            </div>
            </React.Fragment>
            </form>
            
        );
	} 
} 

export default AddResource; 
