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
