package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.p019ui.BaseResolutionAdapter;
import com.huawei.hms.adapter.p019ui.UpdateAdapter;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.availableupdate.UpdateAdapterMgr;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResolutionFlagUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BaseAdapter {

    /* renamed from: a */
    private WeakReference<ApiClient> f983a;

    /* renamed from: b */
    private WeakReference<Activity> f984b;

    /* renamed from: c */
    private BaseCallBack f985c;

    /* renamed from: d */
    private String f986d;

    /* renamed from: e */
    private String f987e;

    /* renamed from: f */
    private Parcelable f988f;

    /* renamed from: g */
    private BaseCallBack f989g;

    /* renamed from: h */
    private String f990h;

    /* renamed from: i */
    private Context f991i;

    /* renamed from: j */
    private RequestHeader f992j = new RequestHeader();

    /* renamed from: k */
    private ResponseHeader f993k = new ResponseHeader();

    /* renamed from: l */
    private SystemObserver f994l;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface BaseCallBack {
        void onComplete(String str, String str2, Parcelable parcelable);

        void onError(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class BaseRequestResultCallback implements ResultCallback<ResolveResult<CoreBaseResponse>> {

        /* renamed from: a */
        private AtomicBoolean f998a = new AtomicBoolean(true);

        public BaseRequestResultCallback() {
        }

        /* renamed from: a */
        private void m957a(String str, BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse, int i) {
            if (CommonCode.Resolution.HAS_RESOLUTION_FROM_APK.equals(str)) {
                Activity m940c = BaseAdapter.this.m940c();
                HMSLog.m2120i("BaseAdapter", "activity is: " + m940c);
                if (m940c != null && !m940c.isFinishing()) {
                    PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
                    if (pendingIntent != null) {
                        if (!Util.isAvailableLibExist(BaseAdapter.this.f991i)) {
                            baseCallBack.onError(BaseAdapter.this.m933b(-9));
                            return;
                        } else {
                            BaseAdapter.this.m914a(m940c, pendingIntent, coreBaseResponse);
                            return;
                        }
                    }
                    Intent intent = coreBaseResponse.getIntent();
                    if (intent != null) {
                        if (!Util.isAvailableLibExist(BaseAdapter.this.f991i)) {
                            baseCallBack.onError(BaseAdapter.this.m933b(-9));
                            return;
                        } else {
                            BaseAdapter.this.m914a(m940c, intent, coreBaseResponse);
                            return;
                        }
                    }
                    if (i == 2) {
                        BaseAdapter baseAdapter = BaseAdapter.this;
                        baseCallBack.onError(baseAdapter.m933b(baseAdapter.f993k.getErrorCode()));
                        return;
                    } else {
                        HMSLog.m2118e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
                        baseCallBack.onError(BaseAdapter.this.m933b(-4));
                        return;
                    }
                }
                HMSLog.m2118e("BaseAdapter", "activity null");
                BaseAdapter.this.m920a(baseCallBack, coreBaseResponse);
                return;
            }
            if (!"installHMS".equals(str)) {
                BaseAdapter.this.m920a(baseCallBack, coreBaseResponse);
            } else {
                HMSLog.m2120i("BaseAdapter", "has resolutin: installHMS");
                m956a(baseCallBack, coreBaseResponse);
            }
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        public void onResult(ResolveResult<CoreBaseResponse> resolveResult) {
            HMSLog.m2120i("BaseAdapter", "BaseRequestResultCallback onResult");
            BaseCallBack m931b = BaseAdapter.this.m931b();
            if (m931b == null) {
                HMSLog.m2118e("BaseAdapter", "onResult baseCallBack null");
                return;
            }
            if (resolveResult == null) {
                HMSLog.m2118e("BaseAdapter", "result null");
                m931b.onError(BaseAdapter.this.m933b(-1));
                return;
            }
            CoreBaseResponse value = resolveResult.getValue();
            if (value == null) {
                HMSLog.m2118e("BaseAdapter", "response null");
                m931b.onError(BaseAdapter.this.m933b(-1));
                return;
            }
            if (!TextUtils.isEmpty(value.getJsonHeader())) {
                JsonUtil.jsonToEntity(value.getJsonHeader(), BaseAdapter.this.f993k);
                if (this.f998a.compareAndSet(true, false)) {
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.m916a(baseAdapter.f991i, BaseAdapter.this.f993k);
                }
                String resolution = BaseAdapter.this.f993k.getResolution();
                int statusCode = BaseAdapter.this.f993k.getStatusCode();
                HMSLog.m2120i("BaseAdapter", "api is: " + BaseAdapter.this.f993k.getApiName() + ", resolution: " + resolution + ", status_code: " + statusCode);
                m957a(resolution, m931b, value, statusCode);
                return;
            }
            HMSLog.m2118e("BaseAdapter", "jsonHeader null");
            m931b.onError(BaseAdapter.this.m933b(-1));
        }

        /* renamed from: a */
        private void m956a(final BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
            if (!BaseAdapter.this.m953h()) {
                if (Util.isAvailableLibExist(BaseAdapter.this.f991i)) {
                    Activity m940c = BaseAdapter.this.m940c();
                    if (m940c != null && !m940c.isFinishing()) {
                        HMSLog.m2120i("BaseAdapter", "start handleSolutionForHMS");
                        AvailableAdapter availableAdapter = new AvailableAdapter(ExceptionCode.CRASH_EXCEPTION);
                        availableAdapter.setCalledBySolutionInstallHms(true);
                        availableAdapter.startResolution(m940c, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback.1
                            @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                            public void onComplete(int i) {
                                HMSLog.m2120i("BaseAdapter", "complete handleSolutionForHMS, result: " + i);
                                if (i != 0) {
                                    BaseAdapter baseAdapter = BaseAdapter.this;
                                    baseCallBack.onError(baseAdapter.m909a(i, baseAdapter.m912a(i)).toJson());
                                    return;
                                }
                                BaseAdapter.this.m919a(baseCallBack);
                            }
                        });
                        return;
                    }
                    HMSLog.m2118e("BaseAdapter", "activity is null");
                    try {
                        if (BaseAdapter.this.f991i != null && AvailableUtil.isInstallerLibExist(BaseAdapter.this.f991i)) {
                            if (!UpdateAdapterMgr.INST.needStartUpdateActivity()) {
                                return;
                            }
                            HMSLog.m2120i("BaseAdapter", "pass installHMS intent");
                            Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(BaseAdapter.this.f991i, UpdateAdapter.class.getName());
                            intentStartBridgeActivity.putExtra(CommonCode.MapKey.UPDATE_VERSION, ExceptionCode.CRASH_EXCEPTION);
                            intentStartBridgeActivity.putExtra("installHMS", "installHMS");
                            coreBaseResponse.setIntent(intentStartBridgeActivity);
                            BaseAdapter.this.m920a(baseCallBack, coreBaseResponse);
                        } else {
                            HMSLog.m2120i("BaseAdapter", "pass ACTIVITY_NULL error");
                            BaseAdapter baseAdapter = BaseAdapter.this;
                            baseCallBack.onError(baseAdapter.m909a(-3, baseAdapter.m912a(-3)).toJson());
                        }
                        return;
                    } catch (RuntimeException unused) {
                        HMSLog.m2118e("BaseAdapter", "handleSolutionForHms pass result failed");
                        return;
                    }
                }
                HMSLog.m2120i("BaseAdapter", "handleSolutionForHms: no Available lib exist");
                baseCallBack.onError(BaseAdapter.this.m933b(-9));
                return;
            }
            HMSLog.m2120i("BaseAdapter", "HMS Core exists, need to refresh bind info");
            BaseAdapter.this.m919a(baseCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.adapter.BaseAdapter$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class C1018a extends PendingResultImpl<ResolveResult<CoreBaseResponse>, CoreBaseResponse> {
        public C1018a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResolveResult<CoreBaseResponse> onComplete(CoreBaseResponse coreBaseResponse) {
            ResolveResult<CoreBaseResponse> resolveResult = new ResolveResult<>(coreBaseResponse);
            resolveResult.setStatus(Status.SUCCESS);
            return resolveResult;
        }
    }

    public BaseAdapter(ApiClient apiClient) {
        this.f983a = new WeakReference<>(apiClient);
        if (apiClient == null) {
            HMSLog.m2121w("BaseAdapter", "BaseAdapter constructor client is null");
        } else {
            this.f991i = apiClient.getContext().getApplicationContext();
            HMSLog.m2120i("BaseAdapter", "In constructor, WeakReference is " + this.f983a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m953h() {
        return new PackageManagerHelper(this.f991i).getPackageStates(HMSPackageManager.getInstance(this.f991i).getHMSPackageName()) == PackageManagerHelper.PackageStates.ENABLED;
    }

    /* renamed from: i */
    private void m954i() {
        if (this.f986d == null || this.f989g == null) {
            return;
        }
        this.f993k = null;
        this.f993k = new ResponseHeader();
        baseRequest(m946d(), m948e(), m950f(), m907a());
    }

    /* renamed from: j */
    private void m955j() {
        if (this.f991i == null) {
            HMSLog.m2118e("BaseAdapter", "sendBroadcastAfterResolutionHms, context is null");
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.action.SESSION_INVALID");
        try {
            intent.setPackage(this.f991i.getPackageName());
            this.f991i.sendBroadcast(intent);
        } catch (IllegalArgumentException unused) {
            HMSLog.m2118e("BaseAdapter", "IllegalArgumentException when sendBroadcastAfterResolutionHms intent.setPackage");
        }
    }

    public void baseRequest(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m928a(str, str2, parcelable, baseCallBack);
        if (this.f983a == null) {
            HMSLog.m2118e("BaseAdapter", "client is null");
            baseCallBack.onError(m933b(-2));
            return;
        }
        this.f985c = baseCallBack;
        JsonUtil.jsonToEntity(str, this.f992j);
        CoreBaseRequest coreBaseRequest = new CoreBaseRequest();
        coreBaseRequest.setJsonObject(str2);
        coreBaseRequest.setJsonHeader(str);
        coreBaseRequest.setParcelable(parcelable);
        String apiName = this.f992j.getApiName();
        if (TextUtils.isEmpty(apiName)) {
            HMSLog.m2118e("BaseAdapter", "get uri null");
            baseCallBack.onError(m933b(-5));
            return;
        }
        String transactionId = this.f992j.getTransactionId();
        this.f990h = transactionId;
        if (TextUtils.isEmpty(transactionId)) {
            HMSLog.m2118e("BaseAdapter", "get transactionId null");
            baseCallBack.onError(m933b(-6));
        } else {
            HMSLog.m2120i("BaseAdapter", "in baseRequest + uri is :" + apiName + ", transactionId is : " + this.f990h);
            m915a(this.f991i, this.f992j);
            m911a(this.f983a.get(), apiName, coreBaseRequest).setResultCallback(new BaseRequestResultCallback());
        }
    }

    /* renamed from: d */
    private String m946d() {
        return this.f986d;
    }

    /* renamed from: e */
    private String m948e() {
        return this.f987e;
    }

    /* renamed from: f */
    private Parcelable m950f() {
        return this.f988f;
    }

    /* renamed from: g */
    private void m951g() {
        this.f994l = new SystemObserver() { // from class: com.huawei.hms.adapter.BaseAdapter.2
            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onNoticeResult(int i) {
                return false;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onSolutionResult(Intent intent, String str) {
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equals(BaseAdapter.this.f990h)) {
                        return false;
                    }
                    HMSLog.m2120i("BaseAdapter", "onSolutionResult + id is :" + str);
                    BaseCallBack m931b = BaseAdapter.this.m931b();
                    if (m931b == null) {
                        HMSLog.m2118e("BaseAdapter", "onResult baseCallBack null");
                        return true;
                    }
                    if (intent != null) {
                        if (BaseAdapter.this.m938b(intent, m931b) || BaseAdapter.this.m929a(intent, m931b)) {
                            return true;
                        }
                        HMSLog.m2118e("BaseAdapter", "onComplete for on activity result");
                        BaseAdapter.this.m943c(intent, m931b);
                        return true;
                    }
                    HMSLog.m2118e("BaseAdapter", "onSolutionResult but data is null");
                    String m933b = BaseAdapter.this.m933b(-7);
                    BaseAdapter baseAdapter = BaseAdapter.this;
                    baseAdapter.m917a(baseAdapter.f991i, BaseAdapter.this.f993k, 0L);
                    m931b.onError(m933b);
                    return true;
                }
                HMSLog.m2118e("BaseAdapter", "onSolutionResult but id is null");
                BaseCallBack m931b2 = BaseAdapter.this.m931b();
                if (m931b2 != null) {
                    m931b2.onError(BaseAdapter.this.m933b(-6));
                    return true;
                }
                HMSLog.m2118e("BaseAdapter", "onSolutionResult baseCallBack null");
                return true;
            }

            @Override // com.huawei.hms.adapter.sysobs.SystemObserver
            public boolean onUpdateResult(int i) {
                return false;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Activity m940c() {
        if (this.f984b == null) {
            HMSLog.m2120i("BaseAdapter", "activityWeakReference is " + this.f984b);
            return null;
        }
        ApiClient apiClient = this.f983a.get();
        if (apiClient == null) {
            HMSLog.m2120i("BaseAdapter", "tmpApi is null");
            return null;
        }
        HMSLog.m2120i("BaseAdapter", "activityWeakReference has " + this.f984b.get());
        return Util.getActiveActivity(this.f984b.get(), apiClient.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public BaseCallBack m931b() {
        BaseCallBack baseCallBack = this.f985c;
        if (baseCallBack != null) {
            return baseCallBack;
        }
        HMSLog.m2118e("BaseAdapter", "callback null");
        return null;
    }

    /* renamed from: b */
    private void m935b(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* renamed from: a */
    private PendingResult<ResolveResult<CoreBaseResponse>> m911a(ApiClient apiClient, String str, CoreBaseRequest coreBaseRequest) {
        return new C1018a(apiClient, str, coreBaseRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m919a(BaseCallBack baseCallBack) {
        HMSPackageManager.getInstance(this.f991i).resetMultiServiceState();
        baseCallBack.onError(m909a(11, m912a(11)).toJson());
        m955j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m933b(int i) {
        m942c(i);
        return this.f993k.toJson();
    }

    /* renamed from: c */
    private void m942c(int i) {
        this.f993k.setTransactionId(this.f992j.getTransactionId());
        this.f993k.setAppID(this.f992j.getAppID());
        this.f993k.setApiName(this.f992j.getApiName());
        this.f993k.setSrvName(this.f992j.getSrvName());
        this.f993k.setPkgName(this.f992j.getPkgName());
        this.f993k.setStatusCode(1);
        this.f993k.setErrorCode(i);
        this.f993k.setErrorReason("Core error");
    }

    /* renamed from: b */
    private void m937b(String str) {
        this.f987e = str;
    }

    public BaseAdapter(ApiClient apiClient, Activity activity) {
        this.f983a = new WeakReference<>(apiClient);
        this.f984b = new WeakReference<>(activity);
        if (activity == null) {
            HMSLog.m2121w("BaseAdapter", "BaseAdapter constructor activity is null");
        } else {
            this.f991i = activity.getApplicationContext();
            HMSLog.m2120i("BaseAdapter", "In constructor, activityWeakReference is " + this.f984b + ", activity is " + this.f984b.get());
        }
    }

    /* renamed from: b */
    private void m936b(BaseCallBack baseCallBack) {
        this.f989g = baseCallBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m938b(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0);
        HMSLog.m2120i("BaseAdapter", "kit_update_result is " + intExtra);
        if (intExtra == 1) {
            HMSLog.m2118e("BaseAdapter", "kit update success,replay request");
            m954i();
        } else {
            HMSLog.m2118e("BaseAdapter", "kit update failed");
            baseCallBack.onError(m909a(-10, m912a(intExtra)).toJson());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m920a(BaseCallBack baseCallBack, CoreBaseResponse coreBaseResponse) {
        HMSLog.m2120i("BaseAdapter", "baseCallBack.onComplete");
        PendingIntent pendingIntent = coreBaseResponse.getPendingIntent();
        if (pendingIntent != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), pendingIntent);
            return;
        }
        Intent modifyIntentBehaviorsSafe = IntentUtil.modifyIntentBehaviorsSafe(coreBaseResponse.getIntent());
        if (modifyIntentBehaviorsSafe != null) {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), modifyIntentBehaviorsSafe);
        } else {
            baseCallBack.onComplete(coreBaseResponse.getJsonHeader(), coreBaseResponse.getJsonBody(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m943c(Intent intent, BaseCallBack baseCallBack) {
        long j;
        String stringExtra = intent.getStringExtra(CommonCode.MapKey.JSON_HEADER);
        String stringExtra2 = intent.getStringExtra(CommonCode.MapKey.JSON_BODY);
        Object infoFromJsonobject = JsonUtil.getInfoFromJsonobject(stringExtra, "status_code");
        Object infoFromJsonobject2 = JsonUtil.getInfoFromJsonobject(stringExtra, "error_code");
        if (intent.hasExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI)) {
            Object infoFromJsonobject3 = JsonUtil.getInfoFromJsonobject(intent.getStringExtra(CommonCode.MapKey.HMS_FOREGROUND_RES_UI), "uiDuration");
            if (infoFromJsonobject3 instanceof Long) {
                j = ((Long) infoFromJsonobject3).longValue();
                if (!(infoFromJsonobject instanceof Integer) && (infoFromJsonobject2 instanceof Integer)) {
                    int intValue = ((Integer) infoFromJsonobject).intValue();
                    m933b(((Integer) infoFromJsonobject2).intValue());
                    this.f993k.setStatusCode(intValue);
                    m917a(this.f991i, this.f993k, j);
                } else {
                    m933b(-8);
                    m917a(this.f991i, this.f993k, j);
                }
                baseCallBack.onComplete(stringExtra, stringExtra2, null);
            }
        }
        j = 0;
        if (!(infoFromJsonobject instanceof Integer)) {
        }
        m933b(-8);
        m917a(this.f991i, this.f993k, j);
        baseCallBack.onComplete(stringExtra, stringExtra2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m914a(Activity activity, Parcelable parcelable, CoreBaseResponse coreBaseResponse) {
        HMSLog.m2120i("BaseAdapter", "startResolution");
        RequestHeader requestHeader = this.f992j;
        if (requestHeader != null) {
            m935b(this.f991i, requestHeader);
        }
        if (this.f994l == null) {
            m951g();
        }
        SystemManager.getSystemNotifier().registerObserver(this.f994l);
        if (Build.VERSION.SDK_INT >= 29) {
            m926a(coreBaseResponse);
        }
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, BaseResolutionAdapter.class.getName());
        Bundle bundle = new Bundle();
        bundle.putParcelable(CommonCode.MapKey.HAS_RESOLUTION, parcelable);
        intentStartBridgeActivity.putExtras(bundle);
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.TRANSACTION_ID, this.f990h);
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.RESOLUTION_FLAG, time);
        ResolutionFlagUtil.getInstance().saveResolutionFlag(this.f990h, time);
        activity.startActivity(intentStartBridgeActivity);
    }

    /* renamed from: a */
    private void m926a(final CoreBaseResponse coreBaseResponse) {
        HMSLog.m2120i("BaseAdapter", "postResolutionTimeoutHandle");
        ApkResolutionFailedManager.getInstance().postTask(this.f990h, new Runnable() { // from class: com.huawei.hms.adapter.BaseAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                HMSLog.m2120i("BaseAdapter", "postResolutionTimeoutHandle handle");
                SystemManager.getSystemNotifier().unRegisterObserver(BaseAdapter.this.f994l);
                ApkResolutionFailedManager.getInstance().removeValueOnly(BaseAdapter.this.f990h);
                BaseCallBack m931b = BaseAdapter.this.m931b();
                if (m931b == null) {
                    HMSLog.m2118e("BaseAdapter", "timeoutRunnable callBack is null");
                } else {
                    BaseAdapter.this.m920a(m931b, coreBaseResponse);
                }
            }
        });
    }

    /* renamed from: a */
    private void m915a(Context context, RequestHeader requestHeader) {
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getInstance().getMapFromRequestHeader(requestHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(requestHeader.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m916a(Context context, ResponseHeader responseHeader) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f992j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m917a(Context context, ResponseHeader responseHeader, long j) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> mapFromRequestHeader = HiAnalyticsUtil.getMapFromRequestHeader(responseHeader);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j));
        mapFromRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f992j.getKitSdkVersion())));
        mapFromRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, mapFromRequestHeader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public ResponseWrap m909a(int i, String str) {
        m942c(i);
        ResponseWrap responseWrap = new ResponseWrap(this.f993k);
        responseWrap.setBody(str);
        return responseWrap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public String m912a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i);
        } catch (JSONException e) {
            HMSLog.m2118e("BaseAdapter", "buildBodyStr failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m927a(String str) {
        this.f986d = str;
    }

    /* renamed from: a */
    private void m918a(Parcelable parcelable) {
        this.f988f = parcelable;
    }

    /* renamed from: a */
    private BaseCallBack m907a() {
        return this.f989g;
    }

    /* renamed from: a */
    private void m928a(String str, String str2, Parcelable parcelable, BaseCallBack baseCallBack) {
        m927a(str);
        m937b(str2);
        m918a(parcelable);
        m936b(baseCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m929a(Intent intent, BaseCallBack baseCallBack) {
        if (!intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            return false;
        }
        int intExtra = intent.getIntExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, 1001);
        if (intExtra == 1001) {
            HMSLog.m2120i("BaseAdapter", "privacy_statement_confirm_result agreed: " + intExtra + ", replay request");
            m954i();
            return true;
        }
        HMSLog.m2120i("BaseAdapter", "privacy_statement_confirm_result rejected: " + intExtra);
        baseCallBack.onError(m909a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE, m912a(CommonCode.BusInterceptor.PRIVACY_CNCEL_ERROR_CODE)).toJson());
        return true;
    }
}
