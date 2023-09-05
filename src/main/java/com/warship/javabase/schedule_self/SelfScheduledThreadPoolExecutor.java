package com.warship.test.javabase.schedule_self;

import java.util.concurrent.*;

/**
 * @author erp
 */
public class SelfScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {
    public SelfScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    public SelfScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    public SelfScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    public SelfScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        return super.decorateTask(runnable, task);
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        return super.decorateTask(callable, task);
    }
}
