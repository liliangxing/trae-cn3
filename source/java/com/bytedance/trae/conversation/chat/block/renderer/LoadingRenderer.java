package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingRenderer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Loading;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LoadingRenderer implements IBlockRenderer<AgentContentBlock.Loading> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    /* compiled from: LoadingRenderer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentContentBlock.TailStatus.values().length];
            try {
                iArr[AgentContentBlock.TailStatus.THINKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentContentBlock.TailStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentContentBlock.TailStatus.GENERATING_CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentContentBlock.TailStatus.COMMAND_RUNNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentContentBlock.TailStatus.SUCCESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentContentBlock.TailStatus.FAILED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: LoadingRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/LoadingRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Loading block) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[LoadingRenderer] render");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = (int) (4 * f);
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        linearLayout.setLayoutParams(layoutParams);
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        int i2 = (int) (16 * f);
        linearLayout.addView(progressBar, new LinearLayout.LayoutParams(i2, i2));
        switch (WhenMappings.$EnumSwitchMapping$0[block.getTailStatus().ordinal()]) {
            case 1:
                string = context.getString(C0637R.string.trae_chat_status_thinking);
                break;
            case 2:
                string = context.getString(C0637R.string.trae_chat_status_pending);
                break;
            case 3:
                string = context.getString(C0637R.string.trae_chat_status_generating_code);
                break;
            case 4:
                string = context.getString(C0637R.string.trae_chat_status_command_running);
                break;
            case 5:
                string = context.getString(C0637R.string.trae_chat_status_done);
                break;
            case 6:
                string = context.getString(C0637R.string.trae_chat_status_failed);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(string);
        TextView textView = new TextView(context);
        textView.setText(string);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart((int) (8 * f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Loading block) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(1);
        TextView textView = childAt instanceof TextView ? (TextView) childAt : null;
        if (textView == null) {
            return;
        }
        Context context = ((LinearLayout) view).getContext();
        switch (WhenMappings.$EnumSwitchMapping$0[block.getTailStatus().ordinal()]) {
            case 1:
                string = context.getString(C0637R.string.trae_chat_status_thinking);
                break;
            case 2:
                string = context.getString(C0637R.string.trae_chat_status_pending);
                break;
            case 3:
                string = context.getString(C0637R.string.trae_chat_status_generating_code);
                break;
            case 4:
                string = context.getString(C0637R.string.trae_chat_status_command_running);
                break;
            case 5:
                string = context.getString(C0637R.string.trae_chat_status_done);
                break;
            case 6:
                string = context.getString(C0637R.string.trae_chat_status_failed);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        textView.setText(string);
    }
}
