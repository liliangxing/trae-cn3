package com.bytedance.sdk.xbridge.cn.service;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IContainerInstance.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/service/IContainerInstance;", "", "bid", "", "context", "Landroid/content/Context;", "sendEvent", "", SchemaConstants.INNER_PARAM_EVENT_NAME, "params", "sessionId", "uri", "Landroid/net/Uri;", "view", "Landroid/view/View;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IContainerInstance {

    /* compiled from: IContainerInstance.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static void sendEvent(IContainerInstance iContainerInstance, String eventName, Object obj) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
        }

        public static String sessionId(IContainerInstance iContainerInstance) {
            return "";
        }
    }

    String bid();

    Context context();

    void sendEvent(String eventName, Object params);

    String sessionId();

    Uri uri();

    View view();
}
