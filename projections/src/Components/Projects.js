import React, { useState } from 'react';
import { If, Else, Elif } from 'rc-if-else';
import { Label, Link, PrimaryButton, List } from 'office-ui-fabric-react';
import { DetailsList, DetailsListLayoutMode, SelectionMode, Selection, IColumn } from 'office-ui-fabric-react/lib/DetailsList';

function Projects(props) {

    const [items, setItems] = useState([]);
    const [state, setState] = useState({
        projectID: "",
        projectName: "",
        description: "",
        startDate: new Date(),
        endDate: new Date(),
        resources: [],
        shouldShowProjections: false,
        totalBill: 0,
        poStatus: "active",
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

    const [projDetailsVisible, setprojDetailsVisible] = useState(false);


    function setCurrentProject(e) {

        var project = props.projectlist[e.target.name]
        setprojDetailsVisible(true)
        setState(prevstate => {
            return {
                ...prevstate,
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
                cdmName: project.cdmName,
                projDetailsVisible: true
            }
        }
        );
    }


    function UpdateItems() {
        setItems([
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
                "Field": "Sales Segment",
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

    //setprojlist(props.projectlist);
    return (<div>
        <h1 className="ProjectsList"> Projects List </h1>
        {
            props.projectlist.map((proj, index) => {
                console.log(proj.projectName);
                return <div><Link onClick={setCurrentProject} name={index}>{proj.projectName} </Link> <br /></div>
            })
        }

        <If condition={projDetailsVisible}>
            <DetailsList
                items={items}
                setKey="set"
                layoutMode={DetailsListLayoutMode.justified}
                selectionMode={SelectionMode.none}
            />
        </If>
        <br />
    </div>);

}

export default Projects;