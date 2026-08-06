package com.bytedance.trae.conversation.devices.newfeature;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.tracker.DeviceEventGate;
import com.bytedance.trae.conversation.tracker.DeviceGuideAction;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptBottomSheet.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020(2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018¨\u0006-"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;", "Lcom/bytedance/trae/conversation/devices/newfeature/HeroPromptBottomSheet;", "<init>", "()V", "onConfirm", "Lkotlin/Function0;", "", "getOnConfirm", "()Lkotlin/jvm/functions/Function0;", "setOnConfirm", "(Lkotlin/jvm/functions/Function0;)V", "onDismissListener", "getOnDismissListener", "setOnDismissListener", "guideShowEventGate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "guideClickEventGate", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "getProductType", "()Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "hasRegisteredWork", "", "getHasRegisteredWork", "()Z", "hasRegisteredIDE", "getHasRegisteredIDE", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onSaveInstanceState", "outState", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "titleRes", "", "messageRes", "imageRes", "connectButtonRes", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewFeaturePromptBottomSheet extends HeroPromptBottomSheet {
    private static final String ARG_HAS_REGISTERED_IDE = "arg_has_registered_ide";
    private static final String ARG_HAS_REGISTERED_WORK = "arg_has_registered_work";
    private static final String ARG_PRODUCT_TYPE = "arg_product_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String STATE_GUIDE_CLICK_REPORTED = "state_guide_click_reported";
    private static final String STATE_GUIDE_SHOW_REPORTED = "state_guide_show_reported";
    public static final String TAG = "NewFeaturePromptBottomSheet";
    private Function0<Unit> onConfirm;
    private Function0<Unit> onDismissListener;
    private DeviceEventGate guideShowEventGate = new DeviceEventGate(false, 1, null);
    private DeviceEventGate guideClickEventGate = new DeviceEventGate(false, 1, null);

    /* compiled from: NewFeaturePromptBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceProductType.values().length];
            try {
                iArr[DeviceProductType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceProductType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Function0<Unit> getOnConfirm() {
        return this.onConfirm;
    }

    public final void setOnConfirm(Function0<Unit> function0) {
        this.onConfirm = function0;
    }

    public final Function0<Unit> getOnDismissListener() {
        return this.onDismissListener;
    }

    public final void setOnDismissListener(Function0<Unit> function0) {
        this.onDismissListener = function0;
    }

    private final DeviceProductType getProductType() {
        String string;
        Object obj;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_PRODUCT_TYPE)) == null) {
            return DeviceProductType.WORK;
        }
        try {
            Result.Companion companion = Result.Companion;
            NewFeaturePromptBottomSheet newFeaturePromptBottomSheet = this;
            obj = Result.constructor-impl(DeviceProductType.valueOf(string));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        DeviceProductType deviceProductType = DeviceProductType.WORK;
        if (Result.isFailure-impl(obj)) {
            obj = deviceProductType;
        }
        return (DeviceProductType) obj;
    }

    private final boolean getHasRegisteredWork() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean(ARG_HAS_REGISTERED_WORK);
    }

    private final boolean getHasRegisteredIDE() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getBoolean(ARG_HAS_REGISTERED_IDE);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.guideShowEventGate = new DeviceEventGate(savedInstanceState != null && savedInstanceState.getBoolean(STATE_GUIDE_SHOW_REPORTED));
        this.guideClickEventGate = new DeviceEventGate(savedInstanceState != null && savedInstanceState.getBoolean(STATE_GUIDE_CLICK_REPORTED));
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int imageRes = imageRes(getProductType());
        String string = getString(titleRes(getProductType()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        String string2 = getString(messageRes(getProductType()));
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String str2 = string2;
        String string3 = getString(connectButtonRes(getProductType()));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        bindHeroPrompt(view, imageRes, str, str2, string3, new Function0() { // from class: com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onViewCreated$lambda$1;
                onViewCreated$lambda$1 = NewFeaturePromptBottomSheet.onViewCreated$lambda$1(NewFeaturePromptBottomSheet.this);
                return onViewCreated$lambda$1;
            }
        }, new Function0() { // from class: com.bytedance.trae.conversation.devices.newfeature.NewFeaturePromptBottomSheet$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = NewFeaturePromptBottomSheet.onViewCreated$lambda$2(NewFeaturePromptBottomSheet.this);
                return onViewCreated$lambda$2;
            }
        });
        if (this.guideShowEventGate.tryConsume()) {
            DeviceTracker.INSTANCE.trackGuideShow(getProductType(), getHasRegisteredWork(), getHasRegisteredIDE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(NewFeaturePromptBottomSheet newFeaturePromptBottomSheet) {
        if (newFeaturePromptBottomSheet.guideClickEventGate.tryConsume()) {
            DeviceTracker.INSTANCE.trackGuideClick$conversation_mainlandRelease(newFeaturePromptBottomSheet.getProductType(), DeviceGuideAction.CLOSE);
            DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) newFeaturePromptBottomSheet);
            if (deviceFlowNavigator != null) {
                deviceFlowNavigator.closeCurrentFlow();
            } else {
                newFeaturePromptBottomSheet.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(NewFeaturePromptBottomSheet newFeaturePromptBottomSheet) {
        if (newFeaturePromptBottomSheet.guideClickEventGate.tryConsume()) {
            DeviceTracker.INSTANCE.trackGuideClick$conversation_mainlandRelease(newFeaturePromptBottomSheet.getProductType(), DeviceGuideAction.GET_STARTED);
            DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) newFeaturePromptBottomSheet);
            Function0<Unit> function0 = newFeaturePromptBottomSheet.onConfirm;
            if (function0 != null) {
                function0.invoke();
            }
            if (deviceFlowNavigator == null) {
                newFeaturePromptBottomSheet.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putBoolean(STATE_GUIDE_SHOW_REPORTED, this.guideShowEventGate.getIsConsumed());
        outState.putBoolean(STATE_GUIDE_CLICK_REPORTED, this.guideClickEventGate.getIsConsumed());
        super.onSaveInstanceState(outState);
    }

    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (activity != null && activity.isChangingConfigurations()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.guideShowEventGate.reset();
        this.guideClickEventGate.reset();
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final int titleRes(DeviceProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return C0637R.string.trae_new_feature_prompt_work_title;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return C0637R.string.trae_new_feature_prompt_ide_title;
    }

    private final int messageRes(DeviceProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return C0637R.string.trae_new_feature_prompt_work_message;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return C0637R.string.trae_new_feature_prompt_ide_message;
    }

    private final int imageRes(DeviceProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return C0637R.drawable.trae_img_new_feature_prompt_work_hero_2026q3;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return C0637R.drawable.trae_img_new_feature_prompt_ide_hero_2026q3;
    }

    private final int connectButtonRes(DeviceProductType productType) {
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return C0637R.string.trae_new_feature_prompt_work_connect;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return C0637R.string.trae_new_feature_prompt_ide_connect;
    }

    /* compiled from: NewFeaturePromptBottomSheet.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PRODUCT_TYPE", "ARG_HAS_REGISTERED_WORK", "ARG_HAS_REGISTERED_IDE", "STATE_GUIDE_SHOW_REPORTED", "STATE_GUIDE_CLICK_REPORTED", "newInstance", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptBottomSheet;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "hasRegisteredWork", "", "hasRegisteredIDE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NewFeaturePromptBottomSheet newInstance(DeviceProductType productType, boolean hasRegisteredWork, boolean hasRegisteredIDE) {
            Intrinsics.checkNotNullParameter(productType, "productType");
            NewFeaturePromptBottomSheet newFeaturePromptBottomSheet = new NewFeaturePromptBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(NewFeaturePromptBottomSheet.ARG_PRODUCT_TYPE, productType.name());
            bundle.putBoolean(NewFeaturePromptBottomSheet.ARG_HAS_REGISTERED_WORK, hasRegisteredWork);
            bundle.putBoolean(NewFeaturePromptBottomSheet.ARG_HAS_REGISTERED_IDE, hasRegisteredIDE);
            newFeaturePromptBottomSheet.setArguments(bundle);
            return newFeaturePromptBottomSheet;
        }
    }
}
