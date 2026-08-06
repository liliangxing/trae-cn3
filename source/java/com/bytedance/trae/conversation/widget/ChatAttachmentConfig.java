package com.bytedance.trae.conversation.widget;

import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.PluginCapability;
import com.bytedance.trae.conversation.widget.ChatAttachmentDialog;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatAttachmentConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/widget/ChatAttachmentConfig;", "", "<init>", "()V", "entries", "", "Lcom/bytedance/trae/conversation/widget/AttachmentEntry;", "getEntries", "()Ljava/util/List;", "rowLayout", "", "count", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatAttachmentConfig {
    public static final ChatAttachmentConfig INSTANCE = new ChatAttachmentConfig();
    private static final List<AttachmentEntry> entries = CollectionsKt.listOf(new AttachmentEntry[]{new AttachmentEntry(ChatAttachmentDialog.AttachmentType.CAMERA, C0637R.id.btn_camera, C0637R.drawable.ic_chat_attachment_camera, R.string.trae_attachment_camera, new Function4() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentConfig$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            boolean entries$lambda$0;
            entries$lambda$0 = ChatAttachmentConfig.entries$lambda$0((ChatMode) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4);
            return Boolean.valueOf(entries$lambda$0);
        }
    }), new AttachmentEntry(ChatAttachmentDialog.AttachmentType.PHOTO, C0637R.id.btn_photo, C0637R.drawable.ic_chat_attachment_photo, R.string.trae_attachment_photo, new Function4() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentConfig$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            boolean entries$lambda$1;
            entries$lambda$1 = ChatAttachmentConfig.entries$lambda$1((ChatMode) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4);
            return Boolean.valueOf(entries$lambda$1);
        }
    }), new AttachmentEntry(ChatAttachmentDialog.AttachmentType.FILES, C0637R.id.btn_files, C0637R.drawable.ic_chat_attachment_files, R.string.trae_attachment_files, new Function4() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentConfig$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            boolean entries$lambda$2;
            entries$lambda$2 = ChatAttachmentConfig.entries$lambda$2((ChatMode) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4);
            return Boolean.valueOf(entries$lambda$2);
        }
    }), new AttachmentEntry(ChatAttachmentDialog.AttachmentType.PLUGINS, C0637R.id.btn_plugins, C0637R.drawable.ic_chat_attachment_plugins, R.string.trae_attachment_plugins, new Function4() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentConfig$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            boolean entries$lambda$3;
            entries$lambda$3 = ChatAttachmentConfig.entries$lambda$3((ChatMode) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4);
            return Boolean.valueOf(entries$lambda$3);
        }
    }), new AttachmentEntry(ChatAttachmentDialog.AttachmentType.SKILLS, C0637R.id.btn_skills, C0637R.drawable.ic_chat_attachment_skills, R.string.trae_attachment_skills, new Function4() { // from class: com.bytedance.trae.conversation.widget.ChatAttachmentConfig$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            boolean entries$lambda$4;
            entries$lambda$4 = ChatAttachmentConfig.entries$lambda$4((ChatMode) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4);
            return Boolean.valueOf(entries$lambda$4);
        }
    })});

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entries$lambda$0(ChatMode chatMode, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(chatMode, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entries$lambda$1(ChatMode chatMode, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(chatMode, "<unused var>");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entries$lambda$4(ChatMode chatMode, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(chatMode, "<unused var>");
        return true;
    }

    private ChatAttachmentConfig() {
    }

    public final List<AttachmentEntry> getEntries() {
        return entries;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entries$lambda$2(ChatMode chatMode, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(chatMode, "mode");
        return chatMode == ChatMode.MTC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean entries$lambda$3(ChatMode chatMode, boolean z, boolean z2, String str) {
        Intrinsics.checkNotNullParameter(chatMode, "<unused var>");
        return !z2 && FeatureCapability.INSTANCE.isEnabled(Feature.PLUGIN) && PluginCapability.INSTANCE.isSupported(z, str);
    }

    public final List<Integer> rowLayout(int count) {
        if (count == 0) {
            return CollectionsKt.emptyList();
        }
        if (count == 1) {
            return CollectionsKt.listOf(1);
        }
        if (count == 2) {
            return CollectionsKt.listOf(2);
        }
        if (count != 3) {
            return count != 4 ? count != 5 ? CollectionsKt.plus(CollectionsKt.listOf(3), rowLayout(count - 3)) : CollectionsKt.listOf(new Integer[]{3, 2}) : CollectionsKt.listOf(new Integer[]{2, 2});
        }
        return CollectionsKt.listOf(3);
    }
}
