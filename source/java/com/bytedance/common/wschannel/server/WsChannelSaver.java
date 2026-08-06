package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.model.SsWsApp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelSaver implements IWsChannelSaver {
    private static final String TAG = "WsChannelSaver";
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WsChannelSaver(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public Map<Integer, IWsApp> loadWsChannels() {
        String wsApp;
        JSONArray jSONArray;
        int length;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            wsApp = WsChannelSettings.inst(this.mContext).getWsApp();
            if (Logger.debug()) {
                Logger.m190d(TAG, "load from sp wsAppStr: " + wsApp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(wsApp) || (length = (jSONArray = new JSONArray(wsApp)).length()) <= 0) {
            return linkedHashMap;
        }
        ArrayList<Integer> autoConnectDisabledChannelIds = WsChannelSettings.inst(this.mContext).getAutoConnectDisabledChannelIds();
        if (Logger.debug()) {
            Logger.m190d(TAG, "load from sp disabledList: " + autoConnectDisabledChannelIds);
        }
        for (int i = 0; i < length; i++) {
            SsWsApp buildFromJson = new SsWsApp.SsWsAppBuilder().buildFromJson(jSONArray.optJSONObject(i));
            if (checkValidWsApp(buildFromJson) && (autoConnectDisabledChannelIds == null || !autoConnectDisabledChannelIds.contains(Integer.valueOf(WsChannelService.getClientKey(buildFromJson))))) {
                linkedHashMap.put(Integer.valueOf(WsChannelService.getClientKey(buildFromJson)), buildFromJson);
            }
        }
        if (Logger.debug()) {
            Logger.m190d(TAG, "loadWsChannels final wsApp: " + linkedHashMap);
        }
        return linkedHashMap;
    }

    private boolean checkValidWsApp(IWsApp iWsApp) {
        return iWsApp != null && iWsApp.getChannelId() > 0 && iWsApp.getAppId() > 0 && !StringUtils.isEmpty(iWsApp.getAppKey()) && iWsApp.getAppVersion() > 0 && !iWsApp.getConnectUrls().isEmpty() && !StringUtils.isEmpty(iWsApp.getDeviceId()) && iWsApp.getFPID() > 0 && !StringUtils.isEmpty(iWsApp.getInstallId()) && iWsApp.getPlatform() == 0;
    }

    @Override // com.bytedance.common.wschannel.server.IWsChannelSaver
    public void saveWsChannels(Map<Integer, IWsApp> map) {
        if (map == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        synchronized (WsChannelService.class) {
            for (Map.Entry<Integer, IWsApp> entry : map.entrySet()) {
                try {
                    if (checkValidWsApp(entry.getValue())) {
                        jSONArray.put(entry.getValue().toJson());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Logger.m190d(TAG, "save to sp : " + jSONArray.toString());
            WsChannelSettings.inst(this.mContext).setWsApp(jSONArray.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
