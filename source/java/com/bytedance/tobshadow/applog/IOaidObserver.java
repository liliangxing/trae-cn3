package com.bytedance.tobshadow.applog;

/* loaded from: classes5.dex */
public interface IOaidObserver {

    /* loaded from: classes5.dex */
    public static final class Oaid {
        public final String id;

        public Oaid(String str) {
            this.id = str;
        }
    }

    void onOaidLoaded(Oaid oaid);
}
