import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider} from 'react-router-dom'
import MySightings from './pages/MySightings.jsx'
import Home from './pages/Home.jsx'
import IndividualSighting from './pages/IndividualSighting.jsx'
import NotFoundPage from './pages/NotFoundPage.jsx'
import LogSighting from './pages/LogSighting.jsx'
import "./index.css"

const router = createBrowserRouter([
  {'path':"/",'element':<Home/>},
  {'path':"/mysightings",'element':<MySightings/>},
  {'path':"/mysightings/:id",'element':<IndividualSighting/>},
  {'path':"/log",'element':<LogSighting/>},
  {'path':"*",'element':<NotFoundPage/>}
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
