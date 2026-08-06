package com.ss.bytertc.audio.device.hwearback.ovm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.audio.device.base.ManufacturerChecker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class OVMAuthManager extends Handler {
    private static final int OPEN_DELAY_TIME = 200;
    private static final String TAG = "OVMAuthManager";
    private static final Uri authUri = Uri.parse("content://com.oplus.ocs.out.OpenCapabilityThirdProvider/oplus");
    private static volatile OVMAuthManager sInstance;
    private List<AuthCallback> listenerList;
    private Messenger mAuthMessenger;
    private int mAuthResultCode;
    private Runnable notifyResultRunnable;

    /* loaded from: classes7.dex */
    public interface AuthCallback {
        void onResult(int resultCode);
    }

    /* loaded from: classes7.dex */
    public static class CommonStatusCodes {
        public static final int APP_DISABLE_EXCEPTION = 1011;
        public static final int AUTHCODE_EXPECTED = 1004;
        public static final int AUTHCODE_INVALID = 1007;
        public static final int AUTHCODE_NOT_INIT = -2;
        public static final int AUTHCODE_NOT_SUPPORT = -3;
        public static final int AUTHCODE_NO_PERMISSION = -1;
        public static final int AUTHCODE_RECYCLE = 1006;
        public static final int AUTHENTICATE_FAIL = 1002;
        public static final int AUTHENTICATE_SUCCESS = 1001;
        public static final int CAPABILITY_EXCEPTION = 1008;
        public static final int INTERNAL_EXCEPTION = 1010;
        public static final int STATUS_EXCEPTION = 1009;
        public static final int TIME_EXPIRED = 1003;
        public static final int VERSION_INCOMPATIBLE = 1005;
    }

    public static OVMAuthManager getInstance() {
        if (sInstance == null) {
            synchronized (OVMAuthManager.class) {
                if (sInstance == null) {
                    sInstance = new OVMAuthManager();
                }
            }
        }
        return sInstance;
    }

    private OVMAuthManager() {
        super(Looper.getMainLooper());
        this.mAuthResultCode = -2;
        this.mAuthMessenger = new Messenger(this);
        this.listenerList = new ArrayList();
        this.notifyResultRunnable = new Runnable() { // from class: com.ss.bytertc.audio.device.hwearback.ovm.OVMAuthManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OVMAuthManager.this.m9413x24570da5();
            }
        };
    }

    public void startAuth(Context context, String capability) {
        if (ManufacturerChecker.getManufacturerType() == ManufacturerChecker.Type.OP) {
            Bundle bundle = new Bundle();
            bundle.putBinder(JsCallParser.VALUE_CALLBACK, this.mAuthMessenger.getBinder());
            this.mAuthResultCode = -2;
            try {
                context.getContentResolver().call(authUri, "auth", capability, bundle);
                return;
            } catch (IllegalArgumentException unused) {
                RXLogging.i(TAG, "url is not exist, do not need auth ");
                this.mAuthResultCode = -3;
                notifyResult();
                return;
            } catch (RuntimeException e) {
                RXLogging.e(TAG, "auth error " + e.toString());
                this.mAuthResultCode = -1;
                notifyResult();
                return;
            }
        }
        RXLogging.e(TAG, "no need to auth");
        this.mAuthResultCode = 1001;
        notifyResult();
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        synchronized (this) {
            Bundle data = msg.getData();
            if (data == null) {
                RXLogging.e(TAG, "handleMessage get bundle is null");
            } else {
                this.mAuthResultCode = data.getInt("result_code");
                notifyResult();
            }
        }
    }

    public synchronized void addCallback(AuthCallback listener) {
        if (!this.listenerList.contains(listener)) {
            this.listenerList.add(listener);
        }
        notifyResult();
    }

    public synchronized void removeCallback(AuthCallback listener) {
        this.listenerList.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-audio-device-hwearback-ovm-OVMAuthManager, reason: not valid java name */
    public /* synthetic */ void m9413x24570da5() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.listenerList);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AuthCallback) it.next()).onResult(this.mAuthResultCode);
        }
    }

    private void notifyResult() {
        if (this.mAuthResultCode != -2) {
            removeCallbacks(this.notifyResultRunnable);
            postDelayed(this.notifyResultRunnable, 200L);
        }
    }
}
