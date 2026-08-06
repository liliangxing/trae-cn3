package com.ss.bytertc.base.utils;

import android.content.Context;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class ContextManager {
    private WeakReference<Context> mContextWeakReference;

    /* loaded from: classes7.dex */
    private static class SingletonHelper {
        private static final ContextManager INSTANCE = new ContextManager();

        private SingletonHelper() {
        }
    }

    public static ContextManager instance() {
        return SingletonHelper.INSTANCE;
    }

    public void setContext(Context context) {
        if (this.mContextWeakReference != null) {
            this.mContextWeakReference = null;
        }
        this.mContextWeakReference = new WeakReference<>(context);
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContextWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.mContextWeakReference.get();
    }
}
