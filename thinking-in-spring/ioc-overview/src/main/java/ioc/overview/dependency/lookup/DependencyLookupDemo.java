package ioc.overview.dependency.lookup;

import ioc.overview.annotation.Super;
import ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 名称 类型 注解
 *
 * @author ：ljf
 * @date ：Created in 2020/9/2 22:15
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置xml文件
        //启动上下文

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-content.xml");
        lookupByType(beanFactory);
        //按照类型查找集合对象
        lookupByCollectionType(beanFactory);

        //通过注解查找
        lookupByAnnotationType(beanFactory);

//        lookupRealTime(beanFactory);
//        lookupInLazy(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找注解@Super 所有的user集合对象"+beansWithAnnotation);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有user集合对象"+users);

        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找："+user);
    }

    //延时查找
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找："+user);
    }
    //实时查找
    private static void lookupRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找："+user);
    }


}
