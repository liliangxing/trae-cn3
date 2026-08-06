package com.bytedance.gkfs.cdc;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: HexUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0010\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/gkfs/cdc/HexUtil;", "", "()V", "HEX_CHAR", "", "decode", "", "hex", "", "encode", "bytes", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final class HexUtil {
    public static final HexUtil INSTANCE = new HexUtil();
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private HexUtil() {
    }

    public final String encode(byte[] bytes) {
        if (bytes != null) {
            if (!(bytes.length == 0)) {
                StringBuffer stringBuffer = new StringBuffer(bytes.length * 2);
                for (byte b : bytes) {
                    char[] cArr = HEX_CHAR;
                    stringBuffer.append(cArr[(b & 240) >> 4]).append(cArr[b & 15]);
                }
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "sb.toString()");
                return stringBuffer2;
            }
        }
        throw new NullPointerException("bytes array MUST not be NULL!");
    }

    public final byte[] decode(String hex) {
        String str = hex;
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = hex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int i3 = i2 + 1;
            if (hex != null) {
                String substring = hex.substring(i2, i3);
                Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring, CharsKt.checkRadix(16));
                int i4 = i2 + 2;
                if (hex != null) {
                    String substring2 = hex.substring(i3, i4);
                    Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    bArr[i] = (byte) ((parseInt << 4) + Integer.parseInt(substring2, CharsKt.checkRadix(16)));
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return bArr;
    }
}
