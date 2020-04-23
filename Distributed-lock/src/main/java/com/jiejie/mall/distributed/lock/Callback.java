package com.jiejie.mall.distributed.lock;

/**
 *
 */
public interface Callback {

    public Object onGetLock() throws InterruptedException;

    public Object onTimeout() throws InterruptedException;
}
