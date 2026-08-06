package com.bytedance.trae.conversation.brainstorm;

import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import kotlin.Metadata;

/* compiled from: VoiceDiscussionPhase2Policy.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/VoiceDiscussionPhase2Policy;", "", "<init>", "()V", "isAttachmentSubTaskEnabled", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VoiceDiscussionPhase2Policy {
    public static final VoiceDiscussionPhase2Policy INSTANCE = new VoiceDiscussionPhase2Policy();

    private VoiceDiscussionPhase2Policy() {
    }

    public final boolean isAttachmentSubTaskEnabled() {
        return FeatureCapability.INSTANCE.isEnabled(Feature.BRAINSTORM_V2);
    }
}
