package com.bytedance.trae.update.dialogs;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.trae.update.bits.impl.C0906R;
import com.bytedance.trae.utils.logger.FLogger;
import com.ss.android.update.UpdateHelper;
import java.io.File;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ManualCheckUpdateDialog.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog;", "Landroid/app/Dialog;", "ctx", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getCtx", "()Landroid/content/Context;", "helper", "Lcom/ss/android/update/UpdateHelper;", "btConfirm", "Landroid/widget/TextView;", "btCancel", "tvContent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initUI", "bindData", "initAction", "confirmClick", "installReadyApk", "readyApkFile", "Ljava/io/File;", "cancelClick", IMessageCallbackService.EVENT_TYPE_SHOW, "isNetworkAvailable", "", "onBackPressed", "Companion", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ManualCheckUpdateDialog extends Dialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ManualCheckUpdateDialog";
    private TextView btCancel;
    private TextView btConfirm;
    private final Context ctx;
    private UpdateHelper helper;
    private TextView tvContent;

    /* compiled from: ManualCheckUpdateDialog.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/update/dialogs/ManualCheckUpdateDialog$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return ManualCheckUpdateDialog.TAG;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManualCheckUpdateDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.ctx = context;
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        this.helper = updateHelper;
    }

    public final Context getCtx() {
        return this.ctx;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUI();
        bindData();
        initAction();
    }

    private final void initUI() {
        requestWindowFeature(1);
        setContentView(C0906R.layout.trae_update_dialog);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setLayout(-1, -2);
            window.setGravity(17);
        }
        setCanceledOnTouchOutside(false);
        this.btCancel = (TextView) findViewById(C0906R.id.tvDialogCancel);
        this.btConfirm = (TextView) findViewById(C0906R.id.btnDialogConfirm);
        this.tvContent = (TextView) findViewById(C0906R.id.tvDialogContent);
    }

    private final void bindData() {
        TextView textView;
        UpdateHelper updateHelper = UpdateHelper.getInstance();
        Intrinsics.checkNotNullExpressionValue(updateHelper, "getInstance(...)");
        this.helper = updateHelper;
        TextView textView2 = this.btConfirm;
        if (textView2 != null) {
            textView2.setText(getContext().getResources().getString(C0906R.string.trae_update_now));
        }
        String whatsNew = this.helper.getWhatsNew();
        if (this.helper.getUpdateReadyApk() != null) {
            whatsNew = this.helper.getAlreadyDownloadTips();
        }
        String str = whatsNew;
        if ((str == null || str.length() == 0) || (textView = this.tvContent) == null) {
            return;
        }
        textView.setText(str);
    }

    private final void initAction() {
        TextView textView = this.btCancel;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.update.dialogs.ManualCheckUpdateDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManualCheckUpdateDialog.this.cancelClick();
                }
            });
        }
        TextView textView2 = this.btConfirm;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.update.dialogs.ManualCheckUpdateDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManualCheckUpdateDialog.this.confirmClick();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void confirmClick() {
        if (this.helper.isRealCurrentVersionOut()) {
            this.helper.clickUpdateButton(false);
            this.helper.cancelNotifyAvai();
            File updateReadyApk = this.helper.getUpdateReadyApk();
            cancel();
            if (updateReadyApk != null) {
                installReadyApk(updateReadyApk);
                return;
            }
            if (!isNetworkAvailable()) {
                Toast.makeText(getContext(), C0906R.string.trae_update_network_error, 1).show();
                return;
            }
            Toast.makeText(getContext(), C0906R.string.trae_update_downloading_bg, 0).show();
            this.helper.startDownload();
            FLogger.INSTANCE.mo425d(TAG, "confirmClick: " + this.helper.isUpdating());
            if (this.helper.isUpdating()) {
                UpdateCheckDialog.INSTANCE.showProgressDialog();
            }
        }
    }

    private final void installReadyApk(File readyApkFile) {
        this.helper.cancelNotifyReady();
        this.helper.installApk(getContext(), readyApkFile);
        this.helper.clickUpdateButton(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelClick() {
        this.helper.clickCloseButton(true);
        cancel();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        this.helper.showUpdateDialogScene(true);
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

    @Override // android.app.Dialog
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        cancelClick();
    }
}
