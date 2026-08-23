import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import MySightings from './pages/MySightings.jsx'
import "./index.css"

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <MySightings/>
  </StrictMode>,
)
