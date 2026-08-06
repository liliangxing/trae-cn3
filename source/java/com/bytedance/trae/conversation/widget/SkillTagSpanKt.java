package com.bytedance.trae.conversation.widget;

import android.content.Context;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkillTagSpan.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {CustomImageSizeResolverDef.UNIT_DP, "", "context", "Landroid/content/Context;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SkillTagSpanKt {
    public static final float dp(float f, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return f * context.getResources().getDisplayMetrics().density;
    }
}
