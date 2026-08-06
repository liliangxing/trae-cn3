package com.bytedance.common.utility.concurrent;

import android.os.AsyncTask;

/* loaded from: classes3.dex */
public class AsyncTaskUtils {
    static final BaseImpl IMPL = new HoneyCombImpl();

    /* loaded from: classes3.dex */
    private static class BaseImpl {
        private BaseImpl() {
        }

        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class HoneyCombImpl extends BaseImpl {
        private HoneyCombImpl() {
            super();
        }

        @Override // com.bytedance.common.utility.concurrent.AsyncTaskUtils.BaseImpl
        public <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(TTExecutors.getNormalExecutor(), tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void executeAsyncTask(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        IMPL.executeAsyncTask(asyncTask, tArr);
    }
}
