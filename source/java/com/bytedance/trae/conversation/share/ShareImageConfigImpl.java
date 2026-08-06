package com.bytedance.trae.conversation.share;

import android.text.TextUtils;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.depend.IShareImageConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareImageConfigImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareImageConfigImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/IShareImageConfig;", "<init>", "()V", "getImageBitmap", "", "imageUrl", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/ug/sdk/share/api/callback/GetImageCallback;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareImageConfigImpl implements IShareImageConfig {
    @Override // com.bytedance.ug.sdk.share.api.depend.IShareImageConfig
    public void getImageBitmap(String imageUrl, GetImageCallback callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TextUtils.isEmpty(imageUrl);
    }
}
