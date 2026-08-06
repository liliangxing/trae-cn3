package com.lynx.tasm.behavior.p000ui;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PropBundle {
    JavaOnlyMap props_map_ = new JavaOnlyMap();
    JavaOnlyArray event_handler_array_ = null;
    JavaOnlyArray gesture_detector_array_ = null;

    PropBundle() {
    }

    public ReadableMap getProps() {
        return this.props_map_;
    }

    public ReadableArray getEventHandlers() {
        return this.event_handler_array_;
    }

    public ReadableArray getGestures() {
        return this.gesture_detector_array_;
    }

    static PropBundle createPropBundle() {
        return new PropBundle();
    }

    void putNull(String str) {
        this.props_map_.putNull(str);
    }

    void putInt(String str, int i) {
        this.props_map_.putInt(str, i);
    }

    void putLong(String str, long j) {
        this.props_map_.putLong(str, j);
    }

    void putString(String str, String str2) {
        this.props_map_.putString(str, str2);
    }

    void putDouble(String str, double d) {
        this.props_map_.putDouble(str, d);
    }

    void putBool(String str, boolean z) {
        this.props_map_.putBoolean(str, z);
    }

    void putMap(String str, JavaOnlyMap javaOnlyMap) {
        this.props_map_.putMap(str, javaOnlyMap);
    }

    void putArray(String str, JavaOnlyArray javaOnlyArray) {
        this.props_map_.putArray(str, javaOnlyArray);
    }

    boolean contains(String str) {
        return this.props_map_.containsKey(str);
    }

    void putEventHandler(JavaOnlyMap javaOnlyMap) {
        if (this.event_handler_array_ == null) {
            this.event_handler_array_ = new JavaOnlyArray();
        }
        this.event_handler_array_.pushMap(javaOnlyMap);
    }

    void resetEventHandler() {
        JavaOnlyArray javaOnlyArray = this.event_handler_array_;
        if (javaOnlyArray == null) {
            return;
        }
        javaOnlyArray.clear();
    }

    void putGesture(JavaOnlyMap javaOnlyMap) {
        if (this.gesture_detector_array_ == null) {
            this.gesture_detector_array_ = new JavaOnlyArray();
        }
        this.gesture_detector_array_.pushMap(javaOnlyMap);
    }

    PropBundle shallowCopy() {
        PropBundle propBundle = new PropBundle();
        propBundle.props_map_ = JavaOnlyMap.shallowCopy(getProps());
        if (getEventHandlers() != null) {
            propBundle.event_handler_array_ = JavaOnlyArray.shallowCopy(getEventHandlers());
        }
        if (getGestures() != null) {
            propBundle.gesture_detector_array_ = JavaOnlyArray.shallowCopy(getGestures());
        }
        return propBundle;
    }
}
