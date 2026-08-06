package com.bytedance.applog.exception;

import android.os.Process;
import com.bytedance.applog.log.AbsSingleton;
import java.lang.Thread;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final AbsSingleton<GlobalExceptionHandler> INSTANCE = new AbsSingleton<GlobalExceptionHandler>() { // from class: com.bytedance.applog.exception.GlobalExceptionHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public GlobalExceptionHandler create(Object... objArr) {
            return new GlobalExceptionHandler();
        }
    };
    private final CopyOnWriteArraySet<UncaughtExceptionCallback> callbacks;
    private final Thread.UncaughtExceptionHandler defaultHandler;

    public static GlobalExceptionHandler getInstance() {
        return INSTANCE.get(new Object[0]);
    }

    private GlobalExceptionHandler() {
        this.callbacks = new CopyOnWriteArraySet<>();
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void addExceptionCallback(UncaughtExceptionCallback uncaughtExceptionCallback) {
        this.callbacks.add(uncaughtExceptionCallback);
    }

    public void removeExceptionCallback(UncaughtExceptionCallback uncaughtExceptionCallback) {
        this.callbacks.remove(uncaughtExceptionCallback);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Iterator<UncaughtExceptionCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onException(thread, th);
        }
        handleException(thread, th);
    }

    private void handleException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.defaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Throwable unused) {
        }
    }
}
