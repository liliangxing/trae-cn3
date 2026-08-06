package com.bytedance.security.android.aopcheck.utils;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackTraceUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/security/android/aopcheck/utils/StackTraceUtil;", "", "()V", "getRawStack", "", LynxError.LYNX_THROWABLE, "", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class StackTraceUtil {
    public static final StackTraceUtil INSTANCE = new StackTraceUtil();

    private StackTraceUtil() {
    }

    public final String getRawStack(Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(throwable, "throwable");
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            if (i < 6) {
                i++;
            } else {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(System.getProperty("line.separator"));
                }
                stringBuffer.append(stackTraceElement.toString());
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }
}
