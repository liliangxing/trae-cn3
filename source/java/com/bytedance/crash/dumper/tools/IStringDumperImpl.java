package com.bytedance.crash.dumper.tools;

/* loaded from: classes3.dex */
interface IStringDumperImpl {
    void dumpByteArray(byte[] bArr, int i);

    void dumpCharArray(char[] cArr, int i);

    void dumpInt(int i);

    void dumpLong(long j);

    void dumpString(String str);

    void flush();

    void release();
}
