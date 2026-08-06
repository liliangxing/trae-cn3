package com.bytedance.push.pull;

/* loaded from: classes4.dex */
public enum PullScene {
    SCENE_COLD_LAUNCH("app_launch"),
    SCENE_SWITCH_TO_BACKGROUND("switch_to_background"),
    SCENE_SWITCH_TO_FOREGROUND("switch_to_foreground");

    public String sceneStr;

    PullScene(String str) {
        this.sceneStr = str;
    }
}
