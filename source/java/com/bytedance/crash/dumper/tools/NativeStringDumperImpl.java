package com.bytedance.crash.dumper.tools;

import com.bytedance.crash.jni.NativeBridge;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class NativeStringDumperImpl implements IStringDumperImpl {
    final long mNativePointer;

    NativeStringDumperImpl(long j) {
        this.mNativePointer = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NativeStringDumperImpl create(String str, int i) {
        long stringDumperCreate = NativeBridge.stringDumperCreate(str, i);
        if (stringDumperCreate != 0) {
            return new NativeStringDumperImpl(stringDumperCreate);
        }
        return null;
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void flush() {
        NativeBridge.stringDumperFlushBuffer(this.mNativePointer);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void release() {
        NativeBridge.stringDumperRelease(this.mNativePointer);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpInt(int i) {
        dumpString(Integer.toString(i));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpLong(long j) {
        dumpString(Long.toString(j));
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpString(String str) {
        NativeBridge.stringDumperDumpString(this.mNativePointer, str, str.length());
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpCharArray(char[] cArr, int i) {
        NativeBridge.stringDumperDumpCharArray(this.mNativePointer, cArr, i);
    }

    @Override // com.bytedance.crash.dumper.tools.IStringDumperImpl
    public void dumpByteArray(byte[] bArr, int i) {
        NativeBridge.stringDumperDumpByteArray(this.mNativePointer, bArr, i);
    }
}
