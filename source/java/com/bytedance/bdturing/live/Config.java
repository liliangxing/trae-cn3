package com.bytedance.bdturing.live;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Config {
    public float detect_model_confidence_th;
    public int detect_model_keep_top_k;
    public float detect_model_nms_th;
    public String detect_model_path;
    public int detect_model_top_k;
    public float eye_ratio_th;
    public float fit_roi_th;
    public int illumination_high_th;
    public int illumination_low_th;
    public float in_rob_th;
    public String kpt_model_path;
    public float mouth_ratio_hi_th;
    public float mouth_ratio_lo_th;
    public float too_large_th;
    public float too_small_th;
    public float vertical_angle_th;
    public float visible_point_rate_th;
    public float visible_point_th;

    public Config() {
    }

    public Config(JSONObject jSONObject) {
        this.detect_model_confidence_th = (float) jSONObject.optDouble("detect_model_confidence_th", 0.0d);
        this.detect_model_top_k = jSONObject.optInt("detect_model_top_k", 0);
        this.detect_model_nms_th = (float) jSONObject.optDouble("detect_model_nms_th", 0.0d);
        this.detect_model_keep_top_k = jSONObject.optInt("detect_model_keep_top_k", 0);
        this.illumination_low_th = jSONObject.optInt("illumination_low_th", 0);
        this.illumination_high_th = jSONObject.optInt("illumination_high_th", 0);
        this.in_rob_th = (float) jSONObject.optDouble("in_rob_th", 0.0d);
        this.too_small_th = (float) jSONObject.optDouble("too_small_th", 0.0d);
        this.too_large_th = (float) jSONObject.optDouble("too_large_th", 0.0d);
        this.fit_roi_th = (float) jSONObject.optDouble("fit_roi_th", 0.0d);
        this.visible_point_th = (float) jSONObject.optDouble("visible_point_th", 0.0d);
        this.visible_point_rate_th = (float) jSONObject.optDouble("visible_point_rate_th", 0.0d);
        this.eye_ratio_th = (float) jSONObject.optDouble("eye_ratio_th", 0.0d);
        this.mouth_ratio_lo_th = (float) jSONObject.optDouble("mouth_ratio_lo_th", 0.0d);
        this.mouth_ratio_hi_th = (float) jSONObject.optDouble("mouth_ratio_hi_th", 0.0d);
        this.vertical_angle_th = (float) jSONObject.optDouble("vertical_angle_th", 0.0d);
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("detect_model_confidence_th", this.detect_model_confidence_th + "");
            jSONObject.put("detect_model_top_k", this.detect_model_top_k + "");
            jSONObject.put("detect_model_nms_th", this.detect_model_nms_th + "");
            jSONObject.put("detect_model_keep_top_k", this.detect_model_keep_top_k + "");
            jSONObject.put("illumination_low_th", this.illumination_low_th + "");
            jSONObject.put("illumination_high_th", this.illumination_high_th + "");
            jSONObject.put("in_rob_th", this.in_rob_th + "");
            jSONObject.put("too_small_th", this.too_small_th + "");
            jSONObject.put("too_large_th", this.too_large_th + "");
            jSONObject.put("fit_roi_th", this.fit_roi_th + "");
            jSONObject.put("visible_point_th", this.visible_point_th + "");
            jSONObject.put("visible_point_rate_th", this.visible_point_rate_th + "");
            jSONObject.put("eye_ratio_th", this.eye_ratio_th + "");
            jSONObject.put("mouth_ratio_lo_th", this.mouth_ratio_lo_th + "");
            jSONObject.put("mouth_ratio_hi_th", this.mouth_ratio_hi_th + "");
            jSONObject.put("vertical_angle_th", this.vertical_angle_th + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
