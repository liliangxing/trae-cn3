package com.bytedance.lego.init.util;

import android.app.Activity;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.TaskConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: InitContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0007R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u00020\b8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\u0007\u0010\nR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0012\u001a\u00020\u00138FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u0012\u0004\b\u0014\u0010\u0002\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/lego/init/util/InitContext;", "", "()V", "commonParams", "Ljava/util/concurrent/ConcurrentHashMap;", "getCommonParams", "()Ljava/util/concurrent/ConcurrentHashMap;", "isMainProcess", "", "isMainProcess$annotations", "()Z", "isMainProcess$delegate", "Lkotlin/Lazy;", "mainActivity", "Landroid/app/Activity;", "mainActivity$annotations", "getMainActivity", "()Landroid/app/Activity;", "processName", "", "processName$annotations", "getProcessName", "()Ljava/lang/String;", "processName$delegate", "splashActivity", "splashActivity$annotations", "getSplashActivity", "key", "setCommonParams", "", "value", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class InitContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "isMainProcess", "isMainProcess()Z")), (KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(InitContext.class), "processName", "getProcessName()Ljava/lang/String;"))};
    public static final InitContext INSTANCE = new InitContext();

    /* renamed from: isMainProcess$delegate, reason: from kotlin metadata */
    private static final Lazy isMainProcess = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.lego.init.util.InitContext$isMainProcess$2
        public /* bridge */ /* synthetic */ Object invoke() {
            return Boolean.valueOf(m703invoke());
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final boolean m703invoke() {
            return InitScheduler.INSTANCE.getConfig$initscheduler_release().getIsMainProcess();
        }
    });

    /* renamed from: processName$delegate, reason: from kotlin metadata */
    private static final Lazy processName = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.lego.init.util.InitContext$processName$2
        public final String invoke() {
            TaskConfig config$initscheduler_release = InitScheduler.INSTANCE.getConfig$initscheduler_release();
            if (config$initscheduler_release != null) {
                return config$initscheduler_release.getProcessName();
            }
            return null;
        }
    });
    private static final ConcurrentHashMap<Object, Object> commonParams = new ConcurrentHashMap<>();

    public static final String getProcessName() {
        Lazy lazy = processName;
        KProperty kProperty = $$delegatedProperties[1];
        return (String) lazy.getValue();
    }

    public static final boolean isMainProcess() {
        Lazy lazy = isMainProcess;
        KProperty kProperty = $$delegatedProperties[0];
        return ((Boolean) lazy.getValue()).booleanValue();
    }

    @JvmStatic
    public static /* synthetic */ void isMainProcess$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void mainActivity$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void processName$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void splashActivity$annotations() {
    }

    private InitContext() {
    }

    public final ConcurrentHashMap<Object, Object> getCommonParams() {
        return commonParams;
    }

    public static final Activity getMainActivity() {
        return InitScheduler.getMainActivity$initscheduler_release();
    }

    public static final Activity getSplashActivity() {
        return InitScheduler.getSplashActivity$initscheduler_release();
    }

    @JvmStatic
    public static final void setCommonParams(Object key, Object value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        commonParams.put(key, value);
    }

    @JvmStatic
    public static final Object getCommonParams(Object key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return commonParams.get(key);
    }
}
