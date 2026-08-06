package com.bytedance.realx.base;

import com.bytedance.platform.godzilla.common.Constant;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* loaded from: classes4.dex */
class JniHelper {
    JniHelper() {
    }

    static byte[] getStringBytes(String s) {
        try {
            return s.getBytes(Constant.CHARSET_UTF_8);
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("utf-8 is unsupported");
        }
    }

    static Object getStringClass() {
        return String.class;
    }

    static Object getKey(Map.Entry entry) {
        return entry.getKey();
    }

    static Object getValue(Map.Entry entry) {
        return entry.getValue();
    }
}
