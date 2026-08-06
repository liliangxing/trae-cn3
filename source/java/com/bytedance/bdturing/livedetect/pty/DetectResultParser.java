package com.bytedance.bdturing.livedetect.pty;

import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DetectResultParser {
    public static FrameDetectResult parseDetectResult(PTYTaskData pTYTaskData, ArrayList<Float> arrayList) {
        if (pTYTaskData == null || pTYTaskData.getParams() == null) {
            return null;
        }
        return parseDetectResult(pTYTaskData.getParams(), arrayList);
    }

    public static FrameDetectResult parseDetectResult(JSONObject jSONObject, ArrayList<Float> arrayList) {
        RectF buildFaceBoxRectF;
        List<PointF> buildKptList;
        FrameDetectResult frameDetectResult = new FrameDetectResult();
        frameDetectResult.status = jSONObject.optInt("status", -1);
        frameDetectResult.logInfo = jSONObject.optString("log", "");
        frameDetectResult.boxRectInfo = arrayList;
        JSONArray optJSONArray = jSONObject.optJSONArray("face_info");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2.has("kps") && (buildKptList = FrameDetectResult.buildKptList(jSONObject2.getJSONArray("kps"))) != null) {
                        frameDetectResult.mKeyPtList.add(buildKptList);
                    }
                    if (jSONObject2.has("box") && (buildFaceBoxRectF = FrameDetectResult.buildFaceBoxRectF(jSONObject2.getJSONArray("box"))) != null) {
                        frameDetectResult.mFaceBoxList.add(buildFaceBoxRectF);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return frameDetectResult;
    }
}
