package hiber.dao;

import hiber.model.User;

public interface CarDao {
   public User getUserByCar(String parModel, int parSeries);
}