package com.ss.android.update;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.common.utility.collection.WeakHandler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class UpdateDialogBase extends Dialog implements WeakHandler.IHandler {
    protected static final int MSG_UPDATE_PROGRESS = 1;
    protected static final int MSG_UPDATE_REFRESH = 2;
    protected boolean mAutoUpdate;
    protected TextView mBindAppHintTextView;
    protected View mBindAppView;
    protected TextView mCancelBtn;
    protected TextView mDescriptionView;
    protected TextView mDownloadedHintView;
    protected String mEventName;
    protected Handler mHandler;
    protected UpdateHelper mHelper;
    protected TextView mTitleView;
    protected View mUpdateBgView;
    protected View mUpdateBtn;
    protected TextView mUpdateBtnText;
    protected TextView mUpdateProgressText;
    protected View mUpdateProgressView;
    protected TextView mUpdatingText;

    abstract void initData();

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateDialogBase(Context context) {
        super(context);
        this.mEventName = "upgrade_pop";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(C0749R.layout.update_dialog_layout);
        getWindow().setBackgroundDrawableResource(C0749R.drawable.transparent);
        getWindow().setLayout(-2, -2);
        getWindow().setGravity(17);
        setCanceledOnTouchOutside(false);
        this.mHandler = new WeakHandler(this);
        this.mTitleView = (TextView) findViewById(C0749R.id.title_text);
        this.mDownloadedHintView = (TextView) findViewById(C0749R.id.downloaded_hint);
        this.mDescriptionView = (TextView) findViewById(C0749R.id.description);
        this.mUpdateBtn = findViewById(C0749R.id.update_btn_layout);
        this.mUpdateBgView = findViewById(C0749R.id.update_bg);
        this.mUpdateProgressView = findViewById(C0749R.id.update_progress);
        this.mUpdateBtnText = (TextView) findViewById(C0749R.id.update_btn_text);
        this.mUpdateProgressText = (TextView) findViewById(C0749R.id.update_progress_text);
        this.mUpdatingText = (TextView) findViewById(C0749R.id.updating_text);
        TextView textView = (TextView) findViewById(C0749R.id.later_btn);
        this.mCancelBtn = textView;
        textView.setPaintFlags(this.mUpdatingText.getPaintFlags() | 8);
        this.mBindAppView = findViewById(C0749R.id.bind_app_view);
        this.mBindAppHintTextView = (TextView) findViewById(C0749R.id.hint_text);
    }

    public void handleMsg(Message message) {
        int i = message.what;
        if (i == 1) {
            refreshProgress(message.arg1, message.arg2);
        } else {
            if (i != 2) {
                return;
            }
            refreshStatus();
        }
    }

    private void refreshProgress(int i, int i2) {
        this.mUpdateBtnText.setVisibility(8);
        this.mUpdateBgView.setVisibility(8);
        this.mUpdateProgressView.setVisibility(0);
        this.mUpdatingText.setVisibility(0);
        this.mUpdateProgressText.setVisibility(0);
        int i3 = i > 0 ? 5 : 0;
        if (i2 > 0 && (i3 = (int) ((i / i2) * 100.0f)) > 99) {
            i3 = 99;
        }
        this.mUpdateProgressText.setText(i3 + "%");
    }

    private void refreshStatus() {
        initData();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class UpdateProgressThread extends Thread {
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
                if (!UpdateDialogBase.this.mHelper.isUpdating()) {
                    break;
                }
                UpdateDialogBase.this.mHelper.getProgress(this.info);
                Message obtainMessage = UpdateDialogBase.this.mHandler.obtainMessage(1);
                obtainMessage.arg1 = this.info.byteSoFar;
                obtainMessage.arg2 = this.info.contentLength;
                synchronized (this) {
                    if (this.canceled) {
                        break;
                    } else {
                        UpdateDialogBase.this.mHandler.sendMessage(obtainMessage);
                    }
                }
            }
            if (this.canceled) {
                return;
            }
            UpdateDialogBase.this.mHandler.sendEmptyMessage(2);
        }
    }
}
