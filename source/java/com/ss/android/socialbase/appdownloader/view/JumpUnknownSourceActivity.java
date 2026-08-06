package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.AhUtilsImpl;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.ResourceUtils;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialog;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAlertDialogBuilder;
import com.ss.android.socialbase.appdownloader.impls.DefaultAlertDialogBuilder;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.ttm.player.C;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class JumpUnknownSourceActivity extends Activity {
    private JSONObject mConfig;
    private Intent mCurrentIntent;
    private IDownloadAlertDialog mDialog;
    private int mId;
    private Intent mOriginIntent;

    public static Intent getIntent(Context context, Intent intent, JSONObject jSONObject, long j) {
        Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
        intent2.addFlags(C.ENCODING_PCM_MU_LAW);
        intent2.putExtra("intent", intent);
        intent2.putExtra("config", jSONObject.toString());
        intent2.putExtra("id", j);
        return intent2;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        AppDownloadUtils.pushActivity(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initWindowSetting();
        AppDownloadUtils.pushActivity(this);
    }

    private void initWindowSetting() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.mCurrentIntent = intent;
        if (intent != null) {
            this.mOriginIntent = (Intent) intent.getParcelableExtra("intent");
            this.mId = intent.getIntExtra("id", -1);
            try {
                this.mConfig = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mConfig == null) {
            AppDownloadUtils.safeFinish(this);
            return;
        }
        showDialog();
        IDownloadAlertDialog iDownloadAlertDialog = this.mDialog;
        if (iDownloadAlertDialog != null && !iDownloadAlertDialog.isShowing()) {
            this.mDialog.show();
        } else if (this.mDialog == null) {
            finish();
        }
    }

    private void showDialog() {
        IDownloadAlertDialogBuilder iDownloadAlertDialogBuilder;
        if (this.mDialog != null || this.mCurrentIntent == null) {
            return;
        }
        try {
            IAppDownloadDepend appDownloadDepend = AppDownloader.getInstance().getAppDownloadDepend();
            if (appDownloadDepend == null) {
                iDownloadAlertDialogBuilder = null;
            } else if (appDownloadDepend instanceof AbsAppDownloadDepend) {
                iDownloadAlertDialogBuilder = ((AbsAppDownloadDepend) appDownloadDepend).getThemedAlertDlgBuilder(this.mId, this);
            } else {
                iDownloadAlertDialogBuilder = appDownloadDepend.getThemedAlertDlgBuilder(this);
            }
            if (iDownloadAlertDialogBuilder == null) {
                iDownloadAlertDialogBuilder = new DefaultAlertDialogBuilder(this);
            }
            int stringId = ResourceUtils.getStringId(this, "tt_appdownloader_tip");
            int stringId2 = ResourceUtils.getStringId(this, "tt_appdownloader_label_ok");
            int stringId3 = ResourceUtils.getStringId(this, "tt_appdownloader_label_cancel");
            String optString = this.mConfig.optString(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNOWN_SOURCE_TIPS);
            if (TextUtils.isEmpty(optString)) {
                optString = getString(ResourceUtils.getStringId(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            iDownloadAlertDialogBuilder.setTitle(stringId).setMessage(optString).setPositiveButton(stringId2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (AhUtilsImpl.realJumpUnknownSource(jumpUnknownSourceActivity, jumpUnknownSourceActivity.mOriginIntent, JumpUnknownSourceActivity.this.mId, JumpUnknownSourceActivity.this.mConfig)) {
                        AhUtilsImpl.sendGuideAuthOpenSettingEvent(JumpUnknownSourceActivity.this.mId, JumpUnknownSourceActivity.this.mConfig);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        AhUtilsImpl.tryStartActivity(jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.mOriginIntent, true);
                    }
                    AhUtilsImpl.sendGuideAuthDialogConfirmEvent(JumpUnknownSourceActivity.this.mId, JumpUnknownSourceActivity.this.mConfig);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).setNegativeButton(stringId3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.mOriginIntent != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        AhUtilsImpl.tryStartActivity(jumpUnknownSourceActivity, jumpUnknownSourceActivity.mOriginIntent, true);
                    }
                    AhUtilsImpl.sendGuideAuthDialogCancelEvent(JumpUnknownSourceActivity.this.mId, JumpUnknownSourceActivity.this.mConfig);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.mOriginIntent != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        AhUtilsImpl.tryStartActivity(jumpUnknownSourceActivity, jumpUnknownSourceActivity.mOriginIntent, true);
                    }
                    AhUtilsImpl.sendGuideAuthDialogCancelEvent(JumpUnknownSourceActivity.this.mId, JumpUnknownSourceActivity.this.mConfig);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).setCanceledOnTouchOutside(false);
            this.mDialog = iDownloadAlertDialogBuilder.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
