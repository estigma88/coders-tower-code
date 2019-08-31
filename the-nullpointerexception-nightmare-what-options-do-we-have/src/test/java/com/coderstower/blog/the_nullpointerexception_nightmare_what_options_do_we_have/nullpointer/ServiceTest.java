package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.nullpointer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    private Repository repository;
    @InjectMocks
    private Service service;

    @Test(expected = NullPointerException.class)
    public void getByName_nullList_nullPointerException(){
        when(repository.findAllIds()).thenReturn(null);

        service.getByName("name");
    }

    @Test(expected = NullPointerException.class)
    public void getByName_nullUser_nullPointerException(){
        when(repository.findAllIds()).thenReturn(Arrays.asList("1", "2"));
        when(repository.findById("1")).thenReturn(null);

        service.getByName("name");
    }
}