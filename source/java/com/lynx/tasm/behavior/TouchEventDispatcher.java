package com.lynx.tasm.behavior;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.GestureRecognizer;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.event.EventTargetBase;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.p000ui.utils.LynxUIHelper;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.utils.PixelUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TouchEventDispatcher {
    private static final String TAG = "LynxTouchEventDispatcher";
    public static final String mTapSlopDefault = "50px";
    public static final float mTapSlopFloatDefault = 50.0f;
    private EventTarget mActiveUI;
    private GestureRecognizer mDetector;
    private LynxTouchEvent mFirstLynxTouchEvent;
    private EventTarget mFocusedUI;
    private GestureArenaManager mGestureArenaManager;
    private boolean mGestureRecognized;
    private PointF mPrePoint;
    private EventTarget mPreTarget;
    private String mPreTargetInlineCSSText;
    private LynxTouchEvent.Point mTargetPoint;
    private boolean mTouchMoved;
    private boolean mTouchMoving;
    private boolean mTouchOutSide;
    private LynxUIOwner mUIOwner;
    private EventTarget.EnableStatus mConsumeSlideEvent = EventTarget.EnableStatus.Undefined;
    private boolean mCanConsumeSlideEvent = false;
    private long mTimestamp = 0;
    private LinkedList<EventTarget> mActiveUIList = new LinkedList<>();
    private LinkedList<EventTarget> mActiveClickList = new LinkedList<>();
    private PointF mDownPoint = new PointF(Float.MIN_VALUE, Float.MIN_VALUE);
    private LynxTouchEvent.Point mFirstFingerDownPoint = new LynxTouchEvent.Point();
    private float mTapSlop = PixelUtils.dipToPx(50.0f);
    private float mMoveSlop = 0.0f;
    private boolean mShouldCheckMove = true;
    private final HashSet<Integer> mGestureRecognizedUISet = new HashSet<>();
    private final HashSet<Integer> mPropsChangedUISet = new HashSet<>();
    private boolean mHasTouchPseudo = false;
    private boolean mHasMultiTouch = false;
    private boolean mEnableMultiTouch = false;
    private HashMap<Integer, EventTargetDetail> mActiveUIMap = new HashMap<>();
    private HashMap<Integer, EventTargetBase> mActiveTargetMap = new HashMap<>();

    public void destroy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class EventTargetDetail {
        private final EventTarget mActiveUI;
        private final PointF mDownPoint;
        private PointF mPrePoint;

        public EventTargetDetail(EventTarget eventTarget, float f, float f2) {
            this.mActiveUI = eventTarget;
            this.mDownPoint = new PointF(f, f2);
            this.mPrePoint = new PointF(f, f2);
        }

        public EventTarget getUI() {
            return this.mActiveUI;
        }

        public PointF getDownPoint() {
            return this.mDownPoint;
        }

        public PointF getPrePoint() {
            return this.mPrePoint;
        }

        public void setPrePoint(PointF pointF) {
            this.mPrePoint = pointF;
        }
    }

    public TouchEventDispatcher(LynxUIOwner lynxUIOwner) {
        this.mUIOwner = lynxUIOwner;
        this.mDetector = new GestureRecognizer(this.mUIOwner.getContext(), new Listener(), new Handler(Looper.getMainLooper()));
        this.mGestureArenaManager = lynxUIOwner.getGestureArenaManager();
    }

    public void attachContext(Context context) {
        GestureRecognizer gestureRecognizer = this.mDetector;
        if (gestureRecognizer != null) {
            gestureRecognizer.updateTouchSlop(context);
        }
    }

    public void onGestureRecognized() {
        this.mGestureRecognized = true;
        if (this.mActiveUIList.isEmpty()) {
            return;
        }
        deactivatePseudoState(8);
    }

    public void setGestureArenaManager(GestureArenaManager gestureArenaManager) {
        this.mGestureArenaManager = gestureArenaManager;
    }

    public void onGestureRecognized(LynxBaseUI lynxBaseUI) {
        HashSet<Integer> hashSet = this.mGestureRecognizedUISet;
        if (hashSet != null) {
            hashSet.add(Integer.valueOf(lynxBaseUI.getSign()));
        }
    }

    public void onGestureRecognized(int i) {
        HashSet<Integer> hashSet = this.mGestureRecognizedUISet;
        if (hashSet != null) {
            hashSet.add(Integer.valueOf(i));
        }
    }

    public void onPropsChanged(LynxBaseUI lynxBaseUI) {
        HashSet<Integer> hashSet = this.mPropsChangedUISet;
        if (hashSet != null) {
            hashSet.add(Integer.valueOf(lynxBaseUI.getSign()));
        }
    }

    public boolean isTouchMoving() {
        return this.mTouchMoving;
    }

    public void setHasTouchPseudo(boolean z) {
        this.mHasTouchPseudo = this.mHasTouchPseudo || z;
    }

    public void setEnableMultiTouch(boolean z) {
        this.mEnableMultiTouch = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean requestNativeDisallowIntercept(boolean z) {
        if (this.mUIOwner.getRootUI() == null || ((UIBody.UIBodyView) this.mUIOwner.getRootUI().getView()).getParent() == null) {
            LLog.e(TAG, "requestNativeDisallowIntercept failed, root ui or root ui'parent is null.");
            return false;
        }
        ((UIBody.UIBodyView) this.mUIOwner.getRootUI().getView()).getParent().requestDisallowInterceptTouchEvent(z);
        return z;
    }

    public boolean consumeSlideEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mConsumeSlideEvent = EventTarget.EnableStatus.Undefined;
            this.mCanConsumeSlideEvent = false;
            EventTarget eventTarget = this.mActiveUI;
            if (eventTarget != null) {
                while (eventTarget != null && eventTarget.parent() != eventTarget) {
                    if (eventTarget.hasConsumeSlideEventAngles()) {
                        this.mCanConsumeSlideEvent = true;
                    }
                    eventTarget = eventTarget.parent();
                }
            }
            boolean z = this.mCanConsumeSlideEvent;
            if (z) {
                requestNativeDisallowIntercept(z);
            }
            return false;
        }
        if (action == 2) {
            if (!this.mCanConsumeSlideEvent) {
                return false;
            }
            float x = motionEvent.getX() - this.mDownPoint.x;
            float y = motionEvent.getY() - this.mDownPoint.y;
            if (Math.abs(x) <= PixelUtils.dipToPx(10.0f) && Math.abs(y) <= PixelUtils.dipToPx(10.0f)) {
                requestNativeDisallowIntercept(true);
                return false;
            }
            if (this.mConsumeSlideEvent == EventTarget.EnableStatus.Undefined) {
                this.mConsumeSlideEvent = EventTarget.EnableStatus.Disable;
                double atan2 = (Math.atan2(y, x) * 180.0f) / 3.141592653589793d;
                EventTarget eventTarget2 = this.mActiveUI;
                while (true) {
                    if (eventTarget2 == null || eventTarget2.parent() == eventTarget2) {
                        break;
                    }
                    if (eventTarget2.consumeSlideEvent((float) atan2)) {
                        this.mConsumeSlideEvent = EventTarget.EnableStatus.Enable;
                        break;
                    }
                    eventTarget2 = eventTarget2.parent();
                }
            }
        }
        return requestNativeDisallowIntercept(this.mConsumeSlideEvent == EventTarget.EnableStatus.Enable);
    }

    public boolean blockNativeEvent(MotionEvent motionEvent) {
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null) {
            return false;
        }
        while (eventTarget != null && eventTarget.parent() != eventTarget) {
            if (eventTarget.blockNativeEvent(motionEvent)) {
                return true;
            }
            eventTarget = eventTarget.parent();
        }
        return false;
    }

    public boolean eventThrough() {
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null) {
            return false;
        }
        return eventTarget.eventThrough(this.mFirstFingerDownPoint.getX(), this.mFirstFingerDownPoint.getY());
    }

    public void setTapSlop(float f) {
        this.mTapSlop = f;
    }

    private int checkCanRespondTapOrClick(EventTarget eventTarget, HashSet hashSet) {
        if (eventTarget == null) {
            return 0;
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return -1;
        }
        while (eventTarget != null && eventTarget.parent() != eventTarget) {
            if (hashSet.contains(Integer.valueOf(eventTarget.getSign()))) {
                return eventTarget.getSign();
            }
            eventTarget = eventTarget.parent();
        }
        return -1;
    }

    private int canRespondTapOrClick(EventTarget eventTarget) {
        return checkCanRespondTapOrClick(eventTarget, this.mGestureRecognizedUISet);
    }

    private int canRespondTapOrClickWhenUISlideWithProps(EventTarget eventTarget) {
        return checkCanRespondTapOrClick(eventTarget, this.mPropsChangedUISet);
    }

    private void initTouchEnv(MotionEvent motionEvent) {
        this.mTouchMoved = false;
        this.mTouchMoving = false;
        this.mShouldCheckMove = true;
        this.mDownPoint = new PointF(motionEvent.getX(), motionEvent.getY());
        this.mGestureRecognized = false;
        this.mPrePoint = new PointF(motionEvent.getX(), motionEvent.getY());
        this.mGestureRecognizedUISet.clear();
        this.mPropsChangedUISet.clear();
        this.mHasMultiTouch = false;
        this.mActiveUIMap.clear();
        this.mActiveTargetMap.clear();
    }

    private void initClickEnv() {
        this.mActiveClickList.clear();
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null) {
            return;
        }
        while (eventTarget != null) {
            this.mActiveClickList.push(eventTarget);
            eventTarget = eventTarget.parent();
        }
        while (!this.mActiveClickList.isEmpty() && (this.mActiveClickList.getLast().getEvents() == null || !this.mActiveClickList.getLast().getEvents().containsKey(LynxTouchEvent.EVENT_CLICK))) {
            this.mActiveClickList.removeLast();
        }
        Iterator<EventTarget> it = this.mActiveClickList.iterator();
        while (it.hasNext()) {
            it.next().onResponseChain();
        }
        if (this.mActiveClickList.isEmpty()) {
            this.mTouchOutSide = true;
        } else {
            this.mTouchOutSide = false;
        }
    }

    private boolean onTouchMove(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        EventTargetDetail eventTargetDetail = this.mActiveUIMap.get(Integer.valueOf(motionEvent.getPointerId(i)));
        boolean z3 = true;
        if (eventTargetDetail != null) {
            PointF prePoint = eventTargetDetail.getPrePoint();
            PointF downPoint = eventTargetDetail.getDownPoint();
            if (!this.mEnableMultiTouch) {
                downPoint = this.mDownPoint;
            }
            if (prePoint.x == motionEvent.getX(i) && prePoint.y == motionEvent.getY(i)) {
                z = false;
                z2 = false;
            } else {
                if (Math.abs(downPoint.x - motionEvent.getX(i)) > this.mTapSlop || Math.abs(downPoint.y - motionEvent.getY(i)) > this.mTapSlop) {
                    this.mTouchMoved = true;
                    if (motionEvent.getPointerId(i) == 0) {
                        z = true;
                        prePoint.x = motionEvent.getX(i);
                        prePoint.y = motionEvent.getY(i);
                        this.mPrePoint = prePoint;
                        z2 = true;
                    }
                }
                z = false;
                prePoint.x = motionEvent.getX(i);
                prePoint.y = motionEvent.getY(i);
                this.mPrePoint = prePoint;
                z2 = true;
            }
            eventTargetDetail.setPrePoint(prePoint);
        } else {
            z = false;
            z2 = false;
        }
        if (z2) {
            EventTarget findUI = findUI(motionEvent, i, this.mUIOwner.getRootUI());
            if (!this.mGestureRecognized && ((this.mActiveClickList.isEmpty() || canRespondTapOrClick(this.mActiveClickList.getLast()) == -1) && !this.mTouchOutSide && !eventOutSideActiveList(motionEvent, findUI))) {
                z3 = false;
            }
            this.mTouchOutSide = z3;
            if ((!this.mActiveUIList.isEmpty() && !this.mEnableMultiTouch && this.mTouchMoved) || ((this.mEnableMultiTouch && z) || canRespondTapOrClick(this.mActiveUI) != -1 || canRespondTapOrClickWhenUISlideWithProps(this.mActiveUI) != -1)) {
                deactivatePseudoState(8);
            }
        }
        return z2;
    }

    public void fireClick(MotionEvent motionEvent) {
        UIBody uIBody;
        if (this.mActiveClickList.isEmpty() || this.mActiveClickList.getLast() == null) {
            return;
        }
        int canRespondTapOrClick = canRespondTapOrClick(this.mActiveClickList.getLast());
        int canRespondTapOrClickWhenUISlideWithProps = canRespondTapOrClickWhenUISlideWithProps(this.mActiveClickList.getLast());
        if ((!this.mEnableMultiTouch || !this.mHasMultiTouch) && !this.mTouchOutSide && !this.mGestureRecognized && !this.mActiveClickList.isEmpty() && this.mActiveClickList.getLast() != null && canRespondTapOrClick == -1 && canRespondTapOrClickWhenUISlideWithProps == -1) {
            dispatchEvent(this.mActiveClickList.getLast(), LynxTouchEvent.EVENT_CLICK, motionEvent);
        }
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().fireClick(motionEvent);
    }

    public void fireTap(MotionEvent motionEvent) {
        UIBody uIBody;
        int canRespondTapOrClick = canRespondTapOrClick(this.mActiveUI);
        int canRespondTapOrClickWhenUISlideWithProps = canRespondTapOrClickWhenUISlideWithProps(this.mActiveUI);
        if ((!this.mEnableMultiTouch || !this.mHasMultiTouch) && !this.mGestureRecognized && !this.mTouchMoved && canRespondTapOrClick == -1 && canRespondTapOrClickWhenUISlideWithProps == -1) {
            if (LynxEnv.inst().isHighlightTouchEnabled()) {
                showMessageOnConsole("LynxTouchEventDispatcher: fire tap for target " + this.mActiveUI.getSign(), LogBoxLogLevel.Info.ordinal());
            }
            dispatchEvent(this.mActiveUI, LynxTouchEvent.EVENT_TAP, motionEvent);
        } else {
            if (LynxEnv.inst().isHighlightTouchEnabled()) {
                showMessageOnConsole("LynxTouchEventDispatcher: tap failed due to [gesture] " + this.mGestureRecognized + ", [move] " + this.mTouchMoved + ", [slide] " + canRespondTapOrClick + ", [props] " + canRespondTapOrClickWhenUISlideWithProps, LogBoxLogLevel.Warn.ordinal());
            }
            LLog.i(TAG, "tap failed:" + this.mGestureRecognized + " " + this.mTouchMoved + " " + canRespondTapOrClick + " " + canRespondTapOrClickWhenUISlideWithProps);
        }
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().fireTap(motionEvent);
    }

    public void fireLongpress(MotionEvent motionEvent) {
        EventTarget eventTarget;
        UIBody uIBody;
        int canRespondTapOrClick = canRespondTapOrClick(this.mActiveUI);
        int canRespondTapOrClickWhenUISlideWithProps = canRespondTapOrClickWhenUISlideWithProps(this.mActiveUI);
        if ((!this.mEnableMultiTouch || !this.mHasMultiTouch) && (eventTarget = this.mActiveUI) != null && canRespondTapOrClick == -1 && canRespondTapOrClickWhenUISlideWithProps == -1) {
            dispatchEvent(eventTarget, LynxTouchEvent.EVENT_LONG_PRESS, motionEvent);
        }
        EventTarget eventTarget2 = this.mActiveUI;
        if (eventTarget2 == null || eventTarget2.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().fireLongpress(motionEvent);
    }

    private void resetEnv() {
        Iterator<EventTarget> it = this.mActiveClickList.iterator();
        while (it.hasNext()) {
            it.next().offResponseChain();
        }
        this.mActiveUIList.clear();
        this.mActiveClickList.clear();
        this.mGestureRecognizedUISet.clear();
        this.mPropsChangedUISet.clear();
        this.mTouchMoved = false;
        this.mTouchMoving = false;
        this.mShouldCheckMove = true;
        this.mHasMultiTouch = false;
        this.mActiveUIMap.clear();
        this.mActiveTargetMap.clear();
        this.mPreTarget = this.mActiveUI;
    }

    private void onActionDown(MotionEvent motionEvent) {
        if (eventEmitter() == null) {
            return;
        }
        for (EventTarget eventTarget = this.mActiveUI; eventTarget != null; eventTarget = eventTarget.parent()) {
            this.mActiveUIList.push(eventTarget);
            if (!eventTarget.enableTouchPseudoPropagation()) {
                break;
            }
        }
        for (int i = 0; i < this.mActiveUIList.size(); i++) {
            EventTarget eventTarget2 = this.mActiveUIList.get(i);
            if (this.mHasTouchPseudo) {
                eventEmitter().onPseudoStatusChanged(eventTarget2.getSign(), 0, 8);
            }
            eventTarget2.onPseudoStatusChanged(0, 8);
        }
    }

    void onActionMove(MotionEvent motionEvent, EventTarget eventTarget) {
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        if (lynxUIOwner == null || lynxUIOwner.getRootUI() == null || this.mActiveUIList.isEmpty() || eventEmitter() == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        while (eventTarget != null) {
            linkedList.push(eventTarget);
            if (!eventTarget.enableTouchPseudoPropagation()) {
                break;
            } else {
                eventTarget = eventTarget.parent();
            }
        }
        int i = -1;
        for (int i2 = 0; i2 < this.mActiveUIList.size() && i2 < linkedList.size(); i2++) {
            if (this.mActiveUIList.get(i2).getSign() != ((EventTarget) linkedList.get(i2)).getSign()) {
                break;
            }
            i = i2;
        }
        int size = this.mActiveUIList.size();
        while (true) {
            size--;
            if (size < i + 1) {
                return;
            }
            EventTarget eventTarget2 = this.mActiveUIList.get(size);
            if (this.mHasTouchPseudo) {
                eventEmitter().onPseudoStatusChanged(eventTarget2.getSign(), 8, 0);
            }
            eventTarget2.onPseudoStatusChanged(8, 0);
            this.mActiveUIList.remove(size);
        }
    }

    private void onActionUpOrCancel(MotionEvent motionEvent) {
        deactivatePseudoState(-1);
    }

    private void deactivatePseudoState(int i) {
        if (eventEmitter() == null) {
            return;
        }
        Iterator<EventTarget> it = this.mActiveUIList.iterator();
        while (it.hasNext()) {
            EventTarget next = it.next();
            if (this.mHasTouchPseudo) {
                eventEmitter().onPseudoStatusChanged(next.getSign(), next.getPseudoStatus(), next.getPseudoStatus() & (~i));
            }
            next.onPseudoStatusChanged(next.getPseudoStatus(), next.getPseudoStatus() & (~i));
        }
    }

    private void dispatchEvent(String str, MotionEvent motionEvent, JavaOnlyMap javaOnlyMap) {
        LynxTouchEvent initialFirstLynxTouchEvent = initialFirstLynxTouchEvent(this.mActiveUI, str, motionEvent);
        this.mFirstLynxTouchEvent = initialFirstLynxTouchEvent;
        initialFirstLynxTouchEvent.setMotionEvent(motionEvent);
        LynxTouchEvent lynxTouchEvent = new LynxTouchEvent(str, javaOnlyMap);
        lynxTouchEvent.setMotionEvent(motionEvent);
        lynxTouchEvent.setActiveTargetMap(this.mActiveTargetMap);
        lynxTouchEvent.setTarget(this.mActiveUI);
        lynxTouchEvent.setTimestamp(this.mTimestamp);
        GestureArenaManager gestureArenaManager = this.mGestureArenaManager;
        if (gestureArenaManager != null) {
            gestureArenaManager.dispatchBubbleTouchEvent(str, this.mFirstLynxTouchEvent);
        }
        eventEmitter().sendMultiTouchEvent(lynxTouchEvent);
    }

    private void dispatchEvent(EventTarget eventTarget, String str, MotionEvent motionEvent) {
        this.mTargetPoint = convertToViewPoint(this.mActiveUI, new LynxTouchEvent.Point(motionEvent.getX(0), motionEvent.getY(0)));
        LynxTouchEvent.Point point = new LynxTouchEvent.Point(motionEvent.getX(0), motionEvent.getY(0));
        PointF convertPointFromUIToScreen = LynxUIHelper.convertPointFromUIToScreen(this.mUIOwner.getRootUI(), new PointF(point.getX(), point.getY()));
        LynxTouchEvent lynxTouchEvent = new LynxTouchEvent(eventTarget.getSign(), str, new LynxTouchEvent.Point(convertPointFromUIToScreen.x, convertPointFromUIToScreen.y), point, this.mTargetPoint);
        this.mFirstLynxTouchEvent = lynxTouchEvent;
        lynxTouchEvent.setMotionEvent(motionEvent);
        this.mFirstLynxTouchEvent.setTarget(this.mActiveUI);
        this.mFirstLynxTouchEvent.setTimestamp(this.mTimestamp);
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(str)) {
            inspectHitTarget();
            if (LynxEnv.inst().isHighlightTouchEnabled()) {
                showMessageOnConsole("LynxTouchEventDispatcher: hit the target with sign = " + eventTarget.getSign(), LogBoxLogLevel.Info.ordinal());
            }
        }
        if (eventEmitter() == null) {
            LLog.i(TAG, "dispatchEvent failed since eventEmitter() null");
            return;
        }
        GestureArenaManager gestureArenaManager = this.mGestureArenaManager;
        if (gestureArenaManager != null) {
            gestureArenaManager.dispatchBubbleTouchEvent(str, this.mFirstLynxTouchEvent);
        }
        eventEmitter().sendTouchEvent(this.mFirstLynxTouchEvent);
    }

    private void showMessageOnConsole(String str, int i) {
        LynxBaseInspectorOwner baseInspectorOwner;
        if (this.mUIOwner.getRootUI() == null || this.mUIOwner.getRootUI().getBodyView() == null || (baseInspectorOwner = this.mUIOwner.getRootUI().getBodyView().getBaseInspectorOwner()) == null) {
            return;
        }
        baseInspectorOwner.showMessageOnConsole(str, i);
    }

    private void inspectHitTarget() {
        final LynxBaseInspectorOwner baseInspectorOwner;
        if (!LynxEnv.inst().isHighlightTouchEnabled() || this.mActiveUI == null || this.mUIOwner.getRootUI() == null || this.mUIOwner.getRootUI().getBodyView() == null || (baseInspectorOwner = this.mUIOwner.getRootUI().getBodyView().getBaseInspectorOwner()) == null) {
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", 1);
            jSONObject.put("method", "DOM.setAttributesAsText");
            if (this.mPreTarget != null && this.mPreTargetInlineCSSText != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("nodeId", this.mPreTarget.getSign());
                jSONObject2.put(PropsConstants.TEXT, String.format("style=\"%s\"", this.mPreTargetInlineCSSText));
                jSONObject2.put("name", "style");
                jSONObject.put("params", jSONObject2);
                baseInspectorOwner.invokeCDPFromSDK(jSONObject.toString(), new CDPResultCallback() { // from class: com.lynx.tasm.behavior.TouchEventDispatcher.1
                    public void onResult(String str) {
                        LLog.i(TouchEventDispatcher.TAG, "DOM.setAttributesAsText:" + str);
                    }
                });
            }
            jSONObject.put("method", "CSS.getInlineStylesForNode");
            final JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("nodeId", this.mActiveUI.getSign());
            jSONObject.put("params", jSONObject3);
            baseInspectorOwner.invokeCDPFromSDK(jSONObject.toString(), new CDPResultCallback() { // from class: com.lynx.tasm.behavior.TouchEventDispatcher.2
                public void onResult(String str) {
                    try {
                        TouchEventDispatcher.this.setAttributeByInvokeCDP(jSONObject, jSONObject3, baseInspectorOwner, str);
                    } catch (JSONException e) {
                        LLog.e(TouchEventDispatcher.TAG, "setAttributeByInvokeCDP error:" + e.toString());
                    }
                }
            });
        } catch (Exception unused) {
            LLog.e(TAG, "inspectHitTarget json generate error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAttributeByInvokeCDP(JSONObject jSONObject, JSONObject jSONObject2, LynxBaseInspectorOwner lynxBaseInspectorOwner, String str) throws JSONException {
        Matcher matcher = Pattern.compile("\"cssText\"\\s*:\\s*\"([^\"]*)\"").matcher(str);
        if (matcher.find()) {
            this.mPreTargetInlineCSSText = matcher.group(1);
        }
        StringBuilder sb = new StringBuilder();
        String str2 = this.mPreTargetInlineCSSText;
        if (str2 == null) {
            str2 = "";
        }
        String sb2 = sb.append(str2).append("background-color:#9CC4E6;border-width:2px;border-color:red;").toString();
        jSONObject.put("method", "DOM.setAttributesAsText");
        jSONObject2.put(PropsConstants.TEXT, String.format("style=\"%s\"", sb2));
        jSONObject2.put("name", "style");
        jSONObject.put("params", jSONObject2);
        lynxBaseInspectorOwner.invokeCDPFromSDK(jSONObject.toString(), new CDPResultCallback() { // from class: com.lynx.tasm.behavior.TouchEventDispatcher.3
            public void onResult(String str3) {
                LLog.i(TouchEventDispatcher.TAG, "DOM.setAttributesAsText:" + str3);
            }
        });
    }

    private boolean shouldTriggerMove(MotionEvent motionEvent) {
        if (this.mShouldCheckMove) {
            float x = motionEvent.getX(0) - this.mDownPoint.x;
            float y = motionEvent.getY(0) - this.mDownPoint.y;
            if (Math.abs(x) <= this.mMoveSlop && Math.abs(y) <= this.mMoveSlop) {
                return false;
            }
            this.mShouldCheckMove = false;
        }
        return true;
    }

    public boolean handleFirstTouchDown(MotionEvent motionEvent, UIGroup uIGroup) {
        UIGroup uIGroup2;
        this.mFirstFingerDownPoint.setX(0.0f);
        this.mFirstFingerDownPoint.setY(0.0f);
        this.mActiveUI = findUI(motionEvent, 0, uIGroup);
        LynxTouchEvent.Point point = new LynxTouchEvent.Point(motionEvent.getX(), motionEvent.getY());
        this.mFirstFingerDownPoint = point;
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget instanceof LynxBaseUI) {
            this.mFirstFingerDownPoint = convertToViewPoint(eventTarget, point);
        }
        EventTarget eventTarget2 = this.mActiveUI;
        if (eventTarget2 != null && eventTarget2.eventThrough(this.mFirstFingerDownPoint.getX(), this.mFirstFingerDownPoint.getY())) {
            return false;
        }
        initTouchEnv(motionEvent);
        initClickEnv();
        this.mActiveUIMap.put(Integer.valueOf(motionEvent.getPointerId(0)), new EventTargetDetail(this.mActiveUI, motionEvent.getX(0), motionEvent.getY(0)));
        this.mActiveTargetMap.put(Integer.valueOf(this.mActiveUI.getSign()), this.mActiveUI);
        GestureArenaManager gestureArenaManager = this.mGestureArenaManager;
        if (gestureArenaManager != null) {
            gestureArenaManager.setActiveUIToArenaAtDownEvent(this.mActiveUI);
        }
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        if (this.mUIOwner.getContext().getLongPressDuration() >= 0) {
            longPressTimeout = this.mUIOwner.getContext().getLongPressDuration();
        }
        this.mDetector.setLongPressTimeout(longPressTimeout);
        if (this.mEnableMultiTouch) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            addMap(javaOnlyMap, motionEvent, 0);
            dispatchEvent(LynxTouchEvent.EVENT_TOUCH_START, motionEvent, javaOnlyMap);
        } else {
            dispatchEvent(this.mActiveUI, LynxTouchEvent.EVENT_TOUCH_START, motionEvent);
        }
        onActionDown(motionEvent);
        EventTarget eventTarget3 = this.mActiveUI;
        if (eventTarget3 == null || eventTarget3.getChildrenLynxPageUI() == null || (uIGroup2 = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIGroup2.getLynxContext() == null || uIGroup2.getLynxContext().getTouchEventDispatcher() == null) {
            return true;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIGroup2.getLynxContext().getTouchEventDispatcher().handleFirstTouchDown(motionEvent, uIGroup2);
        return true;
    }

    public void handleOtherTouchDown(MotionEvent motionEvent, UIGroup uIGroup) {
        UIGroup uIGroup2;
        this.mHasMultiTouch = true;
        int actionIndex = motionEvent.getActionIndex();
        EventTarget findUI = findUI(motionEvent, actionIndex, uIGroup);
        this.mActiveUIMap.put(Integer.valueOf(motionEvent.getPointerId(actionIndex)), new EventTargetDetail(findUI, motionEvent.getX(actionIndex), motionEvent.getY(actionIndex)));
        this.mActiveTargetMap.put(Integer.valueOf(findUI.getSign()), findUI);
        if (this.mEnableMultiTouch) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            addMap(javaOnlyMap, motionEvent, actionIndex);
            dispatchEvent(LynxTouchEvent.EVENT_TOUCH_START, motionEvent, javaOnlyMap);
        }
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIGroup2 = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIGroup2.getLynxContext() == null || uIGroup2.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIGroup2.getLynxContext().getTouchEventDispatcher().handleOtherTouchDown(motionEvent, uIGroup2);
    }

    public void handleTouchMove(MotionEvent motionEvent) {
        UIBody uIBody;
        if (shouldTriggerMove(motionEvent)) {
            this.mTouchMoving = true;
            if (this.mEnableMultiTouch) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                    if (onTouchMove(motionEvent, i)) {
                        addMap(javaOnlyMap, motionEvent, i);
                    }
                }
                dispatchEvent(LynxTouchEvent.EVENT_TOUCH_MOVE, motionEvent, javaOnlyMap);
            } else if (onTouchMove(motionEvent, 0)) {
                dispatchEvent(this.mActiveUI, LynxTouchEvent.EVENT_TOUCH_MOVE, motionEvent);
            }
        }
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().handleTouchMove(motionEvent);
    }

    public void handleOtherTouchUp(MotionEvent motionEvent) {
        UIBody uIBody;
        int actionIndex = motionEvent.getActionIndex();
        if (this.mEnableMultiTouch) {
            if (motionEvent.getPointerId(actionIndex) == 0) {
                onActionUpOrCancel(motionEvent);
            }
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            addMap(javaOnlyMap, motionEvent, actionIndex);
            dispatchEvent(LynxTouchEvent.EVENT_TOUCH_END, motionEvent, javaOnlyMap);
        }
        this.mActiveUIMap.remove(Integer.valueOf(motionEvent.getPointerId(actionIndex)));
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().handleOtherTouchUp(motionEvent);
    }

    public void handleFirstTouchUp(MotionEvent motionEvent) {
        UIBody uIBody;
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget != null && !eventTarget.ignoreFocus() && !this.mGestureRecognized && canRespondTapOrClick(this.mActiveUI) == -1 && canRespondTapOrClickWhenUISlideWithProps(this.mActiveUI) == -1) {
            EventTarget eventTarget2 = this.mFocusedUI;
            EventTarget eventTarget3 = this.mActiveUI;
            this.mFocusedUI = eventTarget3;
            if (eventTarget3 != eventTarget2) {
                if (eventTarget3 != null && eventTarget3.isFocusable()) {
                    this.mActiveUI.onFocusChanged(true, eventTarget2 != null && eventTarget2.isFocusable());
                }
                if (eventTarget2 != null && eventTarget2.isFocusable()) {
                    EventTarget eventTarget4 = this.mActiveUI;
                    eventTarget2.onFocusChanged(false, eventTarget4 != null && eventTarget4.isFocusable());
                }
            }
        }
        if (this.mEnableMultiTouch) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            addMap(javaOnlyMap, motionEvent, 0);
            dispatchEvent(LynxTouchEvent.EVENT_TOUCH_END, motionEvent, javaOnlyMap);
        } else {
            dispatchEvent(this.mActiveUI, LynxTouchEvent.EVENT_TOUCH_END, motionEvent);
        }
        EventTarget eventTarget5 = this.mActiveUI;
        if (eventTarget5 == null || eventTarget5.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().handleFirstTouchUp(motionEvent);
    }

    public void handleTouchCancel(MotionEvent motionEvent) {
        UIBody uIBody;
        if (this.mEnableMultiTouch) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            for (EventTargetDetail eventTargetDetail : this.mActiveUIMap.values()) {
                addMap(javaOnlyMap, motionEvent, 0);
            }
            dispatchEvent(LynxTouchEvent.EVENT_TOUCH_CANCEL, motionEvent, javaOnlyMap);
        } else {
            dispatchEvent(this.mActiveUI, LynxTouchEvent.EVENT_TOUCH_CANCEL, motionEvent);
        }
        onActionUpOrCancel(motionEvent);
        resetEnv();
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget == null || eventTarget.getChildrenLynxPageUI() == null || (uIBody = (UIBody) this.mActiveUI.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this.mActiveUI)))) == null || uIBody.getLynxContext() == null || uIBody.getLynxContext().getTouchEventDispatcher() == null) {
            return;
        }
        motionEvent.setLocation(this.mFirstLynxTouchEvent.getViewPoint().getX(), this.mFirstLynxTouchEvent.getViewPoint().getY());
        uIBody.getLynxContext().getTouchEventDispatcher().handleTouchCancel(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, UIGroup uIGroup) {
        this.mTimestamp = System.currentTimeMillis();
        if (motionEvent.getActionMasked() == 0) {
            if (!handleFirstTouchDown(motionEvent, uIGroup)) {
                LLog.i(TAG, "hit event through");
                return false;
            }
        } else if (motionEvent.getActionMasked() == 5) {
            handleOtherTouchDown(motionEvent, uIGroup);
        } else if (this.mActiveUI != null && !this.mActiveUIMap.isEmpty()) {
            if (this.mActiveUI.eventThrough(this.mFirstFingerDownPoint.getX(), this.mFirstFingerDownPoint.getY())) {
                LLog.i(TAG, "hit event through");
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1) {
                handleFirstTouchUp(motionEvent);
                onActionUpOrCancel(motionEvent);
                fireClick(motionEvent);
                fireTap(motionEvent);
                resetEnv();
            } else if (actionMasked == 2) {
                handleTouchMove(motionEvent);
            } else if (actionMasked == 3) {
                handleTouchCancel(motionEvent);
            } else if (actionMasked == 6) {
                handleOtherTouchUp(motionEvent);
            }
        }
        EventTarget eventTarget = this.mActiveUI;
        if (eventTarget != null && eventTarget.eventThrough(this.mFirstFingerDownPoint.getX(), this.mFirstFingerDownPoint.getY())) {
            LLog.i(TAG, "hit event through");
            return false;
        }
        EventTarget eventTarget2 = this.mActiveUI;
        if (eventTarget2 != null) {
            eventTarget2.dispatchTouch(motionEvent);
        }
        this.mDetector.onTouchEvent(motionEvent);
        GestureArenaManager gestureArenaManager = this.mGestureArenaManager;
        if (gestureArenaManager != null) {
            gestureArenaManager.dispatchTouchEventToArena(motionEvent, this.mFirstLynxTouchEvent);
        }
        return true;
    }

    private void addMap(JavaOnlyMap javaOnlyMap, MotionEvent motionEvent, int i) {
        EventTargetDetail eventTargetDetail = this.mActiveUIMap.get(Integer.valueOf(motionEvent.getPointerId(i)));
        if (eventTargetDetail == null) {
            return;
        }
        EventTarget ui = eventTargetDetail.getUI();
        String valueOf = String.valueOf(ui.getSign());
        ReadableArray array = javaOnlyMap.getArray(valueOf);
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        LynxTouchEvent.Point point = new LynxTouchEvent.Point(motionEvent.getX(i), motionEvent.getY(i));
        LynxTouchEvent.Point convertToViewPoint = ui instanceof LynxBaseUI ? convertToViewPoint(ui, point) : point;
        PointF convertPointFromUIToScreen = LynxUIHelper.convertPointFromUIToScreen(this.mUIOwner.getRootUI(), new PointF(point.getX(), point.getY()));
        LynxTouchEvent.Point point2 = new LynxTouchEvent.Point(convertPointFromUIToScreen.x, convertPointFromUIToScreen.y);
        javaOnlyArray.add(Integer.valueOf(motionEvent.getPointerId(i)));
        javaOnlyArray.add(Float.valueOf(point2.getX()));
        javaOnlyArray.add(Float.valueOf(point2.getY()));
        javaOnlyArray.add(Float.valueOf(point.getX()));
        javaOnlyArray.add(Float.valueOf(point.getY()));
        javaOnlyArray.add(Float.valueOf(convertToViewPoint.getX()));
        javaOnlyArray.add(Float.valueOf(convertToViewPoint.getY()));
        if (array != null) {
            array.asArrayList().add(javaOnlyArray);
            return;
        }
        JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
        javaOnlyArray2.add(javaOnlyArray);
        javaOnlyMap.putArray(valueOf, javaOnlyArray2);
    }

    public void setFocusedUI(LynxBaseUI lynxBaseUI) {
        this.mFocusedUI = lynxBaseUI;
    }

    private LynxTouchEvent.Point convertToViewPoint(EventTarget eventTarget, LynxTouchEvent.Point point) {
        if (!(eventTarget instanceof LynxBaseUI)) {
            return point;
        }
        RectF convertRectFromUIToRootUI = LynxUIHelper.convertRectFromUIToRootUI((LynxBaseUI) eventTarget, new RectF(0.0f, 0.0f, r5.getWidth(), r5.getHeight()));
        return new LynxTouchEvent.Point(point.getX() - convertRectFromUIToRootUI.left, point.getY() - convertRectFromUIToRootUI.top);
    }

    private LynxTouchEvent initialFirstLynxTouchEvent(EventTarget eventTarget, String str, MotionEvent motionEvent) {
        LynxTouchEvent.Point point = new LynxTouchEvent.Point(motionEvent.getX(), motionEvent.getY());
        PointF convertPointFromUIToScreen = LynxUIHelper.convertPointFromUIToScreen(this.mUIOwner.getRootUI(), new PointF(point.getX(), point.getY()));
        return new LynxTouchEvent(eventTarget.getSign(), str, new LynxTouchEvent.Point(convertPointFromUIToScreen.x, convertPointFromUIToScreen.y), point, this.mTargetPoint);
    }

    private EventEmitter eventEmitter() {
        return this.mUIOwner.getContext().getEventEmitter();
    }

    private EventTarget findUI(MotionEvent motionEvent, int i, UIGroup uIGroup) {
        if (uIGroup == null) {
            uIGroup = this.mUIOwner.getRootUI();
        }
        return uIGroup.hitTest(motionEvent.getX(i), motionEvent.getY(i));
    }

    private boolean eventOutSideActiveList(MotionEvent motionEvent, EventTarget eventTarget) {
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        if (lynxUIOwner == null || lynxUIOwner.getRootUI() == null) {
            return true;
        }
        LinkedList linkedList = new LinkedList();
        while (eventTarget != null) {
            linkedList.push(eventTarget);
            eventTarget = eventTarget.parent();
        }
        if (linkedList.size() < this.mActiveClickList.size()) {
            return true;
        }
        for (int i = 0; i < this.mActiveClickList.size(); i++) {
            EventTarget eventTarget2 = this.mActiveClickList.get(i);
            if (eventTarget2 == null || eventTarget2 != linkedList.get(i)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class Listener extends GestureRecognizer.SimpleOnGestureListener {
        private Listener() {
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.SimpleOnGestureListener, com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchEventDispatcher.this.fireLongpress(motionEvent);
            super.onLongPress(motionEvent);
        }
    }

    public void reset() {
        this.mActiveUI = null;
        this.mFocusedUI = null;
        this.mActiveClickList.clear();
    }
}
