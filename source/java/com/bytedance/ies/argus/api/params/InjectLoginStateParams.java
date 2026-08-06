package com.bytedance.ies.argus.api.params;

import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.CommonUtils;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InjectLoginStateParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams;", "Lcom/bytedance/ies/argus/api/params/BaseAspectParamsWithoutRewrite;", "sourceUrl", "", "scene", "Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams$SceneType;", "(Ljava/lang/String;Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams$SceneType;)V", "getScene", "()Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams$SceneType;", "getSourceUrl", "()Ljava/lang/String;", "toALogObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "toMonitorObject", "SceneType", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class InjectLoginStateParams extends BaseAspectParamsWithoutRewrite {
    private final SceneType scene;
    private final String sourceUrl;

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final SceneType getScene() {
        return this.scene;
    }

    public InjectLoginStateParams(String str, SceneType sceneType) {
        Intrinsics.checkNotNullParameter(str, "sourceUrl");
        Intrinsics.checkNotNullParameter(sceneType, "scene");
        this.sourceUrl = str;
        this.scene = sceneType;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPut(jSONObject, "source_url", CommonUtils.INSTANCE.removeQuery(this.sourceUrl));
        JSONUtilsKt.safelyPut(jSONObject, "origin_source_url", this.sourceUrl);
        JSONUtilsKt.safelyPut(jSONObject, "scene_type", this.scene.getValue());
        return jSONObject;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toALogObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return toMonitorObject(action);
    }

    /* compiled from: InjectLoginStateParams.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/argus/api/params/InjectLoginStateParams$SceneType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "X_REQUEST", "PIA", "FOREST", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum SceneType {
        X_REQUEST("xRequest"),
        PIA("pia"),
        FOREST("forest");

        private final String value;

        SceneType(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
