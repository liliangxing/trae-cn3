package com.lynx.tasm.behavior.p000ui;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.gesture.detector.GestureDetector;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIParams {
    public Map<String, EventsListener> mEventsListenerMap;
    public Map<Integer, GestureDetector> mGestureDetectors;
    public StylesDiffMap mInitialProps;
    public boolean mIsFlatten;
    public int mNodeIndex;
    public int mSign;
    public String mTagName;

    public UIParams(int i, int i2, boolean z, String str, StylesDiffMap stylesDiffMap, Map<String, EventsListener> map, Map<Integer, GestureDetector> map2) {
        this.mSign = i;
        this.mNodeIndex = i2;
        this.mIsFlatten = z;
        this.mTagName = str;
        this.mInitialProps = stylesDiffMap;
        this.mEventsListenerMap = map;
        this.mGestureDetectors = map2;
    }
}
