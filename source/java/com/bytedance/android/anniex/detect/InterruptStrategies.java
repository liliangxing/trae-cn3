package com.bytedance.android.anniex.detect;

import com.bytedance.android.anniex.detect.BlankCheckResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetectorConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/detect/InterruptStrategies;", "", "()V", "interruptOnHighConfidence", "Lkotlin/Function1;", "Lcom/bytedance/android/anniex/detect/BlankCheckResult;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class InterruptStrategies {
    public static final InterruptStrategies INSTANCE = new InterruptStrategies();

    private InterruptStrategies() {
    }

    public final Function1<BlankCheckResult, Boolean> interruptOnHighConfidence() {
        return new Function1<BlankCheckResult, Boolean>() { // from class: com.bytedance.android.anniex.detect.InterruptStrategies$interruptOnHighConfidence$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BlankCheckResult r) {
                Intrinsics.checkNotNullParameter(r, "r");
                boolean z = false;
                if (!(r instanceof BlankCheckResult.PartialWhite) && !(r instanceof BlankCheckResult.PureWhite) && (r instanceof BlankCheckResult.Error)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        };
    }
}
