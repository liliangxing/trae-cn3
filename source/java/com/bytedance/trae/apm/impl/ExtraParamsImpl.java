package com.bytedance.trae.apm.impl;

import android.os.Process;
import com.bytedance.apm.ApmContext;
import com.bytedance.trae.apm.api.IExtraParams;
import com.bytedance.trae.utils.StringKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* compiled from: ExtraParamsImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/apm/impl/ExtraParamsImpl;", "Lcom/bytedance/trae/apm/api/IExtraParams;", "<init>", "()V", "_staticParams", "", "", "staticParams", "getStaticParams", "()Ljava/util/Map;", "getAppVariant", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ExtraParamsImpl implements IExtraParams {
    private final Map<String, String> _staticParams = MapsKt.mapOf(new Pair[]{TuplesKt.to("flow_process_name", StringKt.analysis(ApmContext.getCurrentProcessName())), TuplesKt.to("flow_process_id", StringKt.analysis(String.valueOf(Process.myPid()))), TuplesKt.to("flow_app_variant", getAppVariant())});

    @Override // com.bytedance.trae.apm.api.IExtraParams
    public String getAppVariant() {
        return "";
    }

    @Override // com.bytedance.trae.apm.api.IExtraParams
    public Map<String, String> getStaticParams() {
        return this._staticParams;
    }
}
