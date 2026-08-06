package com.bytedance.pitaya.api.feature;

import kotlin.Metadata;

/* compiled from: ICloudFeature.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/feature/ICloudFeature;", "", "aid", "", "getAid", "()Ljava/lang/String;", "business", "getBusiness", "getCloudUserFeature", "featureName", "getUEFetaure", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface ICloudFeature {
    String getAid();

    String getBusiness();

    String getCloudUserFeature(String featureName);

    float[] getUEFetaure(String featureName);
}
