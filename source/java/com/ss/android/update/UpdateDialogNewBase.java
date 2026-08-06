package com.ss.android.update;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.lynx.tasm.behavior.PropsConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class UpdateDialogNewBase extends Dialog implements IUpdateMainDialog, WeakHandler.IHandler {
    private static final long DEFAULT_BG_DURATION = 100;
    private static final long DEFAULT_DISMISS_DURATION = 150;
    private static final long DEFAULT_SHOW_DURATION = 450;
    protected static final int MSG_UPDATE_PROGRESS = 1;
    protected static final int MSG_UPDATE_REFRESH = 2;
    private static final String TAG = "UpdateDialogNewBase";
    public static final String TYPE = "\n";
    protected boolean isClick;
    protected boolean isRepeat;
    protected boolean mAutoUpdate;
    protected TextView mBgAutoDownloadTextView;
    protected View mBgAutoDownloadView;
    protected TextView mBindAppHintTextView;
    protected View mBindAppView;
    protected ImageView mCancelBtn;
    protected LinearLayout mContentRoot;
    protected Context mContext;
    protected Handler mHandler;
    protected UpdateHelper mHelper;
    private DialogInterface.OnDismissListener mOnDismissListener;
    protected ProgressBar mProgressBar;
    protected LottieAnimationView mRocketView;
    private View mRootView;
    protected TextView mUpdateBtn;
    protected TextView mUpdateDownloading;
    protected TextView mUpdateTitle;
    protected TextView mUpdateVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDialogNewBase(Context context, boolean z) {
        super(context);
        this.mBgAutoDownloadView = null;
        this.mBgAutoDownloadTextView = null;
        this.isClick = false;
        this.mAutoUpdate = z;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDialogNewBase(Context context) {
        super(context);
        this.mBgAutoDownloadView = null;
        this.mBgAutoDownloadTextView = null;
        this.isClick = false;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0749R.layout.update_dialog_new_layout);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(C0749R.drawable.transparent);
            window.setLayout(-2, -2);
            window.setGravity(17);
            window.setWindowAnimations(C0749R.style.update_dialog_animation);
        }
        setCanceledOnTouchOutside(false);
        this.mHandler = new WeakHandler(this);
        this.mRootView = findViewById(C0749R.id.update_root);
        this.mUpdateBtn = (TextView) findViewById(C0749R.id.update_check_ok_btn);
        this.mCancelBtn = (ImageView) findViewById(C0749R.id.update_check_cancel_btn);
        this.mUpdateTitle = (TextView) findViewById(C0749R.id.update_title_txt);
        this.mUpdateVersion = (TextView) findViewById(C0749R.id.update_version_txt);
        this.mContentRoot = (LinearLayout) findViewById(C0749R.id.update_content_root);
        this.mRocketView = findViewById(C0749R.id.update_rocket_lottie);
        this.mUpdateDownloading = (TextView) findViewById(C0749R.id.update_download_text);
        this.mProgressBar = (ProgressBar) findViewById(C0749R.id.update_progress);
        this.mBindAppView = findViewById(C0749R.id.bind_app_view);
        this.mBindAppHintTextView = (TextView) findViewById(C0749R.id.hint_text);
        this.mBgAutoDownloadView = findViewById(C0749R.id.bg_auto_download_view);
        this.mBgAutoDownloadTextView = (TextView) findViewById(C0749R.id.bg_auto_download_text);
        UIUtils.setViewVisibility(this.mBgAutoDownloadView, 8);
        startAin();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initData() {
        this.mRocketView.setAnimation("upgrade.json");
        this.mRocketView.playAnimation();
        this.mRocketView.setRepeatCount(-1);
        this.mRocketView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ss.android.update.UpdateDialogNewBase.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (UpdateDialogNewBase.this.isRepeat || valueAnimator == null || valueAnimator.getAnimatedFraction() != 1.0f) {
                    return;
                }
                UpdateDialogNewBase.this.mRocketView.setMinProgress(0.33f);
                UpdateDialogNewBase.this.mRocketView.setMaxProgress(1.0f);
                UpdateDialogNewBase.this.mRocketView.setRepeatCount(-1);
                UpdateDialogNewBase.this.isRepeat = true;
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.UpdateDialogNewBase.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                UpdateDialogNewBase.this.mRocketView.cancelAnimation();
                if (UpdateDialogNewBase.this.mOnDismissListener != null) {
                    UpdateDialogNewBase.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Window window = getWindow();
        if (!z || window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (decorView.getHeight() == 0 || decorView.getWidth() == 0) {
            decorView.requestLayout();
            Logger.m152d(TAG, "重新布局");
        }
    }

    public void setDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void handleMsg(Message message) {
        int i = message.what;
        if (i == 1) {
            refreshProgress(message.arg1, message.arg2);
        } else {
            if (i != 2) {
                return;
            }
            initData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshProgress(int i, int i2) {
        UIUtils.setViewVisibility(this.mProgressBar, 0);
        UIUtils.setViewVisibility(this.mUpdateDownloading, 0);
        UIUtils.setViewVisibility(this.mUpdateBtn, 4);
        int i3 = i > 0 ? 5 : 0;
        if (i2 > 0 && (i3 = (int) ((i / i2) * 100.0f)) > 99) {
            i3 = 100;
        }
        this.mProgressBar.setProgress(i3);
        if (i3 >= 80 && this.mHelper != null) {
            if (i3 >= 99) {
                UIUtils.setViewVisibility(this.mProgressBar, 8);
                UIUtils.setViewVisibility(this.mUpdateDownloading, 8);
                UIUtils.setViewVisibility(this.mUpdateBtn, 0);
                this.mUpdateBtn.setText(C0749R.string.update_install);
            } else {
                updateBtnText();
            }
        }
        String updateButtonText = this.mHelper.getUpdateButtonText();
        if (!TextUtils.isEmpty(updateButtonText)) {
            this.mUpdateBtn.setText(updateButtonText);
        }
        this.mUpdateDownloading.setText(String.format(this.mContext.getResources().getString(C0749R.string.update_downloading), Integer.valueOf(i3)));
    }

    public void updateBtnText() {
        TextView textView;
        if (!TextUtils.isEmpty(this.mHelper.getUpdateButtonText()) || (textView = this.mUpdateBtn) == null || this.mContext == null) {
            return;
        }
        if ((UIUtils.isViewVisible(textView) && TextUtils.equals(this.mUpdateBtn.getText(), this.mContext.getString(C0749R.string.update_install))) || this.mHelper.getUpdateReadyApk() == null) {
            return;
        }
        UIUtils.setViewVisibility(this.mProgressBar, 8);
        UIUtils.setViewVisibility(this.mUpdateDownloading, 8);
        UIUtils.setViewVisibility(this.mUpdateBtn, 0);
        this.mUpdateBtn.setText(C0749R.string.update_install);
    }

    public void isAutoUpdate(boolean z) {
        this.mAutoUpdate = z;
    }

    public void showMainDialog(boolean z) {
        show();
    }

    public boolean isShowMainDialog() {
        return isShowing();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class UpdateProgressThread extends Thread {
        boolean updateProgressFinish;
        DownloadInfo info = new DownloadInfo();
        volatile boolean canceled = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        public UpdateProgressThread() {
        }

        public synchronized void cancel() {
            this.canceled = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1500L);
                } catch (Exception unused) {
                }
                if (this.updateProgressFinish) {
                    break;
                }
                UpdateDialogNewBase.this.mHelper.getProgress(this.info);
                if (3 == this.info.status || 2 == this.info.status) {
                    this.updateProgressFinish = true;
                }
                UpdateDialogNewBase.this.mHelper.getProgress(this.info);
                Message obtainMessage = UpdateDialogNewBase.this.mHandler.obtainMessage(1);
                obtainMessage.arg1 = this.info.byteSoFar;
                obtainMessage.arg2 = this.info.contentLength;
                synchronized (this) {
                    if (this.canceled) {
                        break;
                    } else {
                        UpdateDialogNewBase.this.mHandler.sendMessage(obtainMessage);
                    }
                }
            }
            if (this.canceled) {
                return;
            }
            UpdateDialogNewBase.this.mHandler.sendEmptyMessage(2);
        }
    }

    protected void startAin() {
        if (this.mRocketView == null) {
            return;
        }
        UpdateSpringInterpolator updateSpringInterpolator = new UpdateSpringInterpolator(1.46f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, PropsConstants.SCALE_X, 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, PropsConstants.SCALE_Y, 0.0f, 1.0f);
        ofFloat.setInterpolator(updateSpringInterpolator);
        ofFloat2.setInterpolator(updateSpringInterpolator);
        ofFloat.setDuration(DEFAULT_SHOW_DURATION);
        ofFloat2.setDuration(DEFAULT_SHOW_DURATION);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mRootView, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new LinearInterpolator());
        ofFloat3.setDuration(DEFAULT_BG_DURATION);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stopAin() {
        if (this.mRocketView == null) {
            if (isShowing()) {
                dismiss();
                return;
            }
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, PropsConstants.SCALE_X, 1.0f, 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, PropsConstants.SCALE_Y, 1.0f, 0.5f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mRootView, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.ss.android.update.UpdateDialogNewBase.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpdateDialogNewBase.this.isShowing()) {
                    UpdateDialogNewBase.this.dismiss();
                }
            }
        });
        animatorSet.setDuration(DEFAULT_DISMISS_DURATION);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }
}
