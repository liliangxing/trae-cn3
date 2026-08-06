package com.bytedance.pitaya.api.bean;

import kotlin.Metadata;

/* compiled from: PTYTaskData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/DataFetcher;", "", "fetchAsNumber", "", "keys", "", "", "default", "", "([Ljava/lang/String;D)[D", "fetchAsString", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface DataFetcher {
    double[] fetchAsNumber(String[] keys, double r2);

    String[] fetchAsString(String[] keys, String r2);
}
