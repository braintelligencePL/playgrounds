First checkout [docker-mongo](./Running_mongo_docker) to run your local docker.
Second download [Mongo Compass](https://www.mongodb.com/products/compass)

## Few informations
`"_id" : ObjectId("5bfd1bae09e36be04efd9630")` - document id, unique id, mongo id, [docs](https://docs.mongodb.com/manual/reference/method/ObjectId/#ObjectIDs-BSONObjectIDSpecification)
```
a 4-byte value representing the seconds since the Unix epoch,
a 5-byte random value, and
a 3-byte counter, starting with a random value.
```
`mongod` - is the primary daemon process for the MongoDB system

## Interesting stuff

## MongoShell Commands: 
- `show dbs` - your databases.
- `use NEW_OR_NOT_DB` - creates or switches to DB.

<br>

- `db.COLLECTION.find()` - returns all entries.
- `db.COLLECTION.find().pretty()` - returns all entries well formatted.

<br>

- `db.COLLECTION.insertOne({name :"Jack"})` - inserts (key is translated to String) [docs](https://docs.mongodb.com/manual/tutorial/insert-documents/)
- `db.COLLECTION.insertMany([{name :"Jack"}, {name: 'Jack'}])`

<br> 

- `db.COLLECTION.updateOne({name: "jaccc"}, {$set: {qwerty: "value"}})` - update by name and change/add new field qwerty
- `db.COLLECTION.updateOne({name: "jaccc"}, {$set: {status: "to_do"}})` - just one document - first 
- `db.COLLECTION.updateMany({}, {$set: {status: "to_delete"}})` - all that match first query {}

<br>

- `db.COLLECTION.deleteMany({status: "to_delete"})` - delete with query
- `db.COLLECTION.deleteMany({})` - delete all documents

