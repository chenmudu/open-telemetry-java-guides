/**
 * MIT License
 * <p>
 * Copyright (c) 2020 chenmudu (陈晨)
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 */
package org.chenmudu.otel.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author chenmudu@gmail.com   2021/1/20 22:23
 */
@Component
public class TaskExecutorConfig {

    /**
     * 替换默认的SimpleAsyncTaskExector。
     * @see org.springframework.aop.interceptor.AsyncExecutionAspectSupport#getDefaultExecutor(org.springframework.beans.factory.BeanFactory)
     *
     * 但是，其增强是存在的。原因在于Otel增强的是这个线程池。
     * @see io.opentelemetry.javaagent.instrumentation.spring.core.SpringCoreInstrumentationModule
     * @see io.opentelemetry.javaagent.instrumentation.spring.core.SimpleAsyncTaskExecutorInstrumentation
     *
     * note: 0.13.0 开始，均支持。
     * @see io.opentelemetry.javaagent.instrumentation.javaconcurrent.AbstractExecutorInstrumentation#AbstractExecutorInstrumentation
     *
     *
     * @return
     */
    //    @Bean(name = "taskExecutor") find type == TaskExector and name.equals("taskExector")
    //    @Primary
    @Bean(name = "cchenThreadExector")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(100);
        taskExecutor.setThreadFactory(new CustomizableThreadFactory());
        taskExecutor.initialize();
        return taskExecutor;
    }

    class customizableThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {
        @Override
        public void execute(Runnable task) {
            super.execute(task);
        }

    }

    /**
     * copy form DefaultThreadFactory.
     * [88d49c5a4575e7763bed898862e01d22,dfd1279e70b0ef7a]- o.c.o.a.s.i.OtelTestAsyncServiceImpl.calledAsync:34
     * OtelTestAsyncServiceImpl calledAsync thread is : cchen-pool-1-thread-1
     */
    class CustomizableThreadFactory implements ThreadFactory {

        private final AtomicInteger poolNumber   = new AtomicInteger(1);
        private final ThreadGroup   group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String        namePrefix;

        CustomizableThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "cchen-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
