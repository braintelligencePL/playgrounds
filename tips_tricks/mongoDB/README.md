### First checkout Running_Local_Mongo.md to run your local docker. 


## Few informations
`"_id" : ObjectId("5bfd1bae09e36be04efd9630")` - unique id, contains some timestamp so documents can be sorted by that. (docs)[https://docs.mongodb.com/manual/reference/method/ObjectId/#ObjectIDs-BSONObjectIDSpecification]
```
a 4-byte value representing the seconds since the Unix epoch,
a 5-byte random value, and
a 3-byte counter, starting with a random value.
```



`mongod` - is the primary daemon process for the MongoDB system




MongoShell Commands: 
- `show dbs` - your databases
- `use YOUR_NEW_DB` - creates or switches to DB
