package com.bytedance.platform.godzilla.common;

import android.os.Looper;
import java.lang.Thread;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class ConsumeExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final int OOM_LEVEL = 20;
    private final List<UncaughtExceptionConsumer> consumers = new LinkedList();
    private boolean isRegister;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            if (!isOutOfMemoryError(th) && canConsumeInner(thread, th)) {
                if (thread == null || !thread.getName().equals("main")) {
                    return;
                }
                while (true) {
                    try {
                        Looper.loop();
                    } catch (Exception e) {
                        if (isOutOfMemoryError(e) || !canConsumeInner(thread, e)) {
                            callDefaultHandler(thread, e);
                            return;
                        }
                    }
                }
                callDefaultHandler(thread, e);
                return;
            }
            callDefaultHandler(thread, th);
        } catch (Throwable th2) {
            callDefaultHandler(thread, th2);
        }
    }

    public boolean addExceptionConsumer(UncaughtExceptionConsumer uncaughtExceptionConsumer) {
        boolean add;
        synchronized (this.consumers) {
            add = this.consumers.add(uncaughtExceptionConsumer);
        }
        return add;
    }

    public boolean removeExceptionConsumer(UncaughtExceptionConsumer uncaughtExceptionConsumer) {
        boolean remove;
        synchronized (this.consumers) {
            remove = this.consumers.remove(uncaughtExceptionConsumer);
        }
        return remove;
    }

    public void removeAllExceptionConsumer() {
        synchronized (this.consumers) {
            this.consumers.clear();
        }
    }

    private void callDefaultHandler(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mDefaultHandler;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public void register() {
        if (this.isRegister) {
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.mDefaultHandler = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        } else {
            this.mDefaultHandler = null;
        }
        this.isRegister = true;
    }

    private boolean canConsumeInner(Thread thread, Throwable th) throws Throwable {
        try {
            synchronized (this.consumers) {
                Iterator<UncaughtExceptionConsumer> it = this.consumers.iterator();
                while (it.hasNext()) {
                    if (it.next().consumeUncaughtException(thread, th)) {
                        return true;
                    }
                }
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isOutOfMemoryError(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
