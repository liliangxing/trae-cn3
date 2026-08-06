package com.bytedance.trae.conversation.chat.checkpoint;

import android.content.Context;
import android.view.View;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICheckpointDialogCreator.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J,\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0 H\u0016JB\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\u0014\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u001d0#H\u0016J\u001e\u0010$\u001a\u00020\u001d2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d\u0018\u00010#H\u0016J\u0012\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/ICheckpointDialogCreator;", "", "CHECK_POINT_TAG", "", "getCHECK_POINT_TAG", "()Ljava/lang/String;", "createContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "getTitle", "getPrimaryButtonText", "getSecondaryButtonText", "getPrimaryButtonBackgroundRes", "", "hideDefaultButtons", "", "showCloseButton", "getTitleTextColorRes", "getTitleLetterSpacing", "", "getHeaderLabel", "getContentTopMarginDp", "getContentTopMarginRes", "bindActions", "", "contentView", "onConfirm", "Lkotlin/Function0;", "onSkip", "onConfirmWithParams", "Lkotlin/Function1;", "setFileClickListener", "listener", "setResolvedDisplayName", "name", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ICheckpointDialogCreator {
    void bindActions(View contentView, Function0<Unit> onConfirm, Function0<Unit> onSkip);

    void bindActions(View contentView, Function0<Unit> onConfirm, Function0<Unit> onSkip, Function1<? super String, Unit> onConfirmWithParams);

    View createContentView(Context context, ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo);

    String getCHECK_POINT_TAG();

    int getContentTopMarginDp();

    int getContentTopMarginRes();

    String getHeaderLabel(Context context);

    int getPrimaryButtonBackgroundRes();

    String getPrimaryButtonText(Context context);

    String getSecondaryButtonText(Context context);

    String getTitle(Context context, ParsedToolCallInfo toolCallInfo);

    float getTitleLetterSpacing();

    int getTitleTextColorRes();

    boolean hideDefaultButtons();

    void setFileClickListener(Function1<? super String, Unit> listener);

    void setResolvedDisplayName(String name);

    boolean showCloseButton();

    /* compiled from: ICheckpointDialogCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static void bindActions(ICheckpointDialogCreator iCheckpointDialogCreator, View view, Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(view, "contentView");
            Intrinsics.checkNotNullParameter(function0, "onConfirm");
            Intrinsics.checkNotNullParameter(function02, "onSkip");
        }

        public static String getCHECK_POINT_TAG(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return "CheckPointDialog";
        }

        public static int getContentTopMarginDp(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return 16;
        }

        public static int getContentTopMarginRes(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return 0;
        }

        public static String getHeaderLabel(ICheckpointDialogCreator iCheckpointDialogCreator, Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        public static int getPrimaryButtonBackgroundRes(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return 0;
        }

        public static float getTitleLetterSpacing(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return 0.0f;
        }

        public static int getTitleTextColorRes(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return 0;
        }

        public static boolean hideDefaultButtons(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return false;
        }

        public static void setFileClickListener(ICheckpointDialogCreator iCheckpointDialogCreator, Function1<? super String, Unit> function1) {
        }

        public static void setResolvedDisplayName(ICheckpointDialogCreator iCheckpointDialogCreator, String str) {
        }

        public static boolean showCloseButton(ICheckpointDialogCreator iCheckpointDialogCreator) {
            return false;
        }

        public static /* synthetic */ View createContentView$default(ICheckpointDialogCreator iCheckpointDialogCreator, Context context, ParsedToolCallInfo parsedToolCallInfo, ConfirmInfo confirmInfo, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createContentView");
            }
            if ((i & 4) != 0) {
                confirmInfo = null;
            }
            return iCheckpointDialogCreator.createContentView(context, parsedToolCallInfo, confirmInfo);
        }

        public static void bindActions(ICheckpointDialogCreator iCheckpointDialogCreator, View view, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function1) {
            Intrinsics.checkNotNullParameter(view, "contentView");
            Intrinsics.checkNotNullParameter(function0, "onConfirm");
            Intrinsics.checkNotNullParameter(function02, "onSkip");
            Intrinsics.checkNotNullParameter(function1, "onConfirmWithParams");
            iCheckpointDialogCreator.bindActions(view, function0, function02);
        }
    }
}
