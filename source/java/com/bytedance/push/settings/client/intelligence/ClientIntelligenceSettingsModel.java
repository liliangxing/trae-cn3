package com.bytedance.push.settings.client.intelligence;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class ClientIntelligenceSettingsModel {
    public static final int CLIENT_INTELLIGENCE_MODE_MODEL = 2;
    public static final int CLIENT_INTELLIGENCE_MODE_NOT_ENABLE = 0;
    public static final int CLIENT_INTELLIGENCE_MODE_PERSONAL = 1;
    public static final int CLIENT_INTELLIGENCE_SUB_MODE_DEFAULT = 0;
    public static final int CLIENT_INTELLIGENCE_SUB_MODE_NOTIFICATION_BAR = 1;
    public static final int CLIENT_INTELLIGENCE_SUB_MODE_SCREEN_ON = 2;
    public long maxShowDelayTimeInMill;
    public long minMessageShowIntervalInMill;
    public boolean enableClientFeatureReport = false;
    public boolean allowCollectClientFeature = false;
    public boolean enableClientIntelligencePushShow = false;
    public long featureCollectTimeOutInMill = 2000;
    public long checkClientFeatureIntervalInMill = 5000;
    public int maxNumberOfMessageShowAtTheSameTime = 3;
    public int clientIntelligencePushShowMode = 0;
    public int clientIntelligencePushShowSubMode = 0;
    public int maxNumberOfAllowCache = 5;
    public long minIntervalFromLaunchInMill = 0;
    public boolean improvePushArrivalRate = false;
    public List<String> allowFeatureCollectScene = new ArrayList();
    public LocalPushClientIntelligenceSettingsModel localPushClientIntelligenceSettingsModel = new LocalPushClientIntelligenceSettingsModel();

    public boolean needShowAfterNotificationBarPull(int i) {
        return (i & 1) == 1;
    }

    public boolean needShowAfterScreenOn(int i) {
        return (i & 2) == 2;
    }

    public boolean needShowAfterNotificationBarPull() {
        return needShowAfterNotificationBarPull(this.clientIntelligencePushShowSubMode);
    }

    public boolean needShowAfterScreenOn() {
        return needShowAfterScreenOn(this.clientIntelligencePushShowSubMode);
    }
}
