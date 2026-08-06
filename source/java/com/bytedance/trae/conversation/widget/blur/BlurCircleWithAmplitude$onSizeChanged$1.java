package com.bytedance.trae.conversation.widget.blur;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BlurCircleWithAmplitude.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
/* synthetic */ class BlurCircleWithAmplitude$onSizeChanged$1 extends FunctionReferenceImpl implements Function0<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BlurCircleWithAmplitude$onSizeChanged$1(Object obj) {
        super(0, obj, BlurCircleWithAmplitude.class, "getMaxAmplitude", "getMaxAmplitude()F", 0);
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Float m1578invoke() {
        float maxAmplitude;
        maxAmplitude = ((BlurCircleWithAmplitude) this.receiver).getMaxAmplitude();
        return Float.valueOf(maxAmplitude);
    }
}
