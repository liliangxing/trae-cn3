package com.lynx.tasm.gesture.detector;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GestureDetector {
    public static final String CONTINUE_WITH = "continueWith";
    public static final int GESTURE_TYPE_DEFAULT = 2;
    public static final int GESTURE_TYPE_FLING = 1;
    public static final int GESTURE_TYPE_LONG_PRESS = 4;
    public static final int GESTURE_TYPE_NATIVE = 7;
    public static final int GESTURE_TYPE_PAN = 0;
    public static final int GESTURE_TYPE_PINCH = 6;
    public static final int GESTURE_TYPE_ROTATION = 5;
    public static final int GESTURE_TYPE_TAP = 3;
    public static final String SIMULTANEOUS = "simultaneous";
    public static final String WAIT_FOR = "waitFor";
    private final ReadableMap configMap;
    private final List<String> gestureCallbackNames;
    private final int gestureID;
    private final int gestureType;
    private final Map<String, List<Integer>> relationMap;

    public GestureDetector(int i, int i2, List<String> list, Map<String, List<Integer>> map) {
        this.gestureID = i;
        this.gestureType = i2;
        if (list != null) {
            this.gestureCallbackNames = new ArrayList(list);
        } else {
            this.gestureCallbackNames = new ArrayList();
        }
        if (map != null) {
            this.relationMap = new HashMap(map);
        } else {
            this.relationMap = new HashMap();
        }
        this.configMap = null;
    }

    public GestureDetector(int i, int i2, List<String> list, Map<String, List<Integer>> map, ReadableMap readableMap) {
        this.gestureID = i;
        this.gestureType = i2;
        if (list != null) {
            this.gestureCallbackNames = new ArrayList(list);
        } else {
            this.gestureCallbackNames = new ArrayList();
        }
        if (map != null) {
            this.relationMap = new HashMap(map);
        } else {
            this.relationMap = new HashMap();
        }
        this.configMap = readableMap;
    }

    public int getGestureID() {
        return this.gestureID;
    }

    public int getGestureType() {
        return this.gestureType;
    }

    public ReadableMap getConfigMap() {
        return this.configMap;
    }

    public List<String> getGestureCallbackNames() {
        return this.gestureCallbackNames;
    }

    public Map<String, List<Integer>> getRelationMap() {
        return this.relationMap;
    }

    public static Map<Integer, GestureDetector> convertGestureDetectors(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            int i2 = map.getInt("id");
            int i3 = map.getInt(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            ReadableArray array = map.getArray("callbackNames");
            ArrayList arrayList = new ArrayList();
            if (array != null) {
                for (int i4 = 0; i4 < array.size(); i4++) {
                    arrayList.add(array.getString(i4));
                }
            }
            HashMap hashMap2 = new HashMap();
            ReadableMap map2 = map.getMap("relationMap");
            if (map2 != null) {
                ReadableArray array2 = map2.getArray(SIMULTANEOUS);
                if (array2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i5 = 0; i5 < array2.size(); i5++) {
                        arrayList2.add(Integer.valueOf(array2.getInt(i5)));
                    }
                    hashMap2.put(SIMULTANEOUS, arrayList2);
                }
                ReadableArray array3 = map2.getArray(WAIT_FOR);
                if (array3 != null) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i6 = 0; i6 < array3.size(); i6++) {
                        arrayList3.add(Integer.valueOf(array3.getInt(i6)));
                    }
                    hashMap2.put(WAIT_FOR, arrayList3);
                }
                ReadableArray array4 = map2.getArray(CONTINUE_WITH);
                if (array4 != null) {
                    ArrayList arrayList4 = new ArrayList();
                    for (int i7 = 0; i7 < array4.size(); i7++) {
                        arrayList4.add(Integer.valueOf(array4.getInt(i7)));
                    }
                    hashMap2.put(CONTINUE_WITH, arrayList4);
                }
            }
            hashMap.put(Integer.valueOf(i2), new GestureDetector(i2, i3, arrayList, hashMap2, map.getMap("configMap")));
        }
        return hashMap;
    }
}
