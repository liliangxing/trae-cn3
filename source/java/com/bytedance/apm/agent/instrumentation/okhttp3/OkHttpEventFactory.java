package com.bytedance.apm.agent.instrumentation.okhttp3;

import okhttp3.Call;
import okhttp3.EventListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class OkHttpEventFactory implements EventListener.Factory {
    public EventListener.Factory originFactory;

    public OkHttpEventFactory(EventListener.Factory factory) {
        this.originFactory = factory;
    }

    public EventListener create(Call call) {
        EventListener.Factory factory = this.originFactory;
        return new OkHttpEventListener(factory != null ? factory.create(call) : null);
    }
}
