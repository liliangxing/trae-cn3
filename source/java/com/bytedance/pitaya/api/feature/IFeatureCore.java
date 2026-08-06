package com.bytedance.pitaya.api.feature;

import com.bytedance.pitaya.api.PitayaCep;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;

/* compiled from: IFeatureCore.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0003H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pitaya/api/feature/IFeatureCore;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", CommonConstants.KEY_AID, "", "getAid", "()Ljava/lang/String;", "ResetRunEventCache", "", "businessName", "createCloudFeature", "Lcom/bytedance/pitaya/api/feature/ICloudFeature;", "createFeatureSchema", "Lcom/bytedance/pitaya/api/feature/IFeatureSchema;", "createInMemoryKVStore", "Lcom/bytedance/pitaya/api/feature/IKVStore;", "createKVStore", "getCepCore", "Lcom/bytedance/pitaya/api/PitayaCep;", "sharedFeatureSchema", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IFeatureCore extends ReflectionCall {
    void ResetRunEventCache(String businessName);

    ICloudFeature createCloudFeature(String businessName);

    IFeatureSchema createFeatureSchema(String businessName);

    IKVStore createInMemoryKVStore(String businessName);

    IKVStore createKVStore(String businessName);

    String getAid();

    PitayaCep getCepCore();

    IFeatureSchema sharedFeatureSchema();
}
