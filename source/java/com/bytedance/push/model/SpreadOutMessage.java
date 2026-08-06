package com.bytedance.push.model;

import com.bytedance.push.PushNotificationMessage;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public class SpreadOutMessage {
    private final ConcurrentLinkedQueue<PushNotificationMessage> mConcurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    public synchronized void addMessage(PushNotificationMessage pushNotificationMessage) {
        this.mConcurrentLinkedQueue.add(pushNotificationMessage);
    }

    public PushNotificationMessage getEarliestMessage() {
        return this.mConcurrentLinkedQueue.peek();
    }

    public synchronized void removeMessage(PushNotificationMessage pushNotificationMessage) {
        this.mConcurrentLinkedQueue.remove(pushNotificationMessage);
    }
}
