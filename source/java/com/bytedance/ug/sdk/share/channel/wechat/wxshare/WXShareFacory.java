package com.bytedance.ug.sdk.share.channel.wechat.wxshare;

import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WXShareFacory {
    public static IWxShare getWXShareImpl(ShareStrategy shareStrategy) {
        if (shareStrategy == null) {
            shareStrategy = ShareStrategy.NORMAL;
        }
        int i = C10311.$SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[shareStrategy.ordinal()];
        if (i == 1 || i == 2) {
            return new ComponentNameShareImpl();
        }
        return new DefaultShareImpl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ug.sdk.share.channel.wechat.wxshare.WXShareFacory$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C10311 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy;

        static {
            int[] iArr = new int[ShareStrategy.values().length];
            $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy = iArr;
            try {
                iArr[ShareStrategy.SHARE_WITH_COMPONENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareStrategy[ShareStrategy.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }
}
