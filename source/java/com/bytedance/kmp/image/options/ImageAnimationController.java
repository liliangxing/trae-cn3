package com.bytedance.kmp.image.options;

import kotlin.Metadata;

/* compiled from: AnimatedImageOptions.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageAnimationController;", "", "isRunning", "", "jumpToFrame", "", "frameIndex", "", "pause", "setRepeatCount", "count", "start", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ImageAnimationController {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int REPEAT_INFINITE = -1;

    boolean isRunning();

    void jumpToFrame(int frameIndex);

    void pause();

    void setRepeatCount(int count);

    void start();

    /* compiled from: AnimatedImageOptions.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/kmp/image/options/ImageAnimationController$Companion;", "", "()V", "REPEAT_INFINITE", "", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int REPEAT_INFINITE = -1;

        private Companion() {
        }
    }
}
