package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.AbstractC1197e;
import com.huawei.hms.opendevice.AbstractC1204l;
import com.huawei.hms.opendevice.C1194b;
import com.huawei.hms.opendevice.C1198f;
import com.huawei.hms.opendevice.C1199g;
import com.huawei.hms.opendevice.C1200h;
import com.huawei.hms.opendevice.C1201i;
import com.huawei.hms.opendevice.CallableC1193a;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* renamed from: a */
    private Context f939a;

    /* renamed from: b */
    private PushPreferences f940b;

    /* renamed from: c */
    private HuaweiApi<Api.ApiOptions.NoOptions> f941c;

    private HmsInstanceId(Context context) {
        this.f939a = context.getApplicationContext();
        this.f940b = new PushPreferences(context, "aaid");
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f941c = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f941c = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f941c.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private void m870a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (AbstractC1197e.m1855e(this.f939a)) {
            String string = C1201i.m1865a(this.f939a).getString("subjectId");
            if (TextUtils.isEmpty(string)) {
                C1201i.m1865a(this.f939a).saveString("subjectId", str);
                return;
            } else {
                if (string.contains(str)) {
                    return;
                }
                C1201i.m1865a(this.f939a).saveString("subjectId", string + "," + str);
                return;
            }
        }
        C1201i.m1865a(this.f939a).removeKey("subjectId");
    }

    /* renamed from: b */
    private void m871b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
        }
    }

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        AbstractC1204l.m1889c(context);
        return new HmsInstanceId(context);
    }

    public void deleteAAID() throws ApiException {
        m871b();
        try {
            if (this.f940b.containsKey("aaid")) {
                this.f940b.removeKey("aaid");
                this.f940b.removeKey("creationTime");
                if (C1194b.m1846d(this.f939a)) {
                    if (ProxyCenter.getProxy() != null) {
                        HMSLog.m2120i(TAG, "use proxy delete all token after delete AaId.");
                        ProxyCenter.getProxy().deleteAllToken(this.f939a);
                        return;
                    }
                    DeleteTokenReq m1837a = C1194b.m1837a(this.f939a);
                    m1837a.setDeleteType(1);
                    m1837a.setMultiSender(false);
                    m869a(m1837a, 1);
                    BaseUtils.deleteAllTokenCache(this.f939a);
                }
            }
        } catch (ApiException e) {
            throw e;
        } catch (Exception unused) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public void deleteToken(String str, String str2) throws ApiException {
        m871b();
        m868a();
        DeleteTokenReq m1839a = C1194b.m1839a(this.f939a, str, str2);
        m1839a.setMultiSender(false);
        m869a(m1839a, 1);
    }

    public Task<AAIDResult> getAAID() {
        try {
            return Tasks.callInBackground(new CallableC1193a(this.f939a.getApplicationContext()));
        } catch (Exception unused) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
            return taskCompletionSource.getTask();
        }
    }

    public long getCreationTime() {
        try {
            if (!this.f940b.containsKey("creationTime")) {
                getAAID();
            }
            return this.f940b.getLong("creationTime");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getId() {
        return C1194b.m1844b(this.f939a);
    }

    @Deprecated
    public String getToken() {
        try {
            return getToken(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getToken(String str, String str2) throws ApiException {
        m871b();
        m868a();
        TokenReq m1842b = C1194b.m1842b(this.f939a, null, str2);
        m1842b.setAaid(getId());
        m1842b.setMultiSender(false);
        C1201i.m1865a(this.f939a).saveString(this.f939a.getPackageName(), "1");
        return m867a(m1842b, 1);
    }

    public void deleteToken(String str) throws ApiException {
        m871b();
        m868a();
        if (!TextUtils.isEmpty(str)) {
            String m1845c = C1194b.m1845c(this.f939a);
            if (!TextUtils.isEmpty(m1845c)) {
                if (str.equals(m1845c)) {
                    deleteToken(null, null);
                    return;
                }
                DeleteTokenReq m1838a = C1194b.m1838a(this.f939a, str);
                m1838a.setMultiSender(true);
                m869a(m1838a, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String str) throws ApiException {
        m871b();
        m868a();
        if (!TextUtils.isEmpty(str)) {
            String m1845c = C1194b.m1845c(this.f939a);
            if (!TextUtils.isEmpty(m1845c)) {
                if (str.equals(m1845c)) {
                    return getToken(null, null);
                }
                TokenReq m1841b = C1194b.m1841b(this.f939a, str);
                m1841b.setAaid(getId());
                m1841b.setMultiSender(true);
                return m867a(m1841b, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    /* renamed from: a */
    private String m867a(TokenReq tokenReq, int i) throws ApiException {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m2120i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            ProxyCenter.getProxy().getToken(this.f939a, tokenReq.getSubjectId(), null);
            return null;
        }
        m870a(tokenReq.getSubjectId());
        String m1861a = C1200h.m1861a(this.f939a, "push.gettoken");
        try {
            HMSLog.m2115d(TAG, "getToken req :" + tokenReq.toString());
            C1199g c1199g = new C1199g("push.gettoken", tokenReq, this.f939a, m1861a);
            c1199g.setApiLevel(i);
            return ((TokenResult) Tasks.await(this.f941c.doWrite(c1199g))).getToken();
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                C1200h.m1863a(this.f939a, "push.gettoken", m1861a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f939a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C1200h.m1864a(context, "push.gettoken", m1861a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m869a(DeleteTokenReq deleteTokenReq, int i) throws ApiException {
        String subjectId = deleteTokenReq.getSubjectId();
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m2120i(TAG, "use proxy delete token");
            ProxyCenter.getProxy().deleteToken(this.f939a, subjectId, null);
            return;
        }
        String m1861a = C1200h.m1861a(this.f939a, "push.deletetoken");
        try {
            String m1869b = C1201i.m1865a(this.f939a).m1869b(subjectId);
            if (deleteTokenReq.isMultiSender() && (TextUtils.isEmpty(m1869b) || m1869b.equals(C1201i.m1865a(this.f939a).m1869b(null)))) {
                C1201i.m1865a(this.f939a).removeKey(subjectId);
                HMSLog.m2120i(TAG, "The local subject token is null");
                return;
            }
            deleteTokenReq.setToken(m1869b);
            C1198f c1198f = new C1198f("push.deletetoken", deleteTokenReq, m1861a);
            c1198f.setApiLevel(i);
            Tasks.await(this.f941c.doWrite(c1198f));
            C1201i.m1865a(this.f939a).m1871c(subjectId);
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                ApiException apiException = (ApiException) e.getCause();
                C1200h.m1863a(this.f939a, "push.deletetoken", m1861a, apiException.getStatusCode());
                throw apiException;
            }
            Context context = this.f939a;
            ErrorEnum errorEnum = ErrorEnum.ERROR_INTERNAL_ERROR;
            C1200h.m1864a(context, "push.deletetoken", m1861a, errorEnum);
            throw errorEnum.toApiException();
        }
    }

    /* renamed from: a */
    private void m868a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f939a) && ProxyCenter.getProxy() == null && !BaseUtils.isMainProc(this.f939a)) {
            HMSLog.m2118e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }
}
