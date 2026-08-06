package com.bytedance.pitaya.api.feature.store;

import com.bytedance.notification.Constants;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: PTYModelInstance.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0003J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u0007J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0002J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u001cJ*\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYModelInstance;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "instanceID", "", "featureStr", "(Ljava/lang/String;Ljava/lang/String;)V", "features", "Lorg/json/JSONObject;", "getInstanceID", "()Ljava/lang/String;", "labels", "", "", "predicts", "addLabel", "", "name", "value", "addPredict", "getFeature", "", "featureName", "getFeatureStr", "getFeatures", "getLabelsStr", "getPredictsStr", "updateFeatures", "json", "updateFeatures$pitayacore_release", "upload", "sampleRate", "business", IPiaCacheProvider.CacheConfig.FIELD_VERSION, "", Constants.NOTIFICATION_TAG, "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PTYModelInstance implements ReflectionCall {
    private JSONObject features;
    private final String instanceID;
    private final Map<String, Float> labels;
    private final Map<String, Float> predicts;

    public PTYModelInstance(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "instanceID");
        Intrinsics.checkNotNullParameter(str2, "featureStr");
        this.instanceID = str;
        this.features = new JSONObject(str2);
        this.labels = new LinkedHashMap();
        this.predicts = new LinkedHashMap();
    }

    public final String getInstanceID() {
        return this.instanceID;
    }

    public final Object getFeature(String featureName) {
        Intrinsics.checkNotNullParameter(featureName, "featureName");
        return this.features.opt(featureName);
    }

    public final void updateFeatures$pitayacore_release(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.features = json;
    }

    public final JSONObject getFeatures() {
        return this.features;
    }

    public final void addLabel(String name, float value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.labels.put(name, Float.valueOf(value));
    }

    public final void addPredict(String name, float value) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.predicts.put(name, Float.valueOf(value));
    }

    public static /* synthetic */ void upload$default(PTYModelInstance pTYModelInstance, float f, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        pTYModelInstance.upload(f, str, i, str2);
    }

    public final void upload(float sampleRate, String business, int version, String tag) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(tag, Constants.NOTIFICATION_TAG);
        IFeatureStore featureStore = PTYFeatureStoreInstance.INSTANCE.getFeatureStore();
        if (featureStore != null) {
            featureStore.upload(this, sampleRate, business, version, tag);
        }
    }

    private final String getFeatureStr() {
        String jSONObject = this.features.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "features.toString()");
        return jSONObject;
    }

    private final String getLabelsStr() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Float> entry : this.labels.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    private final String getPredictsStr() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Float> entry : this.predicts.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
