package com.bytedance.perf.monitor;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class AnrEntry implements Comparable<AnrEntry> {
    public String stack;
    public long stackCost;
    public long startMs;

    public AnrEntry(String str, long j, long j2) {
        this.stack = str;
        this.startMs = j;
        this.stackCost = j2;
    }

    public String toString() {
        return "AnrEntry{stack='" + this.stack + "', startMs=" + this.startMs + ", stackCost=" + this.stackCost + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // java.lang.Comparable
    public int compareTo(AnrEntry anrEntry) {
        long j = this.stackCost;
        long j2 = anrEntry.stackCost;
        if (j > j2) {
            return -1;
        }
        return j < j2 ? 1 : 0;
    }
}
