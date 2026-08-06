package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.argus.repository.BaseRemoteConfig;
import com.bytedance.ies.argus.repository.ConfigInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: GlobalConfigModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/GlobalConfigModel;", "Lcom/bytedance/ies/argus/repository/BaseRemoteConfig;", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "hashCode", "", "toString", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GlobalConfigModel extends BaseRemoteConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JSONObject data;

    public static /* synthetic */ GlobalConfigModel copy$default(GlobalConfigModel globalConfigModel, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = globalConfigModel.data;
        }
        return globalConfigModel.copy(jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getData() {
        return this.data;
    }

    public final GlobalConfigModel copy(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new GlobalConfigModel(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GlobalConfigModel) && Intrinsics.areEqual(this.data, ((GlobalConfigModel) other).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "GlobalConfigModel(data=" + this.data + ')';
    }

    public final JSONObject getData() {
        return this.data;
    }

    /* compiled from: GlobalConfigModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/argus/bean/GlobalConfigModel$Companion;", "", "()V", "init", "Lcom/bytedance/ies/argus/bean/GlobalConfigModel;", "data", "Lorg/json/JSONObject;", "info", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GlobalConfigModel init(JSONObject data, ConfigInfo info) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(info, "info");
            GlobalConfigModel globalConfigModel = new GlobalConfigModel(data);
            globalConfigModel.setConfInfo(info);
            return globalConfigModel;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalConfigModel(JSONObject data) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }
}
