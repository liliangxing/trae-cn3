package com.ss.bytertc.engine.aigc;

import com.ss.bytertc.engine.RTCRoomConfig;
import com.ss.bytertc.engine.UserInfo;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AIGCSessionConfig {
    public String action;
    public String fgConfig;
    public boolean joinRoomNeedSdp;
    public JSONObject message;
    public RTCRoomConfig roomConfig;
    public int timeout;
    public String token;
    public String type;
    public UserInfo userInfo;

    public AIGCSessionConfig(String token, UserInfo userInfo, RTCRoomConfig roomConfig, String type, String action, JSONObject message, int timeout) {
        this.fgConfig = "";
        this.token = token;
        this.userInfo = userInfo;
        this.roomConfig = roomConfig;
        this.type = type;
        this.action = action;
        this.message = message;
        this.timeout = timeout;
        this.joinRoomNeedSdp = false;
    }

    public AIGCSessionConfig(String token, UserInfo userInfo, RTCRoomConfig roomConfig, String type, String action, JSONObject message, int timeout, boolean joinRoomNeedSdp) {
        this.fgConfig = "";
        this.token = token;
        this.userInfo = userInfo;
        this.roomConfig = roomConfig;
        this.type = type;
        this.action = action;
        this.message = message;
        this.timeout = timeout;
        this.joinRoomNeedSdp = joinRoomNeedSdp;
    }

    public AIGCSessionConfig(String token, UserInfo userInfo, RTCRoomConfig roomConfig, String type, String action, JSONObject message, int timeout, boolean joinRoomNeedSdp, String fgConfig) {
        this.token = token;
        this.userInfo = userInfo;
        this.roomConfig = roomConfig;
        this.type = type;
        this.action = action;
        this.message = message;
        this.timeout = timeout;
        this.joinRoomNeedSdp = joinRoomNeedSdp;
        this.fgConfig = fgConfig;
    }
}
