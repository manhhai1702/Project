package com.example.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.entities.s_mst_user_entity;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
public class UserDao {
  @Autowired
  private SessionFactory sessionFactory;
  public void save(final s_mst_user_entity userEntity) {
    Session session = this.sessionFactory.getCurrentSession();
    session.save(userEntity);
  }
  public void update(final s_mst_user_entity userEntity) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(userEntity);
  }
  public s_mst_user_entity findById(final int id) {
    Session session = this.sessionFactory.getCurrentSession();
    return session.get(s_mst_user_entity.class, id);
  }
  public void delete(final s_mst_user_entity userEntity) {
    Session session = this.sessionFactory.getCurrentSession();
    session.remove(userEntity);
  }
  public List<s_mst_user_entity> findAll() {
    Session session = this.sessionFactory.getCurrentSession();
    return session.createQuery("FROM Customer", s_mst_user_entity.class).getResultList();
  }
}