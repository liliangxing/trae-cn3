package com.bytedance.timonbase;

import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.foundation.interfaces.ILogger;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMLogger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J3\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\n\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/TMLogger;", "", "()V", "ROOT_TAG", "", "d", "", "tag", "message", "args", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "throwable", "", "i", "setDebug", "debug", "", "v", "w", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMLogger {
    public static final TMLogger INSTANCE = new TMLogger();
    private static final String ROOT_TAG = "Timon";

    private TMLogger() {
    }

    /* renamed from: d */
    public final void m219d(String tag, String message) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (TMEnv.INSTANCE.getDEBUG()) {
            TimonFoundation.INSTANCE.getLogger().mo213d("Timon-" + tag, message, null);
        }
    }

    /* renamed from: d */
    public final void m220d(String tag, String message, Object... args) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (TMEnv.INSTANCE.getDEBUG()) {
            TimonFoundation.INSTANCE.getLogger().mo213d("Timon-" + tag, message + " " + ArraysKt.joinToString$default(args, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null), null);
        }
    }

    /* renamed from: v */
    public final void m224v(String tag, String message) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        TimonFoundation.INSTANCE.getLogger().mo216v("Timon-" + tag, message, null);
    }

    /* renamed from: i */
    public final void m223i(String tag, String message) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        TimonFoundation.INSTANCE.getLogger().mo215i("Timon-" + tag, message, null);
    }

    /* renamed from: w */
    public final void m225w(String tag, String message) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        TimonFoundation.INSTANCE.getLogger().mo217w("Timon-" + tag, message, null);
    }

    /* renamed from: e */
    public final void m221e(String tag, String message) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        TimonFoundation.INSTANCE.getLogger().mo214e("Timon-" + tag, message, null);
    }

    @JvmStatic
    /* renamed from: w */
    public static final void m218w(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        TimonFoundation.INSTANCE.getLogger().mo217w("Timon-" + tag, message, throwable);
    }

    /* renamed from: e */
    public final void m222e(String tag, String message, Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        ILogger logger = TimonFoundation.INSTANCE.getLogger();
        String str = "Timon-" + tag;
        if (message == null) {
            message = "";
        }
        logger.mo214e(str, message, throwable);
    }

    public final void setDebug(boolean debug) {
        TimonFoundation.INSTANCE.getLogger().setDebugMode(debug);
    }
}
