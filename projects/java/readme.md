

[Java Strings are Immutable - Here's What That Actually Means](https://www.youtube.com/watch?v=Bj9Mx_Lx3q4&ab_channel=CodingwithJohn)

```java
public static void main(String[] args) {
        String first = "John"; 
        String second = "John";
        final String third  = new String("John");
        final String fourth  = new String("John");

        System.out.println(first == second); // true
        System.out.println(second == third); // false
        System.out.println(third == fourth); // false
    }
```
