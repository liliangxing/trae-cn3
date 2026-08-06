package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResp;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: GetTokenTask.java */
/* renamed from: com.huawei.hms.opendevice.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1199g extends TaskApiCall<PushClient, TokenResult> {

    /* renamed from: a */
    private Context f1600a;

    /* renamed from: b */
    private TokenReq f1601b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GetTokenTask.java */
    /* renamed from: com.huawei.hms.opendevice.g$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1602a;

        /* renamed from: b */
        final /* synthetic */ String f1603b;

        a(String str, String str2) {
            this.f1602a = str;
            this.f1603b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C1201i.m1865a(C1199g.this.f1600a).m1869b(this.f1602a).equals(this.f1603b)) {
                return;
            }
            HMSLog.m2120i(HmsInstanceId.TAG, "receive a new token, refresh the local token");
            C1201i.m1865a(C1199g.this.f1600a).m1870b(this.f1602a, this.f1603b);
        }
    }

    public C1199g(String str, TokenReq tokenReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(tokenReq), str2);
        this.f1600a = context;
        this.f1601b = tokenReq;
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f1601b.isMultiSender() ? 50004300 : 30000000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<TokenResult> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m2118e(HmsInstanceId.TAG, "TokenTask failed, ErrorCode:" + responseErrorCode.getErrorCode());
            m1858a(responseErrorCode, taskCompletionSource);
        } else {
            TokenResp tokenResp = (TokenResp) JsonUtil.jsonToEntity(str, new TokenResp());
            ErrorEnum fromCode = ErrorEnum.fromCode(tokenResp.getRetCode());
            if (fromCode != ErrorEnum.SUCCESS) {
                taskCompletionSource.setException(fromCode.toApiException());
                HMSLog.m2118e(HmsInstanceId.TAG, "TokenTask failed, StatusCode:" + fromCode.getExternalCode());
            } else {
                TokenResult tokenResult = new TokenResult();
                tokenResult.setToken(tokenResp.getToken());
                tokenResult.setBelongId(tokenResp.getBelongId());
                tokenResult.setRetCode(ErrorEnum.fromCode(tokenResp.getRetCode()).getExternalCode());
                taskCompletionSource.setResult(tokenResult);
                String token = tokenResp.getToken();
                if (TextUtils.isEmpty(token)) {
                    HMSLog.m2120i(HmsInstanceId.TAG, "GetTokenTask receive an empty token, please check onNewToken callback method.");
                    C1200h.m1862a(pushClient.getContext(), getUri(), responseErrorCode);
                    return;
                }
                m1859a(token, this.f1601b.getSubjectId());
            }
        }
        C1200h.m1862a(pushClient.getContext(), getUri(), responseErrorCode);
    }

    /* renamed from: a */
    private void m1858a(ResponseErrorCode responseErrorCode, TaskCompletionSource<TokenResult> taskCompletionSource) {
        ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    /* renamed from: a */
    private void m1859a(String str, String str2) {
        AsyncExec.submitSeqIO(new a(str2, str));
    }
}
