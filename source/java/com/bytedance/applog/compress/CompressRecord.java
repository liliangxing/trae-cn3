package com.bytedance.applog.compress;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class CompressRecord {
    public int compressSize;
    public long compressTime;
    public int dataSize;
    public int encodeType;
    public int result;
    public int token;

    public String toString() {
        return "{dataSize=" + this.dataSize + ", compressSize=" + this.compressSize + ", encodeType=" + this.encodeType + ", compressTime=" + this.compressTime + ", result=" + this.result + ", token=" + this.token + AbstractJsonLexerKt.END_OBJ;
    }
}
