package com.bytedance.tobshadow.applog.simulate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.ArrayMap;
import android.widget.TextView;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.tobshadow.applog.AppLog;
import com.bytedance.tobshadow.applog.AppLogManager;
import com.bytedance.tobshadow.applog.C0355R;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import com.bytedance.tobshadow.applog.IPageMeta;
import com.bytedance.tobshadow.applog.annotation.PageMeta;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.AsyncTaskC0465l4;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0467m;
import java.lang.reflect.Field;
import java.util.Collections;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONException;
import org.json.JSONObject;

@PageMeta(path = "/simulateLaunch", title = "圈选/埋点验证")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SimulateLaunchActivity extends Activity implements IPageMeta {
    public static final String BIND_QUERY = "bind_query";
    public static final String DEBUG_LOG = "debug_log";
    public static final String KEY_URL_PREFIX = "url_prefix";
    public static final String KEY_URL_PREFIX_NO_QR = "url_prefix_no_qr";
    public static final int MODE_NO_QR = 1;
    public static final int MODE_QR = 0;
    public static String entryAppId = "";
    public static int entryMode = 0;
    public static String entryQrParam = "";
    public static String entryType = "";
    public static String entryUrlPrefix = "";

    /* renamed from: a */
    public TextView f416a;

    public static void startSimulatorWithoutQR(Context context, String str) {
        startSimulatorWithoutQR(context, AppLog.getAppId(), str);
    }

    public static void startSimulatorWithoutQR(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) SimulateLaunchActivity.class);
        intent.putExtra(KEY_URL_PREFIX_NO_QR, str2);
        intent.putExtra("aid_no_qr", str);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public final IAppLogLogger m237a() {
        IAppLogLogger logger = LoggerImpl.getLogger(entryAppId);
        return logger != null ? logger : LoggerImpl.global();
    }

    /* renamed from: com_bytedance_tobshadow_applog_simulate_SimulateLaunchActivity__onStop$___twin___ */
    public void m238xb199d24c() {
        super.onStop();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00fb  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        TextView textView;
        String str;
        boolean z;
        Intent launchIntentForPackage;
        ArrayMap arrayMap;
        boolean contains;
        super.onCreate(bundle);
        setContentView(C0355R.layout.applog_activity_simulate);
        this.f416a = (TextView) findViewById(C0355R.id.text_tip);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (intent.hasExtra(KEY_URL_PREFIX_NO_QR) && intent.hasExtra("aid_no_qr")) {
            entryMode = 1;
            entryUrlPrefix = intent.getStringExtra(KEY_URL_PREFIX_NO_QR);
            entryAppId = intent.getStringExtra("aid_no_qr");
        } else if (data != null) {
            entryMode = 0;
            entryAppId = data.getQueryParameter(Constant.KEY_AID);
            entryQrParam = data.getQueryParameter("qr_param");
            entryUrlPrefix = data.getQueryParameter(KEY_URL_PREFIX);
            String queryParameter = data.getQueryParameter(DBData.FIELD_TYPE);
            entryType = queryParameter;
            if (!DEBUG_LOG.equals(queryParameter)) {
                textView = this.f416a;
                str = "启动失败：type参数错误";
            } else if (C0411e.m376c(entryUrlPrefix)) {
                textView = this.f416a;
                str = "启动失败：缺少url_prefix参数";
            }
            textView.setText(str);
            return;
        }
        IAppLogInstance appLogManager = AppLogManager.getInstance(entryAppId);
        if (appLogManager != null && appLogManager.hasStarted()) {
            m237a().debug(Collections.singletonList("SimulateLaunchActivity"), "AppLog has started with appId:{}", entryAppId);
            new AsyncTaskC0465l4((C0467m) appLogManager).execute(new Void[0]);
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            arrayMap = (ArrayMap) declaredField.get(invoke);
        } catch (Throwable th) {
            m237a().debug(Collections.singletonList("SimulateLaunchActivity"), "Check has activity failed", th);
        }
        if (arrayMap != null && !arrayMap.isEmpty()) {
            if (arrayMap.size() == 1) {
                try {
                    contains = arrayMap.values().toArray()[0].toString().contains("com.bytedance.tobshadow.applog.simulate.SimulateLaunchActivity");
                } catch (Exception unused) {
                }
                if (!contains) {
                    z = true;
                    m237a().debug(Collections.singletonList("SimulateLaunchActivity"), "Simulator onCreate appId: {}, urlPrefix: {}, mode: {}, params: {}, activity exists: {}", entryAppId, entryUrlPrefix, Integer.valueOf(entryMode), entryQrParam, Boolean.valueOf(z));
                    if (!z && (launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getApplicationInfo().packageName)) != null) {
                        launchIntentForPackage.setPackage(null);
                        startActivity(launchIntentForPackage);
                    }
                    finish();
                }
            }
            contains = false;
            if (!contains) {
            }
        }
        z = false;
        m237a().debug(Collections.singletonList("SimulateLaunchActivity"), "Simulator onCreate appId: {}, urlPrefix: {}, mode: {}, params: {}, activity exists: {}", entryAppId, entryUrlPrefix, Integer.valueOf(entryMode), entryQrParam, Boolean.valueOf(z));
        if (!z) {
            launchIntentForPackage.setPackage(null);
            startActivity(launchIntentForPackage);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m236xa449f2f(this);
    }

    @Override // com.bytedance.tobshadow.applog.IPageMeta
    public JSONObject pageProperties() {
        try {
            return new JSONObject().put("class_name", "SimulateLaunchActivity");
        } catch (JSONException e) {
            m237a().debug(Collections.singletonList("SimulateLaunchActivity"), "JSON handle failed", e);
            return null;
        }
    }

    @Override // com.bytedance.tobshadow.applog.IPageMeta
    public String path() {
        return "/simulateLaunch";
    }

    @Override // com.bytedance.tobshadow.applog.IPageMeta
    public String title() {
        return "圈选/埋点验证";
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_tobshadow_applog_simulate_SimulateLaunchActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m236xa449f2f(SimulateLaunchActivity simulateLaunchActivity) {
        simulateLaunchActivity.m238xb199d24c();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                simulateLaunchActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
