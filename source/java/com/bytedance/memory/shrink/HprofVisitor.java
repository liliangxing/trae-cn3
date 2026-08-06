package com.bytedance.memory.shrink;

/* loaded from: classes4.dex */
public class HprofVisitor {
    protected HprofVisitor hv;

    public HprofVisitor(HprofVisitor hprofVisitor) {
        this.hv = hprofVisitor;
    }

    public void visitHeader(String str, int i, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitHeader(str, i, j);
        }
    }

    public void visitStringRecord(HprofID hprofID, String str, int i, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitStringRecord(hprofID, str, i, j);
        }
    }

    public void visitLoadClassRecord(int i, HprofID hprofID, int i2, HprofID hprofID2, int i3, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitLoadClassRecord(i, hprofID, i2, hprofID2, i3, j);
        }
    }

    public void visitStackFrameRecord(HprofID hprofID, HprofID hprofID2, HprofID hprofID3, HprofID hprofID4, int i, int i2, int i3, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitStackFrameRecord(hprofID, hprofID2, hprofID3, hprofID4, i, i2, i3, j);
        }
    }

    public void visitStackTraceRecord(int i, int i2, HprofID[] hprofIDArr, int i3, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitStackTraceRecord(i, i2, hprofIDArr, i3, j);
        }
    }

    public HprofHeapDumpVisitorInterface visitHeapDumpRecord(int i, int i2, long j) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            return hprofVisitor.visitHeapDumpRecord(i, i2, j);
        }
        return null;
    }

    public void visitUnconcernedRecord(int i, int i2, long j, byte[] bArr) {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitUnconcernedRecord(i, i2, j, bArr);
        }
    }

    public void visitEnd() {
        HprofVisitor hprofVisitor = this.hv;
        if (hprofVisitor != null) {
            hprofVisitor.visitEnd();
        }
    }
}
