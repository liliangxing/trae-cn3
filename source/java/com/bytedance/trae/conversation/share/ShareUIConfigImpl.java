package com.bytedance.trae.conversation.share;

import android.app.Activity;
import com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.keep.impl.UIConfigImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareUIConfigImpl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareUIConfigImpl;", "Lcom/bytedance/ug/sdk/share/keep/impl/UIConfigImpl;", "<init>", "()V", "getSharePanel", "Lcom/bytedance/ug/sdk/share/impl/ui/panel/ISharePanel;", "activity", "Landroid/app/Activity;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ShareUIConfigImpl extends UIConfigImpl {
    public ISharePanel getSharePanel(Activity activity) {
        ISharePanel sharePanel = super.getSharePanel(activity);
        Intrinsics.checkNotNullExpressionValue(sharePanel, "getSharePanel(...)");
        return sharePanel;
    }
}
