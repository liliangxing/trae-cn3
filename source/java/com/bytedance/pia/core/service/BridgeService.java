package com.bytedance.pia.core.service;

import android.view.View;
import com.bytedance.android.anniex.R;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.services.IPiaBridgeService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.bridge.PiaBridge;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.google.gson.JsonObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BridgeService implements IPiaBridgeService {
    public static BridgeService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final BridgeService INSTANCE = new BridgeService();

        private InstanceHolder() {
        }
    }

    @Override // com.bytedance.pia.core.api.services.IPiaBridgeService
    public void call(View view, String str, Object obj, final IConsumer<Object> iConsumer, IConsumer<PiaMethod.Error> iConsumer2) {
        Object tag = view.getTag(R.id.tag_binding_pia_runtime);
        if (tag instanceof PiaRuntime) {
            ((PiaRuntime) tag).getRenderBridge().call(str, obj, new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.service.BridgeService.1
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public void accept(JsonObject jsonObject) {
                    IConsumer iConsumer3 = iConsumer;
                    if (iConsumer3 != null) {
                        iConsumer3.accept(jsonObject);
                    }
                }
            }, iConsumer2);
        } else {
            PiaBridge.callOnce(str, obj, new IConsumer<JsonObject>() { // from class: com.bytedance.pia.core.service.BridgeService.2
                @Override // com.bytedance.pia.core.api.utils.IConsumer
                public void accept(JsonObject jsonObject) {
                    IConsumer iConsumer3 = iConsumer;
                    if (iConsumer3 != null) {
                        iConsumer3.accept(jsonObject);
                    }
                }
            }, iConsumer2);
        }
    }
}
