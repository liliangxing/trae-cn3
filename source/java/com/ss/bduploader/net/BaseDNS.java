package com.ss.bduploader.net;

import android.os.Handler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BaseDNS {
    private static final int MSG_IS_CANCELLED = 0;
    private static final int MSG_IS_ERROR = 2;
    private static final int MSG_IS_RETRY = 1;
    private static final int MSG_IS_SUCCESS = 3;
    private static final String TAG = "BaseDNS";
    protected boolean mCancelled;
    protected Handler mHandler;
    public String mHostname;
    public String mId;
    protected DNSCompletionListener mListener;
    protected BDVNetClient mNetClient;

    public void cancel() {
    }

    public void close() {
    }

    public boolean isRunning() {
        return true;
    }

    public void start() {
    }

    public BaseDNS(String str, Handler handler) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = handler;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public BaseDNS(String str, BDVNetClient bDVNetClient, Handler handler) {
        this.mCancelled = false;
        this.mNetClient = null;
        this.mHostname = str;
        this.mHandler = handler;
        this.mNetClient = bDVNetClient == null ? new BDHTTPNetwork() : bDVNetClient;
        this.mId = Long.toString(System.nanoTime()) + Integer.toString(System.identityHashCode(this));
    }

    public void setCompletionListener(DNSCompletionListener dNSCompletionListener) {
        this.mListener = dNSCompletionListener;
    }

    protected void notifyRetry(Error error) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, error));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyError(BDUploadDNSInfo bDUploadDNSInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, bDUploadDNSInfo));
    }

    protected void notifyCancelled() {
        this.mHandler.sendEmptyMessage(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifySuccess(BDUploadDNSInfo bDUploadDNSInfo) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, bDUploadDNSInfo));
    }
}
