package com.bytedance.applog.monitor;

import com.bytedance.applog.monitor.exception.AppLogExceptionManager;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.MonitorV3Helper;
import com.bytedance.applog.monitor.p006v3.StageEventBasic;
import com.bytedance.applog.monitor.p006v3.StageEventType;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Event;
import com.bytedance.applog.store.EventMisc;
import com.bytedance.applog.store.EventV3;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Terminate;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class MonitorUtils {
    public static boolean isEventWillStage(MonitorV3Helper monitorV3Helper, BaseData baseData) {
        if (!monitorV3Helper.isStageEnabled()) {
            return false;
        }
        if (baseData instanceof Event) {
            return monitorV3Helper.isEventHitStage(((Event) baseData).label);
        }
        if (baseData instanceof EventV3) {
            return monitorV3Helper.isEventHitStage(((EventV3) baseData).getEvent());
        }
        if (baseData instanceof EventMisc) {
            return monitorV3Helper.isEventHitStage(((EventMisc) baseData).getLogType());
        }
        if (baseData instanceof Launch) {
            return monitorV3Helper.isEventHitStage("launch");
        }
        if (baseData instanceof Terminate) {
            return monitorV3Helper.isEventHitStage("terminate");
        }
        return false;
    }

    public static boolean isEventMaybeAccepted(MonitorV3Helper monitorV3Helper, BaseData baseData) {
        if (!monitorV3Helper.isStageEnabled()) {
            return false;
        }
        if (baseData instanceof Event) {
            return monitorV3Helper.isEventMaybeAccepted(((Event) baseData).label);
        }
        if (baseData instanceof EventV3) {
            return monitorV3Helper.isEventMaybeAccepted(((EventV3) baseData).getEvent());
        }
        if (baseData instanceof EventMisc) {
            return monitorV3Helper.isEventMaybeAccepted(((EventMisc) baseData).getLogType());
        }
        if (baseData instanceof Launch) {
            return monitorV3Helper.isEventMaybeAccepted("launch");
        }
        if (baseData instanceof Terminate) {
            return monitorV3Helper.isEventMaybeAccepted("terminate");
        }
        return false;
    }

    public static void stageEvent(MonitorV3Helper monitorV3Helper, EventStage eventStage, BaseData baseData) {
        if (monitorV3Helper.isStageEnabled()) {
            if (baseData instanceof Event) {
                monitorV3Helper.stageEvent(eventStage, ((Event) baseData).tag, String.valueOf(baseData.monitorId), baseData.f80ts, StageEventType.V1_EVENT);
                return;
            }
            if (baseData instanceof EventV3) {
                monitorV3Helper.stageEvent(eventStage, ((EventV3) baseData).getEvent(), String.valueOf(baseData.monitorId), baseData.f80ts, StageEventType.V3_EVENT);
                return;
            }
            if (baseData instanceof EventMisc) {
                monitorV3Helper.stageEvent(eventStage, ((EventMisc) baseData).getLogType(), String.valueOf(baseData.monitorId), baseData.f80ts, StageEventType.LOG_DATA);
            } else if (baseData instanceof Launch) {
                monitorV3Helper.stageEvent(eventStage, "launch", String.valueOf(baseData.monitorId), baseData.f80ts, StageEventType.LAUNCH);
            } else if (baseData instanceof Terminate) {
                monitorV3Helper.stageEvent(eventStage, "terminate", String.valueOf(baseData.monitorId), baseData.f80ts, StageEventType.TERMINATE);
            }
        }
    }

    public static void stageEvent(MonitorV3Helper monitorV3Helper, EventStage eventStage, StageEventBasic stageEventBasic) {
        if (monitorV3Helper.isStageEnabled()) {
            monitorV3Helper.stageEvent(stageEventBasic.priorityName, stageEventBasic.groupId, eventStage, stageEventBasic.eventName, stageEventBasic.monitorId, stageEventBasic.f59ts, stageEventBasic.eventType);
        }
    }

    public static int getStainedValue(MonitorV3Helper monitorV3Helper, BaseData baseData) {
        if (isEventWillStage(monitorV3Helper, baseData)) {
            return monitorV3Helper.isDebugMode() ? 3 : 1;
        }
        return 0;
    }

    public static void addHighFrequencyEvent(BaseData baseData) {
        if (AppLogExceptionManager.getInstance().isEnabled()) {
            if (baseData instanceof Event) {
                AppLogExceptionManager.getInstance().addHighFrequencyEvent(StageEventType.V1_EVENT, ((Event) baseData).tag, baseData.f80ts);
            } else if (baseData instanceof EventV3) {
                AppLogExceptionManager.getInstance().addHighFrequencyEvent(StageEventType.V3_EVENT, ((EventV3) baseData).getEvent(), baseData.f80ts);
            } else if (baseData instanceof EventMisc) {
                AppLogExceptionManager.getInstance().addHighFrequencyEvent(StageEventType.LOG_DATA, ((EventMisc) baseData).getLogType(), baseData.f80ts);
            }
        }
    }
}
