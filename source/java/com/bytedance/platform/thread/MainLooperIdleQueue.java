package com.bytedance.platform.thread;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes4.dex */
public class MainLooperIdleQueue implements MessageQueue.IdleHandler {
    private static final String TAG = "MainLooperIdleQueue";
    private static Callback sCallback;
    private static int sThreshold;
    private static ArrayList<String> whiteList = new ArrayList<>();
    private Queue<MessageQueue.IdleHandler> mIdleHandlers;
    private Field mMessageField;

    /* loaded from: classes4.dex */
    public interface Callback {
        void onCostTime(MessageQueue.IdleHandler idleHandler, long j);

        void onDelay(MessageQueue.IdleHandler idleHandler, long j);

        void onInit(boolean z, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class Holder {
        private static MainLooperIdleQueue INSTANCE = new MainLooperIdleQueue();

        private Holder() {
        }
    }

    public static MainLooperIdleQueue getInstance() {
        return Holder.INSTANCE;
    }

    private MainLooperIdleQueue() {
        this.mIdleHandlers = new LinkedList();
        whiteList.add("android");
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        Callback callback;
        if (this.mMessageField == null) {
            try {
                this.mMessageField = MessageQueue.class.getDeclaredField("mMessages");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            this.mMessageField.setAccessible(true);
        }
        long headerWhen = getHeaderWhen();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (headerWhen - uptimeMillis > sThreshold || headerWhen == Long.MIN_VALUE) {
            synchronized (this) {
                if (this.mIdleHandlers.isEmpty()) {
                    return true;
                }
                MessageQueue.IdleHandler poll = this.mIdleHandlers.poll();
                boolean queueIdle = poll.queueIdle();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                Callback callback2 = sCallback;
                if (callback2 != null) {
                    callback2.onCostTime(poll, uptimeMillis2 - uptimeMillis);
                }
                long headerWhen2 = getHeaderWhen();
                if (headerWhen2 > 0) {
                    headerWhen = headerWhen2;
                }
                if (headerWhen > 0 && uptimeMillis2 > headerWhen && (callback = sCallback) != null) {
                    callback.onDelay(poll, uptimeMillis2 - headerWhen);
                }
                if (queueIdle) {
                    synchronized (this) {
                        this.mIdleHandlers.offer(poll);
                    }
                }
            }
        }
        return true;
    }

    private long getHeaderWhen() {
        long j;
        Object obj;
        synchronized (this) {
            try {
                try {
                    obj = this.mMessageField.get(Looper.myQueue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    j = 0;
                }
                if (obj == null) {
                    return Long.MIN_VALUE;
                }
                j = ((Message) obj).getWhen();
                return j;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addIdleHandler(MessageQueue.IdleHandler idleHandler) {
        if (idleHandler == null) {
            throw new NullPointerException("Can't add a null IdleHandler");
        }
        synchronized (this) {
            this.mIdleHandlers.add(idleHandler);
        }
    }

    public void removeIdleHandler(MessageQueue.IdleHandler idleHandler) {
        synchronized (this) {
            this.mIdleHandlers.remove(idleHandler);
        }
    }

    public static void init(int i) {
        init(i, null);
    }

    public static void init(int i, Callback callback) {
        if (i < 1) {
            return;
        }
        sThreshold = i;
        sCallback = callback;
        try {
            MessageQueue myQueue = Looper.myQueue();
            synchronized (myQueue) {
                Field declaredField = MessageQueue.class.getDeclaredField("mIdleHandlers");
                ProxyArrayList proxyArrayList = new ProxyArrayList();
                declaredField.setAccessible(true);
                ArrayList arrayList = (ArrayList) declaredField.get(myQueue);
                setFinalField(myQueue, declaredField, proxyArrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    proxyArrayList.add((ProxyArrayList) it.next());
                }
            }
        } catch (IllegalAccessException e) {
            Callback callback2 = sCallback;
            if (callback2 != null) {
                callback2.onInit(false, e);
            }
        } catch (NoSuchFieldException e2) {
            Callback callback3 = sCallback;
            if (callback3 != null) {
                callback3.onInit(false, e2);
            }
        }
        Looper.myQueue().addIdleHandler(getInstance());
        Callback callback4 = sCallback;
        if (callback4 != null) {
            callback4.onInit(true, null);
        }
    }

    public static void setThreshold(int i) {
        if (i < 1) {
            return;
        }
        sThreshold = i;
    }

    public static void addToWhite(String str) {
        if (whiteList.contains(str)) {
            return;
        }
        whiteList.add(str);
    }

    private static void setFinalField(Object obj, Field field, Object obj2) throws NoSuchFieldException, IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class ProxyArrayList extends ArrayList<MessageQueue.IdleHandler> {
        ProxyArrayList() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(MessageQueue.IdleHandler idleHandler) {
            if (!(idleHandler instanceof MainLooperIdleQueue)) {
                if (MainLooperIdleQueue.isWhite(idleHandler.getClass().getName())) {
                    return super.add((ProxyArrayList) idleHandler);
                }
                MainLooperIdleQueue.getInstance().addIdleHandler(idleHandler);
                return true;
            }
            if (contains(idleHandler)) {
                return true;
            }
            return super.add((ProxyArrayList) idleHandler);
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(Object obj) {
            if (obj instanceof MainLooperIdleQueue) {
                return true;
            }
            MainLooperIdleQueue.getInstance().removeIdleHandler((MessageQueue.IdleHandler) obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhite(String str) {
        Iterator<String> it = whiteList.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }
}
