package com.bytedance.push.starter;

import android.util.Log;
import com.bytedance.applog.IDataObserver;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushDataObserver {
    public static IDataObserver iDataObserver = new IDataObserver() { // from class: com.bytedance.push.starter.PushDataObserver.1
        public void onIdLoaded(String str, String str2, String str3) {
            Log.d("PushStarter", "onIdLoaded");
            PushStarter.startPush();
        }

        public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
            Log.d("PushStarter", "onRemoteIdGet");
            PushStarter.startPush();
        }

        public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
            Log.d("PushStarter", "onRemoteIdGet");
        }

        public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
            Log.d("PushStarter", "onRemoteIdGet");
        }

        public void onAbVidsChange(String str, String str2) {
            Log.d("PushStarter", "onRemoteIdGet");
        }
    };
}
