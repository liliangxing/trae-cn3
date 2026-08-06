package com.lynx.tasm.behavior.p000ui.text;

import android.graphics.PointF;
import android.text.Layout;
import android.text.Spanned;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.text.EventTargetSpan;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UITextUtils {
    public static Spanned getSpanned(AndroidText androidText) {
        if (androidText != null && (androidText.getText() instanceof Spanned)) {
            return (Spanned) androidText.getText();
        }
        return null;
    }

    public static Spanned getSpanned(Layout layout) {
        if (layout != null && (layout.getText() instanceof Spanned)) {
            return (Spanned) layout.getText();
        }
        return null;
    }

    public static EventTarget hitTest(LynxBaseUI lynxBaseUI, float f, float f2, EventTarget eventTarget, Layout layout, Spanned spanned, PointF pointF, boolean z) {
        if (layout != null && f <= layout.getWidth() && f2 <= layout.getHeight()) {
            int lineForVertical = layout.getLineForVertical((int) f2);
            int paragraphDirection = layout.getParagraphDirection(lineForVertical);
            float f3 = f - pointF.x;
            float f4 = f2 - pointF.y;
            if (f4 <= layout.getLineBottom(lineForVertical) && f4 >= layout.getLineTop(lineForVertical) && f3 >= layout.getLineLeft(lineForVertical) && f3 <= layout.getLineRight(lineForVertical)) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f3);
                float primaryHorizontal = layout.getPrimaryHorizontal(offsetForHorizontal);
                if (paragraphDirection != 1 ? f3 >= primaryHorizontal : f3 < primaryHorizontal) {
                    offsetForHorizontal--;
                }
                EventTargetSpan[] eventTargetSpanArr = spanned != null ? (EventTargetSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, EventTargetSpan.class) : null;
                if (eventTargetSpanArr != null && eventTargetSpanArr.length != 0) {
                    int length = spanned.length();
                    int length2 = eventTargetSpanArr.length;
                    int i = 0;
                    EventTarget eventTarget2 = eventTarget;
                    int i2 = 0;
                    while (i < length2) {
                        EventTargetSpan eventTargetSpan = eventTargetSpanArr[i];
                        eventTargetSpan.setParent(eventTarget);
                        int spanStart = spanned.getSpanStart(eventTargetSpan);
                        int spanEnd = spanned.getSpanEnd(eventTargetSpan);
                        if (offsetForHorizontal >= spanStart && offsetForHorizontal <= spanEnd && spanStart >= i2 && spanEnd <= length) {
                            eventTargetSpan.setParent(eventTarget);
                            eventTarget2 = eventTargetSpan;
                        }
                        i++;
                        i2 = spanStart;
                        length = spanEnd;
                    }
                    if (eventTarget2 instanceof NativeLayoutNodeRef.InlineViewEventSpan) {
                        for (LynxBaseUI lynxBaseUI2 : lynxBaseUI.getChildren()) {
                            if (lynxBaseUI2.getSign() == eventTarget2.getSign()) {
                                return lynxBaseUI2.hitTest(f - lynxBaseUI2.getOriginLeft(), f2 - lynxBaseUI2.getOriginTop(), z);
                            }
                        }
                    }
                    return eventTarget2;
                }
            }
        }
        return eventTarget;
    }

    public static void HandleInlineViewTruncated(TextUpdateBundle textUpdateBundle, LynxBaseUI lynxBaseUI) {
        Set viewTruncatedSet = textUpdateBundle.getViewTruncatedSet();
        for (LynxBaseUI lynxBaseUI2 : lynxBaseUI.getChildren()) {
            if (lynxBaseUI2 instanceof LynxUI) {
                LynxUI lynxUI = (LynxUI) lynxBaseUI2;
                boolean z = viewTruncatedSet != null && viewTruncatedSet.contains(Integer.valueOf(lynxUI.getSign()));
                if (z && lynxUI.getVisibility()) {
                    lynxUI.setVisibilityForView(4);
                } else if (!z && !lynxUI.getVisibility()) {
                    lynxUI.setVisibilityForView(0);
                }
            }
        }
    }
}
