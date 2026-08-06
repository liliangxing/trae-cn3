package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.methods.BootOnFinish;
import com.bytedance.pia.core.bridge.methods.WorkerCreate;
import com.bytedance.pia.core.bridge.protocol.ProtocolMessage;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.setting.Settings;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BootPlugin extends PiaPlugin {
    public static final String RESULT = "result";
    public static final String RESULT_CONFIG_KEY = "configKey";
    public static final String RESULT_TYPE = "type";
    public static final int UNKNOWN_BRIDGE_ID = 1;
    private static final Map<String, String> bootOperation;
    private final JsonArray bootResult;
    private final List<String> runningTasks;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return ErrorType.BOOT;
    }

    static {
        HashMap hashMap = new HashMap();
        bootOperation = hashMap;
        hashMap.put(ErrorType.PREFETCH, WorkerCreate.NAME);
    }

    public BootPlugin(PiaRuntime piaRuntime) {
        super(piaRuntime);
        this.bootResult = new JsonArray();
        this.runningTasks = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onEvent(String str, Object... objArr) {
        if (Settings.get().getIsBootEnabled() && PiaRuntime.EVENT_ON_MANIFEST_READY.equals(str)) {
            Object obj = objArr[0];
            if (obj instanceof JsonObject) {
                for (Map.Entry entry : ((JsonObject) obj).entrySet()) {
                    final String str2 = (String) entry.getKey();
                    String bootOperation2 = getBootOperation(str2);
                    if (bootOperation2 != null) {
                        this.runtime.getOnlineTrace().updateSSRStatus(3);
                        JsonObject asJsonObject = ((JsonElement) entry.getValue()).getAsJsonObject();
                        final JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty(RESULT_CONFIG_KEY, str2);
                        jsonObject.addProperty("type", bootOperation2);
                        this.runningTasks.add(str2);
                        this.runtime.getRenderBridge().call(bootOperation2, asJsonObject, new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.plugins.BootPlugin.1
                            @Override // com.bytedance.pia.core.api.utils.IConsumer
                            public void accept(JsonObject jsonObject2) {
                                jsonObject.add("result", ProtocolMessage.toRaw(new ProtocolMessage.Callback(1, 1, jsonObject2, null)));
                                BootPlugin.this.finishTask(str2, jsonObject);
                            }
                        }, new IConsumer<PiaMethod.Error>() { // from class: com.bytedance.pia.core.plugins.BootPlugin.2
                            @Override // com.bytedance.pia.core.api.utils.IConsumer
                            public void accept(PiaMethod.Error error) {
                                jsonObject.add("result", ProtocolMessage.toRaw(new ProtocolMessage.Callback(1, error.getCode(), null, error.getMessage())));
                                BootPlugin.this.finishTask(str2, jsonObject);
                            }
                        });
                    }
                }
            }
        }
    }

    private String getBootOperation(String str) {
        if (ErrorType.PREFETCH.equals(str) && this.runtime.getConfig().isPrefetchEnabled()) {
            return bootOperation.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishTask(String str, JsonObject jsonObject) {
        this.bootResult.add(jsonObject);
        this.runningTasks.remove(str);
        if (this.runningTasks.isEmpty()) {
            this.runtime.getRenderBridge().send(BootOnFinish.NAME, new BootOnFinish.Result(this.bootResult));
        }
    }

    public JsonArray getBootResult() {
        return this.bootResult;
    }
}
