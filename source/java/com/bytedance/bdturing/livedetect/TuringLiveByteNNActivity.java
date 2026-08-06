package com.bytedance.bdturing.livedetect;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.C0603R;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.comonui.AlertDialogParam;
import com.bytedance.bdturing.comonui.TuringAlertDialog;
import com.bytedance.bdturing.comonui.TuringAlertDialogCallBack;
import com.bytedance.bdturing.live.Config;
import com.bytedance.bdturing.live.TuringLive;
import com.bytedance.bdturing.livedetect.LiveModelResManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TuringLiveByteNNActivity extends TuringLiveDetectActivity implements LiveModelResManager.ModelFileDownLoadListener {
    private final AtomicBoolean mModelFileReady = new AtomicBoolean(false);
    private final AtomicBoolean mByteNNLoad = new AtomicBoolean(false);
    private boolean mDetectModelInit = false;
    private final IByteNNLoadCallBack mByteNNLoadCallBack = new IByteNNLoadCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity.2
        @Override // com.bytedance.bdturing.livedetect.IByteNNLoadCallBack
        public void onSuccess(String str) {
            TuringLiveByteNNActivity.this.mByteNNLoad.set(true);
            TuringLiveByteNNActivity.this.tryInitTuringLive();
        }

        @Override // com.bytedance.bdturing.livedetect.IByteNNLoadCallBack
        public void onFail(String str, int i) {
            TuringLiveByteNNActivity.this.tryInitTuringLive();
        }
    };

    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveByteNNActivity__onStop$___twin___ */
    public void m172x3e60e1f1() {
        super.onStop();
    }

    protected void onStop() {
        m171x4f49e2aa(this);
    }

    public static void startActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) TuringLiveByteNNActivity.class);
        intent.putExtra("detail", str);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTuringLive() {
        if (this.mDetectModelInit) {
            return;
        }
        this.mDetectModelInit = true;
        new Thread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity.1
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                Config modelConfig = LiveAuthConfig.modelConfig();
                int init = TuringLive.getInstance().init(modelConfig);
                EventReport.byteNNInitResult(init, TuringLiveByteNNActivity.this.mRequest, System.currentTimeMillis() - currentTimeMillis, modelConfig.toJson());
                TuringLiveByteNNActivity.this.startDetect(init);
            }
        }).start();
    }

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity
    protected void initEngine() {
        boolean isModelFileReady = LiveModelResManager.getInstance().isModelFileReady();
        boolean isByteNNLoad = LiveDetectService.getInstance().isByteNNLoad();
        this.mModelFileReady.set(isModelFileReady);
        this.mByteNNLoad.set(isByteNNLoad);
        boolean z = isModelFileReady && isByteNNLoad;
        EventReport.onLivePageCreate(TuringLiveDetectActivity.class.getName(), z, this.mRequest);
        if (z) {
            initTuringLive();
            return;
        }
        EventReport.liveDetectError(BdTuring.BYTENN_LIVE_NOT_READY, "modelFileReady=" + isModelFileReady + ":pluginReady=" + isByteNNLoad + ":appFirstLaunch=" + LiveAuthConfig.isAppFirstLaunch(), this.mRequest);
        if (!this.mModelFileReady.get()) {
            downloadModel();
        }
        if (this.mByteNNLoad.get()) {
            return;
        }
        loadByteNN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadModel() {
        showLoadingDlg(getString(C0603R.string.turing_bytenn_model_loading));
        LiveModelResManager.getInstance().downLoadModelFile(getClass().getName(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByteNN() {
        LiveDetectService.getInstance().loadByteNNInNeed(getClass().getName(), this.mByteNNLoadCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showRetryDlg() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
        }
        String string = getString(C0603R.string.turing_bytenn_model_load_fail_title);
        String string2 = !this.mByteNNLoad.get() ? getString(C0603R.string.turing_bytenn_plugin_load_fail_content) : "";
        if (!this.mModelFileReady.get()) {
            string2 = getString(C0603R.string.turing_bytenn_model_load_fail_content);
        }
        AlertDialogParam alertDialogParam = new AlertDialogParam();
        alertDialogParam.title = string;
        alertDialogParam.contentText = string2;
        alertDialogParam.lefBtnText = getString(C0603R.string.turing_bytenn_model_load_fail_left_text);
        alertDialogParam.rightBtnText = getString(C0603R.string.turing_bytenn_model_load_fail_right_text);
        final String str = "byteNNLoad:" + this.mByteNNLoad + ";modelFileReady=" + this.mModelFileReady;
        this.mDialog = new TuringAlertDialog(this, alertDialogParam, false, new TuringAlertDialogCallBack() { // from class: com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity.3
            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onLeftBtnClick() {
                EventReport.liveDialogState(3, 1, "liveDetectPage", str, TuringLiveByteNNActivity.this.mRequest);
                TuringLiveByteNNActivity.this.finish();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onRightBtnClick() {
                if (TuringLiveByteNNActivity.this.mDialog != null) {
                    TuringLiveByteNNActivity.this.mDialog.dismiss();
                }
                EventReport.liveDialogState(3, 2, "liveDetectPage", str, TuringLiveByteNNActivity.this.mRequest);
                if (!TuringLiveByteNNActivity.this.mByteNNLoad.get() || TuringLiveByteNNActivity.this.mModelFileReady.get()) {
                    if (!TuringLiveByteNNActivity.this.mByteNNLoad.get() && TuringLiveByteNNActivity.this.mModelFileReady.get()) {
                        TuringLiveByteNNActivity.this.loadByteNN();
                        return;
                    } else {
                        TuringLiveByteNNActivity.this.finish();
                        return;
                    }
                }
                TuringLiveByteNNActivity.this.downloadModel();
            }

            @Override // com.bytedance.bdturing.comonui.TuringAlertDialogCallBack
            public void onCancel() {
                EventReport.liveDialogState(3, 3, "liveDetectPage", str, TuringLiveByteNNActivity.this.mRequest);
                TuringLiveByteNNActivity.this.finish();
            }
        });
        this.mDialog.show();
        EventReport.liveDialogState(3, 0, "liveDetectPage", str, this.mRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDetect(final int i) {
        runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (i == 0) {
                    TuringLiveByteNNActivity.this.initTipsMap();
                    TuringLiveByteNNActivity.this.createSession();
                } else {
                    TuringLiveByteNNActivity.this.showFailDlg(new String[]{TuringLiveByteNNActivity.this.getString(C0603R.string.turing_bytenn_model_load_fail_title), TuringLiveByteNNActivity.this.getString(C0603R.string.turing_bytenn_init_error)});
                }
            }
        });
    }

    @Override // com.bytedance.bdturing.livedetect.LiveModelResManager.ModelFileDownLoadListener
    public void onComplete(boolean z, String str) {
        this.mModelFileReady.set(z);
        tryInitTuringLive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryInitTuringLive() {
        runOnUiThread(new Runnable() { // from class: com.bytedance.bdturing.livedetect.TuringLiveByteNNActivity.5
            @Override // java.lang.Runnable
            public void run() {
                TuringLiveByteNNActivity.this.dismissLoadingDlg();
                if (!TuringLiveByteNNActivity.this.mByteNNLoad.get() || !TuringLiveByteNNActivity.this.mModelFileReady.get()) {
                    TuringLiveByteNNActivity.this.showRetryDlg();
                } else {
                    TuringLiveByteNNActivity.this.initTuringLive();
                }
            }
        });
    }

    @Override // com.bytedance.bdturing.livedetect.TuringLiveDetectActivity, com.bytedance.bdturing.livedetect.TuringBaseLiveDetectActivity
    protected void onDestroy() {
        if (this.mDetectModelInit) {
            TuringLive.getInstance().release();
        }
        LiveModelResManager.getInstance().removeCallBackRef(this);
        LiveDetectService.getInstance().removeByteNNCallBack(this.mByteNNLoadCallBack);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_bdturing_livedetect_TuringLiveByteNNActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m171x4f49e2aa(TuringLiveByteNNActivity turingLiveByteNNActivity) {
        turingLiveByteNNActivity.m172x3e60e1f1();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) turingLiveByteNNActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
