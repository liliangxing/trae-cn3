package com.bytedance.sdk.open.aweme.commonbase.net;

import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class b {
    public static byte[] a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
