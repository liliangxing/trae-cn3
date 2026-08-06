package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.CronetClient;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CronetDiagnosisRequestImpl implements ICronetDiagnosisRequest {
    private static final String TAG = "CronetDiagnosisRequestImpl";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private ICronetDiagnosisRequest.Callback mCallback;
    private CallbackImpl mCronetCallback = new CallbackImpl();
    private TTNetDiagnosisRequest mRequest;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    class CallbackImpl implements TTNetDiagnosisRequest.Callback {
        CallbackImpl() {
        }

        public void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest tTNetDiagnosisRequest, String str) {
            CronetDiagnosisRequestImpl.this.mCallback.onNetDiagnosisRequestComplete(str);
        }
    }

    public CronetDiagnosisRequestImpl(ICronetDiagnosisRequest.Callback callback, int i, List<String> list, int i2, int i3, int i4) throws Exception {
        this.mRequest = null;
        this.mCallback = callback;
        if (sCronetEngine == null) {
            sCronetEngine = getCronetEngine();
        }
        CronetEngine cronetEngine = sCronetEngine;
        if (cronetEngine == null) {
            throw new UnsupportedOperationException("Can not get cronet engine.");
        }
        TTNetDiagnosisRequest.Builder newNetDiagnosisRequestBuilder = cronetEngine.newNetDiagnosisRequestBuilder(this.mCronetCallback, (Executor) null);
        newNetDiagnosisRequestBuilder.setRequestType(i).setTargets(list).setNetDetectType(i2).setMultiNetAction(i3).setTimeout(i4);
        this.mRequest = newNetDiagnosisRequestBuilder.build();
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug()) {
            Logger.m190d(TAG, "Init cronet engine");
        }
        try {
            loadCronetKernel();
        } catch (Throwable th) {
            th.printStackTrace();
            if (Logger.debug()) {
                Logger.m190d(TAG, "TTNet init failed, cronet engine is null.");
            }
        }
        return CronetClient.getCronetEngine();
    }

    private static void loadCronetKernel() throws Exception {
        Reflect.m213on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("preInitCronetKernel");
    }

    public void start() {
        TTNetDiagnosisRequest tTNetDiagnosisRequest = this.mRequest;
        if (tTNetDiagnosisRequest != null) {
            tTNetDiagnosisRequest.start();
        }
    }

    public void cancel() {
        TTNetDiagnosisRequest tTNetDiagnosisRequest = this.mRequest;
        if (tTNetDiagnosisRequest != null) {
            tTNetDiagnosisRequest.cancel();
        }
    }

    public void doExtraCommand(String str, String str2) {
        TTNetDiagnosisRequest tTNetDiagnosisRequest = this.mRequest;
        if (tTNetDiagnosisRequest != null) {
            tTNetDiagnosisRequest.doExtraCommand(str, str2);
        }
    }
}
