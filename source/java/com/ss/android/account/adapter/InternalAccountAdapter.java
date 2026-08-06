package com.ss.android.account.adapter;

import android.content.Context;
import com.bytedance.sdk.account.impl.BDAccountManagerAdapter;
import com.bytedance.sdk.account.platform.BaseAccountAdapter;
import com.bytedance.sdk.account.platform.DouyinPlatformDelegate;
import com.bytedance.sdk.account.platform.HotsoonPlatformDelegate;
import com.bytedance.sdk.account.platform.QQPlatformDelegate;
import com.bytedance.sdk.account.platform.TaptapPlatformDelegate;
import com.bytedance.sdk.account.platform.TouTiaoPlatformDelegate;
import com.bytedance.sdk.account.platform.WeiboPlatformDelegate;
import com.bytedance.sdk.account.platform.WeixinPlatformDelegate;
import com.bytedance.sdk.account.platform.XiguaPlatformDelegate;
import com.ss.android.LogHelper;
import com.ss.android.account.model.internal.BDAccountPlatformEntity;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InternalAccountAdapter {
    public static void init(Context context) {
        BDAccountManagerAdapter.init();
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_WX, new WeixinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_QZONE, new QQPlatformDelegate.QQLoginFactor());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_WEIBO, new WeiboPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_DOUYIN, new DouyinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_TOUTIAO, new TouTiaoPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_DOUYIN_NEW, new DouyinPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_TOUTIAO_NEW, new TouTiaoPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_TAPTAP, new TaptapPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put("live_stream", new HotsoonPlatformDelegate.Factory());
        BaseAccountAdapter.delegateMap.put(BDAccountPlatformEntity.PLAT_NAME_XIGUA, new XiguaPlatformDelegate.Factory());
        LogHelper.m36d("InternalAccountAdapter", "call init");
    }
}
