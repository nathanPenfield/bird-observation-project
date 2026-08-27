## ChirpLog
ChirpLog is a full-stack web application for recording and managing bird sightings, inspired by platforms such as eBird. The project combines my interest in birdwatching and photography with my goal of building practical experience with modern full-stack development.

## Current Progress
The backend is built with Java, Spring Boot, PostgreSQL, and Docker. It provides a RESTful API for creating, viewing, updating, and deleting bird observations, with data persisted in PostgreSQL.

The frontend is being developed with React and JavaScript and currently includes:
* A form for logging bird observations
* A sightings page for viewing recorded observations
* Individual sighting pages for viewing observation details
* Integration with the backend REST API

## Tech Stack
* **Backend:** Java, Spring Boot, JPA
* **Frontend:** React, JavaScript, HTML/CSS
* **Database:** PostgreSQL
* **Development:** Docker, Git

## Roadmap
Future plans include:
* Expanding the species database
* Adding bird sighting analytics and statistics
* Exploring integration with the eBird API
* Adding additional features to make logging observations easier in the field

## Why I Built It
I built ChirpLog as both a personal project and a way to strengthen my full-stack development skills. As a birdwatcher and photographer, I wanted to create something around an interest of mine while learning technologies such as Java, Spring Boot, PostgreSQL, and React through a real application rather than isolated tutorials.

## How to run
1. Clone repo
2. Docker compose up (this creates the docker container with postgres)
3. ./backend/mvnw spring-boot:run
4. ./frontend npm run dev
5. Go to localhost:5173
