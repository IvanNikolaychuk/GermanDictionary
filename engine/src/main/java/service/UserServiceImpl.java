package service;

import dao.UserDao;
import exceptions.user.UserNotFoundException;
import role.Role;
import user.User;

public class UserServiceImpl implements UserService{
    UserDao userDao;

    public UserServiceImpl( UserDao userDao ) {
        this.userDao = userDao;
    }

    public User getUserById( long userId ) throws UserNotFoundException {
        return userDao.getUserById( userId );
    }

    public boolean deleteUserById( long userId ) throws UserNotFoundException {
        return userDao.deleteUserById( userId );
    }

    public boolean registerUser( String username, String password, Role role ) {
        return userDao.registerUser( username, password, role );
    }
}
