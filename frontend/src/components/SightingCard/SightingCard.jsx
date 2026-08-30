import "./SightingCard.css"
import { Link } from "react-router-dom";

function SightingCard({sighting}){
    return (
        <li className="sighting">
            <Link to={`/mysightings/${sighting.id}`}>
                <div>{sighting.species.name}</div>
                <div>{sighting.date} {sighting.time}</div>
                <div>{sighting.location.name}</div>
            </Link>
        </li>
    );  
}

export default SightingCard