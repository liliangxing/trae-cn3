package com.bytedance.trae.utils.logger;

import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FLogger.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\n\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00112\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fH\u0016J2\u0010 \u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00112 \u0010!\u001a\u001c\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b\u0018\u00010\"H\u0016J6\u0010$\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fH\u0016J\u001a\u0010(\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010)\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010,\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006-"}, d2 = {"Lcom/bytedance/trae/utils/logger/FLogger;", "Lcom/bytedance/trae/utils/logger/ILogger;", "<init>", "()V", "impl", "spiImpl", "getSpiImpl", "()Lcom/bytedance/trae/utils/logger/ILogger;", "spiImpl$delegate", "Lkotlin/Lazy;", "setLogger", "", "logger", "getImpl", "isDebug", "", "getDirPath", "", "isInitSuccess", "v", Constants.NOTIFICATION_TAG, "msg", "d", "i", "w", "tr", "", "e", "uploadAllLog", ReportConst.KEY_SCENE, "unit", "Lkotlin/Function1;", "uploadAllLogV2", "callback", "Lkotlin/Function3;", "", "uploadALog", "startTime", "", "endTime", "perfTraceLog", "perfSceneTraceStart", "sceneName", "uniqId", "perfTSceneTraceEnd", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FLogger implements ILogger {
    private static ILogger impl;
    public static final FLogger INSTANCE = new FLogger();

    /* renamed from: spiImpl$delegate, reason: from kotlin metadata */
    private static final Lazy spiImpl = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.utils.logger.FLogger$$ExternalSyntheticLambda0
        public final Object invoke() {
            ILogger spiImpl_delegate$lambda$0;
            spiImpl_delegate$lambda$0 = FLogger.spiImpl_delegate$lambda$0();
            return spiImpl_delegate$lambda$0;
        }
    });

    private FLogger() {
    }

    private final ILogger getSpiImpl() {
        return (ILogger) spiImpl.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILogger spiImpl_delegate$lambda$0() {
        return (ILogger) ServiceManager.get().getService(ILogger.class);
    }

    public final void setLogger(ILogger logger) {
        impl = logger;
    }

    private final ILogger getImpl() {
        ILogger iLogger = impl;
        return iLogger == null ? getSpiImpl() : iLogger;
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public boolean isDebug() {
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            return impl2.isDebug();
        }
        return false;
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public String getDirPath() {
        String dirPath;
        ILogger impl2 = getImpl();
        return (impl2 == null || (dirPath = impl2.getDirPath()) == null) ? "" : dirPath;
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public boolean isInitSuccess() {
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            return impl2.isInitSuccess();
        }
        return false;
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: v */
    public void mo429v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo429v(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: d */
    public void mo425d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo425d(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: i */
    public void mo428i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo428i(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: w */
    public void mo430w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo430w(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: w */
    public void mo431w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo431w(tag, msg, tr);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: w */
    public void mo432w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo432w(tag, tr);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: e */
    public void mo426e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo426e(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    /* renamed from: e */
    public void mo427e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.mo427e(tag, msg, tr);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void uploadAllLog(String scene, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.uploadAllLog(scene, unit);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void uploadAllLogV2(String scene, Function3<? super Boolean, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.uploadAllLogV2(scene, callback);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void uploadALog(String scene, long startTime, long endTime, Function1<? super Boolean, Unit> unit) {
        Intrinsics.checkNotNullParameter(scene, ReportConst.KEY_SCENE);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.uploadALog(scene, startTime, endTime, unit);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void perfTraceLog(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.perfTraceLog(tag, msg);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void perfSceneTraceStart(String tag, String sceneName, String uniqId) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.perfSceneTraceStart(tag, sceneName, uniqId);
        }
    }

    @Override // com.bytedance.trae.utils.logger.ILogger
    public void perfTSceneTraceEnd(String tag, String sceneName, String uniqId) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        ILogger impl2 = getImpl();
        if (impl2 != null) {
            impl2.perfTSceneTraceEnd(tag, sceneName, uniqId);
        }
    }
}
