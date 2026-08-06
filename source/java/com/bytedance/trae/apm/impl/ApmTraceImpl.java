package com.bytedance.trae.apm.impl;

import com.bytedance.apm.ApmAgent;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.crash.Npth;
import com.bytedance.trae.apm.api.IApmTrace;
import com.bytedance.trae.applog.api.IApplog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ApmTraceImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/apm/impl/ApmTraceImpl;", "Lcom/bytedance/trae/apm/api/IApmTrace;", "<init>", "()V", "addPerfTag", "", "key", "", "value", "addTag", "traceAll", "reportApmEvent", "category", "Lorg/json/JSONObject;", "metric", "extra", "reportTeaEvent", "startApmScene", "scene", "stopApmScene", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ApmTraceImpl implements IApmTrace {
    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void addPerfTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ApmAgent.addPerfTag(key, value);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void addTag(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Npth.addTag(key, value);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void traceAll(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        ApmAgent.addPerfTag(key, value);
        Npth.addTag(key, value);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void reportApmEvent(String key, JSONObject category, JSONObject metric, JSONObject extra) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(category, "category");
        ApmAgent.monitorEvent(key, category, metric, extra);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void reportTeaEvent(String key, JSONObject value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        IApplog.INSTANCE.reportEvent(key, value);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void startApmScene(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ApmCpuManager.getInstance().startScene(scene);
    }

    @Override // com.bytedance.trae.apm.api.IApmTrace
    public void stopApmScene(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        ApmCpuManager.getInstance().stopScene(scene);
    }
}
