package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import com.bytedance.bdinstall.util.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventUtils {
    public static final String TAG = "EventTracking#";
    private static volatile EventUtils instance;
    private final Map<String, Map<String, Monitor>> monitorMap = new ConcurrentHashMap();

    public static void onDidFetchResult(InstallOptions installOptions, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        boolean z = (jSONObject2 == null || TextUtils.isEmpty(jSONObject2.optString("device_id_str"))) ? false : true;
        JSONObject optJSONObject = jSONObject.optJSONObject(Oaid.KEY_OAID_ID);
        String str = null;
        OaidModel create = optJSONObject != null ? OaidModel.create(optJSONObject.toString()) : null;
        boolean isEmpty = TextUtils.isEmpty(jSONObject.optString("install_id"));
        boolean isEmpty2 = TextUtils.isEmpty(jSONObject.optString("device_id"));
        try {
            jSONObject3.put("reqeust_did_success", z);
            jSONObject3.put("empty_iid", isEmpty);
            jSONObject3.put("empty_did", isEmpty2);
            if (create != null) {
                str = create.oaid;
            }
            jSONObject3.put("dr_oaid", str);
            jSONObject3.put("oaid_thread_switch_ts", OaidMonitor.getReadStartInitTs() - OaidMonitor.getInitTs());
            jSONObject3.put("oaid_file_load_ts", OaidMonitor.getStartSystemCall() - OaidMonitor.getReadStartInitTs());
            jSONObject3.put("oaid_sys_call_ts", OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());
            jSONObject3.put("oaid_save_ts", OaidMonitor.getOnFinishFetchOaid() - OaidMonitor.getSystemCallFinished());
            jSONObject3.put("dr_wait_oaid_realtime", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());
            jSONObject3.put("dr_wait_oaid_estimate_time", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());
            jSONObject3.put("support_oaid", jSONObject.optBoolean(SstLoader.KEY_OAID_SUPPORT));
            jSONObject3.put("oaid_impl", Oaid.instance(installOptions.getContext()).getImplName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (installOptions != null && installOptions.getEventDepend() != null) {
            installOptions.getEventDepend().onEvent("did_fetch_result", jSONObject3);
        }
        DrLog.m139d("did_fetch_result, " + jSONObject3);
    }

    private EventUtils() {
    }

    public static EventUtils getInstance() {
        if (instance == null) {
            synchronized (EventUtils.class) {
                if (instance == null) {
                    instance = new EventUtils();
                }
            }
        }
        return instance;
    }

    public void setMonitors(int i) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(Constants.Events.KEY_REGISTER, new RegisterMonitor());
        concurrentHashMap.put(Constants.Events.KEY_ACTIVATE, new ActivateMonitor());
        concurrentHashMap.put(Constants.Events.KEY_PARAMS, new ParamsMonitor());
        this.monitorMap.put(String.valueOf(i), concurrentHashMap);
    }

    public ParamsMonitor getParamsMonitor(int i) {
        Map<String, Monitor> map = this.monitorMap.get(String.valueOf(i));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.monitorMap.put(String.valueOf(i), map);
        }
        ParamsMonitor paramsMonitor = (ParamsMonitor) map.get(Constants.Events.KEY_PARAMS);
        if (paramsMonitor != null) {
            return paramsMonitor;
        }
        ParamsMonitor paramsMonitor2 = new ParamsMonitor();
        map.put(Constants.Events.KEY_PARAMS, paramsMonitor2);
        return paramsMonitor2;
    }

    public RegisterMonitor getRegisterMonitor(int i) {
        Map<String, Monitor> map = this.monitorMap.get(String.valueOf(i));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.monitorMap.put(String.valueOf(i), map);
        }
        RegisterMonitor registerMonitor = (RegisterMonitor) map.get(Constants.Events.KEY_REGISTER);
        if (registerMonitor != null) {
            return registerMonitor;
        }
        RegisterMonitor registerMonitor2 = new RegisterMonitor();
        map.put(Constants.Events.KEY_REGISTER, registerMonitor2);
        return registerMonitor2;
    }

    public ActivateMonitor getActivateMonitor(int i) {
        Map<String, Monitor> map = this.monitorMap.get(String.valueOf(i));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.monitorMap.put(String.valueOf(i), map);
        }
        ActivateMonitor activateMonitor = (ActivateMonitor) map.get(Constants.Events.KEY_ACTIVATE);
        if (activateMonitor != null) {
            return activateMonitor;
        }
        ActivateMonitor activateMonitor2 = new ActivateMonitor();
        map.put(Constants.Events.KEY_ACTIVATE, activateMonitor2);
        return activateMonitor2;
    }

    public VerifyMonitor getVerifyMonitor(int i) {
        Map<String, Monitor> map = this.monitorMap.get(String.valueOf(i));
        if (map == null) {
            map = new ConcurrentHashMap<>();
            this.monitorMap.put(String.valueOf(i), map);
        }
        VerifyMonitor verifyMonitor = (VerifyMonitor) map.get(Constants.Events.KEY_VERIFY);
        if (verifyMonitor != null) {
            return verifyMonitor;
        }
        VerifyMonitor verifyMonitor2 = new VerifyMonitor();
        map.put(Constants.Events.KEY_VERIFY, verifyMonitor2);
        return verifyMonitor2;
    }

    public static void onRegisterParams(InstallOptions installOptions) {
        getInstance().getParamsMonitor(installOptions.getAid()).onEvent(installOptions, Constants.Events.DR_REGISTER_PARAM);
    }

    public static void onRegisterResult(InstallOptions installOptions) {
        getInstance().getRegisterMonitor(installOptions.getAid()).onEvent(installOptions, Constants.Events.DR_REGISTER_RESULT);
    }

    public static void onActiveResult(InstallOptions installOptions) {
        getInstance().getActivateMonitor(installOptions.getAid()).onEvent(installOptions, Constants.Events.DR_ACTIVATE_RESULT);
    }

    public static void onVerifyResult(InstallOptions installOptions) {
        if (BDInstall.getBDInstallConfig().isEnableDidGuard()) {
            getInstance().getVerifyMonitor(installOptions.getAid()).onEvent(installOptions, Constants.Events.DR_VERIFY_RESULT);
        }
    }
}
