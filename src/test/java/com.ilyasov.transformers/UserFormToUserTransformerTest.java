package com.ilyasov.transformers;

import com.ilyasov.config.CoreConfig;
import com.ilyasov.config.PersistenceConfig;
import com.ilyasov.model.User;
import com.ilyasov.model.enums.Sex;
import com.ilyasov.util.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;

public class UserFormToUserTransformerTest {
    @Test
    public void formShouldReturnCorrectUser(){
        UserForm userForm = new UserForm();
        userForm.setEmail("q");
        userForm.setFirstName("qw");
        userForm.setLastName("qwe");
        userForm.setPassword("ww");
        userForm.setSex(Sex.MALE);
        UserFormToUserTransformer userFormToUserTransformer = new UserFormToUserTransformer();
        User user = userFormToUserTransformer.apply(userForm);
        assertEquals(user.getEmail(),userForm.getEmail());
        assertEquals(user.getFirstName(),userForm.getFirstName());
        assertEquals(user.getLastName(),userForm.getLastName());
        assertEquals(user.getSex(),userForm.getSex());
    }
}
