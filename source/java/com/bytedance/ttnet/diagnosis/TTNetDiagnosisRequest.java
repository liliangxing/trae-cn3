package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.bytedance.push.event.sync.ISignalReportConstants;
import java.util.List;

/* loaded from: classes4.dex */
class TTNetDiagnosisRequest implements IDiagnosisRequest {
    private static final String CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS = "org.chromium.diagnosis.CronetDiagnosisRequestImpl";
    private static final String TAG = "TTNetDiagnosisRequest";
    private IDiagnosisCallback mCallback;
    private ICronetDiagnosisRequest mCronetDiagnosisRequest;
    private String mExtraInfo;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private List<String> mTargets;
    private int mTimeoutMs;
    private ICronetDiagnosisRequest.Callback mCronetDiagnosisRequestCallback = new CallbackImpl();
    private boolean mStarted = false;
    private boolean mCanceled = false;

    /* loaded from: classes4.dex */
    class CallbackImpl implements ICronetDiagnosisRequest.Callback {
        CallbackImpl() {
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(String str) {
            if (TTNetDiagnosisRequest.this.mCallback != null) {
                TTNetDiagnosisRequest.this.mCallback.onDiagnosisComplete(str);
            }
        }
    }

    public TTNetDiagnosisRequest(int i, List<String> list, int i2, int i3, int i4) throws Exception {
        this.mReqType = i;
        this.mTargets = list;
        this.mNetDetectType = i2;
        this.mMultiNetAction = i3;
        this.mTimeoutMs = i4;
        tryResolveCronetDiagnosisRequest();
    }

    private void tryResolveCronetDiagnosisRequest() throws Exception {
        if (this.mCronetDiagnosisRequest == null) {
            Class<?> checkClass = checkClass(CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS);
            if (checkClass == null) {
                throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
            }
            Object newInstance = checkClass.getDeclaredConstructor(ICronetDiagnosisRequest.Callback.class, Integer.TYPE, List.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).newInstance(this.mCronetDiagnosisRequestCallback, Integer.valueOf(this.mReqType), this.mTargets, Integer.valueOf(this.mNetDetectType), Integer.valueOf(this.mMultiNetAction), Integer.valueOf(this.mTimeoutMs));
            if (newInstance instanceof ICronetDiagnosisRequest) {
                this.mCronetDiagnosisRequest = (ICronetDiagnosisRequest) newInstance;
            }
        }
    }

    private Class<?> checkClass(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback iDiagnosisCallback) {
        synchronized (this) {
            if (this.mStarted) {
                return;
            }
            this.mCallback = iDiagnosisCallback;
            this.mCronetDiagnosisRequest.start();
            this.mStarted = true;
            String str = this.mExtraInfo;
            if (str != null && !str.isEmpty()) {
                doExtraCommand(ISignalReportConstants.KEY_EXTRA_INFO, this.mExtraInfo);
            }
        }
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        synchronized (this) {
            if (this.mStarted && !this.mCanceled) {
                this.mCronetDiagnosisRequest.cancel();
                this.mCanceled = true;
            }
        }
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String str, String str2) {
        synchronized (this) {
            if (this.mStarted) {
                this.mCronetDiagnosisRequest.doExtraCommand(str, str2);
            }
        }
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String str) {
        synchronized (this) {
            this.mExtraInfo = str;
            doExtraCommand(ISignalReportConstants.KEY_EXTRA_INFO, str);
        }
    }
}
