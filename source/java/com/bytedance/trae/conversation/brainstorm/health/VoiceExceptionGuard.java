package com.bytedance.trae.conversation.brainstorm.health;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.trae.conversation.brainstorm.health.VoicePrompt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceExceptionGuard.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\r\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoiceExceptionGuard;", "", "<init>", "()V", "checkAndToast", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "container", "Landroid/view/ViewGroup;", "trigger", "Lcom/bytedance/trae/conversation/brainstorm/health/VoiceCheckTrigger;", "checkOnly", "ctx", "Landroid/content/Context;", "resetThrottle", "", "resetThrottle$conversation_mainlandRelease", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceExceptionGuard {
    public static final VoiceExceptionGuard INSTANCE = new VoiceExceptionGuard();

    private VoiceExceptionGuard() {
    }

    public final VoicePrompt.Health checkAndToast(ViewGroup container, VoiceCheckTrigger trigger) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        Context context = container.getContext();
        Intrinsics.checkNotNull(context);
        VoicePrompt.Health checkPreflight = new VoiceHealthMonitor(context).checkPreflight(trigger);
        if (checkPreflight == null) {
            return null;
        }
        VoicePromptCenter.INSTANCE.enqueue(container, checkPreflight);
        return checkPreflight;
    }

    public final VoicePrompt.Health checkOnly(Context ctx, VoiceCheckTrigger trigger) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        return new VoiceHealthMonitor(ctx).checkPreflight(trigger);
    }

    public final void resetThrottle$conversation_mainlandRelease() {
        VoicePromptCenter.INSTANCE.resetThrottle$conversation_mainlandRelease();
    }
}
