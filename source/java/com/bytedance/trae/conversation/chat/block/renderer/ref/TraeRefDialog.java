package com.bytedance.trae.conversation.chat.block.renderer.ref;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TraeRefDialog.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010\u0015\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;", "", "<init>", "()V", "DEFAULT_LISTENER", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;", "getDEFAULT_LISTENER", "()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;", "show", "", "context", "Landroid/content/Context;", "group", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "webReferences", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/WebReference;", "buildContentView", "Landroid/view/View;", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "buildSourceItem", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;", "webRef", "dp", "", "onClick", "Lkotlin/Function0;", "normalizeUrl", "", IWeixinService.ResponseConstants.URL, "openUrl", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRefDialog {
    public static final TraeRefDialog INSTANCE = new TraeRefDialog();
    private static final TraeRefClickListener DEFAULT_LISTENER = new TraeRefClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog$$ExternalSyntheticLambda0
        @Override // com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener
        public final void onRefClick(View view, TraeRefGroup traeRefGroup) {
            TraeRefDialog.DEFAULT_LISTENER$lambda$0(view, traeRefGroup);
        }
    };

    private static final int buildContentView$dp(int i, float f) {
        return (int) (i * f);
    }

    private static final int buildSourceItem$dp$12(int i, float f) {
        return (int) (i * f);
    }

    private TraeRefDialog() {
    }

    public final TraeRefClickListener getDEFAULT_LISTENER() {
        return DEFAULT_LISTENER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DEFAULT_LISTENER$lambda$0(View view, TraeRefGroup traeRefGroup) {
        Intrinsics.checkNotNullParameter(view, "anchor");
        Intrinsics.checkNotNullParameter(traeRefGroup, "group");
        TraeRefDialog traeRefDialog = INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        traeRefDialog.show(context, traeRefGroup, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(TraeRefDialog traeRefDialog, Context context, TraeRefGroup traeRefGroup, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        traeRefDialog.show(context, traeRefGroup, list);
    }

    public final void show(Context context, TraeRefGroup group, List<WebReference> webReferences) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(group, "group");
        if (group.getSources().isEmpty()) {
            return;
        }
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
        bottomSheetDialog.setContentView(buildContentView(context, group, webReferences, bottomSheetDialog));
        bottomSheetDialog.show();
    }

    private final View buildContentView(final Context context, TraeRefGroup group, List<WebReference> webReferences, final BottomSheetDialog dialog) {
        LinkedHashMap emptyMap;
        char c;
        float f = context.getResources().getDisplayMetrics().density;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                TraeRefDialog.buildContentView$lambda$1(dialog, dialogInterface);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundResource(C0637R.drawable.trae_bg_bottom_sheet);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, buildContentView$dp(545, f)));
        TraeTitleBar traeTitleBar = new TraeTitleBar(context, null, 0, 6, null);
        traeTitleBar.setMode(TraeTitleBar.Mode.SHEET, true);
        traeTitleBar.setTitle(group.getSources().size() + " sources");
        traeTitleBar.setRightAction(TraeTitleBar.Action.CLOSE);
        traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        traeTitleBar.setBackgroundResource(C0637R.drawable.trae_bg_bottom_sheet);
        traeTitleBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(traeTitleBar);
        if (webReferences != null) {
            List<WebReference> list = webReferences;
            emptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                emptyMap.put(INSTANCE.normalizeUrl(((WebReference) obj).getLink()), obj);
            }
        } else {
            emptyMap = MapsKt.emptyMap();
        }
        Map map = emptyMap;
        NestedScrollView nestedScrollView = new NestedScrollView(context);
        nestedScrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(0, 0, 0, buildContentView$dp(16, f));
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        int i = 0;
        for (Object obj2 : group.getSources()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            final TraeRefSource traeRefSource = (TraeRefSource) obj2;
            TraeRefDialog traeRefDialog = INSTANCE;
            int i3 = i;
            linearLayout2.addView(traeRefDialog.buildSourceItem(context, traeRefSource, (WebReference) map.get(traeRefDialog.normalizeUrl(traeRefSource.getUrl())), f, new Function0() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit buildContentView$lambda$11$lambda$8;
                    buildContentView$lambda$11$lambda$8 = TraeRefDialog.buildContentView$lambda$11$lambda$8(context, traeRefSource, dialog);
                    return buildContentView$lambda$11$lambda$8;
                }
            }));
            if (i3 < group.getSources().size() - 1) {
                View view = new View(context);
                view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
                c = 16;
                layoutParams.setMarginStart(buildContentView$dp(16, f));
                layoutParams.setMarginEnd(buildContentView$dp(16, f));
                layoutParams.topMargin = buildContentView$dp(16, f);
                layoutParams.bottomMargin = buildContentView$dp(16, f);
                view.setLayoutParams(layoutParams);
                linearLayout2.addView(view);
            } else {
                c = 16;
            }
            i = i2;
        }
        nestedScrollView.addView(linearLayout2);
        linearLayout.addView((View) nestedScrollView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildContentView$lambda$1(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        View findViewById;
        if ((dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null) == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        findViewById.setBackgroundResource(android.R.color.transparent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildContentView$lambda$11$lambda$8(Context context, TraeRefSource traeRefSource, BottomSheetDialog bottomSheetDialog) {
        INSTANCE.openUrl(context, traeRefSource.getUrl());
        bottomSheetDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x012a, code lost:
    
        if (r6 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View buildSourceItem(Context context, TraeRefSource source, WebReference webRef, float dp, final Function0<Unit> onClick) {
        String title;
        String content;
        String str;
        String description;
        int color = ContextCompat.getColor(context, C0591R.color.trae_text_text_default);
        int color2 = ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary);
        LinearLayout linearLayout = new LinearLayout(context);
        boolean z = true;
        linearLayout.setOrientation(1);
        linearLayout.setPadding(buildSourceItem$dp$12(16, dp), 0, buildSourceItem$dp$12(16, dp), 0);
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClick.invoke();
            }
        });
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(context);
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(16);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        String favicon = webRef != null ? webRef.getFavicon() : null;
        SimpleDraweeView simpleDraweeView = new SimpleDraweeView(context);
        simpleDraweeView.getHierarchy().setPlaceholderImage(C0637R.drawable.ic_tool_web);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(buildSourceItem$dp$12(16, dp), buildSourceItem$dp$12(16, dp));
        layoutParams.setMarginEnd(buildSourceItem$dp$12(4, dp));
        layoutParams.gravity = 16;
        simpleDraweeView.setLayoutParams(layoutParams);
        simpleDraweeView.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(2.15f * dp));
        linearLayout3.addView((View) simpleDraweeView);
        String str2 = favicon;
        if (!(str2 == null || StringsKt.isBlank(str2)) && StringsKt.startsWith$default(favicon, "http", false, 2, (Object) null)) {
            simpleDraweeView.setImageURI(Uri.parse(favicon));
        }
        TextView textView = new TextView(context);
        textView.setText(source.getHost());
        textView.setTextSize(0, context.getResources().getDimension(C0591R.dimen.trae_footnote_footnote_font_size_sp));
        TextViewCompat.setLineHeight(textView, context.getResources().getDimensionPixelSize(C0591R.dimen.trae_footnote_footnote_line_height_dp));
        textView.setTextColor(color2);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.gravity = 16;
        textView.setLayoutParams(layoutParams2);
        linearLayout3.addView(textView);
        linearLayout2.addView(linearLayout3);
        if (webRef != null && (title = webRef.getTitle()) != null) {
            if (!(!StringsKt.isBlank(title))) {
                title = null;
            }
        }
        title = source.getTitle();
        if (title == null || !(!StringsKt.isBlank(title))) {
            title = null;
        }
        if (title == null) {
            title = source.getHost();
        }
        TextView textView2 = new TextView(context);
        textView2.setText(title);
        textView2.setTextSize(0, context.getResources().getDimension(C0591R.dimen.trae_body_body_sm_md_font_size_sp));
        TextViewCompat.setLineHeight(textView2, context.getResources().getDimensionPixelSize(C0591R.dimen.trae_body_body_sm_md_line_height_dp));
        textView2.setTextColor(color);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setPadding(0, buildSourceItem$dp$12(4, dp), 0, 0);
        linearLayout2.addView(textView2);
        if (webRef != null && (description = webRef.getDescription()) != null) {
            if (!(!StringsKt.isBlank(description))) {
                description = null;
            }
            if (description != null) {
                content = description;
                str = content;
                if (str != null && !StringsKt.isBlank(str)) {
                    z = false;
                }
                if (!z) {
                    TextView textView3 = new TextView(context);
                    textView3.setText(StringsKt.replace$default(content, "\n", " ", false, 4, (Object) null));
                    textView3.setTextSize(0, context.getResources().getDimension(C0591R.dimen.trae_footnote_footnote_font_size_sp));
                    TextViewCompat.setLineHeight(textView3, context.getResources().getDimensionPixelSize(C0591R.dimen.trae_footnote_footnote_line_height_dp));
                    textView3.setTextColor(color2);
                    textView3.setMaxLines(3);
                    textView3.setEllipsize(TextUtils.TruncateAt.END);
                    textView3.setPadding(0, buildSourceItem$dp$12(4, dp), 0, 0);
                    linearLayout2.addView(textView3);
                }
                linearLayout.addView(linearLayout2);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                return linearLayout;
            }
        }
        content = webRef != null ? webRef.getContent() : null;
        str = content;
        if (str != null) {
            z = false;
        }
        if (!z) {
        }
        linearLayout.addView(linearLayout2);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    private final String normalizeUrl(String url) {
        String lowerCase = StringsKt.trimEnd(url, new char[]{'/'}).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final void openUrl(Context context, String url) {
        try {
            Result.Companion companion = Result.Companion;
            TraeRefDialog traeRefDialog = this;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
