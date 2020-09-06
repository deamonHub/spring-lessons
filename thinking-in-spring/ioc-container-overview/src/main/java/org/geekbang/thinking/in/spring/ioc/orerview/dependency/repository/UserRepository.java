package org.geekbang.thinking.in.spring.ioc.orerview.dependency.repository;

import org.geekbang.thinking.in.spring.ioc.orerview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * 用户信息仓库
 *
 * @author ：ljf
 * @date ：Created in 2020/9/6 20:20
 */
public class UserRepository {

    private Collection<User> users;//自定义bean

    private BeanFactory beanFactory;//内建非bean(依赖)

    private ObjectFactory<ApplicationContext> objectFactory;

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> userObjectFactory) {
        this.objectFactory = userObjectFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
