package ioc.overview.dependency.injection;

import ioc.overview.annotation.Super;
import ioc.overview.dependency.domain.User;
import ioc.overview.dependency.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 * 名称 类型 注解
 *
 * @author ：ljf
 * @date ：Created in 2020/9/2 22:15
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-content.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        //System.out.println(userRepository.getUsers());
        //依赖注入
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory()==beanFactory);

        ObjectFactory<ApplicationContext> userFactory = userRepository.getObjectFactory();
//        System.out.println(userFactory.getObject());
        System.out.println(userFactory.getObject() == beanFactory);
        // 依赖查找 (error)
        //System.out.println(beanFactory.getBean(BeanFactory.class));
    }

}
