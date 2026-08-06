package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [S] */
/* compiled from: Transition.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransitionKt$animateValue$animationSpec$1$1<S> implements Function0<Transition.Segment<S>> {
    final /* synthetic */ Transition<S> $this_animateValue;

    public TransitionKt$animateValue$animationSpec$1$1(Transition<S> transition) {
        this.$this_animateValue = transition;
    }

    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Transition.Segment<S> m343invoke() {
        return this.$this_animateValue.getSegment();
    }
}
