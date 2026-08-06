package com.bytedance.trae.conversation.chat.error;

import com.bytedance.trae.conversation.R;
import kotlin.Metadata;

/* compiled from: AgentErrorCodeRegistry.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorDisplayPolicy;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;", "code", "", "creditsFeatureEnabled", "", "(Ljava/lang/Integer;Z)Lcom/bytedance/trae/conversation/chat/error/TocCreditsErrorOverride;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TocCreditsErrorDisplayPolicy {
    public static final TocCreditsErrorDisplayPolicy INSTANCE = new TocCreditsErrorDisplayPolicy();

    private TocCreditsErrorDisplayPolicy() {
    }

    public final TocCreditsErrorOverride resolve(Integer code, boolean creditsFeatureEnabled) {
        if (creditsFeatureEnabled && code != null && code.intValue() == 4008) {
            return new TocCreditsErrorOverride(R.string.trae_credits_exhausted, R.string.trae_credits_exhausted_title, AgentErrorLevel.WARN, true);
        }
        return null;
    }
}
