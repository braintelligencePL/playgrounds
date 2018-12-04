## Prerequisites
1. Checkout [docker-mongo](./docker-mongo.md) to run your local docker with mongo instance. <br> 
2. Download [Mongo Compass](https://www.mongodb.com/products/compass) for browsing databases/documents. <br>
3. Download [Robo 3T (formerly Robomongo)](https://robomongo.org/) for embedded mongo shell. <br>

<br>

```
# Docker with mongo
your-pc-root $  docker pull mongo
your-pc-root $  docker run --name YOURCONTAINERNAME --restart=always -d -p 27017:27017 mongo mongod --auth
your-pc-root $  docker exec -i -t YOURCONTAINERNAME bash

docker-root $  mongo

mongo-shell $  use admin
mongo-shell $  db.createUser({user:"user",pwd:"1234",roles:[{role:"root",db:"admin"}]})
```

<br>

## Few informations

<br>

`"_id" : ObjectId("5bfd1bae09e36be04efd9630")` - document id, unique id, mongo id, [docs](https://docs.mongodb.com/manual/reference/method/ObjectId/#ObjectIDs-BSONObjectIDSpecification).
```
a 4-byte value representing the seconds since the Unix epoch,
a 5-byte random value, and
a 3-byte counter, starting with a random value.
```

<br>

`mongod` - is the primary daemon process for the MongoDB system.

<br>



## Interesting stuff

<br>
<br>

# MongoShell Commands: 
- `show dbs` <br>
📜 Your databases

- `use CREATE_NEW_OR_USE_EXISTING_DB` <br>
📜 Creates or switches to DB.

<br>

# Find

### Just find 
- `db.COLLECTION.find()` <br>
📜 Returns all entries.

- `db.COLLECTION.find().pretty()` <br> 
📜 Returns all entries well formatted.

<br>

### Find 'something' 
- `db.COLLECTION.find({name: "Jack"})` <br> 
📜 Find by field.
- `db.COLLECTION.find({distance: {$gt: 10}})`  <br>
📜 Find all distances that are greater than 10. [docs $gt](https://docs.mongodb.com/manual/reference/operator/query/gt/)
- `db.COLLECTION.findOne({distance: {$gt: 10}})` <br>
📜 Find one distance.

<br>

### Find - specify fields to return (bandwidth is less busy that way) - PROJECTION
- `db.COLLECTION.find({}, {name: 1})` <br>
📜 first argument: {} find all. <br>
📜 second argument: Return only name field (plus mongo _id) <br> 
- `db.COLLECTION.find({}, {name: 1, _id: 0})` <br>
📜 without mongo _id

<br>

# Insert

- `db.COLLECTION.insertOne({name :"Jack"})` <br>
📜 Inserts one object, key (name) is translated to String [docs insert](https://docs.mongodb.com/manual/tutorial/insert-documents/)

- `db.COLLECTION.insertMany([{name :"Jack"}, {name: 'Jack'}])` <br>
📜 Similar to above, but inserts many objects

<br> 

# Update

### Just update
- `db.COLLECTION.updateOne({name: "qwer"}, {$set: {status: "to_do"}})` <br>
📜 One doc that match query 
- `db.COLLECTION.updateMany({}, {$set: {status: "to_delete"}})` <br>
📜 All that match first query {}

<br>

### Update with override
- `db.COLLECTION.update({_id: ObjectId("1234")}, {delay: true})` <= AVOID USING <br> 
📜 Similar to updateMany, but OVERRIDES all the values, so now object has only one field (delay).
- `db.COLLECTION.replaceOne({_id: ObjectId("1234")}, {delay: true})` <= USE THIS INSTEAD <br>
📜 Does the same thing that update does, but it is more descriptive, explicit. OVERRIDES all values.

<br>

### Working with Embedded Documents
- `db.getCollection('COLLECTION').updateMany({}, {$set: {status123: {stat: "WAITING"}}})` <br>
📜 Document inside of document (Embedded Document) <br>
![Embedded document - mongoDB](images/mongo-embedded-document.png?raw=true)

<br>

### Working with Arrays
- `db.getCollection('COLLECTION').updateMany({}, {$set: {hobbies: ['111','222']}})` <br>
📜 It is not a document, but a list of Strings

<br>


# Delete

- `db.COLLECTION.deleteMany({status: "to_delete"})` <br> 
📜 Delete with query
- `db.COLLECTION.deleteMany({})` <br> 
📜 Delete all documents

## Other interesting things
- `db.COLLECTION.find().forEach( (pass) => {printjson(pass)})` <br>
📜 find() returns cursor you simply can't display all the data so you have a cursor.



