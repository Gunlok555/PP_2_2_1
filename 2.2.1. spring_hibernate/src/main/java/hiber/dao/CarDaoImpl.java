package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByCar(String parModel, int parSeries) {
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User where car.model=:parModel and car.series=:parSeries")
                .setParameter("parModel", parModel)
                .setParameter("parSeries", parSeries)
                .getSingleResult();
        return user;
    }
}