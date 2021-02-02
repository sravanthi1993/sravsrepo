import React, {useState} from 'react';
import './Search.css';
import { If, Else, Elif } from 'rc-if-else';
import { Label, PrimaryButton } from 'office-ui-fabric-react';
import { SearchBox, ISearchBoxStyles } from 'office-ui-fabric-react/lib/SearchBox';


const _MS_PER_DAY = 1000 * 60 * 60 * 24;
function Search(){

    const searchBoxStyles = { root: { width: 200 } };
    const [state, setState] = useState({
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
      });

    function onSubmit(searchString) {
        //e.preventDefault();
        console.log(searchString + "------------")
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/Search?code=CbTDUtF5NSctIKh/jP6BmrifZ17wiSyQvqc0COv0G1ybdouglcICWw==&ProjectName="+searchString;
        //const url = "http://localhost:7071/api/AddProject";
        fetch(url, {
              method : "GET",
            }).then(response => response.json()
            ).then(project => {
                if(project.projectID != null)
                {
                setState(
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
                    setState(
                        {
                            projNotFound: true,
                            projDetailsVisible: false,
                            shouldShowProjections: false
                        })
                }

            }).catch(err => {alert(err)});
      }
      
      function showProjections() {
          var billing = 0
        state.resources.map(res =>{
            billing +=res.billing;   
        } )   
        var a = state.startDate;
        var b = state.endDate;
        const utc1 = Date.UTC(a.getFullYear(), a.getMonth(), a.getDate());
        const utc2 = Date.UTC(b.getFullYear(), b.getMonth(), b.getDate());
        var diffdays = Math.floor((utc2 - utc1) / _MS_PER_DAY);
        billing *= diffdays  
        setState({
            totalBill : billing,
            shouldShowProjections: true
        })
      }

        return(
            <div className="SearchSection">
                <Label>Search for the Project ID</Label>
                <SearchBox
                    styles={searchBoxStyles}
                    placeholder="Enter the Project name"
                    onSearch={onSubmit}
                />
                <If condition={state.projNotFound}>
                    <h3> Project not found! </h3>
                </If>
                <If condition={state.projDetailsVisible}>
                <h2 className = "projdetailheader"> Project Details </h2>
                <table className="projdetails">
                    <tr className="projfield"> 
                        <th><label >Project ID</label></th>
                        <th><label>{state.projectID}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Project Name</label></th>
                        <th><label>{state.projectName}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Description</label></th>
                        <th><label>{state.description}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>Start Date</label></th>
                        <th><label>{state.startDate.toString()}</label></th>
                    </tr>
                    <tr className="projfield">
                        <th><label>End Date</label></th>
                        <th><label>{state.endDate.toString()}</label></th>
                    </tr>
                    <br/>
                    <If condition={state.resources.length > 0}>
                    <h3> Resources </h3>
                    <ul className="projfield">
                    { state.resources.map(res =>
                        <li className="projfield">{res.resourceName}</li>)
                    }
                    </ul>
                    
                    </If>
                    <If condition={state.resources.length == 0}>
                    <h3> No resources assigned to the project as of now. </h3>
                    </If>
                </table>
                </If>
                <If condition={state.resources.length > 0}>
                 <button id="Projections" onClick={showProjections}>Show Projection</button>
                </If>
                <If condition={state.shouldShowProjections} >
                    <table className="BillingTable">
                        <tr>
                            <th> Resource Name</th>
                            <th> Bill (/day) </th>
                            <th> Bill for the project duration</th>
                        </tr>
                        { state.resources.map(res =>
                        <tr>
                            <th className="resentry"> {res.resourceName} </th>
                            <th className="resentry"> ${res.billing} </th>
                            <th className="resentry"> ${res.billing * ((state.endDate - state.startDate)/_MS_PER_DAY)}</th>
                        </tr>)}
                        <br/>
                        <tr>
                            <th> Total</th>
                            <th>  - </th>
                            <th> ${state.totalBill} </th>
                        </tr>
                    </table>
                    
                </If>
            </div>
        );
}

export default Search;