package com.huawei.hms.push.plugin.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.NotificationEnableReq;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsNotificationManagerEx {

    /* renamed from: a */
    private HuaweiApi<Api.ApiOptions.NoOptions> f1730a;

    /* renamed from: b */
    private Context f1731b;

    private HmsNotificationManagerEx(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f1731b = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>((Activity) this.f1731b, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f1730a = huaweiApi;
        huaweiApi.setKitSdkVersion(61000300);
    }

    /* renamed from: a */
    private Task<NotificationStatus> m2025a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return m2026a(ErrorEnum.ERROR_MAIN_THREAD.toApiException());
        }
        if (!AbstractC1228a.m2027a()) {
            HMSLog.m2118e("HmsNotificationManagerEx", "operation not supported on device with EMUI lower than 10");
            return m2026a(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
        }
        if (((NotificationManager) this.f1731b.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled()) {
            HMSLog.m2118e("HmsNotificationManagerEx", "App already enabled notification");
            return m2026a(ErrorEnum.ERROR_NOTIFICATION_ENABLED.toApiException());
        }
        long j = new PushPreferences(this.f1731b, "hwpush_local_config").getLong("notification_request_time");
        if (j > 0 && System.currentTimeMillis() - j < 172800000) {
            HMSLog.m2118e("HmsNotificationManagerEx", "the frequency is too high");
            return m2026a(ErrorEnum.ERROR_OVER_FLOW_CONTROL_SIZE.toApiException());
        }
        String reportEntry = PushBiUtil.reportEntry(this.f1731b, "push.enableNotification");
        try {
            NotificationEnableReq notificationEnableReq = new NotificationEnableReq();
            notificationEnableReq.setPkgName(this.f1731b.getPackageName());
            Task doWrite = this.f1730a.doWrite(new C1229b("push.enableNotification", notificationEnableReq, this.f1731b, reportEntry));
            Tasks.await(doWrite);
            return doWrite;
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                PushBiUtil.reportExit(this.f1731b, "push.enableNotification", reportEntry, apiException.getStatusCode());
                return m2026a(apiException);
            }
            PushBiUtil.reportExit(this.f1731b, "push.enableNotification", reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
            return m2026a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
        }
    }

    public static HmsNotificationManagerEx getInstance(Activity activity) {
        return new HmsNotificationManagerEx(activity);
    }

    public Task<NotificationStatus> enableNotification() {
        return m2025a();
    }

    /* renamed from: a */
    private Task<NotificationStatus> m2026a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
