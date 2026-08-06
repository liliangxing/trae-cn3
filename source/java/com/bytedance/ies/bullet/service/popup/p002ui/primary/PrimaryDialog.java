package com.bytedance.ies.bullet.service.popup.p002ui.primary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupDialog;
import com.bytedance.push.interfaze.ISignalReportService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimaryDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/ui/primary/PrimaryDialog;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "card", "Landroid/view/View;", "cardAreaWhenTouchDown", "Landroid/graphics/Rect;", "gestureDetector", "Landroid/view/GestureDetector;", "dispatchTouchEvent", "", ISignalReportService.BODY_KEY_EVENT, "Landroid/view/MotionEvent;", "getCardArea", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PrimaryDialog extends AbsPopupDialog {
    private View card;
    private volatile Rect cardAreaWhenTouchDown;
    private final GestureDetector gestureDetector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimaryDialog(Context context) {
        super(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
        this.cardAreaWhenTouchDown = new Rect();
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.ies.bullet.service.popup.ui.primary.PrimaryDialog$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Rect rect;
                Intrinsics.checkNotNullParameter(e, "e");
                rect = PrimaryDialog.this.cardAreaWhenTouchDown;
                if (!rect.contains((int) e.getRawX(), (int) e.getRawY()) && PrimaryDialog.this.getCallbackIfMaskCancel() != null) {
                    Function0<Boolean> callbackIfMaskCancel = PrimaryDialog.this.getCallbackIfMaskCancel();
                    if (callbackIfMaskCancel != null && ((Boolean) callbackIfMaskCancel.invoke()).booleanValue()) {
                        PrimaryDialog.this.dismiss();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        Activity ownerActivity;
        Intrinsics.checkNotNullParameter(event, ISignalReportService.BODY_KEY_EVENT);
        Rect cardArea = getCardArea();
        if (cardArea == null) {
            return super.dispatchTouchEvent(event);
        }
        if (event.getActionMasked() == 0) {
            this.cardAreaWhenTouchDown = cardArea;
        }
        if (!cardArea.contains((int) event.getRawX(), (int) event.getRawY()) && getClickThroughMask() && (ownerActivity = getOwnerActivity()) != null) {
            ownerActivity.dispatchTouchEvent(event);
        }
        return this.gestureDetector.onTouchEvent(event) || super.dispatchTouchEvent(event);
    }

    private final Rect getCardArea() {
        if (this.card == null) {
            this.card = findViewById(R.id.bullet_popup_round);
        }
        View view = this.card;
        if (view == null) {
            return null;
        }
        int[] iArr = {(int) view.getX(), (int) view.getY()};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
    }
}
