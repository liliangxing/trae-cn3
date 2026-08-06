package com.ss.android.deviceregister.utils;

import android.content.Context;
import android.util.Pair;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.deviceregister.GaidGetter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class GaidGetUitls {
    public static Pair<String, Boolean> getGaid(final Context context, long j) {
        if (GaidGetter.isInitGaid()) {
            return GaidGetter.getGaid(context);
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Pair<String, Boolean>[] pairArr = {new Pair<>(null, false)};
        new ThreadPlusProxyExecutor("DeviceRegister.gaid").execute(new Runnable() { // from class: com.ss.android.deviceregister.utils.GaidGetUitls.1
            @Override // java.lang.Runnable
            public void run() {
                pairArr[0] = GaidGetter.getGaid(context);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(j, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pairArr[0];
    }

    /* loaded from: classes7.dex */
    private static final class ThreadPlusProxyExecutor implements Executor {
        private final String name;

        ThreadPlusProxyExecutor(String str) {
            this.name = str;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new ThreadPlus(runnable, this.name, false).start();
        }
    }
}
