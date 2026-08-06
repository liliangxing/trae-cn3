package org.chromium.mpa;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.mpa.IMpaService;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;
import org.chromium.CronetClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CronetMpaServiceImpl implements IMpaService {
    private static final String PRE_CNIT_KETNEL_FUNC = "preInitCronetKernel";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private CronetEngine mCronetEngine;
    private IMpaService.ICallback mOuterAccAddressCallback;
    private IMpaService.ICallback mOuterInitCallback;
    private TTMpaService mTTNetMpaService;
    private TTMpaService.ICallback mCronetInitCallback = new TTMpaService.ICallback() { // from class: org.chromium.mpa.CronetMpaServiceImpl.1
        public void onFinish(boolean z, String str) {
            if (CronetMpaServiceImpl.this.mOuterInitCallback != null) {
                CronetMpaServiceImpl.this.mOuterInitCallback.onFinish(z, str);
            }
        }
    };
    private TTMpaService.ICallback mCronetAccAddressCallback = new TTMpaService.ICallback() { // from class: org.chromium.mpa.CronetMpaServiceImpl.2
        public void onFinish(boolean z, String str) {
            synchronized (CronetMpaServiceImpl.class) {
                if (CronetMpaServiceImpl.this.mOuterAccAddressCallback != null) {
                    CronetMpaServiceImpl.this.mOuterAccAddressCallback.onFinish(z, str);
                    CronetMpaServiceImpl.this.mOuterAccAddressCallback = null;
                }
            }
        }
    };

    public void init(IMpaService.ICallback iCallback) {
        if (!createMpaService()) {
            iCallback.onFinish(false, "Create MpaService Failed");
        } else {
            this.mOuterInitCallback = iCallback;
            this.mTTNetMpaService.init(this.mCronetInitCallback);
        }
    }

    private boolean createMpaService() {
        if (!loadCronetKernel()) {
            return false;
        }
        if (this.mTTNetMpaService != null) {
            return true;
        }
        this.mTTNetMpaService = this.mCronetEngine.createTTMpaService();
        return true;
    }

    private boolean loadCronetKernel() {
        if (this.mCronetEngine != null) {
            return true;
        }
        try {
            Reflect.m213on(Class.forName(TTNET_INIT_CLASS).newInstance()).call(PRE_CNIT_KETNEL_FUNC);
            CronetEngine cronetEngine = CronetClient.getCronetEngine();
            this.mCronetEngine = cronetEngine;
            return cronetEngine != null;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void setAccAddress(List<String> list, IMpaService.ICallback iCallback) {
        if (this.mTTNetMpaService == null) {
            if (iCallback != null) {
                iCallback.onFinish(false, "TTNetMpaService is null");
                return;
            }
            return;
        }
        synchronized (CronetMpaServiceImpl.class) {
            if (this.mOuterAccAddressCallback != null) {
                if (iCallback != null) {
                    iCallback.onFinish(false, "setAccAddress is running");
                }
            } else {
                this.mOuterAccAddressCallback = iCallback;
                this.mTTNetMpaService.setAccAddress(list, this.mCronetAccAddressCallback);
            }
        }
    }

    public void start() {
        TTMpaService tTMpaService = this.mTTNetMpaService;
        if (tTMpaService != null) {
            tTMpaService.start();
        }
    }

    public void stop() {
        TTMpaService tTMpaService = this.mTTNetMpaService;
        if (tTMpaService != null) {
            tTMpaService.stop();
        }
    }

    public void command(String str, String str2) {
        TTMpaService tTMpaService = this.mTTNetMpaService;
        if (tTMpaService != null) {
            tTMpaService.command(str, str2);
        }
    }
}
