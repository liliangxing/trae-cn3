package com.bytedance.push.settings.pull;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class PullSettingsModel {
    public static final String SCENE_COLD_LAUNCH = "app_launch";
    public static final String SCENE_DEPTHS = "depths";
    public static final String SCENE_HOST = "host_invoke";
    public static final String SCENE_LOOP = "loop";
    public static final String SCENE_SWITCH_TO_BACKGROUND = "switch_to_background";
    public static final String SCENE_SWITCH_TO_FOREGROUND = "switch_to_foreground";

    @SerializedName("background_min_interval_in_mill")
    public long backgroundMinIntervalInMill = 5000;

    @SerializedName("foreground_min_interval_in_mill")
    public long foregroundMinIntervalInMill = 5000;

    @SerializedName("allow_scene_list")
    public List<String> allowScene = new ArrayList();

    @SerializedName("allow_branch_scene_list")
    public List<String> allowBranchScene = new ArrayList();

    @SerializedName("allow_loop_scene_list")
    public List<String> allowLoopScene = new ArrayList();

    @SerializedName("allow_loop_branch_scene_list")
    public List<String> allowLoopBranchScene = new ArrayList();
}
