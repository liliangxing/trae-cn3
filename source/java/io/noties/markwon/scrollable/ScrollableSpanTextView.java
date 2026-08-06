package io.noties.markwon.scrollable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScrollableSpanTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/noties/markwon/scrollable/ScrollableSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowScrollVertical", "", "downOnScrollableArea", "lastX", "", "lastY", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "requestDisallowViewPager2Intercept", "", "disallow", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class ScrollableSpanTextView extends AppCompatTextView {
    private boolean allowScrollVertical;
    private boolean downOnScrollableArea;
    private float lastX;
    private float lastY;

    public ScrollableSpanTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ScrollableSpanTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ScrollableSpanTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableSpanTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev != null) {
            boolean z = false;
            if (ev.getActionMasked() == 0) {
                HorizontalScrollable[] horizontalScrollableArr = (HorizontalScrollable[]) HorizontalScrollableMovementMethod.INSTANCE.getTouchSpans(ev, this, HorizontalScrollable.class);
                if (horizontalScrollableArr != null) {
                    int length = horizontalScrollableArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if (horizontalScrollableArr[i].isScrollable()) {
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        this.downOnScrollableArea = true;
                    }
                }
            } else if (ev.getActionMasked() == 2) {
                float x = ev.getX() - this.lastX;
                float y = ev.getY() - this.lastY;
                if (!this.allowScrollVertical && this.downOnScrollableArea && Math.abs(y) > Math.abs(x)) {
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    requestDisallowViewPager2Intercept(true);
                    this.allowScrollVertical = true;
                }
            } else if (ev.getActionMasked() == 1) {
                ViewParent parent3 = getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(false);
                }
                this.downOnScrollableArea = false;
                this.allowScrollVertical = false;
            }
            this.lastX = ev.getX();
            this.lastY = ev.getY();
        }
        return super.dispatchTouchEvent(ev);
    }

    private final void requestDisallowViewPager2Intercept(boolean disallow) {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = ((ViewGroup) parent).getParent()) {
            if (parent instanceof HorizontalScrollParent) {
                parent.requestDisallowInterceptTouchEvent(disallow);
                return;
            }
        }
    }
}
