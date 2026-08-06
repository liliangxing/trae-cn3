package com.lynx.tasm.gesture.handler;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.common.GestureExtraBundle;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class BaseGestureHandler {
    protected final GestureArenaMember mGestureArenaMember;
    protected final GestureDetector mGestureDetector;
    protected final LynxContext mLynxContext;
    protected int mSign;
    protected int mStatus = 0;
    protected final Map<String, Boolean> mEnableFlags = new HashMap();

    protected abstract void handleConfigMap(ReadableMap readableMap);

    protected abstract void onBegin(float f, float f2, LynxTouchEvent lynxTouchEvent);

    protected abstract void onEnd(float f, float f2, LynxTouchEvent lynxTouchEvent);

    protected abstract void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle);

    protected abstract void onStart(float f, float f2, LynxTouchEvent lynxTouchEvent);

    protected abstract void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle);

    public BaseGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        this.mSign = i;
        this.mLynxContext = lynxContext;
        this.mGestureDetector = gestureDetector;
        this.mGestureArenaMember = gestureArenaMember;
        handleEnableGestureCallback(gestureDetector.getGestureCallbackNames());
    }

    public static Map<Integer, BaseGestureHandler> convertToGestureHandler(int i, LynxContext lynxContext, GestureArenaMember gestureArenaMember, Map<Integer, GestureDetector> map) {
        HashMap hashMap = new HashMap();
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            GestureDetector gestureDetector = map.get(Integer.valueOf(it.next().intValue()));
            if (gestureDetector != null) {
                if (gestureDetector.getGestureType() == 0) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new PanGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                } else if (gestureDetector.getGestureType() == 2) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new DefaultGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                } else if (gestureDetector.getGestureType() == 1) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new FlingGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                } else if (gestureDetector.getGestureType() == 3) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new TapGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                } else if (gestureDetector.getGestureType() == 4) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new LongPressGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                } else if (gestureDetector.getGestureType() == 7) {
                    hashMap.put(Integer.valueOf(gestureDetector.getGestureType()), new NativeGestureHandler(i, lynxContext, gestureDetector, gestureArenaMember));
                }
            }
        }
        return hashMap;
    }

    private void handleEnableGestureCallback(List<String> list) {
        this.mEnableFlags.put(GestureConstants.ON_TOUCHES_DOWN, false);
        this.mEnableFlags.put(GestureConstants.ON_TOUCHES_MOVE, false);
        this.mEnableFlags.put(GestureConstants.ON_TOUCHES_UP, false);
        this.mEnableFlags.put(GestureConstants.ON_TOUCHES_CANCEL, false);
        this.mEnableFlags.put(GestureConstants.ON_BEGIN, false);
        this.mEnableFlags.put(GestureConstants.ON_UPDATE, false);
        this.mEnableFlags.put(GestureConstants.ON_START, false);
        this.mEnableFlags.put(GestureConstants.ON_END, false);
        if (list != null) {
            for (String str : list) {
                if (this.mEnableFlags.containsKey(str)) {
                    this.mEnableFlags.put(str, true);
                }
            }
        }
    }

    public void handleMotionEvent(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        onHandle(motionEvent, lynxTouchEvent, f, f2, z, gestureExtraBundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isEnd() {
        return this.mStatus == 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isActive() {
        return this.mStatus == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getGestureStatus() {
        return this.mStatus;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendGestureEvent(String str, HashMap<String, Object> hashMap) {
        if (this.mGestureDetector == null) {
            return;
        }
        this.mLynxContext.getEventEmitter().sendGestureEvent(this.mGestureDetector.getGestureID(), new LynxCustomEvent(this.mSign, str, hashMap));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnBeginEnable() {
        return this.mEnableFlags.get(GestureConstants.ON_BEGIN).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnUpdateEnable() {
        return this.mEnableFlags.get(GestureConstants.ON_UPDATE).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnStartEnable() {
        return this.mEnableFlags.get(GestureConstants.ON_START).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isOnEndEnable() {
        return this.mEnableFlags.get(GestureConstants.ON_END).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, Object> getEventParamsFromTouchEvent(LynxTouchEvent lynxTouchEvent) {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (lynxTouchEvent != null) {
            hashMap.put(FrescoMonitorConst.TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
            hashMap.put(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE, lynxTouchEvent.getName());
            if (lynxTouchEvent.getViewPoint() != null) {
                hashMap.put("x", Integer.valueOf(px2dip(lynxTouchEvent.getViewPoint().getX())));
                hashMap.put("y", Integer.valueOf(px2dip(lynxTouchEvent.getViewPoint().getY())));
            }
            if (lynxTouchEvent.getPagePoint() != null) {
                hashMap.put("pageX", Integer.valueOf(px2dip(lynxTouchEvent.getPagePoint().getX())));
                hashMap.put("pageY", Integer.valueOf(px2dip(lynxTouchEvent.getPagePoint().getY())));
            }
            if (lynxTouchEvent.getClientPoint() != null) {
                hashMap.put("clientX", Integer.valueOf(px2dip(lynxTouchEvent.getClientPoint().getX())));
                hashMap.put("clientY", Integer.valueOf(px2dip(lynxTouchEvent.getClientPoint().getY())));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int px2dip(float f) {
        LynxContext lynxContext = this.mLynxContext;
        return (lynxContext == null || lynxContext.getResources() == null || lynxContext.getResources().getDisplayMetrics() == null) ? (int) f : (int) ((f / lynxContext.getResources().getDisplayMetrics().density) + 0.5d);
    }

    public void activate() {
        this.mStatus = 2;
    }

    public void reset() {
        this.mStatus = 0;
    }

    public void fail() {
        this.mStatus = 3;
    }

    public void begin() {
        this.mStatus = 1;
    }

    public void ignore() {
        this.mStatus = 5;
    }

    public void end() {
        this.mStatus = 4;
    }

    public void onTouchesDown(LynxTouchEvent lynxTouchEvent) {
        if (this.mEnableFlags.get(GestureConstants.ON_TOUCHES_DOWN).booleanValue()) {
            sendGestureEvent(GestureConstants.ON_TOUCHES_DOWN, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    public void onTouchesMove(LynxTouchEvent lynxTouchEvent) {
        if (this.mEnableFlags.get(GestureConstants.ON_TOUCHES_MOVE).booleanValue()) {
            sendGestureEvent(GestureConstants.ON_TOUCHES_MOVE, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    public void onTouchesUp(LynxTouchEvent lynxTouchEvent) {
        if (this.mEnableFlags.get(GestureConstants.ON_TOUCHES_UP).booleanValue()) {
            sendGestureEvent(GestureConstants.ON_TOUCHES_UP, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    public void onTouchesCancel(LynxTouchEvent lynxTouchEvent) {
        if (this.mEnableFlags.get(GestureConstants.ON_TOUCHES_CANCEL).booleanValue()) {
            sendGestureEvent(GestureConstants.ON_TOUCHES_CANCEL, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }
}
