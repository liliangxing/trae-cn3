package com.bytedance.trae.conversation.chat.block.renderer.ref;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeRefClickableSpan.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;", "Landroid/text/style/ClickableSpan;", "group", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TraeRefClickableSpan extends ClickableSpan {
    private final TraeRefGroup group;
    private final TraeRefClickListener listener;

    public TraeRefClickableSpan(TraeRefGroup group, TraeRefClickListener traeRefClickListener) {
        Intrinsics.checkNotNullParameter(group, "group");
        this.group = group;
        this.listener = traeRefClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        TraeRefClickListener traeRefClickListener = this.listener;
        if (traeRefClickListener != null) {
            traeRefClickListener.onRefClick(widget, this.group);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        ds.setUnderlineText(false);
    }
}
