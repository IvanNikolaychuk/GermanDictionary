package dao;

import exceptions.user.UserNotFoundException;
import role.Role;
import user.User;

public interface UserDao {
    User getUserById( int userId ) throws UserNotFoundException;
    boolean deleteUserById( int userId ) throws UserNotFoundException;
    boolean registerUser( String username, String password, Role role );
}
