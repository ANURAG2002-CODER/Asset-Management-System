# Asset Management System

## Introduction

The Asset Management System is a Spring Boot application that allows users to manage various assets such as mobile devices and laptops. It provides a RESTful API for performing operations like adding assets, assigning them to employees, updating information, and more.

## Requirements

- Jdk 17 or higher
- Spring Boot
- PostgreSQL (or your preferred database)

## Getting Started

## Clone the Repository

>git clone <s://github.com/ANURAG2002-CODER/Asset-Management-System>

>cd Asset-Management-System



## Database Configuration

- Configure your PostgreSQL database settings in src/main/resources/application.properties.

## Database
>
>spring.datasource.url=jdbc:postgresql://localhost:5432/yourdb
spring.datasource.username=yourusername
spring.datasource.password=yourpassword

## Build and Run

>./mvnw clean install

>./mvnw spring-boot:run

The application will be accessible at ://localhost:8083.

# API Documentation

## Category Management

### Add a new category

> POST /api/categories

### Update the details of an existing category

> PUT /api/categories/{id}

### Retrieve a list of all existing asset categories

> GET /api/categories

## Asset Management

### Add a new asset

> POST /api/assets

### Retrieve a list of all assets

> GET /api/assets

### Search for assets based on their names

> GET /api/assets/search?name={name}

### Update the details of an existing asset

> PUT /api/assets/{id}

### Assign an asset to an employee

> POST /api/assets/assign/{assetId}/to/{employeeId}

### Mark an asset as "Recovered" from an employee

> PUT /api/assets/recover/{id}

### Delete an asset from the system

> PUT /api/assets/delete/{id}

### Security

By default, the application uses Spring Security. You can customize security settings in the SecurityConfig class.

## ⭐ Show your support

Give a ⭐ if this tool made your life easier!

Spread the word to your geek fellows to save their time!

## ✨ Contributors

<table>
	<tr align="center" style="font-weight:bold">
		<td>
		Anurag Mahajan
		<p align="center">
			<img src = "https://avatars.githubusercontent.com/ANURAG2002-CODER" width="150" height="150" alt="Anurag Mahajan">
		</p>
			<p align="center">
				<a href = "https://github.com/ANURAG2002-CODER">
					<img src = "http://www.iconninja.com/files/241/825/211/round-collaboration-social-github-code-circle-network-icon.svg" width="36" height = "36" alt="GitHub"/>
				</a>
			</p>
		</td>
	</tr>
</table>
