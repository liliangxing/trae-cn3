package com.bytedance.kmp.network;

import kotlin.Metadata;
import okio.Utf8;

/* compiled from: Character.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/kmp/network/Character;", "", "()V", "HIGH_SURROGATE_ENCODE_OFFSET", "", "MAX_CODE_POINT", "", "MIN_SUPPLEMENTARY_CODE_POINT", "SURROGATE_DECODE_OFFSET", "highSurrogateOf", "codePoint", "highSurrogateOf$network_service_release", "isBmpCodePoint", "", "isBmpCodePoint$network_service_release", "isSupplementaryCodePoint", "isSupplementaryCodePoint$network_service_release", "lowSurrogateOf", "lowSurrogateOf$network_service_release", "toCodePoint", "highSurrogate", "lowSurrogate", "toCodePoint$network_service_release", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Character {
    private static final char HIGH_SURROGATE_ENCODE_OFFSET = 55232;
    public static final Character INSTANCE = new Character();
    private static final int MAX_CODE_POINT = 1114111;
    private static final int MIN_SUPPLEMENTARY_CODE_POINT = 65536;
    private static final int SURROGATE_DECODE_OFFSET = -56613888;

    public final char highSurrogateOf$network_service_release(int codePoint) {
        return (char) ((codePoint >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
    }

    public final boolean isBmpCodePoint$network_service_release(int codePoint) {
        return (codePoint >>> 16) == 0;
    }

    public final boolean isSupplementaryCodePoint$network_service_release(int codePoint) {
        return 65536 <= codePoint && codePoint < 1114112;
    }

    public final char lowSurrogateOf$network_service_release(int codePoint) {
        return (char) ((codePoint & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    public final int toCodePoint$network_service_release(char highSurrogate, char lowSurrogate) {
        return (highSurrogate << '\n') + lowSurrogate + SURROGATE_DECODE_OFFSET;
    }

    private Character() {
    }
}
