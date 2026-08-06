package com.bytedance.crash.dumper.tools;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DirectStringDumper extends BaseStringDumper {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DirectStringDumper(String str) {
        this.mDumpImpl = createImpl(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void flush() {
        this.mDumpImpl.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void release() {
        this.mDumpImpl.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(char c) {
        this.mDumpImpl.dumpString(String.valueOf(c));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(int i) {
        this.mDumpImpl.dumpInt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(long j) {
        this.mDumpImpl.dumpLong(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(char[] cArr) {
        this.mDumpImpl.dumpCharArray(cArr, cArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(byte[] bArr) {
        this.mDumpImpl.dumpByteArray(bArr, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.crash.dumper.tools.BaseStringDumper
    public void append(String str) {
        this.mDumpImpl.dumpString(str);
    }
}
