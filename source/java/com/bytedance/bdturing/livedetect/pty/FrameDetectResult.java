package com.bytedance.bdturing.livedetect.pty;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.bdturing.R;
import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public class FrameDetectResult {
    public static final int BLUR = 10;
    public static final int FACE_CLOSE = 41;
    public static final int FACE_DIRECTION = 42;
    public static final int FACE_OCCLUSION = 30;
    public static final int FACE_SMALL = 40;
    public static final int HALF_FACE = 21;
    public static final int ILLUMINATION_HIGH = 11;
    public static final int ILLUMINATION_LOW = 12;
    public static final int MULTIPLE_FACE = 22;
    public static final int NOT_EXISTS = 20;
    public static final int SUCCESS = 0;
    public static final int UNKNOWN = -1;
    public ArrayList<Float> boxRectInfo;
    public ImageDataWrapper data;
    public List<List<PointF>> mKeyPtList = new ArrayList();
    public List<RectF> mFaceBoxList = new ArrayList();
    public int status = -1;
    public String logInfo = "";

    public static List<PointF> buildKptList(JSONArray jSONArray) {
        PointF pointF = null;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            double optDouble = jSONArray.optDouble(i);
            if (i % 2 == 0) {
                pointF = new PointF();
                pointF.x = (float) optDouble;
            } else {
                pointF.y = (float) optDouble;
                arrayList.add(pointF);
            }
        }
        return arrayList;
    }

    public static RectF buildFaceBoxRectF(JSONArray jSONArray) {
        RectF rectF = null;
        if (jSONArray != null && jSONArray.length() == 4) {
            for (int i = 0; i < jSONArray.length(); i++) {
                double optDouble = jSONArray.optDouble(i);
                int i2 = i % 4;
                if (i2 == 0) {
                    rectF = new RectF();
                    rectF.left = (float) optDouble;
                } else if (i2 == 1) {
                    rectF.top = (float) optDouble;
                } else if (i2 == 2) {
                    rectF.right = (float) optDouble;
                } else if (i2 == 3) {
                    rectF.bottom = (float) optDouble;
                }
            }
        }
        return rectF;
    }

    public boolean isSuccess() {
        return this.status == 0;
    }

    public static Map<Integer, String> buildTipsMap(Context context) {
        HashMap hashMap = new HashMap();
        if (context != null) {
            try {
                hashMap.put(-1, context.getResources().getString(R.string.turing_live_detect_no_face));
                hashMap.put(0, context.getString(R.string.turing_live_detect_server_detecting));
                hashMap.put(20, context.getResources().getString(R.string.turing_live_detect_no_face));
                hashMap.put(10, context.getResources().getString(R.string.turing_live_detect_face_small));
                hashMap.put(21, context.getResources().getString(R.string.turing_live_detect_no_face));
                hashMap.put(22, context.getResources().getString(R.string.turing_live_detect_multiple_face));
                hashMap.put(40, context.getResources().getString(R.string.turing_live_detect_face_small));
                hashMap.put(41, context.getResources().getString(R.string.turing_live_detect_face_close));
                hashMap.put(42, context.getResources().getString(R.string.turing_live_detect_face_direction));
                hashMap.put(30, context.getResources().getString(R.string.turing_live_detect_face_occlusion));
                hashMap.put(11, context.getResources().getString(R.string.turing_live_detect_illumination_high));
                hashMap.put(12, context.getResources().getString(R.string.turing_live_detect_illumination_low));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
