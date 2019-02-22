package pl.braintelligence.garbage.three_ways_to_tryCatch;

import java.io.IOException;
import java.net.http.HttpConnectTimeoutException;

public class Application {
    public static void main(String[] args) {
        ClassicalWay.printDatabase();
    }
}

class ClassicalWay {

    static String printDatabase() {

    }
}


class CustomerDatabase {

    // spring-data, mongoDB, internal-database...
    public static String getInternalCustomer() throws IOException {

//        throw new IOException("");
        return "INTERNAL Customer - from your mongoDB";
    }

    // restTemplate, HTTP...
    public static String getExternalCustomer() throws HttpConnectTimeoutException {

//        throw new HttpConnectTimeoutException("");
        return "EXTERNAL Customer - fetched from server through HTTP";
    }

}
