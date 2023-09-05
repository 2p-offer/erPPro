//package com.warship.test.javabase.schedule_self;
//
//import java.util.concurrent.*;
//
///**
// * @author erp
// */
//public class SelfScheduledFuture implements RunnableScheduledFuture {
//    @Override
//    public boolean isPeriodic() {
//        return false;
//    }
//
//    @Override
//    public long getDelay(TimeUnit unit) {
//        return 0;
//    }
//
//    @Override
//    public int compareTo(Delayed o) {
//        return 0;
//    }
//
//    @Override
//    public void run() {
//
//    }
//
//    @Override
//    public boolean cancel(boolean mayInterruptIfRunning) {
//        return false;
//    }
//
//    @Override
//    public boolean isCancelled() {
//        return false;
//    }
//
//    @Override
//    public boolean isDone() {
//        return false;
//    }
//
//    @Override
//    public Object get() throws InterruptedException, ExecutionException {
//        return null;
//    }
//
//    @Override
//    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
//        return null;
//    }
//}
