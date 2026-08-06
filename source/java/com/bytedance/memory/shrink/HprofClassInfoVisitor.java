package com.bytedance.memory.shrink;

import com.bytedance.memory.common.MemoryLog;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HprofClassInfoVisitor extends HprofVisitor {
    private final String ACTIVTY_CLASS_NAME;
    public HprofID mActivityClassObjectId;
    public HprofID mActivityStringId;
    private final HashMap<HprofID, HeapClassDump> mClassDump;
    private final Recorder mHeapRecord;
    private int mIdSize;
    private final Recorder mRecord;
    private HashMap<HprofID, HprofID> mStringCache;

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStackFrameRecord(HprofID hprofID, HprofID hprofID2, HprofID hprofID3, HprofID hprofID4, int i, int i2, int i3, long j) {
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStackTraceRecord(int i, int i2, HprofID[] hprofIDArr, int i3, long j) {
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitUnconcernedRecord(int i, int i2, long j, byte[] bArr) {
    }

    public HprofClassInfoVisitor() {
        super(null);
        this.mIdSize = 0;
        this.mClassDump = new HashMap<>();
        this.mRecord = new Recorder();
        this.mHeapRecord = new Recorder();
        this.ACTIVTY_CLASS_NAME = "android.app.Activity";
        this.mActivityStringId = null;
        this.mActivityClassObjectId = null;
        this.mStringCache = null;
        this.mStringCache = new HashMap<>();
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitHeader(String str, int i, long j) {
        this.mIdSize = i;
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStringRecord(HprofID hprofID, String str, int i, long j) {
        this.mRecord.increment(1);
        if (this.mActivityStringId == null && "android.app.Activity".equals(str)) {
            this.mActivityStringId = hprofID;
            MemoryLog.m101i("find activity string id=" + this.mActivityStringId, new Object[0]);
            this.mActivityClassObjectId = this.mStringCache.get(this.mActivityStringId);
            MemoryLog.m101i("find activity from cache object id=" + this.mActivityClassObjectId + " cache size=" + this.mStringCache.size(), new Object[0]);
            this.mStringCache.clear();
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitLoadClassRecord(int i, HprofID hprofID, int i2, HprofID hprofID2, int i3, long j) {
        this.mRecord.increment(2);
        HprofID hprofID3 = this.mActivityStringId;
        if (hprofID3 != null) {
            if (hprofID3.equals(hprofID2)) {
                this.mActivityClassObjectId = hprofID;
                MemoryLog.m101i("find activity object id=" + this.mActivityClassObjectId, new Object[0]);
                return;
            }
            return;
        }
        this.mStringCache.put(hprofID2, hprofID);
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public HprofHeapDumpWriter visitHeapDumpRecord(int i, int i2, long j) {
        this.mRecord.increment(28);
        try {
            return new HprofHeapDumpWriter(i, i2, j);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitEnd() {
        MemoryLog.m101i("mRecord=" + this.mRecord, new Object[0]);
        MemoryLog.m101i("mHeapRecord=" + this.mHeapRecord, new Object[0]);
        MemoryLog.m101i("mClassDump size=" + this.mClassDump.size(), new Object[0]);
        MemoryLog.m101i("mActivityStringId=" + this.mActivityStringId + " mActivityClassObjectId=" + this.mActivityClassObjectId, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class HprofHeapDumpWriter extends HprofHeapDumpVisitorInterface {
        private final long mOrigLength;
        private final int mTag;
        private final int mTimestamp;

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitEnd() {
        }

        HprofHeapDumpWriter(int i, int i2, long j) {
            super(null);
            this.mTag = i;
            this.mTimestamp = i2;
            this.mOrigLength = j;
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpInfo(int i, HprofID hprofID) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpBasicObj(int i, HprofID hprofID) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(1);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJniLocal(HprofID hprofID, int i, int i2) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(2);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJavaFrame(HprofID hprofID, int i, int i2) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(3);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpNativeStack(HprofID hprofID, int i) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(4);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpThreadBlock(HprofID hprofID, int i) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(6);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpThreadObject(HprofID hprofID, int i, int i2) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(8);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpClass(HprofID hprofID, int i, HprofID hprofID2, HprofID hprofID3, int i2, HprofField[] hprofFieldArr, HprofField[] hprofFieldArr2) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(32);
            HprofClassInfoVisitor.this.mClassDump.put(hprofID, new HeapClassDump(hprofID, i, hprofID2, hprofID3, i2, hprofFieldArr, hprofFieldArr2));
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpInstance(HprofID hprofID, int i, HprofID hprofID2, byte[] bArr) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(33);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpObjectArray(HprofID hprofID, int i, int i2, HprofID hprofID2, byte[] bArr) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(34);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpPrimitiveArray(int i, HprofID hprofID, int i2, int i3, int i4, byte[] bArr) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(35);
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJniMonitor(HprofID hprofID, int i, int i2) {
            HprofClassInfoVisitor.this.mHeapRecord.increment(HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_JNI_MONITOR);
        }
    }

    public HashMap<HprofID, HeapClassDump> getClassDump() {
        return this.mClassDump;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class Recorder {
        HashMap<Integer, Long> mMap = new HashMap<>();

        Recorder() {
        }

        public void increment(int i) {
            Long l = this.mMap.get(Integer.valueOf(i));
            if (l == null) {
                l = 0L;
            }
            this.mMap.put(Integer.valueOf(i), Long.valueOf(l.longValue() + 1));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Iterator<Integer> it = this.mMap.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                sb.append(String.format("k=%x v=%d,", Integer.valueOf(intValue), this.mMap.get(Integer.valueOf(intValue))));
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
