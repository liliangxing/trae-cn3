package com.bytedance.sdk.account.impl;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountManagerAdapter {
    public static void init() {
        ArrayList arrayList = new ArrayList(Arrays.asList(BDAccountManager.ALL));
        arrayList.add(new BDAccountPlatformEntity("weixin"));
        arrayList.add(new BDAccountPlatformEntity("huawei"));
        arrayList.add(new BDAccountPlatformEntity("xiaomi"));
        arrayList.add(new BDAccountPlatformEntity("flyme"));
        arrayList.add(new BDAccountPlatformEntity("qq_weibo"));
        arrayList.add(new BDAccountPlatformEntity("sina_weibo"));
        arrayList.add(new BDAccountPlatformEntity("qzone_sns"));
        arrayList.add(new BDAccountPlatformEntity("toutiao"));
        arrayList.add(new BDAccountPlatformEntity("toutiao_v2"));
        arrayList.add(new BDAccountPlatformEntity("aweme"));
        arrayList.add(new BDAccountPlatformEntity("aweme_v2"));
        arrayList.add(new BDAccountPlatformEntity("live_stream"));
        arrayList.add(new BDAccountPlatformEntity(OnekeyLoginConstants.TELECOM));
        arrayList.add(new BDAccountPlatformEntity("renren_sns"));
        arrayList.add(new BDAccountPlatformEntity("kaixin_sns"));
        arrayList.add(new BDAccountPlatformEntity("flipchat"));
        arrayList.add(new BDAccountPlatformEntity("gogokid"));
        BDAccountManager.ALL = (BDAccountPlatformEntity[]) arrayList.toArray(new BDAccountPlatformEntity[0]);
    }
}
