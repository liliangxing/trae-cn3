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
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.lynx.tasm.behavior.PropsConstants;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AlphaUpdateInstallDialog extends Dialog implements IInstallAlphaDialog, WeakHandler.IHandler {
    private static final long DEFAULT_BG_DURATION = 100;
    private static final long DEFAULT_DISMISS_DURATION = 150;
    private static final long DEFAULT_SHOW_DURATION = 450;
    protected boolean isAnimRepeat;
    protected TextView mButIgnore;
    protected TextView mButInstallNow;
    protected ImageView mCancelBtn;
    protected LinearLayout mContentRoot;
    protected Context mContext;
    protected Handler mHandler;
    private UpdateHelper mHelper;
    protected LottieAnimationView mRocketView;
    private View mRootView;
    private IUpdateConfig mUpdateConfig;
    protected TextView mUpdateTitle;
    protected TextView mUpdateVersion;

    public void handleMsg(Message message) {
    }

    public AlphaUpdateInstallDialog(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0749R.layout.alpha_install_dialog_new_layout);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(C0749R.drawable.transparent);
            window.setLayout(-2, -2);
            window.setGravity(17);
            window.setWindowAnimations(C0749R.style.update_dialog_animation);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.mHandler = new WeakHandler(this);
        this.mRootView = findViewById(C0749R.id.update_root);
        this.mCancelBtn = (ImageView) findViewById(C0749R.id.update_check_cancel_btn);
        this.mUpdateTitle = (TextView) findViewById(C0749R.id.update_title_txt);
        this.mUpdateVersion = (TextView) findViewById(C0749R.id.update_version_txt);
        this.mContentRoot = (LinearLayout) findViewById(C0749R.id.update_content_root);
        this.mRocketView = findViewById(C0749R.id.update_rocket_lottie);
        this.mButInstallNow = (TextView) findViewById(C0749R.id.but_install_now);
        this.mButIgnore = (TextView) findViewById(C0749R.id.but_ignore);
        startRootAnim();
        startRocketAnim();
        initData();
    }

    protected void initData() {
        String[] split;
        this.mUpdateConfig = UpdateSDK.getConfig();
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        this.mHelper = updateHelper;
        if (updateHelper == null) {
            return;
        }
        if (!TextUtils.isEmpty(updateHelper.getWhatsNew())) {
            split = this.mHelper.getWhatsNew().split(UpdateDialogNewBase.TYPE);
        } else if (!TextUtils.isEmpty(UpdateAlphaManager.inst().getAlphaDialogDesc())) {
            split = UpdateAlphaManager.inst().getAlphaDialogDesc().split(UpdateDialogNewBase.TYPE);
        } else {
            split = this.mContext.getResources().getString(C0749R.string.label_update_open_desc).split(UpdateDialogNewBase.TYPE);
        }
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                UpdateContentLinearLayout updateContentLinearLayout = new UpdateContentLinearLayout(this.mContext);
                updateContentLinearLayout.bindUpdateContent(str);
                this.mContentRoot.addView(updateContentLinearLayout);
            }
        }
        String lastVersion = this.mHelper.getLastVersion();
        if (!TextUtils.isEmpty(lastVersion)) {
            this.mUpdateVersion.setText(lastVersion);
            UIUtils.setViewVisibility(this.mUpdateVersion, 0);
        } else {
            UIUtils.setViewVisibility(this.mUpdateVersion, 4);
        }
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlphaUpdateInstallDialog.this.mHelper.onInstallAlphaCloseClick();
                UpdateAlphaManager.inst().markAlphaDialogShown();
                AlphaUpdateInstallDialog.this.stopRootAnim();
            }
        });
        this.mButIgnore.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlphaUpdateInstallDialog.this.mHelper.onInstallAlphaIgnoreClick();
                AlphaUpdateInstallDialog.this.stopRootAnim();
            }
        });
        this.mButInstallNow.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlphaUpdateInstallDialog.this.mHelper.onInstallAlphaInstallNowClick();
                File alphaUpdateBgDownloadReadyApk = AlphaUpdateInstallDialog.this.mHelper.getAlphaUpdateBgDownloadReadyApk();
                AlphaUpdateInstallDialog.this.mHelper.cancelNotifyAvai();
                if (alphaUpdateBgDownloadReadyApk != null) {
                    AlphaUpdateInstallDialog.this.mHelper.cancelNotifyReady();
                    try {
                        AlphaUpdateInstallDialog.this.getContext().startActivity(UpdateFileProviderUtils.getIntent(AlphaUpdateInstallDialog.this.getContext(), alphaUpdateBgDownloadReadyApk));
                        UpdateEventUtils.alphaUpdateBgDownloadEvent(9);
                        UpdateAlphaManager.inst().markAlphaDialogShown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        UpdateEventUtils.alphaUpdateBgDownloadEvent(10, e.getMessage());
                    }
                }
                AlphaUpdateInstallDialog.this.stopRootAnim();
            }
        });
    }

    protected void startRocketAnim() {
        this.mRocketView.setAnimation("upgrade.json");
        this.mRocketView.playAnimation();
        this.mRocketView.setRepeatCount(-1);
        this.mRocketView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (AlphaUpdateInstallDialog.this.isAnimRepeat || valueAnimator == null || valueAnimator.getAnimatedFraction() != 1.0f) {
                    return;
                }
                AlphaUpdateInstallDialog.this.mRocketView.setMinProgress(0.33f);
                AlphaUpdateInstallDialog.this.mRocketView.setMaxProgress(1.0f);
                AlphaUpdateInstallDialog.this.mRocketView.setRepeatCount(-1);
                AlphaUpdateInstallDialog.this.isAnimRepeat = true;
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AlphaUpdateInstallDialog.this.mRocketView.cancelAnimation();
            }
        });
    }

    @Override // com.ss.android.update.IInstallAlphaDialog
    public void showInstallDialog(int i) {
        show();
        this.mHelper.onInstallAlphaDialogShow(i);
    }

    @Override // com.ss.android.update.IInstallAlphaDialog
    public boolean isInstallDialogShowing() {
        return isShowing();
    }

    protected void startRootAnim() {
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

    protected void stopRootAnim() {
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
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.ss.android.update.AlphaUpdateInstallDialog.6
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
                if (AlphaUpdateInstallDialog.this.isShowing()) {
                    AlphaUpdateInstallDialog.this.dismiss();
                }
            }
        });
        animatorSet.setDuration(DEFAULT_DISMISS_DURATION);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }
}
