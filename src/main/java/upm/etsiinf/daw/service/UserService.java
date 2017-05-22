package upm.etsiinf.daw.service;

import upm.etsiinf.daw.model.User;

/**
 * Created by S on 18/05/2017.
 */
public interface UserService {
    public User findUserByEmail(String email);
    public void subscribeUser(User user);
    public void unsubscribeUser(User user);
    public void deleteUser(User user);
    public void modifyUser(User user);
}
