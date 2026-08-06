package com.bytedance.trae.update;

import com.bytedance.notification.Constants;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.update.IUpdateLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBitsUpdateImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/update/UpdateSdkLogger;", "Lcom/ss/android/update/IUpdateLogger;", "<init>", "()V", "v", "", Constants.NOTIFICATION_TAG, "", "msg", "d", "i", "w", "tr", "", "e", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateSdkLogger implements IUpdateLogger {
    /* renamed from: v */
    public void m420v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo429v(tag, msg);
    }

    /* renamed from: d */
    public void m416d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo425d(tag, msg);
    }

    /* renamed from: i */
    public void m419i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo428i(tag, msg);
    }

    /* renamed from: w */
    public void m421w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo430w(tag, msg);
    }

    /* renamed from: w */
    public void m422w(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo431w(tag, msg, tr);
    }

    /* renamed from: w */
    public void m423w(String tag, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo432w(tag, tr);
    }

    /* renamed from: e */
    public void m417e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo426e(tag, msg);
    }

    /* renamed from: e */
    public void m418e(String tag, String msg, Throwable tr) {
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        FLogger.INSTANCE.mo427e(tag, msg, tr);
    }
}
