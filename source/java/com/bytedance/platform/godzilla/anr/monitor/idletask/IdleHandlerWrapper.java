package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;

/* loaded from: classes4.dex */
public class IdleHandlerWrapper implements MessageQueue.IdleHandler {
    private MessageQueue.IdleHandler mOriginalIdleHandler;

    public IdleHandlerWrapper(MessageQueue.IdleHandler idleHandler) {
        this.mOriginalIdleHandler = idleHandler;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String name = this.mOriginalIdleHandler.getClass().getName();
        BridgeIdleTaskToLooperPrinter.println(">>>>> Dispatching to IdleTask " + name);
        long currentTimeMillis = System.currentTimeMillis();
        boolean queueIdle = this.mOriginalIdleHandler.queueIdle();
        BridgeIdleTaskToLooperPrinter.println("<<<<< Finished to IdleTask " + name);
        IdleHandlerCostTimeMonitor.getInstance().getIdleHandlerCostTimeCallback().upload(name, System.currentTimeMillis() - currentTimeMillis);
        return queueIdle;
    }

    public MessageQueue.IdleHandler getOriginalIdleHandler() {
        return this.mOriginalIdleHandler;
    }
}
