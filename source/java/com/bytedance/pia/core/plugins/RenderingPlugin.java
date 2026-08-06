package com.bytedance.pia.core.plugins;

import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.methods.WorkerRunTask;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.utils.GsonUtils;
import com.google.gson.JsonObject;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RenderingPlugin extends PiaPlugin {
    public static final String KEY_RENDERING = "rendering";
    private final IConsumer<PiaMethod.Error> errorCallback;
    private final Map<String, ?> params;
    private final IConsumer<Map<String, ?>> resultCallback;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public String getName() {
        return KEY_RENDERING;
    }

    public RenderingPlugin(PiaRuntime piaRuntime, Params params) {
        super(piaRuntime);
        this.params = params.params;
        this.resultCallback = params.resultCallback;
        this.errorCallback = params.errorCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.pia.core.runtime.PiaPlugin
    public void onEvent(String str, Object... objArr) {
        if (PiaRuntime.EVENT_ON_MANIFEST_ERROR.equals(str) || PiaRuntime.EVENT_ON_HTML_ERROR.equals(str)) {
            this.errorCallback.accept(new PiaMethod.Error("Request manifest error!"));
            return;
        }
        if (PiaRuntime.EVENT_ON_MANIFEST_READY.equals(str)) {
            Object obj = objArr[0];
            if (obj instanceof JsonObject) {
                try {
                    JsonObject jsonObject = (JsonObject) obj;
                    if (!jsonObject.has(KEY_RENDERING)) {
                        this.errorCallback.accept(new PiaMethod.Error("'rendering' is required!"));
                        return;
                    }
                    JsonObject asJsonObject = jsonObject.get(KEY_RENDERING).getAsJsonObject();
                    if (this.params != null) {
                        asJsonObject.add("params", GsonUtils.getGson().toJsonTree(this.params));
                    }
                    this.runtime.getRenderBridge().call(WorkerRunTask.NAME, asJsonObject, new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.plugins.RenderingPlugin.1
                        @Override // com.bytedance.pia.core.api.utils.IConsumer
                        public void accept(JsonObject jsonObject2) {
                            RenderingPlugin.this.resultCallback.accept((Map) GsonUtils.getGson().fromJson(jsonObject2, Map.class));
                        }
                    }, new IConsumer<PiaMethod.Error>() { // from class: com.bytedance.pia.core.plugins.RenderingPlugin.2
                        @Override // com.bytedance.pia.core.api.utils.IConsumer
                        public void accept(PiaMethod.Error error) {
                            RenderingPlugin.this.errorCallback.accept(error);
                        }
                    });
                } catch (Throwable th) {
                    this.errorCallback.accept(new PiaMethod.Error(th.toString()));
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Params {
        private final IConsumer<PiaMethod.Error> errorCallback;
        private final Map<String, ?> params;
        private final IConsumer<Map<String, ?>> resultCallback;

        public Params(Map<String, ?> map, IConsumer<Map<String, ?>> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
            this.params = map;
            this.resultCallback = iConsumer;
            this.errorCallback = iConsumer2;
        }
    }
}
