package com.bytedance.ies.web.jsbridge2;

import java.util.List;

/* loaded from: classes4.dex */
public class TimeLineEventSummary {
    public List<TimeLineEvent> jsbCallTimeLineEvents;
    public List<TimeLineEvent> jsbInstanceTimeLineEvents;
    public List<TimeLineEvent> sdkInitTimeLineEvents;

    public TimeLineEventSummary(List<TimeLineEvent> list, List<TimeLineEvent> list2, List<TimeLineEvent> list3) {
        this.sdkInitTimeLineEvents = list;
        this.jsbInstanceTimeLineEvents = list2;
        this.jsbCallTimeLineEvents = list3;
    }
}
