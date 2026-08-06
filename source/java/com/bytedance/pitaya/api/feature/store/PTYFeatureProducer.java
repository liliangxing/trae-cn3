package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PTYFeatureProducer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureProducer;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", "getDictFeature", "", "featureName", "params", "Lorg/json/JSONObject;", "getGroupName", "getNumericFeature", "", "getSeqFeature", "Lorg/json/JSONArray;", "getStringFeature", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public abstract class PTYFeatureProducer implements ReflectionCall {
    public abstract JSONObject getDictFeature(String featureName, JSONObject params);

    public abstract String getGroupName();

    public abstract float getNumericFeature(String featureName, JSONObject params);

    public abstract JSONArray getSeqFeature(String featureName, JSONObject params);

    public abstract String getStringFeature(String featureName, JSONObject params);

    private final String getStringFeature(String featureName, String params) {
        JSONObject jSONObject = null;
        try {
            if (!(params.length() == 0)) {
                jSONObject = new JSONObject(params);
            }
        } catch (Throwable unused) {
        }
        return getStringFeature(featureName, jSONObject);
    }

    private final float getNumericFeature(String featureName, String params) {
        JSONObject jSONObject = null;
        try {
            if (!(params.length() == 0)) {
                jSONObject = new JSONObject(params);
            }
        } catch (Throwable unused) {
        }
        return getNumericFeature(featureName, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getDictFeature(String featureName, String params) {
        JSONObject jSONObject;
        JSONObject dictFeature;
        if (params.length() == 0) {
            jSONObject = null;
            dictFeature = getDictFeature(featureName, jSONObject);
            if (dictFeature == null) {
                return dictFeature.toString();
            }
            return null;
        }
        jSONObject = new JSONObject(params);
        dictFeature = getDictFeature(featureName, jSONObject);
        if (dictFeature == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getSeqFeature(String featureName, String params) {
        JSONObject jSONObject;
        JSONArray seqFeature;
        if (params.length() == 0) {
            jSONObject = null;
            seqFeature = getSeqFeature(featureName, jSONObject);
            if (seqFeature == null) {
                return seqFeature.toString();
            }
            return null;
        }
        jSONObject = new JSONObject(params);
        seqFeature = getSeqFeature(featureName, jSONObject);
        if (seqFeature == null) {
        }
    }
}
