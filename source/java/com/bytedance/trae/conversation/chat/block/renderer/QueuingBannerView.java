package com.bytedance.trae.conversation.chat.block.renderer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.service.FastRequestEvent;
import com.bytedance.trae.im.service.FastRequestEventType;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: QueuingBannerView.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingBannerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconView", "Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "messageView", "actionView", "Landroid/view/View;", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "queryItem", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;", "getQueryItem", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;", "setQueryItem", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;)V", "isToAppLog", "", "render", "", "query", "updateQueue", "updateTitle", "title", "", "buildTitleText", "block", "createActionButton", "buildDisplayText", "buildOrdinaryQueueText", "useFastRequest", "usePayLoadingView", "showLoading", "hideLoading", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class QueuingBannerView extends LinearLayout {
    private final View actionView;
    private final GradientDrawable backgroundDrawable;
    private final ImageView iconView;
    private boolean isToAppLog;
    private final TextView messageView;
    public AgentContentBlock.Queuing queryItem;
    private final TextView titleView;
    private View usePayLoadingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueuingBannerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (16 * f);
        float f2 = 12 * f;
        int i2 = (int) f2;
        setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setStroke((int) (1 * f), 0);
        this.backgroundDrawable = gradientDrawable;
        setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.iconView = imageView;
        int i3 = (int) (20 * f);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i3, i3));
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        int i4 = (int) (4 * f);
        layoutParams.setMarginStart(i4);
        textView.setLayoutParams(layoutParams);
        this.titleView = textView;
        linearLayout.addView(textView);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(context);
        textView2.setTextSize(2, 13.0f);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i4;
        textView2.setLayoutParams(layoutParams2);
        this.messageView = textView2;
        addView(textView2);
        View createActionButton = createActionButton();
        this.actionView = createActionButton;
        createActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QueuingBannerView.this.useFastRequest();
            }
        });
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = (int) (8 * f);
        layoutParams3.gravity = 8388613;
        addView(createActionButton, layoutParams3);
    }

    public final AgentContentBlock.Queuing getQueryItem() {
        AgentContentBlock.Queuing queuing = this.queryItem;
        if (queuing != null) {
            return queuing;
        }
        Intrinsics.throwUninitializedPropertyAccessException("queryItem");
        return null;
    }

    public final void setQueryItem(AgentContentBlock.Queuing queuing) {
        Intrinsics.checkNotNullParameter(queuing, "<set-?>");
        this.queryItem = queuing;
    }

    public final void render(AgentContentBlock.Queuing query) {
        Intrinsics.checkNotNullParameter(query, "query");
        setQueryItem(query);
        float f = getResources().getDisplayMetrics().density;
        int i = C0591R.color.trae_status_info_surface_l1;
        int i2 = C0591R.color.trae_status_primary_surface_l2;
        int i3 = C0591R.color.trae_status_info_default;
        int i4 = C0637R.drawable.info_filled_blue;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String buildDisplayText = buildDisplayText(context, query);
        this.backgroundDrawable.setColor(ContextCompat.getColor(getContext(), i));
        this.backgroundDrawable.setStroke((int) (1 * f), ContextCompat.getColor(getContext(), i2));
        this.iconView.setImageResource(i4);
        this.iconView.setColorFilter(ContextCompat.getColor(getContext(), i3));
        TextView textView = this.titleView;
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        textView.setText(buildTitleText(context2, query));
        String str = buildDisplayText;
        if (str.length() == 0) {
            this.messageView.setVisibility(8);
        } else {
            this.messageView.setVisibility(0);
            this.messageView.setText(str);
        }
        QueuingBannerPolicy queuingBannerPolicy = QueuingBannerPolicy.INSTANCE;
        FastRequestEvent fastRequestEvent = query.getFastRequestEvent();
        if (queuingBannerPolicy.shouldShowFastRequestAction(fastRequestEvent != null ? fastRequestEvent.getType() : null, TocCreditsPolicy.INSTANCE.isEnabled())) {
            this.actionView.setVisibility(0);
            if (this.isToAppLog) {
                return;
            }
            this.isToAppLog = true;
            IApplog.Companion companion = IApplog.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("unique_id", query.getOriginMessage().getSessionId() + '_' + query.getRequestUUid());
            Unit unit = Unit.INSTANCE;
            companion.reportEvent("im_queue_banner_occur", jSONObject);
            return;
        }
        this.actionView.setVisibility(8);
    }

    public final void updateQueue(AgentContentBlock.Queuing query) {
        Intrinsics.checkNotNullParameter(query, "query");
        setQueryItem(query);
        TextView textView = this.titleView;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        textView.setText(buildTitleText(context, query));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        String buildDisplayText = buildDisplayText(context2, query);
        if (buildDisplayText.length() == 0) {
            this.messageView.setVisibility(8);
        } else {
            this.messageView.setVisibility(0);
            this.messageView.setText(buildDisplayText);
        }
        QueuingBannerPolicy queuingBannerPolicy = QueuingBannerPolicy.INSTANCE;
        FastRequestEvent fastRequestEvent = query.getFastRequestEvent();
        if (queuingBannerPolicy.shouldShowFastRequestAction(fastRequestEvent != null ? fastRequestEvent.getType() : null, TocCreditsPolicy.INSTANCE.isEnabled())) {
            this.actionView.setVisibility(0);
        } else {
            this.actionView.setVisibility(8);
        }
    }

    public final void updateTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleView.setText(title);
    }

    private final String buildTitleText(Context context, AgentContentBlock.Queuing block) {
        String noticeTitle = block.getNoticeTitle();
        if (noticeTitle != null) {
            if (!(!StringsKt.isBlank(noticeTitle))) {
                noticeTitle = null;
            }
            if (noticeTitle != null) {
                return noticeTitle;
            }
        }
        String string = context.getString(C0637R.string.trae_chat_queue_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final View createActionButton() {
        float f = getContext().getResources().getDisplayMetrics().density;
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String string = i18nTextProvider.getString(resources, R.string.imkit_queue_canuse_button, new Object[0]);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        int i = (int) (12 * f);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(linearLayout.getContext(), C0591R.color.trae_bg_bg_base_secondary));
        gradientDrawable.setCornerRadius(8 * f);
        gradientDrawable.setStroke((int) (1 * f), ContextCompat.getColor(linearLayout.getContext(), C0591R.color.trae_border_border_neutral_l2));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i));
        TextView textView = new TextView(getContext());
        textView.setText(string);
        textView.setGravity(17);
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_text_text_default));
        textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) (4 * f));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final String buildDisplayText(Context context, AgentContentBlock.Queuing block) {
        if (!QueuingBannerPolicy.INSTANCE.shouldUseFastRequestPresentation(TocCreditsPolicy.INSTANCE.isEnabled())) {
            return buildOrdinaryQueueText(context, block);
        }
        FastRequestEvent fastRequestEvent = block.getFastRequestEvent();
        if (fastRequestEvent != null ? Intrinsics.areEqual(fastRequestEvent.getRefunded(), true) : false) {
            if (UserPayIdentityService.getUserPayIdentity() == 100) {
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                Resources resources = getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                return i18nTextProvider.getString(resources, R.string.imkit_queue_refund_999, new Object[]{Integer.valueOf(block.getPosition())});
            }
            I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            return i18nTextProvider2.getString(resources2, R.string.imkit_queue_refund, new Object[]{Integer.valueOf(block.getPosition())});
        }
        try {
            FastRequestEvent fastRequestEvent2 = block.getFastRequestEvent();
            Integer type = fastRequestEvent2 != null ? fastRequestEvent2.getType() : null;
            int value = FastRequestEventType.HasQuotaCanUse.getValue();
            if (type != null && type.intValue() == value) {
                I18nTextProvider i18nTextProvider3 = I18nTextProvider.INSTANCE;
                Resources resources3 = getResources();
                Intrinsics.checkNotNullExpressionValue(resources3, "getResources(...)");
                return i18nTextProvider3.getString(resources3, R.string.imkit_queue_canuse, new Object[]{Integer.valueOf(block.getPosition())});
            }
        } catch (Throwable unused) {
        }
        return buildOrdinaryQueueText(context, block);
    }

    private final String buildOrdinaryQueueText(Context context, AgentContentBlock.Queuing block) {
        String message = block.getMessage();
        if (message != null) {
            if (!(!StringsKt.isBlank(message))) {
                message = null;
            }
            if (message != null) {
                return message;
            }
        }
        String string = context.getString(C0637R.string.trae_chat_queue_alert_body, Integer.valueOf(block.getPosition()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void useFastRequest() {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            this.actionView.setVisibility(8);
            return;
        }
        AgentContentBlock.Queuing queryItem = getQueryItem();
        String sessionId = queryItem.getOriginMessage().getSessionId();
        Object content = queryItem.getOriginMessage().getContent();
        ParsedTaskContent parsedTaskContent = content instanceof ParsedTaskContent ? (ParsedTaskContent) content : null;
        String taskId = parsedTaskContent != null ? parsedTaskContent.getTaskId() : null;
        if (taskId == null) {
            taskId = "";
        }
        String queueId = queryItem.getQueueId();
        String str = queueId == null ? "" : queueId;
        String replyToMessageId = queryItem.getOriginMessage().getReplyToMessageId();
        showLoading();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new QueuingBannerView$useFastRequest$1(sessionId, taskId, str, replyToMessageId, this, null), 3, (Object) null);
    }

    private final void showLoading() {
        post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                QueuingBannerView.showLoading$lambda$18(QueuingBannerView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLoading$lambda$18(QueuingBannerView queuingBannerView) {
        try {
            if (queuingBannerView.usePayLoadingView != null) {
                return;
            }
            Context context = queuingBannerView.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup == null) {
                return;
            }
            View inflate = LayoutInflater.from(queuingBannerView.getContext()).inflate(C0637R.layout.loading_progress_bar_voice, viewGroup, false);
            viewGroup.addView(inflate);
            queuingBannerView.usePayLoadingView = inflate;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        try {
            View view = this.usePayLoadingView;
            if (view == null) {
                return;
            }
            Context context = getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.usePayLoadingView = null;
        } catch (Throwable unused) {
        }
    }
}
