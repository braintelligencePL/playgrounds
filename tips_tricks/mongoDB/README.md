## Prerequisites
1. Checkout [docker-mongo](./docker-mongo.md) to run your local docker with mongo instance. <br> 
2. Download [Mongo Compass](https://www.mongodb.com/products/compass) for browsing databases/documents. <br>
3. Download [Robo 3T (formerly Robomongo)](https://robomongo.org/) for embedded mongo shell. <br>

<br>

```
# Docker with mongo
your-pc-root $ docker pull mongo
your-pc-root $ docker run --name YOURCONTAINERNAME --restart=always -d -p 27017:27017 mongo mongod --auth
your-pc-root $ docker exec -i -t YOURCONTAINERNAME bash

docker-root $  mongo

mongo-shell $  use admin
mongo-shell $  db.createUser({user:"user",pwd:"1234",roles:[{role:"root",db:"admin"}]})
```

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
📜 Returns all entries. (kind of because we have here a cursor returned).

- `db.COLLECTION.find().pretty()` <br> 
📜 same but well formatted.

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
Projection - you can tell mongoDB which field you want and which you dont wanna send through your bandwidth.
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
- `db.getCollection('COLLECTION').insertOne({hobbies: ['111','222']})` <br>
📜 It is not a document, but a list of Strings
![Embedded document - mongoDB](images/array-example1.png?raw=true)

<br>

# Delete

- `db.COLLECTION.deleteMany({status: "to_delete"})` <br> 
📜 Delete with query
- `db.COLLECTION.deleteMany({})` <br> 
📜 Delete all documents

# Few informations

### Interesting commands

- `db.COLLECTION.find().forEach( (pass) => {printjson(pass)})` <br>
📜 find() returns cursor you simply can't display all the data but you can bypass that with forEach and display all the data.

<br>

###  Facts, internal mongo.... whatever... just random stuff...

`"_id" : ObjectId("5bfd1bae09e36be04efd9630")` - document id, unique id, mongo id, [docs](https://docs.mongodb.com/manual/reference/method/ObjectId/#ObjectIDs-BSONObjectIDSpecification).
```
a 4-byte value representing the seconds since the Unix epoch,
a 5-byte random value, and
a 3-byte counter, starting with a random value.
```

<br>

`mongod` - is the primary daemon process for the MongoDB system.

<br>

`Hard Limit` - mongo document may have 16mb including embedded documents. Additionaly you can have 100 levels of embedded documents. For files beyond 16mb checkout [GridFS](https://docs.mongodb.com/manual/core/gridfs/).

<br>

### Relations - Options
Lets say you have user, adres, work.

1. We can just create embedded document (nested)
2. Reference so Customer has list of books. 

#### Relation - One to one - Embedded



<br>

### Data Types
- Text, String
- Boolean
- Number - Integer (int32), NumberLong (int64), NumberDecimal
```
NumberInt creates a int32 value => NumberInt(55)
NumberLong creates a int64 value => NumberLong(7489729384792)

If you just use a number  insertOne({a: 1}
This will get added as a normal double into the database.

The reason for this is that the shell is based on JS which only knows float/ double values.
```
- ObjectId
- ISODate - ISODate("2011-11-11") and Timestamp
```
db.getCollection('COLLECTION').insertOne({dd: new Date(), tt: Timestamp()})
{
    "_id" : ObjectId("5c07c8d3f1c85be228e60406"),
    "dd" : ISODate("2018-12-05T12:47:15.825Z"),
    "tt" : Timestamp(1544014035, 1)
}
```
- Embedded Documents - `{person: {...}}`
- Arrays - `{names: [...]}`

<br>

