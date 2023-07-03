//package com.dailycodebuffer.springbootdemo.entities.users;
//import com.dailycodebuffer.springbootdemo.models.users.Roles;
//import com.dailycodebuffer.springbootdemo.repository.users.RoleRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Commit;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Commit
//public class RoleRepositoryTests {
//
//    @Autowired
//    private  RoleRepository roleRepository;
//
//
//
//
//    @Test
//    public void createTestRoleAdmin() {
//        Roles roleAdmin = new Roles("Admin", "Manage Everything");
//        RolesEntity entity = new RolesEntity();
//        BeanUtils.copyProperties(roleAdmin, entity);
//
//        RolesEntity savedRole = roleRepository.save(entity);
//        assertThat(savedRole.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void createTestRoleSalesPerson(){
//        RolesEntity roleSalesPerson=new
//                RolesEntity("Salesperson",
//                "manage product price,customers");
//        RolesEntity roleEditor=new RolesEntity("Editor",
//                "manage categories, brands");
//        RolesEntity roleAssistant=new RolesEntity("Assistant",
//                "manage questions and reviews");
//        RolesEntity roleShipper=new RolesEntity("Shipper",
//                "view products, orders and update orders");
//
//        roleRepository.saveAll(List.of(roleSalesPerson, roleEditor, roleAssistant, roleShipper));
//
//    }
//
//
//
//}
