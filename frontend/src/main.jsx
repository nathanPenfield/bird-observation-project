import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { createBrowserRouter, RouterProvider} from 'react-router-dom'
import MySightings from './pages/MySightings.jsx'
import Home from './pages/Home.jsx'
import "./index.css"

const router = createBrowserRouter([
  {'path':"/",'element':<Home/>},
  {'path':"/mysightings",'element':<MySightings/>}
]);

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router}/>
  </StrictMode>,
)
