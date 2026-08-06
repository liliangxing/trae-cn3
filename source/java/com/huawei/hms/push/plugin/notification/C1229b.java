package com.huawei.hms.push.plugin.notification;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClient;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.push.NotificationEnableReq;
import com.huawei.hms.support.api.entity.push.NotificationEnableResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

/* compiled from: NotificationEnableTask.java */
/* renamed from: com.huawei.hms.push.plugin.notification.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1229b extends TaskApiCall<PushClient, NotificationStatus> {

    /* renamed from: a */
    private Context f1733a;

    /* renamed from: b */
    private NotificationEnableReq f1734b;

    public C1229b(String str, NotificationEnableReq notificationEnableReq, Context context, String str2) {
        super(str, JsonUtil.createJsonString(notificationEnableReq), str2);
        this.f1733a = context;
        this.f1734b = notificationEnableReq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.common.internal.TaskApiCall
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void doExecute(PushClient pushClient, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<NotificationStatus> taskCompletionSource) {
        if (responseErrorCode.getErrorCode() != 0) {
            HMSLog.m2118e("HmsNotificationManagerEx", "Notification Enable failed, ErrorCode:" + responseErrorCode.getErrorCode());
            m2029a(responseErrorCode, taskCompletionSource);
            return;
        }
        ErrorEnum fromCode = ErrorEnum.fromCode(((NotificationEnableResp) JsonUtil.jsonToEntity(str, new NotificationEnableResp())).getRetCode());
        if (fromCode != ErrorEnum.SUCCESS) {
            taskCompletionSource.setException(fromCode.toApiException());
            HMSLog.m2118e("HmsNotificationManagerEx", "Notification Enable failed, StatusCode:" + fromCode.getExternalCode());
            return;
        }
        NotificationStatus notificationStatus = new NotificationStatus();
        notificationStatus.setRetCode(fromCode.getExternalCode());
        notificationStatus.getStatus().setIntent(m2028a(responseErrorCode));
        taskCompletionSource.setResult(notificationStatus);
        new PushPreferences(this.f1733a, "hwpush_local_config").saveLong("notification_request_time", Long.valueOf(System.currentTimeMillis()));
        PushBiUtil.reportExit(pushClient.getContext(), getUri(), responseErrorCode);
    }

    @Override // com.huawei.hms.common.internal.TaskApiCall
    public int getApiLevel() {
        return 5;
    }

    /* renamed from: a */
    private void m2029a(ResponseErrorCode responseErrorCode, TaskCompletionSource<NotificationStatus> taskCompletionSource) {
        ErrorEnum fromCode = ErrorEnum.fromCode(responseErrorCode.getErrorCode());
        if (fromCode != ErrorEnum.ERROR_UNKNOWN) {
            taskCompletionSource.setException(fromCode.toApiException());
        } else {
            taskCompletionSource.setException(new ApiException(new Status(responseErrorCode.getErrorCode(), responseErrorCode.getErrorReason())));
        }
    }

    /* renamed from: a */
    private Intent m2028a(ResponseErrorCode responseErrorCode) {
        Parcelable parcelable = responseErrorCode.getParcelable();
        if (parcelable == null) {
            return new Intent();
        }
        if (parcelable instanceof Intent) {
            return (Intent) parcelable;
        }
        return new Intent();
    }
}
