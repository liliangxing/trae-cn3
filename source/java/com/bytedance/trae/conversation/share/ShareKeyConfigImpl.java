package com.bytedance.trae.conversation.share;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.depend.IShareKeyConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ShareKeyConfigImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/IShareKeyConfig;", "weixinKey", "", "<init>", "(Ljava/lang/String;)V", "getKeys", "Lorg/json/JSONObject;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareKeyConfigImpl implements IShareKeyConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean WEIXIN_KEY_AVAILABLE;
    private final String weixinKey;

    /* JADX WARN: Multi-variable type inference failed */
    public ShareKeyConfigImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static final boolean getWEIXIN_KEY_AVAILABLE() {
        return INSTANCE.getWEIXIN_KEY_AVAILABLE();
    }

    public static final void setWEIXIN_KEY_AVAILABLE(boolean z) {
        INSTANCE.setWEIXIN_KEY_AVAILABLE(z);
    }

    public ShareKeyConfigImpl(String weixinKey) {
        Intrinsics.checkNotNullParameter(weixinKey, "weixinKey");
        this.weixinKey = weixinKey;
    }

    public /* synthetic */ ShareKeyConfigImpl(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    /* compiled from: ShareKeyConfigImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;", "", "<init>", "()V", "WEIXIN_KEY_AVAILABLE", "", "getWEIXIN_KEY_AVAILABLE$annotations", "getWEIXIN_KEY_AVAILABLE", "()Z", "setWEIXIN_KEY_AVAILABLE", "(Z)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getWEIXIN_KEY_AVAILABLE$annotations() {
        }

        private Companion() {
        }

        public final boolean getWEIXIN_KEY_AVAILABLE() {
            return ShareKeyConfigImpl.WEIXIN_KEY_AVAILABLE;
        }

        public final void setWEIXIN_KEY_AVAILABLE(boolean z) {
            ShareKeyConfigImpl.WEIXIN_KEY_AVAILABLE = z;
        }
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareKeyConfig
    public JSONObject getKeys() {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.weixinKey)) {
            WEIXIN_KEY_AVAILABLE = true;
        }
        return jSONObject;
    }
}
