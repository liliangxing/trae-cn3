package com.bytedance.tobshadow.applog.exposure;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.tobshadow.applog.exposure.IExposureConfig;
import com.bytedance.tobshadow.bdtracker.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/tobshadow/applog/exposure/ViewExposureData;", "Config", "Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "", "properties", "Lorg/json/JSONObject;", "config", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;)V", "getConfig", "()Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;", "setConfig", "(Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;)V", "Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;", "getEventName", "()Ljava/lang/String;", "getProperties", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Lorg/json/JSONObject;Lcom/bytedance/tobshadow/applog/exposure/IExposureConfig;)Lcom/bytedance/tobshadow/applog/exposure/ViewExposureData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final /* data */ class ViewExposureData<Config extends IExposureConfig> {
    public final String a;
    public final JSONObject b;
    public Config c;

    public ViewExposureData() {
        this(null, null, null, 7, null);
    }

    public ViewExposureData(String str, JSONObject jSONObject, Config config) {
        this.a = str;
        this.b = jSONObject;
        this.c = config;
    }

    public /* synthetic */ ViewExposureData(String str, JSONObject jSONObject, IExposureConfig iExposureConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jSONObject, (i & 4) != 0 ? null : iExposureConfig);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ViewExposureData copy$default(ViewExposureData viewExposureData, String str, JSONObject jSONObject, IExposureConfig iExposureConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = viewExposureData.a;
        }
        if ((i & 2) != 0) {
            jSONObject = viewExposureData.b;
        }
        if ((i & 4) != 0) {
            iExposureConfig = viewExposureData.c;
        }
        return viewExposureData.copy(str, jSONObject, iExposureConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final String getA() {
        return this.a;
    }

    /* renamed from: component2, reason: from getter */
    public final JSONObject getB() {
        return this.b;
    }

    public final Config component3() {
        return this.c;
    }

    public final ViewExposureData<Config> copy(String eventName, JSONObject properties, Config config) {
        return new ViewExposureData<>(eventName, properties, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewExposureData)) {
            return false;
        }
        ViewExposureData viewExposureData = (ViewExposureData) other;
        return Intrinsics.areEqual(this.a, viewExposureData.a) && Intrinsics.areEqual(this.b, viewExposureData.b) && Intrinsics.areEqual(this.c, viewExposureData.c);
    }

    public final Config getConfig() {
        return this.c;
    }

    public final String getEventName() {
        return this.a;
    }

    public final JSONObject getProperties() {
        return this.b;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        JSONObject jSONObject = this.b;
        int hashCode2 = (hashCode + (jSONObject != null ? jSONObject.hashCode() : 0)) * 31;
        Config config = this.c;
        return hashCode2 + (config != null ? config.hashCode() : 0);
    }

    public final void setConfig(Config config) {
        this.c = config;
    }

    public String toString() {
        return a.a("ViewExposureData(eventName=").append(this.a).append(", properties=").append(this.b).append(", config=").append(this.c).append(")").toString();
    }
}
