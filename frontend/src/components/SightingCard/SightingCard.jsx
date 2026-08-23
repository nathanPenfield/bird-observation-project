import "./SightingCard.css"

function SightingCard({sighting}){
    return (
        <li className="sighting" key={sighting.id}>
            <div>{sighting.species.name}</div>
            <div>{sighting.date} {sighting.time}</div>
            <div>{sighting.location}</div>
        </li>
    );  
}

export default SightingCard