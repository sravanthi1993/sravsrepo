import React, {useState, useEffect} from 'react'; 
import {v1 as uuid} from "uuid"; 
import "./AddProject.css"
import { Label } from 'office-ui-fabric-react/lib/Label';
import { TextField, PrimaryButton, ChoiceGroup, Stack, IStackTokens } from 'office-ui-fabric-react';
import { DatePicker, DayOfWeek, IDatePickerStrings, mergeStyleSets } from 'office-ui-fabric-react';

	const AddProject = () => {
        const [state, setState] = useState({
            projName : "",
            description : "",
            startDate : new Date(),
            endDate : new Date(),
            indicatorText: "",
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

        const [poStatusOptions, setPoStatusOptions] = useState([
            { key: 'active', text: 'Active' },
            { key: 'inActive', text: 'Inactive' },
          ])  

          const [poTypes, setPOTypes] = useState([
            { key: 'sow', text: 'SOW' },
            { key: 'beeline', text: 'Beeline' },
          ]) 

          const [projTypes, setProjTypes] = useState([
            { key: 't&m', text: 'T&M' },
            { key: 'fixed', text: 'Fixed Price' },
            { key: 'na', text: 'N/A' }
          ])

        function setOption(e, option) {
            setState(prevState => { return {...prevState, [e.target.name]:option.key}})
        }

        function setProperty(e) {
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
                  mode: "no-cors",
                  headers: {
                      'Content-Type': 'application/json',
                      // 'Content-Type': 'application/x-www-form-urlencoded',
                    },
                  body:  JSON.stringify({
                      "ProjectID": uuid(),
                      "ProjectName": state.projName,
                      "Description": state.description,
                      "StartDate": state.startDate,
                      "EndDate": state.endDate,
                      "PoStatus": state.poStatus == "active" ? 0: 1,
                      "PoValue": parseInt(state.poValue) || 0,
                      "PoNumber": parseInt(state.poNum) || 0,
                      "OrginalPoNumber": parseInt(state.origPoNum) || 0,
                      "PoType": state.poType == "sow" ? 0: 1,
                      "ProjectType": state.projType == "t&m" ? 0 : 1,
                      "SalesSegment": state.salesSegment,
                      "Cluster": state.cluster,
                      "ClientPartner": state.clientPartner,
                      "AccountManager": state.accountManager,
                      "CdmName": state.cdmName
                  })
              }).then(response => {
                  setState({indicatorText: "Added new Project"});
              }).catch(err => {setState({indicatorText: "Ran into an error while adding project " + err})});
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
                <TextField className="field" label="PO Number" name="poNum" value={state.poNum} onChange={setProperty}/>
                <TextField className="field" label="Original PO Number" name="origPoNum" value={state.origPoNum} onChange={setProperty}/>
                <ChoiceGroup row className="field" name="poStatus" selectedKey={state.poStatus} options={poStatusOptions} onChange={setOption} label="PO Current Status" />
                <TextField className="field" label="PO Value" name="poValue" value={state.poValue} onChange={setProperty}/>
                <ChoiceGroup className="field" selectedKey={state.poType} name="poType" options={poTypes} onChange={setOption} label="PO Type" />
                <ChoiceGroup className="field" selectedKey={state.projType} name="projType" options={projTypes} onChange={setOption} label="Project Type" />
                <TextField className="field" label="Sales Segment " name="salesSegment" value={state.salesSegment} onChange={setProperty}/>
                <TextField className="field" label="Cluster" name="cluster" value={state.cluster} onChange={setProperty}/>
                <TextField className="field" label="Client Partner(L1)" name="clientPartner" value={state.clientPartner} onChange={setProperty}/>
                <TextField className="field" label="Account Manager(L2)" name="accountManager" value={state.accountManager} onChange={setProperty}/>
                <TextField className="field" label="CDM Name" name="cdmName" value={state.cdmName} onChange={setProperty}/>
                
                <PrimaryButton className="Add" text="AddResource" onClick={onSubmit} allowDisabledFocus />
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
