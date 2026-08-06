package com.bytedance.trae.update.dialogs;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.trae.update.bits.impl.C0906R;
import com.ss.android.update.DownloadInfo;
import com.ss.android.update.IUpdateConfig;
import com.ss.android.update.IUpdateForceExit;
import com.ss.android.update.OnUpdateStatusChangedListener;
import com.ss.android.update.UpdateConfig;
import com.ss.android.update.UpdateHelper;
import com.ss.android.update.UpdateSDK;
import java.io.File;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: UpdateProcessDialog.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\"H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u001dH\u0002J\b\u0010,\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001dH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/update/dialogs/UpdateProcessDialog;", "Landroid/app/Dialog;", "ctx", "Landroid/content/Context;", "autoUpdate", "", "<init>", "(Landroid/content/Context;Z)V", "getCtx", "()Landroid/content/Context;", "getAutoUpdate", "()Z", "handler", "Landroid/os/Handler;", "helper", "Lcom/ss/android/update/UpdateHelper;", "iUpdateConfig", "Lcom/ss/android/update/IUpdateConfig;", "listener", "Lcom/ss/android/update/OnUpdateStatusChangedListener;", "tvTitle", "Landroid/widget/TextView;", "tvHintButton", "tvProgressPercent", "progressBar", "Landroid/widget/ProgressBar;", "downloadInfo", "Lcom/ss/android/update/DownloadInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initUI", "calculateProgress", "", "byteSoFar", "contentLength", "formatSize", "", "bytes", "updateUI", "bindData", "initAction", "startDownload", "isNetworkAvailable", "handleMsg", "msg", "Landroid/os/Message;", "onBackPressed", "Companion", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateProcessDialog extends Dialog {
    public static final int MESSAGE_DOWNLOAD_RESULT = 2;
    public static final int MESSAGE_REFRESH_PROGRESS = 1;
    public static final String TAG = "UpdateProcessDialog";
    private final boolean autoUpdate;
    private final Context ctx;
    private DownloadInfo downloadInfo;
    private Handler handler;
    private UpdateHelper helper;
    private IUpdateConfig iUpdateConfig;
    private OnUpdateStatusChangedListener listener;
    private ProgressBar progressBar;
    private TextView tvHintButton;
    private TextView tvProgressPercent;
    private TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateProgress(int byteSoFar, int contentLength) {
        if (byteSoFar < 0 || contentLength <= 0) {
            return 0;
        }
        int i = (int) ((byteSoFar / contentLength) * 100);
        if (i > 100) {
            return 100;
        }
        return i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateProcessDialog(Context context, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.ctx = context;
        this.autoUpdate = z;
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.bytedance.trae.update.dialogs.UpdateProcessDialog$$ExternalSyntheticLambda2
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean handler$lambda$0;
                handler$lambda$0 = UpdateProcessDialog.handler$lambda$0(UpdateProcessDialog.this, message);
                return handler$lambda$0;
            }
        });
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        this.helper = updateHelper;
        this.downloadInfo = new DownloadInfo();
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final Context getCtx() {
        return this.ctx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handler$lambda$0(UpdateProcessDialog updateProcessDialog, Message message) {
        Intrinsics.checkNotNullParameter(message, "msg");
        updateProcessDialog.handleMsg(message);
        return true;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        bindData();
        initAction();
        UpdateHelper.getInstance().getProgress(this.downloadInfo);
        updateUI();
    }

    private final void initUI() {
        requestWindowFeature(1);
        setContentView(C0906R.layout.trae_update_progress_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -2);
            window.setGravity(17);
        }
        setCanceledOnTouchOutside(false);
        this.tvTitle = (TextView) findViewById(C0906R.id.tvDialogTitle);
        this.tvHintButton = (TextView) findViewById(C0906R.id.tv_update_hint);
        this.tvProgressPercent = (TextView) findViewById(C0906R.id.tvProgressPercent);
        this.progressBar = (ProgressBar) findViewById(C0906R.id.updateProgressBar);
    }

    private final String formatSize(int bytes) {
        double d = bytes / 1048576.0d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void updateUI() {
        int i = this.downloadInfo.status;
        if (i == 0 || i == 1) {
            int calculateProgress = calculateProgress(this.downloadInfo.byteSoFar, this.downloadInfo.contentLength);
            TextView textView = this.tvTitle;
            if (textView != null) {
                textView.setText(getContext().getResources().getString(C0906R.string.trae_update_downloading));
            }
            int i2 = UpdateHelper.getInstance().isForceUpdate() ? C0906R.string.trae_update_quit : C0906R.string.trae_update_ok;
            TextView textView2 = this.tvHintButton;
            if (textView2 != null) {
                textView2.setText(getContext().getResources().getString(i2));
            }
            TextView textView3 = this.tvHintButton;
            if (textView3 != null) {
                textView3.setBackgroundResource(C0906R.drawable.trae_update_btn_bg_secondary);
            }
            TextView textView4 = this.tvHintButton;
            if (textView4 != null) {
                textView4.setTextColor(-10066330);
            }
            ProgressBar progressBar = this.progressBar;
            if (progressBar != null) {
                progressBar.setProgress(calculateProgress, true);
            }
            if (this.downloadInfo.contentLength > 0) {
                TextView textView5 = this.tvProgressPercent;
                if (textView5 != null) {
                    textView5.setText(formatSize(this.downloadInfo.byteSoFar) + " / " + formatSize(this.downloadInfo.contentLength) + "  (" + calculateProgress + "%)");
                    return;
                }
                return;
            }
            TextView textView6 = this.tvProgressPercent;
            if (textView6 != null) {
                textView6.setText(new StringBuilder().append(calculateProgress).append('%').toString());
                return;
            }
            return;
        }
        if (i == 2) {
            TextView textView7 = this.tvTitle;
            if (textView7 != null) {
                textView7.setText(getContext().getResources().getString(C0906R.string.trae_update_download_failed));
            }
            TextView textView8 = this.tvHintButton;
            if (textView8 != null) {
                textView8.setText(getContext().getResources().getString(C0906R.string.trae_update_retry));
            }
            TextView textView9 = this.tvHintButton;
            if (textView9 != null) {
                textView9.setBackgroundResource(C0906R.drawable.trae_update_btn_bg);
            }
            TextView textView10 = this.tvHintButton;
            if (textView10 != null) {
                textView10.setTextColor(-1);
            }
            TextView textView11 = this.tvProgressPercent;
            if (textView11 != null) {
                textView11.setText("");
            }
            ProgressBar progressBar2 = this.progressBar;
            if (progressBar2 != null) {
                progressBar2.setProgress(0);
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        TextView textView12 = this.tvTitle;
        if (textView12 != null) {
            textView12.setText(getContext().getResources().getString(C0906R.string.trae_update_download_completed));
        }
        TextView textView13 = this.tvHintButton;
        if (textView13 != null) {
            textView13.setText(getContext().getResources().getString(C0906R.string.trae_update_install));
        }
        TextView textView14 = this.tvHintButton;
        if (textView14 != null) {
            textView14.setBackgroundResource(C0906R.drawable.trae_update_btn_bg);
        }
        TextView textView15 = this.tvHintButton;
        if (textView15 != null) {
            textView15.setTextColor(-1);
        }
        TextView textView16 = this.tvProgressPercent;
        if (textView16 != null) {
            textView16.setText("");
        }
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 != null) {
            progressBar3.setProgress(100);
        }
    }

    private final void bindData() {
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        this.helper = updateHelper;
        this.iUpdateConfig = UpdateSDK.getConfig();
        OnUpdateStatusChangedListener onUpdateStatusChangedListener = new OnUpdateStatusChangedListener() { // from class: com.bytedance.trae.update.dialogs.UpdateProcessDialog$bindData$1
            private int lastProgress;

            public void onPrepare(boolean pre) {
            }

            public void onUpdateStatusChanged(int status) {
            }

            public void saveDownloadInfo(int size, String etag, boolean pre) {
            }

            public final int getLastProgress() {
                return this.lastProgress;
            }

            public final void setLastProgress(int i) {
                this.lastProgress = i;
            }

            public void updateProgress(int byteSoFar, int contentLength, boolean pre) {
                int calculateProgress;
                Handler handler;
                if (pre) {
                    return;
                }
                calculateProgress = UpdateProcessDialog.this.calculateProgress(byteSoFar, contentLength);
                if (calculateProgress - this.lastProgress <= 1) {
                    return;
                }
                this.lastProgress = calculateProgress;
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.status = 1;
                downloadInfo.byteSoFar = byteSoFar;
                downloadInfo.contentLength = contentLength;
                Message obtain = Message.obtain();
                obtain.what = 1;
                obtain.obj = downloadInfo;
                handler = UpdateProcessDialog.this.handler;
                handler.sendMessage(obtain);
            }

            public void downloadResult(boolean isSuccess, boolean pre) {
                Handler handler;
                if (pre) {
                    return;
                }
                DownloadInfo downloadInfo = new DownloadInfo();
                downloadInfo.status = isSuccess ? 3 : 2;
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = downloadInfo;
                handler = UpdateProcessDialog.this.handler;
                handler.sendMessage(obtain);
            }
        };
        this.listener = onUpdateStatusChangedListener;
        this.helper.addUpdateStatusListener(onUpdateStatusChangedListener);
    }

    private final void initAction() {
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.trae.update.dialogs.UpdateProcessDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UpdateProcessDialog.initAction$lambda$6(UpdateProcessDialog.this, dialogInterface);
            }
        });
        TextView textView = this.tvHintButton;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.update.dialogs.UpdateProcessDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UpdateProcessDialog.initAction$lambda$8(UpdateProcessDialog.this, view);
                }
            });
        }
        startDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAction$lambda$6(UpdateProcessDialog updateProcessDialog, DialogInterface dialogInterface) {
        OnUpdateStatusChangedListener onUpdateStatusChangedListener = updateProcessDialog.listener;
        if (onUpdateStatusChangedListener != null) {
            updateProcessDialog.helper.removeUpdateStatusListener(onUpdateStatusChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAction$lambda$8(UpdateProcessDialog updateProcessDialog, View view) {
        IUpdateConfig iUpdateConfig;
        UpdateConfig updateConfig;
        IUpdateForceExit iUpdateForceExit;
        int i = updateProcessDialog.downloadInfo.status;
        if (i == 0 || i == 1) {
            updateProcessDialog.cancel();
            if (!UpdateHelper.getInstance().isForceUpdate() || (iUpdateConfig = updateProcessDialog.iUpdateConfig) == null || (updateConfig = iUpdateConfig.getUpdateConfig()) == null || (iUpdateForceExit = updateConfig.getiUpdateForceExit()) == null) {
                return;
            }
            iUpdateForceExit.forceExitApp(updateProcessDialog.getContext());
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            File updateReadyApk = updateProcessDialog.helper.getUpdateReadyApk();
            if (updateReadyApk != null) {
                updateProcessDialog.helper.installApk(updateProcessDialog.getContext(), updateReadyApk);
            }
            if (UpdateHelper.getInstance().isForceUpdate()) {
                return;
            }
            updateProcessDialog.cancel();
            return;
        }
        if (!updateProcessDialog.isNetworkAvailable()) {
            Toast.makeText(updateProcessDialog.getContext(), C0906R.string.trae_update_network_error, 1).show();
            return;
        }
        DownloadInfo downloadInfo = new DownloadInfo();
        updateProcessDialog.downloadInfo = downloadInfo;
        downloadInfo.status = 1;
        updateProcessDialog.startDownload();
        updateProcessDialog.updateUI();
    }

    private final void startDownload() {
        this.helper.startDownload();
    }

    private final boolean isNetworkAvailable() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Object systemService = getContext().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(12);
    }

    private final void handleMsg(Message msg) {
        int i = msg.what;
        if (i == 1) {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
            this.downloadInfo = (DownloadInfo) obj;
            updateUI();
            return;
        }
        if (i != 2) {
            return;
        }
        Object obj2 = msg.obj;
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.ss.android.update.DownloadInfo");
        this.downloadInfo = (DownloadInfo) obj2;
        updateUI();
    }

    @Override // android.app.Dialog
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        IUpdateConfig iUpdateConfig;
        UpdateConfig updateConfig;
        IUpdateForceExit iUpdateForceExit;
        super.onBackPressed();
        if (!UpdateHelper.getInstance().isForceUpdate() || (iUpdateConfig = this.iUpdateConfig) == null || (updateConfig = iUpdateConfig.getUpdateConfig()) == null || (iUpdateForceExit = updateConfig.getiUpdateForceExit()) == null) {
            return;
        }
        iUpdateForceExit.forceExitApp(getContext());
    }
}
