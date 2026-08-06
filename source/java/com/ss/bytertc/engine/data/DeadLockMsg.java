package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class DeadLockMsg {
    public String blockPaths;
    public String blockSessionId;
    public boolean isCritical;

    public DeadLockMsg(String blockSessionId, String blockPaths, boolean isCritical) {
        this.blockSessionId = blockSessionId;
        this.blockPaths = blockPaths;
        this.isCritical = isCritical;
    }

    public String toString() {
        return "DeadLockMsg{blockSessionId:" + this.blockSessionId + "blockPths:" + this.blockPaths + "isCritical" + this.isCritical + "}";
    }
}
