package com.bytedance.pia.core.bridge.methods;

import android.text.TextUtils;
import com.bytedance.pia.core.PiaContext;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TracingSet implements PiaMethod.ICall<Params, Void> {
    public static final String NAME = "pia.internal.tracing.set";
    public static final PiaMethod<Params, Void> METHOD = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.TracingSet$$ExternalSyntheticLambda0
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final Object create() {
            return new TracingSet();
        }
    });

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Event {

        @SerializedName("args")
        public Map<String, Object> args;

        @SerializedName("name")
        public String name;

        /* renamed from: ts */
        @SerializedName("ts")
        public Long f68ts;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {

        @SerializedName("events")
        public List<Event> events;
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge iPiaBridge, Params params, IConsumer<Void> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        PiaContext piaContext = (PiaContext) iPiaBridge.getContext();
        if (params.events != null) {
            for (Event event : params.events) {
                if (!TextUtils.isEmpty(event.name) && event.f68ts != null) {
                    piaContext.getOnlineTrace().addDuration(event.name, event.f68ts.longValue());
                }
            }
        }
        iConsumer.accept(null);
    }
}
