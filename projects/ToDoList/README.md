# TodoList - Project

Checkout my Blog where I write about [basics of Domain-Driven Design](http://www.braintelligence.pl/the-nature-of-domain-driven-design/)

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
ONE TO RULE THEM ALL:
```
./gradlew clean build test integrationTest
```

<br>

# Endpoints:

* [x] `POST /lists` - create new List
* [x] `GET /lists` - get all lists-names
 
<br>

* [x] `POST /lists/:id/tasks` - add new task to the list
* [x] `GET /lists/:id` - get list with tasks

<br>

* [ ] `GET /lists/:id/tasks/pending` - retrieve pending tasks from certain list
* [ ] `GET /lists/:id/tasks/completed` - retrieve completed tasks from certain list

<br>

* [ ] `PUT /lists/:id/tasks/:id` - for changing text of the task

<br>

* [ ] `DELETE /lists/:id` - delete list
* [ ] `DELETE /lists/:id/tasks/:id` - delete task


## Features
- [ ] Create branches and divide project into incremental stages 
- [ ] Mock sample data into DB on start
- [ ] Task priority and sorting list
- [ ] Sort by createdAt and priority? 
- [ ] OAuth2 for login/registration

## Additional features
- [ ] Search all tasks by text ( configure elasticsearch )
- [ ] Public and private endpoints ( plus useless endpoint that counts users )

## Possible optimizations (future)
- [ ] Don't return whole object TasksList take just tasks `GET /lists/:id` ---> `GET /lists/:id/tasks`

<br>

## Fixes (to verify)
`public static Task mapToTask(NewTaskDto newTaskDto)` - probably setting TaskState in mapper is a bad idea

# Implemented in architectures

### To do List - Layered Service (in progress)
Sample REST service implemented using most popular **Layered Architecture**.

### To do List - Hexagonal Service (soon)
Sample REST service implemented using **Hexagonal Architecture**. 

### To do List - Frontend (soon)
Will be implemented in React.js


# Refactor todo:
- [ ] TasksList rename to TodoList
