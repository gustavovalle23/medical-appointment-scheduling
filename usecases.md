# Medical appointment scheduling system (Java, Spring-boot)
Profiles:
  - Doctor
    - will have access to a list of all appointments that he has already performed and will perform (with date filter)
    - consultation history of the patient he searches
  - Patient
    - Will have access to a list with the appointments that he has already performed and will perform
    - Access to the doctor's profile (how many consultations he has had, average grade given by patients, specialty, career time and Biography, written by the doctor himself)
    - Appointment scheduling from a medical record
  - Manager
    - Access to medical consultations
    - Physician data as well as patients + average consultation time
    - patient complaints, with which doctor was consulted
    - best/worst doctor (based on patient grade)
    - waiting time (appointment scheduled at 2:00 pm, doctor appeared at 2:05 pm)
    - Most frequently diagnosed diseases