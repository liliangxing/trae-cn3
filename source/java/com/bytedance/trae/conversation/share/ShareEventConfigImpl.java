package com.bytedance.trae.conversation.share;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.depend.IShareEventConfig;
import com.bytedance.ug.sdk.share.api.entity.ShareMonitorEvent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ShareEventConfigImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J<\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareEventConfigImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/IShareEventConfig;", "<init>", "()V", "onAppLogEvent", "", "event", "", RemoteMessageConst.MessageBody.PARAM, "Lorg/json/JSONObject;", "onSDKMonitorInit", "context", "Landroid/content/Context;", "aid", "headerInfo", "configUrls", "", "reportUrls", "onSDKMonitorEvent", "Lcom/bytedance/ug/sdk/share/api/entity/ShareMonitorEvent;", "onALogEvent", "level", "", "tag", "msg", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareEventConfigImpl implements IShareEventConfig {
    @Override // com.bytedance.ug.sdk.share.api.depend.IShareEventConfig
    public void onALogEvent(int level, String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareEventConfig
    public void onAppLogEvent(String event, JSONObject param) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(param, "param");
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareEventConfig
    public void onSDKMonitorEvent(String aid, ShareMonitorEvent event) {
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareEventConfig
    public void onSDKMonitorInit(Context context, String aid, JSONObject headerInfo, List<String> configUrls, List<String> reportUrls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aid, "aid");
        Intrinsics.checkNotNullParameter(headerInfo, "headerInfo");
        Intrinsics.checkNotNullParameter(configUrls, "configUrls");
        Intrinsics.checkNotNullParameter(reportUrls, "reportUrls");
    }
}
