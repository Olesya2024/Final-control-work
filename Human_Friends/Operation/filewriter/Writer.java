package Operation.filewriter;

public interface Writer<T> {
    void save(T entity);
    T load();
}
