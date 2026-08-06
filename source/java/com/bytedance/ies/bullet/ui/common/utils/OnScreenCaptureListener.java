package com.bytedance.ies.bullet.ui.common.utils;

import kotlin.Metadata;

/* compiled from: ScreenCaptureUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/OnScreenCaptureListener;", "", "onCapture", "", "responseType", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface OnScreenCaptureListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MATCH_DATE_ADDED_FAILED = 1;
    public static final int MATCH_PATH_FAILED = 2;
    public static final int SUCCESS = 0;

    void onCapture(int responseType);

    /* compiled from: ScreenCaptureUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/OnScreenCaptureListener$Companion;", "", "()V", "MATCH_DATE_ADDED_FAILED", "", "MATCH_PATH_FAILED", "SUCCESS", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MATCH_DATE_ADDED_FAILED = 1;
        public static final int MATCH_PATH_FAILED = 2;
        public static final int SUCCESS = 0;

        private Companion() {
        }
    }

    /* compiled from: ScreenCaptureUtils.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onCapture$default(OnScreenCaptureListener onScreenCaptureListener, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCapture");
            }
            if ((i2 & 1) != 0) {
                i = 0;
            }
            onScreenCaptureListener.onCapture(i);
        }
    }
}
