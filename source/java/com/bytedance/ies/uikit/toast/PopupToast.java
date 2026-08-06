package com.bytedance.ies.uikit.toast;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ugc.uikit.R;

/* loaded from: classes4.dex */
public class PopupToast {
    boolean mDestroyed;
    final Handler mHandler;
    private boolean mHideSystemUI;
    final Runnable mHideToastTask;
    ImageView mIcon;
    boolean mPaused;
    Dialog mPopup;
    TextView mText;
    View mView;

    public PopupToast(Context context, int i, int i2, int i3) {
        this.mDestroyed = false;
        this.mPaused = false;
        this.mHandler = new Handler();
        this.mHideToastTask = new Runnable() { // from class: com.bytedance.ies.uikit.toast.PopupToast.1
            @Override // java.lang.Runnable
            public void run() {
                PopupToast.this.hidePopupToast();
            }
        };
        LayoutInflater from = LayoutInflater.from(context);
        this.mPopup = new Dialog(context, R.style.popuptoast_dialog);
        try {
            View inflate = from.inflate(R.layout.popup_toast, (ViewGroup) null);
            this.mView = inflate;
            this.mIcon = (ImageView) inflate.findViewById(R.id.icon);
            this.mText = (TextView) inflate.findViewById(R.id.text);
            this.mPopup.setContentView(this.mView);
            this.mPopup.getWindow().addFlags(8);
            this.mPopup.getWindow().addFlags(32);
            this.mPopup.getWindow().addFlags(16);
            this.mPopup.getWindow().setLayout(i, i2);
            this.mPopup.getWindow().setGravity(i3);
        } catch (Throwable unused) {
        }
    }

    public PopupToast(Context context) {
        this(context, -1, -2, 17);
    }

    private void hideSystemUI() {
        this.mPopup.getWindow().getDecorView().setSystemUiVisibility(5380);
    }

    public void showToast(String str) {
        showToast(null, 0, 0, str, 2000, 48);
    }

    public void showToast(String str, int i) {
        showToast(null, 0, 0, str, 2000, i);
    }

    public void showToast(String str, int i, int i2) {
        showToast(null, 0, 0, str, i, i2);
    }

    public void showLongToast(String str) {
        showToast(null, 0, 0, str, 3500, 17);
    }

    public void showLongToast(String str, int i) {
        showToast(null, 0, 0, str, 3500, i);
    }

    public void showLongToast(int i, String str) {
        showToast(null, i, 0, str, 3500, 17);
    }

    public void showToast(int i, String str) {
        showToast(null, i, 0, str, 2000, 17);
    }

    public void showToast(int i, String str, int i2) {
        showToast(null, i, 0, str, i2, 17);
    }

    public void showToast(int i, String str, int i2, int i3) {
        showToast(null, i, 0, str, i2, i3);
    }

    public void showToast(View view, int i, int i2) {
        showToast(view, i, i2, null, 1500, 17);
    }

    public void showToast(View view, int i, String str) {
        showToast(view, i, 0, str, 1500, 17);
    }

    private void showToast(View view, int i, int i2, String str, int i3, int i4) {
        if (this.mDestroyed || i3 <= 0) {
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (i > 0) {
            this.mIcon.setImageResource(i);
            this.mIcon.setVisibility(0);
            z = true;
        } else {
            this.mIcon.setVisibility(8);
        }
        if (i2 > 0) {
            this.mText.setText(i2);
        } else if (StringUtils.isEmpty(str)) {
            z2 = z;
        } else {
            this.mText.setText(str);
        }
        if (z2) {
            this.mHandler.removeCallbacks(this.mHideToastTask);
            hidePopupToast();
            try {
                this.mPopup.getWindow().setGravity(i4);
                if (this.mHideSystemUI) {
                    hideSystemUI();
                }
                this.mPopup.show();
                this.mHandler.postDelayed(this.mHideToastTask, i3);
            } catch (Exception unused) {
            }
        }
    }

    public void onDestroy() {
        if (this.mDestroyed || this.mPaused) {
            return;
        }
        this.mHandler.removeCallbacks(this.mHideToastTask);
        hidePopupToast();
        this.mDestroyed = true;
    }

    public void onPause() {
        if (this.mDestroyed || this.mPaused) {
            return;
        }
        this.mHandler.removeCallbacks(this.mHideToastTask);
        hidePopupToast();
        this.mPaused = true;
    }

    public void onResume() {
        this.mPaused = false;
    }

    public void hidePopupToast() {
        if (this.mDestroyed) {
            return;
        }
        try {
            if (this.mPopup.isShowing()) {
                this.mPopup.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isHideSystemUI() {
        return this.mHideSystemUI;
    }

    public void hideSystemUI(boolean z) {
        this.mHideSystemUI = z;
    }
}
