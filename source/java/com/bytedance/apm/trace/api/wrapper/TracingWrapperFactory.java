package com.bytedance.apm.trace.api.wrapper;

import com.bytedance.apm.trace.api.TracingContext;
import com.bytedance.apm.trace.api.TracingMode;
import com.bytedance.apm.trace.model.wrapper.ParallelTracingWrapper;
import com.bytedance.apm.trace.model.wrapper.SerialTracingWrapper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TracingWrapperFactory {
    public static ITracingWrapper create(String str, TracingMode tracingMode, TracingWrapperMode tracingWrapperMode) {
        return create(str, tracingMode, tracingWrapperMode, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.apm.trace.api.wrapper.TracingWrapperFactory$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static /* synthetic */ class C02961 {

        /* renamed from: $SwitchMap$com$bytedance$apm$trace$api$wrapper$TracingWrapperMode */
        static final /* synthetic */ int[] f42x63125510;

        static {
            int[] iArr = new int[TracingWrapperMode.values().length];
            f42x63125510 = iArr;
            try {
                iArr[TracingWrapperMode.PARALLEL_WRAPPER_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42x63125510[TracingWrapperMode.SERIAL_WRAPPER_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static ITracingWrapper create(String str, TracingMode tracingMode, TracingWrapperMode tracingWrapperMode, boolean z) {
        int i = C02961.f42x63125510[tracingWrapperMode.ordinal()];
        if (i == 1) {
            return new ParallelTracingWrapper(new TracingContext(str, tracingMode, z));
        }
        if (i != 2) {
            return null;
        }
        return new SerialTracingWrapper(new TracingContext(str, tracingMode, z));
    }
}
