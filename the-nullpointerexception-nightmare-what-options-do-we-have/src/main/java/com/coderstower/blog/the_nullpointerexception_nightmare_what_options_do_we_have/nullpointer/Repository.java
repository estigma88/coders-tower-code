package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.nullpointer;


import java.util.List;

interface Repository {
    User findById(String id);

    List<String> findAllIds();
}
