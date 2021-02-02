import React from 'react';
import './Search.css';
import { If, Else, Elif } from 'rc-if-else';

const _MS_PER_DAY = 1000 * 60 * 60 * 24;
class Search extends React.Component{

    state = {
        searchString: "",
        projectID: "",
        projectName : "",
        description : "",
        startDate : new Date(),
        endDate : new Date(),
        projDetailsVisible: false,
        resources: [],
        projNotFound: false,
        shouldShowProjections: false,
        totalBill: 0
    }

    setProperty = (e) => this.setState({ [e.target.name] : e.target.value });

    onSubmit = async(e) => {
        e.preventDefault();
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/Search?code=CbTDUtF5NSctIKh/jP6BmrifZ17wiSyQvqc0COv0G1ybdouglcICWw==&ProjectName="+this.state.searchString;
        //const url = "http://localhost:7071/api/AddProject";
        fetch(url, {
              method : "GET",
            }).then(response => response.json()
            ).then(project => {
                if(project.projectID != null)
                {
                this.setState(
                    {
                      projNotFound: false,
                      projDetailsVisible: true,
                      shouldShowProjections: false,
                      projectID: project.projectID,
                      projectName: project.projectName,
                      startDate: new Date(Date.parse(project.startDate)),
                      endDate: new Date(Date.parse(project.endDate)),
                      description: project.description,
                      resources: project.resources
                    }
                );
                }
                else{
                    this.setState(
                        {
                            projNotFound: true,
                            projDetailsVisible: false,
                            shouldShowProjections: false
                        })
                }

            }).catch(err => {alert(err)});
      }
      
      showProjections = () => {
          var billing = 0
        this.state.resources.map(res =>{
            billing +=res.billing;   
        } )   
        var a = this.state.startDate;
        var b = this.state.endDate;
        const utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
        const utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());
        var diffdays = Math.floor((utc2 - utc1) / _MS_PER_DAY);
        billing *= diffdays  
        this.setState({
            totalBill : billing,
            shouldShowProjections: true
        })
      }

    render(){
        return(
            <div className="SearchSection">
                <form onSubmit={this.onSubmit} >
                <h1 >Search for the Project ID</h1>
                <table>
                    <tr>
                        <th><label >Project ID</label></th>
                        <th><input type="text" id="ProjectID" name="searchString" value = {this.state.searchString} onChange={this.setProperty}/></th>
                    </tr>
                </table><br/>
                <button id="search">Search</button>
                </form> <br/>
                <If condition={this.state.projNotFound}>
                    <h3> Project not found! </h3>
                </If>
                <If condition={this.state.projDetailsVisible}>
                <h2 className = "projdetailheader"> Project Details </h2>
                <table className="projdetails">
                    <tr className="projfield"> 
                        <th><label >Project ID</label></th>
                        <th><label>{this.state.projectID}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Project Name</label></th>
                        <th><label>{this.state.projectName}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Description</label></th>
                        <th><label>{this.state.description}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Start Date</label></th>
                        <th><label>{this.state.startDate.toString()}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>End Date</label></th>
                        <th><label>{this.state.endDate.toString()}</label></th>
                    </tr>
                    <br/>
                    <If condition={this.state.resources.length > 0}>
                    <h3> Resources </h3>
                    <ul className="projfield">
                    { this.state.resources.map(res =>
                        <li className="projfield">{res.resourceName}</li>)
                    }
                    </ul>
                    
                    </If>
                    <If condition={this.state.resources.length == 0}>
                    <h3> No resources assigned to the project as of now. </h3>
                    </If>
                </table>
                </If>
                <If condition={this.state.resources.length > 0}>
                 <button id="Projections" onClick={this.showProjections}>Show Projection</button>
                </If>
                <If condition={this.state.shouldShowProjections} >
                    <table className="BillingTable">
                        <tr>
                            <th> Resource Name</th>
                            <th> Bill (/day) </th>
                            <th> Bill for the project duration</th>
                        </tr>
                        { this.state.resources.map(res =>
                        <tr>
                            <th className="resentry"> {res.resourceName} </th>
                            <th className="resentry"> ${res.billing} </th>
                            <th className="resentry"> ${res.billing * ((this.state.endDate - this.state.startDate)/_MS_PER_DAY)}</th>
                        </tr>)}
                        <br/>
                        <tr>
                            <th> Total</th>
                            <th>  - </th>
                            <th> ${this.state.totalBill} </th>
                        </tr>
                    </table>
                    
                </If>
            </div>
        );
    }
}

export default Search;