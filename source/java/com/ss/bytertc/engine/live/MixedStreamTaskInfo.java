package com.ss.bytertc.engine.live;

/* loaded from: classes7.dex */
public class MixedStreamTaskInfo {
    private String taskId = "";
    private MixedStreamPushTargetType targetType = MixedStreamPushTargetType.PUSH_TO_CDN;

    public MixedStreamTaskInfo setTargetType(MixedStreamPushTargetType targetType) {
        this.targetType = targetType;
        return this;
    }

    public MixedStreamPushTargetType getTargetType() {
        return this.targetType;
    }

    public MixedStreamTaskInfo setTaskId(String taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public static MixedStreamTaskInfo from(String taskId, int id) {
        MixedStreamTaskInfo mixedStreamTaskInfo = new MixedStreamTaskInfo();
        if (id == 0) {
            mixedStreamTaskInfo.setTargetType(MixedStreamPushTargetType.PUSH_TO_CDN);
        } else if (id == 1) {
            mixedStreamTaskInfo.setTargetType(MixedStreamPushTargetType.PUSH_TO_WTN);
        } else {
            mixedStreamTaskInfo.setTargetType(MixedStreamPushTargetType.PUSH_TO_CDN);
        }
        mixedStreamTaskInfo.setTaskId(taskId);
        return mixedStreamTaskInfo;
    }
}
