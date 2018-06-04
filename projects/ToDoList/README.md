# ToDoList - Project

## Working with backend application

To run application:
```
./gradlew bootRun
```
To run unit tests
```
./gradlew test
```
To run integration tests:
```
./gradlew integrationTest
```

<br>

# Endpoints:

* `POST /lists` - create new list
* `GET /lists` - retrieve all lists

<br>

* `POST /lists/:id/tasks` - add task to the list

<br>

* `GET /lists/:id` - get certain list with tasks
* `GET /lists/:id/tasks/pending` - retrieve pending tasks from certain list
* `GET /lists/:id/tasks/completed` - retrieve completed tasks from certain list

<br>

* `PUT /lists/:id/task/:id` - for changing text of the task

<br>

* `DELETE /lists/:id` - delete list
* `DELETE /lists/:id/task/:id` - delete task


## Features
- [ ] Mock sample data into DB on start

## Additional features
- [ ] Search all tasks by text ( elasticsearch )

## Possible optymalizations
- [ ] Don't return whole object just tasks `GET /lists/:id` -> `GET /lists/:id/tasks`

<br>

# Implemented in architectures

### To do List - Layered Service (in progress)
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js
