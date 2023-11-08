# 🎓 Bus Stop Signage Generation System

## Introduction
The aim of this project is to create a service that generates bus stop signs for public transport vehicles. The service being developed is part of a larger system that has been supporting the organization and management of public transport for a year and a half. The "schedule" module provides the timetable data for the bus stop signs.

## Description
The service enables the generation of bus stop signs in PDF format, divided by companies, schedule versions, lines, and stops. Each company should be able to choose its own bus stop sign template. Additionally, it should be possible to change the schedule for individual stops. A configuration used once for a company/user should be saved in the database and set as the default when creating subsequent queries.

## Bus Stop Signage Features
Bus stop signs are generated with a PDF extension. The system generates bus stop signs in various sizes. A single bus stop sign may contain timetables for several lines, including those from different companies. One bus stop sign contains a timetable for only one bus stop.

## Business Plan
The bus stop signage generation system already exists in an alpha version. The current version contains many errors and is difficult to modify and introduce new features. For this reason, we have chosen this project. We want to refine the system to adhere to good programming standards. The system has been generating regular profits for a year. The service's features are developed based on dialogue with clients and their needs.

## ERD Diagram

The ERD diagram for the service is as follows:
![schedule_template_erd](/img/drive_module_erd.png)

It does not contain many tables, as most of the functionalities are performed in separate modules. As a project for the Software Testing and Quality II course, we only want to submit the bus stop sign generation module, as it is impossible to write the entire system correctly in such a short time. However, the entire server will be submitted for evaluation to check the correctness of the task.

Current database structure for the entire project:
![tarbus_erd](/img/tarbus_erd.png)

## Distribution of Responsibilities

The team consists of three people who will be responsible for:
- Dominik Pająk - refining existing "drive," "schedule," and "core" modules for the planned functionality of the "schedule_tables_generator" module. Assigning tasks, creating documentation, managing project consistency.
- Bartosz Dymański - implementation of the database, services, and repositories. Preparing sample HTML bus stop signs using the thymeleaf framework.
- Dariusz Czajka - creating a PDF parser, converting a template written in HTML into a PDF file.

## Stack
1. **Technology** - Java using the [Spring](https://spring.io/) framework.
2. **Database** - Relational database [PostgreSQL](https://www.postgresql.org/).
3. **Documentation** - [Swagger](https://swagger.io/).
4. **Others**
    - **HTML template generation** - [Thymeleaf](https://www.thymeleaf.org/)
    - **PDF Generation** - [OpenPDF](https://github.com/LibrePDF/OpenPDF)

# Notes
https://github.com/itext/itext7
https://github.com/itext/i7j-pdfhtml
