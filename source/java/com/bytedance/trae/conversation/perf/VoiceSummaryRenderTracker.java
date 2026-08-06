package com.bytedance.trae.conversation.perf;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceSummaryRenderTracker.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/perf/VoiceSummaryRenderTracker;", "", "<init>", "()V", "trackingId", "", "value", "", "firstCharOnScreenMs", "getFirstCharOnScreenMs", "()J", "lastCharOnScreenMs", "getLastCharOnScreenMs", "onLastCharOnScreen", "Lkotlin/Function0;", "", "start", "id", "stop", "markFirstChar", "markLastChar", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceSummaryRenderTracker {
    public static final VoiceSummaryRenderTracker INSTANCE = new VoiceSummaryRenderTracker();
    private static volatile long firstCharOnScreenMs;
    private static volatile long lastCharOnScreenMs;
    private static volatile Function0<Unit> onLastCharOnScreen;
    private static volatile String trackingId;

    private VoiceSummaryRenderTracker() {
    }

    public final long getFirstCharOnScreenMs() {
        return firstCharOnScreenMs;
    }

    public final long getLastCharOnScreenMs() {
        return lastCharOnScreenMs;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void start$default(VoiceSummaryRenderTracker voiceSummaryRenderTracker, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        voiceSummaryRenderTracker.start(str, function0);
    }

    public final void start(String id, Function0<Unit> onLastCharOnScreen2) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (id.length() == 0) {
            return;
        }
        trackingId = id;
        firstCharOnScreenMs = 0L;
        lastCharOnScreenMs = 0L;
        onLastCharOnScreen = onLastCharOnScreen2;
    }

    public final void stop() {
        trackingId = null;
        firstCharOnScreenMs = 0L;
        lastCharOnScreenMs = 0L;
        onLastCharOnScreen = null;
    }

    public final void markFirstChar(String id) {
        if (id != null && Intrinsics.areEqual(id, trackingId) && firstCharOnScreenMs == 0) {
            firstCharOnScreenMs = System.currentTimeMillis();
        }
    }

    public final void markLastChar(String id) {
        Function0<Unit> function0;
        if (id == null || !Intrinsics.areEqual(id, trackingId)) {
            return;
        }
        boolean z = lastCharOnScreenMs == 0;
        lastCharOnScreenMs = System.currentTimeMillis();
        if (!z || (function0 = onLastCharOnScreen) == null) {
            return;
        }
        function0.invoke();
    }
}
