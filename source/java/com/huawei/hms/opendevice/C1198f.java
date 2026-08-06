package com.huawei.hms.opendevice;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.DeleteTokenResp;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: DeleteTokenTask.java */
/* renamed from: com.huawei.hms.opendevice.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1198f extends TaskApiCall<PushClient, Void> {

    /* renamed from: a */
    private DeleteTokenReq f1599a;

    public C1198f(String str, DeleteTokenReq deleteTokenReq, String str2) {
        super(str, JsonUtil.createJsonString(deleteTokenReq), str2);
        this.f1599a = deleteTokenReq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m2118e(HmsInstanceId.TAG, "DeleteTokenTask failed, ErrorCode: " + responseErrorCode.getErrorCode());
            ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
            if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
                taskCompletionSource.setException(fromCode.toApiException());
                return;
            } else {
                taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
                return;
            }
        }
        ErrorEnum fromCode2 = ErrorEnum.fromCode(((DeleteTokenResp) JsonUtil.jsonToEntity(str, new DeleteTokenResp())).getRetCode());
        if (fromCode2 != ErrorEnum.SUCCESS) {
            taskCompletionSource.setException(fromCode2.toApiException());
        } else {
            taskCompletionSource.setResult(null);
            C1200h.m1862a(pushClient.getContext(), getUri(), responseErrorCode);
        }
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getMinApkVersion() {
        return this.f1599a.isMultiSender() ? 50004300 : 30000000;
    }
}
