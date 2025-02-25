package com.umugram.Tfg.repositories.custom.implementations;

import com.umugram.Tfg.domain.Post;
import com.umugram.Tfg.repositories.custom.CustomPostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CustomPostRepositoryImpl implements CustomPostRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> cFindPostsWithLongCaptions(int minLength) {
        String select = "SELECT p FROM Post p ";
        String where = "WHERE LENGTH(p.caption) > :minLength";
        String query = select + where;
        Query q = entityManager.createQuery(query);
        q.setParameter("minLength", minLength);
        return q.getResultList();
    }

    @Override
    public List<Post> cnFindAllLessUsers()
    {
        String p = "Post.findAllLessUsers";
        Query q = entityManager.createNamedQuery(p);
        return q.getResultList();
    }

    @Override
    public List<Post> cnFindAllShortsComments()
    {
        TypedQuery<Post> q = entityManager.createNamedQuery("Post.findAllShortsComments", Post.class);
        return q.getResultList();
    }
}
