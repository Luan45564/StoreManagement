package src.repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();
    private int nextId = 1;

    public int generateId() {
        return nextId++;
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public List<T> getAll() {
        return items;
    }
}
