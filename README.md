![Java](https://img.shields.io/badge/JAVA-E65100?style=for-the-badge&labelColor=FFFFFF)
![Maven](https://img.shields.io/badge/MAVEN-0074D9?style=for-the-badge&labelColor=FFFFFF)
![Lombok](https://img.shields.io/badge/LOMBOK-E53935?style=for-the-badge&labelColor=FFFFFF)

A Java-based employee management system developed as a technical test for **Projedata**.

## Project Overview

This project simulates a small employee management system for an industry, featuring core object-oriented concepts and data processing in Java. The system enables management and reporting of employee data, salary updates, grouping, and various queries, all via a simple command-line interface.

## Features

- **Person and Employee Classes:** `Person`: name and date of birth. `Employee` (extends `Person`): salary and job title.


- **Operations:**
- Insert all employees from a given list.
- Remove an employee named "João".
- Print all employee details: Dates formatted as `dd/MM/yyyy`. Salaries formatted with thousand separators (`.`) and decimals as comma (`,`).
- Apply a 10% salary increase to all employees.
- Group employees by their job title in a `Map`.
- Print employees grouped by job title.
- Print employees with birthdays in October and December.
- Print the oldest employee (name and age).
- Print employees sorted alphabetically by name.
- Print the sum of all employees' salaries.
- Print how many minimum wages each employee earns (minimum wage: R$1.518,00).

## Tech Stack

- Java 21
- JUnit
- Lombok
- Maven
- Git

**IDE:** Developed using [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/syxbruno/employee-system.git
   cd employee-system
   ```

2. **Build with Maven:**
   ```bash
   mvn clean install
   ```

3. **Run the Application:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.syxbruno.employee_system.EmployeeSystemApplication"
   ```

