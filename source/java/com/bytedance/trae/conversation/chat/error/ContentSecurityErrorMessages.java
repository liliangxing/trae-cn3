package com.bytedance.trae.conversation.chat.error;

import android.content.res.Resources;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ContentSecurityErrorMessages.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/chat/error/ContentSecurityErrorMessages;", "", "<init>", "()V", "blockedMessage", "", "resources", "Landroid/content/res/Resources;", "ruleName", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ContentSecurityErrorMessages {
    public static final ContentSecurityErrorMessages INSTANCE = new ContentSecurityErrorMessages();

    private ContentSecurityErrorMessages() {
    }

    public final String blockedMessage(Resources resources, String ruleName) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        String obj = ruleName != null ? StringsKt.trim(ruleName).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (obj.length() > 0) {
            return I18nTextProvider.INSTANCE.getStringWithNamedArgs(resources, R.string.imkit_error_enterprise_content_security_blocked_with_rule_name, MapsKt.mapOf(TuplesKt.to("rule_name", obj)));
        }
        return I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_enterprise_content_security_blocked, new Object[0]);
    }
}
