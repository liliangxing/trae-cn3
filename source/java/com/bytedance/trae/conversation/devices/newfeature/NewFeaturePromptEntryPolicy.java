package com.bytedance.trae.conversation.devices.newfeature;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntryPolicy;", "", "<init>", "()V", "canRequestNaturalPrompt", "", "entry", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptEntry;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewFeaturePromptEntryPolicy {
    public static final NewFeaturePromptEntryPolicy INSTANCE = new NewFeaturePromptEntryPolicy();

    private NewFeaturePromptEntryPolicy() {
    }

    public final boolean canRequestNaturalPrompt(NewFeaturePromptEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return entry == NewFeaturePromptEntry.NEW_CHAT;
    }
}
