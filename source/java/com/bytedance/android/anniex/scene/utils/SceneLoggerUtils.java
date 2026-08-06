package com.bytedance.android.anniex.scene.utils;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.BulletEnv;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SceneLoggerUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ&\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u001c\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/scene/utils/SceneLoggerUtils;", "", "()V", "debugLog", "", "tag", "", "message", "Lkotlin/Function0;", "doLog", "level", "", "infoLog", "warningLog", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SceneLoggerUtils {
    public static final SceneLoggerUtils INSTANCE = new SceneLoggerUtils();

    private SceneLoggerUtils() {
    }

    public final void infoLog(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        doLog(4, tag, message);
    }

    public final void warningLog(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        doLog(5, tag, message);
    }

    public final void debugLog(String tag, Function0<String> message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        doLog(3, tag, message);
    }

    private final void doLog(int level, String tag, Function0<String> message) {
        if (level == 3 && BulletEnv.Companion.getInstance().getDebuggable()) {
            HybridLogger.d$default(HybridLogger.INSTANCE, tag, (String) message.invoke(), (Map) null, (LoggerContext) null, 12, (Object) null);
        } else if (level == 4 || level == 5) {
            HybridLogger.i$default(HybridLogger.INSTANCE, tag, (String) message.invoke(), (Map) null, (LoggerContext) null, 12, (Object) null);
        }
    }
}
