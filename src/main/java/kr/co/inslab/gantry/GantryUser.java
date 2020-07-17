package kr.co.inslab.gantry;

import kr.co.inslab.model.NewUser;

public interface GantryUser {
    void checkUserById(String userId) throws UserException;
    default void deleteUser(String userId){}
    default void createTestUser(NewUser newUser) {}
}
