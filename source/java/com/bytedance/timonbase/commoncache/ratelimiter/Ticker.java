package com.bytedance.timonbase.commoncache.ratelimiter;

/* loaded from: classes5.dex */
public abstract class Ticker {
    private static final Ticker SYSTEM_TICKER = new Ticker() { // from class: com.bytedance.timonbase.commoncache.ratelimiter.Ticker.1
        @Override // com.bytedance.timonbase.commoncache.ratelimiter.Ticker
        public long read() {
            return System.nanoTime();
        }
    };

    public abstract long read();

    protected Ticker() {
    }

    public static Ticker systemTicker() {
        return SYSTEM_TICKER;
    }
}
