package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ExpressPassBenefitManager;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.im.service.FastRequestEvent;
import com.bytedance.trae.im.service.FastRequestEventType;
import com.bytedance.trae.multilanguage.I18nLanguage;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: FreeActivityQuotaErrorRenderer.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FreeActivityQuotaError;", "<init>", "()V", "isToAppLog", "", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "createActionButton", "density", "", "buildFreeActivityQuotaMessage", "", "data", "Lcom/google/gson/JsonObject;", "shouldShowAction", "formatResetDate", "dimension", "update", "", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FreeActivityQuotaErrorRenderer implements IBlockRenderer<AgentContentBlock.FreeActivityQuotaError> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);
    private boolean isToAppLog;

    /* compiled from: FreeActivityQuotaErrorRenderer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[I18nLanguage.values().length];
            try {
                iArr[I18nLanguage.JA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[I18nLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: FreeActivityQuotaErrorRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/FreeActivityQuotaErrorRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016b  */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View render(Context context, final AgentContentBlock.FreeActivityQuotaError block) {
        boolean z;
        String str;
        String str2;
        boolean z2;
        JsonElement jsonElement;
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[FreeActivityQuotaErrorRenderer] render");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int i = (int) (16 * f);
        float f2 = 12 * f;
        int i2 = (int) f2;
        linearLayout.setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_status_info_surface_l1));
        gradientDrawable.setStroke((int) (1 * f), ContextCompat.getColor(context, C0591R.color.trae_status_primary_surface_l2));
        linearLayout.setBackground(gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i3 = (int) (8 * f);
        layoutParams.topMargin = i3;
        int i4 = (int) (4 * f);
        layoutParams.bottomMargin = i4;
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(C0637R.drawable.info_filled_blue);
        imageView.setColorFilter(ContextCompat.getColor(context, C0591R.color.trae_status_info_default));
        int i5 = (int) (20 * f);
        linearLayout2.addView(imageView, new LinearLayout.LayoutParams(i5, i5));
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.setMarginStart(i4);
        textView.setLayoutParams(layoutParams2);
        textView.setText(context.getString(C0637R.string.trae_chat_stream_tips_title));
        linearLayout2.addView(textView);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        if (block.isLatestAgent()) {
            JsonObject data = block.getError().getData();
            if (data != null && (jsonElement = data.get("fast_request_event")) != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    FreeActivityQuotaErrorRenderer freeActivityQuotaErrorRenderer = this;
                    obj = Result.constructor-impl((FastRequestEvent) new Gson().fromJson(jsonElement, FastRequestEvent.class));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                FastRequestEvent fastRequestEvent = (FastRequestEvent) obj;
                if (fastRequestEvent != null) {
                    Integer type = fastRequestEvent.getType();
                    int value = FastRequestEventType.HasQuotaCanUse.getValue();
                    if (type != null && type.intValue() == value) {
                        z2 = true;
                        if (z2) {
                            z = true;
                            if (block.getError().getData() == null) {
                                JsonObject data2 = block.getError().getData();
                                Intrinsics.checkNotNull(data2);
                                str = buildFreeActivityQuotaMessage(context, data2, z);
                            } else {
                                str = "";
                            }
                            TextView textView2 = new TextView(context);
                            textView2.setTextSize(2, 13.0f);
                            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams3.topMargin = i4;
                            textView2.setLayoutParams(layoutParams3);
                            str2 = str;
                            if (!(str2.length() != 0)) {
                                textView2.setVisibility(8);
                            } else {
                                textView2.setVisibility(0);
                                textView2.setText(str2);
                            }
                            linearLayout.addView(textView2);
                            View createActionButton = createActionButton(context, f);
                            final long[] jArr = {0};
                            createActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FreeActivityQuotaErrorRenderer$$ExternalSyntheticLambda0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    FreeActivityQuotaErrorRenderer.render$lambda$11(jArr, block, view);
                                }
                            });
                            createActionButton.setVisibility(z ? 0 : 8);
                            if (z && !this.isToAppLog) {
                                this.isToAppLog = true;
                                try {
                                    IApplog.Companion companion3 = IApplog.INSTANCE;
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("unique_id", block.getOriginMessage().getSessionId() + '_' + block.getOriginMessage().getMessageId());
                                    Unit unit = Unit.INSTANCE;
                                    companion3.reportEvent("im_quota_banner_occur", jSONObject);
                                } catch (Throwable unused) {
                                }
                            }
                            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams4.topMargin = i3;
                            layoutParams4.gravity = 8388613;
                            linearLayout.addView(createActionButton, layoutParams4);
                            return linearLayout;
                        }
                    }
                }
            }
            z2 = false;
            if (z2) {
            }
        }
        z = false;
        if (block.getError().getData() == null) {
        }
        TextView textView22 = new TextView(context);
        textView22.setTextSize(2, 13.0f);
        textView22.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams32.topMargin = i4;
        textView22.setLayoutParams(layoutParams32);
        str2 = str;
        if (!(str2.length() != 0)) {
        }
        linearLayout.addView(textView22);
        View createActionButton2 = createActionButton(context, f);
        final long[] jArr2 = {0};
        createActionButton2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.FreeActivityQuotaErrorRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FreeActivityQuotaErrorRenderer.render$lambda$11(jArr2, block, view);
            }
        });
        createActionButton2.setVisibility(z ? 0 : 8);
        if (z) {
            this.isToAppLog = true;
            IApplog.Companion companion32 = IApplog.INSTANCE;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("unique_id", block.getOriginMessage().getSessionId() + '_' + block.getOriginMessage().getMessageId());
            Unit unit2 = Unit.INSTANCE;
            companion32.reportEvent("im_quota_banner_occur", jSONObject2);
        }
        LinearLayout.LayoutParams layoutParams42 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams42.topMargin = i3;
        layoutParams42.gravity = 8388613;
        linearLayout.addView(createActionButton2, layoutParams42);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$11(long[] jArr, AgentContentBlock.FreeActivityQuotaError freeActivityQuotaError, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - jArr[0] < 500) {
            return;
        }
        jArr[0] = currentTimeMillis;
        IApplog.INSTANCE.reportEvent("im_quota_banner_click");
        ExpressPassBenefitManager.INSTANCE.notifyBenefitEnable();
        Function1<AgentContentBlock.ActionType, Unit> onActionClick = freeActivityQuotaError.getOnActionClick();
        if (onActionClick != null) {
            onActionClick.invoke(AgentContentBlock.ActionType.USER_ERPRESS_PASS_WHEN_ERROR);
        }
    }

    private final View createActionButton(Context context, float density) {
        float f = context.getResources().getDisplayMetrics().density;
        I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        String string = i18nTextProvider.getString(resources, R.string.imkit_queue_canuse_button, new Object[0]);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(C0637R.id.btn_use_now);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        int i = (int) (12 * f);
        linearLayout.setPadding(i, i, i, i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_base_secondary));
        gradientDrawable.setCornerRadius(8 * f);
        gradientDrawable.setStroke((int) (1 * f), ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2));
        linearLayout.setBackground(gradientDrawable);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, i));
        TextView textView = new TextView(context);
        textView.setText(string);
        textView.setGravity(17);
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart((int) (4 * f));
        textView.setLayoutParams(layoutParams);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final String buildFreeActivityQuotaMessage(Context context, JsonObject data, boolean shouldShowAction) {
        int i;
        int i2;
        Resources resources = context.getResources();
        JsonElement jsonElement = data.get("dimension");
        String str = null;
        if (jsonElement != null) {
            if (!(!jsonElement.isJsonNull())) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        if (shouldShowAction) {
            String formatResetDate = formatResetDate(context, str);
            String str2 = str;
            if (TextUtils.equals(str2, "weekly")) {
                i2 = R.string.imkit_weekly_limit_canuse;
            } else {
                i2 = TextUtils.equals(str2, "monthly") ? R.string.imkit_monthly_limit_canuse : R.string.imkit_daily_limit_canuse;
            }
            I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
            Intrinsics.checkNotNull(resources);
            String string = i18nTextProvider.getString(resources, i2, new Object[]{formatResetDate});
            if (string.length() == 0) {
                String string2 = I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_free_activity_quota, new Object[0]);
                string = string2.length() == 0 ? "Let's call it a day. Get some rest and we'll pick this back up tomorrow!" : string2;
            }
            return string;
        }
        String formatResetDate2 = formatResetDate(context, str);
        String str3 = str;
        if (TextUtils.equals(str3, "weekly")) {
            i = R.string.imkit_weekly_limit_cannotuse;
        } else {
            i = TextUtils.equals(str3, "monthly") ? R.string.imkit_monthly_limit_cannotuse : R.string.imkit_daily_limit_cannotuse;
        }
        I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
        Intrinsics.checkNotNull(resources);
        String string3 = i18nTextProvider2.getString(resources, i, new Object[]{formatResetDate2});
        if (string3.length() == 0) {
            String string4 = I18nTextProvider.INSTANCE.getString(resources, R.string.imkit_error_free_activity_quota, new Object[0]);
            string3 = string4.length() == 0 ? "Let's call it a day. Get some rest and we'll pick this back up tomorrow!" : string4;
        }
        return string3;
    }

    private final String formatResetDate(Context context, String dimension) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"));
        String str = dimension;
        if (TextUtils.equals(str, "weekly")) {
            int i = 7;
            switch (calendar.get(7)) {
                case 1:
                    i = 1;
                    break;
                case 3:
                    i = 6;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 4;
                    break;
                case 6:
                    i = 3;
                    break;
                case 7:
                    i = 2;
                    break;
            }
            calendar.add(6, i);
        } else if (TextUtils.equals(str, "monthly")) {
            calendar.add(2, 1);
            calendar.set(5, 1);
        } else {
            calendar.add(6, 1);
        }
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        boolean equals = TextUtils.equals(str, "monthly");
        Locale locale = context.getResources().getConfiguration().getLocales().get(0);
        if (locale == null) {
            locale = Locale.getDefault();
        }
        I18nLanguage.Companion companion = I18nLanguage.Companion;
        Intrinsics.checkNotNull(locale);
        int i5 = WhenMappings.$EnumSwitchMapping$0[companion.fromLocale(locale).ordinal()];
        if (i5 == 1) {
            if (equals) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.JAPANESE, "%d年%d月 1日", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                return format;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.JAPANESE, "%d年%d月%d日", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        if (i5 != 2) {
            if (equals) {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format(Locale.ENGLISH, "%04d-%02d-01", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                return format3;
            }
            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
            String format4 = String.format(Locale.ENGLISH, "%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            return format4;
        }
        if (equals) {
            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
            String format5 = String.format(Locale.CHINESE, "%d 年 %d月 1日", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}, 2));
            Intrinsics.checkNotNullExpressionValue(format5, "format(...)");
            return format5;
        }
        StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
        String format6 = String.format(Locale.CHINESE, "%d 年 %d月 %d 日", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
        Intrinsics.checkNotNullExpressionValue(format6, "format(...)");
        return format6;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(View view, AgentContentBlock.FreeActivityQuotaError block) {
        boolean z;
        boolean z2;
        JsonElement jsonElement;
        Object obj;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        if (view instanceof LinearLayout) {
            try {
                View findViewById = view.findViewById(C0637R.id.btn_use_now);
                int i = 0;
                if (block.isLatestAgent()) {
                    JsonObject data = block.getError().getData();
                    z = true;
                    if (data != null && (jsonElement = data.get("fast_request_event")) != null) {
                        try {
                            Result.Companion companion = Result.Companion;
                            FreeActivityQuotaErrorRenderer freeActivityQuotaErrorRenderer = this;
                            obj = Result.constructor-impl((FastRequestEvent) new Gson().fromJson(jsonElement, FastRequestEvent.class));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        FastRequestEvent fastRequestEvent = (FastRequestEvent) obj;
                        if (fastRequestEvent != null) {
                            Integer type = fastRequestEvent.getType();
                            int value = FastRequestEventType.HasQuotaCanUse.getValue();
                            if (type != null && type.intValue() == value) {
                                z2 = true;
                                if (z2) {
                                    if (z) {
                                        i = 8;
                                    }
                                    findViewById.setVisibility(i);
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                z = false;
                if (z) {
                }
                findViewById.setVisibility(i);
            } catch (Throwable unused) {
            }
        }
    }
}
