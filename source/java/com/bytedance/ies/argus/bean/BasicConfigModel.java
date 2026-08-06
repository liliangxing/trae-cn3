package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BasicConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/argus/bean/BasicConfigModel;", "", "conf", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getConf", "()Lorg/json/JSONObject;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Builder", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BasicConfigModel {
    private final JSONObject conf;

    /* JADX WARN: Multi-variable type inference failed */
    public BasicConfigModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BasicConfigModel copy$default(BasicConfigModel basicConfigModel, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = basicConfigModel.conf;
        }
        return basicConfigModel.copy(jSONObject);
    }

    /* renamed from: component1, reason: from getter */
    public final JSONObject getConf() {
        return this.conf;
    }

    public final BasicConfigModel copy(JSONObject conf) {
        return new BasicConfigModel(conf);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BasicConfigModel) && Intrinsics.areEqual(this.conf, ((BasicConfigModel) other).conf);
    }

    public int hashCode() {
        JSONObject jSONObject = this.conf;
        if (jSONObject == null) {
            return 0;
        }
        return jSONObject.hashCode();
    }

    public String toString() {
        return "BasicConfigModel(conf=" + this.conf + ')';
    }

    public BasicConfigModel(JSONObject jSONObject) {
        this.conf = jSONObject;
    }

    public /* synthetic */ BasicConfigModel(JSONObject jSONObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jSONObject);
    }

    public final JSONObject getConf() {
        return this.conf;
    }

    /* compiled from: BasicConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J)\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J'\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/bean/BasicConfigModel$Builder;", "", "()V", "config", "Lcom/bytedance/ies/argus/bean/BasicConfigModel;", "getConfig", "()Lcom/bytedance/ies/argus/bean/BasicConfigModel;", "setConfig", "(Lcom/bytedance/ies/argus/bean/BasicConfigModel;)V", "build", "init", "confData", "Lorg/json/JSONObject;", "toMergeConfData", "mergeMode", "", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;)Lcom/bytedance/ies/argus/bean/BasicConfigModel$Builder;", "mergeJsonArrays", "Lorg/json/JSONArray;", IEncryptorType.DEFAULT_ENCRYPTOR, "b", "mergeJsonObjects", "toMergeConfig", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;)Lorg/json/JSONObject;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        public static final int DEFAULT_MERGE_MODE = 2;
        public static final int STANDALONE_MERGE_MODE = 0;
        private BasicConfigModel config = new BasicConfigModel(null, 1, 0 == true ? 1 : 0);

        public final BasicConfigModel getConfig() {
            return this.config;
        }

        public final void setConfig(BasicConfigModel basicConfigModel) {
            Intrinsics.checkNotNullParameter(basicConfigModel, "<set-?>");
            this.config = basicConfigModel;
        }

        public final Builder init(JSONObject confData, JSONObject toMergeConfData, Integer mergeMode) {
            JSONObject optJSONObject = confData != null ? confData.optJSONObject("conf") : null;
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            JSONObject optJSONObject2 = toMergeConfData != null ? toMergeConfData.optJSONObject("conf") : null;
            if (optJSONObject2 != null && (mergeMode == null || mergeMode.intValue() != 0)) {
                optJSONObject = mergeJsonObjects(optJSONObject, optJSONObject2, mergeMode);
            }
            this.config = new BasicConfigModel(optJSONObject);
            return this;
        }

        /* renamed from: build, reason: from getter */
        public final BasicConfigModel getConfig() {
            return this.config;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final JSONObject mergeJsonObjects(JSONObject config, JSONObject toMergeConfig, Integer mergeMode) {
            int i;
            if (mergeMode != null && mergeMode.intValue() == 0) {
                return config;
            }
            JSONObject jSONObject = new JSONObject(toMergeConfig.toString());
            if (mergeMode != null) {
                if (!(mergeMode.intValue() > 0)) {
                    mergeMode = null;
                }
                if (mergeMode != null) {
                    i = mergeMode.intValue();
                    if (i != 1) {
                        Iterator<String> keys = config.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "config.keys()");
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.put(next, config.get(next));
                        }
                    } else {
                        Iterator<String> keys2 = config.keys();
                        Intrinsics.checkNotNullExpressionValue(keys2, "config.keys()");
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            Object obj = config.get(next2);
                            if (toMergeConfig.has(next2)) {
                                Object obj2 = toMergeConfig.get(next2);
                                if ((obj2 instanceof JSONObject) && (obj instanceof JSONObject)) {
                                    jSONObject.put(next2, mergeJsonObjects((JSONObject) obj, (JSONObject) obj2, Integer.valueOf(i - 1)));
                                } else if ((obj2 instanceof JSONArray) && (obj instanceof JSONArray)) {
                                    jSONObject.put(next2, mergeJsonArrays((JSONArray) obj2, (JSONArray) obj));
                                } else {
                                    jSONObject.put(next2, obj);
                                }
                            } else {
                                jSONObject.put(next2, obj);
                            }
                        }
                    }
                    return jSONObject;
                }
            }
            i = 2;
            if (i != 1) {
            }
            return jSONObject;
        }

        private final JSONArray mergeJsonArrays(JSONArray a, JSONArray b) {
            JSONArray jSONArray = new JSONArray();
            int length = a.length();
            for (int i = 0; i < length; i++) {
                jSONArray.put(a.get(i));
            }
            int length2 = b.length();
            for (int i2 = 0; i2 < length2; i2++) {
                jSONArray.put(b.get(i2));
            }
            return jSONArray;
        }
    }
}
