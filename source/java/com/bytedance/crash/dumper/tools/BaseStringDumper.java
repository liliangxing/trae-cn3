package com.bytedance.crash.dumper.tools;

/* loaded from: classes3.dex */
abstract class BaseStringDumper {
    IStringDumperImpl mDumpImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(char c);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void append(char[] cArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void flush();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void release();

    /* JADX INFO: Access modifiers changed from: package-private */
    public IStringDumperImpl createImpl(String str, int i) {
        NativeStringDumperImpl create = NativeStringDumperImpl.create(str, i);
        return create != null ? create : JavaStringDumperImpl.create(str);
    }
}
