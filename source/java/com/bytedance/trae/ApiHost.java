package com.bytedance.trae;

import com.bytedance.trae.network.AiRegion;
import com.bytedance.trae.network.DomainList;
import com.bytedance.trae.network.FrontierConfig;
import com.bytedance.trae.network.HostEntry;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ApiHost {
    private static final String COMMUNITY_HOST = "forum.trae.cn";
    private static final String DOCS_HOST = "docs.trae.cn";
    private static final String ENTERPRISE_BOE_HOST = "enterprise.mcdemo.show";
    private static final String ENTERPRISE_HOST = "console.enterprise.trae.cn";
    public static final FrontierConfig FRONTIER_CONFIG = new FrontierConfig(1924, BuildConfig.APP_ID, "2eb730eefff567bc66454d914f83b9dc", "wss://frontier.zijieapi.com/ws/v2");
    public static final FrontierConfig FRONTIER_CONFIG_BYTECLOUD = new FrontierConfig(1924, 1016841, "2eb730eefff567bc66454d914f83b9dc", "wss://frontier.zijieapi.com/ws/v2");
    private static final String IMAGEX_HOST = "imagex.bytedanceapi.com";
    private static final String LOGIN_HOST = "api.trae.cn";
    private static final String MARKETPLACE_BYTECLOUD_HOST = "ide.byted.org";
    private static final String MARKETPLACE_HOST = "api.trae.com.cn";
    private static final String MSSDK_PASSPORT_TOKEN_Z = "mssdk.doubao.com";
    private static final String NOTIFICATION_HOST = "api.trae.com.cn";
    private static final String ONLINE_HOST = "www.trae.cn";
    private static final String PRAISE_HOST = "praisewindow.ugsdk.cn";
    private static final String SETTINGS_HOST = "is.snssdk.com";
    private static final String TRAE_MC_HOST = "trae-api-cn.mchost.guru";
    private static final String TRAE_REMOTE = "solo.trae.cn";
    private static final String WEBSITE_BYTECLOUD_HOST = "solo-web.bytedance.net";
    private static final String WEBSITE_HOST = "www.trae.cn";

    public static void initHostResolver() {
        HashMap hashMap = new HashMap();
        hashMap.put(AiRegion.CN, "copilot-cn.bytedance.net");
        hashMap.put(AiRegion.SG, "copilot-sg-og.byteintl.net");
        hashMap.put(AiRegion.US, "copilot-og.byteintl.net");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(HostType.ONLINE, HostEntry.builder().publicUser(new DomainList("www.trae.cn")).bytecloudUser(new DomainList(WEBSITE_BYTECLOUD_HOST)).enterpriseUser(new DomainList(ENTERPRISE_HOST)).enterpriseBoeUser(new DomainList(ENTERPRISE_BOE_HOST)).build());
        hashMap2.put(HostType.LOGIN, HostEntry.builder().publicUser(new DomainList(LOGIN_HOST)).bytecloudUser(new DomainList(WEBSITE_BYTECLOUD_HOST)).enterpriseUser(new DomainList(ENTERPRISE_HOST)).enterpriseBoeUser(new DomainList(ENTERPRISE_BOE_HOST)).build());
        hashMap2.put(HostType.AI, HostEntry.builder().publicUser(new DomainList(TRAE_MC_HOST)).bytecloudUser(new DomainList("copilot-cn.bytedance.net", hashMap)).enterpriseUser(new DomainList(ENTERPRISE_HOST)).enterpriseBoeUser(new DomainList(ENTERPRISE_BOE_HOST)).build());
        hashMap2.put(HostType.REMOTE, HostEntry.builder().publicUser(new DomainList(TRAE_REMOTE)).bytecloudUser(new DomainList("copilot-cn.bytedance.net", hashMap)).enterpriseUser(new DomainList(ENTERPRISE_HOST)).enterpriseBoeUser(new DomainList(ENTERPRISE_BOE_HOST)).build());
        hashMap2.put(HostType.IMAGEX, HostEntry.builder().publicUser(new DomainList(IMAGEX_HOST)).build());
        hashMap2.put(HostType.MSSDK, HostEntry.builder().publicUser(new DomainList(MSSDK_PASSPORT_TOKEN_Z)).build());
        hashMap2.put(HostType.PASSPORT, HostEntry.builder().publicUser(new DomainList("www.trae.cn")).build());
        hashMap2.put(HostType.SETTINGS, HostEntry.builder().publicUser(new DomainList(SETTINGS_HOST)).build());
        hashMap2.put(HostType.PRAISE, HostEntry.builder().publicUser(new DomainList(PRAISE_HOST)).build());
        hashMap2.put(HostType.NOTIFICATION, HostEntry.builder().publicUser(new DomainList("api.trae.com.cn")).build());
        hashMap2.put(HostType.MARKETPLACE, HostEntry.builder().publicUser(new DomainList("api.trae.com.cn")).bytecloudUser(new DomainList(MARKETPLACE_BYTECLOUD_HOST)).build());
        hashMap2.put(HostType.WEBSITE, HostEntry.builder().publicUser(new DomainList("www.trae.cn")).build());
        hashMap2.put(HostType.PLUGIN_WEB, HostEntry.builder().publicUser(new DomainList("www.trae.cn")).bytecloudUser(new DomainList(WEBSITE_BYTECLOUD_HOST)).build());
        hashMap2.put(HostType.DOCS, HostEntry.builder().publicUser(new DomainList(DOCS_HOST)).build());
        hashMap2.put(HostType.COMMUNITY, HostEntry.builder().publicUser(new DomainList(COMMUNITY_HOST)).build());
        HostResolver.INSTANCE.init(hashMap2);
    }
}
