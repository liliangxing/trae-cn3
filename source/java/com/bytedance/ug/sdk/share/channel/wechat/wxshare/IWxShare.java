package com.bytedance.ug.sdk.share.channel.wechat.wxshare;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IWxShare {
    boolean doShare(Context context, IWXAPI iwxapi, ShareContent shareContent, SendMessageToWX.Req req);
}
