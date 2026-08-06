package com.bytedance.memory.shrink;

/* loaded from: classes4.dex */
public class HeapClassDump {
    public HprofID classLoaderId;
    public HprofID id;
    public HprofField[] instanceFields;
    public int instanceSize;
    public int stackSerialNumber;
    public HprofField[] staticFields;
    public HprofID superClassId;

    public HeapClassDump(HprofID hprofID, int i, HprofID hprofID2, HprofID hprofID3, int i2, HprofField[] hprofFieldArr, HprofField[] hprofFieldArr2) {
        this.id = hprofID;
        this.stackSerialNumber = i;
        this.superClassId = hprofID2;
        this.classLoaderId = hprofID3;
        this.instanceSize = i2;
        this.staticFields = hprofFieldArr;
        this.instanceFields = hprofFieldArr2;
    }
}
