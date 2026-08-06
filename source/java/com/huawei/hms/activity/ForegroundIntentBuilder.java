package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.utils.Util;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ForegroundIntentBuilder {

    /* renamed from: a */
    private Activity f961a;

    /* renamed from: b */
    private RequestHeader f962b;

    /* renamed from: c */
    private String f963c;

    /* renamed from: d */
    private ForegroundInnerHeader f964d;

    /* renamed from: e */
    private String f965e;

    /* renamed from: f */
    private Context f966f;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.f961a = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.f962b = requestHeader;
            requestHeader.setSdkVersion(61300301);
            this.f963c = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.f964d = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        String packageName;
        String appId;
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.f961a, ForegroundBusDelegate.class.getName());
        Context context = this.f966f;
        if (context != null) {
            packageName = context.getPackageName();
            appId = Util.getAppId(this.f966f);
        } else {
            packageName = this.f961a.getPackageName();
            appId = Util.getAppId(this.f961a);
        }
        if (this.f962b.getAppID() == null) {
            this.f962b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        } else {
            this.f962b.setAppID(appId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f962b.getAppID());
        }
        if (TextUtils.isEmpty(this.f962b.getTransactionId())) {
            RequestHeader requestHeader = this.f962b;
            requestHeader.setTransactionId(TransactionIdCreater.getId(requestHeader.getAppID(), CoreNaming.HUBREQUEST));
        }
        this.f962b.setPkgName(packageName);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.f962b.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.f963c);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.f964d.toJson());
        if (!TextUtils.isEmpty(this.f965e)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.f965e);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.f962b.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i) {
        this.f962b.setApiLevel(i);
        return this;
    }

    public ForegroundIntentBuilder setApplicationContext(Context context) {
        this.f966f = context;
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.f965e = this.f961a.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i) {
        this.f962b.setKitSdkVersion(i);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i) {
        this.f964d.setApkVersion(i);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.f963c = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.f964d.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.f962b.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.f962b.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.f962b.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.f964d.setResponseCallbackKey(str);
        return this;
    }
}
