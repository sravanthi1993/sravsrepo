import React, {useState} from 'react';
import './Search.css';
import { If, Else, Elif } from 'rc-if-else';
import { Label, Link, PrimaryButton, List } from 'office-ui-fabric-react';
import { SearchBox, ISearchBoxStyles } from 'office-ui-fabric-react/lib/SearchBox';
import { DetailsList, DetailsListLayoutMode, SelectionMode, Selection, IColumn } from 'office-ui-fabric-react/lib/DetailsList';

const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];

const _MS_PER_DAY = 1000 * 60 * 60 * 24;
//const holidays = [new Date(2021,1,19), new Date(2021,4,28)];
var listofholidays = []
function Search(){

    const [projlist, setProjlist] = useState([]);
    const [resourceDetails, setResourceDetails ] = useState([]);
    const [billingDetails, setBillingDetails] = useState([]);
    const [items, setItems] = useState([]);
    const searchBoxStyles = { root: { width: 200 } };
    const [state, setState] = useState({
        searchString: "",
        projectID: "",
        projectName : "",
        description : "",
        startDate : new Date(),
        endDate : new Date(),
        projListVisible: false,
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
        var resDetails = [];
        state.resources.map(res =>{
            resDetails.push(
                {
                    "ResourceName": res.resourceName,
                    "Billing (/day)": res.billing,
                }
            )   
        } ) 
        setResourceDetails(resDetails) ;
    }
    
    React.useEffect(() => {
        UpdateItems();
      }, [state]);

    function setCurrentProject(e) {
        var project = projlist[e.target.name]
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
              cdmName: project.cdmName,
              projDetailsVisible: true
            }
            }
        );
    }

    function onSubmit(searchString) {
        //e.preventDefault();
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/Search?code=CbTDUtF5NSctIKh/jP6BmrifZ17wiSyQvqc0COv0G1ybdouglcICWw==&ProjectName="+searchString;
        //const url = "http://localhost:7071/api/Search?ProjectName="+searchString;
        

        fetch(url, {
              method : "GET",
            }).then(response => response.json()
            ).then(projects => {
                console.log(projects)
                if(projects.length != 0)
                {
                    setProjlist(projects)
                
               /* if(project.poNumber != 0)
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
                );*/
                setState(prevState =>
                    {return {...prevState, 
                        projListVisible: true,  
                      projNotFound: false,
                    }})
                }
                else{
                    setState(prevstate =>
                        {return{...prevstate,
                            projNotFound: true,
                            projListVisible: false,
                            projDetailsVisible: false,
                            shouldShowProjections: false}
                        })
                }

            }).catch(err => {alert(err)});
      }
      
     function computeWorkingDaysBetweenTwoDays(startDate, endDate) {
      
      // Validate input
        if (endDate < startDate) {
          return 0;
        }
      
      // Calculate days between dates
        var millisecondsPerDay = 86400 * 1000; // Day in milliseconds
        startDate.setHours(0, 0, 0, 1);  // Start just after midnight
        endDate.setHours(23, 59, 59, 999);  // End just before midnight
        var diff = endDate - startDate;  // Milliseconds between datetime objects    
        var days = Math.ceil(diff / millisecondsPerDay);
      
        // Subtract two weekend days for every week in between
        var weeks = Math.floor(days / 7);
        days -= weeks * 2;
      
        // Handle special cases
        var startDay = startDate.getDay();
        var endDay = endDate.getDay();
          
        // Remove weekend not previously removed.   
        if (startDay - endDay > 1) {
          days -= 2;
        }
        // Remove start day if span starts on Sunday but ends before Saturday
        if (startDay == 0 && endDay != 6) {
          days--;  
        }
        // Remove end day if span ends on Saturday but starts after Sunday
        if (endDay == 6 && startDay != 0) {
          days--;
        }

        /* Here is the code */
        listofholidays.forEach(day => {
            //console.log(day + " -- " + startDate + " -- " + endDate)
          if ((day >= startDate) && (day <= endDate)) {
              days--;
          }
        });
        return days;
     }

      function showProjections() {
          
        //const url = "http://localhost:7071/api/search";
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/GetHolidays?code=IGZG4SdEVqbHWYhV32asIb8junLY3IttJDVB4KjCjL3aNGyr0L1rOg=="
        fetch(url, {
            method : "GET"
          }).then(response => response.json()
          ).then(holidays => {
              console.log(holidays);
              holidays.map(holiday =>  
                {
                    listofholidays.push(new Date(Date.parse(holiday.holidayDate)))
                });
              console.log(listofholidays)

              var total = 0;
              var billDetails = [];
              var billMap = new Map();

              state.resources.map(res => {

                var billing = res.billing
                 // var a = new Date(res.resourceProjStartDate);
                  //var b = state.endDate;
                  var start = new Date(res.resourceProjStartDate);
                  var end = new Date(start.getFullYear(), start.getMonth() + 1, 0);
                  console.log(start + " - " + end + " - " + billing)
                  end = (end > state.endDate) ? state.endDate : end;
                  var year = start.getFullYear();
                  while (end >= start) {
                      var diffDays = computeWorkingDaysBetweenTwoDays(start, end);
                      total += billing * diffDays;

                      var key = monthNames[start.getMonth()] + " " + start.getFullYear();
                      console.log(key + "-" + billMap.get(key));
                      if(!billMap.has(key))
                      {
                        billMap.set(key, 0);
                      }
                      billMap.set(key, billMap.get(key) + (billing * diffDays));
                      

                      var month = start.getMonth() == 11 ? -1 : start.getMonth();
                      year = start.getMonth() == 11 ? year + 1 : year;
                      start = new Date(year, month + 1, 1);
                      end = new Date(year, start.getMonth() + 1, 0);
                      end = (end >= state.endDate) ? state.endDate : end;
                      console.log(start + " - " + end + " - " + billing)
                  }
              })

      
             setState(prevstate => {
                  return{...prevstate,totalBill : total,
                      shouldShowProjections: true,}
                  
              })
              
              for (const [key, value] of billMap) {
                billDetails.push(
                    {
                        "Month": key,
                        "Monthly Bill": "$" + value
                    },
                )
                console.log(`${key}: ${value}`);
              }

             
            //   billMap.map(monthlyBill => {
            //       billDetails.push(
            //           {
            //               "Month": monthlyBill,
            //               "Monthly Bill": "$" + (billing * diffDays)
            //           },
            //       )
            //   })

              setBillingDetails(billDetails);
          });

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
                
                <If condition={state.projListVisible}>
                <h1 className = "ProjectsList"> Projects List </h1>
                {
                    projlist.map((proj , index)=> {
                        console.log(proj.projectName);
                        return <div><Link onClick={setCurrentProject} name= {index}>{proj.projectName} </Link> <br/></div>
                    })
                }
                </If>

                <If condition={state.projDetailsVisible}>
                {/* <DetailsList
                    items ={projlist}
                    setKey = "set"
                    layoutMode={DetailsListLayoutMode.justified}
                    selectionMode={SelectionMode.none}
                /> */}
                <h2 className = "projdetailheader"> Project Details </h2>
                    <DetailsList
                        items={items}
                        setKey="set"
                        layoutMode={DetailsListLayoutMode.justified}
                        selectionMode={SelectionMode.none}
                    /> <br/>
                    <If condition={state.resources.length > 0}>
                    <h3> Resources </h3>
                    <DetailsList
                        items={resourceDetails}
                        setKey="set"
                        layoutMode={DetailsListLayoutMode.justified}
                        selectionMode={SelectionMode.none}
                    /> 
                    </If>
                    <If condition={state.resources.length == 0}>
                    <h3> No resources assigned to the project as of now. </h3>
                    </If>
                    <br/>
                </If>
                <If condition={state.projDetailsVisible && state.resources.length > 0}>
                 <PrimaryButton id="Projections" onClick={showProjections}>Show Projection</PrimaryButton>
                </If>
                <br></br>
                <If condition={state.shouldShowProjections} >
                <DetailsList
                        items={billingDetails}
                        setKey="set"
                        layoutMode={DetailsListLayoutMode.justified}
                        selectionMode={SelectionMode.none}
                    /> 
                    <h3> Total Bill - ${state.totalBill}</h3>
                </If>
            </div>
        );
}

export default Search;