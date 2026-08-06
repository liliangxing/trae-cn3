package com.lynx.tasm.gesture.handler;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.OverScroller;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.common.GestureExtraBundle;
import com.lynx.tasm.gesture.detector.GestureDetectorManager;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GestureHandlerTrigger {
    private static final String TAG = "GestureHandlerTrigger";
    private LynxContext mContext;
    private GestureExtraBundle mCurrentGestureExtraBundle;
    private GestureArenaMember mDuplicatedMember;
    private final GestureDetectorManager mGestureDetectorManager;
    private int mLastFlingScrollX;
    private int mLastFlingScrollY;
    private int mLastFlingTargetId;
    private GestureArenaMember mLastFlingWinner;
    private GestureArenaMember mLastWinner;
    private final OverScroller mScroller;
    private HashSet<Integer> mSimultaneousGestureIds;
    private HashSet<GestureArenaMember> mSimultaneousWinners;
    private VelocityTracker mVelocityTracker;
    private GestureArenaMember mWinner;

    public GestureHandlerTrigger(LynxContext lynxContext, GestureDetectorManager gestureDetectorManager) {
        this.mScroller = new OverScroller(lynxContext);
        this.mContext = lynxContext;
        this.mGestureDetectorManager = gestureDetectorManager;
    }

    public void initCurrentWinnerWhenDown(GestureArenaMember gestureArenaMember) {
        this.mWinner = gestureArenaMember;
        updateLastWinner(gestureArenaMember);
        updateSimultaneousWinner(this.mWinner);
        resetGestureHandlerAndSimultaneous(this.mWinner);
        this.mCurrentGestureExtraBundle = new GestureExtraBundle();
    }

    public void resolveTouchEvent(MotionEvent motionEvent, LinkedList<GestureArenaMember> linkedList, LynxTouchEvent lynxTouchEvent, LinkedList<GestureArenaMember> linkedList2) {
        int i;
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetCandidatesGestures(linkedList);
            stopFlingByLastFlingMember(lynxTouchEvent, linkedList, linkedList2, motionEvent);
            dispatchMotionEventWithSimultaneousAndReCompete(this.mWinner, motionEvent.getX(), motionEvent.getY(), lynxTouchEvent, linkedList, motionEvent);
            findNextWinnerInBegin(lynxTouchEvent, linkedList, motionEvent.getX(), motionEvent.getY(), motionEvent);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                GestureArenaMember reCompeteByGestures = reCompeteByGestures(linkedList, this.mWinner);
                this.mWinner = reCompeteByGestures;
                if (reCompeteByGestures == this.mLastWinner) {
                    dispatchMotionEventWithSimultaneous(reCompeteByGestures, motionEvent.getX(), motionEvent.getY(), lynxTouchEvent, motionEvent);
                }
                findNextWinnerInBegin(lynxTouchEvent, linkedList, motionEvent.getX(), motionEvent.getY(), motionEvent);
                return;
            }
            if (actionMasked != 3) {
                return;
            }
        }
        dispatchMotionEventWithSimultaneousAndReCompete(this.mWinner, motionEvent.getX(), motionEvent.getY(), null, linkedList, motionEvent);
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.computeCurrentVelocity(1000);
            i = LynxUIHelper.px2dip(this.mContext, this.mVelocityTracker.getXVelocity());
            i2 = LynxUIHelper.px2dip(this.mContext, this.mVelocityTracker.getYVelocity());
        } else {
            i = 0;
            i2 = 0;
        }
        if (this.mWinner != null && (Math.abs(i) > 300 || Math.abs(i2) > 300)) {
            startGestureFling();
        } else {
            dispatchMotionEventWithSimultaneousAndReCompete(this.mWinner, Float.MIN_VALUE, Float.MIN_VALUE, null, linkedList, null);
        }
    }

    private void resetCandidatesGestures(List<GestureArenaMember> list) {
        if (list == null) {
            return;
        }
        Iterator<GestureArenaMember> it = list.iterator();
        while (it.hasNext()) {
            resetGestureHandlerAndSimultaneous(it.next());
        }
        this.mDuplicatedMember = null;
    }

    private void failOthersMembersInRaceRelation(GestureArenaMember gestureArenaMember, int i, Set<Integer> set) {
        Map<Integer, BaseGestureHandler> gestureHandlers;
        if (gestureArenaMember == null || (gestureHandlers = gestureArenaMember.getGestureHandlers()) == null) {
            return;
        }
        for (BaseGestureHandler baseGestureHandler : gestureHandlers.values()) {
            if (baseGestureHandler.getGestureDetector().getGestureID() != i && !set.contains(Integer.valueOf(baseGestureHandler.getGestureDetector().getGestureID()))) {
                baseGestureHandler.fail();
            }
        }
    }

    private void stopFlingByLastFlingMember(LynxTouchEvent lynxTouchEvent, LinkedList<GestureArenaMember> linkedList, LinkedList<GestureArenaMember> linkedList2, MotionEvent motionEvent) {
        if (linkedList2 == null) {
            return;
        }
        Iterator<GestureArenaMember> it = linkedList2.iterator();
        while (it.hasNext()) {
            GestureArenaMember next = it.next();
            if ((this.mWinner != null && this.mLastFlingTargetId == next.getGestureArenaMemberId()) || this.mLastFlingTargetId == 0) {
                this.mLastFlingTargetId = 0;
                if (this.mScroller.isFinished()) {
                    return;
                }
                dispatchMotionEventWithSimultaneousAndReCompete(this.mWinner, 0.0f, 0.0f, lynxTouchEvent, linkedList, motionEvent);
                this.mScroller.abortAnimation();
                LynxContext lynxContext = this.mContext;
                if (lynxContext != null) {
                    lynxContext.onGestureRecognized();
                    return;
                }
                return;
            }
        }
    }

    private void findNextWinnerInBegin(LynxTouchEvent lynxTouchEvent, LinkedList<GestureArenaMember> linkedList, float f, float f2, MotionEvent motionEvent) {
        for (int i = 0; i < linkedList.size(); i++) {
            GestureArenaMember gestureArenaMember = this.mWinner;
            if (gestureArenaMember == this.mLastWinner || gestureArenaMember == null) {
                return;
            }
            updateLastWinner(gestureArenaMember);
            updateSimultaneousWinner(this.mWinner);
            dispatchMotionEventWithSimultaneousAndReCompete(this.mWinner, f, f2, lynxTouchEvent, linkedList, motionEvent);
        }
        dispatchMotionEventWithSimultaneousAndReCompete(this.mLastWinner, f, f2, lynxTouchEvent, linkedList, motionEvent);
    }

    public void computeScroll(LinkedList<GestureArenaMember> linkedList) {
        if (this.mScroller.computeScrollOffset()) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int i = currX - this.mLastFlingScrollX;
            int i2 = currY - this.mLastFlingScrollY;
            this.mLastFlingScrollX = currX;
            this.mLastFlingScrollY = currY;
            this.mLastFlingWinner = reCompeteByGestures(linkedList, this.mLastFlingWinner);
            findNextWinnerInBegin(null, linkedList, 0.0f, 0.0f, null);
            GestureArenaMember gestureArenaMember = this.mLastFlingWinner;
            if (gestureArenaMember != null) {
                this.mLastFlingTargetId = gestureArenaMember.getGestureArenaMemberId();
                dispatchMotionEventWithSimultaneous(this.mLastFlingWinner, i, i2, null, null);
                if (this.mScroller.isFinished()) {
                    dispatchMotionEventWithSimultaneousAndReCompete(this.mLastFlingWinner, Float.MIN_VALUE, Float.MIN_VALUE, null, linkedList, null);
                    return;
                }
                return;
            }
            this.mLastFlingTargetId = 0;
            if (this.mScroller.isFinished()) {
                return;
            }
            this.mScroller.abortAnimation();
        }
    }

    private void updateSimultaneousWinner(GestureArenaMember gestureArenaMember) {
        Pair<HashSet<GestureArenaMember>, HashSet<Integer>> handleSimultaneousWinner = this.mGestureDetectorManager.handleSimultaneousWinner(gestureArenaMember);
        if (handleSimultaneousWinner == null) {
            return;
        }
        this.mSimultaneousWinners = (HashSet) handleSimultaneousWinner.first;
        this.mSimultaneousGestureIds = (HashSet) handleSimultaneousWinner.second;
    }

    private void updateLastWinner(GestureArenaMember gestureArenaMember) {
        if (this.mLastWinner != gestureArenaMember) {
            this.mLastWinner = gestureArenaMember;
        }
    }

    private GestureArenaMember reCompeteByGestures(LinkedList<GestureArenaMember> linkedList, GestureArenaMember gestureArenaMember) {
        boolean z;
        GestureArenaMember gestureArenaMember2;
        if ((gestureArenaMember == null && this.mLastWinner == null) || linkedList == null) {
            return null;
        }
        if (gestureArenaMember != null || (gestureArenaMember2 = this.mLastWinner) == null) {
            z = false;
        } else {
            resetGestureHandlerAndSimultaneous(gestureArenaMember2);
            z = true;
            gestureArenaMember = gestureArenaMember2;
        }
        int currentMemberState = getCurrentMemberState(gestureArenaMember);
        if (currentMemberState <= 2) {
            return gestureArenaMember;
        }
        if (currentMemberState == 4 || z) {
            return null;
        }
        int indexOf = linkedList.indexOf(gestureArenaMember);
        int lastIndexOf = linkedList.lastIndexOf(gestureArenaMember);
        if (indexOf != lastIndexOf) {
            GestureArenaMember gestureArenaMember3 = this.mDuplicatedMember;
            if (gestureArenaMember3 != null) {
                resetGestureHandlerAndSimultaneous(gestureArenaMember3);
                indexOf = lastIndexOf;
            } else {
                this.mDuplicatedMember = linkedList.get(indexOf);
            }
        }
        if (indexOf >= 0 && indexOf < linkedList.size()) {
            int gestureArenaMemberId = linkedList.get(indexOf).getGestureArenaMemberId();
            for (int i = indexOf + 1; i < linkedList.size(); i++) {
                GestureArenaMember gestureArenaMember4 = linkedList.get(i);
                if (gestureArenaMember4.getGestureArenaMemberId() != gestureArenaMemberId) {
                    if (this.mDuplicatedMember == gestureArenaMember4) {
                        this.mDuplicatedMember = null;
                    } else {
                        resetGestureHandlerAndSimultaneous(gestureArenaMember4);
                    }
                    int currentMemberState2 = getCurrentMemberState(gestureArenaMember4);
                    if (currentMemberState2 <= 2) {
                        return gestureArenaMember4;
                    }
                    if (currentMemberState2 == 4) {
                        return null;
                    }
                }
            }
            for (int i2 = 0; i2 < indexOf; i2++) {
                GestureArenaMember gestureArenaMember5 = linkedList.get(i2);
                if (gestureArenaMember5.getGestureArenaMemberId() != gestureArenaMemberId) {
                    if (this.mDuplicatedMember == gestureArenaMember5) {
                        this.mDuplicatedMember = null;
                    } else {
                        resetGestureHandlerAndSimultaneous(gestureArenaMember5);
                    }
                    int currentMemberState3 = getCurrentMemberState(gestureArenaMember5);
                    if (currentMemberState3 <= 2) {
                        return gestureArenaMember5;
                    }
                    if (currentMemberState3 == 4) {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private void dispatchMotionEventOnCurrentWinner(MotionEvent motionEvent, GestureArenaMember gestureArenaMember, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        Map<Integer, BaseGestureHandler> gestureHandlers;
        if (gestureArenaMember == null || (gestureHandlers = gestureArenaMember.getGestureHandlers()) == null) {
            return;
        }
        Iterator<BaseGestureHandler> it = gestureHandlers.values().iterator();
        while (it.hasNext()) {
            it.next().handleMotionEvent(motionEvent, lynxTouchEvent, f, f2, z, gestureExtraBundle);
        }
    }

    private int getCurrentMemberState(GestureArenaMember gestureArenaMember) {
        Map<Integer, BaseGestureHandler> gestureHandlers;
        if (gestureArenaMember == null || (gestureHandlers = gestureArenaMember.getGestureHandlers()) == null) {
            return 3;
        }
        int i = -1;
        for (BaseGestureHandler baseGestureHandler : gestureHandlers.values()) {
            if (baseGestureHandler.isEnd()) {
                resetGestureHandlerAndSimultaneous(gestureArenaMember);
                this.mLastWinner = null;
                return 4;
            }
            if (baseGestureHandler.isActive()) {
                failOthersMembersInRaceRelation(gestureArenaMember, baseGestureHandler.getGestureDetector().getGestureID(), this.mSimultaneousGestureIds);
                return 2;
            }
            if (i < 0) {
                i = baseGestureHandler.getGestureStatus();
            } else if (i > baseGestureHandler.getGestureStatus()) {
                i = baseGestureHandler.getGestureStatus();
            }
        }
        return i;
    }

    private void resetGestureHandlerAndSimultaneous(GestureArenaMember gestureArenaMember) {
        resetGestureHandler(gestureArenaMember);
        HashSet<GestureArenaMember> hashSet = this.mSimultaneousWinners;
        if (hashSet != null) {
            Iterator<GestureArenaMember> it = hashSet.iterator();
            while (it.hasNext()) {
                resetGestureHandler(it.next());
            }
        }
    }

    private void resetGestureHandler(GestureArenaMember gestureArenaMember) {
        Map<Integer, BaseGestureHandler> gestureHandlers;
        if (gestureArenaMember == null || (gestureHandlers = gestureArenaMember.getGestureHandlers()) == null) {
            return;
        }
        Iterator<BaseGestureHandler> it = gestureHandlers.values().iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            try {
                velocityTracker.recycle();
            } catch (IllegalStateException e) {
                LLog.e(TAG, e.toString());
            }
            this.mVelocityTracker = null;
        }
    }

    private void startGestureFling() {
        GestureArenaMember gestureArenaMember = this.mWinner;
        if (gestureArenaMember == null || this.mVelocityTracker == null) {
            return;
        }
        this.mLastFlingWinner = gestureArenaMember;
        this.mScroller.fling(gestureArenaMember.getMemberScrollX(), this.mLastFlingWinner.getMemberScrollY(), (int) (-this.mVelocityTracker.getXVelocity()), (int) (-this.mVelocityTracker.getYVelocity()), Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
        this.mLastFlingWinner.onInvalidate();
        this.mLastFlingScrollX = this.mLastFlingWinner.getMemberScrollX();
        this.mLastFlingScrollY = this.mLastFlingWinner.getMemberScrollY();
    }

    private void dispatchMotionEventWithSimultaneous(GestureArenaMember gestureArenaMember, float f, float f2, LynxTouchEvent lynxTouchEvent, MotionEvent motionEvent) {
        dispatchMotionEventWithSimultaneousAndReCompete(gestureArenaMember, f, f2, lynxTouchEvent, null, motionEvent);
    }

    private void dispatchMotionEventWithSimultaneousAndReCompete(GestureArenaMember gestureArenaMember, float f, float f2, LynxTouchEvent lynxTouchEvent, LinkedList<GestureArenaMember> linkedList, MotionEvent motionEvent) {
        if (gestureArenaMember == null) {
            return;
        }
        dispatchMotionEventOnCurrentWinner(motionEvent, gestureArenaMember, lynxTouchEvent, f, f2, false, this.mCurrentGestureExtraBundle);
        HashSet<GestureArenaMember> hashSet = this.mSimultaneousWinners;
        if (hashSet != null) {
            Iterator<GestureArenaMember> it = hashSet.iterator();
            while (it.hasNext()) {
                dispatchMotionEventOnCurrentWinner(motionEvent, it.next(), lynxTouchEvent, f, f2, true, this.mCurrentGestureExtraBundle);
            }
            this.mCurrentGestureExtraBundle.resetSimultaneousDelta();
        }
        if (linkedList != null) {
            this.mWinner = reCompeteByGestures(linkedList, this.mWinner);
        }
    }

    public void handleGestureDetectorState(GestureArenaMember gestureArenaMember, int i, int i2) {
        if (gestureArenaMember == null) {
            return;
        }
        BaseGestureHandler gestureHandlerById = getGestureHandlerById(gestureArenaMember, i);
        if (i2 == 2) {
            if (gestureHandlerById != null) {
                gestureHandlerById.fail();
            }
        } else if (i2 == 3 && gestureHandlerById != null) {
            gestureHandlerById.end();
        }
    }

    public BaseGestureHandler getGestureHandlerById(GestureArenaMember gestureArenaMember, int i) {
        Map<Integer, BaseGestureHandler> gestureHandlers = gestureArenaMember.getGestureHandlers();
        if (gestureHandlers == null) {
            return null;
        }
        for (BaseGestureHandler baseGestureHandler : gestureHandlers.values()) {
            if (baseGestureHandler.getGestureDetector().getGestureID() == i) {
                return baseGestureHandler;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0059. Please report as an issue. */
    public void dispatchBubbleTouchEvent(String str, LynxTouchEvent lynxTouchEvent, LinkedList<GestureArenaMember> linkedList, GestureArenaMember gestureArenaMember) {
        if (gestureArenaMember == null) {
            return;
        }
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(str) || LynxTouchEvent.EVENT_TOUCH_MOVE.equals(str) || LynxTouchEvent.EVENT_TOUCH_CANCEL.equals(str) || LynxTouchEvent.EVENT_TOUCH_END.equals(str)) {
            for (int i = 0; i < linkedList.size(); i++) {
                Map<Integer, BaseGestureHandler> gestureHandlers = linkedList.get(i).getGestureHandlers();
                if (gestureHandlers != null) {
                    for (BaseGestureHandler baseGestureHandler : gestureHandlers.values()) {
                        str.hashCode();
                        char c = 65535;
                        switch (str.hashCode()) {
                            case -1578593149:
                                if (str.equals(LynxTouchEvent.EVENT_TOUCH_START)) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case -819532484:
                                if (str.equals(LynxTouchEvent.EVENT_TOUCH_END)) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 364536720:
                                if (str.equals(LynxTouchEvent.EVENT_TOUCH_MOVE)) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 2127979129:
                                if (str.equals(LynxTouchEvent.EVENT_TOUCH_CANCEL)) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                                baseGestureHandler.onTouchesDown(lynxTouchEvent);
                                break;
                            case 1:
                                baseGestureHandler.onTouchesUp(lynxTouchEvent);
                                break;
                            case 2:
                                baseGestureHandler.onTouchesMove(lynxTouchEvent);
                                break;
                            case 3:
                                baseGestureHandler.onTouchesCancel(lynxTouchEvent);
                                break;
                        }
                    }
                }
            }
        }
    }

    public void onDestroy() {
        recycleVelocityTracker();
        this.mContext = null;
        HashSet<GestureArenaMember> hashSet = this.mSimultaneousWinners;
        if (hashSet != null) {
            hashSet.clear();
        }
    }
}
