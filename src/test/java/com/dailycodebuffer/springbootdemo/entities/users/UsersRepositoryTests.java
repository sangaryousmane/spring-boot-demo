//package com.dailycodebuffer.springbootdemo.entities.users;
//
//import com.dailycodebuffer.springbootdemo.repository.users.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Commit;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Commit
//public class UsersRepositoryTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    void testCreateUsers() {
//        RolesEntity roleId = entityManager.find(RolesEntity.class, 1);
//        UserEntity userAdmin = new UserEntity(
//                "ousmane@gmail.com",
//                "Ousmane",
//                "Sangary", "ousman2022&&!");
//        userAdmin.addRole(roleId);
//        UserEntity savedUser = userRepository.save(userAdmin);
//        assertThat(savedUser.getId()).isGreaterThan(0);
//    }
//
//
//    @Test
//    void testCreateUsersTwoRoles() {
//        UserEntity savedUser = new UserEntity(
//                "samba@gmail.com",
//                "Samba",
//                "Bailo Diallo",
//                "bailo2022&&!");
//        savedUser.addRole(new RolesEntity(3));
//        savedUser.addRole(new RolesEntity(5));
//        UserEntity savedSamba = userRepository.save(savedUser);
//        assertThat(savedSamba.getRoles()).isNotNull();
//    }
//
//    @Test
//    void testCreateUsersAssistant() {
//        UserEntity savedUserAssistant = new UserEntity(
//                "mark@yahoo.com",
//                "Mark",
//                "Mangou",
//                "mark2022&&!");
//        savedUserAssistant.addRole(new RolesEntity(4));
//        UserEntity savedUser = userRepository.save(savedUserAssistant);
//        assertThat(savedUser.getId()).isNotZero();
//    }
//
//    @Test
//    void testCreateUsersSalesperson() {
//        UserEntity savedUserSalesperson = new UserEntity(
//                "john@gmail.com",
//                "John",
//                "Browne",
//                "brown199");
//        savedUserSalesperson.addRole(new RolesEntity(2));
//        UserEntity savedUser = userRepository.save(savedUserSalesperson);
//        assertThat(savedUser.getId()).isPositive();
//    }
//
//    @Test
//    void testFindAllUsers() {
//        List<UserEntity> allUsers = userRepository.findAll();
//        allUsers
//                .forEach(System.out::println);
//        assertThat(allUsers.size()).isNotZero();
//    }
//
//    @Test
//    void testUserFindById() {
//        UserEntity byId = userRepository.findById(2).get();
//        System.out.println(byId);
//        assertThat(byId.getEmail()).isNotEmpty();
//    }
//
//    @Test
//    void testUserUpdate() {
//        UserEntity userEntity = userRepository.findById(4).get();
//        userEntity.setFirstname("Eastgar");
//        userEntity.setLastName("Sarpka");
//        UserEntity savedUpdatedUser = userRepository.save(userEntity);
//        assertThat(savedUpdatedUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    void testUpdatedUser2() {
//        UserEntity userEntity = userRepository.findById(1).get();
//        userEntity.setEnabled(true);
//        UserEntity savedEntity = userRepository.save(userEntity);
//        assertThat(savedEntity.getId()).isNotZero();
//    }
//
//    @Test
//    void testDeleteUser() {
//        UserEntity userEntity = userRepository.findById(2).get();
//        userEntity.getRoles().remove(new RolesEntity(5));
//
//        UserEntity saved = userRepository.save(userEntity);
//        assertThat(saved.getId()).isNotNegative();
//    }
//
//
//    @Test
//    void testDeleteUser2() {
//        Integer id = 2;
//        userRepository.deleteById(id);
//    }
//}
