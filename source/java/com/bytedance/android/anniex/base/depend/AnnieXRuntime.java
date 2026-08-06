package com.bytedance.android.anniex.base.depend;

import com.bytedance.android.anniex.assemble.initialize.IAnnieXHostDepend;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXRuntime.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/AnnieXRuntime;", "", "()V", "ANNIE_X_HOST_DEPEND_CLASS_NAME", "", AnnieXRuntime.NOT_IMPLEMENT, "applicationDepend", "Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "getApplicationDepend", "()Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "applicationDepend$delegate", "Lkotlin/Lazy;", "deviceDepend", "Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "getDeviceDepend", "()Lcom/bytedance/android/anniex/base/depend/DeviceDepend;", "deviceDepend$delegate", "hostDepend", "Lcom/bytedance/android/anniex/assemble/initialize/IAnnieXHostDepend;", "getHostDepend", "()Lcom/bytedance/android/anniex/assemble/initialize/IAnnieXHostDepend;", "hostDepend$delegate", "init", "", "builder", "Lcom/bytedance/android/anniex/base/depend/AnnieXRuntimeBuilder;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXRuntime {
    private static final String ANNIE_X_HOST_DEPEND_CLASS_NAME = "com.bytedance.android.anniex.assemble.initialize.AnnieXHostDepend";
    public static final String NOT_IMPLEMENT = "NOT_IMPLEMENT";
    public static final AnnieXRuntime INSTANCE = new AnnieXRuntime();

    /* renamed from: hostDepend$delegate, reason: from kotlin metadata */
    private static final Lazy hostDepend = LazyKt.lazy(new Function0<IAnnieXHostDepend>() { // from class: com.bytedance.android.anniex.base.depend.AnnieXRuntime$hostDepend$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final IAnnieXHostDepend m3289invoke() {
            try {
                Object newInstance = Class.forName("com.bytedance.android.anniex.assemble.initialize.AnnieXHostDepend").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (newInstance instanceof IAnnieXHostDepend) {
                    return (IAnnieXHostDepend) newInstance;
                }
                return null;
            } catch (Exception unused) {
                HybridLogger.e$default(HybridLogger.INSTANCE, "XInit", "create AnnieXHostDepend by reflect failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                return null;
            }
        }
    });

    /* renamed from: applicationDepend$delegate, reason: from kotlin metadata */
    private static final Lazy applicationDepend = LazyKt.lazy(new Function0<ApplicationDepend>() { // from class: com.bytedance.android.anniex.base.depend.AnnieXRuntime$applicationDepend$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ApplicationDepend m3287invoke() {
            ApplicationDepend createApplicationDepend;
            IAnnieXHostDepend hostDepend2 = AnnieXRuntime.INSTANCE.getHostDepend();
            return (hostDepend2 == null || (createApplicationDepend = hostDepend2.createApplicationDepend()) == null) ? new ApplicationDepend() : createApplicationDepend;
        }
    });

    /* renamed from: deviceDepend$delegate, reason: from kotlin metadata */
    private static final Lazy deviceDepend = LazyKt.lazy(new Function0<DeviceDepend>() { // from class: com.bytedance.android.anniex.base.depend.AnnieXRuntime$deviceDepend$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DeviceDepend m3288invoke() {
            DeviceDepend createDeviceDepend;
            IAnnieXHostDepend hostDepend2 = AnnieXRuntime.INSTANCE.getHostDepend();
            return (hostDepend2 == null || (createDeviceDepend = hostDepend2.createDeviceDepend()) == null) ? new DeviceDepend() : createDeviceDepend;
        }
    });

    public final void init(AnnieXRuntimeBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    private AnnieXRuntime() {
    }

    public final IAnnieXHostDepend getHostDepend() {
        return (IAnnieXHostDepend) hostDepend.getValue();
    }

    public final ApplicationDepend getApplicationDepend() {
        return (ApplicationDepend) applicationDepend.getValue();
    }

    public final DeviceDepend getDeviceDepend() {
        return (DeviceDepend) deviceDepend.getValue();
    }
}
