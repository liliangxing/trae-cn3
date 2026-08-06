package com.bytedance.timonbase.scene.silenceimpl;

import android.view.MotionEvent;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* compiled from: OnTouchListenerWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/timonbase/scene/silenceimpl/OnTouchListenerWrapper;", "Landroid/view/View$OnTouchListener;", "onTouchListener", "(Landroid/view/View$OnTouchListener;)V", "onTouch", "", BaseSwitches.V, "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class OnTouchListenerWrapper implements View.OnTouchListener {
    private final View.OnTouchListener onTouchListener;

    public OnTouchListenerWrapper(View.OnTouchListener onTouchListener) {
        this.onTouchListener = onTouchListener;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (event != null && event.getAction() == 0) {
            InputEventHappenRecordHolder.INSTANCE.touchEventHappen();
        }
        View.OnTouchListener onTouchListener = this.onTouchListener;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(v, event);
        }
        return false;
    }
}
