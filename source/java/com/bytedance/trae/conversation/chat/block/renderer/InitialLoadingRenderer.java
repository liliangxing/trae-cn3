package com.bytedance.trae.conversation.chat.block.renderer;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.Property;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitialLoadingRenderer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$InitialLoading;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitialLoadingRenderer implements IBlockRenderer<AgentContentBlock.InitialLoading> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.InitialLoading initialLoading) {
        IBlockRenderer.DefaultImpls.update(this, view, initialLoading);
    }

    /* compiled from: InitialLoadingRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/InitialLoadingRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.InitialLoading block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[InitialLoadingRenderer] render");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(8388627);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (20 * f)));
        int i = (int) (8 * f);
        int i2 = (int) (6 * f);
        int color = ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary);
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(color);
            View view = new View(context);
            view.setBackground(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            if (i3 > 0) {
                layoutParams.setMarginStart(i2);
            } else if (i3 == 0) {
                layoutParams.setMarginStart((int) (2 * f));
            }
            linearLayout.addView(view, layoutParams);
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 1.0f, 0.3f));
            ofPropertyValuesHolder.setDuration(400L);
            ofPropertyValuesHolder.setRepeatMode(2);
            ofPropertyValuesHolder.setRepeatCount(-1);
            ofPropertyValuesHolder.setStartDelay(i3 * 150);
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "apply(...)");
            arrayList.add(ofPropertyValuesHolder);
            ofPropertyValuesHolder.start();
        }
        linearLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.InitialLoadingRenderer$render$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ObjectAnimator) it.next()).cancel();
                }
                arrayList.clear();
            }
        });
        return linearLayout;
    }
}
