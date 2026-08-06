package com.bytedance.common;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MainProcessEventService extends Service {
    public static String KEY_EVENT_NAME = "event_name";
    public static String KEY_EVENT_PARAMS = "event_params";

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Logger.d("MainProcessEventServiceTag", "onBind");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        String string = extras.getString(KEY_EVENT_NAME);
        String string2 = extras.getString(KEY_EVENT_PARAMS);
        try {
            Logger.d("MainProcessEventServiceTag", "report " + string + " :" + string2);
            PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonEventSender.onEventV3(string, new JSONObject(string2));
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
