# Hospital Management Application

A console-based Hospital Management Application developed using **Core Java and the Java Module System**. This project manages patient records, doctor details, and hospital appointments through a menu-driven interface.

## Features

- **Patient Management**
  - Register new patients.
  - View registered patients.
  - Categorize patients by treatment type.

- **Doctor Management**
  - Register new doctors.
  - View registered doctors.
  - Maintain doctor specializations.

- **Appointment Management**
  - Schedule appointments between patients and doctors.
  - View appointment records.
  - Cancel scheduled appointments.
  - Track appointment status.

- **Modular Architecture**
  - Organizes the application into three Java modules.
  - Separates data models, business logic, and the user interface.

## Technologies Used

- Java
- Java Module System (JPMS)
- Object-Oriented Programming (OOP)
- Collections Framework (`ArrayList`)
- Enums
- Console-based user interface

## Project Structure

```text
Hospital-Management-Application/
├── ModuleA/
│   └── src/
│       ├── module-info.java
│       └── com/demo/
│           ├── enums/
│           │   ├── TreatmentType.java
│           │   ├── Specialization.java
│           │   └── AppointmentStatus.java
│           └── model/
│               ├── Patient.java
│               ├── Doctor.java
│               └── Appointment.java
│
├── ModuleB/
│   └── src/
│       ├── module-info.java
│       └── com/demo/
│           ├── repository/
│           └── service/
│
├── ModuleC/
│   └── src/
│       ├── module-info.java
│       └── com/demo/
│           ├── app/
│           │   └── Main.java
│           └── util/
│               └── InputUtil.java
│
└── .gitignore
```

## Module Description

### ModuleA — Models and Enums
Contains the `Patient`, `Doctor`, and `Appointment` model classes, along with enums for treatment types, doctor specializations, and appointment statuses.

### ModuleB — Repository and Service Layer
Contains repository classes for managing records and service classes for implementing patient, doctor, and appointment operations.

### ModuleC — Application Layer
Contains the main console application and input utility. Provides the menu-driven interface for interacting with the system.

## Prerequisites

- JDK installed on your computer.
- Windows Command Prompt or another terminal.
- Basic knowledge of Java.

Check your Java installation:

```cmd
java -version
javac -version
```

## How to Compile and Run

Run the following commands from the project root directory.

### 1. Compile ModuleA

```cmd
javac -d out\ModuleA ModuleA\src\module-info.java ModuleA\src\com\demo\enums\TreatmentType.java ModuleA\src\com\demo\enums\Specialization.java ModuleA\src\com\demo\enums\AppointmentStatus.java ModuleA\src\com\demo\model\Patient.java ModuleA\src\com\demo\model\Doctor.java ModuleA\src\com\demo\model\Appointment.java
```

### 2. Compile ModuleB

```cmd
javac --module-path out -d out\ModuleB ModuleB\src\module-info.java ModuleB\src\com\demo\repository\PatientRepository.java ModuleB\src\com\demo\repository\DoctorRepository.java ModuleB\src\com\demo\repository\AppointmentRepository.java ModuleB\src\com\demo\service\PatientService.java ModuleB\src\com\demo\service\DoctorService.java ModuleB\src\com\demo\service\AppointmentService.java
```

### 3. Compile ModuleC

```cmd
javac --module-path out -d out\ModuleC ModuleC\src\module-info.java ModuleC\src\com\demo\util\InputUtil.java ModuleC\src\com\demo\app\Main.java
```

### 4. Run the Application

```cmd
java --module-path out -m ModuleC/com.demo.app.Main
```

**Note:** These commands assume the source files are in the paths shown above and the package and class names match. Run each command from the project root directory.

## Learning Outcomes

- Understanding Java modular programming.
- Applying OOP principles in a real-world-style project.
- Separating application layers using repositories and services.
- Using enums to represent fixed categories and statuses.
- Managing records using Java collections.
- Building a menu-driven console application.

## Future Enhancements

- Integrate MySQL using JDBC for persistent storage.
- Add stronger input validation and exception handling.
- Develop a graphical user interface using Java Swing or JavaFX.
- Add patient search and appointment filtering.
- Introduce login and role-based access.

## Author

**Suraj**

GitHub: [@02suraj-c](https://github.com/02suraj-c)
