package com.bytedance.push.model;

import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HeadSetStatusExtraConfig {
    public static final String HARMONY_LISTEN_METHOD_AWARENESS = "awareness";
    public static final String KEY_KILL_PROCESS_MODE = "kill_process_mode";
    public static final int KILL_PROCESS_MODE_FORCE_KILL = 1;
    public static final int KILL_PROCESS_MODE_KILL_IF_NO_NOTIFICATION = 2;
    public static final int KILL_PROCESS_MODE_NOT_KILL = 0;
    public static final String VALUE_CONNECTED = "connected";
    public static final String VALUE_CONNECTING = "connecting";
    public static final String VALUE_DISCONNECT = "disconnect";
    final String KEY_CALLBACK_INTENT = "callback_intent";
    final String KEY_HARMONY_LISTEN_METHOD = "harmony_listen_method";
    final String KEY_LISTEN_TYPE = "listen_type";
    public String callbackIntent;
    public String harmonyListenMethod;
    public int killProcessMode;
    public List<String> listenTypeList;

    public HeadSetStatusExtraConfig(Map<String, String> map) {
        map = map == null ? new HashMap<>() : map;
        this.callbackIntent = map.get("callback_intent");
        this.harmonyListenMethod = map.get("harmony_listen_method");
        this.killProcessMode = ToolUtils.parseInt(map.get(KEY_KILL_PROCESS_MODE), 1);
        this.listenTypeList = ToolUtils.stringDividedByCommaToList(map.get("listen_type"));
    }
}
