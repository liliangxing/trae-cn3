package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.im.service.FastRequestEventType;
import kotlin.Metadata;

/* compiled from: QueuingBannerView.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerPolicy;", "", "<init>", "()V", "shouldShowFastRequestAction", "", "eventType", "", "creditsFeatureEnabled", "(Ljava/lang/Integer;Z)Z", "shouldUseFastRequestPresentation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueuingBannerPolicy {
    public static final QueuingBannerPolicy INSTANCE = new QueuingBannerPolicy();

    public final boolean shouldUseFastRequestPresentation(boolean creditsFeatureEnabled) {
        return !creditsFeatureEnabled;
    }

    private QueuingBannerPolicy() {
    }

    public final boolean shouldShowFastRequestAction(Integer eventType, boolean creditsFeatureEnabled) {
        if (shouldUseFastRequestPresentation(creditsFeatureEnabled)) {
            int value = FastRequestEventType.HasQuotaCanUse.getValue();
            if (eventType != null && eventType.intValue() == value) {
                return true;
            }
        }
        return false;
    }
}
