import React from 'react'
import AddProject from './Components/AddProject'
import AddResource from './Components/AddResource'
import Search from './Components/Search'
import { Link, BrowserRouter } from 'react-router-dom'
import { BrowserRouter as Switch, Route} from 'react-router-dom'
import './App.css';

function App() {

  return (
    
     <BrowserRouter>
       <div>
         <div class ="header">
         <h3 class="Content"> What do you want to do today </h3>
     <Link to="/" class="Content"> Home</Link>  | 
     <Link to="/addproject"  class="Content"> AddProject</Link>  | 
     <Link to="/addresource"  class="Content"> AddResource</Link> |
     <Link to="/search"  class="Content"> Search</Link>
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
      
       </div>
      </BrowserRouter>
  );
}

export default App;
