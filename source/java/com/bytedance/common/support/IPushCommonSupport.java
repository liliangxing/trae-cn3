package com.bytedance.common.support;

import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.service.IPushCommonParamService;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.support.service.ISecurityService;
import com.bytedance.push.monitor.ICommonPushSdkMonitorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IPushCommonSupport {
    ICommonPushSdkMonitorService getICommonPushSdkMonitorService();

    IPushCommonConfiguration getIPushCommonConfiguration();

    IPushCommonParamService getPushCommonParamService();

    IPushConfigurationService getPushConfigurationService();

    ISecurityService getSecurityService();
}
