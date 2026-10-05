# StudyQuest

> A gamified study productivity dashboard built with Java, Spring Boot, MySQL, and Thymeleaf to help students turn study tasks into measurable progress.

## Overview

**StudyQuest** is a web-based study tracker designed to make consistent learning more engaging and measurable.

Instead of functioning as a basic to-do list, StudyQuest combines task management with a **gamification and goal-tracking system**. Users can create study tasks, assign priorities, complete tasks to earn XP, progress through levels, track monthly performance, and maintain a long-term study goal.

The application was developed to demonstrate practical use of **Java, Spring Boot, Spring Data JPA, MySQL, Thymeleaf, and JavaScript** in a full-stack web application.

## Key Features

### Task Management

* Create study tasks with a name and category
* Assign LOW, MEDIUM, or HIGH priority
* View active study tasks in a centralized dashboard
* Mark completed tasks and automatically remove them from the active task list
* Persist task data using MySQL

### Gamification System

Tasks award XP based on priority:

| Priority |    XP |
| -------- | ----: |
| LOW      | 10 XP |
| MEDIUM   | 20 XP |
| HIGH     | 30 XP |

Accumulated XP contributes to the user's level progression.

### Study Goals

Users can define a long-term study goal such as:

> Finish preparing for Infosys

The dashboard tracks progress toward the selected goal using completed study tasks.

### Monthly Progress

StudyQuest separately tracks monthly productivity:

* Tasks completed during the current month
* XP earned during the current month
* Progress toward the monthly study target

Monthly statistics automatically reset when a new month begins, while lifetime XP and level progression are preserved.

### Interactive Dashboard

The single-page dashboard provides:

* Current level
* Total tasks
* Completed tasks
* Remaining tasks
* Lifetime XP
* Current study goal
* Goal completion percentage
* Monthly progress
* Active study tasks
* Task creation and priority management

## Tech Stack

**Backend**

* Java
* Spring Boot
* Spring Data JPA
* Spring MVC

**Frontend**

* Thymeleaf
* HTML5
* CSS3
* JavaScript

**Database**

* MySQL

**Build Tool**

* Maven

## Application Architecture

```text
                    ┌─────────────────────┐
                    │      Browser        │
                    │ HTML/CSS/JavaScript │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │     Thymeleaf       │
                    │      Views          │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Spring Boot       │
                    │    Controller       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │   Spring Data JPA   │
                    │    Repositories     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │       MySQL         │
                    │      Database       │
                    └─────────────────────┘
```

## Core Workflow

```text
Create Study Task
        ↓
Assign Category + Priority
        ↓
Task Stored in MySQL
        ↓
Complete Task
        ↓
Calculate XP
        ↓
Update Level
        ↓
Update Monthly Progress
        ↓
Update Study Goal Progress
        ↓
Remove Completed Task
```

## XP & Level System

StudyQuest uses a simple progression model to encourage consistent study habits.

```text
LOW Priority     → 10 XP
MEDIUM Priority  → 20 XP
HIGH Priority    → 30 XP
```

The user's level is derived from accumulated lifetime XP.

```text
Level = (Total XP / 100) + 1
```

For example:

```text
0–99 XP       → Level 1
100–199 XP    → Level 2
200–299 XP    → Level 3
...
```

Lifetime XP is preserved even when monthly statistics reset.

## Monthly Progress

Monthly progress is tracked independently from lifetime progression.

At the beginning of a new month, StudyQuest automatically resets:

```text
Monthly Tasks Completed → 0
Monthly XP              → 0
```

while preserving:

```text
Total XP
Level
Study Goal
Study Goal Progress
```

This allows users to measure both **long-term growth** and **current-month consistency**.

## Database

The application uses **MySQL** for persistent storage.

The main entities include:

* `TodoItem` — stores study task information
* `StudyProfile` — stores XP, level, monthly statistics, and study goal information

Spring Data JPA handles database interaction and entity persistence.

## Getting Started

### Prerequisites

Make sure the following are installed:

* Java JDK 22
* MySQL
* Maven or Maven Wrapper
* Git

### 1. Clone the repository

```bash
git clone <YOUR-REPOSITORY-URL>
cd StudyQuest
```

### 2. Configure MySQL

Create a MySQL database for the application.

Then update:

```text
src/main/resources/application.properties
```

with your local database configuration.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tododb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

**Do not commit real database passwords to GitHub.**

### 3. Run the application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Or:

```bash
mvnw.cmd clean package
java -jar target/<generated-jar-name>.jar
```

### 4. Open the application

Navigate to:

```text
http://localhost:8080
```

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/nttdata/ta/todo/
│   │       ├── TodoAppController.java
│   │       ├── TodoItem.java
│   │       ├── TodoItemRepository.java
│   │       ├── TodoListViewModel.java
│   │       ├── StudyProfile.java
│   │       └── StudyProfileRepository.java
│   │
│   └── resources/
│       ├── templates/
│       │   └── index.html
│       │
│       └── application.properties
│
└── test/
```

## What I Learned

Building StudyQuest provided practical experience with:

* Spring Boot application structure
* MVC architecture
* Spring Data JPA
* MySQL persistence
* Entity relationships and database operations
* Thymeleaf server-side rendering
* Form handling and validation
* JavaScript-based UI interactions
* Backend-driven gamification logic
* State management across application sessions
* Designing features around a real user problem

## Future Improvements

Potential future enhancements include:

* User authentication and individual profiles
* Study streak tracking
* Daily study statistics
* Analytics and progress charts
* Subject-wise performance tracking
* Cloud deployment
* REST API integration
* Responsive mobile-focused interface

## Author

**Cusnat Sova**

B.E. Computer Science Engineering
Panimalar Engineering College

### Project Focus

`Java` · `Spring Boot` · `MySQL` · `Spring Data JPA` · `Thymeleaf` · `JavaScript` · `HTML/CSS`
