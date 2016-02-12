package service.user;

import exceptions.UserNotFoundException;
import role.Role;
import user.User;

public interface UserService {
    User getUserById( int userId ) throws UserNotFoundException;
    boolean deleteUserById( int userId ) throws UserNotFoundException;
    boolean registerUser( String username, String password, Role role );
}
