package com.bytedance.ies.xbridge.base.runtime.thread;

import android.os.Handler;
import android.os.Looper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* compiled from: ThreadUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/thread/ThreadUtils;", "", "()V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler$annotations", "getMainThreadHandler", "()Landroid/os/Handler;", "mainThreadHandler$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ThreadUtils {
    public static final ThreadUtils INSTANCE = new ThreadUtils();

    /* renamed from: mainThreadHandler$delegate, reason: from kotlin metadata */
    private static final Lazy mainThreadHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.ies.xbridge.base.runtime.thread.ThreadUtils$mainThreadHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m633invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    @JvmStatic
    public static /* synthetic */ void getMainThreadHandler$annotations() {
    }

    private ThreadUtils() {
    }

    public static final Handler getMainThreadHandler() {
        return (Handler) mainThreadHandler.getValue();
    }
}
