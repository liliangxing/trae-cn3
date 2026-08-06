package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.AlertDialogParam;
import com.bytedance.bdturing.comonui.PermissionAlertDialog;
import com.bytedance.bdturing.comonui.TuringAlertDialogCallBack;
import com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity;
import com.bytedance.bdturing.verify.request.AbstractRequest;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringLiveDetectGuideActivity extends TuringBaseLiveDetectActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, TuringBaseLiveDetectActivity.CameraPermissionCallBack {
    private static final String DATA = "detail";
    private static final String TAG = "LiveDetectGuideActivity";
    private View agreementLayout;
    private boolean backFromSetting;
    private CheckBox cbAgreement;
    private View cbTipsView;
    private String mAgreementTitle;
    private String mDecisionDetail;
    private PermissionAlertDialog mDialog;
    private AbstractRequest mRequest;
    private View rootView;
    private TextView tvAgreement;
    private TextView tvBtn;
    private TextView tvHelp;
    private boolean startLiveDetect = false;
    ClickableSpan mClickableSpan = new ClickableSpan() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity.3
        final long CLICK_DELAY = 800;
        long lastClickTime = 0;

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (System.currentTimeMillis() - this.lastClickTime > 800) {
                this.lastClickTime = System.currentTimeMillis();
                TuringLiveDetectWebActivity.startActivity(TuringLiveDetectGuideActivity.this, LiveAuthConfig.getAgreementH5Url(), TuringLiveDetectGuideActivity.this.mAgreementTitle.replace("《", "").replace("》", ""));
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#1664FF"));
        }
    };

    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveDetectGuideActivity__onStop$___twin___ */
    public void m174x46896646() {
        super.onStop();
    }

    protected void onStop() {
        m173xa951df75(this);
    }

    public static void startActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) TuringLiveDetectGuideActivity.class);
        intent.putExtra("detail", str);
        activity.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0603R.layout.activity_turing_live_detect_guide);
        initView();
        initData();
        EventReport.onLivePageCreate(getClass().getName(), LiveDetectService.getInstance().preInit(getApplicationContext(), getClass().getName()), this.mRequest);
        LiveDetectService.getInstance().setOnVerify(true);
    }

    private void initData() {
        this.mDecisionDetail = getIntent().getStringExtra("detail");
        this.mRequest = LiveDetectService.getInstance().getRequest();
        if (TextUtils.isEmpty(this.mDecisionDetail)) {
            finish();
        }
    }

    private void initView() {
        this.rootView = findViewById(C0603R.id.rl_root);
        View findViewById = findViewById(C0603R.id.rl_agreement_container);
        this.agreementLayout = findViewById;
        findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        View findViewById2 = findViewById(C0603R.id.fl_agreement_cb_tip);
        this.cbTipsView = findViewById2;
        findViewById2.postDelayed(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TuringLiveDetectGuideActivity.this.cbTipsView.setVisibility(0);
                TuringLiveDetectGuideActivity.this.cbTipsView.postDelayed(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TuringLiveDetectGuideActivity.this.cbTipsView.setVisibility(8);
                    }
                }, 2000L);
            }
        }, 1000L);
        this.ivLoading = (ImageView) findViewById(C0603R.id.loading);
        CheckBox checkBox = (CheckBox) findViewById(C0603R.id.cb_live_detect_agreement);
        this.cbAgreement = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.cbAgreement.setOnClickListener(this);
        this.tvBtn = (TextView) findViewById(C0603R.id.tv_live_detect_confirm_btn);
        this.tvAgreement = (TextView) findViewById(C0603R.id.tv_live_detect_agreement);
        this.tvHelp = (TextView) findViewById(C0603R.id.tv_live_detect_help);
        String agreementTitle = LiveAuthConfig.getAgreementTitle();
        this.mAgreementTitle = agreementTitle;
        if (TextUtils.isEmpty(agreementTitle)) {
            this.mAgreementTitle = getString(C0603R.string.turing_live_detect_agreement_title);
        }
        initAgreement();
        this.tvBtn.setEnabled(this.cbAgreement.isChecked());
        this.tvBtn.setOnClickListener(this);
        this.tvHelp.setOnClickListener(this);
        this.rootView.setOnClickListener(this);
    }

    private void initAgreement() {
        StringBuilder sb = new StringBuilder();
        String string = getString(C0603R.string.turing_live_detect_agreement_prefix);
        sb.append(string).append(this.mAgreementTitle);
        String sb2 = sb.toString();
        SpannableString spannableString = new SpannableString(sb2);
        spannableString.setSpan(this.mClickableSpan, string.length(), sb2.length(), 33);
        this.tvAgreement.setText(spannableString);
        this.tvAgreement.setHighlightColor(0);
        this.tvAgreement.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.tvBtn.setEnabled(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == C0603R.id.tv_live_detect_confirm_btn) {
            checkCameraPermission(this);
        } else if (view.getId() == C0603R.id.tv_live_detect_help) {
            TuringLiveDetectWebActivity.startActivity(this, LiveAuthConfig.getHelpH5Url(), getString(C0603R.string.turing_live_detect_help));
        } else {
            view.getId();
            int i = C0603R.id.rl_root;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void startLiveDetect() {
        if (this.startLiveDetect) {
            return;
        }
        this.startLiveDetect = true;
        LiveDetectService.getInstance().turn2DetectPage(this.mRequest, this, this.mDecisionDetail);
        finish();
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onGRanted(int i) {
        EventReport.LiveCameraPermission(i == 2 ? 1 : 0, this.mRequest);
        EventReport.liveDetectStartBtnClick(true, this.mRequest);
        startLiveDetect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onDenied(int i) {
        if (this.backFromSetting) {
            return;
        }
        if (i == 1) {
            Toast.makeText((Context) this, (CharSequence) getString(C0603R.string.turing_live_camera_permission_tip_1), 0).show();
        } else if (i == 2) {
            Toast.makeText((Context) this, (CharSequence) getString(C0603R.string.turing_live_camera_permission_tip_2), 0).show();
        }
        EventReport.LiveCameraPermission(i == 2 ? 3 : 2, this.mRequest);
        finish();
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity.CameraPermissionCallBack
    public void onForbidden() {
        EventReport.LiveCameraPermission(4, this.mRequest);
        EventReport.liveDetectStartBtnClick(false, this.mRequest);
        showPermissionDlg();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showPermissionDlg() {
        String string = getString(C0603R.string.truing_live_camera_permission_dlg_title);
        String string2 = getString(C0603R.string.truing_live_camera_permission_dlg_content);
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        alertDialogParam.title = string;
        alertDialogParam.contentText = string2;
        alertDialogParam.lefBtnText = getString(C0603R.string.truing_live_camera_permission_dlg_left_btn_text);
        alertDialogParam.rightBtnText = getString(C0603R.string.truing_live_camera_permission_dlg_right_btn_text);
        PermissionAlertDialog permissionAlertDialog = new PermissionAlertDialog(this, alertDialogParam, false, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveDetectGuideActivity.4
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                TuringLiveDetectGuideActivity.this.finish();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                TuringLiveDetectGuideActivity.this.mDialog.dismiss();
                TuringLiveDetectGuideActivity.this.turn2Setting();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                TuringLiveDetectGuideActivity.this.finish();
            }
        });
        this.mDialog = permissionAlertDialog;
        permissionAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void turn2Setting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        startActivityForResult(intent, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (1 == i) {
            if (ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0) {
                startLiveDetect();
            } else {
                this.backFromSetting = true;
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.CAMERA"}, 1);
            }
        }
    }

    public void onBackPressed() {
        if (LiveAuthConfig.liveDetectCancellable()) {
            super.onBackPressed();
        }
    }

    @Override // com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    protected void onDestroy() {
        super.onDestroy();
        EventReport.onLivePageClose(getClass().getName(), !this.startLiveDetect ? 1 : 0, this.mRequest);
        this.mRequest = null;
        if (this.startLiveDetect) {
            return;
        }
        LiveDetectService.getInstance().onResult(2, null);
    }

    public void finish() {
        super.finish();
        PermissionAlertDialog permissionAlertDialog = this.mDialog;
        if (permissionAlertDialog != null) {
            permissionAlertDialog.dismiss();
            this.mDialog = null;
        }
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveDetectGuideActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m173xa951df75(TuringLiveDetectGuideActivity turingLiveDetectGuideActivity) {
        turingLiveDetectGuideActivity.m174x46896646();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) turingLiveDetectGuideActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
