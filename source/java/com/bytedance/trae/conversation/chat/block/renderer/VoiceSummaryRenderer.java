package com.bytedance.trae.conversation.chat.block.renderer;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper;
import com.bytedance.trae.conversation.perf.VoiceSummaryRenderTracker;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: VoiceSummaryRenderer.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u0002H\u0002J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020%H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010)\u001a\u00020%H\u0002J&\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u001c2\b\b\u0002\u0010-\u001a\u00020\u001c2\b\b\u0002\u0010.\u001a\u00020\u001cH\u0002J\u0018\u0010/\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001cH\u0002J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u0016022\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¨\u00064"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummary;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "bind", "container", "Landroid/widget/LinearLayout;", "headerView", "Landroid/widget/TextView;", "markdownContainer", "bottomView", "renderMarkdownSections", "markdown", "", "finished", "", "renderFooter", "createBodyText", "fontSizeSp", "", "lineHeightSp", "createSummaryCard", "createCardHeader", "radius", "createMarkdownView", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "createDivider", "color", "", "createHistoryButton", "createCardBackground", "Landroid/graphics/drawable/GradientDrawable;", "strokeWidth", "matchWrapLp", "Landroid/widget/LinearLayout$LayoutParams;", "topMarginDp", "bottomMarginDp", "density", "spToPx", "sp", "splitMarkdownSections", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSummaryRenderer implements IBlockRenderer<AgentContentBlock.VoiceSummary> {
    private static final int COLOR_CARD_BG;
    private static final int COLOR_CARD_DIVIDER;
    private static final int COLOR_CARD_HEADER_BG;
    private static final int COLOR_CARD_STROKE;
    private static final int COLOR_DIVIDER;
    private static final int COLOR_HEADING;
    private static final HeaderStyleConfig HEADING_STYLE_CONFIG;
    private static final String TAG_BOTTOM = "voice_summary_bottom";
    private static final String TAG_FOOTER_CONTAINER = "voice_summary_footer_container";
    private static final String TAG_HEADER = "voice_summary_header";
    private static final String TAG_MARKDOWN_CONTAINER = "voice_summary_markdown_container";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex SECTION_HEADING_REGEX = new Regex("^#{1,2}\\s+.+");
    private static final int COLOR_TEXT_PRIMARY = Color.parseColor("#171717");
    private static final int COLOR_TEXT_SECONDARY = Color.parseColor("#737373");

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.VoiceSummary block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = MathKt.roundToInt(8 * f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setTag(C0637R.id.tag_summary_tracking_id, block.getTrackingId());
        TextView createBodyText = createBodyText(context, 17.0f, 24.0f);
        createBodyText.setTag(TAG_HEADER);
        linearLayout.addView(createBodyText, matchWrapLp$default(this, 0.0f, 0.0f, 0.0f, 7, null));
        LinearLayout createSummaryCard = createSummaryCard(context);
        LinearLayout linearLayout2 = (LinearLayout) createSummaryCard.findViewWithTag(TAG_MARKDOWN_CONTAINER);
        if (linearLayout2 == null) {
            linearLayout2 = new LinearLayout(context);
        }
        linearLayout.addView(createSummaryCard, matchWrapLp$default(this, 16.0f, 0.0f, f, 2, null));
        TextView createBodyText2 = createBodyText(context, 17.0f, 24.0f);
        createBodyText2.setTag(TAG_BOTTOM);
        linearLayout.addView(createBodyText2, matchWrapLp$default(this, 16.0f, 0.0f, f, 2, null));
        bind(linearLayout, block, createBodyText, linearLayout2, createBodyText2);
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.VoiceSummary block) {
        TextView textView;
        LinearLayout linearLayout;
        TextView textView2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        LinearLayout linearLayout2 = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout2 == null || (textView = (TextView) linearLayout2.findViewWithTag(TAG_HEADER)) == null || (linearLayout = (LinearLayout) linearLayout2.findViewWithTag(TAG_MARKDOWN_CONTAINER)) == null || (textView2 = (TextView) linearLayout2.findViewWithTag(TAG_BOTTOM)) == null) {
            return;
        }
        bind(linearLayout2, block, textView, linearLayout, textView2);
    }

    private final void bind(LinearLayout container, AgentContentBlock.VoiceSummary block, TextView headerView, LinearLayout markdownContainer, TextView bottomView) {
        headerView.setText(block.getHeader());
        headerView.setVisibility(StringsKt.isBlank(block.getHeader()) ? 8 : 0);
        bottomView.setText(block.getBottom());
        bottomView.setVisibility(StringsKt.isBlank(block.getBottom()) ? 8 : 0);
        String trackingId = block.getTrackingId();
        if (trackingId == null) {
            Object tag = container.getTag(C0637R.id.tag_summary_tracking_id);
            trackingId = tag instanceof String ? (String) tag : null;
        }
        INSTANCE.cancelTypewriter(container);
        renderMarkdownSections(markdownContainer, block.getMarkdown(), block.getFinished());
        renderFooter(container, block);
        Object tag2 = container.getTag(C0637R.id.tag_on_content_changed);
        Function0 function0 = TypeIntrinsics.isFunctionOfArity(tag2, 0) ? (Function0) tag2 : null;
        if (function0 != null) {
            function0.invoke();
        }
        if (block.getMarkdown().length() > 0) {
            VoiceSummaryRenderTracker.INSTANCE.markFirstChar(trackingId);
            if (block.getFinished()) {
                VoiceSummaryRenderTracker.INSTANCE.markLastChar(trackingId);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void renderMarkdownSections(LinearLayout markdownContainer, String markdown, boolean finished) {
        Context context = markdownContainer.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        markdownContainer.removeAllViews();
        int i = 0;
        for (Object obj : splitMarkdownSections(markdown)) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i > 0) {
                Intrinsics.checkNotNull(context);
                View createDivider = createDivider(context, COLOR_CARD_DIVIDER);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Math.max(1, MathKt.roundToInt(0.5f * f)));
                float f2 = 12 * f;
                layoutParams.topMargin = MathKt.roundToInt(f2);
                layoutParams.bottomMargin = MathKt.roundToInt(f2);
                Unit unit = Unit.INSTANCE;
                markdownContainer.addView(createDivider, layoutParams);
            }
            Intrinsics.checkNotNull(context);
            SimpleMarkdownTextView createMarkdownView = createMarkdownView(context);
            markdownContainer.addView((View) createMarkdownView, matchWrapLp$default(this, 0.0f, 0.0f, 0.0f, 7, null));
            MarkdownHelper.INSTANCE.setMarkdownContent(createMarkdownView, VoiceSummaryMarkdownNormalizer.INSTANCE.taskListAsBulletList(str), finished, MarkdownHelper.ListBulletStyle.TEXT_COLOR_DISC);
            i = i2;
        }
    }

    private final void renderFooter(LinearLayout container, AgentContentBlock.VoiceSummary block) {
        LinearLayout linearLayout = (LinearLayout) container.findViewWithTag(TAG_FOOTER_CONTAINER);
        if (linearLayout == null) {
            return;
        }
        Context context = linearLayout.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        linearLayout.removeAllViews();
        Intrinsics.checkNotNull(context);
        TextView createHistoryButton = createHistoryButton(context, block);
        if (createHistoryButton == null) {
            return;
        }
        View createDivider = createDivider(context, COLOR_CARD_DIVIDER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Math.max(1, MathKt.roundToInt(0.5f * f)));
        float f2 = 16 * f;
        layoutParams.topMargin = MathKt.roundToInt(f2);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(createDivider, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = createHistoryButton.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
        layoutParams3.topMargin = MathKt.roundToInt(f2);
        linearLayout.addView(createHistoryButton, layoutParams3);
    }

    private final TextView createBodyText(Context context, float fontSizeSp, float lineHeightSp) {
        TextView textView = new TextView(context);
        textView.setTextColor(COLOR_TEXT_PRIMARY);
        textView.setTextSize(2, fontSizeSp);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(textView, spToPx(context, lineHeightSp));
        return textView;
    }

    private final LinearLayout createSummaryCard(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = 16.0f * f;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(createCardBackground(f2, MathKt.roundToInt(1 * f)));
        linearLayout.setClipToOutline(true);
        linearLayout.addView(createCardHeader(context, f2), new LinearLayout.LayoutParams(-1, MathKt.roundToInt(40 * f)));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        float f3 = 12 * f;
        linearLayout2.setPadding(MathKt.roundToInt(f3), MathKt.roundToInt(f3), MathKt.roundToInt(f3), MathKt.roundToInt(f3));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setTag(TAG_MARKDOWN_CONTAINER);
        linearLayout3.setOrientation(1);
        linearLayout2.addView(linearLayout3, matchWrapLp$default(this, 0.0f, 0.0f, 0.0f, 7, null));
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setTag(TAG_FOOTER_CONTAINER);
        linearLayout4.setOrientation(1);
        linearLayout2.addView(linearLayout4, matchWrapLp$default(this, 0.0f, 0.0f, 0.0f, 7, null));
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    private final LinearLayout createCardHeader(Context context, float radius) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        float f2 = 12 * f;
        linearLayout.setPadding(MathKt.roundToInt(f2), 0, MathKt.roundToInt(f2), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(COLOR_CARD_HEADER_BG);
        gradientDrawable.setCornerRadii(new float[]{radius, radius, radius, radius, 0.0f, 0.0f, 0.0f, 0.0f});
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setText(C0637R.string.trae_brainstorm_discussion_results);
        textView.setTextColor(COLOR_TEXT_SECONDARY);
        textView.setTextSize(2, 15.0f);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight(textView, spToPx(context, 20.0f));
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final SimpleMarkdownTextView createMarkdownView(Context context) {
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
        simpleMarkdownTextView.setTextColor(COLOR_TEXT_PRIMARY);
        simpleMarkdownTextView.setTextSize(2, 16.0f);
        simpleMarkdownTextView.setLineSpacing(0.0f, 1.0f);
        TextViewCompat.setLineHeight((TextView) simpleMarkdownTextView, spToPx(context, 22.0f));
        simpleMarkdownTextView.setHeadingStyle(HEADING_STYLE_CONFIG);
        return simpleMarkdownTextView;
    }

    static /* synthetic */ View createDivider$default(VoiceSummaryRenderer voiceSummaryRenderer, Context context, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = COLOR_DIVIDER;
        }
        return voiceSummaryRenderer.createDivider(context, i);
    }

    private final View createDivider(Context context, int color) {
        View view = new View(context);
        view.setBackgroundColor(color);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        return view;
    }

    private final TextView createHistoryButton(final Context context, AgentContentBlock.VoiceSummary block) {
        final String historySessionId;
        final String conversationId;
        if (block.getFinished() && (historySessionId = block.getHistorySessionId()) != null) {
            if (!(!StringsKt.isBlank(historySessionId))) {
                historySessionId = null;
            }
            if (historySessionId != null && (conversationId = block.getConversationId()) != null) {
                if (!(!StringsKt.isBlank(conversationId))) {
                    conversationId = null;
                }
                if (conversationId != null) {
                    float f = context.getResources().getDisplayMetrics().density;
                    TextView textView = new TextView(context);
                    textView.setText(C0637R.string.trae_brainstorm_view_voice_history);
                    textView.setGravity(17);
                    textView.setTextColor(COLOR_TEXT_PRIMARY);
                    textView.setTextSize(2, 17.0f);
                    textView.setTypeface(Typeface.create("sans-serif-medium", 0));
                    textView.setIncludeFontPadding(false);
                    TextViewCompat.setLineHeight(textView, spToPx(context, 24.0f));
                    textView.setBackgroundResource(C0637R.drawable.trae_bg_view_voice_history_btn);
                    TypedValue typedValue = new TypedValue();
                    context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
                    textView.setForeground(context.getDrawable(typedValue.resourceId));
                    textView.setClickable(true);
                    textView.setFocusable(true);
                    textView.setLayoutParams(new LinearLayout.LayoutParams(-1, MathKt.roundToInt(36 * f)));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryRenderer$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            VoiceSummaryRenderer.createHistoryButton$lambda$20$lambda$19(context, historySessionId, conversationId, view);
                        }
                    });
                    return textView;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createHistoryButton$lambda$20$lambda$19(Context context, String str, String str2, View view) {
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            return;
        }
        BrainstormVoiceHistorySheet.Companion companion = BrainstormVoiceHistorySheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        companion.show(supportFragmentManager, str, str2);
    }

    private final GradientDrawable createCardBackground(float radius, int strokeWidth) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(radius);
        gradientDrawable.setColor(COLOR_CARD_BG);
        gradientDrawable.setStroke(strokeWidth, COLOR_CARD_STROKE);
        return gradientDrawable;
    }

    static /* synthetic */ LinearLayout.LayoutParams matchWrapLp$default(VoiceSummaryRenderer voiceSummaryRenderer, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 1.0f;
        }
        return voiceSummaryRenderer.matchWrapLp(f, f2, f3);
    }

    private final LinearLayout.LayoutParams matchWrapLp(float topMarginDp, float bottomMarginDp, float density) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = MathKt.roundToInt(topMarginDp * density);
        layoutParams.bottomMargin = MathKt.roundToInt(bottomMarginDp * density);
        return layoutParams;
    }

    private final int spToPx(Context context, float sp) {
        return MathKt.roundToInt(TypedValue.applyDimension(2, sp, context.getResources().getDisplayMetrics()));
    }

    private final List<String> splitMarkdownSections(String markdown) {
        boolean z;
        String str = markdown;
        if (StringsKt.isBlank(str)) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = StringsKt.lines(str).iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            if (SECTION_HEADING_REGEX.matches(StringsKt.trim(str2).toString())) {
                ArrayList arrayList3 = arrayList2;
                if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                    Iterator it2 = arrayList3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (!StringsKt.isBlank((String) it2.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    arrayList.add(arrayList2);
                    arrayList2 = new ArrayList();
                }
            }
            arrayList2.add(str2);
        }
        ArrayList arrayList4 = arrayList2;
        if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
            Iterator it3 = arrayList4.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (!StringsKt.isBlank((String) it3.next())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            arrayList.add(arrayList2);
        }
        ArrayList arrayList5 = arrayList;
        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
        Iterator it4 = arrayList5.iterator();
        while (it4.hasNext()) {
            arrayList6.add(StringsKt.trim(CollectionsKt.joinToString$default((List) it4.next(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).toString());
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object obj : arrayList6) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList7.add(obj);
            }
        }
        return arrayList7;
    }

    /* compiled from: VoiceSummaryRenderer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$Companion;", "", "<init>", "()V", "TAG_HEADER", "", "TAG_MARKDOWN_CONTAINER", "TAG_FOOTER_CONTAINER", "TAG_BOTTOM", "SECTION_HEADING_REGEX", "Lkotlin/text/Regex;", "COLOR_TEXT_PRIMARY", "", "COLOR_TEXT_SECONDARY", "COLOR_HEADING", "HEADING_STYLE_CONFIG", "Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "COLOR_DIVIDER", "getCOLOR_DIVIDER", "()I", "COLOR_CARD_BG", "COLOR_CARD_HEADER_BG", "COLOR_CARD_STROKE", "COLOR_CARD_DIVIDER", "cancelTypewriter", "", "view", "Landroid/view/View;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getCOLOR_DIVIDER() {
            return VoiceSummaryRenderer.COLOR_DIVIDER;
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

    static {
        int parseColor = Color.parseColor("#000000");
        COLOR_HEADING = parseColor;
        Float valueOf = Float.valueOf(18.0f);
        HEADING_STYLE_CONFIG = new HeaderStyleConfig(MapsKt.mapOf(new Pair[]{TuplesKt.to(1, valueOf), TuplesKt.to(2, valueOf), TuplesKt.to(3, valueOf), TuplesKt.to(4, Float.valueOf(17.0f)), TuplesKt.to(5, Float.valueOf(16.0f)), TuplesKt.to(6, Float.valueOf(15.0f))}), Integer.valueOf(parseColor));
        COLOR_DIVIDER = Color.parseColor("#1F4D6B99");
        COLOR_CARD_BG = Color.rgb(244, 244, 244);
        COLOR_CARD_HEADER_BG = Color.parseColor("#14737373");
        COLOR_CARD_STROKE = Color.parseColor("#2E737373");
        COLOR_CARD_DIVIDER = Color.parseColor("#2E4D6B99");
    }
}
