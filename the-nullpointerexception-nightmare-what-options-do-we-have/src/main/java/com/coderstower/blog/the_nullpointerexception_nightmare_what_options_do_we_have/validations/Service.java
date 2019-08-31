package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.validations;

import java.util.List;

class Service {
    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public User getByName(String name) {
        List<String> users = this.repository.findAllIds();

        if (users != null) {
            for (String id: users) {
                User userComplete = this.repository.findById(id);

                if (userComplete != null && userComplete.getName().equals(name)) {
                    return userComplete;
                }
            }
        }

        return null;
    }
}
