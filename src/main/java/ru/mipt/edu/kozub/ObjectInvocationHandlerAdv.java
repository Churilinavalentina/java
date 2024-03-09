package ru.mipt.edu.kozub;

import ru.mipt.edu.kozub.annotation.Cache;
import ru.mipt.edu.kozub.annotation.Mutator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ObjectInvocationHandlerAdv<T> implements InvocationHandler {
    private T currentObject;
    private Map<Method, Object> results = new HashMap<>();

    public ObjectInvocationHandlerAdv(T currentObject) {
        this.currentObject = currentObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object objectResult;
        Method currentMethod;

        try {
            currentMethod = currentObject.getClass().getMethod(method.getName(), method.getParameterTypes());
        } catch (Exception e) {
            return method.invoke(currentObject, args);
        }

        if (currentMethod.isAnnotationPresent(Cache.class)) {
            if (results.containsKey(currentMethod)) {
                return results.get(currentMethod);
            }
            objectResult = method.invoke(currentObject, args);
            results.put(currentMethod, objectResult);
            return objectResult;
        }
        if (currentMethod.isAnnotationPresent(Mutator.class)) {
            results.clear();
        }
        return method.invoke(currentObject, args);
    }
}
