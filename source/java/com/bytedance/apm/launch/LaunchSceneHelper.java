package com.bytedance.apm.launch;

import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.monitor.util.ActivityThreadUtils;
import com.bytedance.monitor.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes3.dex */
public class LaunchSceneHelper {
    private static final String TAG = "LaunchSceneHelper";

    public static Intent getFirstComponentIntent() {
        Intent componentIntent;
        Intent componentIntent2;
        try {
            MessageQueue messageQueue = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");
            synchronized (messageQueue) {
                Message message = (Message) FieldUtils.readField(messageQueue, "mMessages");
                if (message != null && message.getTarget() == ActivityThreadUtils.getHInActivityThread() && ActivityThreadUtils.isMessageNeedInterrupt(message) && (componentIntent2 = getComponentIntent(message)) != null) {
                    return componentIntent2;
                }
                Field field = FieldUtils.getField(Message.class, "next");
                field.setAccessible(true);
                while (message != null) {
                    message = (Message) FieldUtils.readField(field, message);
                    if (message != null && message.getTarget() == ActivityThreadUtils.getHInActivityThread() && ActivityThreadUtils.isMessageNeedInterrupt(message) && (componentIntent = getComponentIntent(message)) != null) {
                        return componentIntent;
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Intent getFirstActivityIntent() {
        int i;
        int i2;
        Intent componentIntent;
        try {
            MessageQueue messageQueue = (MessageQueue) FieldUtils.readField(Looper.getMainLooper(), "mQueue");
            synchronized (messageQueue) {
                Message message = (Message) FieldUtils.readField(messageQueue, "mMessages");
                if (message != null && message.getTarget() == ActivityThreadUtils.getHInActivityThread() && ActivityThreadUtils.isMessageNeedInterrupt(message) && (((i2 = message.what) == 100 || i2 == 159) && (componentIntent = getComponentIntent(message)) != null)) {
                    return componentIntent;
                }
                Field field = FieldUtils.getField(Message.class, "next");
                field.setAccessible(true);
                while (message != null) {
                    message = (Message) FieldUtils.readField(field, message);
                    if (message != null && message.getTarget() == ActivityThreadUtils.getHInActivityThread() && ActivityThreadUtils.isMessageNeedInterrupt(message) && ((i = message.what) == 100 || i == 159)) {
                        Intent componentIntent2 = getComponentIntent(message);
                        if (componentIntent2 != null) {
                            return componentIntent2;
                        }
                    }
                }
                return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Intent getComponentIntent(Message message) {
        int i = message.what;
        if (i != 100) {
            if (i != 121) {
                if (i != 159) {
                    switch (i) {
                        case 113:
                            return getReceiverComponentIntent(message);
                        case 114:
                        case 115:
                            break;
                        default:
                            return null;
                    }
                }
            }
            return getServiceComponentIntent(message);
        }
        return getActivityComponentIntent(message);
    }

    static Intent getActivityComponentIntent(Message message) {
        Intent intent;
        Object obj = message.obj;
        if (Build.VERSION.SDK_INT < 28 && message.what == 100) {
            try {
                return (Intent) FieldUtils.readField(obj, "intent");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (Build.VERSION.SDK_INT < 28 || message.what != 159) {
            return null;
        }
        try {
            List list = (List) FieldUtils.readField(obj, "mActivityCallbacks");
            if (list == null) {
                return null;
            }
            for (int i = 0; i < list.size(); i++) {
                Object obj2 = list.get(i);
                if (obj2 != null && (intent = (Intent) FieldUtils.readField(obj2, "mIntent")) != null) {
                    return intent;
                }
            }
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static Intent getServiceComponentIntent(Message message) {
        String str;
        if (message.what == 114 || message.what == 121) {
            str = "intent";
        } else {
            str = message.what == 115 ? "args" : "";
        }
        if (str.isEmpty() || message.obj == null) {
            return null;
        }
        try {
            return (Intent) FieldUtils.readField(message.obj, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    static Intent getReceiverComponentIntent(Message message) {
        String str = message.what == 113 ? "intent" : "";
        if (str.isEmpty() || message.obj == null) {
            return null;
        }
        try {
            return (Intent) FieldUtils.readField(message.obj, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
