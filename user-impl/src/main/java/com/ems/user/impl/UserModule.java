package com.ems.user.impl;

import com.ems.user.api.IUser;
import com.google.inject.AbstractModule;

public class UserModule extends AbstractModule {

    @Override
    protected void configure(){
        bind(IUser.class).to(DefaultUserImpl.class);
    }

}
