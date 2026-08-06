package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.C1194b;
import com.huawei.hms.opendevice.C1199g;
import com.huawei.hms.opendevice.C1200h;
import com.huawei.hms.support.log.HMSLog;
import java.util.UUID;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";

    /* renamed from: a */
    private Context f942a;

    /* renamed from: b */
    private PushPreferences f943b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f944c;

    private HmsInstanceIdEx(Context context) {
        this.f943b = null;
        this.f942a = context;
        this.f943b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f944c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f944c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f944c.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private String m873a(String str) {
        return "creationTime" + str;
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        return new HmsInstanceIdEx(context);
    }

    public void deleteAAID(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f943b.containsKey(str)) {
                    this.f943b.removeKey(str);
                    this.f943b.removeKey(m873a(str));
                    return;
                }
                return;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getAAId(String str) throws ApiException {
        if (str != null) {
            try {
                if (this.f943b.containsKey(str)) {
                    return this.f943b.getString(str);
                }
                String uuid = UUID.randomUUID().toString();
                this.f943b.saveString(str, uuid);
                this.f943b.saveLong(m873a(str), Long.valueOf(System.currentTimeMillis()));
                return uuid;
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public long getCreationTime(String str) throws ApiException {
        if (str != null) {
            try {
                if (!this.f943b.containsKey(m873a(str))) {
                    getAAId(str);
                }
                return this.f943b.getLong(m873a(str));
            } catch (RuntimeException unused) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            } catch (Exception unused2) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public Task<TokenResult> getToken() {
        if (ProxyCenter.getProxy() != null) {
            try {
                HMSLog.m2120i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
                ProxyCenter.getProxy().getToken(this.f942a, null, null);
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setResult(new TokenResult());
                return taskCompletionSource.getTask();
            } catch (ApiException e) {
                return m872a(e);
            } catch (Exception unused) {
                return m872a(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            }
        }
        String m1861a = C1200h.m1861a(this.f942a, "push.gettoken");
        try {
            TokenReq m1842b = C1194b.m1842b(this.f942a, null, null);
            m1842b.setAaid(HmsInstanceId.getInstance(this.f942a).getId());
            return this.f944c.doWrite(new C1199g("push.gettoken", m1842b, this.f942a, m1861a));
        } catch (RuntimeException unused2) {
            Context context = this.f942a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C1200h.m1864a(context, "push.gettoken", m1861a, errorEnum);
            return m872a(errorEnum.toApiException());
        } catch (Exception unused3) {
            Context context2 = this.f942a;
            ErrorEnum errorEnum2 = ErrorEnum.ERROR_INTERNAL_ERROR;
            C1200h.m1864a(context2, "push.gettoken", m1861a, errorEnum2);
            return m872a(errorEnum2.toApiException());
        }
    }

    /* renamed from: a */
    private Task<TokenResult> m872a(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }
}
