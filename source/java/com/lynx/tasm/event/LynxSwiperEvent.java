package com.lynx.tasm.event;

import com.bytedance.apm.constant.PerfConsts;

/* loaded from: classes7.dex */
public class LynxSwiperEvent extends LynxDetailEvent {
    public static final String EVENT_CHANGE = "change";

    public LynxSwiperEvent(int i, String str) {
        super(i, str);
    }

    public static LynxSwiperEvent createSwiperEvent(int i, String str) {
        return new LynxSwiperEvent(i, str);
    }

    public void setScrollParmas(int i) {
        addDetail(PerfConsts.KEY_CURRENT_GALVANIC, Integer.valueOf(i));
    }
}
