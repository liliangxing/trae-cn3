package cn.com.chinatelecom.account.api;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.p006a.C0678d;
import cn.com.chinatelecom.account.api.p007b.C0680b;
import cn.com.chinatelecom.account.api.p007b.InterfaceC0679a;
import cn.com.chinatelecom.account.api.p008c.C0681a;
import cn.com.chinatelecom.account.api.p009d.C0688c;
import cn.com.chinatelecom.account.api.p010e.C0695b;
import cn.com.chinatelecom.account.api.p010e.C0699f;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import cn.com.chinatelecom.account.api.p010e.C0703j;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CtAuth {
    private static final String TAG = "CtAuth";
    private static volatile CtAuth instance = null;
    public static boolean isInit = false;
    public static String mAppId = "";
    public static String mAppSecret = "";
    public static Context mContext;
    public static Handler mHandler = new Handler(Looper.getMainLooper());
    public static TraceLogger mTraceLogger;

    public static CtAuth getInstance() {
        if (instance == null) {
            synchronized (CtAuth.class) {
                if (instance == null) {
                    instance = new CtAuth();
                }
            }
        }
        return instance;
    }

    public static void info(String str, String str2) {
        if (mTraceLogger != null) {
            mTraceLogger.info("CT_" + str, str2);
        }
    }

    public static void postResultOnMainThread(final String str, final JSONObject jSONObject, final ResultListener resultListener) {
        mHandler.post(new Runnable() { // from class: cn.com.chinatelecom.account.api.CtAuth.1
            @Override // java.lang.Runnable
            public void run() {
                if (ResultListener.this != null) {
                    try {
                        String str2 = str;
                        if (str2 != null) {
                            jSONObject.put("reqId", str2);
                        }
                        ResultListener.this.onResult(jSONObject.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    C0699f.m335c(str);
                }
            }
        });
    }

    public static void warn(String str, String str2, Throwable th) {
        if (mTraceLogger != null) {
            mTraceLogger.warn("CT_" + str, str2, th);
        }
    }

    public Context getContext() {
        return mContext;
    }

    public String getOperatorType() {
        Context context = mContext;
        if (context != null) {
            return C0700g.m339a(context, false);
        }
        throw new IllegalArgumentException("Please call the init method");
    }

    public void getPreCodeParamsByJs(String str, InterfaceC0679a interfaceC0679a) {
        info(TAG, "called getPreCodeParamsByJs()");
        if (interfaceC0679a == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
            interfaceC0679a.callbackPreCodeParams(C0703j.m369e().toString());
        } else {
            new C0680b().m198a(str, interfaceC0679a);
        }
    }

    public void init(Context context, String str, String str2, TraceLogger traceLogger) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null!");
        }
        if (str == null) {
            throw new IllegalArgumentException("appId must not be null!");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("appSecret must not be null!");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        mContext = context;
        C0688c.m246a(mContext);
        mAppId = str;
        mAppSecret = str2;
        mTraceLogger = traceLogger;
    }

    public boolean isMobileDataEnabled() {
        Context context = mContext;
        if (context != null) {
            return C0700g.m345d(context);
        }
        throw new IllegalArgumentException("Please call the init method");
    }

    @Deprecated
    public void requestPreCode(CtSetting ctSetting, ResultListener resultListener) {
        requestPreLogin(ctSetting, resultListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestPreCodeByJs(String str, InterfaceC0679a interfaceC0679a) {
        JSONObject m369e;
        String str2;
        String str3;
        JSONObject jSONObject;
        info(TAG, "called requestPreCodeByJs()");
        if (interfaceC0679a == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
            m369e = C0703j.m369e();
        } else {
            String str4 = null;
            if (TextUtils.isEmpty(str)) {
                str3 = null;
            } else {
                try {
                    jSONObject = new JSONObject(str);
                    str2 = jSONObject.optString(StreamTrafficObservable.STREAM_URL);
                } catch (Exception e) {
                    e = e;
                    str2 = null;
                }
                try {
                    str4 = jSONObject.optString("taskId");
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    String str5 = str4;
                    str4 = str2;
                    str3 = str5;
                    if (TextUtils.isEmpty(str4)) {
                    }
                }
                String str52 = str4;
                str4 = str2;
                str3 = str52;
            }
            if (TextUtils.isEmpty(str4)) {
                if (C0700g.m343c(mContext)) {
                    new C0680b().m199a(str3, str4, interfaceC0679a);
                    return;
                } else if (C0700g.m345d(mContext)) {
                    new C0680b().m200b(str3, str4, interfaceC0679a);
                    return;
                } else {
                    interfaceC0679a.callbackPreCode(C0703j.m368d().toString());
                    return;
                }
            }
            m369e = C0703j.m370f();
        }
        interfaceC0679a.callbackPreCode(m369e.toString());
    }

    public void requestPreLogin(CtSetting ctSetting, int i, ResultListener resultListener) {
        JSONObject m369e;
        info(TAG, "called requestPreLogin()");
        if (resultListener == null) {
            return;
        }
        if (mContext == null || TextUtils.isEmpty(mAppId) || TextUtils.isEmpty(mAppSecret)) {
            m369e = C0703j.m369e();
        } else {
            if (C0700g.m341b(mContext)) {
                if (C0700g.m343c(mContext)) {
                    new C0681a(mContext, mAppId, mAppSecret).m218a(C0678d.m189a(C0695b.f254e), ctSetting, i, resultListener);
                    return;
                } else if (C0700g.m345d(mContext)) {
                    new C0681a(mContext, mAppId, mAppSecret).m219b(C0678d.m189a(C0695b.f254e), ctSetting, i, resultListener);
                    return;
                } else {
                    postResultOnMainThread(null, C0703j.m368d(), resultListener);
                    return;
                }
            }
            m369e = C0703j.m363a();
        }
        postResultOnMainThread(null, m369e, resultListener);
    }

    public void requestPreLogin(CtSetting ctSetting, ResultListener resultListener) {
        requestPreLogin(ctSetting, C0674a.f116d, resultListener);
    }

    public void setDomainName(String str, String str2, String str3) {
        C0700g.f290a = str;
        C0700g.f291b = str2;
        C0700g.f292c = str3;
    }
}
