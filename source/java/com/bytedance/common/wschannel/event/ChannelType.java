package com.bytedance.common.wschannel.event;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public enum ChannelType {
    CHANNEL_SELF(1),
    CHANNEL_OK(2);

    int mTypeValue;

    ChannelType(int i) {
        this.mTypeValue = i;
    }

    public static ChannelType of(int i) {
        if (i == 1) {
            return CHANNEL_SELF;
        }
        return CHANNEL_OK;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "ChannelType{Type=" + this.mTypeValue + AbstractJsonLexerKt.END_OBJ;
    }

    public int getVal() {
        return this.mTypeValue;
    }
}
