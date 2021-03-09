// authProvider.js
import { MsalAuthProvider, LoginType } from 'react-aad-msal';
 
// Msal Configurations
const config = {
  auth: {
    authority: 'https://login.microsoftonline.com/common',
    clientId: '69eae811-3023-42d6-a909-f784ee78c95a',
    redirectUri: 'http://localhost:3000'
  },
  cache: {
    cacheLocation: "localStorage",
    storeAuthStateInCookie: true
  }
};
 
// Authentication Parameters
const authenticationParameters = {
  scopes: [  
    'user.read'
  ]
}
 
// Options
const options = {
  loginType: LoginType.Redirect,
  tokenRefreshUri: window.location.origin
}
 
export const authProvider = new MsalAuthProvider(config, authenticationParameters, options)