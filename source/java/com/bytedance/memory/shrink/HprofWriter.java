package com.bytedance.memory.shrink;

import com.bytedance.memory.common.MemoryLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HprofWriter extends HprofVisitor {
    private final HprofClassInfoVisitor mClassInfoVistor;
    private final ByteArrayOutputStream mHeapDumpOut;
    private int mIdSize;
    private final OutputStream mStreamOut;

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStackFrameRecord(HprofID hprofID, HprofID hprofID2, HprofID hprofID3, HprofID hprofID4, int i, int i2, int i3, long j) {
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStackTraceRecord(int i, int i2, HprofID[] hprofIDArr, int i3, long j) {
    }

    public HprofWriter(OutputStream outputStream, HprofClassInfoVisitor hprofClassInfoVisitor) {
        super(null);
        this.mIdSize = 0;
        this.mHeapDumpOut = new ByteArrayOutputStream();
        this.mStreamOut = outputStream;
        this.mClassInfoVistor = hprofClassInfoVisitor;
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitHeader(String str, int i, long j) {
        try {
            this.mIdSize = i;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitStringRecord(HprofID hprofID, String str, int i, long j) {
        try {
            this.mStreamOut.write(1);
            MemoryIOUtil.writeBEShort(this.mStreamOut, (int) j);
            this.mStreamOut.write(hprofID.getBytes());
            MemoryIOUtil.writeString(this.mStreamOut, str);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitLoadClassRecord(int i, HprofID hprofID, int i2, HprofID hprofID2, int i3, long j) {
        try {
            this.mStreamOut.write(2);
            this.mStreamOut.write(hprofID.getBytes());
            this.mStreamOut.write(hprofID2.getBytes());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public HprofHeapDumpWriter visitHeapDumpRecord(int i, int i2, long j) {
        try {
            return new HprofHeapDumpWriter(i, i2, j);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitUnconcernedRecord(int i, int i2, long j, byte[] bArr) {
        if (i == 44) {
            try {
                this.mStreamOut.write(i);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    @Override // com.bytedance.memory.shrink.HprofVisitor
    public void visitEnd() {
        try {
            this.mStreamOut.flush();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class HprofHeapDumpWriter extends HprofHeapDumpVisitorInterface {
        private final long mOrigLength;
        private final int mTag;
        private final int mTimestamp;

        HprofHeapDumpWriter(int i, int i2, long j) {
            super(null);
            this.mTag = i;
            this.mTimestamp = i2;
            this.mOrigLength = j;
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpInfo(int i, HprofID hprofID) {
            try {
                HprofWriter.this.mHeapDumpOut.write(HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_HEAP_DUMP_INFO);
                MemoryIOUtil.writeBEInt(HprofWriter.this.mHeapDumpOut, i);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpBasicObj(int i, HprofID hprofID) {
            try {
                HprofWriter.this.mHeapDumpOut.write(i);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
                if (i == 1) {
                    MemoryIOUtil.skip(HprofWriter.this.mHeapDumpOut, HprofWriter.this.mIdSize);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJniLocal(HprofID hprofID, int i, int i2) {
            try {
                HprofWriter.this.mHeapDumpOut.write(2);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJavaFrame(HprofID hprofID, int i, int i2) {
            try {
                HprofWriter.this.mHeapDumpOut.write(3);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpNativeStack(HprofID hprofID, int i) {
            try {
                HprofWriter.this.mHeapDumpOut.write(4);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpThreadBlock(HprofID hprofID, int i) {
            try {
                HprofWriter.this.mHeapDumpOut.write(6);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpThreadObject(HprofID hprofID, int i, int i2) {
            try {
                HprofWriter.this.mHeapDumpOut.write(8);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpClass(HprofID hprofID, int i, HprofID hprofID2, HprofID hprofID3, int i2, HprofField[] hprofFieldArr, HprofField[] hprofFieldArr2) {
            try {
                HprofWriter.this.mHeapDumpOut.write(32);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
                HprofWriter.this.mHeapDumpOut.write(hprofID2.getBytes());
                HprofWriter.this.mHeapDumpOut.write(hprofID3.getBytes());
                MemoryIOUtil.skip(HprofWriter.this.mHeapDumpOut, HprofWriter.this.mIdSize << 1);
                MemoryIOUtil.writeBEShort(HprofWriter.this.mHeapDumpOut, i2);
                MemoryIOUtil.writeBEShort(HprofWriter.this.mHeapDumpOut, 0);
                MemoryIOUtil.writeBEShort(HprofWriter.this.mHeapDumpOut, hprofFieldArr.length);
                for (HprofField hprofField : hprofFieldArr) {
                    MemoryIOUtil.writeID(HprofWriter.this.mHeapDumpOut, hprofField.mNameId);
                    HprofWriter.this.mHeapDumpOut.write(hprofField.mTypeId);
                    if (HprofWriter.this.mClassInfoVistor != null) {
                        MemoryIOUtil.writeEmptyValue(HprofWriter.this.mHeapDumpOut, hprofField.mStaticValue);
                    } else {
                        MemoryIOUtil.writeValue(HprofWriter.this.mHeapDumpOut, hprofField.mStaticValue);
                    }
                }
                MemoryIOUtil.writeBEShort(HprofWriter.this.mHeapDumpOut, hprofFieldArr2.length);
                for (HprofField hprofField2 : hprofFieldArr2) {
                    MemoryIOUtil.writeID(HprofWriter.this.mHeapDumpOut, hprofField2.mNameId);
                    HprofWriter.this.mHeapDumpOut.write(hprofField2.mTypeId);
                }
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpInstance(HprofID hprofID, int i, HprofID hprofID2, byte[] bArr) {
            try {
                HprofWriter.this.mHeapDumpOut.write(33);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
                HprofWriter.this.mHeapDumpOut.write(hprofID2.getBytes());
                MemoryIOUtil.writeBEInt(HprofWriter.this.mHeapDumpOut, bArr.length);
                HprofWriter.this.mHeapDumpOut.write(eraseFieldData(hprofID, hprofID2, bArr));
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpObjectArray(HprofID hprofID, int i, int i2, HprofID hprofID2, byte[] bArr) {
            try {
                HprofWriter.this.mHeapDumpOut.write(34);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
                MemoryIOUtil.writeBEInt(HprofWriter.this.mHeapDumpOut, i2);
                HprofWriter.this.mHeapDumpOut.write(hprofID2.getBytes());
                HprofWriter.this.mHeapDumpOut.write(bArr, 0, i2 * HprofWriter.this.mIdSize);
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpPrimitiveArray(int i, HprofID hprofID, int i2, int i3, int i4, byte[] bArr) {
            try {
                HprofWriter.this.mHeapDumpOut.write(i);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
                MemoryIOUtil.writeBEInt(HprofWriter.this.mHeapDumpOut, i3);
                HprofWriter.this.mHeapDumpOut.write(i4);
                BaseType type = BaseType.getType(i4);
                if (type == BaseType.CHAR || type == BaseType.BYTE) {
                    return;
                }
                MemoryIOUtil.skip(HprofWriter.this.mHeapDumpOut, i3 * BaseType.getType(i4).getSize(HprofWriter.this.mIdSize));
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitHeapDumpJniMonitor(HprofID hprofID, int i, int i2) {
            try {
                HprofWriter.this.mHeapDumpOut.write(HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_JNI_MONITOR);
                HprofWriter.this.mHeapDumpOut.write(hprofID.getBytes());
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        @Override // com.bytedance.memory.shrink.HprofHeapDumpVisitorInterface
        public void visitEnd() {
            try {
                HprofWriter.this.mStreamOut.write(this.mTag);
                HprofWriter.this.mStreamOut.write(HprofWriter.this.mHeapDumpOut.toByteArray());
                HprofWriter.this.mHeapDumpOut.reset();
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }

        public byte[] eraseFieldData(HprofID hprofID, HprofID hprofID2, byte[] bArr) {
            if (HprofWriter.this.mClassInfoVistor == null) {
                return bArr;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            HeapClassDump heapClassDump = HprofWriter.this.mClassInfoVistor.getClassDump().get(hprofID2);
            while (heapClassDump != null) {
                try {
                    if (!heapClassDump.f48id.equals(HprofWriter.this.mClassInfoVistor.mActivityClassObjectId)) {
                        for (HprofField hprofField : heapClassDump.instanceFields) {
                            eraseBaseTypeData(byteArrayInputStream, byteArrayOutputStream, BaseType.getType(hprofField.mTypeId));
                        }
                    } else {
                        for (HprofField hprofField2 : heapClassDump.instanceFields) {
                            MemoryIOUtil.writeValue(byteArrayOutputStream, MemoryIOUtil.readValue(byteArrayInputStream, BaseType.getType(hprofField2.mTypeId), HprofWriter.this.mIdSize));
                        }
                        MemoryLog.m101i("find a activity skip erase " + heapClassDump.f48id, new Object[0]);
                    }
                    heapClassDump = HprofWriter.this.mClassInfoVistor.getClassDump().get(heapClassDump.superClassId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return byteArrayOutputStream.toByteArray();
        }

        private void eraseBaseTypeData(ByteArrayInputStream byteArrayInputStream, ByteArrayOutputStream byteArrayOutputStream, BaseType baseType) throws IOException {
            switch (C03221.$SwitchMap$com$bytedance$memory$shrink$BaseType[baseType.ordinal()]) {
                case 1:
                    MemoryIOUtil.writeID(byteArrayOutputStream, MemoryIOUtil.readID(byteArrayInputStream, HprofWriter.this.mIdSize));
                    return;
                case 2:
                case 3:
                    byteArrayInputStream.read();
                    byteArrayOutputStream.write(0);
                    return;
                case 4:
                case 5:
                    MemoryIOUtil.readBEShort(byteArrayInputStream);
                    MemoryIOUtil.writeBEShort(byteArrayOutputStream, 0);
                    return;
                case 6:
                case 7:
                    MemoryIOUtil.readBEInt(byteArrayInputStream);
                    MemoryIOUtil.writeBEInt(byteArrayOutputStream, 0);
                    return;
                case 8:
                case 9:
                    MemoryIOUtil.readBELong(byteArrayInputStream);
                    MemoryIOUtil.writeBELong(byteArrayOutputStream, 0L);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.memory.shrink.HprofWriter$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C03221 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$memory$shrink$BaseType;

        static {
            int[] iArr = new int[BaseType.values().length];
            $SwitchMap$com$bytedance$memory$shrink$BaseType = iArr;
            try {
                iArr[BaseType.OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.CHAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.SHORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.INT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bytedance$memory$shrink$BaseType[BaseType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }
}
