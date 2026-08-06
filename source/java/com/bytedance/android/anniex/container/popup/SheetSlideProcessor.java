package com.bytedance.android.anniex.container.popup;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetSlideProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetSlideProcessor;", "", "disableDragDown", "", "inIndicatorArea", "event", "Landroid/view/MotionEvent;", "shouldInterceptSlide", "touchY", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface SheetSlideProcessor {

    /* compiled from: SheetSlideProcessor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean inIndicatorArea(SheetSlideProcessor sheetSlideProcessor, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }

        public static boolean shouldInterceptSlide(SheetSlideProcessor sheetSlideProcessor, int i) {
            return true;
        }
    }

    boolean disableDragDown();

    boolean inIndicatorArea(MotionEvent event);

    boolean shouldInterceptSlide(int touchY);
}
