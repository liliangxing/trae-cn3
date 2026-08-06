package com.bytedance.trae.conversation.brainstorm.health;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.bytedance.trae.common.widget.InlineToast;
import com.bytedance.trae.im.service.ChatEventPayload;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoicePromptCenter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\tH\u0007J\b\u0010\u0018\u001a\u00020\u0015H\u0007J\r\u0010\u0019\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001aJ\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePromptCenter;", "", "<init>", "()V", "DEFAULT_DURATION_MS", "", "FADE_TOTAL_MS", ChatEventPayload.Notification.TYPE_QUEUE, "Ljava/util/PriorityQueue;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;", "lastEmitAtByType", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "currentType", "mainHandler", "Landroid/os/Handler;", "latestContainer", "Landroid/view/ViewGroup;", "nextPromptRunnable", "Ljava/lang/Runnable;", "enqueue", "", "container", "prompt", "clearAll", "resetThrottle", "resetThrottle$conversation_mainlandRelease", "showNext", "shouldEmit", "", "recordEmit", "isAlreadyPending", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoicePromptCenter {
    private static final long DEFAULT_DURATION_MS = 2000;
    private static final long FADE_TOTAL_MS = 500;
    private static Class<?> currentType;
    private static ViewGroup latestContainer;
    private static Runnable nextPromptRunnable;
    public static final VoicePromptCenter INSTANCE = new VoicePromptCenter();
    private static final PriorityQueue<VoicePrompt> queue = new PriorityQueue<>(8, new Comparator() { // from class: com.bytedance.trae.conversation.brainstorm.health.VoicePromptCenter$special$$inlined$compareByDescending$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((VoicePrompt) t2).getPriority()), Integer.valueOf(((VoicePrompt) t).getPriority()));
        }
    });
    private static final ConcurrentHashMap<Class<?>, Long> lastEmitAtByType = new ConcurrentHashMap<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private VoicePromptCenter() {
    }

    public final void enqueue(ViewGroup container, VoicePrompt prompt) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        latestContainer = container;
        if (shouldEmit(prompt) && !isAlreadyPending(prompt)) {
            queue.offer(prompt);
            if (currentType == null) {
                showNext();
            }
        }
    }

    public final void clearAll() {
        queue.clear();
        currentType = null;
        latestContainer = null;
        Runnable runnable = nextPromptRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        nextPromptRunnable = null;
        InlineToast.INSTANCE.dismiss();
    }

    public final void resetThrottle$conversation_mainlandRelease() {
        lastEmitAtByType.clear();
    }

    private final void showNext() {
        ViewGroup viewGroup;
        VoicePrompt poll = queue.poll();
        if (poll == null || (viewGroup = latestContainer) == null) {
            return;
        }
        currentType = poll.getClass();
        recordEmit(poll);
        InlineToast inlineToast = InlineToast.INSTANCE;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        InlineToast.show$default(inlineToast, viewGroup, poll.text(context), poll.getIconRes(), 2000L, 0, null, 0, 112, null);
        Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.brainstorm.health.VoicePromptCenter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VoicePromptCenter.showNext$lambda$1();
            }
        };
        nextPromptRunnable = runnable;
        mainHandler.postDelayed(runnable, RtcLowAudioDetector.ASR_FALLBACK_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNext$lambda$1() {
        VoicePromptCenter voicePromptCenter = INSTANCE;
        currentType = null;
        nextPromptRunnable = null;
        voicePromptCenter.showNext();
    }

    private final boolean shouldEmit(VoicePrompt prompt) {
        long currentTimeMillis = System.currentTimeMillis();
        Long l = lastEmitAtByType.get(prompt.getClass());
        return currentTimeMillis - (l != null ? l.longValue() : 0L) >= prompt.getThrottleMs();
    }

    private final void recordEmit(VoicePrompt prompt) {
        lastEmitAtByType.put(prompt.getClass(), Long.valueOf(System.currentTimeMillis()));
    }

    private final boolean isAlreadyPending(VoicePrompt prompt) {
        if (Intrinsics.areEqual(currentType, prompt.getClass())) {
            return true;
        }
        PriorityQueue<VoicePrompt> priorityQueue = queue;
        if (!(priorityQueue instanceof Collection) || !priorityQueue.isEmpty()) {
            Iterator<T> it = priorityQueue.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((VoicePrompt) it.next()).getClass(), prompt.getClass())) {
                    return true;
                }
            }
        }
        return false;
    }
}
