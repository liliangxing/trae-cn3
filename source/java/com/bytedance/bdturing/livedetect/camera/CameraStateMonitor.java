package com.bytedance.bdturing.livedetect.camera;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.livedetect.LiveDetectService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CameraStateMonitor {
    private static final String TAG = "CameraStateMonitor";
    private static volatile CameraStateMonitor sInstance;
    private final int MAX_EVENT_SIZE = 100;
    private List<CameraStateEvent> mEventList = new ArrayList();

    private CameraStateMonitor() {
    }

    public static CameraStateMonitor getInstance() {
        if (sInstance == null) {
            synchronized (CameraStateMonitor.class) {
                if (sInstance == null) {
                    sInstance = new CameraStateMonitor();
                }
            }
        }
        return sInstance;
    }

    public synchronized void recordCameraState(String str, String str2) {
        try {
            List<CameraStateEvent> list = this.mEventList;
            if (list != null && list.size() < 100) {
                CameraStateEvent cameraStateEvent = new CameraStateEvent();
                cameraStateEvent.eventName = str;
                cameraStateEvent.f100ts = System.currentTimeMillis();
                if (str2 == null) {
                    str2 = "";
                }
                cameraStateEvent.msg = str2;
                this.mEventList.add(cameraStateEvent);
            }
        } finally {
        }
    }

    public synchronized void clearEvent() {
        try {
            List<CameraStateEvent> list = this.mEventList;
            if (list != null && list.size() > 0) {
                this.mEventList.clear();
            }
        } finally {
        }
    }

    public synchronized void reportCameraState() {
        try {
            List<CameraStateEvent> list = this.mEventList;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < this.mEventList.size(); i++) {
                    CameraStateEvent cameraStateEvent = this.mEventList.get(i);
                    JSONObject jSONObject = new JSONObject();
                    if (cameraStateEvent != null) {
                        jSONObject.put("eventName", cameraStateEvent.eventName);
                        jSONObject.put("msg", cameraStateEvent.msg);
                        jSONObject.put("ts", cameraStateEvent.f100ts);
                    }
                    jSONArray.put(jSONObject);
                }
                EventReport.liveCameraState(jSONArray.toString(), LiveDetectService.getInstance().getRequest());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
