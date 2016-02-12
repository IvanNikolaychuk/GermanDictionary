package service.user;

import dao.user.UserDao;
import exceptions.UserNotFoundException;
import role.Role;
import user.User;

public class UserServiceImpl implements UserService{
    UserDao userDao;

    public UserServiceImpl( UserDao userDao ) {
        this.userDao = userDao;
    }

    public User getUserById( int userId ) throws UserNotFoundException {
        return userDao.getUserById( userId );
    }

    public boolean deleteUserById( int userId ) throws UserNotFoundException {
        return userDao.deleteUserById( userId );
    }

    public boolean registerUser( String username, String password, Role role ) {
        return userDao.registerUser( username, password, role );
    }
}
