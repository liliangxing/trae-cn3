package com.bytedance.bmf_mods_lite_api.bean;

import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* loaded from: classes3.dex */
public class PerfReport {

    @SerializedName("alg_name")
    public String algName;

    @SerializedName("avg")
    public float average;

    @SerializedName("count")
    public int frameCount;

    @SerializedName("max")
    public float max;

    @SerializedName("min")
    public float min;

    @SerializedName(CloudControlInf.ROUTE)
    public String route;
}
