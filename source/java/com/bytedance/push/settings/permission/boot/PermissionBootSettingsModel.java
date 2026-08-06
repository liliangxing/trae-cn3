package com.bytedance.push.settings.permission.boot;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes4.dex */
public class PermissionBootSettingsModel {
    private final long DEFAULT_SCENE_REQUEST_INTERVAL = 60000;
    private final long DEFAULT_APP_REQUEST_INTERVAL = 30000;
    private final long LOOP_DETECT_INTERVAL = 500;
    private final long LOOP_DETECT_TIMEOUT = 2000;
    private final long AUTH_KILL_EVENT_INTERVAL = 3600000;
    private final long SYS_DIALOG_SHOW_TIMEOUT = 3000;

    @SerializedName("scenes_request_interval")
    private long scenesRequestInterval = 60000;

    @SerializedName("app_request_interval")
    private long appRequestInterval = 30000;

    @SerializedName("loop_detect_result_interval")
    private long loopDetectResultInterval = 500;

    @SerializedName("loop_detect_result_timeout")
    private long loopDetectResultTimeout = 2000;

    @SerializedName("auth_kill_event_interval")
    private long authKillEventInterval = 3600000;

    @SerializedName("sys_dialog_show_timeout")
    private long sysDialogShowTimeout = 3000;

    @SerializedName("cancel_dialog_on_touch_out_side")
    private boolean cancelDialogOnTouchOutSide = false;

    @SerializedName("disable_dialog_back_btn")
    private boolean disableDialogBackBtn = true;

    public long getScenesRequestInterval() {
        return this.scenesRequestInterval;
    }

    public PermissionBootSettingsModel setScenesRequestInterval(long j) {
        this.scenesRequestInterval = j;
        return this;
    }

    public long getAppRequestInterval() {
        return this.appRequestInterval;
    }

    public PermissionBootSettingsModel setAppRequestInterval(long j) {
        this.appRequestInterval = j;
        return this;
    }

    public long getLoopDetectResultInterval() {
        return this.loopDetectResultInterval;
    }

    public PermissionBootSettingsModel setLoopDetectResultInterval(long j) {
        this.loopDetectResultInterval = j;
        return this;
    }

    public long getLoopDetectResultTimeout() {
        return this.loopDetectResultTimeout;
    }

    public PermissionBootSettingsModel setLoopDetectResultTimeout(long j) {
        this.loopDetectResultTimeout = j;
        return this;
    }

    public long getAuthKillEventInterval() {
        return this.authKillEventInterval;
    }

    public PermissionBootSettingsModel setAuthKillEventInterval(long j) {
        this.authKillEventInterval = j;
        return this;
    }

    public long getSysDialogShowTimeout() {
        return this.sysDialogShowTimeout;
    }

    public PermissionBootSettingsModel setSysDialogShowTimeout(long j) {
        this.sysDialogShowTimeout = j;
        return this;
    }

    public boolean isCancelDialogOnTouchOutSide() {
        return this.cancelDialogOnTouchOutSide;
    }

    public PermissionBootSettingsModel setCancelDialogOnTouchOutSide(boolean z) {
        this.cancelDialogOnTouchOutSide = z;
        return this;
    }

    public boolean isDisableDialogBackBtn() {
        return this.disableDialogBackBtn;
    }

    public PermissionBootSettingsModel setDisableDialogBackBtn(boolean z) {
        this.disableDialogBackBtn = z;
        return this;
    }
}
