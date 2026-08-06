package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003JE\u0010\u0012\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/ConfigWithSwitchLazy;", "", "contentJson", "", "", "Lorg/json/JSONArray;", "contentV2Json", "Lorg/json/JSONObject;", "settingsJson", "(Ljava/util/Map;Ljava/util/Map;Lorg/json/JSONObject;)V", "getContentJson", "()Ljava/util/Map;", "getContentV2Json", "getSettingsJson", "()Lorg/json/JSONObject;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigWithSwitchLazy {
    private final Map<String, JSONArray> contentJson;
    private final Map<String, JSONObject> contentV2Json;
    private final JSONObject settingsJson;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConfigWithSwitchLazy copy$default(ConfigWithSwitchLazy configWithSwitchLazy, Map map, Map map2, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            map = configWithSwitchLazy.contentJson;
        }
        if ((i & 2) != 0) {
            map2 = configWithSwitchLazy.contentV2Json;
        }
        if ((i & 4) != 0) {
            jSONObject = configWithSwitchLazy.settingsJson;
        }
        return configWithSwitchLazy.copy(map, map2, jSONObject);
    }

    public final Map<String, JSONArray> component1() {
        return this.contentJson;
    }

    public final Map<String, JSONObject> component2() {
        return this.contentV2Json;
    }

    /* renamed from: component3, reason: from getter */
    public final JSONObject getSettingsJson() {
        return this.settingsJson;
    }

    public final ConfigWithSwitchLazy copy(Map<String, ? extends JSONArray> contentJson, Map<String, ? extends JSONObject> contentV2Json, JSONObject settingsJson) {
        return new ConfigWithSwitchLazy(contentJson, contentV2Json, settingsJson);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigWithSwitchLazy)) {
            return false;
        }
        ConfigWithSwitchLazy configWithSwitchLazy = (ConfigWithSwitchLazy) other;
        return Intrinsics.areEqual(this.contentJson, configWithSwitchLazy.contentJson) && Intrinsics.areEqual(this.contentV2Json, configWithSwitchLazy.contentV2Json) && Intrinsics.areEqual(this.settingsJson, configWithSwitchLazy.settingsJson);
    }

    public int hashCode() {
        Map<String, JSONArray> map = this.contentJson;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, JSONObject> map2 = this.contentV2Json;
        int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        JSONObject jSONObject = this.settingsJson;
        return hashCode2 + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public String toString() {
        return "ConfigWithSwitchLazy(contentJson=" + this.contentJson + ", contentV2Json=" + this.contentV2Json + ", settingsJson=" + this.settingsJson + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConfigWithSwitchLazy(Map<String, ? extends JSONArray> map, Map<String, ? extends JSONObject> map2, JSONObject jSONObject) {
        this.contentJson = map;
        this.contentV2Json = map2;
        this.settingsJson = jSONObject;
    }

    public final Map<String, JSONArray> getContentJson() {
        return this.contentJson;
    }

    public final Map<String, JSONObject> getContentV2Json() {
        return this.contentV2Json;
    }

    public final JSONObject getSettingsJson() {
        return this.settingsJson;
    }
}
