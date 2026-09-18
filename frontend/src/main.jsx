import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider} from 'react-router-dom'
import MySightings from './pages/MySightings.jsx'
import Home from './pages/Home.jsx'
import IndividualSighting from './pages/IndividualSighting.jsx'
import NotFoundPage from './pages/NotFoundPage.jsx'
import LogSighting from './pages/LogSighting.jsx'
import SignIn from './pages/SignIn.jsx'
import SignUp from './pages/SignUp.jsx'
import Profile from './pages/Profile.jsx'
import About from './pages/About.jsx'
import { AuthProvider } from './context/AuthContext.jsx'
import ProtectedRoute from './components/ProtectedRoute.jsx'
import "./index.css"

const router = createBrowserRouter([
  {'path':"/",'element':<Home/>},
  {'path':"/signin",'element':<SignIn/>},
  {'path':"/signup",'element':<SignUp/>},
  {'path':"/about",'element':<About/>},
  {
    'element':<ProtectedRoute/>,
    'children':[
      {'path':"/mysightings",'element':<MySightings/>},
      {'path':"/mysightings/:id",'element':<IndividualSighting/>},
      {'path':"/log",'element':<LogSighting/>},
      {'path':"/account",'element':<Profile/>},
    ],
  },
  {'path':"*",'element':<NotFoundPage/>}
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <AuthProvider>
      <RouterProvider router={router}/>
    </AuthProvider>
  </StrictMode>,
)
