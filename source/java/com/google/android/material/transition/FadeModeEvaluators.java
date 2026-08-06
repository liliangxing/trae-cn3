package com.google.android.material.transition;

import com.facebook.imageutils.JfifUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class FadeModeEvaluators {

    /* renamed from: IN */
    private static final FadeModeEvaluator f403IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.endOnTop(JfifUtil.MARKER_FIRST_BYTE, TransitionUtils.lerp(0, JfifUtil.MARKER_FIRST_BYTE, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(JfifUtil.MARKER_FIRST_BYTE, 0, f2, f3, f), JfifUtil.MARKER_FIRST_BYTE);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(JfifUtil.MARKER_FIRST_BYTE, 0, f2, f3, f), TransitionUtils.lerp(0, JfifUtil.MARKER_FIRST_BYTE, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            float f5 = ((f3 - f2) * f4) + f2;
            return FadeModeResult.startOnTop(TransitionUtils.lerp(JfifUtil.MARKER_FIRST_BYTE, 0, f2, f5, f), TransitionUtils.lerp(0, JfifUtil.MARKER_FIRST_BYTE, f5, f3, f));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeEvaluator get(int i, boolean z) {
        if (i == 0) {
            return z ? f403IN : OUT;
        }
        if (i == 1) {
            return z ? OUT : f403IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i);
    }

    private FadeModeEvaluators() {
    }
}
