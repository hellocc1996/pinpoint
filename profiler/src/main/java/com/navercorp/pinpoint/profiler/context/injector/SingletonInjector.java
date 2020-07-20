package com.navercorp.pinpoint.profiler.context.injector;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author : cuipingping
 * create at:  2020/7/20
 * @description: 依赖注入器单例
 */
public class SingletonInjector {
    private volatile static SingletonInjector uniqueInstance;

    private Injector                          injector;

    private SingletonInjector() {
    }

    private SingletonInjector(Injector injector) {
        this.injector = injector;
    }

    public static SingletonInjector getUniqueInstance(Injector injector) {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (SingletonInjector.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new SingletonInjector(injector);
                }
            }
        }
        return uniqueInstance;
    }

    public static SingletonInjector getUniqueInstance() {
        return getUniqueInstance(null);
    }

    public Injector getInjector() {
        return injector;
    }
}