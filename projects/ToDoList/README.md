# ToDoList - Project

## Working with application

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

### To do List - Layered Service 
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js
# Endpoints:

* `POST /list` - create new list
* `GET /lists` - retrieve all lists

* `GET /list/:id/tasks?state=all` - get all tasks from specific list
* `GET /list/:id/tasks?state=current` - get all tasks from specific list
* `GET /list/:id/tasks?state=finished` - get all tasks from specific list

* `POST /list/:id/task` - add task to list
* `PUT /list/:id/task` - change task state 

## Additional features
* Searching by task text - elasticsearch

