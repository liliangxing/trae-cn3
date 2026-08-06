package com.bytedance.apm.block;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BlockRecord {
    long beginTime;
    JSONObject cpuInfo;
    long currentTime;
    boolean ignoreStack;
    String lastScene;
    JSONObject looperMessages;
    JSONObject memoryInfo;
    String msg;
    JSONObject perfInfo;
    StackTraceElement[] stackTrace;
    StackTraceElement[] stackTrace2;
    String trace;
    long traceTime;
    long traceTime2;
    String uuid;
    boolean isValid = true;
    boolean belongDump = false;
    boolean belongFrame = false;
    boolean delayInputEvent = false;
    boolean delayDoFrame = false;
    long endTime = -1;
    boolean isSeriousBlock = false;
    boolean isPollOnce = false;
    volatile boolean isErrorStack = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockRecord(long j, String str) {
        this.beginTime = -1L;
        this.beginTime = j;
        this.msg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BlockRecord getCopy() {
        BlockRecord blockRecord = new BlockRecord(this.beginTime, this.msg);
        blockRecord.endTime = this.endTime;
        blockRecord.isValid = this.isValid;
        blockRecord.belongDump = this.belongDump;
        blockRecord.belongFrame = this.belongFrame;
        blockRecord.delayInputEvent = this.delayInputEvent;
        blockRecord.delayDoFrame = this.delayDoFrame;
        blockRecord.currentTime = this.currentTime;
        blockRecord.isSeriousBlock = this.isSeriousBlock;
        blockRecord.isPollOnce = this.isPollOnce;
        blockRecord.traceTime = this.traceTime;
        blockRecord.traceTime2 = this.traceTime2;
        blockRecord.stackTrace = this.stackTrace;
        blockRecord.stackTrace2 = this.stackTrace2;
        blockRecord.trace = this.trace;
        blockRecord.uuid = this.uuid;
        blockRecord.lastScene = this.lastScene;
        blockRecord.looperMessages = this.looperMessages;
        blockRecord.cpuInfo = this.cpuInfo;
        blockRecord.memoryInfo = this.memoryInfo;
        blockRecord.perfInfo = this.perfInfo;
        blockRecord.ignoreStack = this.ignoreStack;
        return blockRecord;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset(long j, String str) {
        this.beginTime = j;
        this.msg = str;
        this.endTime = -1L;
        this.isValid = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        this.isValid = true;
        this.belongDump = false;
        this.belongFrame = false;
        this.delayInputEvent = false;
        this.delayDoFrame = false;
        this.currentTime = 0L;
        this.isSeriousBlock = false;
        this.isErrorStack = false;
        this.isPollOnce = false;
        this.ignoreStack = false;
        this.traceTime = 0L;
        this.traceTime2 = 0L;
        this.stackTrace = null;
        this.stackTrace2 = null;
        this.trace = null;
        this.uuid = null;
        this.lastScene = null;
        this.looperMessages = null;
        this.cpuInfo = null;
        this.memoryInfo = null;
        this.perfInfo = null;
    }
}
