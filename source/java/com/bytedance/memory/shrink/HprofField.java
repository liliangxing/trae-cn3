package com.bytedance.memory.shrink;

/* loaded from: classes4.dex */
public final class HprofField {
    public final HprofID mNameId;
    public final Object mStaticValue;
    public final int mTypeId;

    public HprofField(int i, HprofID hprofID, Object obj) {
        this.mTypeId = i;
        this.mNameId = hprofID;
        this.mStaticValue = obj;
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HprofField)) {
            return false;
        }
        HprofField hprofField = (HprofField) obj;
        if (this.mTypeId != hprofField.mTypeId || !this.mNameId.equals(hprofField.mNameId)) {
            return false;
        }
        Object obj3 = this.mStaticValue;
        return (obj3 == null || obj3.equals(hprofField.mStaticValue)) && ((obj2 = hprofField.mStaticValue) == null || obj2.equals(this.mStaticValue));
    }

    public int hashCode() {
        return (this.mNameId.hashCode() << 31) + this.mTypeId;
    }
}
