package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBlockRenderer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "T", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)Landroid/view/View;", "update", "", "view", "(Landroid/view/View;Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBlockRenderer<T extends AgentContentBlock> {

    /* compiled from: IBlockRenderer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static <T extends AgentContentBlock> void update(IBlockRenderer<T> iBlockRenderer, View view, T t) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(t, "block");
        }
    }

    View render(Context context, T block);

    void update(View view, T block);
}
