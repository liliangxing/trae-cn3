package io.noties.markwon.ext.tables;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes7.dex */
public class TableAwareMovementMethod implements MovementMethod {
    private final MovementMethod wrapped;

    public static TableAwareMovementMethod wrap(MovementMethod movementMethod) {
        return new TableAwareMovementMethod(movementMethod);
    }

    public static TableAwareMovementMethod create() {
        return new TableAwareMovementMethod(LinkMovementMethod.getInstance());
    }

    public static boolean handleTableRowTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        ClickableSpan[] clickableSpanArr;
        if (motionEvent.getAction() != 1) {
            return false;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int totalPaddingLeft = x - textView.getTotalPaddingLeft();
        int totalPaddingTop = y - textView.getTotalPaddingTop();
        int scrollX = totalPaddingLeft + textView.getScrollX();
        int scrollY = totalPaddingTop + textView.getScrollY();
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
        AbsTableRowSpan[] absTableRowSpanArr = (AbsTableRowSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, AbsTableRowSpan.class);
        if (absTableRowSpanArr.length == 0 || (clickableSpanArr = (ClickableSpan[]) absTableRowSpanArr[0].findSpanInTable(scrollX, scrollY - layout.getLineTop(lineForVertical), ClickableSpan.class)) == null || clickableSpanArr.length <= 0) {
            return false;
        }
        clickableSpanArr[0].onClick(textView);
        return true;
    }

    public TableAwareMovementMethod(MovementMethod movementMethod) {
        this.wrapped = movementMethod;
    }

    @Override // android.text.method.MovementMethod
    public void initialize(TextView textView, Spannable spannable) {
        this.wrapped.initialize(textView, spannable);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyDown(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return this.wrapped.onKeyDown(textView, spannable, i, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyUp(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        return this.wrapped.onKeyUp(textView, spannable, i, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onKeyOther(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        return this.wrapped.onKeyOther(textView, spannable, keyEvent);
    }

    @Override // android.text.method.MovementMethod
    public void onTakeFocus(TextView textView, Spannable spannable, int i) {
        this.wrapped.onTakeFocus(textView, spannable, i);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTrackballEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.wrapped.onTrackballEvent(textView, spannable, motionEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.wrapped.onTouchEvent(textView, spannable, motionEvent) || handleTableRowTouchEvent(textView, spannable, motionEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean onGenericMotionEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return this.wrapped.onGenericMotionEvent(textView, spannable, motionEvent);
    }

    @Override // android.text.method.MovementMethod
    public boolean canSelectArbitrarily() {
        return this.wrapped.canSelectArbitrarily();
    }
}
