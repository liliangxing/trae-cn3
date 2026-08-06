package com.lynx.devtoolwrapper;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Toast;
import com.heytap.mcssdk.constant.C0879b;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.service.ILynxDevToolService;
import com.lynx.tasm.service.LynxServiceCenter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxDevtoolGlobalHelper {
    private static final String TAG = "LynxDevtoolGlobalHelper";
    private static ILynxDevToolService sDevToolService;
    private Map<String, String> mAppInfo;
    private Context mContext;
    private boolean remoteDebugAvailable;

    @Deprecated
    public void showDebugView(ViewGroup viewGroup) {
    }

    public static LynxDevtoolGlobalHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class SingletonHolder {
        private static final LynxDevtoolGlobalHelper INSTANCE = new LynxDevtoolGlobalHelper();

        private SingletonHolder() {
        }
    }

    private LynxDevtoolGlobalHelper() {
        this.remoteDebugAvailable = false;
        HashMap hashMap = new HashMap();
        this.mAppInfo = hashMap;
        hashMap.put(C0879b.f554C, LynxEnv.inst().getLynxVersion());
        if (LynxEnv.inst().isLynxDebugEnabled()) {
            initRemoteDebugIfNecessary();
            sDevToolService = LynxServiceCenter.inst().getService(ILynxDevToolService.class);
        }
    }

    private boolean initRemoteDebugIfNecessary() {
        if (!LynxEnv.inst().isLynxDebugEnabled()) {
            return false;
        }
        if (!LynxEnv.inst().isNativeLibraryLoaded()) {
            Context context = this.mContext;
            if (context != null) {
                Toast.makeText(context, "Lynx initialization not finished!", 0).show();
            }
            LLog.m2580w(TAG, "liblynx.so not loaded!");
            return false;
        }
        if (this.remoteDebugAvailable) {
            return true;
        }
        if (LynxEnv.inst().isLaunchRecordEnabled()) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService != null) {
                iLynxDevToolService.globalDebugBridgeStartRecord();
            } else {
                LLog.m2577e(TAG, "failed to get DevToolService");
                return this.remoteDebugAvailable;
            }
        }
        this.remoteDebugAvailable = true;
        return true;
    }

    public void setAppInfo(Context context, Map<String, String> map) {
        if (map != null) {
            this.mAppInfo.putAll(map);
        }
        if (initRemoteDebugIfNecessary()) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService != null) {
                iLynxDevToolService.globalDebugBridgeSetAppInfo(context, this.mAppInfo);
            } else {
                LLog.m2577e(TAG, "failed to get DevToolService");
            }
        }
    }

    public void setAppInfo(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App", str);
        hashMap.put("AppVersion", str2);
        setAppInfo(context, hashMap);
    }

    @Deprecated
    public void setAppInfo(String str, String str2) {
        setAppInfo(null, str, str2);
    }

    public boolean isRemoteDebugAvailable() {
        return this.remoteDebugAvailable;
    }

    public boolean shouldPrepareRemoteDebug(String str) {
        if (!initRemoteDebugIfNecessary()) {
            return false;
        }
        ILynxDevToolService iLynxDevToolService = sDevToolService;
        if (iLynxDevToolService != null) {
            return iLynxDevToolService.globalDebugBridgeShouldPrepareRemoteDebug(str).booleanValue();
        }
        LLog.m2577e(TAG, "failed to get DevToolService");
        return false;
    }

    public boolean prepareRemoteDebug(String str) {
        if (!initRemoteDebugIfNecessary()) {
            return false;
        }
        if (!LynxEnv.inst().isLynxDebugEnabled()) {
            Context context = this.mContext;
            if (context != null) {
                Toast.makeText(context, "Debugging not supported in this package", 0).show();
            }
            LLog.m2580w(TAG, "Debugging not supported in this package");
            return false;
        }
        if (!LynxEnv.inst().isDevtoolEnabled()) {
            Context context2 = this.mContext;
            if (context2 != null) {
                Toast.makeText(context2, "DevTool not enabled, turn on the switch!", 0).show();
            }
            LLog.m2580w(TAG, "DevTool not enabled, turn on the switch!");
            return false;
        }
        setAppInfo(this.mContext, (Map<String, String>) null);
        ILynxDevToolService iLynxDevToolService = sDevToolService;
        if (iLynxDevToolService != null) {
            return iLynxDevToolService.globalDebugBridgePrepareRemoteDebug(str).booleanValue();
        }
        LLog.m2577e(TAG, "failed to get DevToolService");
        return false;
    }

    public void setContext(Context context) {
        this.mContext = context;
        if (initRemoteDebugIfNecessary()) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService != null) {
                iLynxDevToolService.globalDebugBridgeSetContext(context);
            } else {
                LLog.m2577e(TAG, "failed to get DevToolService");
            }
        }
    }

    public void registerCardListener(LynxDevtoolCardListener lynxDevtoolCardListener) {
        if (initRemoteDebugIfNecessary()) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService != null) {
                iLynxDevToolService.globalDebugBridgeRegisterCardListener(lynxDevtoolCardListener);
            } else {
                LLog.m2577e(TAG, "failed to get DevToolService");
            }
        }
    }

    public void onPerfMetricsEvent(String str, JSONObject jSONObject, int i) {
        if (this.remoteDebugAvailable) {
            ILynxDevToolService iLynxDevToolService = sDevToolService;
            if (iLynxDevToolService != null) {
                iLynxDevToolService.globalDebugBridgeOnPerfMetricsEvent(str, jSONObject, i);
            } else {
                LLog.m2577e(TAG, "failed to get DevToolService");
            }
        }
    }
}
