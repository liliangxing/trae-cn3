package com.bytedance.memory.shrink;

/* loaded from: classes4.dex */
public class HprofHeapDumpVisitorInterface {
    protected final HprofHeapDumpVisitorInterface hdv;

    public HprofHeapDumpVisitorInterface(HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface) {
        this.hdv = hprofHeapDumpVisitorInterface;
    }

    public void visitHeapDumpInfo(int i, HprofID hprofID) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpInfo(i, hprofID);
        }
    }

    public void visitHeapDumpBasicObj(int i, HprofID hprofID) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpBasicObj(i, hprofID);
        }
    }

    public void visitHeapDumpJniLocal(HprofID hprofID, int i, int i2) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpJniLocal(hprofID, i, i2);
        }
    }

    public void visitHeapDumpJavaFrame(HprofID hprofID, int i, int i2) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpJavaFrame(hprofID, i, i2);
        }
    }

    public void visitHeapDumpNativeStack(HprofID hprofID, int i) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpNativeStack(hprofID, i);
        }
    }

    public void visitHeapDumpThreadBlock(HprofID hprofID, int i) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpThreadBlock(hprofID, i);
        }
    }

    public void visitHeapDumpThreadObject(HprofID hprofID, int i, int i2) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpThreadObject(hprofID, i, i2);
        }
    }

    public void visitHeapDumpClass(HprofID hprofID, int i, HprofID hprofID2, HprofID hprofID3, int i2, HprofField[] hprofFieldArr, HprofField[] hprofFieldArr2) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpClass(hprofID, i, hprofID2, hprofID3, i2, hprofFieldArr, hprofFieldArr2);
        }
    }

    public void visitHeapDumpInstance(HprofID hprofID, int i, HprofID hprofID2, byte[] bArr) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpInstance(hprofID, i, hprofID2, bArr);
        }
    }

    public void visitHeapDumpJniMonitor(HprofID hprofID, int i, int i2) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpJniMonitor(hprofID, i, i2);
        }
    }

    public void visitHeapDumpPrimitiveArray(int i, HprofID hprofID, int i2, int i3, int i4, byte[] bArr) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpPrimitiveArray(i, hprofID, i2, i3, i4, bArr);
        }
    }

    public void visitHeapDumpObjectArray(HprofID hprofID, int i, int i2, HprofID hprofID2, byte[] bArr) {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitHeapDumpObjectArray(hprofID, i, i2, hprofID2, bArr);
        }
    }

    public void visitEnd() {
        HprofHeapDumpVisitorInterface hprofHeapDumpVisitorInterface = this.hdv;
        if (hprofHeapDumpVisitorInterface != null) {
            hprofHeapDumpVisitorInterface.visitEnd();
        }
    }
}
