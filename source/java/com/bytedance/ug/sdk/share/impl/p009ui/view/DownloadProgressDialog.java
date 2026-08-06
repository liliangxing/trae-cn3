package com.bytedance.ug.sdk.share.impl.p009ui.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SSDialog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DownloadProgressDialog extends SSDialog implements IDownloadProgressDialog {
    private int mProgress;
    private DownloadProgressView mProgressView;

    public DownloadProgressDialog(Activity activity) {
        super(activity, R.style.share_sdk_token_dialog);
        this.mProgress = 0;
        setCancelable(ShareConfigManager.getInstance().isDownloadCanCancel());
        setCanceledOnTouchOutside(ShareConfigManager.getInstance().isDownloadCanCancelOnTouchOutside());
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(getContext(), R.layout.share_sdk_download_progress_dlg, null);
        this.mProgressView = (DownloadProgressView) inflate.findViewById(R.id.share_download_pv);
        syncUi();
        setContentView(inflate);
    }

    @Override // com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog
    public void setProgress(int i) {
        if (this.mProgress != i) {
            this.mProgress = i;
        }
        syncUi();
    }

    private void syncUi() {
        if (isShowing()) {
            this.mProgressView.setProgress(this.mProgress);
        }
    }
}
