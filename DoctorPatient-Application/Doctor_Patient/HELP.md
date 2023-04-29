# Backend APIs for Doctor-Patient Platform
 ### This repository contains the code for building a backend API that manages the doctor-patient platform. The API has been built using Spring Boot framework and Hibernate for database operations.

## Features
## The API includes the following features:

### Adding a doctor to the platform.
### Adding a patient and their symptom to the platform.
### Suggesting a doctor based on a patient's symptom and location.

## Entities
### The API includes two entities:

## Doctor
The doctor entity contains the following attributes:

- id (integer): the unique identifier for the doctor.
- name (string): the name of the doctor.
- city (string): the city where the doctor is located.
- email (string): the email address of the doctor.
- phone (string): the phone number of the doctor.
- speciality (string): the speciality of the doctor. This can have four possible values: Orthopedic, Gynecology, Dermatology, or ENT specialist.

## Patient
The patient entity contains the following attributes:

- id (integer): the unique identifier for the patient.
- name (string): the name of the patient.
- city (string): the city where the patient is located.
- email (string): the email address of the patient.
- phone (string): the phone number of the patient.
- symptom (string): the symptom of the patient. This can have several possible values, depending on the patient's speciality.


## Validations
The following fields have the following validations:

- name: should be at least 3 characters.
- city: should be at max 20 characters.
- email: should be a valid email address.
- phone: should be at least 10 numbers.
