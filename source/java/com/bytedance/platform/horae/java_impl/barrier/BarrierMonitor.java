package com.bytedance.platform.horae.java_impl.barrier;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.bytedance.platform.horae.common.DoubleReflectHelper;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.common.MethodUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BarrierMonitor {
    private static final int BARRIER_MESSAGE_MAX = 5;
    private static final int CHECKTIME_NUM = 2;
    private static final int DELETE_BARRIER = 1001;
    private static MessageQueue mMessageQueue;
    private static Field mMessagesHeadField;
    private static Field mNextBarrierField;
    private static Field mNextField;
    private static Method mRemoveSyncBarrierMethod;
    private static Field mRootsField;
    private static Field mTraversalBarrierField;
    private static Object mWindowManagerGlobalObject;
    private static BarrierMonitor sInstance = new BarrierMonitor();
    private BarrierHandler mBarrierHandler;
    private int mCheckTime = 0;
    private int mLastBarrierToken = -1;
    private Method mSetAsynchronous;

    public static BarrierMonitor getInstance() {
        return sInstance;
    }

    public int initBarrierMonitorReflect() {
        try {
            if (mMessageQueue == null || mMessagesHeadField == null || mNextBarrierField == null || mWindowManagerGlobalObject == null || mRootsField == null || mTraversalBarrierField == null || mNextField == null) {
                mMessageQueue = (MessageQueue) DoubleReflectHelper.getField(Looper.class, "mQueue").get(Looper.getMainLooper());
                mMessagesHeadField = DoubleReflectHelper.getField(MessageQueue.class, "mMessages");
                mNextBarrierField = DoubleReflectHelper.getField(MessageQueue.class, "mNextBarrierToken");
                Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.view.WindowManagerGlobal"), "getInstance", new Object[0]);
                mWindowManagerGlobalObject = invokeStaticMethod;
                mRootsField = DoubleReflectHelper.getField(invokeStaticMethod.getClass(), "mRoots");
                mTraversalBarrierField = DoubleReflectHelper.getField(Class.forName("android.view.ViewRootImpl"), "mTraversalBarrier");
                mNextField = DoubleReflectHelper.getField(Message.class, "next");
                Logger.m208i("ContentValues", "initBarrierMonitorReflect");
            }
            if (mRemoveSyncBarrierMethod == null) {
                mRemoveSyncBarrierMethod = DoubleReflectHelper.getMethod(MessageQueue.class, "removeSyncBarrier", Integer.TYPE);
            }
            if (this.mBarrierHandler == null) {
                this.mBarrierHandler = new BarrierHandler(Looper.getMainLooper());
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public int onFirstMessageOfMessageQueueArrive(WeakReference<Message> weakReference) {
        return checkAndRemoveDangerBarrier(weakReference);
    }

    public int checkAndRemoveDangerBarrier(WeakReference<Message> weakReference) {
        try {
            Message message = weakReference.get();
            ArrayList arrayList = new ArrayList();
            Message message2 = message;
            int i = -1;
            for (int i2 = 0; message2 != null && i2 < 5 && message2.getTarget() == null && message2.arg1 >= 0; i2++) {
                if (message2.arg1 > 0) {
                    Logger.m203d("ContentValues", "barrier message:" + message2 + " getWhen:" + message2.getWhen());
                }
                i = message2.arg1;
                arrayList.add(Integer.valueOf(i));
                message2 = (Message) mNextField.get(message2);
            }
            int size = arrayList.size();
            if (size <= 0) {
                return -1;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (checkViewRootBarrier(((Integer) arrayList.get(i3)).intValue()) < 0) {
                    return -1;
                }
            }
            if (this.mLastBarrierToken != i) {
                this.mCheckTime = 0;
                this.mLastBarrierToken = i;
            }
            int intValue = ((Integer) mNextBarrierField.get(mMessageQueue)).intValue();
            Logger.m208i("ContentValues", "last barrier message token:" + i + " MessageQueue::mNextBarrierToken:" + intValue);
            if (i < intValue) {
                this.mCheckTime++;
            }
            if (this.mCheckTime < 2) {
                Logger.m208i("ContentValues", "token < mNextBarrierToken try again,mCheckTime:" + this.mCheckTime);
                return -1;
            }
            Logger.m210w("ContentValues", "firstMsg:" + message);
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                int intValue2 = ((Integer) arrayList.get(i5)).intValue();
                if (intValue2 < intValue) {
                    this.mBarrierHandler.removeMessages(1001);
                    Message obtainMessage = this.mBarrierHandler.obtainMessage(1001, intValue2, 0);
                    obtainMessage.setAsynchronous(true);
                    this.mBarrierHandler.sendMessage(obtainMessage);
                    i4 = intValue2;
                }
            }
            this.mCheckTime = 0;
            this.mLastBarrierToken = -1;
            return i4;
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.m210w("ContentValues", "checkAndRemoveDangerBarrier throwable !!!");
            return -1;
        }
    }

    public int checkViewRootBarrier(int i) throws Throwable {
        Object obj = mRootsField.get(mWindowManagerGlobalObject);
        if (obj instanceof ArrayList) {
            ArrayList arrayList = (ArrayList) obj;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Object obj2 = arrayList.get(i2);
                if (((Integer) mTraversalBarrierField.get(obj2)).intValue() == i) {
                    Logger.m203d("ContentValues", "mTraversalBarrier == token : for viewRoot:" + obj2);
                    return -1;
                }
            }
            return 0;
        }
        Logger.m205e("ContentValues", " mRoots type is:" + obj);
        return -1;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class BarrierHandler extends Handler {
        public BarrierHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1001) {
                return;
            }
            try {
                int i = message.arg1;
                BarrierMonitor.mRemoveSyncBarrierMethod.invoke(BarrierMonitor.mMessageQueue, Integer.valueOf(i));
                Logger.m210w("ContentValues", "force remove lost barrier for:" + i);
            } catch (Exception e) {
                Logger.m210w("ContentValues", "delete barrier message throwable !!!" + e);
                e.printStackTrace();
            }
        }
    }
}
