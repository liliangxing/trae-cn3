package com.bytedance.pia.core.api.monitor;

import com.bytedance.pia.core.api.context.IContainerContext;

/* loaded from: classes4.dex */
public interface IPiaTracer {
    public static final IPiaTracer EMPTY = new IPiaTracer() { // from class: com.bytedance.pia.core.api.monitor.IPiaTracer.1
        @Override // com.bytedance.pia.core.api.monitor.IPiaTracer
        public void report(String str, long j) {
        }

        @Override // com.bytedance.pia.core.api.monitor.IPiaTracer
        public void reportExtra(String str, Object obj) {
        }
    };

    void report(String str, long j);

    void reportExtra(String str, Object obj);

    static IPiaTracer get(Object obj) {
        IPiaTracer iPiaTracer = obj instanceof IContainerContext ? (IPiaTracer) ((IContainerContext) obj).get(IPiaTracer.class) : null;
        return iPiaTracer == null ? EMPTY : iPiaTracer;
    }
}
