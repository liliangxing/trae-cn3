package com.bytedance.apm6.java_alloc;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JavaAllocConfig {
    public static final String KEY_CONF_COLLECT = "enable_alloc_collect";
    public static final String KEY_CONF_COLLECT_PER_THOUSAND_ALLOC = "alloc_collect_per_thousand_alloc";
    public static final String KEY_CONF_DUMP_PER_THOUSAND_COLLECT = "alloc_dump_per_thousand_collect";
    public static final String KEY_CONF_THRESHOLD_ALLOC_FREQ = "alloc_threshold_alloc_frequency";
    public static final String KEY_CONF_THRESHOLD_ALLOC_SIZE = "alloc_threshold_alloc_size";
    public static final String KEY_CONF_UPLOAD = "enable_alloc_upload";
    public int collect_per_thousand_alloc;
    public int dump_per_thousand_collect;
    public boolean enable_collect;
    public boolean enable_upload;
    public int threshold_alloc_frequency;
    public long threshold_alloc_size;

    public JavaAllocConfig(boolean z, boolean z2, int i, int i2, int i3, long j) {
        this.enable_collect = z;
        this.enable_upload = z2;
        this.collect_per_thousand_alloc = i;
        this.dump_per_thousand_collect = i2;
        this.threshold_alloc_frequency = i3;
        this.threshold_alloc_size = j;
    }

    public JSONObject packJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CONF_COLLECT, this.enable_collect);
            jSONObject.put(KEY_CONF_UPLOAD, this.enable_upload);
            jSONObject.put(KEY_CONF_COLLECT_PER_THOUSAND_ALLOC, this.collect_per_thousand_alloc);
            jSONObject.put(KEY_CONF_DUMP_PER_THOUSAND_COLLECT, this.dump_per_thousand_collect);
            jSONObject.put(KEY_CONF_THRESHOLD_ALLOC_FREQ, this.threshold_alloc_frequency);
            jSONObject.put(KEY_CONF_THRESHOLD_ALLOC_SIZE, this.threshold_alloc_size);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
