package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;

/* loaded from: classes4.dex */
public class LooperUtil {
    private static MessageQueue mMainQueue;
    private static Field mMessagesField;
    private static Field mNextMessageField;

    public static MessageQueue getMainMessageQueue() {
        if (mMainQueue == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                mMainQueue = Looper.myQueue();
            } else {
                mMainQueue = mainLooper.getQueue();
            }
        }
        return mMainQueue;
    }

    public static Message getMessageObject(MessageQueue messageQueue) {
        Field field = mMessagesField;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                mMessagesField = declaredField;
                declaredField.setAccessible(true);
                return (Message) mMessagesField.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Message getNextMessage(Message message) {
        Field field = mNextMessageField;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                mNextMessageField = declaredField;
                declaredField.setAccessible(true);
                return (Message) mNextMessageField.get(message);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(message);
        } catch (Exception unused2) {
            return null;
        }
    }
}
