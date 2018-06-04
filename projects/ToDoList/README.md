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

* `POST /lists/:id/task` - add task to the list

<br>

* `GET /lists/:id/tasks` - retrieve all tasks from certain list
* `GET /lists/:id/tasks/pending` - retrieve pending tasks from certain list
* `GET /lists/:id/tasks/completed` - retrieve completed tasks from certain list

<br>

* `PUT /lists/:id/task/:id` - for changing text of the task

<br>

* `DELETE /lists/:id` - delete list
* `DELETE /lists/:id/task/:id` - delete task


## Features
- [ ] mock data loaded on start

## Additional features
- [ ] search by task text ( elasticsearch )


<br>

# Implemented in architectures

### To do List - Layered Service (in progress)
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js
