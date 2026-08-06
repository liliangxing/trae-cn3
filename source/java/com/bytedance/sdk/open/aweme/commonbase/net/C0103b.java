package com.bytedance.sdk.open.aweme.commonbase.net;

import java.io.UnsupportedEncodingException;

/* renamed from: com.bytedance.sdk.open.aweme.commonbase.net.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0103b {
    /* renamed from: a */
    public static byte[] m22a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
