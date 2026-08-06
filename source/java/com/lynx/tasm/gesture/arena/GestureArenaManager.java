package com.lynx.tasm.gesture.arena;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.detector.GestureDetectorManager;
import com.lynx.tasm.gesture.handler.GestureHandlerTrigger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GestureArenaManager {
    private static final String TAG = "GestureArenaManager";
    private Map<Integer, WeakReference<GestureArenaMember>> mArenaMemberMap;
    private LinkedList<GestureArenaMember> mBubbleCandidate;
    private LinkedList<GestureArenaMember> mCompeteChainCandidates;
    private GestureDetectorManager mGestureDetectorManager;
    private GestureHandlerTrigger mGestureHandlerTrigger;
    private boolean mIsEnableNewGesture;
    private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
    private GestureArenaMember mWinner;

    public void init(boolean z, LynxContext lynxContext) {
        this.mIsEnableNewGesture = z;
        if (isEnableNewGesture()) {
            this.mGestureDetectorManager = new GestureDetectorManager(this);
            this.mArenaMemberMap = new HashMap();
            this.mCompeteChainCandidates = new LinkedList<>();
            this.mBubbleCandidate = new LinkedList<>();
            this.mGestureHandlerTrigger = new GestureHandlerTrigger(lynxContext, this.mGestureDetectorManager);
        }
    }

    public void dispatchTouchEventToArena(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent) {
        GestureHandlerTrigger gestureHandlerTrigger;
        if (!isEnableNewGesture() || (gestureHandlerTrigger = this.mGestureHandlerTrigger) == null) {
            return;
        }
        gestureHandlerTrigger.resolveTouchEvent(motionEvent, this.mCompeteChainCandidates, lynxTouchEvent, this.mBubbleCandidate);
    }

    private boolean isEnableNewGesture() {
        if (LynxLiteConfigs.enableNewGesture()) {
            return this.mIsEnableNewGesture;
        }
        return false;
    }

    public void dispatchBubbleTouchEvent(String str, LynxTouchEvent lynxTouchEvent) {
        GestureHandlerTrigger gestureHandlerTrigger;
        if (!isEnableNewGesture() || (gestureHandlerTrigger = this.mGestureHandlerTrigger) == null) {
            return;
        }
        gestureHandlerTrigger.dispatchBubbleTouchEvent(str, lynxTouchEvent, this.mBubbleCandidate, this.mWinner);
    }

    public void setActiveUIToArenaAtDownEvent(EventTarget eventTarget) {
        GestureArenaMember gestureArenaMember;
        if (isEnableNewGesture()) {
            clearCurrentGesture();
            Map<Integer, WeakReference<GestureArenaMember>> map = this.mArenaMemberMap;
            if (map == null || map.isEmpty() || this.mGestureHandlerTrigger == null) {
                return;
            }
            while (eventTarget != null) {
                for (WeakReference<GestureArenaMember> weakReference : this.mArenaMemberMap.values()) {
                    if (weakReference != null && (gestureArenaMember = weakReference.get()) != null && gestureArenaMember.getGestureArenaMemberId() > 0 && gestureArenaMember.getGestureArenaMemberId() == eventTarget.getGestureArenaMemberId()) {
                        this.mBubbleCandidate.add(gestureArenaMember);
                    }
                }
                eventTarget = eventTarget.parent();
            }
            GestureDetectorManager gestureDetectorManager = this.mGestureDetectorManager;
            if (gestureDetectorManager != null) {
                this.mCompeteChainCandidates = gestureDetectorManager.convertResponseChainToCompeteChain(this.mBubbleCandidate);
            }
            LinkedList<GestureArenaMember> linkedList = this.mCompeteChainCandidates;
            if (linkedList != null && !linkedList.isEmpty()) {
                this.mWinner = this.mCompeteChainCandidates.getFirst();
            }
            this.mGestureHandlerTrigger.initCurrentWinnerWhenDown(this.mWinner);
        }
    }

    public void computeScroll() {
        Handler handler;
        if (!isEnableNewGesture() || this.mGestureHandlerTrigger == null || (handler = this.mMainThreadHandler) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.lynx.tasm.gesture.arena.GestureArenaManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                GestureArenaManager.this.m11xe7e7fc78();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$computeScroll$0$com-lynx-tasm-gesture-arena-GestureArenaManager */
    public /* synthetic */ void m11xe7e7fc78() {
        GestureHandlerTrigger gestureHandlerTrigger = this.mGestureHandlerTrigger;
        if (gestureHandlerTrigger != null) {
            gestureHandlerTrigger.computeScroll(this.mCompeteChainCandidates);
        }
    }

    private void clearCurrentGesture() {
        this.mWinner = null;
        LinkedList<GestureArenaMember> linkedList = this.mBubbleCandidate;
        if (linkedList != null) {
            linkedList.clear();
        }
        LinkedList<GestureArenaMember> linkedList2 = this.mCompeteChainCandidates;
        if (linkedList2 != null) {
            linkedList2.clear();
        }
    }

    public int addMember(GestureArenaMember gestureArenaMember) {
        Map<Integer, WeakReference<GestureArenaMember>> map;
        if (!isEnableNewGesture() || gestureArenaMember == null || (map = this.mArenaMemberMap) == null) {
            return 0;
        }
        map.put(Integer.valueOf(gestureArenaMember.getSign()), new WeakReference<>(gestureArenaMember));
        registerGestureDetectors(gestureArenaMember.getSign(), gestureArenaMember.getGestureDetectorMap());
        return gestureArenaMember.getSign();
    }

    public boolean isMemberExist(int i) {
        Map<Integer, WeakReference<GestureArenaMember>> map;
        if (!isEnableNewGesture() || (map = this.mArenaMemberMap) == null) {
            return false;
        }
        return map.containsKey(Integer.valueOf(i));
    }

    public void setGestureDetectorState(int i, int i2, int i3) {
        Map<Integer, WeakReference<GestureArenaMember>> map;
        if (!isEnableNewGesture() || this.mGestureHandlerTrigger == null || (map = this.mArenaMemberMap) == null) {
            return;
        }
        this.mGestureHandlerTrigger.handleGestureDetectorState(map.get(Integer.valueOf(i)).get(), i2, i3);
    }

    public void removeMember(GestureArenaMember gestureArenaMember) {
        Map<Integer, WeakReference<GestureArenaMember>> map;
        if (!isEnableNewGesture() || gestureArenaMember == null || (map = this.mArenaMemberMap) == null) {
            return;
        }
        map.remove(Integer.valueOf(gestureArenaMember.getGestureArenaMemberId()));
        unRegisterGestureDetectors(gestureArenaMember.getGestureArenaMemberId(), gestureArenaMember.getGestureDetectorMap());
    }

    public GestureArenaMember getMemberById(int i) {
        WeakReference<GestureArenaMember> weakReference = this.mArenaMemberMap.get(Integer.valueOf(i));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void onDestroy() {
        Map<Integer, WeakReference<GestureArenaMember>> map = this.mArenaMemberMap;
        if (map != null) {
            map.clear();
        }
        LinkedList<GestureArenaMember> linkedList = this.mCompeteChainCandidates;
        if (linkedList != null) {
            linkedList.clear();
        }
        LinkedList<GestureArenaMember> linkedList2 = this.mBubbleCandidate;
        if (linkedList2 != null) {
            linkedList2.clear();
        }
        GestureDetectorManager gestureDetectorManager = this.mGestureDetectorManager;
        if (gestureDetectorManager != null) {
            gestureDetectorManager.onDestroy();
        }
        GestureHandlerTrigger gestureHandlerTrigger = this.mGestureHandlerTrigger;
        if (gestureHandlerTrigger != null) {
            gestureHandlerTrigger.onDestroy();
        }
    }

    public void registerGestureDetectors(int i, Map<Integer, GestureDetector> map) {
        if (!isEnableNewGesture() || map == null || map.isEmpty() || this.mGestureDetectorManager == null) {
            return;
        }
        Iterator<Map.Entry<Integer, GestureDetector>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.mGestureDetectorManager.registerGestureDetector(i, it.next().getValue());
        }
    }

    public void unRegisterGestureDetectors(int i, Map<Integer, GestureDetector> map) {
        if (!isEnableNewGesture() || map == null || map.isEmpty() || this.mGestureDetectorManager == null) {
            return;
        }
        Iterator<Map.Entry<Integer, GestureDetector>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            this.mGestureDetectorManager.unregisterGestureDetector(i, it.next().getValue());
        }
    }
}
