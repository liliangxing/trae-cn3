package com.larus.business.markdown.impl.markwon;

import com.larus.business.markdown.impl.markwon.EmojiReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: EmojiReader.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\tJ\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0006\u001a\u00020\u0007J!\u0010\u0014\u001a\u00020\u0015*\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150\u0017H\u0082\b¨\u0006\u001b"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/EmojiReader;", "", "()V", "analyzeText", "", "Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;", "str", "", "getTextLength", "", "isEmojiOfCharIndex", "", "idx", "nodeList", "isEmojiOfVisionIndex", "subSequence", "end", "start", "transToUnicode", "", "forEachCodePoint", "", "action", "Lkotlin/Function1;", "InnerNode", "Node", "StateMachine", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class EmojiReader {
    public static final EmojiReader INSTANCE = new EmojiReader();

    private EmojiReader() {
    }

    public final int getTextLength(CharSequence str) {
        Intrinsics.checkNotNullParameter(str, "str");
        StateMachine stateMachine = new StateMachine();
        StateMachine.read$default(stateMachine, str, 0, 2, null);
        return stateMachine.getCurrentCharSize();
    }

    public final List<Node> analyzeText(CharSequence str) {
        Intrinsics.checkNotNullParameter(str, "str");
        StateMachine stateMachine = new StateMachine();
        StateMachine.read$default(stateMachine, str, 0, 2, null);
        List<InnerNode> charList = stateMachine.getCharList();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(charList, 10));
        for (InnerNode innerNode : charList) {
            Iterator<T> it = innerNode.getCodePoint().iterator();
            int i = 0;
            while (it.hasNext()) {
                i += Character.charCount(((Number) it.next()).intValue());
            }
            arrayList.add(new Node(innerNode.getStartIndex(), i, innerNode.isEmoji(), CollectionsKt.toList(innerNode.getCodePoint())));
        }
        return arrayList;
    }

    public final boolean isEmojiOfVisionIndex(CharSequence str, int idx) {
        Intrinsics.checkNotNullParameter(str, "str");
        return isEmojiOfVisionIndex(analyzeText(str), idx);
    }

    public final boolean isEmojiOfVisionIndex(List<Node> nodeList, int idx) {
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        return nodeList.get(idx).isEmoji();
    }

    public final boolean isEmojiOfCharIndex(CharSequence str, int idx) {
        Intrinsics.checkNotNullParameter(str, "str");
        return isEmojiOfCharIndex(analyzeText(str), idx);
    }

    public final boolean isEmojiOfCharIndex(List<Node> nodeList, final int idx) {
        Intrinsics.checkNotNullParameter(nodeList, "nodeList");
        int binarySearch$default = CollectionsKt.binarySearch$default(nodeList, 0, 0, new Function1<Node, Integer>() { // from class: com.larus.business.markdown.impl.markwon.EmojiReader$isEmojiOfCharIndex$visionIdx$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Integer invoke(EmojiReader.Node node) {
                int i;
                Intrinsics.checkNotNullParameter(node, "node");
                if (idx < node.getStartIndex()) {
                    i = 1;
                } else {
                    i = idx >= node.getStartIndex() + node.getLength() ? -1 : 0;
                }
                return Integer.valueOf(i);
            }
        }, 3, (Object) null);
        if (binarySearch$default < 0) {
            return false;
        }
        return isEmojiOfVisionIndex(nodeList, binarySearch$default);
    }

    public final CharSequence subSequence(CharSequence str, int end) {
        Intrinsics.checkNotNullParameter(str, "str");
        return subSequence(str, 0, end);
    }

    public final CharSequence subSequence(CharSequence str, int start, int end) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, "str");
        if (start < 0 || end > str.length()) {
            throw new IndexOutOfBoundsException("The index should be in range [0," + str.length() + "],but actually start = " + start + " and end = " + end + '.');
        }
        if (start > end) {
            throw new IndexOutOfBoundsException("The start index should be not bigger than end,but actually start = " + start + " and end = " + end + '.');
        }
        if (start == end) {
            return "";
        }
        StateMachine stateMachine = new StateMachine();
        stateMachine.read(str, start + end);
        List<InnerNode> charList = stateMachine.getCharList();
        InnerNode innerNode = (InnerNode) CollectionsKt.getOrNull(charList, start);
        if (innerNode == null) {
            return "";
        }
        int startIndex = innerNode.getStartIndex();
        InnerNode innerNode2 = (InnerNode) CollectionsKt.getOrNull(charList, end - 1);
        if (innerNode2 != null) {
            int startIndex2 = innerNode2.getStartIndex();
            Iterator<T> it = innerNode2.getCodePoint().iterator();
            int i = 0;
            while (it.hasNext()) {
                i += Character.charCount(((Number) it.next()).intValue());
            }
            num = Integer.valueOf(startIndex2 + i);
        } else {
            num = null;
        }
        if (num == null) {
            return str.subSequence(startIndex, str.length());
        }
        return str.subSequence(startIndex, num.intValue());
    }

    public final List<String> transToUnicode(CharSequence str) {
        Intrinsics.checkNotNullParameter(str, "str");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int codePointAt = Character.codePointAt(str, i);
            arrayList.add("U+" + Integer.toHexString(codePointAt));
            i += Character.charCount(codePointAt);
        }
        return arrayList;
    }

    private final void forEachCodePoint(CharSequence charSequence, Function1<? super Integer, Unit> function1) {
        int i = 0;
        while (i < charSequence.length()) {
            int codePointAt = Character.codePointAt(charSequence, i);
            function1.invoke(Integer.valueOf(codePointAt));
            i += Character.charCount(codePointAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiReader.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0003\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011J\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/EmojiReader$StateMachine;", "", "()V", "charUnitList", "", "Lcom/larus/business/markdown/impl/markwon/EmojiReader$InnerNode;", "currentChar", "currentCodePoint", "", "currentIndex", "currentState", "emojiModifier", "", "assertEmoji", "", "endChar", "getCharList", "", "getCurrentCharSize", "getCurrentIndex", "isEmojiCodePoint", "", "codePoint", "isRegionalIndicator", "isSpecialSymbol", "maybeEmojiCodePoint", "moveToNext", "moveToPrev", "read", "str", "", "end", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class StateMachine {
        public static final int Joiner = 8205;
        public static final int ModifierBlack = 65038;
        public static final int ModifierColorFul = 65039;
        public static final int ModifierKeyCap = 8419;
        public static final int STATE_DEFAULT = 0;
        public static final int STATE_EMOJI = 1;
        public static final int STATE_EMOJI_JOIN = 65536;
        public static final int STATE_EMOJI_MODIFIER = 4097;
        public static final int STATE_NATIONAL_FLAG = 257;
        public static final int STATE_PRE_EMOJI = 16;
        private int currentCodePoint;
        private int currentIndex;
        private int currentState;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final IntRange ModifierTagRange = new IntRange(917536, 917631);
        private static final Set<Integer> ModifierSkinTone = SetsKt.setOf(new Integer[]{127995, 127996, 127997, 127998, 127999});
        private final Set<Integer> emojiModifier = SetsKt.plus(SetsKt.plus(SetsKt.setOf(new Integer[]{Integer.valueOf(ModifierBlack), Integer.valueOf(ModifierColorFul), Integer.valueOf(ModifierKeyCap)}), ModifierTagRange), ModifierSkinTone);
        private final List<InnerNode> charUnitList = new ArrayList();
        private InnerNode currentChar = new InnerNode(0, false, null, 6, null);

        private final boolean isRegionalIndicator(int codePoint) {
            return 126976 <= codePoint && codePoint < 127488;
        }

        private final boolean isSpecialSymbol(int codePoint) {
            return codePoint == 12336 || codePoint == 169 || codePoint == 174 || codePoint == 8482;
        }

        private final boolean maybeEmojiCodePoint(int codePoint) {
            if (codePoint >= 0 && codePoint < 58) {
                return true;
            }
            return 8592 <= codePoint && codePoint < 8704;
        }

        /* compiled from: EmojiReader.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/EmojiReader$StateMachine$Companion;", "", "()V", "Joiner", "", "ModifierBlack", "ModifierColorFul", "ModifierKeyCap", "ModifierSkinTone", "", "getModifierSkinTone", "()Ljava/util/Set;", "ModifierTagRange", "Lkotlin/ranges/IntRange;", "getModifierTagRange", "()Lkotlin/ranges/IntRange;", "STATE_DEFAULT", "STATE_EMOJI", "STATE_EMOJI_JOIN", "STATE_EMOJI_MODIFIER", "STATE_NATIONAL_FLAG", "STATE_PRE_EMOJI", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final IntRange getModifierTagRange() {
                return StateMachine.ModifierTagRange;
            }

            public final Set<Integer> getModifierSkinTone() {
                return StateMachine.ModifierSkinTone;
            }
        }

        private final void endChar() {
            this.currentState = 0;
            if (!this.currentChar.getCodePoint().isEmpty()) {
                this.charUnitList.add(this.currentChar);
                this.currentChar = new InnerNode(this.currentIndex, false, null, 6, null);
            }
        }

        private final void assertEmoji() {
            this.currentChar.setEmoji(true);
        }

        private final void moveToNext() {
            this.currentChar.getCodePoint().add(Integer.valueOf(this.currentCodePoint));
            this.currentIndex += Character.charCount(this.currentCodePoint);
        }

        private final void moveToPrev() {
            this.currentIndex -= Character.charCount(this.currentChar.getCodePoint().remove(CollectionsKt.getLastIndex(this.currentChar.getCodePoint())).intValue());
        }

        public static /* synthetic */ void read$default(StateMachine stateMachine, CharSequence charSequence, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = charSequence.length();
            }
            stateMachine.read(charSequence, i);
        }

        public final void read(CharSequence str, int end) {
            Intrinsics.checkNotNullParameter(str, "str");
            while (this.currentIndex < str.length()) {
                int codePointAt = Character.codePointAt(str, this.currentIndex);
                this.currentCodePoint = codePointAt;
                int i = this.currentState;
                if (i == 65536) {
                    if (isEmojiCodePoint(codePointAt)) {
                        this.currentState = 1;
                        moveToNext();
                    } else {
                        moveToPrev();
                        endChar();
                    }
                } else if (i == 257) {
                    if (isRegionalIndicator(codePointAt)) {
                        moveToNext();
                        assertEmoji();
                        endChar();
                    } else {
                        assertEmoji();
                        endChar();
                    }
                } else if (i == 16) {
                    if (this.emojiModifier.contains(Integer.valueOf(codePointAt))) {
                        this.currentState = 4097;
                        moveToNext();
                    } else {
                        endChar();
                    }
                } else if ((i & 1) != 0) {
                    if (8205 == codePointAt) {
                        this.currentState = 65536;
                        moveToNext();
                    } else if (this.emojiModifier.contains(Integer.valueOf(codePointAt))) {
                        this.currentState = 4097;
                        moveToNext();
                    } else {
                        assertEmoji();
                        endChar();
                    }
                } else if (isRegionalIndicator(codePointAt)) {
                    this.currentState = STATE_NATIONAL_FLAG;
                    moveToNext();
                } else if (maybeEmojiCodePoint(this.currentCodePoint)) {
                    this.currentState = 16;
                    moveToNext();
                } else if (isEmojiCodePoint(this.currentCodePoint)) {
                    this.currentState = 1;
                    moveToNext();
                } else {
                    moveToNext();
                    endChar();
                }
                if (getCurrentCharSize() >= end) {
                    break;
                }
            }
            int i2 = this.currentState;
            if (i2 != 0) {
                if ((i2 & 1) != 0) {
                    assertEmoji();
                }
                endChar();
            }
        }

        public final int getCurrentIndex() {
            return this.currentIndex;
        }

        public final int getCurrentCharSize() {
            return this.charUnitList.size();
        }

        public final List<InnerNode> getCharList() {
            return this.charUnitList;
        }

        private final boolean isEmojiCodePoint(int codePoint) {
            if (127488 <= codePoint && codePoint < 131072) {
                return true;
            }
            if (8986 <= codePoint && codePoint < 9216) {
                return true;
            }
            if (9312 <= codePoint && codePoint < 9472) {
                return true;
            }
            if (9472 <= codePoint && codePoint < 12288) {
                return true;
            }
            return (12800 <= codePoint && codePoint < 13056) || isSpecialSymbol(codePoint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmojiReader.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/EmojiReader$InnerNode;", "", "startIndex", "", "isEmoji", "", "codePoint", "", "(IZLjava/util/List;)V", "getCodePoint", "()Ljava/util/List;", "()Z", "setEmoji", "(Z)V", "getStartIndex", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class InnerNode {
        private final List<Integer> codePoint;
        private boolean isEmoji;
        private final int startIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InnerNode copy$default(InnerNode innerNode, int i, boolean z, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = innerNode.startIndex;
            }
            if ((i2 & 2) != 0) {
                z = innerNode.isEmoji;
            }
            if ((i2 & 4) != 0) {
                list = innerNode.codePoint;
            }
            return innerNode.copy(i, z, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsEmoji() {
            return this.isEmoji;
        }

        public final List<Integer> component3() {
            return this.codePoint;
        }

        public final InnerNode copy(int startIndex, boolean isEmoji, List<Integer> codePoint) {
            Intrinsics.checkNotNullParameter(codePoint, "codePoint");
            return new InnerNode(startIndex, isEmoji, codePoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InnerNode)) {
                return false;
            }
            InnerNode innerNode = (InnerNode) other;
            return this.startIndex == innerNode.startIndex && this.isEmoji == innerNode.isEmoji && Intrinsics.areEqual(this.codePoint, innerNode.codePoint);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Integer.hashCode(this.startIndex) * 31;
            boolean z = this.isEmoji;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.codePoint.hashCode();
        }

        public String toString() {
            return "InnerNode(startIndex=" + this.startIndex + ", isEmoji=" + this.isEmoji + ", codePoint=" + this.codePoint + ')';
        }

        public InnerNode(int i, boolean z, List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "codePoint");
            this.startIndex = i;
            this.isEmoji = z;
            this.codePoint = list;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final boolean isEmoji() {
            return this.isEmoji;
        }

        public final void setEmoji(boolean z) {
            this.isEmoji = z;
        }

        public /* synthetic */ InnerNode(int i, boolean z, ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? new ArrayList() : arrayList);
        }

        public final List<Integer> getCodePoint() {
            return this.codePoint;
        }
    }

    /* compiled from: EmojiReader.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/EmojiReader$Node;", "", "startIndex", "", "length", "isEmoji", "", "codePoint", "", "(IIZLjava/util/List;)V", "getCodePoint", "()Ljava/util/List;", "()Z", "getLength", "()I", "getStartIndex", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final /* data */ class Node {
        private final List<Integer> codePoint;
        private final boolean isEmoji;
        private final int length;
        private final int startIndex;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Node copy$default(Node node, int i, int i2, boolean z, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = node.startIndex;
            }
            if ((i3 & 2) != 0) {
                i2 = node.length;
            }
            if ((i3 & 4) != 0) {
                z = node.isEmoji;
            }
            if ((i3 & 8) != 0) {
                list = node.codePoint;
            }
            return node.copy(i, i2, z, list);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLength() {
            return this.length;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsEmoji() {
            return this.isEmoji;
        }

        public final List<Integer> component4() {
            return this.codePoint;
        }

        public final Node copy(int startIndex, int length, boolean isEmoji, List<Integer> codePoint) {
            Intrinsics.checkNotNullParameter(codePoint, "codePoint");
            return new Node(startIndex, length, isEmoji, codePoint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Node)) {
                return false;
            }
            Node node = (Node) other;
            return this.startIndex == node.startIndex && this.length == node.length && this.isEmoji == node.isEmoji && Intrinsics.areEqual(this.codePoint, node.codePoint);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.startIndex) * 31) + Integer.hashCode(this.length)) * 31;
            boolean z = this.isEmoji;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((hashCode + i) * 31) + this.codePoint.hashCode();
        }

        public Node(int i, int i2, boolean z, List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "codePoint");
            this.startIndex = i;
            this.length = i2;
            this.isEmoji = z;
            this.codePoint = list;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final int getLength() {
            return this.length;
        }

        public final boolean isEmoji() {
            return this.isEmoji;
        }

        public final List<Integer> getCodePoint() {
            return this.codePoint;
        }

        public String toString() {
            return "Node(startIndex=" + this.startIndex + ", length=" + this.length + ", isEmoji=" + this.isEmoji + ", codePoint=" + CollectionsKt.joinToString$default(this.codePoint, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Integer, CharSequence>() { // from class: com.larus.business.markdown.impl.markwon.EmojiReader$Node$toString$1
                public final CharSequence invoke(int i) {
                    String hexString = Integer.toHexString(i);
                    Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(it)");
                    return hexString;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }
            }, 31, (Object) null) + ')';
        }
    }
}
