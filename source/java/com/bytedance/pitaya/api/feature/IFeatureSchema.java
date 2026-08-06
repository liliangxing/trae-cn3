package com.bytedance.pitaya.api.feature;

import java.util.List;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: IFeatureSchema.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J$\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J,\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00032\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\"\u0010\r\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\"\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/bytedance/pitaya/api/feature/IFeatureSchema;", "", "aid", "", "getAid", "()Ljava/lang/String;", "business", "getBusiness", "collectFeatures", "Lorg/json/JSONObject;", "featureNames", "", "context", "getFeatures", "registerCustomFunc", "", "funcName", "func", "Lcom/bytedance/pitaya/api/feature/PTYCustomSchemaFunction;", "registerCustomFuncv2", "", "registerFeatureSchemaConfig", "schema", "opPath", "unregisterCustomFunc", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface IFeatureSchema {
    JSONObject collectFeatures(String business, List<String> featureNames, JSONObject context);

    JSONObject collectFeatures(List<String> featureNames, JSONObject context);

    String getAid();

    String getBusiness();

    JSONObject getFeatures(String business, List<String> featureNames, JSONObject context);

    JSONObject getFeatures(List<String> featureNames, JSONObject context);

    void registerCustomFunc(String funcName, PTYCustomSchemaFunction func);

    boolean registerCustomFuncv2(String funcName, PTYCustomSchemaFunction func);

    void registerFeatureSchemaConfig(String business, JSONObject schema, String opPath);

    void unregisterCustomFunc(String funcName);
}
