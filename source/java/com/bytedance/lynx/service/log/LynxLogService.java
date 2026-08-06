package com.bytedance.lynx.service.log;

import android.util.Log;
import com.bytedance.notification.Constants;
import com.lynx.tasm.service.ILynxLogService;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxLogService.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lynx/service/log/LynxLogService;", "Lcom/lynx/tasm/service/ILynxLogService;", "()V", "logOutputChannel", "Lcom/lynx/tasm/service/ILynxLogService$LogOutputChannelType;", "getALogNativeFunctionAddress", "", "functionName", "", "getDefaultWriteFunction", "getLogToSystemStatus", "", "isLogOutputByPlatform", "logByPlatform", "", "level", "", Constants.NOTIFICATION_TAG, "msg", "switchLogToSystem", "enableSystemLog", "Companion", "LynxLogService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxLogService implements ILynxLogService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<LynxLogService> INSTANCE$delegate = LazyKt.lazy(new Function0<LynxLogService>() { // from class: com.bytedance.lynx.service.log.LynxLogService$Companion$INSTANCE$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LynxLogService m705invoke() {
            return new LynxLogService();
        }
    });
    private ILynxLogService.LogOutputChannelType logOutputChannel = ILynxLogService.LogOutputChannelType.Native;

    public void logByPlatform(int level, String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    /* compiled from: LynxLogService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\t\u001a\u00020\u0004H\u0086\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/lynx/service/log/LynxLogService$Companion;", "", "()V", "INSTANCE", "Lcom/bytedance/lynx/service/log/LynxLogService;", "getINSTANCE", "()Lcom/bytedance/lynx/service/log/LynxLogService;", "INSTANCE$delegate", "Lkotlin/Lazy;", "invoke", "LynxLogService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxLogService getINSTANCE() {
            return (LynxLogService) LynxLogService.INSTANCE$delegate.getValue();
        }

        public final LynxLogService invoke() {
            return getINSTANCE();
        }
    }

    public boolean isLogOutputByPlatform() {
        return this.logOutputChannel == ILynxLogService.LogOutputChannelType.Platform;
    }

    public long getDefaultWriteFunction() {
        return getALogNativeFunctionAddress("getALogSimpleWriteFuncAddr");
    }

    public void switchLogToSystem(boolean enableSystemLog) {
        try {
            Class.forName("com.ss.android.agilelogger.ALog").getMethod("setDebug", Boolean.TYPE).invoke(null, Boolean.valueOf(enableSystemLog));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public boolean getLogToSystemStatus() {
        try {
            Class<?> cls = Class.forName("com.ss.android.agilelogger.ALog");
            Field declaredField = cls.getDeclaredField("sDebug");
            declaredField.setAccessible(true);
            return declaredField.getBoolean(cls);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    private final long getALogNativeFunctionAddress(String functionName) {
        try {
            Method declaredMethod = Class.forName("com.ss.android.agilelogger.ALog").getDeclaredMethod(functionName, new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke != null) {
                return ((Long) invoke).longValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        } catch (Exception e) {
            String str = "The ALog " + functionName + " function was not successfully retrieved [ " + e.getMessage();
            if (str == null) {
                str = " ]";
            }
            Log.e("lynx", str);
            return 0L;
        }
    }
}
