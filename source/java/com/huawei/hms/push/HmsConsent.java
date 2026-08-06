package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.task.ConsentTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableConsentReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.utils.JsonUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsConsent {

    /* renamed from: a */
    private HuaweiApi<Api.ApiOptions.NoOptions> f1622a;

    /* renamed from: b */
    private Context f1623b;

    private HmsConsent(Context context) {
        Preconditions.checkNotNull(context);
        this.f1623b = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f1622a = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f1622a = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f1622a.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m1903a(boolean z) {
        TaskCompletionSource taskCompletionSource;
        int externalCode;
        String reportEntry = PushBiUtil.reportEntry(this.f1623b, PushNaming.PUSH_CONSENT);
        try {
            if (AbstractC1214d.m1946d(this.f1623b)) {
                EnableConsentReq enableConsentReq = new EnableConsentReq();
                enableConsentReq.setPackageName(this.f1623b.getPackageName());
                enableConsentReq.setEnable(z);
                return this.f1622a.doWrite(new ConsentTask(PushNaming.PUSH_CONSENT, JsonUtil.createJsonString(enableConsentReq), reportEntry));
            }
            throw ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
        } catch (ApiException e) {
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            taskCompletionSource2.setException(e);
            externalCode = e.getStatusCode();
            taskCompletionSource = taskCompletionSource2;
            PushBiUtil.reportExit(this.f1623b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        } catch (Exception unused) {
            taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            externalCode = ErrorEnum.ERROR_INTERNAL_ERROR.getExternalCode();
            PushBiUtil.reportExit(this.f1623b, PushNaming.PUSH_CONSENT, reportEntry, externalCode);
            return taskCompletionSource.getTask();
        }
    }

    public static HmsConsent getInstance(Context context) {
        return new HmsConsent(context);
    }

    public Task<Void> consentOff() {
        return m1903a(false);
    }

    public Task<Void> consentOn() {
        return m1903a(true);
    }
}
