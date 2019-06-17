package com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.main;

import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction.Repository;
import com.coderstower.blog.interfaces_and_replacement_the_liskov_substitution_principle.better.abstraction.Service;

public class Starter {
    public static void main(String[] args){

        Repository repository = new MySQLRepository();

        Service service = new Service(repository);

        //TODO: Use service object.........

    }
}
