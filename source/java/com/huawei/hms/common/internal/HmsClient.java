package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class HmsClient extends BaseHmsClient implements AnyClient {
    public HmsClient(Context context, ClientSettings clientSettings, BaseHmsClient.OnConnectionFailedListener onConnectionFailedListener, BaseHmsClient.ConnectionCallbacks connectionCallbacks) {
        super(context, clientSettings, onConnectionFailedListener, connectionCallbacks);
    }

    @Override // com.huawei.hms.common.internal.AnyClient
    public void post(IMessageEntity iMessageEntity, String str, AnyClient.CallBack callBack) {
        if (callBack == null) {
            HMSLog.m2118e("HmsClient", "callback is invalid, discard.");
            return;
        }
        if ((iMessageEntity instanceof RequestHeader) && str != null) {
            if (!isConnected()) {
                HMSLog.m2120i("HmsClient", "No connection now, the connection status:" + getConnectionStatus());
                if (getConnectionStatus() != 6) {
                    HMSLog.m2118e("HmsClient", "post failed for not connected.");
                    callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, "Not Connected"), new JSONObject().toString());
                    return;
                } else {
                    HMSLog.m2120i("HmsClient", "in timeout-disconnect status, need to bind again.");
                    m1113a();
                }
            }
            RequestHeader requestHeader = (RequestHeader) iMessageEntity;
            HMSLog.m2120i("HmsClient", "post msg " + requestHeader);
            Activity cpActivity = getClientSettings().getCpActivity();
            boolean z = cpActivity == null;
            if (z) {
                HMSLog.m2120i("HmsClient", "Activity is null for " + getClientSettings().getAppID());
            }
            (z ? new BaseAdapter(this) : new BaseAdapter(this, cpActivity)).baseRequest(requestHeader.toJson(), str, requestHeader.getParcelable(), new C1063a(this, callBack));
            return;
        }
        HMSLog.m2118e("HmsClient", "arguments is invalid.");
        callBack.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "Args is invalid"), new JSONObject().toString());
    }

    public void updateSessionId(String str) {
        if (TextUtils.isEmpty(this.sessionId)) {
            this.sessionId = str;
        }
    }

    /* renamed from: com.huawei.hms.common.internal.HmsClient$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class C1063a implements BaseAdapter.BaseCallBack {

        /* renamed from: a */
        private final AnyClient.CallBack f1215a;

        /* renamed from: b */
        private final WeakReference<HmsClient> f1216b;

        C1063a(HmsClient hmsClient, AnyClient.CallBack callBack) {
            this.f1215a = callBack;
            this.f1216b = new WeakReference<>(hmsClient);
        }

        /* renamed from: a */
        private void m1117a(String str) {
            HmsClient hmsClient = this.f1216b.get();
            if (hmsClient != null) {
                hmsClient.updateSessionId(str);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onComplete(String str, String str2, Parcelable parcelable) {
            if (parcelable == null) {
                m1118a(str, str2);
            } else {
                m1119a(str, str2, parcelable);
            }
        }

        @Override // com.huawei.hms.adapter.BaseAdapter.BaseCallBack
        public void onError(String str) {
            if (this.f1215a == null) {
                return;
            }
            ResponseWrap responseWrap = new ResponseWrap(new ResponseHeader());
            if (responseWrap.fromJson(str)) {
                HMSLog.m2120i("HmsClient", "receive msg " + responseWrap);
                ResponseHeader responseHeader = responseWrap.getResponseHeader();
                m1117a(responseHeader.getSessionId());
                this.f1215a.onCallback(responseHeader, responseWrap.getBody());
                return;
            }
            this.f1215a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        /* renamed from: a */
        private void m1118a(String str, String str2) {
            if (this.f1215a == null) {
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                HMSLog.m2120i("HmsClient", "receive msg " + responseHeader);
                m1117a(responseHeader.getSessionId());
                this.f1215a.onCallback(responseHeader, str2);
                return;
            }
            this.f1215a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }

        /* renamed from: a */
        private void m1119a(String str, String str2, Parcelable parcelable) {
            if (this.f1215a == null) {
                return;
            }
            ResponseHeader responseHeader = new ResponseHeader();
            if (responseHeader.fromJson(str)) {
                responseHeader.setParcelable(parcelable);
                HMSLog.m2120i("HmsClient", "receive msg " + responseHeader);
                m1117a(responseHeader.getSessionId());
                this.f1215a.onCallback(responseHeader, str2);
                return;
            }
            this.f1215a.onCallback(new ResponseHeader(1, CommonCode.ErrorCode.ARGUMENTS_INVALID, "response header json error"), new JSONObject().toString());
        }
    }
}
