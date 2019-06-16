package com.coderstower.blog.inversion_of_control_putting_all_together.main;

import com.coderstower.blog.inversion_of_control_putting_all_together.abstraction.Repository;
import com.coderstower.blog.inversion_of_control_putting_all_together.abstraction.Service;

public class Starter {
    public static void main(String[] args){

        Repository repository = new MySQLRepository();

        Service service = new Service(repository);

        //TODO: Use service object.........

    }
}
