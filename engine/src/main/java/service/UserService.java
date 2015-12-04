package service;

import exceptions.user.UserNotFoundException;
import role.Role;
import user.User;

public interface UserService {
    User getUserById( long userId ) throws UserNotFoundException;
    boolean deleteUserById( long userId ) throws UserNotFoundException;
    boolean registerUser( String username, String password, Role role );
}
