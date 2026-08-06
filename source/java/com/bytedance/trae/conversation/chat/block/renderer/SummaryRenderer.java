package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.menu.AgentMessageMenu;
import com.bytedance.trae.conversation.chat.textselector.TextSelectionHelper;
import com.bytedance.trae.conversation.perf.VoiceSummaryRenderTracker;
import com.bytedance.trae.multilanguage.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* compiled from: SummaryRenderer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0014H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Summary;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "createTypewriter", "Lcom/bytedance/trae/conversation/chat/block/renderer/Typewriter;", "container", "Landroid/widget/LinearLayout;", "contentView", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "trackingId", "", "setupLongPressMenu", "summaryContent", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SummaryRenderer implements IBlockRenderer<AgentContentBlock.Summary> {
    private static final String BLOCK_TAG = "AgentBlock";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Summary block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (8 * f);
        layoutParams.bottomMargin = (int) (6 * f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setTag(C0637R.id.tag_summary_tracking_id, block.getTrackingId());
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_summary_title));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 22.0f);
        textView.setTypeface(Typeface.create("sans-serif", 1));
        textView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.bottomMargin = (int) (12 * f);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams2);
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
        simpleMarkdownTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        simpleMarkdownTextView.setTextSize(2, 17.0f);
        simpleMarkdownTextView.setLineSpacing(0.0f, 1.0f);
        linearLayout.addView((View) simpleMarkdownTextView);
        if (block.getFinished()) {
            simpleMarkdownTextView.setWebReferenceDescription(block.getWebReferences());
            MarkdownHelper.setMarkdownContentWithRef$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, block.getContent(), true, null, 8, null);
            if (block.getContent().length() > 0) {
                VoiceSummaryRenderTracker.INSTANCE.markFirstChar(block.getTrackingId());
                VoiceSummaryRenderTracker.INSTANCE.markLastChar(block.getTrackingId());
            }
            setupLongPressMenu(simpleMarkdownTextView, block.getContent());
        } else {
            simpleMarkdownTextView.setLongClickable(false);
            simpleMarkdownTextView.setWebReferenceDescription(block.getWebReferences());
            Typewriter createTypewriter = createTypewriter(linearLayout, simpleMarkdownTextView, block.getTrackingId());
            linearLayout.setTag(C0637R.id.tag_typewriter, createTypewriter);
            createTypewriter.feed(block.getContent());
        }
        return linearLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(View view, AgentContentBlock.Summary block) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            return;
        }
        Object childAt = linearLayout.getChildAt(1);
        SimpleMarkdownTextView simpleMarkdownTextView = childAt instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) childAt : null;
        if (simpleMarkdownTextView == null) {
            return;
        }
        String trackingId = block.getTrackingId();
        if (trackingId == null) {
            Object tag = linearLayout.getTag(C0637R.id.tag_summary_tracking_id);
            if (!(tag instanceof String)) {
                str = null;
                if (!block.getFinished()) {
                    INSTANCE.cancelTypewriter(linearLayout);
                    simpleMarkdownTextView.setWebReferenceDescription(block.getWebReferences());
                    MarkdownHelper.setMarkdownContentWithRef$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, block.getContent(), true, null, 8, null);
                    if (block.getContent().length() > 0) {
                        VoiceSummaryRenderTracker.INSTANCE.markFirstChar(str);
                        VoiceSummaryRenderTracker.INSTANCE.markLastChar(str);
                    }
                    setupLongPressMenu(simpleMarkdownTextView, block.getContent());
                    return;
                }
                Object tag2 = linearLayout.getTag(C0637R.id.tag_typewriter);
                Typewriter typewriter = tag2 instanceof Typewriter ? (Typewriter) tag2 : null;
                if (typewriter == null) {
                    typewriter = createTypewriter(linearLayout, simpleMarkdownTextView, str);
                    linearLayout.setTag(C0637R.id.tag_typewriter, typewriter);
                }
                simpleMarkdownTextView.setLongClickable(false);
                simpleMarkdownTextView.setOnLongClickListener(null);
                simpleMarkdownTextView.setWebReferenceDescription(block.getWebReferences());
                typewriter.feed(block.getContent());
                return;
            }
            trackingId = (String) tag;
        }
        str = trackingId;
        if (!block.getFinished()) {
        }
    }

    private final Typewriter createTypewriter(final LinearLayout container, final SimpleMarkdownTextView contentView, final String trackingId) {
        return new Typewriter(new Function2() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit createTypewriter$lambda$5;
                createTypewriter$lambda$5 = SummaryRenderer.createTypewriter$lambda$5(SimpleMarkdownTextView.this, trackingId, (String) obj, ((Boolean) obj2).booleanValue());
                return createTypewriter$lambda$5;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit createTypewriter$lambda$6;
                createTypewriter$lambda$6 = SummaryRenderer.createTypewriter$lambda$6(container);
                return createTypewriter$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTypewriter$lambda$5(SimpleMarkdownTextView simpleMarkdownTextView, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str2, "displayText");
        MarkdownHelper.setMarkdownContentWithRef$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, str2, z, null, 8, null);
        if (str2.length() > 0) {
            VoiceSummaryRenderTracker.INSTANCE.markFirstChar(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createTypewriter$lambda$6(LinearLayout linearLayout) {
        Object tag = linearLayout.getTag(C0637R.id.tag_on_content_changed);
        Function0 function0 = TypeIntrinsics.isFunctionOfArity(tag, 0) ? (Function0) tag : null;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final void setupLongPressMenu(final SimpleMarkdownTextView contentView, final String summaryContent) {
        if (TextSelectionHelper.INSTANCE.isSelectionActionModeAvailable()) {
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            final Ref.FloatRef floatRef4 = new Ref.FloatRef();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            contentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean z;
                    z = SummaryRenderer.setupLongPressMenu$lambda$7(floatRef, floatRef2, floatRef3, floatRef4, view, motionEvent);
                    return z;
                }
            });
            contentView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean z;
                    z = SummaryRenderer.setupLongPressMenu$lambda$8(SimpleMarkdownTextView.this, objectRef, floatRef, floatRef2, summaryContent, floatRef3, floatRef4, view);
                    return z;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupLongPressMenu$lambda$7(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Ref.FloatRef floatRef4, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        floatRef.element = motionEvent.getRawX();
        floatRef2.element = motionEvent.getRawY();
        floatRef3.element = motionEvent.getX();
        floatRef4.element = motionEvent.getY();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean setupLongPressMenu$lambda$8(final SimpleMarkdownTextView simpleMarkdownTextView, Ref.ObjectRef objectRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, final String str, final Ref.FloatRef floatRef3, final Ref.FloatRef floatRef4, View view) {
        if (TextSelectionHelper.INSTANCE.isEnteringSelection()) {
            return true;
        }
        simpleMarkdownTextView.performHapticFeedback(0);
        AgentMessageMenu agentMessageMenu = (AgentMessageMenu) objectRef.element;
        if (agentMessageMenu != null) {
            agentMessageMenu.dismiss();
        }
        Context context = simpleMarkdownTextView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        objectRef.element = new AgentMessageMenu(context, new AgentMessageMenu.OnMenuClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SummaryRenderer$setupLongPressMenu$2$1
            @Override // com.bytedance.trae.conversation.chat.menu.AgentMessageMenu.OnMenuClickListener
            public void onCopyClick() {
                Context context2 = SimpleMarkdownTextView.this.getContext();
                if (StringsKt.isBlank(str)) {
                    CustomToast.showLong(context2, R.string.trae_conversation_no_copyable_content);
                    return;
                }
                Object systemService = context2.getSystemService("clipboard");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("summary", str));
                CustomToast.showLong(context2, R.string.trae_conversation_copied);
            }

            @Override // com.bytedance.trae.conversation.chat.menu.AgentMessageMenu.OnMenuClickListener
            public void onSelectTextClick() {
                TextSelectionHelper.INSTANCE.enterSelectionMode((TextView) SimpleMarkdownTextView.this, floatRef3.element, floatRef4.element);
            }
        });
        AgentMessageMenu agentMessageMenu2 = (AgentMessageMenu) objectRef.element;
        if (agentMessageMenu2 != null) {
            agentMessageMenu2.showNear((View) simpleMarkdownTextView, floatRef.element, floatRef2.element);
        }
        return true;
    }

    /* compiled from: SummaryRenderer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SummaryRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "cancelTypewriter", "", "view", "Landroid/view/View;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void cancelTypewriter(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag(C0637R.id.tag_typewriter);
            Typewriter typewriter = tag instanceof Typewriter ? (Typewriter) tag : null;
            if (typewriter != null) {
                typewriter.cancel();
            }
            view.setTag(C0637R.id.tag_typewriter, null);
        }
    }
}
