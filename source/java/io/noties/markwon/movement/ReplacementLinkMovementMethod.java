package io.noties.markwon.movement;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.lynx.tasm.behavior.PropsConstants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacementLinkMovementMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lio/noties/markwon/movement/ReplacementLinkMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "()V", "downTime", "", "downX", "", "downY", "handlerTouchSpans", "", "Lio/noties/markwon/movement/IHandlerTouchSpan;", "[Lio/noties/markwon/movement/IHandlerTouchSpan;", "longPressTimeout", "", "touchSlop", "initialize", "", "widget", "Landroid/widget/TextView;", PropsConstants.TEXT, "Landroid/text/Spannable;", "onTouchEvent", "", "buffer", "event", "Landroid/view/MotionEvent;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ReplacementLinkMovementMethod extends LinkMovementMethod {
    private long downTime;
    private float downX;
    private float downY;
    private int touchSlop;
    private final int longPressTimeout = ViewConfiguration.getLongPressTimeout();
    private IHandlerTouchSpan[] handlerTouchSpans = new IHandlerTouchSpan[0];

    @Override // android.text.method.LinkMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public void initialize(TextView widget, Spannable text) {
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        super.initialize(widget, text);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(widget.getContext());
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(widget.context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(widget, "widget");
        Intrinsics.checkParameterIsNotNull(buffer, "buffer");
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event.getActionMasked() == 1 || event.getActionMasked() == 0 || event.getActionMasked() == 3) {
            float x = (event.getX() - widget.getTotalPaddingLeft()) + widget.getScrollX();
            float y = (event.getY() - widget.getTotalPaddingTop()) + widget.getScrollY();
            Layout layout = widget.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) y), x);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) buffer.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            if (event.getActionMasked() == 0) {
                this.downX = event.getX();
                this.downY = event.getY();
                this.downTime = System.currentTimeMillis();
                Object[] spans = buffer.getSpans(offsetForHorizontal, offsetForHorizontal, IHandlerTouchSpan.class);
                Intrinsics.checkExpressionValueIsNotNull(spans, "buffer.getSpans(off, off…lerTouchSpan::class.java)");
                IHandlerTouchSpan[] iHandlerTouchSpanArr = (IHandlerTouchSpan[]) spans;
                this.handlerTouchSpans = iHandlerTouchSpanArr;
                for (IHandlerTouchSpan iHandlerTouchSpan : iHandlerTouchSpanArr) {
                    iHandlerTouchSpan.onTouchDown(widget);
                }
                Intrinsics.checkExpressionValueIsNotNull(clickableSpanArr, "links");
                if (((clickableSpanArr.length == 0 ? 1 : 0) ^ 1) != 0) {
                    Selection.setSelection(buffer, buffer.getSpanStart(ArraysKt.first(clickableSpanArr)), buffer.getSpanEnd(ArraysKt.first(clickableSpanArr)));
                }
            } else {
                if (event.getActionMasked() == 1) {
                    for (IHandlerTouchSpan iHandlerTouchSpan2 : this.handlerTouchSpans) {
                        iHandlerTouchSpan2.onTouchUp(widget);
                    }
                    if (Math.abs(event.getX() - this.downX) < this.touchSlop && Math.abs(event.getY() - this.downY) < this.touchSlop && System.currentTimeMillis() - this.downTime < this.longPressTimeout) {
                        Intrinsics.checkExpressionValueIsNotNull(clickableSpanArr, "links");
                        if (!(clickableSpanArr.length == 0)) {
                            float primaryHorizontal = layout.getPrimaryHorizontal(offsetForHorizontal);
                            int length = clickableSpanArr.length;
                            while (r7 < length) {
                                ClickableSpan clickableSpan = clickableSpanArr[r7];
                                if (primaryHorizontal < x) {
                                    if (buffer.getSpanEnd(clickableSpan) > offsetForHorizontal) {
                                        clickableSpan.onClick(widget);
                                        return true;
                                    }
                                } else if (buffer.getSpanStart(clickableSpan) < offsetForHorizontal) {
                                    clickableSpan.onClick(widget);
                                    return true;
                                }
                                r7++;
                            }
                        }
                    }
                    Selection.removeSelection(buffer);
                    return Touch.onTouchEvent(widget, buffer, event);
                }
                IHandlerTouchSpan[] iHandlerTouchSpanArr2 = this.handlerTouchSpans;
                int length2 = iHandlerTouchSpanArr2.length;
                while (r7 < length2) {
                    iHandlerTouchSpanArr2[r7].onTouchCancel(widget);
                    r7++;
                }
            }
        }
        return Touch.onTouchEvent(widget, buffer, event);
    }
}
