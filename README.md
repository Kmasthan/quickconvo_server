# QuickConvo Server

## About
QuickConvo Server is the backend for the QuickConvo platform, built with **Spring Boot** and **MongoDB**. It handles messaging between farmers and buyers, managing chats. The server exposes **RESTful APIs** consumed by the frontend, ensuring reliable and secure communication.

## Technology Stack
- **Backend Framework:** Spring Boot
- **Database:** MongoDB
- **Build Tool:** Gradle
- **API Communication:** RESTful APIs (JSON)

## Features
- Real-time messaging between farmers and buyers
- CRUD operations for chats
- API endpoints for frontend integration

## Prerequisites
- Java 17
- MongoDB instance running locally or remotely
- Gradle installed

## Running the Application
1. Clone the repository:
```bash
git clone https://github.com/Kmasthan/quickconvo_server.git
```
2. Navigate to the project directory:
```bash
cd quickconvo-server
```
3. Build and run the application
```bash
./gradlew bootRun
```
