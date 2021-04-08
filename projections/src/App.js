import React, {useState} from 'react'
import AddProject from './Components/AddProject'
import AddResource from './Components/AddResource'
import Search from './Components/Search'
import Holidays from './Components/Holidays'
import { BrowserRouter } from 'react-router-dom'
import { Link, Label } from 'office-ui-fabric-react';
import { BrowserRouter as Switch, Route} from 'react-router-dom'
import './App.css';
import {AzureAD, AuthenticationState} from 'react-aad-msal'
import {authProvider} from './AuthProvider'
import Projects from "./Components/Projects";
function App() {

  const [useraccess, setuseraccess] = useState(false);
  const[projectlist,setprojectlist] = useState([]);
  const [callcompleted, setcallcompleted] = useState(false);
  function isUserPrevileged(userName)
  {
    if(callcompleted) return;
    const url = "https://projectionsazurefunctions.azurewebsites.net/api/GetProjectsforUser?code=kaSW53cyA5upWfbPFHNwRUZYJfaDs2tDxI0364LJXZEYoULHkLt3Hg==&UserName="+userName
    fetch(url, {
        method : "GET"
      }).then(response => response.json()
      ).then(useraccess => {
        setcallcompleted(true);
        if(useraccess.userInfo!=null)
        {
          console.log("HEyy !! I have access");
          setuseraccess(true);
          if(useraccess.projects!=null)
          setprojectlist(useraccess.projects);
        }
      })
  }

  return (
    
     <BrowserRouter>
       <div>
     <AzureAD
      provider={authProvider}>
      {({ login, logout, authenticationState, error, accountInfo }) => {

        if (authenticationState === AuthenticationState.Authenticated) {
          isUserPrevileged(accountInfo.account.userName);
          if(useraccess)
          {
          return (
            <div>
            
         <div class ="header">
     <Label className="Content"> Project Billing Projections </Label>
     <Link href="/" className="Content"> Home</Link>  | 
     <Link href="/addproject"  className="Content"> AddProject</Link>  | 
     <Link href="/addresource"  className="Content"> AddResource</Link> |
     <Link href="/search"  className="Content"> Search</Link> |
     <Link href="/holidays" className ="Content">Holidays</Link>
            <div>
            <label className = "username" > {accountInfo.account.userName}</label> <br/>
          <button className = "logout" onClick={logout} color="inherit" variant="outlined">Log Out</button></div></div>
          </div>);
        }
          else if(!callcompleted)
          {
            return <h1> Loading ..... </h1>
          }
          else 
          {
            return (<div>
            <div class ="header">
              <label className = "usernamenoaccess" > {accountInfo.account.userName}</label> <br/>
          <button className = "logoutnoaccess" onClick={logout} color="inherit" variant="outlined">Log Out</button> </div>
          <h2> Sorry!! You don't have access to this application. Please ask your Admin to get access to this.</h2>
           </div>)
          }
        }
      }}
    </AzureAD>
     
         <Switch>
         <Route exact path="/" render={props =>(
           <React.Fragment>
             <Projects projectlist={projectlist}/>
           </React.Fragment>
         )}/>
          </Switch>
       <Route exact path="/addproject" component={AddProject}/>
       <Route exact path="/addresource" component={AddResource}/>
       <Route path="/search" component={Search}/>
       <Route path="/holidays" component={Holidays}/>
      
       </div>
      </BrowserRouter>
  );
}

export default App;
