package com.bytedance.crash.anr;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
public class LooperMonitor {
    private static MessageQueue mMainQueue;
    private static Field mMessagesField;
    private static Field mNextMessageField;

    private static Message getMessageObject(MessageQueue messageQueue) {
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

    public static List<Message> dumpPendingMessages(int i) {
        MessageQueue mainMessageQueue = getMainMessageQueue();
        if (mainMessageQueue == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (mainMessageQueue) {
            Message messageObject = getMessageObject(mainMessageQueue);
            if (messageObject == null) {
                return null;
            }
            int i2 = 0;
            while (messageObject != null) {
                int i3 = i2 + 1;
                if (i2 >= i) {
                    break;
                }
                arrayList.add(messageObject);
                messageObject = getNextMessage(messageObject);
                i2 = i3;
            }
            return arrayList;
        }
    }

    private static Message getNextMessage(Message message) {
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
