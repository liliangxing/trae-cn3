package com.bytedance.android.livesdk.pannel;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetSlideProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetPullUpProcessor;", "", "disableNestedChildScroll", "", "enablePullUp", "enableToFull", "enableToHalf", "inIgnoreArea", "event", "Landroid/view/MotionEvent;", "isWebViewReachTop", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface SheetPullUpProcessor {

    /* compiled from: SheetSlideProcessor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static boolean disableNestedChildScroll(SheetPullUpProcessor sheetPullUpProcessor) {
            return false;
        }

        public static boolean enableToFull(SheetPullUpProcessor sheetPullUpProcessor) {
            return true;
        }

        public static boolean enableToHalf(SheetPullUpProcessor sheetPullUpProcessor) {
            return true;
        }

        public static boolean inIgnoreArea(SheetPullUpProcessor sheetPullUpProcessor, MotionEvent event) {
            Intrinsics.checkParameterIsNotNull(event, "event");
            return false;
        }

        public static boolean isWebViewReachTop(SheetPullUpProcessor sheetPullUpProcessor) {
            return true;
        }
    }

    boolean disableNestedChildScroll();

    boolean enablePullUp();

    boolean enableToFull();

    boolean enableToHalf();

    boolean inIgnoreArea(MotionEvent event);

    boolean isWebViewReachTop();
}
