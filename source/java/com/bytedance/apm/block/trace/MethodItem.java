package com.bytedance.apm.block.trace;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class MethodItem {
    public int count = 1;
    public int depth;
    public int durTime;
    public int methodId;
    public long startTime;

    public MethodItem(int i, int i2, long j, int i3) {
        this.methodId = i;
        this.durTime = i2;
        this.depth = i3;
        this.startTime = j;
    }

    public String toString() {
        return this.depth + "," + this.methodId + "," + this.count + "," + this.durTime + "," + this.startTime;
    }

    public String toPrettyString() {
        return "{methodId=" + this.methodId + ", durTime=" + this.durTime + ", startTime=" + this.startTime + ", depth=" + this.depth + ", count=" + this.count + AbstractJsonLexerKt.END_OBJ;
    }

    public String getKey() {
        return this.depth + "," + this.methodId + "," + this.count;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MethodItem)) {
            return false;
        }
        MethodItem methodItem = (MethodItem) obj;
        return methodItem.methodId == this.methodId && methodItem.depth == this.depth;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void mergeMore(long j) {
        this.count++;
        this.durTime = (int) (this.durTime + j);
    }

    public String print() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < this.depth; i++) {
            stringBuffer.append('.');
        }
        return stringBuffer.toString() + this.methodId + " " + this.count + " " + this.durTime;
    }
}
