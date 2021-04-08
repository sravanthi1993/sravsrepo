import React, {useState} from 'react';
import './Search.css';
import { If, Else, Elif } from 'rc-if-else';
import { Label, Link, PrimaryButton, List } from 'office-ui-fabric-react';
import { SearchBox, ISearchBoxStyles } from 'office-ui-fabric-react/lib/SearchBox';
import { DetailsList, DetailsListLayoutMode, SelectionMode, Selection, IColumn } from 'office-ui-fabric-react/lib/DetailsList';
import Projects from "./Projects";

function Search(){
 
    const searchBoxStyles = { root: { width: 200 } };
    const [projlist, setProjlist] = useState([])
    const [state, setState] = useState({
        searchString: "",
        projListVisible: false,
        projNotFound: false
      });

    function onSubmit(searchString) {
        //e.preventDefault();
        const url = "https://projectionsazurefunctions.azurewebsites.net/api/Search?code=CbTDUtF5NSctIKh/jP6BmrifZ17wiSyQvqc0COv0G1ybdouglcICWw==&ProjectName="+searchString;
        //const url = "http://localhost:7071/api/Search?ProjectName="+searchString;

        fetch(url, {
              method : "GET",
            }).then(response => response.json()
            ).then(projects => {
                if(projects.length != 0)
                {
                    setProjlist(projects)
                    setState(prevState =>
                    {
                        return {...prevState, 
                            projListVisible: true,  
                            projNotFound: false,
                    }})
                }
                else{
                    setState(prevstate =>
                        {return{...prevstate,
                            projNotFound: true,
                            projListVisible: false}
                        })
                }

            }).catch(err => {alert(err)});
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
                    <Projects projectlist={projlist}/>
                </If>
            </div>
        );
}

export default Search;