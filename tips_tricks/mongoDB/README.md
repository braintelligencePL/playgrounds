First checkout [docker-mongo](./Running_mongo_docker) to run your local docker.


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

<br>

> db.flightData.updateOne({name: "jaccc"}, {$set: {xd: "asd"}})
{ "acknowledged" : true, "matchedCount" : 0, "modifiedCount" : 0 }
> db.flightData.updateOne({name: "jacc"}, {$set: {xd: "asd"}})
{ "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }
> 
