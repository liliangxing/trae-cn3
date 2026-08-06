package com.bytedance.apm.doctor;

import android.text.TextUtils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.ss.android.common.util.ToolUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DoctorDataUtil {
    public static final String KEY_DATA = "data";
    public static final String KEY_LIST = "list";
    private static AtomicInteger eventNum = new AtomicInteger(0);

    public static void onReceivedEvent(String str, JSONObject jSONObject, boolean z) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DoctorConstants.DATA_DOCTOR);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        try {
            if (optJSONObject.optInt(DoctorConstants.DATA_ID, -1) == -1) {
                optJSONObject.put(DoctorConstants.DATA_ID, eventNum.incrementAndGet());
            }
            optJSONObject.put(DoctorConstants.DATA_PROCESS, ToolUtils.getCurProcessName(ApmContext.getContext()));
            optJSONObject.put(DoctorConstants.DATA_TYPE, str);
            optJSONObject.put(DoctorConstants.DATA_SAMPLE, z);
            optJSONObject.put(DoctorConstants.DATA_AID, ApmContext.getAid());
            jSONObject.put(DoctorConstants.DATA_DOCTOR, optJSONObject);
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_RECEIVE, jSONObject2);
            DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_CACHE, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void onDowngradeEvent(String str, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(DoctorConstants.DATA_DOCTOR);
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        try {
            if (optJSONObject.optInt(DoctorConstants.DATA_ID, -1) == -1) {
                optJSONObject.put(DoctorConstants.DATA_ID, eventNum.incrementAndGet());
            }
            optJSONObject.put(DoctorConstants.DATA_PROCESS, ToolUtils.getCurProcessName(ApmContext.getContext()));
            optJSONObject.put(DoctorConstants.DATA_TYPE, str);
            optJSONObject.put(DoctorConstants.DATA_AID, ApmContext.getAid());
            jSONObject.put(DoctorConstants.DATA_DOCTOR, optJSONObject);
            DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_DOWNGRADE, new JSONObject(jSONObject.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveToFileEvent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            DoctorManager.getInstance().onDataEvent(DoctorConstants.DATA_SAVE_TO_DB, new JSONObject(jSONObject.toString()));
        } catch (Exception unused) {
        }
    }

    public static void sendBeginEvent(byte[] bArr) {
        List<JSONObject> jSONObject = toJSONObject(bArr);
        if (jSONObject == null) {
            return;
        }
        Iterator<JSONObject> it = jSONObject.iterator();
        while (it.hasNext()) {
            sendEvent(it.next(), DoctorConstants.DATA_SEND_BEGIN);
        }
    }

    public static void sendSuccessEvent(byte[] bArr) {
        for (JSONObject jSONObject : toJSONObject(bArr)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(DoctorConstants.DATA_DOCTOR);
                if (optJSONObject != null) {
                    optJSONObject.put(DoctorConstants.DATA_SEND_RESULT, 200);
                }
            } catch (Exception unused) {
            }
            sendEvent(jSONObject, DoctorConstants.DATA_SEND_SUCCESS);
            sendEvent(jSONObject, DoctorConstants.DATA_SEND_END);
        }
    }

    public static void sendFailEvent(byte[] bArr) {
        for (JSONObject jSONObject : toJSONObject(bArr)) {
            sendEvent(jSONObject, DoctorConstants.DATA_SEND_FAIL);
            sendEvent(jSONObject, DoctorConstants.DATA_SEND_END);
        }
    }

    public static void sendResponseEvent(byte[] bArr, JSONObject jSONObject) {
        for (JSONObject jSONObject2 : toJSONObject(bArr)) {
            try {
                JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                JSONObject optJSONObject = jSONObject2.optJSONObject(DoctorConstants.DATA_DOCTOR);
                if (optJSONObject != null) {
                    jSONObject3.put(DoctorConstants.DATA_DOCTOR, optJSONObject);
                }
                sendEvent(jSONObject3, DoctorConstants.DATA_SEND_RESPONSE);
                sendEvent(jSONObject2.put(ApmTrafficStats.TTNET_RESPONSE, jSONObject3), DoctorConstants.DATA_SEND_RESPONSE_NEW);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void sendEvent(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return;
        }
        try {
            DoctorManager.getInstance().onDataEvent(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    private static List<JSONObject> toJSONObject(byte[] bArr) {
        JSONArray optJSONArray;
        if (bArr == null) {
            return null;
        }
        String str = new String(bArr);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("list")) {
                JSONArray optJSONArray2 = jSONObject.optJSONArray("list");
                if (optJSONArray2 == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                    if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("data")) != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.getJSONObject(i2));
                        }
                    }
                }
            } else {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("data");
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    arrayList.add(optJSONArray3.getJSONObject(i3));
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
