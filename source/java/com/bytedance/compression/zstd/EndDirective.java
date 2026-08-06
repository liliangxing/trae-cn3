package com.bytedance.compression.zstd;

/* loaded from: classes3.dex */
public enum EndDirective {
    CONTINUE(0),
    FLUSH(1),
    END(2);

    private final int value;

    EndDirective(int i) {
        this.value = i;
    }

    int value() {
        return this.value;
    }
}
