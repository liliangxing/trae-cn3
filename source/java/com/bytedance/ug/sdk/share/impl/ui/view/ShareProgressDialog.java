package com.bytedance.ug.sdk.share.impl.ui.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.ui.IShareProgressView;
import com.bytedance.ug.sdk.share.impl.ui.utils.UIUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;

/* loaded from: classes4.dex */
public class ShareProgressDialog implements IShareProgressView {
    private Activity mActivity;
    private TextView mContentTv;
    private ProgressDialog mProgressDialog;

    public ShareProgressDialog(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.bytedance.ug.sdk.share.api.ui.IShareProgressView
    public void show() {
        if (this.mActivity == null) {
            this.mProgressDialog = null;
            return;
        }
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog == null || !progressDialog.isShowing()) {
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this.mActivity);
            }
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setCancelable(true);
            try {
                this.mProgressDialog.show();
                this.mProgressDialog.setContentView(R.layout.share_sdk_ss_progress_dialog);
                this.mProgressDialog.getWindow().setBackgroundDrawable(this.mActivity.getResources().getDrawable(R.drawable.share_sdk_transparent));
                Resources resources = this.mActivity.getResources();
                View findViewById = this.mProgressDialog.findViewById(R.id.container);
                ProgressBar progressBar = (ProgressBar) this.mProgressDialog.findViewById(R.id.progress);
                this.mContentTv = (TextView) this.mProgressDialog.findViewById(R.id.loading);
                UIUtils.setViewBackgroundWithPadding(findViewById, resources.getDrawable(R.drawable.share_sdk_bg_ss_progress_dialog));
                progressBar.setIndeterminateDrawable(new AnimatedRotateDrawable(resources.getDrawable(R.drawable.share_sdk_icon_loading)));
                this.mContentTv.setTextColor(resources.getColor(R.color.share_sdk_loading_text));
                this.mContentTv.setText(R.string.share_sdk_token_loading_tips);
            } catch (Exception e) {
                Logger.e(e.toString());
            }
        }
    }

    @Override // com.bytedance.ug.sdk.share.api.ui.IShareProgressView
    public void dismiss() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override // com.bytedance.ug.sdk.share.api.ui.IShareProgressView
    public boolean isShowing() {
        ProgressDialog progressDialog = this.mProgressDialog;
        return progressDialog != null && progressDialog.isShowing();
    }
}
