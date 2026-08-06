package com.bytedance.trae.apm.api;

import android.app.Application;
import android.content.Context;
import com.bytedance.trae.apm.api.INpth;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INpth.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/apm/api/INpth;", "", "init", "", "baseCtx", "Landroid/content/Context;", "registerCrashCallback", "crashCallback", "Lcom/bytedance/trae/apm/api/ICrashCallback;", "stopUpload", "stop", "", "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", "", "enableGwpAsan", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface INpth {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void enableGwpAsan();

    void goUpload();

    void init(Context baseCtx);

    void registerCrashCallback(ICrashCallback crashCallback);

    void startNpthLifecycleRecorder(Application app, int maxLifeCycleCount);

    void stopUpload(boolean stop);

    /* compiled from: INpth.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u000bR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/apm/api/INpth$Companion;", "", "<init>", "()V", "impl", "Lcom/bytedance/trae/apm/api/INpth;", "getImpl", "()Lcom/bytedance/trae/apm/api/INpth;", "impl$delegate", "Lkotlin/Lazy;", "init", "", "base", "Landroid/content/Context;", "registerCrashCallback", "crashCallback", "Lcom/bytedance/trae/apm/api/ICrashCallback;", "stopUpload", "stop", "", "goUpload", "startNpthLifecycleRecorder", "app", "Landroid/app/Application;", "maxLifeCycleCount", "", "enableGwpAsan", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: impl$delegate, reason: from kotlin metadata */
        private static final Lazy<INpth> impl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.apm.api.INpth$Companion$$ExternalSyntheticLambda0
            public final Object invoke() {
                INpth impl_delegate$lambda$0;
                impl_delegate$lambda$0 = INpth.Companion.impl_delegate$lambda$0();
                return impl_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        private final INpth getImpl() {
            return (INpth) impl.getValue();
        }

        public final void init(Context base) {
            Intrinsics.checkNotNullParameter(base, "base");
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.init(base);
            }
        }

        public final void registerCrashCallback(ICrashCallback crashCallback) {
            Intrinsics.checkNotNullParameter(crashCallback, "crashCallback");
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.registerCrashCallback(crashCallback);
            }
        }

        public final void stopUpload(boolean stop) {
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.stopUpload(stop);
            }
        }

        public final void goUpload() {
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.goUpload();
            }
        }

        public final void startNpthLifecycleRecorder(Application app, int maxLifeCycleCount) {
            Intrinsics.checkNotNullParameter(app, "app");
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.startNpthLifecycleRecorder(app, maxLifeCycleCount);
            }
        }

        public final void enableGwpAsan() {
            INpth impl2 = getImpl();
            if (impl2 != null) {
                impl2.enableGwpAsan();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final INpth impl_delegate$lambda$0() {
            return (INpth) ServiceManager.get().getService(INpth.class);
        }
    }
}
