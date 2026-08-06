package com.ss.android.update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.io.File;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateProgressActivity extends AppCompatActivity implements WeakHandler.IHandler {
    static final int MSG_UPDATE_PROGRESS = 1;
    static final int MSG_UPDATE_REFRESH = 2;
    Button mBack;
    Button mCancel;
    Handler mHandler;
    UpdateService mHelper;
    Button mInstall;
    View mPartingLine;
    ProgressBar mProgress;
    View mProgressContainer;
    TextView mProgressText;
    Button mStop;
    TextView mTitle;
    Button mUpdate;
    String mVerboseAppName;
    TextView mWhatsnew;
    View mWhatsnewContainer;
    UpdateProgressThread mThread = null;
    String mUnknownSize = "";
    private boolean mStatusDestroyed = false;

    public void com_ss_android_update_UpdateProgressActivity__onStop$___twin___() {
        super.onStop();
    }

    protected void onStop() {
        m160x9721ffaa(this);
    }

    protected void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        setContentView(C0749R.layout.update_activity);
        this.mHelper = UpdateSDK.getUpdateService();
        this.mHandler = new WeakHandler(this);
        this.mVerboseAppName = this.mHelper.getVerboseAppName();
        this.mUnknownSize = getString(C0749R.string.ssl_update_unknown_size);
        this.mTitle = (TextView) findViewById(C0749R.id.update_sdk_title);
        this.mPartingLine = findViewById(C0749R.id.parting_line);
        this.mProgressContainer = findViewById(C0749R.id.progress_container);
        this.mProgress = (ProgressBar) findViewById(C0749R.id.progress);
        this.mProgressText = (TextView) findViewById(C0749R.id.progress_text);
        this.mWhatsnewContainer = findViewById(C0749R.id.whatsnew_container);
        this.mWhatsnew = (TextView) findViewById(C0749R.id.whatsnew);
        Button button = (Button) findViewById(C0749R.id.back_btn);
        this.mBack = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateProgressActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateProgressActivity.this.finish();
            }
        });
        Button button2 = (Button) findViewById(C0749R.id.cancel_btn);
        this.mCancel = button2;
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateProgressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateProgressActivity.this.mHelper.cancelNotifyAvai();
                UpdateProgressActivity.this.mHelper.cancelNotifyReady();
                UpdateProgressActivity.this.finish();
            }
        });
        Button button3 = (Button) findViewById(C0749R.id.update_btn);
        this.mUpdate = button3;
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateProgressActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateProgressActivity.this.tryUpdate();
            }
        });
        Button button4 = (Button) findViewById(C0749R.id.stop_btn);
        this.mStop = button4;
        button4.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateProgressActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UpdateProgressActivity.this.mThread != null) {
                    UpdateProgressActivity.this.mThread.cancel();
                }
                UpdateProgressActivity.this.mThread = null;
                UpdateProgressActivity.this.mHelper.cancelDownload();
                UpdateProgressActivity.this.finish();
            }
        });
        Button button5 = (Button) findViewById(C0749R.id.install_btn);
        this.mInstall = button5;
        button5.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.update.UpdateProgressActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateProgressActivity.this.tryUpdate();
            }
        });
        refreshStatus();
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.getBoolean("from_update_avail")) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        Utils.safePutJsonKV(jSONObject, "notify_version_click", 1);
        EventReporter.onEvent("more_tab", jSONObject);
    }

    protected void onDestroy() {
        super.onDestroy();
        UpdateProgressThread updateProgressThread = this.mThread;
        if (updateProgressThread != null) {
            updateProgressThread.cancel();
        }
        this.mStatusDestroyed = true;
    }

    public boolean isDestroyed() {
        try {
            return super.isDestroyed();
        } catch (Throwable unused) {
            return this.mStatusDestroyed;
        }
    }

    private boolean isViewValid() {
        return !this.mStatusDestroyed;
    }

    void refreshStatus() {
        if (this.mHelper.isUpdating()) {
            UpdateProgressThread updateProgressThread = this.mThread;
            if (updateProgressThread != null) {
                updateProgressThread.cancel();
            }
            UpdateProgressThread updateProgressThread2 = new UpdateProgressThread();
            this.mThread = updateProgressThread2;
            updateProgressThread2.start();
            showDownloading();
            return;
        }
        if (!this.mHelper.isRealCurrentVersionOut()) {
            showNoUpdate();
        } else if (this.mHelper.getUpdateReadyApk() != null) {
            showUpdateReady();
        } else {
            showUpdateAvail();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void tryUpdate() {
        if (!this.mHelper.isRealCurrentVersionOut()) {
            showNoUpdate();
            return;
        }
        this.mHelper.cancelNotifyAvai();
        File updateReadyApk = this.mHelper.getUpdateReadyApk();
        if (updateReadyApk != null) {
            this.mHelper.cancelNotifyReady();
            UpdateFileProviderUtils.installApk(this, updateReadyApk);
            finish();
            return;
        }
        this.mHelper.startDownload();
        UpdateProgressThread updateProgressThread = this.mThread;
        if (updateProgressThread != null) {
            updateProgressThread.cancel();
        }
        UpdateProgressThread updateProgressThread2 = new UpdateProgressThread();
        this.mThread = updateProgressThread2;
        updateProgressThread2.start();
        showDownloading();
    }

    public void handleMsg(Message message) {
        if (isViewValid()) {
            int i = message.what;
            if (i == 1) {
                showProgress(message.arg1, message.arg2);
            } else {
                if (i != 2) {
                    return;
                }
                refreshStatus();
            }
        }
    }

    void showProgress(int i, int i2) {
        String str = this.mUnknownSize;
        long j = i > 0 ? 10L : 0L;
        if (i2 > 0) {
            str = formatSize(i2);
            j = (i * 100) / i2;
            if (j > 99) {
                j = 99;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(formatSize(i));
        sb.append(" / ").append(str);
        this.mProgress.setProgress((int) j);
        this.mProgressText.setText(sb.toString());
    }

    String formatSize(int i) {
        return i >= 1048576 ? String.format("%.2f MB", Float.valueOf(i / 1048576.0f)) : i >= 1024 ? String.format("%.2f KB", Float.valueOf(i / 1024.0f)) : String.format("%d B", Integer.valueOf(i));
    }

    void hideAllButtons() {
        this.mUpdate.setVisibility(8);
        this.mInstall.setVisibility(8);
        this.mStop.setVisibility(8);
        this.mCancel.setVisibility(8);
        this.mBack.setVisibility(8);
    }

    void bindWhatsnew() {
        String parseWhatsNew = UpdateHelper.getInstance().parseWhatsNew(this.mHelper.getWhatsNew());
        if (parseWhatsNew == null) {
            parseWhatsNew = "";
        }
        this.mWhatsnew.setText(parseWhatsNew);
    }

    void showUpdateAvail() {
        String lastVersion = this.mHelper.getLastVersion();
        if (lastVersion == null) {
            lastVersion = "";
        }
        this.mTitle.setText(String.format(getString(C0749R.string.ssl_update_avail_fmt), this.mVerboseAppName, lastVersion));
        this.mPartingLine.setVisibility(0);
        this.mProgressContainer.setVisibility(8);
        this.mWhatsnewContainer.setVisibility(0);
        bindWhatsnew();
        hideAllButtons();
        this.mUpdate.setVisibility(0);
        this.mCancel.setVisibility(0);
    }

    void showNoUpdate() {
        this.mTitle.setText(String.format(getString(C0749R.string.ssl_update_none), this.mVerboseAppName));
        this.mPartingLine.setVisibility(8);
        this.mProgressContainer.setVisibility(8);
        this.mWhatsnewContainer.setVisibility(4);
        hideAllButtons();
        this.mBack.setVisibility(0);
    }

    void showUpdateReady() {
        String lastVersion = this.mHelper.getLastVersion();
        this.mTitle.setText(String.format(getString(C0749R.string.ssl_update_ready_fmt), this.mVerboseAppName, lastVersion));
        this.mPartingLine.setVisibility(0);
        this.mProgressContainer.setVisibility(8);
        this.mWhatsnewContainer.setVisibility(0);
        bindWhatsnew();
        hideAllButtons();
        this.mInstall.setVisibility(0);
        this.mCancel.setVisibility(0);
    }

    void showDownloading() {
        String lastVersion = this.mHelper.getLastVersion();
        this.mTitle.setText(String.format(getString(C0749R.string.ssl_update_avail_fmt), this.mVerboseAppName, lastVersion));
        this.mWhatsnewContainer.setVisibility(0);
        bindWhatsnew();
        hideAllButtons();
        this.mStop.setVisibility(0);
        this.mBack.setVisibility(0);
        this.mPartingLine.setVisibility(0);
        this.mProgressContainer.setVisibility(0);
        this.mProgress.setProgress(0);
        this.mProgressText.setText(" ");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class UpdateProgressThread extends Thread {
        DownloadInfo info = new DownloadInfo();
        volatile boolean canceled = false;

        UpdateProgressThread() {
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
                if (!UpdateProgressActivity.this.mHelper.isUpdating()) {
                    break;
                }
                UpdateProgressActivity.this.mHelper.getProgress(this.info);
                Message obtainMessage = UpdateProgressActivity.this.mHandler.obtainMessage(1);
                obtainMessage.arg1 = this.info.byteSoFar;
                obtainMessage.arg2 = this.info.contentLength;
                synchronized (this) {
                    if (this.canceled) {
                        break;
                    } else {
                        UpdateProgressActivity.this.mHandler.sendMessage(obtainMessage);
                    }
                }
            }
            if (this.canceled) {
                return;
            }
            UpdateProgressActivity.this.mHandler.sendEmptyMessage(2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_ss_android_update_UpdateProgressActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m160x9721ffaa(UpdateProgressActivity updateProgressActivity) {
        updateProgressActivity.com_ss_android_update_UpdateProgressActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) updateProgressActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
