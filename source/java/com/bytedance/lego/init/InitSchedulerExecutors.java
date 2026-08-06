package com.bytedance.lego.init;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: InitSchedulerExecutors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/lego/init/InitSchedulerExecutors;", "", "()V", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor$initscheduler_release", "()Ljava/util/concurrent/ThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitSchedulerExecutors {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitSchedulerExecutors.class), "threadPoolExecutor", "getThreadPoolExecutor$initscheduler_release()Ljava/util/concurrent/ThreadPoolExecutor;"))};
    public static final InitSchedulerExecutors INSTANCE = new InitSchedulerExecutors();

    /* renamed from: threadPoolExecutor$delegate, reason: from kotlin metadata */
    private static final Lazy threadPoolExecutor = LazyKt.lazy(new Function0<ThreadPoolExecutor>() { // from class: com.bytedance.lego.init.InitSchedulerExecutors$threadPoolExecutor$2
        public final ThreadPoolExecutor invoke() {
            return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.bytedance.lego.init.InitSchedulerExecutors$threadPoolExecutor$2.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return new Thread(runnable, "A-DelayTaskThread");
                }
            });
        }
    });

    public final ThreadPoolExecutor getThreadPoolExecutor$initscheduler_release() {
        Lazy lazy = threadPoolExecutor;
        KProperty kProperty = $$delegatedProperties[0];
        return (ThreadPoolExecutor) lazy.getValue();
    }

    private InitSchedulerExecutors() {
    }
}
