package com.bytedance.platform.godzilla.anr.sp;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public final class QueuedWorkProxyAboveOrEqualsAndroid0 {
    private static final String CLASS_NAME = "android.app.QueuedWork";
    private static final String FILE_NAME_FINISHERS = "sFinishers";
    private static final String FILE_NAME_S_WORK = "sWork";
    private static final String METHOD_NAME_GET_HANDLER = "getHandler";
    private static final int MSG_RUN = 1;
    private static final String TAG = "QueuedWkPyAOrEAndroid0";
    private static Handler sHandlerInQueueWork;
    private static LinkedList<Runnable> sWorkWrapper;

    private QueuedWorkProxyAboveOrEqualsAndroid0() {
    }

    public static void replacesFinishersAndsWork() {
        Class<?> cls;
        Field field;
        if (Build.VERSION.SDK_INT > 29) {
            return;
        }
        try {
            cls = Class.forName(CLASS_NAME);
            field = FieldUtils.getField(cls, FILE_NAME_FINISHERS);
        } catch (Exception e) {
            Log.e(TAG, "Above android 0, hook sPendingWorkFinishers fail.", e);
        }
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        LinkedList linkedList = (LinkedList) field.get(null);
        if (linkedList != null) {
            field.set(null, new LinkedListProxyForFinishers(linkedList));
        }
        Field field2 = FieldUtils.getField(cls, FILE_NAME_S_WORK);
        if (field2 == null) {
            return;
        }
        field2.setAccessible(true);
        LinkedList linkedList2 = (LinkedList) field2.get(null);
        if (linkedList2 != null) {
            LinkedListProxyForWorks linkedListProxyForWorks = new LinkedListProxyForWorks(linkedList2);
            sWorkWrapper = linkedListProxyForWorks;
            field2.set(null, linkedListProxyForWorks);
        }
        Method accessibleMethod = MethodUtils.getAccessibleMethod(cls, METHOD_NAME_GET_HANDLER, new Class[0]);
        if (accessibleMethod == null) {
            return;
        }
        accessibleMethod.setAccessible(true);
        Handler handler = (Handler) accessibleMethod.invoke(null, new Object[0]);
        sHandlerInQueueWork = handler;
        hooksHandlerInQueueWork(handler);
        Log.d(TAG, "Above android 0,replaceQueueWorkPendingWorkFinishers success.");
        Log.d(TAG, "end hook, time stamp = " + System.currentTimeMillis());
    }

    public static void reSendMessageToQueueWork() {
        Handler handler = sHandlerInQueueWork;
        if (handler != null) {
            if (!handler.hasMessages(1)) {
                Log.d("LinkedListForWorks", "Handler in QueuedWork has no MSG_RUN message,so we send one.");
                final Message obtain = Message.obtain(sHandlerInQueueWork);
                obtain.what = 1;
                new Handler().post(new Runnable() { // from class: com.bytedance.platform.godzilla.anr.sp.QueuedWorkProxyAboveOrEqualsAndroid0.1
                    @Override // java.lang.Runnable
                    public void run() {
                        obtain.sendToTarget();
                    }
                });
                return;
            }
            Log.d("LinkedListForWorks", "Handler in QueuedWork has MSG_RUN message,no need to send one.");
        }
    }

    private static void hooksHandlerInQueueWork(Handler handler) {
        if (handler == null) {
            return;
        }
        try {
            Field field = FieldUtils.getField(Class.forName(Handler.class.getName()), "mCallback");
            if (field == null) {
                return;
            }
            field.setAccessible(true);
            field.set(handler, new Handler.Callback() { // from class: com.bytedance.platform.godzilla.anr.sp.QueuedWorkProxyAboveOrEqualsAndroid0.2
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message.what == 1) {
                        Log.d("LinkedListForWorks", "Hint the message MSG_RUN.");
                        try {
                            QueuedWorkProxyAboveOrEqualsAndroid0.processPendingWork();
                        } catch (ConcurrentModificationException e) {
                            Log.d("QueuedWorkProxyAboveO", e.toString());
                        }
                    }
                    return true;
                }
            });
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processPendingWork() {
        LinkedList<Runnable> linkedList;
        if (sHandlerInQueueWork == null || (linkedList = sWorkWrapper) == null) {
            return;
        }
        LinkedList linkedList2 = (LinkedList) linkedList.clone();
        sWorkWrapper.clear();
        sHandlerInQueueWork.removeMessages(1);
        if (linkedList2.size() > 0) {
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
    }
}
