package com.ttnet.org.chromium.net.impl;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;

@JNINamespace("cronet")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class TTCronetMpaService extends TTMpaService {
    private static final String TAG = "TTCronetMpaService";
    private TTMpaService.ICallback mAccAddressCallback;
    private TTMpaService.ICallback mInitCallback;
    private long mMpaServiceAdapter;
    private final Object mMpaServiceAdapterLock = new Object();
    private CronetUrlRequestContext mRequestContext;

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long j, String str, String str2);

    private native long nativeCreateMpaServiceAdapter(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long j, String[] strArr);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long j);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long j);

    public TTCronetMpaService(CronetUrlRequestContext cronetUrlRequestContext) {
        this.mRequestContext = cronetUrlRequestContext;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void init(TTMpaService.ICallback iCallback) {
        synchronized (this.mMpaServiceAdapterLock) {
            if (this.mMpaServiceAdapter == 0) {
                this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());
            }
            this.mInitCallback = iCallback;
            nativeInit(this.mMpaServiceAdapter);
        }
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void setAccAddress(List<String> list, TTMpaService.ICallback iCallback) {
        synchronized (this.mMpaServiceAdapterLock) {
            long j = this.mMpaServiceAdapter;
            if (j == 0) {
                return;
            }
            this.mAccAddressCallback = iCallback;
            nativeSetAccAddress(j, (String[]) list.toArray(new String[list.size()]));
        }
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void start() {
        synchronized (this.mMpaServiceAdapterLock) {
            long j = this.mMpaServiceAdapter;
            if (j == 0) {
                return;
            }
            nativeStart(j);
        }
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void stop() {
        synchronized (this.mMpaServiceAdapterLock) {
            long j = this.mMpaServiceAdapter;
            if (j == 0) {
                return;
            }
            nativeStop(j);
        }
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void command(String str, String str2) {
        synchronized (this.mMpaServiceAdapterLock) {
            long j = this.mMpaServiceAdapter;
            if (j == 0) {
                return;
            }
            nativeCommand(j, str, str2);
        }
    }

    private void onInitFinish(final boolean z, final String str) {
        postToSubThread(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.TTCronetMpaService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTCronetMpaService.this.mInitCallback.onFinish(z, str);
                } catch (Exception e) {
                    Log.m282e(TTCronetMpaService.TAG, "Exception in callback: ", e);
                }
            }
        });
    }

    private void onSetAccAddressFinish(final boolean z, final String str) {
        postToSubThread(new Runnable() { // from class: com.ttnet.org.chromium.net.impl.TTCronetMpaService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTCronetMpaService.this.mAccAddressCallback.onFinish(z, str);
                } catch (Exception e) {
                    Log.m282e(TTCronetMpaService.TAG, "Exception in callback: ", e);
                }
            }
        });
    }

    private void postToSubThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("TTCronetMpaService_Thread");
        thread.start();
    }
}
