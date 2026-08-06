package com.bytedance.trae.conversation.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.bytedance.trae.im.model.MessagePart;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatAttachmentDialog.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001dH\u0002J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0006H\u0002J\u000e\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onAttachmentSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;", "", "getOnAttachmentSelected", "()Lkotlin/jvm/functions/Function1;", "setOnAttachmentSelected", "(Lkotlin/jvm/functions/Function1;)V", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "getChatMode", "()Lcom/bytedance/trae/conversation/widget/ChatMode;", "isLocal", "", "()Z", "isIde", "ideVersion", "", "getIdeVersion", "()Ljava/lang/String;", "showSkills", "getShowSkills", "useVoiceCompactLayout", "getUseVoiceCompactLayout", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupDynamicLayout", "setupVoiceLayout", "trackAttachment", DBData.FIELD_TYPE, "showOnce", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "AttachmentType", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatAttachmentDialog extends BottomSheetDialogFragment {
    private static final String ARG_CHAT_MODE = "chat_mode";
    private static final String ARG_IDE_VERSION = "ide_version";
    private static final String ARG_IS_IDE = "is_ide";
    private static final String ARG_IS_LOCAL = "is_local";
    private static final String ARG_SHOW_SKILLS = "show_skills";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ChatAttachmentDialog";
    private Function1<? super AttachmentType, Unit> onAttachmentSelected;

    /* compiled from: ChatAttachmentDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AttachmentType.values().length];
            try {
                iArr[AttachmentType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttachmentType.PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttachmentType.FILES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AttachmentType.PLUGINS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AttachmentType.SKILLS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ChatAttachmentDialog.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", "PHOTO", "FILES", "SKILLS", "PLUGINS", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AttachmentType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AttachmentType[] $VALUES;
        public static final AttachmentType CAMERA = new AttachmentType("CAMERA", 0);
        public static final AttachmentType PHOTO = new AttachmentType("PHOTO", 1);
        public static final AttachmentType FILES = new AttachmentType("FILES", 2);
        public static final AttachmentType SKILLS = new AttachmentType("SKILLS", 3);
        public static final AttachmentType PLUGINS = new AttachmentType("PLUGINS", 4);

        private static final /* synthetic */ AttachmentType[] $values() {
            return new AttachmentType[]{CAMERA, PHOTO, FILES, SKILLS, PLUGINS};
        }

        public static EnumEntries<AttachmentType> getEntries() {
            return $ENTRIES;
        }

        private AttachmentType(String str, int i) {
        }

        static {
            AttachmentType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static AttachmentType valueOf(String str) {
            return (AttachmentType) Enum.valueOf(AttachmentType.class, str);
        }

        public static AttachmentType[] values() {
            return (AttachmentType[]) $VALUES.clone();
        }
    }

    public final Function1<AttachmentType, Unit> getOnAttachmentSelected() {
        return this.onAttachmentSelected;
    }

    public final void setOnAttachmentSelected(Function1<? super AttachmentType, Unit> function1) {
        this.onAttachmentSelected = function1;
    }

    private final ChatMode getChatMode() {
        String string;
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(ARG_CHAT_MODE)) != null) {
            try {
                Result.Companion companion = Result.Companion;
                ChatAttachmentDialog chatAttachmentDialog = this;
                obj = Result.constructor-impl(ChatMode.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            ChatMode chatMode = (ChatMode) obj;
            if (chatMode != null) {
                return chatMode;
            }
        }
        return ChatMode.MTC;
    }

    private final boolean isLocal() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_IS_LOCAL, false);
        }
        return false;
    }

    private final boolean isIde() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_IS_IDE, false);
        }
        return false;
    }

    private final String getIdeVersion() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString(ARG_IDE_VERSION);
        }
        return null;
    }

    private final boolean getShowSkills() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_SHOW_SKILLS, true);
        }
        return true;
    }

    private final boolean getUseVoiceCompactLayout() {
        return !getShowSkills();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (getUseVoiceCompactLayout()) {
            i = C0637R.layout.dialog_chat_attachment_voice;
        } else {
            i = C0637R.layout.dialog_chat_attachment;
        }
        return inflater.inflate(i, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getUseVoiceCompactLayout()) {
            setupVoiceLayout(view);
        } else {
            setupDynamicLayout(view);
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ChatAttachmentDialog.onViewCreated$lambda$4(dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(DialogInterface dialogInterface) {
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final View findViewById = ((BottomSheetDialog) dialogInterface).findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            final BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            from.setHideable(true);
            findViewById.post(new Runnable() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ChatAttachmentDialog.onViewCreated$lambda$4$lambda$3$lambda$2(from, findViewById);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3$lambda$2(BottomSheetBehavior bottomSheetBehavior, View view) {
        bottomSheetBehavior.setPeekHeight(view.getMeasuredHeight());
        bottomSheetBehavior.setState(3);
    }

    private final void setupDynamicLayout(View view) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C0637R.id.container);
        LayoutInflater from = LayoutInflater.from(requireContext());
        List<AttachmentEntry> entries = ChatAttachmentConfig.INSTANCE.getEntries();
        ArrayList arrayList = new ArrayList();
        for (Object obj : entries) {
            if (((Boolean) ((AttachmentEntry) obj).isVisible().invoke(getChatMode(), Boolean.valueOf(isLocal()), Boolean.valueOf(isIde()), getIdeVersion())).booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        List<Integer> rowLayout = ChatAttachmentConfig.INSTANCE.rowLayout(arrayList2.size());
        int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_12);
        int i = 0;
        int i2 = 0;
        for (Object obj2 : rowLayout) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = ((Number) obj2).intValue();
            if (i > 0) {
                View view2 = new View(requireContext());
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, dimensionPixelSize));
                linearLayout.addView(view2);
            }
            LinearLayout linearLayout2 = new LinearLayout(requireContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            int i4 = 0;
            while (i4 < intValue) {
                if (i4 > 0) {
                    View view3 = new View(requireContext());
                    view3.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, -1));
                    linearLayout2.addView(view3);
                }
                int i5 = i2 + 1;
                final AttachmentEntry attachmentEntry = (AttachmentEntry) arrayList2.get(i2);
                View inflate = from.inflate(C0637R.layout.item_chat_attachment_entry, (ViewGroup) linearLayout2, false);
                inflate.setId(attachmentEntry.getViewIdRes());
                ((ImageView) inflate.findViewById(C0637R.id.iv_icon)).setImageResource(attachmentEntry.getIconRes());
                ((TextView) inflate.findViewById(C0637R.id.tv_label)).setText(attachmentEntry.getLabelRes());
                inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        ChatAttachmentDialog.setupDynamicLayout$lambda$10$lambda$9(ChatAttachmentDialog.this, attachmentEntry, view4);
                    }
                });
                linearLayout2.addView(inflate);
                i4++;
                i2 = i5;
            }
            linearLayout.addView(linearLayout2);
            i = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDynamicLayout$lambda$10$lambda$9(ChatAttachmentDialog chatAttachmentDialog, AttachmentEntry attachmentEntry, View view) {
        chatAttachmentDialog.trackAttachment(attachmentEntry.getType());
        Function1<? super AttachmentType, Unit> function1 = chatAttachmentDialog.onAttachmentSelected;
        if (function1 != null) {
            function1.invoke(attachmentEntry.getType());
        }
        chatAttachmentDialog.dismiss();
    }

    private final void setupVoiceLayout(View view) {
        if (getChatMode() == ChatMode.CODE) {
            View findViewById = view.findViewById(C0637R.id.btn_files);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = view.findViewById(C0637R.id.spacer_photo_files);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
        }
        View findViewById3 = view.findViewById(C0637R.id.btn_close);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatAttachmentDialog.this.dismiss();
                }
            });
        }
        View findViewById4 = view.findViewById(C0637R.id.btn_camera);
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatAttachmentDialog.setupVoiceLayout$lambda$12(ChatAttachmentDialog.this, view2);
                }
            });
        }
        View findViewById5 = view.findViewById(C0637R.id.btn_photo);
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatAttachmentDialog.setupVoiceLayout$lambda$13(ChatAttachmentDialog.this, view2);
                }
            });
        }
        View findViewById6 = view.findViewById(C0637R.id.btn_files);
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChatAttachmentDialog.setupVoiceLayout$lambda$14(ChatAttachmentDialog.this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupVoiceLayout$lambda$12(ChatAttachmentDialog chatAttachmentDialog, View view) {
        chatAttachmentDialog.trackAttachment(AttachmentType.CAMERA);
        Function1<? super AttachmentType, Unit> function1 = chatAttachmentDialog.onAttachmentSelected;
        if (function1 != null) {
            function1.invoke(AttachmentType.CAMERA);
        }
        chatAttachmentDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupVoiceLayout$lambda$13(ChatAttachmentDialog chatAttachmentDialog, View view) {
        chatAttachmentDialog.trackAttachment(AttachmentType.PHOTO);
        Function1<? super AttachmentType, Unit> function1 = chatAttachmentDialog.onAttachmentSelected;
        if (function1 != null) {
            function1.invoke(AttachmentType.PHOTO);
        }
        chatAttachmentDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupVoiceLayout$lambda$14(ChatAttachmentDialog chatAttachmentDialog, View view) {
        chatAttachmentDialog.trackAttachment(AttachmentType.FILES);
        Function1<? super AttachmentType, Unit> function1 = chatAttachmentDialog.onAttachmentSelected;
        if (function1 != null) {
            function1.invoke(AttachmentType.FILES);
        }
        chatAttachmentDialog.dismiss();
    }

    private final void trackAttachment(AttachmentType type) {
        String str;
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            str = "camera";
        } else if (i == 2) {
            str = "image";
        } else if (i == 3) {
            str = MessagePart.TYPE_FILE;
        } else if (i == 4) {
            str = "plugin";
        } else {
            if (i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "skill";
        }
        InputTracker.INSTANCE.trackAttachmentClick(str);
    }

    public final boolean showOnce(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (fragmentManager.isStateSaved() || fragmentManager.findFragmentByTag(TAG) != null) {
            return false;
        }
        showNow(fragmentManager, TAG);
        return true;
    }

    /* compiled from: ChatAttachmentDialog.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$Companion;", "", "<init>", "()V", "TAG", "", "ARG_CHAT_MODE", "ARG_IS_LOCAL", "ARG_IS_IDE", "ARG_IDE_VERSION", "ARG_SHOW_SKILLS", "newInstance", "Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog;", "chatMode", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "isLocal", "", "isIde", "ideVersion", "showSkills", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ChatAttachmentDialog newInstance$default(Companion companion, ChatMode chatMode, boolean z, boolean z2, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                str = null;
            }
            return companion.newInstance(chatMode, z, z2, str);
        }

        public final ChatAttachmentDialog newInstance(ChatMode chatMode, boolean isLocal, boolean isIde, String ideVersion) {
            Intrinsics.checkNotNullParameter(chatMode, "chatMode");
            ChatAttachmentDialog chatAttachmentDialog = new ChatAttachmentDialog();
            Bundle bundle = new Bundle();
            bundle.putString(ChatAttachmentDialog.ARG_CHAT_MODE, chatMode.name());
            bundle.putBoolean(ChatAttachmentDialog.ARG_IS_LOCAL, isLocal);
            bundle.putBoolean(ChatAttachmentDialog.ARG_IS_IDE, isIde);
            bundle.putString(ChatAttachmentDialog.ARG_IDE_VERSION, ideVersion);
            chatAttachmentDialog.setArguments(bundle);
            return chatAttachmentDialog;
        }

        public final ChatAttachmentDialog newInstance(ChatMode chatMode, boolean showSkills) {
            Intrinsics.checkNotNullParameter(chatMode, "chatMode");
            ChatAttachmentDialog chatAttachmentDialog = new ChatAttachmentDialog();
            Bundle bundle = new Bundle();
            bundle.putString(ChatAttachmentDialog.ARG_CHAT_MODE, chatMode.name());
            bundle.putBoolean(ChatAttachmentDialog.ARG_SHOW_SKILLS, showSkills);
            chatAttachmentDialog.setArguments(bundle);
            return chatAttachmentDialog;
        }
    }
}
