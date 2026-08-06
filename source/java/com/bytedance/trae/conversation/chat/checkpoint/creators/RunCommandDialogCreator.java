package com.bytedance.trae.conversation.chat.checkpoint.creators;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointTypefaces;
import com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RunCommandDialogCreator.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0003\u0019\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator;", "Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "<init>", "()V", "resolveWarningLevel", "Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "getTitle", "", "getPrimaryButtonText", "getSecondaryButtonText", "getDescriptionText", "buildWarningView", "density", "", "buildCommandListText", "getWarningConfig", "Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;", "WarningLevel", "WarningConfig", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunCommandDialogCreator implements ICheckpointDialogCreator {
    public static final String BLOCK_LEVEL_BLACKLIST = "blacklist";
    public static final String BLOCK_LEVEL_MANUAL = "manual";
    public static final String BLOCK_LEVEL_REDLIST = "redlist";
    public static final String BLOCK_LEVEL_SANDBOX_EXECUTE_FAILURE = "sandbox_execute_failure";
    public static final String BLOCK_LEVEL_SANDBOX_NOT_BLOCK_COMMAND = "sandbox_not_block_command";
    public static final String BLOCK_LEVEL_SANDBOX_TO_RECOVERY = "sandbox_to_recovery";
    public static final String BLOCK_LEVEL_SANDBOX_UNAVAILABLE = "sandbox_unavailable";

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getTitle(Context context, ParsedToolCallInfo toolCallInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        return "";
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View view, Function0<Unit> function0, Function0<Unit> function02) {
        ICheckpointDialogCreator.DefaultImpls.bindActions(this, view, function0, function02);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void bindActions(View view, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.bindActions(this, view, function0, function02, function1);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getCHECK_POINT_TAG() {
        return ICheckpointDialogCreator.DefaultImpls.getCHECK_POINT_TAG(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getContentTopMarginDp() {
        return ICheckpointDialogCreator.DefaultImpls.getContentTopMarginDp(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getContentTopMarginRes() {
        return ICheckpointDialogCreator.DefaultImpls.getContentTopMarginRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getHeaderLabel(Context context) {
        return ICheckpointDialogCreator.DefaultImpls.getHeaderLabel(this, context);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getPrimaryButtonBackgroundRes() {
        return ICheckpointDialogCreator.DefaultImpls.getPrimaryButtonBackgroundRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public float getTitleLetterSpacing() {
        return ICheckpointDialogCreator.DefaultImpls.getTitleLetterSpacing(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public int getTitleTextColorRes() {
        return ICheckpointDialogCreator.DefaultImpls.getTitleTextColorRes(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean hideDefaultButtons() {
        return ICheckpointDialogCreator.DefaultImpls.hideDefaultButtons(this);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setFileClickListener(Function1<? super String, Unit> function1) {
        ICheckpointDialogCreator.DefaultImpls.setFileClickListener(this, function1);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public void setResolvedDisplayName(String str) {
        ICheckpointDialogCreator.DefaultImpls.setResolvedDisplayName(this, str);
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public boolean showCloseButton() {
        return ICheckpointDialogCreator.DefaultImpls.showCloseButton(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RunCommandDialogCreator.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningLevel;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "NORMAL", "HIGH", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class WarningLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ WarningLevel[] $VALUES;
        public static final WarningLevel NONE = new WarningLevel("NONE", 0);
        public static final WarningLevel NORMAL = new WarningLevel("NORMAL", 1);
        public static final WarningLevel HIGH = new WarningLevel("HIGH", 2);

        private static final /* synthetic */ WarningLevel[] $values() {
            return new WarningLevel[]{NONE, NORMAL, HIGH};
        }

        public static EnumEntries<WarningLevel> getEntries() {
            return $ENTRIES;
        }

        static {
            WarningLevel[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private WarningLevel(String str, int i) {
        }

        public static WarningLevel valueOf(String str) {
            return (WarningLevel) Enum.valueOf(WarningLevel.class, str);
        }

        public static WarningLevel[] values() {
            return (WarningLevel[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (r0.equals(com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.BLOCK_LEVEL_SANDBOX_UNAVAILABLE) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0098, code lost:
    
        r0 = r5.getHitBlackList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x009e, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a4, code lost:
    
        if (r0.isEmpty() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a7, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00aa, code lost:
    
        if (r0 != false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.WarningLevel.HIGH;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00af, code lost:
    
        r5 = r5.getHitRedList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b5, code lost:
    
        if (r5 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bb, code lost:
    
        if (r5.isEmpty() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
    
        if (r1 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.WarningLevel.NORMAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.WarningLevel.NORMAL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bd, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a9, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0044, code lost:
    
        if (r0.equals(com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.BLOCK_LEVEL_SANDBOX_NOT_BLOCK_COMMAND) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x004f, code lost:
    
        if (r0.equals(com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.BLOCK_LEVEL_SANDBOX_TO_RECOVERY) == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0095, code lost:
    
        if (r0.equals(com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator.BLOCK_LEVEL_SANDBOX_EXECUTE_FAILURE) == false) goto L67;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final WarningLevel resolveWarningLevel(ConfirmInfo confirmInfo) {
        if (confirmInfo == null) {
            return WarningLevel.NONE;
        }
        String blockLevel = confirmInfo.getBlockLevel();
        if (blockLevel != null) {
            switch (blockLevel.hashCode()) {
                case -1666895544:
                    break;
                case -1081415738:
                    if (blockLevel.equals("manual")) {
                        List<String> hitBlackList = confirmInfo.getHitBlackList();
                        if (!(hitBlackList == null || hitBlackList.isEmpty())) {
                            return WarningLevel.HIGH;
                        }
                        List<String> hitRedList = confirmInfo.getHitRedList();
                        return !(hitRedList == null || hitRedList.isEmpty()) ? WarningLevel.NORMAL : WarningLevel.NONE;
                    }
                    break;
                case -611981471:
                    break;
                case 973218229:
                    break;
                case 1083422895:
                    if (blockLevel.equals(BLOCK_LEVEL_REDLIST)) {
                        return WarningLevel.NORMAL;
                    }
                    break;
                case 1333012765:
                    if (blockLevel.equals(BLOCK_LEVEL_BLACKLIST)) {
                        return WarningLevel.HIGH;
                    }
                    break;
                case 2057241304:
                    break;
            }
        }
        List<String> hitBlackList2 = confirmInfo.getHitBlackList();
        if (!(hitBlackList2 == null || hitBlackList2.isEmpty())) {
            return WarningLevel.HIGH;
        }
        List<String> hitRedList2 = confirmInfo.getHitRedList();
        return !(hitRedList2 == null || hitRedList2.isEmpty()) ? WarningLevel.NORMAL : WarningLevel.NONE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r14 != null) goto L19;
     */
    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        JsonElement jsonElement;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        FLogger.INSTANCE.i(getCHECK_POINT_TAG(), "[RunCommandDialogCreator] createContentView: toolCallInfo=" + toolCallInfo);
        float f = context.getResources().getDisplayMetrics().density;
        JsonObject params = toolCallInfo.getParams();
        if (params == null || (jsonElement = params.get("command")) == null) {
            JsonObject params2 = toolCallInfo.getParams();
            jsonElement = params2 != null ? params2.get("cmd") : null;
        }
        if (jsonElement != null) {
            JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
            }
        }
        str = "";
        WarningLevel resolveWarningLevel = resolveWarningLevel(confirmInfo);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (resolveWarningLevel == WarningLevel.NONE) {
            TextView textView = new TextView(context);
            textView.setText(context.getString(C0637R.string.trae_checkpoint_run_command_title));
            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
            textView.setTextSize(2, 17.0f);
            textView.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        } else {
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            int i = (int) (20 * f);
            int i2 = resolveWarningLevel == WarningLevel.HIGH ? C0637R.drawable.warning_filled_red : C0637R.drawable.warning_filled_yellow;
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(i2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.setMarginEnd((int) (4 * f));
            imageView.setLayoutParams(layoutParams);
            linearLayout2.addView(imageView);
            TextView textView2 = new TextView(context);
            textView2.setText(context.getString(C0637R.string.trae_checkpoint_run_command_title));
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
            textView2.setTextSize(2, 17.0f);
            textView2.setTypeface(CheckpointTypefaces.INSTANCE.defaultMedium());
            linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            String descriptionText = getDescriptionText(context, confirmInfo);
            if (descriptionText != null) {
                TextView textView3 = new TextView(context);
                textView3.setText(descriptionText);
                textView3.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                textView3.setTextSize(2, 15.0f);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.topMargin = (int) (12 * f);
                Unit unit = Unit.INSTANCE;
                linearLayout.addView(textView3, layoutParams2);
            }
        }
        final NestedScrollView nestedScrollView = new NestedScrollView(context);
        int i3 = (int) (12 * f);
        nestedScrollView.setPadding(i3, i3, i3, i3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
        gradientDrawable.setCornerRadius(10 * f);
        nestedScrollView.setBackground(gradientDrawable);
        nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean createContentView$lambda$11$lambda$10;
                createContentView$lambda$11$lambda$10 = RunCommandDialogCreator.createContentView$lambda$11$lambda$10(view, motionEvent);
                return createContentView$lambda$11$lambda$10;
            }
        });
        TextView textView4 = new TextView(context);
        textView4.setText(str);
        textView4.setTypeface(Typeface.MONOSPACE);
        textView4.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView4.setTextSize(2, 16.0f);
        nestedScrollView.addView(textView4, new LinearLayout.LayoutParams(-1, -2));
        final int i4 = (int) (300 * f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) (16 * f);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView((View) nestedScrollView, layoutParams3);
        nestedScrollView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RunCommandDialogCreator.createContentView$lambda$15(nestedScrollView, i4);
            }
        });
        View buildWarningView = buildWarningView(context, confirmInfo, f);
        if (buildWarningView != null) {
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams4.topMargin = (int) (8 * f);
            Unit unit3 = Unit.INSTANCE;
            linearLayout.addView(buildWarningView, layoutParams4);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean createContentView$lambda$11$lambda$10(View view, MotionEvent motionEvent) {
        ViewParent parent = view.getParent();
        if (parent == null) {
            return false;
        }
        parent.requestDisallowInterceptTouchEvent(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createContentView$lambda$15(NestedScrollView nestedScrollView, int i) {
        if (nestedScrollView.getHeight() > i) {
            ViewGroup.LayoutParams layoutParams = nestedScrollView.getLayoutParams();
            layoutParams.height = i;
            nestedScrollView.setLayoutParams(layoutParams);
        }
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getPrimaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_run);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.bytedance.trae.conversation.chat.checkpoint.ICheckpointDialogCreator
    public String getSecondaryButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C0637R.string.trae_checkpoint_deny);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String getDescriptionText(Context context, ConfirmInfo confirmInfo) {
        String blockLevel;
        if (confirmInfo == null || (blockLevel = confirmInfo.getBlockLevel()) == null) {
            return null;
        }
        switch (blockLevel.hashCode()) {
            case -1666895544:
                if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_EXECUTE_FAILURE)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_sandbox_failure);
                }
                break;
            case -1081415738:
                if (blockLevel.equals("manual")) {
                    List<String> hitRedList = confirmInfo.getHitRedList();
                    return !(hitRedList == null || hitRedList.isEmpty()) ? context.getString(C0637R.string.trae_checkpoint_warning_redlist) : context.getString(C0637R.string.trae_checkpoint_warning_manual);
                }
                break;
            case -611981471:
                if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_TO_RECOVERY)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_sandbox_recovery);
                }
                break;
            case 973218229:
                if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_NOT_BLOCK_COMMAND)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_sandbox_not_block);
                }
                break;
            case 1083422895:
                if (blockLevel.equals(BLOCK_LEVEL_REDLIST)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_redlist);
                }
                break;
            case 1333012765:
                if (blockLevel.equals(BLOCK_LEVEL_BLACKLIST)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_blacklist);
                }
                break;
            case 2057241304:
                if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_UNAVAILABLE)) {
                    return context.getString(C0637R.string.trae_checkpoint_warning_sandbox_unavailable);
                }
                break;
        }
        List<String> hitRedList2 = confirmInfo.getHitRedList();
        if (hitRedList2 == null || hitRedList2.isEmpty()) {
            return null;
        }
        return context.getString(C0637R.string.trae_checkpoint_warning_redlist);
    }

    private final View buildWarningView(Context context, ConfirmInfo confirmInfo, float density) {
        WarningConfig warningConfig;
        String buildCommandListText = buildCommandListText(context, confirmInfo);
        if (buildCommandListText == null || (warningConfig = getWarningConfig(context, confirmInfo)) == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        int i = (int) (12 * density);
        int i2 = (int) (10 * density);
        linearLayout.setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(warningConfig.getBgColor());
        gradientDrawable.setCornerRadius(8 * density);
        linearLayout.setBackground(gradientDrawable);
        TextView textView = new TextView(context);
        textView.setText(buildCommandListText);
        textView.setTextColor(warningConfig.getTextColor());
        textView.setTextSize(2, 11.0f);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setMaxLines(1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    private final String buildCommandListText(Context context, ConfirmInfo confirmInfo) {
        List<String> runningCommandList;
        if (confirmInfo == null) {
            return null;
        }
        List<String> hitBlackList = confirmInfo.getHitBlackList();
        if (hitBlackList == null || hitBlackList.isEmpty()) {
            List<String> hitRedList = confirmInfo.getHitRedList();
            if (hitRedList == null || hitRedList.isEmpty()) {
                List<String> runningCommandList2 = confirmInfo.getRunningCommandList();
                runningCommandList = !(runningCommandList2 == null || runningCommandList2.isEmpty()) ? confirmInfo.getRunningCommandList() : null;
            } else {
                runningCommandList = confirmInfo.getHitRedList();
            }
        } else {
            runningCommandList = confirmInfo.getHitBlackList();
        }
        List<String> list = runningCommandList;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return context.getString(C0637R.string.trae_checkpoint_warning_command_label, CollectionsKt.joinToString$default(runningCommandList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private final WarningConfig getWarningConfig(Context context, ConfirmInfo confirmInfo) {
        if (confirmInfo == null) {
            return null;
        }
        String blockLevel = confirmInfo.getBlockLevel();
        List<String> hitRedList = confirmInfo.getHitRedList();
        boolean z = !(hitRedList == null || hitRedList.isEmpty());
        if (blockLevel != null) {
            switch (blockLevel.hashCode()) {
                case -1666895544:
                    if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_EXECUTE_FAILURE)) {
                        return new WarningConfig(z ? 872369487 : 872066324, z ? -45745 : -2848762);
                    }
                    break;
                case -1081415738:
                    if (blockLevel.equals("manual")) {
                        return z ? new WarningConfig(872369487, -45745) : new WarningConfig(872066324, -2848762);
                    }
                    break;
                case -611981471:
                    if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_TO_RECOVERY)) {
                        return new WarningConfig(z ? 872369487 : 872066324, z ? -45745 : -2848762);
                    }
                    break;
                case 973218229:
                    if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_NOT_BLOCK_COMMAND)) {
                        return new WarningConfig(z ? 872369487 : 872066324, z ? -45745 : -2848762);
                    }
                    break;
                case 1083422895:
                    if (blockLevel.equals(BLOCK_LEVEL_REDLIST)) {
                        return new WarningConfig(872369487, -45745);
                    }
                    break;
                case 1333012765:
                    if (blockLevel.equals(BLOCK_LEVEL_BLACKLIST)) {
                        return new WarningConfig(872369487, -45745);
                    }
                    break;
                case 2057241304:
                    if (blockLevel.equals(BLOCK_LEVEL_SANDBOX_UNAVAILABLE)) {
                        return new WarningConfig(z ? 872369487 : 872066324, z ? -45745 : -2848762);
                    }
                    break;
            }
        }
        if (z) {
            return new WarningConfig(872369487, -45745);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RunCommandDialogCreator.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/creators/RunCommandDialogCreator$WarningConfig;", "", "bgColor", "", "textColor", "<init>", "(II)V", "getBgColor", "()I", "getTextColor", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class WarningConfig {
        private final int bgColor;
        private final int textColor;

        public static /* synthetic */ WarningConfig copy$default(WarningConfig warningConfig, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = warningConfig.bgColor;
            }
            if ((i3 & 2) != 0) {
                i2 = warningConfig.textColor;
            }
            return warningConfig.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBgColor() {
            return this.bgColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        public final WarningConfig copy(int bgColor, int textColor) {
            return new WarningConfig(bgColor, textColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WarningConfig)) {
                return false;
            }
            WarningConfig warningConfig = (WarningConfig) other;
            return this.bgColor == warningConfig.bgColor && this.textColor == warningConfig.textColor;
        }

        public int hashCode() {
            return (Integer.hashCode(this.bgColor) * 31) + Integer.hashCode(this.textColor);
        }

        public String toString() {
            return "WarningConfig(bgColor=" + this.bgColor + ", textColor=" + this.textColor + ')';
        }

        public WarningConfig(int i, int i2) {
            this.bgColor = i;
            this.textColor = i2;
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final int getTextColor() {
            return this.textColor;
        }
    }
}
