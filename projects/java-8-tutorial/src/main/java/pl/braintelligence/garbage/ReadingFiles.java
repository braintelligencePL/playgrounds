package pl.braintelligence.garbage;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

class ClassWithHeavyInitialization {

    private ClassWithHeavyInitialization INSTANCE;

    private ClassWithHeavyInitialization() {
        INSTANCE = new ClassWithHeavyInitialization();
    }

    private static class LazyHolder {
        public static final ClassWithHeavyInitialization INSTANCE = new ClassWithHeavyInitialization();
    }

    public static ClassWithHeavyInitialization getInstance() {
        return LazyHolder.INSTANCE;
    }
}

class Morty {
    private static class mortyHolder {
        static final Morty instance = new Morty();
    }

    public static Morty getInstance() {
        return mortyHolder.instance;
    }
}

class Heavy {

    private static final Logger LOGGER = LoggerFactory.getLogger(Heavy.class);

    /**
     * Constructor
     */
    public Heavy() {
        LOGGER.info("Creating Heavy ...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            LOGGER.error("Exception caught.", e);
        }
        LOGGER.info("... Heavy created");
    }
}


class Java8Holder {

    private static final Logger LOGGER = LoggerFactory.getLogger(Java8Holder.class);

    private Supplier<Heavy> heavy = this::createAndCacheHeavy;

    public Java8Holder() {
        LOGGER.info("Java8Holder created");
    }

    public Heavy getHeavy() {
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            @Override
            public Heavy get() {
                return heavyInstance;
            }
        }
        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
}

class LazyInit {
    public static void main(String[] args) throws IOException, InterruptedException {


    }
}
