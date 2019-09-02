package com.coderstower.blog.the_nullpointerexception_nightmare_what_options_do_we_have.nullobject;

class NullUser extends User {
  static final NullUser INSTANCE = new NullUser();

  public NullUser() {
    super("null", "null");
  }
}
