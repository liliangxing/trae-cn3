package com.bytedance.apm6.java_alloc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class DefaultTraceReader implements ITraceReader {
    private final ArrayList<StackTraceElement> result = new ArrayList<>();

    @Override // com.bytedance.apm6.java_alloc.ITraceReader
    public boolean onItem(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        String str = new String(bArr, 0, i, StandardCharsets.US_ASCII);
        String str2 = new String(bArr2, 0, i2, StandardCharsets.US_ASCII);
        int lastIndexOf = str.lastIndexOf(46);
        this.result.add(new StackTraceElement(str.substring(0, lastIndexOf), str.substring(lastIndexOf + 1, i), str2, i3));
        return true;
    }

    public void setTrace(Trace trace) {
        this.result.ensureCapacity(trace.getTraceLength());
    }

    public ArrayList<StackTraceElement> getResult() {
        return this.result;
    }

    public void clear() {
        this.result.clear();
    }
}
