package com.bytedance.pia.core.bridge.channel;

import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.worker.Worker;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WorkerPort implements IBridgePort {
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final Worker worker;

    public WorkerPort(Worker worker) {
        this.worker = worker;
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void postMessage(JsonObject jsonObject) {
        if (this.isClosed.get()) {
            return;
        }
        this.worker.sendBridgeMessage(jsonObject);
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void setOnMessage(final IConsumer<JsonObject> iConsumer) {
        this.worker.onBridgeMessage(new IConsumer() { // from class: com.bytedance.pia.core.bridge.channel.WorkerPort$$ExternalSyntheticLambda0
            @Override // com.bytedance.pia.core.api.utils.IConsumer
            public final void accept(Object obj) {
                WorkerPort.this.m166x2cfd4f07(iConsumer, (JsonObject) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnMessage$0$com-bytedance-pia-core-bridge-channel-WorkerPort */
    public /* synthetic */ void m166x2cfd4f07(IConsumer iConsumer, JsonObject jsonObject) {
        if (this.isClosed.get() || jsonObject == null) {
            return;
        }
        iConsumer.accept(jsonObject);
    }

    @Override // com.bytedance.pia.core.bridge.channel.IBridgePort
    public void close() {
        this.isClosed.compareAndSet(false, true);
    }
}
