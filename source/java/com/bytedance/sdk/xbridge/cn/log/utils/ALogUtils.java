package com.bytedance.sdk.xbridge.cn.log.utils;

import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.trae.im.model.MessagePart;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ALogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/log/utils/ALogUtils;", "", "()V", "getALogByLogger", "Lcom/bytedance/sdk/xbridge/cn/utils/UGLogger$IALog;", "printALog", "", "message", "", "tag", "level", MessagePart.TYPE_FILE, "function", "line", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ALogUtils {
    public static final ALogUtils INSTANCE = new ALogUtils();

    private ALogUtils() {
    }

    public final void printALog(String message, String tag, String level, String file, String function, int line) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(file, MessagePart.TYPE_FILE);
        Intrinsics.checkNotNullParameter(function, "function");
        String sb = new StringBuilder(message.length() + 100).append("[").append(file).append(", ").append(function).append(", ").append(line).append("]").append(message).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "builder.toString()");
        String str = "web_" + tag;
        switch (level.hashCode()) {
            case 3237038:
                if (level.equals("info")) {
                    getALogByLogger().mo167i(str, sb);
                    return;
                }
                break;
            case 3641990:
                if (level.equals("warn")) {
                    getALogByLogger().mo169w(str, sb);
                    return;
                }
                break;
            case 95458899:
                if (level.equals("debug")) {
                    getALogByLogger().mo164d(str, sb);
                    return;
                }
                break;
            case 96784904:
                if (level.equals("error")) {
                    getALogByLogger().mo165e(str, sb);
                    return;
                }
                break;
            case 351107458:
                if (level.equals("verbose")) {
                    getALogByLogger().mo168v(str, sb);
                    return;
                }
                break;
        }
        throw new IllegalArgumentException("Illegal level!");
    }

    private final UGLogger.IALog getALogByLogger() {
        return UGLogger.INSTANCE.getALog();
    }
}
