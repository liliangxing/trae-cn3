package com.bytedance.trae.conversation.tracker;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TocCreditsObservation.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/Credits4008ObservationGate;", "", "maxEntries", "", "<init>", "(I)V", "consumedKeys", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "tryAcquire", "", "sessionId", "messageId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class Credits4008ObservationGate {
    private final LinkedHashMap<String, Unit> consumedKeys;
    private final int maxEntries;

    public Credits4008ObservationGate(int i) {
        this.maxEntries = i;
        this.consumedKeys = new LinkedHashMap<>(i, 0.75f, true);
        if (!(i > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final synchronized boolean tryAcquire(String sessionId, String messageId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        if (!StringsKt.isBlank(sessionId) && !StringsKt.isBlank(messageId)) {
            String str = sessionId + (char) 0 + messageId + "\u00004008";
            if (this.consumedKeys.get(str) != null) {
                return false;
            }
            this.consumedKeys.put(str, Unit.INSTANCE);
            if (this.consumedKeys.size() > this.maxEntries) {
                Iterator<Map.Entry<String, Unit>> it = this.consumedKeys.entrySet().iterator();
                it.next();
                it.remove();
            }
            return true;
        }
        return true;
    }
}
