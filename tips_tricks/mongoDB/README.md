## Prerequisites
1. Checkout [docker-mongo](./docker-mongo.md) to run your local docker with mongo instance. <br> 
2. Download [Mongo Compass](https://www.mongodb.com/products/compass) for browsing databases/documents. <br>
3. Download [Robo 3T (formerly Robomongo)](https://robomongo.org/) for embedded mongo shell. <br>

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

`mongod` - is the primary daemon process for the MongoDB system

## Interesting stuff

<br>
<br>

## MongoShell Commands: 
- `show dbs` <br>
📜 Your databases

- `use CREATE_NEW_OR_USE_EXISTING_DB` <br>
📜 Creates or switches to DB.

<br>

- `db.COLLECTION.find()` <br>
📜 Returns all entries.

- `db.COLLECTION.find().pretty()` <br> 
📜 Returns all entries well formatted.

<br>

- `db.COLLECTION.find({name: "Jack"})` <br> 
📜 Find by field.
- `db.COLLECTION.find({distance: {$gt: 10}})`  <br>
📜 Find all distances that are greater than 10. [docs $gt](https://docs.mongodb.com/manual/reference/operator/query/gt/)
- `db.COLLECTION.findOne({distance: {$gt: 10}})` <br>
📜 Find one distance.

<br>

- `db.COLLECTION.insertOne({name :"Jack"})` <br>
📜 Inserts one object, key (name) is translated to String [docs insert](https://docs.mongodb.com/manual/tutorial/insert-documents/)

- `db.COLLECTION.insertMany([{name :"Jack"}, {name: 'Jack'}])` <br>
📜 Similar to above, but inserts many objects

<br> 

- `db.COLLECTION.updateOne({name: "qwer"}, {$set: {status: "to_do"}})` <br>
📜 One doc that match query 
- `db.COLLECTION.updateMany({}, {$set: {status: "to_delete"}})` <br>
📜 All that match first query {}
- `db.COLLECTION.update({_id: ObjectId("5bfd36633c5800238dbfaaf2")}, {delay: true})` <br> 
📜 Similar to updateMany, but OVERRIDES all the values, so now object has only one field (delay). (AVOID USING).
- `db.COLLECTION.replaceOne({_id: ObjectId("5bfd36633c5800238dbfaaf2")}, {delay: true})` <br>
Does the same thing that update does, but it is more descriptive, explicit. OVERRIDES all values.


<br>

- `db.COLLECTION.deleteMany({status: "to_delete"})` <br> 
📜 Delete with query
- `db.COLLECTION.deleteMany({})` <br> 
📜 Delete all documents

