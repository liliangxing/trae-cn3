package com.ss.ttm.player.UnifiedCodec.reuse;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public final class ReusePolicy {
    public static final ReusePolicy DEFAULT = new ReusePolicy(1920, 1920);
    public static final int DEFAULT_INIT_HEIGHT = 1920;
    public static final int DEFAULT_INIT_WIDTH = 1920;
    public int mInitHeight;
    public int mInitWidth;
    public RemoveType mRemoveType = RemoveType.FIRST;
    public boolean mConfigUseInitFormat = true;

    /* loaded from: classes7.dex */
    public enum RemoveType {
        FIRST,
        SAME
    }

    public ReusePolicy(int initWidth, int initHeight) {
        this.mInitWidth = initWidth;
        this.mInitHeight = initHeight;
    }

    public String toString() {
        return "[initWidth:" + this.mInitWidth + ", initHeight:" + this.mInitHeight + ", reConfigByRealFormat:" + this.mConfigUseInitFormat + AbstractJsonLexerKt.END_LIST;
    }
}
