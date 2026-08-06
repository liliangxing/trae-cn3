package com.bytedance.trae.kmp.p007ui;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* compiled from: KmpClickHandler.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"clickEpoch", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "monotonicNowMillis", "", "base_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpClickHandlerKt {
    private static final long clickEpoch = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();

    /* JADX INFO: Access modifiers changed from: private */
    public static final long monotonicNowMillis() {
        return Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(clickEpoch));
    }
}
