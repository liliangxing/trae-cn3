package com.huawei.hms.adapter.p019ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.ApkResolutionFailedManager;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.RegionUtils;
import com.huawei.hms.utils.ResolutionFlagUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BaseResolutionAdapter implements IBridgeActivityDelegate {

    /* renamed from: a */
    private WeakReference<Activity> f1030a;

    /* renamed from: b */
    private String f1031b = "";

    /* renamed from: c */
    private long f1032c = 0;

    /* renamed from: a */
    private void m970a(long j) {
        if (!RegionUtils.isChinaROM(m973c())) {
            HMSLog.m2120i("BaseResolutionAdapter", "not ChinaROM");
            return;
        }
        Activity m973c = m973c();
        if (m973c == null || m973c.isFinishing()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("package", m973c.getPackageName());
        hashMap.put(CommonCode.MapKey.RESOLUTION_FLAG, this.f1032c + "-" + j);
        HiAnalyticsUtils.getInstance().onEvent(m973c, HiAnalyticsConstant.HMS_SDK_BASE_START_RESOLUTION, hashMap);
        HMSLog.m2118e("BaseResolutionAdapter", "check resolution flag failed, transactionId: " + this.f1031b + ", carriedTimeStamp: " + this.f1032c + ", savedTimeStamp: " + j);
    }

    /* renamed from: b */
    private void m972b() {
        Activity m973c = m973c();
        if (m973c == null || m973c.isFinishing()) {
            return;
        }
        m973c.finish();
    }

    /* renamed from: c */
    private Activity m973c() {
        WeakReference<Activity> weakReference = this.f1030a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* renamed from: d */
    private void m974d() {
        SystemManager.getInstance().notifyResolutionResult(null, this.f1031b);
        m972b();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBridgeActivityCreate(Activity activity) {
        Bundle bundle;
        if (activity == null) {
            HMSLog.m2118e("BaseResolutionAdapter", "activity is null");
            m974d();
            return;
        }
        if (activity.isFinishing()) {
            HMSLog.m2118e("BaseResolutionAdapter", "activity is finishing");
            return;
        }
        this.f1030a = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        if (intent == null) {
            m974d();
            return;
        }
        try {
            bundle = intent.getExtras();
            try {
                this.f1031b = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
                this.f1032c = intent.getLongExtra(CommonCode.MapKey.RESOLUTION_FLAG, 0L);
            } catch (Throwable th) {
                th = th;
                HMSLog.m2118e("BaseResolutionAdapter", "get transaction_id or resolution_flag exception:" + th.getClass().getSimpleName());
                if (m971a()) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bundle = null;
        }
        if (m971a()) {
            m974d();
            return;
        }
        if (this.f1031b != null && Build.VERSION.SDK_INT >= 29) {
            HMSLog.m2120i("BaseResolutionAdapter", "remove apk resolution failed task.");
            ApkResolutionFailedManager.getInstance().removeTask(this.f1031b);
        }
        if (bundle == null) {
            m974d();
            return;
        }
        Parcelable parcelable = bundle.getParcelable(CommonCode.MapKey.HAS_RESOLUTION);
        if (parcelable == null) {
            m974d();
            return;
        }
        if (parcelable instanceof Intent) {
            try {
                activity.startActivityForResult(IntentUtil.modifyIntentBehaviorsSafe((Intent) parcelable), 1001);
                return;
            } catch (Throwable unused) {
                m974d();
                HMSLog.m2118e("BaseResolutionAdapter", "ActivityNotFoundException:exception");
                return;
            }
        }
        if (parcelable instanceof PendingIntent) {
            try {
                activity.startIntentSenderForResult(((PendingIntent) parcelable).getIntentSender(), 1001, null, 0, 0, 0);
            } catch (IntentSender.SendIntentException unused2) {
                m974d();
                HMSLog.m2118e("BaseResolutionAdapter", "SendIntentException:exception");
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.m2120i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.f1030a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            return false;
        }
        HMSLog.m2120i("BaseResolutionAdapter", "onBridgeActivityResult, resultCode: " + i2);
        if (i2 == 1001 || i2 == 1002) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT, i2);
        }
        if (i2 != -1 && !intent.hasExtra(KpmsConstant.KIT_UPDATE_RESULT) && !intent.hasExtra(CommonCode.MapKey.PRIVACY_STATEMENT_CONFIRM_RESULT)) {
            SystemManager.getInstance().notifyResolutionResult(null, this.f1031b);
        } else {
            SystemManager.getInstance().notifyResolutionResult(intent, this.f1031b);
        }
        m972b();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.m2120i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.m2120i("BaseResolutionAdapter", "On key up when resolve conn error");
    }

    /* renamed from: a */
    private boolean m971a() {
        long resolutionFlag = ResolutionFlagUtil.getInstance().getResolutionFlag(this.f1031b);
        ResolutionFlagUtil.getInstance().removeResolutionFlag(this.f1031b);
        if (resolutionFlag != 0 && resolutionFlag == this.f1032c) {
            return true;
        }
        m970a(resolutionFlag);
        return false;
    }
}
