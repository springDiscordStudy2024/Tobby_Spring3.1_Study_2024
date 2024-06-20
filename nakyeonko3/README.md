# Todo MVC Application

This is a simple Todo MVC (Model-View-Controller) application built with Spring Boot 3.2. It provides a RESTful API for
managing todo items.

## Features check list

- [ ] todo를 추가하는 기능 create
- [ ] 저장된 todo 전체를 가져오는 기능read
- [ ] 저장된 todo의 내용을 업데이트 하는 기능 update
- [ ] 저장된 todo 중에서 id 값을 이용해서 삭제하는 기능 delete
- [ ] 각 기능에 대한 테스트 코드를 작성함.

## Features

- Create a new todo item
- Get a list of all todo items
- Update an existing todo item
- Delete a todo item

## Technologies

- Java 17
- Spring Boot 3.2
- Spring Web MVC
- Spring Data JPA
- H2 Database (in-memory)

## Getting Started

### Prerequisites

- Java 17 or higher
- gradle

### API Endpoints

The application will start on `http://localhost:8080`.

- `GET /api/v1/todos/test`: Test endpoint that returns "Hello, World"
- `POST /api/v1/todos`: Create a new todo item
    - Request body: `{ "message": "Todo message" }`
- `GET /api/v1/todos/list`: Get a list of all todo items
- `PUT /api/v1/todos?id={id}`: Update an existing todo item
- `DELETE /api/v1/todos?id={id}`: Delete a todo item

