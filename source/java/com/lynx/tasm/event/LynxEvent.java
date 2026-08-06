package com.lynx.tasm.event;

import com.lynx.tasm.behavior.event.EventTargetBase;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class LynxEvent {
    private long mEventID;
    private String mName;
    private int mTag;
    private EventTargetBase mTarget;
    private long mTimestamp;
    private LynxEventType mType;

    /* loaded from: classes7.dex */
    public enum LynxEventType {
        kNone,
        kTouch,
        kMouse,
        kWheel,
        kKeyboard,
        kCustom
    }

    public LynxEvent(int i, String str, LynxEventType lynxEventType) {
        this.mTag = -1;
        this.mName = "";
        LynxEventType lynxEventType2 = LynxEventType.kNone;
        this.mTarget = null;
        this.mTimestamp = 0L;
        this.mEventID = 0L;
        this.mTag = i;
        this.mName = str;
        this.mType = lynxEventType;
        this.mTimestamp = System.currentTimeMillis();
    }

    public int getTag() {
        return this.mTag;
    }

    public String getName() {
        return this.mName;
    }

    public LynxEventType getType() {
        return this.mType;
    }

    public void setTarget(EventTargetBase eventTargetBase) {
        this.mTarget = eventTargetBase;
    }

    public EventTargetBase getTarget() {
        return this.mTarget;
    }

    public void setTimestamp(long j) {
        this.mTimestamp = j;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void setEventID(long j) {
        this.mEventID = j;
    }

    public long getEventID() {
        return this.mEventID;
    }

    public ArrayList<Object> getEventParams() {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(this.mName);
        arrayList.add(Integer.valueOf(this.mType.ordinal()));
        arrayList.add(Integer.valueOf(this.mTag));
        arrayList.add(Long.valueOf(this.mTimestamp));
        arrayList.add(Long.valueOf(this.mEventID));
        return arrayList;
    }
}
