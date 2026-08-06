package com.bytedance.trae.conversation.brainstorm.adapter;

import com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HistorySubtitleAdapter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"isImageAttachment", "", "Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class HistorySubtitleAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isImageAttachment(BrainstormAttachment brainstormAttachment) {
        if (!brainstormAttachment.isImage()) {
            String lowerCase = brainstormAttachment.getMimeType().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!StringsKt.startsWith$default(lowerCase, "image/", false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
