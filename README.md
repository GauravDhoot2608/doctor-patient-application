# doctor-patient-application
Platform where doctors can register their patients through a mobile or web portal. \
For this to work we need to build backend APIs to achieve task like: \
Adding a doctor & their speciality \
Adding a patient & it’s symptom \
Suggesting the doctor based on patient’s symptom


## Setup Instructions
To set up the project locally, follow these steps:

1. Clone the repository to your local machine:
2. Install dependencies:
3. Start the server:
4. The server should now be running locally. You can access the API at `http://localhost:8080/`
5. Swagger list of all apis `http://localhost:8080/swagger-ui/index.html#/`

## API Documentation

* Add Doctor:
  **POST** `/api/doctors/add`

* Add Patient:
  **POST** `/api/patients/add`

* Delete Doctor:
  **DELETE** `/api/doctors/{id}`

* Delete Patient:
  **DELETE** `/api/patients/{id}`

* Suggested Doctors:
  **GET** `/api/patients/suggestedDoctors/patientId=?`



