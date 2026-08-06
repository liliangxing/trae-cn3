package com.ss.bytertc.engine.type;

import java.util.List;

/* loaded from: classes7.dex */
public class ProblemFeedbackInfo {
    public String problemDesc;
    public List<ProblemFeedbackRoomInfo> roomInfo;

    public ProblemFeedbackInfo() {
    }

    public ProblemFeedbackInfo(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getProblemDesc() {
        return this.problemDesc;
    }

    public ProblemFeedbackRoomInfo[] getRoomInfo() {
        List<ProblemFeedbackRoomInfo> list = this.roomInfo;
        if (list == null) {
            return null;
        }
        return (ProblemFeedbackRoomInfo[]) list.toArray(new ProblemFeedbackRoomInfo[0]);
    }
}
