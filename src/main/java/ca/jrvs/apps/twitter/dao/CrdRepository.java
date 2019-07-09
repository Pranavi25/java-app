package ca.jrvs.apps.twitter.dao;

import java.io.IOException;

public interface CrdRepository<T, ID> {
    T create(T entity) throws IOException;
    T findById(ID id);
    T deleteById(ID id) throws IOException;

}