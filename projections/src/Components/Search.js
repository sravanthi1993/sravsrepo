import React, {useState} from 'react';
import './Search.css';
import { If, Else, Elif } from 'rc-if-else';
import { Label, PrimaryButton, List } from 'office-ui-fabric-react';
import { SearchBox, ISearchBoxStyles } from 'office-ui-fabric-react/lib/SearchBox';
import { DetailsList, DetailsListLayoutMode, Selection, IColumn } from 'office-ui-fabric-react/lib/DetailsList';


const _MS_PER_DAY = 1000 * 60 * 60 * 24;
function Search(){

    const [items, setItems] = useState([]);
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
        totalBill: 0,
        poStatus:"active",
        poValue: "",
        poNum: "",
        origPoNum: "",
        poType: "sow",
        projType: "t&m",
        salesSegment: "",
        cluster: "",
        clientPartner: "",
        accountManager: "",
        cdmName: ""
      });

    function UpdateItems()
    {
        console.log("hereeee");
        setItems( [
            {
                "Field": "PO Number",
                "Value": state.poNum
            },
            {
                "Field": "Name",
                "Value": state.projectName
            }, {
                "Field": "Description",
                "Value": state.description
            }, {
                "Field": "Start Date",
                "Value": state.startDate.toString()
            }, {
                "Field": "End Date",
                "Value": state.endDate.toString()
            }, {
                "Field": "Original PO Number",
                "Value": state.origPoNum
            }, {
                "Field": "PO Current Status",
                "Value": state.poStatus
            }, {
                "Field": "PO Value",
                "Value": state.poValue
            }, {
                "Field": "PO Type",
                "Value": state.poType
            }, {
                "Field": "Project Type",
                "Value": state.projType
            }, {
                "Field": "sSales Segment",
                "Value": state.salesSegment
            }, {
                "Field": "Cluster ",
                "Value": state.cluster
            }, {
                "Field": "Client Partner(L1)",
                "Value": state.clientPartner
            }, {
                "Field": "Account Manager(L2)",
                "Value": state.accountManager
            }, {
                "Field": "CDM Name",
                "Value": state.cdmName
            }
        ]);
    }
    
    React.useEffect(() => {
        UpdateItems();
      }, [state]);

    function onSubmit(searchString) {
        //e.preventDefault();
        console.log(searchString + "------------")
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/Search?code=CbTDUtF5NSctIKh/jP6BmrifZ17wiSyQvqc0COv0G1ybdouglcICWw==&ProjectName="+searchString;
        //const url = "http://localhost:7071/api/Search?ProjectName="+searchString;
        

        fetch(url, {
              method : "GET",
              mode: "cors",
            }).then(response => response.json()
            ).then(project => {
                if(project.poNumber != null)
                {
                setState(prevstate =>
                    {return{...prevstate,
                      shouldShowProjections: false,
                      projectName: project.projectName,
                      startDate: new Date(Date.parse(project.startDate)),
                      endDate: new Date(Date.parse(project.endDate)),
                      description: project.description,
                      resources: project.resources,
                      poStatus: project.poStatus == 0 ? "Active" : "Inactive",
                      poValue: project.poValue,
                      poType: project.poType == 0 ? "SOW" : "Beeline",
                      projType: project.projectType == 0 ? "T&M" : "Fixed Price",
                      poNum: project.poNumber,
                      origPoNum: project.orginalPoNumber,
                      salesSegment: project.salesSegment,
                      cluster: project.cluster,
                      clientPartner: project.clientPartner,
                      accountManager: project.accountManager,
                      cdmName: project.cdmName
                    }
                    }
                );
                setState(prevState =>
                    {return {...prevState, 
                      projDetailsVisible: true,  
                      projNotFound: false,
                    }})
                }
                else{
                    setState(prevstate =>
                        {return{...prevstate,
                            projNotFound: true,
                            projDetailsVisible: false,
                            shouldShowProjections: false}
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
        setState(prevstate => {
            return{...prevstate,totalBill : billing,
                shouldShowProjections: true}
            
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
                    <DetailsList
                        items={items}
                        setKey="set"
                        layoutMode={DetailsListLayoutMode.justified}
                    /> <br/>
                    <If condition={state.resources.length > 0}>
                    <Label className="field"> Resources </Label>
                    <div className="projfield">
                    { state.resources.map(res =>
                        <li className="projfield">{res.resourceName}</li>)
                    }
                    </div> 
                    </If>
                    <If condition={state.resources.length == 0}>
                    <h3> No resources assigned to the project as of now. </h3>
                    </If>
                    <br/>
                </If>
                <If condition={state.resources.length > 0}>
                 <PrimaryButton id="Projections" onClick={showProjections}>Show Projection</PrimaryButton>
                </If>
                <br></br>
                <If condition={state.shouldShowProjections} >
                <br></br>
                    <table className="BillingTable">
                        <tbody>
                        <tr>
                            <td> Resource Name</td>
                            <td> Bill (/day) </td>
                            <td> Bill for the project duration</td>
                        </tr>
                        { state.resources.map(res =>
                        <tr>
                            <td className="resentry"> {res.resourceName} </td>
                            <td className="resentry"> ${res.billing} </td>
                            <td className="resentry"> ${res.billing * ((state.endDate - state.startDate)/_MS_PER_DAY)}</td>
                        </tr>)}
                        <br/>
                        <tr>
                            <td> Total</td>
                            <td>  - </td>
                            <td> ${state.totalBill} </td>
                        </tr>
                        </tbody>
                    </table>
                    
                </If>
            </div>
        );
}

export default Search;