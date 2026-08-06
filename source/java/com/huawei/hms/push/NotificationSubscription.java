package com.huawei.hms.push;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.push.task.SubscribeNotificationTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeNotificationReq;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NotificationSubscription {
    public static final int NOTIFICATION_SUBSCRIBE_REQUEST_CODE = 1001;

    /* renamed from: d */
    private static final String f1635d = "NotificationSubscription";

    /* renamed from: a */
    private Activity f1636a;

    /* renamed from: b */
    private Context f1637b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f1638c;

    private NotificationSubscription(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f1637b = activity.getApplicationContext();
        this.f1636a = activity;
        HuaweiApi<Api.ApiOptions.NoOptions> huaweiApi = new HuaweiApi<>(activity, (Api<Api.ApiOptions>) new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH), (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        this.f1638c = huaweiApi;
        huaweiApi.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m1922a(List<String> list) {
        String reportEntry = PushBiUtil.reportEntry(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION);
        if (list != null && !list.isEmpty() && list.size() <= 3) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                PushBiUtil.reportExit(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_MAIN_THREAD);
                return m1921a(ErrorEnum.ERROR_MAIN_THREAD.toApiException());
            }
            if (!((NotificationManager) this.f1637b.getSystemService(RemoteMessageConst.NOTIFICATION)).areNotificationsEnabled()) {
                HMSLog.m2120i(f1635d, "App disabled notification");
                PushBiUtil.reportExit(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_NOTIFICATION_DISABLED);
                return m1921a(ErrorEnum.ERROR_NOTIFICATION_DISABLED.toApiException());
            }
            try {
                if (C1238v.m2056a(this.f1637b) != ErrorEnum.SUCCESS) {
                    return m1921a(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                }
                if (-1 != this.f1637b.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f1637b.getPackageName()) && C1217g.m1956a(this.f1637b) == -1) {
                    HMSLog.m2118e(f1635d, "no network");
                    return m1921a(ErrorEnum.ERROR_NO_NETWORK.toApiException());
                }
                Task doWrite = this.f1638c.doWrite(new SubscribeNotificationTask(this.f1636a, PushNaming.SUBSCRIBE_NOTIFICATION, m1923b(list), reportEntry));
                Tasks.await(doWrite);
                return doWrite;
            } catch (Exception e) {
                if (e.getCause() instanceof ApiException) {
                    ApiException apiException = (ApiException) e.getCause();
                    PushBiUtil.reportExit(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, apiException.getStatusCode());
                    return m1921a(apiException);
                }
                PushBiUtil.reportExit(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                return m1921a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        PushBiUtil.reportExit(this.f1637b, PushNaming.SUBSCRIBE_NOTIFICATION, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        HMSLog.m2118e(f1635d, "Invalid entityIds: entityId list should not be empty or more than max size");
        return m1921a(ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException());
    }

    /* renamed from: b */
    private SubscribeNotificationReq m1923b(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        SubscribeNotificationReq subscribeNotificationReq = new SubscribeNotificationReq();
        subscribeNotificationReq.setEntityIds(jSONArray.toString());
        subscribeNotificationReq.setToken(BaseUtils.getLocalToken(this.f1637b, null));
        return subscribeNotificationReq;
    }

    public static NotificationSubscription getInstance(Activity activity) {
        return new NotificationSubscription(activity);
    }

    public static SubscribeResult getSubscribeResult(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            stringExtra = intent.getStringExtra("errorMsg");
        } catch (Throwable unused) {
            HMSLog.m2118e(f1635d, "get subscribe result occurs exception");
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            SubscribeResult subscribeResult = new SubscribeResult();
            subscribeResult.setErrorMsg(stringExtra);
            HMSLog.m2118e(f1635d, "get subscribe error msg:" + stringExtra);
            return subscribeResult;
        }
        String stringExtra2 = intent.getStringExtra("subscribedItems");
        if (!TextUtils.isEmpty(stringExtra2)) {
            List<SubscribedItem> m1935a = C1212b.m1935a(stringExtra2);
            SubscribeResult subscribeResult2 = new SubscribeResult();
            subscribeResult2.setSubscribedItems(m1935a);
            return subscribeResult2;
        }
        return null;
    }

    public Task<SubscribeResult> requestSubscribeNotification(List<String> list) {
        HMSLog.m2120i(f1635d, "invoke request subscribe notification");
        return m1922a(list);
    }

    /* renamed from: a */
    private Task<SubscribeResult> m1921a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
