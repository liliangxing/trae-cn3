package com.bytedance.trae.push.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.push.PushBody;
import com.bytedance.push.interfaze.IPushMsgShowInterceptor;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.push.api.ActiveConversationTracker;
import com.bytedance.trae.push.api.PushConst;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushMsgShowInterceptor.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/push/impl/PushMsgShowInterceptor;", "Lcom/bytedance/push/interfaze/IPushMsgShowInterceptor;", "<init>", "()V", "onReceivePassThoughMsg", "", "context", "Landroid/content/Context;", "pushType", "", "body", "Lcom/bytedance/push/PushBody;", "onReceiveRevokeMsg", "parsePushConversationId", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushMsgShowInterceptor implements IPushMsgShowInterceptor {
    @Override // com.bytedance.push.interfaze.IPushMsgShowInterceptor
    public boolean onReceiveRevokeMsg(Context context, int pushType, PushBody body) {
        return false;
    }

    @Override // com.bytedance.push.interfaze.IPushMsgShowInterceptor
    public boolean onReceivePassThoughMsg(Context context, int pushType, PushBody body) {
        String parsePushConversationId;
        PushEventManager.INSTANCE.onPushArrive(body);
        String str = body != null ? body.open_url : null;
        boolean z = true;
        if (str == null || str.length() == 0) {
            PushEventManager.INSTANCE.trackPushProcess(PushTrackerType.VALIDATE_FAIL, MapsKt.mapOf(TuplesKt.to("fail_reason", "missing_open_url_in_push_body")));
        }
        if (AppHost.Companion.getActivityStackManager().isAppBackground()) {
            return false;
        }
        String activeConversationId = ActiveConversationTracker.INSTANCE.getActiveConversationId();
        String str2 = activeConversationId;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z || (parsePushConversationId = parsePushConversationId(body)) == null) {
            return false;
        }
        return Intrinsics.areEqual(activeConversationId, parsePushConversationId);
    }

    private final String parsePushConversationId(PushBody body) {
        String str = body != null ? body.open_url : null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        try {
            return Uri.parse(str).getQueryParameter(PushConst.PUSH_KEY_CONVERSATION_ID);
        } catch (Exception unused) {
            return null;
        }
    }
}
