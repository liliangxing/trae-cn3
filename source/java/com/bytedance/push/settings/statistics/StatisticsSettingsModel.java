package com.bytedance.push.settings.statistics;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class StatisticsSettingsModel {
    public long maxAliveDuration;
    public long smpMaxAliveDuration;
    public boolean isEnableStatistics = false;
    public long fgLoopIntervalInSecond = 300;
    public long bgLoopIntervalInSecond = 5;
    public int networkDetectMode = 0;
    public int smpNetworkDetectMode = 0;
    public int maxSpFileCount = 15;
    public long apiRequestTimeoutInMill = 3000;
    public long loopGapInMill = 5;
    public long minDozeDurationDetectIntervalInMill = -1;
    public long dozeDurationDetectValidity = 604800;
    public long maxUndozeDuration = 5;
    public long smpMinDozeDurationDetectIntervalInMill = -1;
    public long smpDozeDurationDetectValidity = 604800;
    public long smpMaxUndozeDuration = 5;
    public List<String> enableStatisticsProcess = new ArrayList();
}
