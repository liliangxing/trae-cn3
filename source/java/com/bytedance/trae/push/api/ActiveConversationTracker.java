package com.bytedance.trae.push.api;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

/* compiled from: ActiveConversationTracker.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/push/api/ActiveConversationTracker;", "", "<init>", "()V", "activeConversationId", "Ljava/util/concurrent/atomic/AtomicReference;", "", "setActiveConversationId", "", "conversationId", "getActiveConversationId", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ActiveConversationTracker {
    public static final ActiveConversationTracker INSTANCE = new ActiveConversationTracker();
    private static final AtomicReference<String> activeConversationId = new AtomicReference<>(null);

    private ActiveConversationTracker() {
    }

    public final void setActiveConversationId(String conversationId) {
        activeConversationId.set(conversationId);
    }

    public final String getActiveConversationId() {
        return activeConversationId.get();
    }
}
