package com.lynx.tasm.utils;

import com.lynx.tasm.behavior.shadow.text.TextHelper;
import com.lynx.tasm.common.LepusBuffer;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class TextUtils {
    TextUtils() {
    }

    private static ByteBuffer getTextInfo(String str, String str2, String str3, String str4, int i) {
        return LepusBuffer.INSTANCE.encodeMessage(TextHelper.getTextInfo(str, str2, str3, str4, i));
    }

    private static double getTextWidth(String str, String str2, String str3) {
        if (str.isEmpty() || str2.isEmpty()) {
            return 0.0d;
        }
        return TextHelper.getTextWidth(str, str2, str3);
    }

    private static String getFirstLineText(String str, String str2, String str3, String str4) {
        return (str.isEmpty() || str2.isEmpty()) ? "" : TextHelper.getFirstLineText(str, str2, str3, str4);
    }
}
