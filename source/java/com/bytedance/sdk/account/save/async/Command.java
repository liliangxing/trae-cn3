package com.bytedance.sdk.account.save.async;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes5.dex */
public abstract class Command<T> {
    private static ExecutorService sExecutorService = Executors.newSingleThreadExecutor();
    private static final Handler sHandler = new Handler(Looper.getMainLooper());

    protected abstract T doInBackground();

    protected void onPostExecute(T t) {
    }

    public final void execute() {
        sExecutorService.execute(new Runnable() { // from class: com.bytedance.sdk.account.save.async.Command.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Command command = Command.this;
                    command.postResult(command.doInBackground());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postResult(final T t) {
        sHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.save.async.Command.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Command.this.onPostExecute(t);
            }
        });
    }
}
