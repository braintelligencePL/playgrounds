## What it is `functional interface`?  <br>
It's an interface with only one abstract method

## What is a type of `lambda`? <br> 
Functional Interface

## Functional toolbox of Java 8 <br>

1. `Supplier` - `T get()` - just provides object, doesn't take anything

2. `Consumer` - `accept(T t)` example: System.out.print()
2. `BiConsumer` - `accept(T t, U u)` - don't have to be of the same type

3. `Predicate` - `boolean test(T t)` - takes object and returns boolean
3. `BiPredicate` - `boolean test(T t, U u)` - don't have to be of the same type
 
4. `Function` - `R apply(T t)` - takes object and returns another object
4. `BiFunction` - `R apply(T t, U u)` - takes object and returns another object


## What is `stream`?
It's simply object on which you can define `operations`. <br>
BUT he does not hold any data! It's not `Collection` object. <br>
Stream shouldn't change data when processing something. <br>
It's able to process data in parallel. <br>
