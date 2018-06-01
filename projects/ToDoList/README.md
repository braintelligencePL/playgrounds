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

# Endpoints:

* `POST /list` - create new list
* `POST /list/:id/task` - add task to the list

<br>

* `GET /lists` - retrieve all lists
* `GET /lists/:id/tasks` - retrieve all tasks from certain list
* `GET /lists/:id/tasks/pending` - retrieve pending tasks from certain list
* `GET /lists/:id/tasks/completed` - retrieve completed tasks from certain list

<br>

* `PUT /list/:id/task/:id` - for changing text of the task
* `PUT /list/:id/` - for changing name of the the list 

<br>

* `DELETE /list/:id` - delete list
* `DELETE /list/:id/task/:id` - delete task


## Additional features
* Searching by task text - elasticsearch

<br>

# Implemented in architectures

### To do List - Layered Service (in progress)
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js
