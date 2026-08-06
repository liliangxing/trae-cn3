package com.bytedance.pia.core.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\b\u0010\u0015\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0007J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/pia/core/utils/ThreadUtil;", "", "()V", "mPiaThread", "Landroid/os/HandlerThread;", "getMPiaThread", "()Landroid/os/HandlerThread;", "mPiaThread$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "piaHandler", "getPiaHandler", "piaHandler$delegate", "cancelOnPia", "", "runnable", "Ljava/lang/Runnable;", "checkMainThread", "checkPiaThread", "runOnMain", "runOnPia", "delayTime", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ThreadUtil {
    public static final ThreadUtil INSTANCE = new ThreadUtil();

    /* renamed from: mPiaThread$delegate, reason: from kotlin metadata */
    private static final Lazy mPiaThread = LazyKt.lazy(new Function0<HandlerThread>() { // from class: com.bytedance.pia.core.utils.ThreadUtil$mPiaThread$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HandlerThread m771invoke() {
            HandlerThread handlerThread = new HandlerThread("pia_thread");
            handlerThread.start();
            return handlerThread;
        }
    });

    /* renamed from: piaHandler$delegate, reason: from kotlin metadata */
    private static final Lazy piaHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.pia.core.utils.ThreadUtil$piaHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m773invoke() {
            HandlerThread mPiaThread2;
            mPiaThread2 = ThreadUtil.INSTANCE.getMPiaThread();
            return new Handler(mPiaThread2.getLooper());
        }
    });

    /* renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private static final Lazy mainHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.pia.core.utils.ThreadUtil$mainHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m772invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    private ThreadUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HandlerThread getMPiaThread() {
        return (HandlerThread) mPiaThread.getValue();
    }

    public final Handler getPiaHandler() {
        return (Handler) piaHandler.getValue();
    }

    public final Handler getMainHandler() {
        return (Handler) mainHandler.getValue();
    }

    @JvmStatic
    public static final void checkPiaThread() {
        Intrinsics.areEqual(INSTANCE.getPiaHandler().getLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void runOnPia(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadUtil threadUtil = INSTANCE;
        if (Intrinsics.areEqual(threadUtil.getPiaHandler().getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            threadUtil.getPiaHandler().post(runnable);
        }
    }

    @JvmStatic
    public static final void runOnPia(Runnable runnable, long delayTime) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        INSTANCE.getPiaHandler().postDelayed(runnable, delayTime);
    }

    @JvmStatic
    public static final void cancelOnPia(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        INSTANCE.getPiaHandler().removeCallbacks(runnable);
    }

    @JvmStatic
    public static final void checkMainThread() {
        Intrinsics.areEqual(INSTANCE.getMainHandler().getLooper(), Looper.myLooper());
    }

    @JvmStatic
    public static final void runOnMain(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ThreadUtil threadUtil = INSTANCE;
        if (Intrinsics.areEqual(threadUtil.getMainHandler().getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            threadUtil.getMainHandler().post(runnable);
        }
    }
}
