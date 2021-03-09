import React from 'react'
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

function App() {

  return (
    
     <BrowserRouter>
       <div>
         <div class ="header">
     <Label className="Content"> Project Billing Projections </Label>
     <Link href="/" className="Content"> Home</Link>  | 
     <Link href="/addproject"  className="Content"> AddProject</Link>  | 
     <Link href="/addresource"  className="Content"> AddResource</Link> |
     <Link href="/search"  className="Content"> Search</Link> |
     <Link href="/holidays" className ="Content">Holidays</Link>
     <AzureAD
      provider={authProvider}>
      {({ login, logout, authenticationState }) => {
        if (authenticationState === AuthenticationState.Authenticated) {
          return (<button className = "logout" onClick={logout} color="inherit" variant="outlined">Log Out</button>);
        }
      }}
    </AzureAD>
     </div>
     
         <Switch>
         <Route exact path="/" render={props =>(
           <React.Fragment>
          
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
