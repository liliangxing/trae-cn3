package com.bytedance.trae.conversation.chat.block.renderer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: VoiceSummaryMarkdownNormalizer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;", "", "<init>", "()V", "taskListItemRegex", "Lkotlin/text/Regex;", "fencedCodeBlockRegex", "taskListAsBulletList", "", "markdown", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSummaryMarkdownNormalizer {
    public static final VoiceSummaryMarkdownNormalizer INSTANCE = new VoiceSummaryMarkdownNormalizer();
    private static final Regex taskListItemRegex = new Regex("^(\\s*)([-*+])\\s+\\[[ xX]\\]\\s+(.*)$");
    private static final Regex fencedCodeBlockRegex = new Regex("^\\s*(`{3,}|~{3,}).*$");

    private VoiceSummaryMarkdownNormalizer() {
    }

    public final String taskListAsBulletList(String markdown) {
        Intrinsics.checkNotNullParameter(markdown, "markdown");
        String str = markdown;
        if (str.length() == 0) {
            return markdown;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.IntRef intRef = new Ref.IntRef();
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(str), new Function1() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String taskListAsBulletList$lambda$1;
                taskListAsBulletList$lambda$1 = VoiceSummaryMarkdownNormalizer.taskListAsBulletList$lambda$1(objectRef, intRef, (String) obj);
                return taskListAsBulletList$lambda$1;
            }
        }), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String taskListAsBulletList$lambda$1(Ref.ObjectRef objectRef, Ref.IntRef intRef, String str) {
        Intrinsics.checkNotNullParameter(str, "line");
        String str2 = str;
        MatchResult matchEntire = fencedCodeBlockRegex.matchEntire(str2);
        if (matchEntire == null) {
            return objectRef.element != null ? str : taskListItemRegex.replace(str2, new Function1() { // from class: com.bytedance.trae.conversation.chat.block.renderer.VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    CharSequence taskListAsBulletList$lambda$1$lambda$0;
                    taskListAsBulletList$lambda$1$lambda$0 = VoiceSummaryMarkdownNormalizer.taskListAsBulletList$lambda$1$lambda$0((MatchResult) obj);
                    return taskListAsBulletList$lambda$1$lambda$0;
                }
            });
        }
        String str3 = (String) matchEntire.getGroupValues().get(1);
        char first = StringsKt.first(str3);
        if (objectRef.element == null) {
            objectRef.element = Character.valueOf(first);
            intRef.element = str3.length();
            return str;
        }
        Character ch = (Character) objectRef.element;
        if (ch == null || ch.charValue() != first || str3.length() < intRef.element) {
            return str;
        }
        objectRef.element = null;
        intRef.element = 0;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence taskListAsBulletList$lambda$1$lambda$0(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "match");
        return ((String) matchResult.getGroupValues().get(1)) + ((String) matchResult.getGroupValues().get(2)) + ' ' + ((String) matchResult.getGroupValues().get(3));
    }
}
