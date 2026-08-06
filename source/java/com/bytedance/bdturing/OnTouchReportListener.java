package com.bytedance.bdturing;

import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class OnTouchReportListener {
    private static int DEFAULT_EVENTS_LIMIT = 6000;
    private static final double INTERVAL = 33.3333d;
    private List<TouchEvent> mEventList = new ArrayList();
    private volatile boolean mEventListLocked = false;
    private int mMaxEvents;

    public OnTouchReportListener(int i) {
        int i2 = DEFAULT_EVENTS_LIMIT;
        this.mMaxEvents = i2;
        if (i > i2) {
            this.mMaxEvents = i;
        }
    }

    public void onTouch(MotionEvent motionEvent) {
        int i;
        if (this.mEventListLocked) {
            return;
        }
        try {
            if (this.mEventList.size() < this.mMaxEvents) {
                i = motionEvent.getAction();
                try {
                    TouchEvent touchEvent = new TouchEvent();
                    touchEvent.pressure = motionEvent.getPressure();
                    touchEvent.majorRadius = motionEvent.getTouchMajor();
                    touchEvent.x = motionEvent.getX();
                    touchEvent.y = motionEvent.getY();
                    touchEvent.timestamp = motionEvent.getEventTime();
                    touchEvent.actionType = motionEvent.getAction();
                    this.mEventList.add(touchEvent);
                    LogUtil.d("onTouch", "events : " + this.mEventList.size());
                } catch (Exception unused) {
                    if (i != 1) {
                        return;
                    }
                    this.mEventListLocked = true;
                    uploadEvent();
                } catch (Throwable th) {
                    th = th;
                    if (i == 1) {
                        this.mEventListLocked = true;
                        uploadEvent();
                    }
                    throw th;
                }
            } else {
                i = 1;
            }
            if (i != 1) {
                return;
            }
        } catch (Exception unused2) {
            i = 1;
        } catch (Throwable th2) {
            th = th2;
            i = 1;
        }
        this.mEventListLocked = true;
        uploadEvent();
    }

    private void uploadEvent() {
        try {
            VerifyTaskHandler.getInstance().postRunnable(new Runnable() { // from class: com.bytedance.bdturing.OnTouchReportListener.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int size = OnTouchReportListener.this.mEventList.size() - 1;
                        double d = ((TouchEvent) OnTouchReportListener.this.mEventList.get(size)).timestamp;
                        while (size >= 0) {
                            TouchEvent touchEvent = (TouchEvent) OnTouchReportListener.this.mEventList.get(size);
                            if (d >= touchEvent.timestamp || size == 0) {
                                UserMotionManager.collectUserMotion(touchEvent.timestamp, touchEvent.pressure, touchEvent.majorRadius, touchEvent.actionType, touchEvent.x, touchEvent.y);
                                d -= OnTouchReportListener.INTERVAL;
                                LogUtil.i("onTouch", "uploadEvent use " + touchEvent.timestamp + " " + touchEvent.actionType);
                            } else {
                                LogUtil.i("onTouch", "uploadEvent abandon " + touchEvent.timestamp + " " + touchEvent.actionType);
                            }
                            size--;
                        }
                        OnTouchReportListener.this.mEventList.clear();
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        OnTouchReportListener.this.mEventListLocked = false;
                        throw th;
                    }
                    OnTouchReportListener.this.mEventListLocked = false;
                }
            });
        } catch (Exception unused) {
        }
    }

    /* loaded from: classes3.dex */
    class TouchEvent {
        int actionType;
        float majorRadius;
        float pressure;
        long timestamp;
        float x;
        float y;

        TouchEvent() {
        }
    }
}
