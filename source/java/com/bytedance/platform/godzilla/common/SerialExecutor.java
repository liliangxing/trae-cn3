package com.bytedance.platform.godzilla.common;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes4.dex */
public final class SerialExecutor implements Executor {
    private static SerialExecutor sINSTANCE;
    private Runnable mActive;
    private Executor mExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.bytedance.platform.godzilla.common.SerialExecutor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "godzilla_serialExecutor");
        }
    });
    final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

    private SerialExecutor() {
    }

    public static SerialExecutor getInstance() {
        if (sINSTANCE == null) {
            synchronized (SerialExecutor.class) {
                if (sINSTANCE == null) {
                    sINSTANCE = new SerialExecutor();
                }
            }
        }
        return sINSTANCE;
    }

    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(final Runnable runnable) {
        this.mTasks.offer(new Runnable() { // from class: com.bytedance.platform.godzilla.common.SerialExecutor.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable unused) {
                }
                SerialExecutor.this.scheduleNext();
            }
        });
        if (this.mActive == null) {
            scheduleNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void scheduleNext() {
        Runnable poll = this.mTasks.poll();
        this.mActive = poll;
        if (poll != null) {
            this.mExecutor.execute(poll);
        }
    }
}
