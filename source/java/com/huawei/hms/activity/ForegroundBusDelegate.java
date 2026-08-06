package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* renamed from: a */
    private RequestHeader f954a;

    /* renamed from: b */
    private String f955b;

    /* renamed from: c */
    private ForegroundInnerHeader f956c = new ForegroundInnerHeader();

    /* renamed from: d */
    private ResponseHeader f957d;

    /* renamed from: e */
    private WeakReference<Activity> f958e;

    /* renamed from: f */
    private boolean f959f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.activity.ForegroundBusDelegate$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1012b implements AvailableAdapter.AvailableCallBack {
        private C1012b() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            if (i == 0) {
                ForegroundBusDelegate.this.m900h();
            } else {
                HMSLog.m2120i("ForegroundBusDelegate", "version check failed");
                ForegroundBusDelegate.this.m888a(0, "apk version is invalid");
            }
        }
    }

    /* renamed from: b */
    private BusResponseCallback m893b(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    /* renamed from: c */
    private void m895c() {
        if (this.f954a != null) {
            m892a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        }
    }

    /* renamed from: d */
    private void m896d() {
        m892a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    /* renamed from: e */
    private void m897e() {
        if (m899g() == null) {
            HMSLog.m2118e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
            m888a(0, "checkMinVersion failed, activity must not be null.");
            return;
        }
        if (this.f959f) {
            m900h();
            return;
        }
        if (!Util.isAvailableLibExist(m899g().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(m899g().getApplicationContext(), this.f956c.getApkVersion()) != 0) {
                HMSLog.m2118e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
                m888a(0, "apk version is invalid");
                return;
            } else {
                m900h();
                return;
            }
        }
        C1012b c1012b = new C1012b();
        AvailableAdapter availableAdapter = new AvailableAdapter(this.f956c.getApkVersion());
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(m899g());
        if (isHuaweiMobileServicesAvailable == 0) {
            c1012b.onComplete(isHuaweiMobileServicesAvailable);
        } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            m889a(m899g(), availableAdapter, c1012b);
        } else {
            c1012b.onComplete(isHuaweiMobileServicesAvailable);
        }
    }

    /* renamed from: f */
    private void m898f() {
        Activity m899g = m899g();
        if (m899g == null || m899g.isFinishing()) {
            return;
        }
        m899g.finish();
    }

    /* renamed from: g */
    private Activity m899g() {
        WeakReference<Activity> weakReference = this.f958e;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m900h() {
        String hMSPackageNameForMultiService;
        HMSLog.m2120i("ForegroundBusDelegate", "startApkHubActivity");
        Activity m899g = m899g();
        if (m899g == null) {
            HMSLog.m2118e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
            return;
        }
        if (this.f959f) {
            hMSPackageNameForMultiService = m899g.getPackageName();
        } else {
            hMSPackageNameForMultiService = HMSPackageManager.getInstance(m899g.getApplicationContext()).getHMSPackageNameForMultiService();
        }
        if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
            HMSLog.m2118e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
            m888a(0, "hmsPackageName is null, Service is invalid.");
            return;
        }
        Intent intent = new Intent(this.f956c.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.f955b);
        try {
            intent.setPackage(hMSPackageNameForMultiService);
        } catch (IllegalArgumentException unused) {
            HMSLog.m2118e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(m899g));
        intent.setClassName(hMSPackageNameForMultiService, "com.huawei.hms.core.activity.UiJumpActivity");
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f954a.toJson());
        intent.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        try {
            m894b();
            m899g.startActivityForResult(intent, 431057);
        } catch (ActivityNotFoundException e) {
            HMSLog.m2119e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e);
            m888a(0, "launch bus intent failed");
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.m2118e("ForegroundBusDelegate", "activity is null");
            m888a(0, "activity is null");
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m2118e("ForegroundBusDelegate", "activity is finishing");
            m888a(0, "activity is finishing");
            return;
        }
        this.f958e = new WeakReference<>(activity);
        try {
            Intent intent = activity.getIntent();
            if (intent == null) {
                m888a(0, "intent is invalid");
                return;
            }
            String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
            RequestHeader requestHeader = new RequestHeader();
            this.f954a = requestHeader;
            if (!requestHeader.fromJson(stringExtra)) {
                m888a(0, "header is invalid");
                return;
            }
            this.f955b = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
            ForegroundInnerHeader foregroundInnerHeader = this.f956c;
            if (foregroundInnerHeader == null) {
                m888a(0, "inner header is invalid");
                return;
            }
            foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
            if (TextUtils.isEmpty(this.f954a.getApiName())) {
                m888a(0, "action is invalid");
                return;
            }
            m886a();
            if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
                HMSLog.m2120i("ForegroundBusDelegate", "isUseInnerHms: true");
                this.f959f = true;
            }
            m897e();
        } catch (Throwable th) {
            HMSLog.m2118e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
            m888a(0, "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        m895c();
        this.f958e = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        String str;
        if (i != 431057) {
            return false;
        }
        if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
            try {
                str = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
            } catch (Throwable unused) {
                HMSLog.m2121w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
                str = "";
            }
            ResponseHeader responseHeader = new ResponseHeader();
            this.f957d = responseHeader;
            JsonUtil.jsonToEntity(str, responseHeader);
        }
        m896d();
        BusResponseCallback m893b = m893b(this.f956c.getResponseCallbackKey());
        if (m893b == null) {
            m887a(i2, intent);
            return true;
        }
        BusResponseResult succeedReturn = m893b.succeedReturn(this.f958e.get(), i2, intent);
        if (succeedReturn == null) {
            m887a(i2, intent);
            return true;
        }
        m887a(succeedReturn.getCode(), succeedReturn.getIntent());
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
    }

    /* renamed from: b */
    private void m894b() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f954a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f954a.getKitSdkVersion())));
        if (m899g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m899g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m887a(int i, Intent intent) {
        HMSLog.m2120i("ForegroundBusDelegate", "succeedReturn");
        Activity m899g = m899g();
        if (m899g == null) {
            return;
        }
        m899g.setResult(i, IntentUtil.modifyIntentBehaviorsSafe(intent));
        m898f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m888a(int i, String str) {
        HMSLog.m2118e("ForegroundBusDelegate", str);
        Activity m899g = m899g();
        if (m899g == null) {
            return;
        }
        BusResponseCallback m893b = m893b(this.f956c.getResponseCallbackKey());
        if (m893b != null) {
            BusResponseResult innerError = m893b.innerError(this.f958e.get(), i, str);
            if (innerError == null) {
                m899g.setResult(0);
            } else {
                m899g.setResult(innerError.getCode(), IntentUtil.modifyIntentBehaviorsSafe(innerError.getIntent()));
            }
        } else {
            m899g.setResult(0);
        }
        m898f();
    }

    /* renamed from: a */
    private static void m889a(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.m2120i("ForegroundBusDelegate", "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* renamed from: a */
    private void m886a() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f954a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f954a.getKitSdkVersion())));
        if (m899g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m899g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    /* renamed from: a */
    private void m892a(String str) {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f954a);
        mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f954a.getKitSdkVersion())));
        ResponseHeader responseHeader = this.f957d;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.f957d.getErrorCode()));
        }
        if (m899g() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(m899g().getApplicationContext(), str, mapFromForegroundRequestHeader);
        }
    }
}
