package com.bytedance.trae.conversation.upgrade;

import com.bytedance.trae.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UpgradeReminderDismissStore.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/upgrade/UpgradeReminderDismissStore;", "", "<init>", "()V", "PREF", "", "isDismissed", "", "conversationId", "markDismissed", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UpgradeReminderDismissStore {
    public static final UpgradeReminderDismissStore INSTANCE = new UpgradeReminderDismissStore();
    private static final String PREF = "upgrade_reminder_dismissed";

    private UpgradeReminderDismissStore() {
    }

    public final boolean isDismissed(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        if (StringsKt.isBlank(conversationId)) {
            return false;
        }
        return AppHost.INSTANCE.getApplication().getSharedPreferences(PREF, 0).getBoolean(conversationId, false);
    }

    public final void markDismissed(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        if (StringsKt.isBlank(conversationId)) {
            return;
        }
        AppHost.INSTANCE.getApplication().getSharedPreferences(PREF, 0).edit().putBoolean(conversationId, true).apply();
    }
}
