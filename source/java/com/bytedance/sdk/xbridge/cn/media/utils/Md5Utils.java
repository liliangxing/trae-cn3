package com.bytedance.sdk.xbridge.cn.media.utils;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Md5Utils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/Md5Utils;", "", "()V", "hexDigits", "", "hexDigest", "", "bytes", "", "string", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class Md5Utils {
    public static final Md5Utils INSTANCE = new Md5Utils();
    private static final char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private Md5Utils() {
    }

    public final String hexDigest(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return hexDigest(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final String hexDigest(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "messageDigest.digest()");
            char[] cArr = new char[32];
            int i = 0;
            for (int i2 = 0; i2 < 16; i2++) {
                byte b = digest[i2];
                int i3 = i + 1;
                char[] cArr2 = hexDigits;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i = i3 + 1;
                cArr[i3] = cArr2[b & 15];
            }
            return cArr.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
