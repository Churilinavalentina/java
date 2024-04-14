package ru.mipt.edu.kozub.ValidateAnnotationBeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.mipt.edu.kozub.annotation.Default;
import ru.mipt.edu.kozub.annotation.Validate;
import ru.mipt.edu.kozub.reflection.Validation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static ru.mipt.edu.kozub.Utils.reset;

@Component
public class ValidateAnnotationPost implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException{
        if(bean.getClass().isAnnotationPresent(Validate.class)){
            System.out.println(beanName+" ValidationBefore");
        }
        return  bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException{
        try {
            Field f = bean.getClass().getDeclaredField("name");
            if(f.getType().equals(String.class)){
                System.out.println(beanName+" ValidationAfter");
                f.setAccessible(true);
                f.set(bean, "vasia");
            }
        } catch (NoSuchFieldException e) {
            System.out.println(beanName + "not find name");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        reset(bean);
        if(bean.getClass().isAnnotationPresent(Default.class)){
            try {
                Method df = bean.getClass().getDeclaredMethod(bean.getClass().getAnnotation(Default.class).Value());
                System.out.println(df.getName());
                df.invoke(bean);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        if(bean.getClass().isAnnotationPresent(Validate.class)){
            System.out.println(beanName+" ValidationAfter");
            Validation.validate(bean);
        }
        return  bean;
    }
}
