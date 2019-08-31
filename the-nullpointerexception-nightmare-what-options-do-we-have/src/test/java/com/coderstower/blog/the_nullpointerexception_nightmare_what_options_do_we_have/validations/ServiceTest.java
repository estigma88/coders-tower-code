package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.validations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private Repository repository;
    @InjectMocks
    private Service service;

    @Test
    public void getByName_nullList_nullPointerException(){
        when(repository.findAllIds()).thenReturn(null);

        User user = service.getByName("name");

        assertThat(user).isNull();
    }

    @Test
    public void getByName_nullUser_nullPointerException(){
        when(repository.findAllIds()).thenReturn(Arrays.asList("1","2"));
        when(repository.findById("1")).thenReturn(null);

        User user = service.getByName("name");

        assertThat(user).isNull();
    }
}