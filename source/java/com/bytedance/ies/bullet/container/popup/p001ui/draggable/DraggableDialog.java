package com.bytedance.ies.bullet.container.popup.p001ui.draggable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.anniex.R;
import com.bytedance.ies.bullet.container.popup.p001ui.draggable.BottomSheetBehavior;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupDialog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DraggableDialog extends AbsPopupDialog {
    private BottomSheetBehavior<FrameLayout> behavior;
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;

    public DraggableDialog(Context context) {
        super(context, R.style.Dialog_Immersive_NoAnim);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog.4
            @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }

            @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i) {
                if (i == 5) {
                    DraggableDialog.this.cancel();
                }
            }
        };
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupDialog
    public void setContentView(int i) {
        super.setContentView(wrapInBottomSheet(i, null, null));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupDialog
    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupDialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.cancelable != z) {
            this.cancelable = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior == null || bottomSheetBehavior.getState() != 5) {
            return;
        }
        this.behavior.setState(4);
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z;
        this.canceledOnTouchOutsideSet = true;
    }

    private View wrapInBottomSheet(int i, View view, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.bullet_popup_dialog_bottom_sheet, null);
        CoordinatorLayout findViewById = frameLayout.findViewById(R.id.bullet_popup_bottom_sheet_coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) findViewById, false);
        }
        FrameLayout frameLayout2 = (FrameLayout) findViewById.findViewById(R.id.bullet_popup_bottom_sheet);
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
        this.behavior = from;
        from.addBottomSheetCallback(this.bottomSheetCallback);
        this.behavior.setHideable(this.cancelable);
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        findViewById.findViewById(R.id.bullet_popup_bottom_sheet_touch_outside).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (DraggableDialog.this.cancelable && DraggableDialog.this.isShowing() && DraggableDialog.this.shouldWindowCloseOnTouchOutside()) {
                    DraggableDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(frameLayout2, new AccessibilityDelegateCompat() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog.2
            public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                if (DraggableDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(PreloadV2Kt.M_MEM_SIZE);
                    accessibilityNodeInfoCompat.setDismissable(true);
                } else {
                    accessibilityNodeInfoCompat.setDismissable(false);
                }
            }

            public boolean performAccessibilityAction(View view2, int i2, Bundle bundle) {
                if (i2 == 1048576 && DraggableDialog.this.cancelable) {
                    DraggableDialog.this.cancel();
                    return true;
                }
                return super.performAccessibilityAction(view2, i2, bundle);
            }
        });
        frameLayout2.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggableDialog.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        return frameLayout;
    }

    boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    void setCloseByGesture(boolean z) {
        this.behavior.setHideable(z);
    }

    private static int getThemeResId(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(com.google.android.material.R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return com.google.android.material.R.style.Theme_Design_Light_BottomSheetDialog;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout;
        Boolean bool = false;
        if (getCallbackIfMaskCancel() != null) {
            bool = (Boolean) getCallbackIfMaskCancel().invoke();
        }
        setCanceledOnTouchOutside(bool.booleanValue());
        if (getClickThroughMask() && (frameLayout = (FrameLayout) findViewById(R.id.bullet_popup_bottom_sheet)) != null) {
            int[] iArr = {(int) frameLayout.getX(), (int) frameLayout.getY()};
            frameLayout.getLocationInWindow(iArr);
            int i = iArr[0];
            if (!new Rect(i, iArr[1], frameLayout.getWidth() + i, iArr[1] + frameLayout.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                getOwnerActivity().dispatchTouchEvent(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
