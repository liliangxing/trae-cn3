package com.lynx.tasm.gesture;

import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface GestureArenaMember {
    boolean canConsumeGesture(float f, float f2);

    int getGestureArenaMemberId();

    Map<Integer, GestureDetector> getGestureDetectorMap();

    Map<Integer, BaseGestureHandler> getGestureHandlers();

    int getMemberScrollX();

    int getMemberScrollY();

    int getScrollContainerDirection();

    int getSign();

    boolean isAtBorder(boolean z);

    void onGestureScrollBy(float f, float f2);

    void onInvalidate();
}
