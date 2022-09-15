package com.codegym.repository.impl;

import com.codegym.model.ZingMusic;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.IZingMusicRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class ZingMusicRepository implements IZingMusicRepository {
    @Override
    public List<ZingMusic> findAll() {
        Session session = null;
        List<ZingMusic> musicList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList = session.createQuery("SELECT p FROM ZingMusic AS p").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return musicList;
    }

    @Override
    public void save(ZingMusic zingMusic) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(zingMusic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public ZingMusic findById(int id) {
        TypedQuery<ZingMusic> query = ConnectionUtil.entityManager.createQuery("select p from ZingMusic as p where p.id = : id", ZingMusic.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(ZingMusic zingMusic) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(zingMusic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        TypedQuery<ZingMusic> query = ConnectionUtil.entityManager.createQuery("SELECT p FROM ZingMusic AS p WHERE p.id = :id", ZingMusic.class);
        query.setParameter("id", id);
        ZingMusic zingMusic = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;


        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(zingMusic);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<ZingMusic> findByName(String name) {
        TypedQuery<ZingMusic> query = ConnectionUtil.entityManager.createQuery("select p from ZingMusic as p where p.name like :name", ZingMusic.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

}
