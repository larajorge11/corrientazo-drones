package delegate.definition;

import java.io.IOException;

public interface Delegate<T, R> {
    R process(T valueObject) throws IOException;
}
