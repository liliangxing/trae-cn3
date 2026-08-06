package com.bytedance.trae.conversation.chat.block.renderer.ref;

import android.content.Context;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefChipSpan;
import com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefParser;
import io.noties.markwon.ext.tables.TableSpan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TraeRefRenderer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ \u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;", "", "clickListener", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V", "applyOnSpanned", "Landroid/text/Spanned;", "textView", "Landroid/widget/TextView;", TimonPipeline.KEY_SOURCE, "stripResult", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;", "applyWithPlaceholders", "applyLegacy", "renderPlain", "Landroid/text/Spannable;", AccountMonitorConstants.CommonParameter.RAW, "", "ensureClickable", "", "StripResult", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRefRenderer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex PLACEHOLDER_PATTERN = new Regex("\u2060\u200b([\u200b\u200c]+)\u200b\u2061");
    private static final String PLACEHOLDER_PREFIX = "\u2060\u200b";
    private static final String PLACEHOLDER_SUFFIX = "\u200b\u2061";
    private final TraeRefClickListener clickListener;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TraeRefRenderer() {
        this(r0, 1, r0);
        TraeRefClickListener traeRefClickListener = null;
    }

    public TraeRefRenderer(TraeRefClickListener traeRefClickListener) {
        Intrinsics.checkNotNullParameter(traeRefClickListener, "clickListener");
        this.clickListener = traeRefClickListener;
    }

    public /* synthetic */ TraeRefRenderer(TraeRefClickListener traeRefClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TraeRefDialog.INSTANCE.getDEFAULT_LISTENER() : traeRefClickListener);
    }

    /* compiled from: TraeRefRenderer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;", "", "safeText", "", "groups", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getSafeText", "()Ljava/lang/String;", "getGroups", "()Ljava/util/List;", "hasRefs", "", "getHasRefs", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class StripResult {
        private final List<TraeRefGroup> groups;
        private final String safeText;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StripResult copy$default(StripResult stripResult, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stripResult.safeText;
            }
            if ((i & 2) != 0) {
                list = stripResult.groups;
            }
            return stripResult.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getSafeText() {
            return this.safeText;
        }

        public final List<TraeRefGroup> component2() {
            return this.groups;
        }

        public final StripResult copy(String safeText, List<TraeRefGroup> groups) {
            Intrinsics.checkNotNullParameter(safeText, "safeText");
            Intrinsics.checkNotNullParameter(groups, "groups");
            return new StripResult(safeText, groups);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StripResult)) {
                return false;
            }
            StripResult stripResult = (StripResult) other;
            return Intrinsics.areEqual(this.safeText, stripResult.safeText) && Intrinsics.areEqual(this.groups, stripResult.groups);
        }

        public int hashCode() {
            return (this.safeText.hashCode() * 31) + this.groups.hashCode();
        }

        public String toString() {
            return "StripResult(safeText=" + this.safeText + ", groups=" + this.groups + ')';
        }

        public StripResult(String str, List<TraeRefGroup> list) {
            Intrinsics.checkNotNullParameter(str, "safeText");
            Intrinsics.checkNotNullParameter(list, "groups");
            this.safeText = str;
            this.groups = list;
        }

        public final String getSafeText() {
            return this.safeText;
        }

        public final List<TraeRefGroup> getGroups() {
            return this.groups;
        }

        public final boolean getHasRefs() {
            return !this.groups.isEmpty();
        }
    }

    /* compiled from: TraeRefRenderer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;", "", "<init>", "()V", "PLACEHOLDER_PREFIX", "", "PLACEHOLDER_SUFFIX", "placeholder", "index", "", "PLACEHOLDER_PATTERN", "Lkotlin/text/Regex;", "decodePlaceholderIndex", "encoded", "(Ljava/lang/String;)Ljava/lang/Integer;", "stripBeforeMarkdown", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;", AccountMonitorConstants.CommonParameter.RAW, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String placeholder(int index) {
            String num = Integer.toString(index, CharsKt.checkRadix(2));
            Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
            String str = num;
            ArrayList arrayList = new ArrayList(str.length());
            for (int i = 0; i < str.length(); i++) {
                arrayList.add(Character.valueOf(str.charAt(i) == '0' ? (char) 8203 : (char) 8204));
            }
            return TraeRefRenderer.PLACEHOLDER_PREFIX + CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + TraeRefRenderer.PLACEHOLDER_SUFFIX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Integer decodePlaceholderIndex(String encoded) {
            String str = encoded;
            ArrayList arrayList = new ArrayList(str.length());
            for (int i = 0; i < str.length(); i++) {
                arrayList.add(Character.valueOf(str.charAt(i) == 8203 ? '0' : '1'));
            }
            return StringsKt.toIntOrNull(CollectionsKt.joinToString$default(arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), 2);
        }

        public final StripResult stripBeforeMarkdown(String raw) {
            boolean z;
            boolean z2;
            Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
            String str = raw;
            if (!StringsKt.contains$default(str, TraeRefConstants.SPECIAL_TOKEN, false, 2, (Object) null)) {
                return new StripResult(raw, CollectionsKt.emptyList());
            }
            List<TraeRefParser.Segment> parse = TraeRefParser.INSTANCE.parse(raw);
            List<TraeRefParser.Segment> list = parse;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((TraeRefParser.Segment) it.next()) instanceof TraeRefParser.Segment.Ref) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return new StripResult(raw, CollectionsKt.emptyList());
            }
            ArrayList arrayList = new ArrayList();
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (raw.charAt(i2) == '\n') {
                    String substring = raw.substring(i, i2);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    if (StringsKt.startsWith$default(StringsKt.trimStart(substring).toString(), "|", false, 2, (Object) null)) {
                        arrayList.add(new IntRange(i, i2));
                    }
                    i = i2 + 1;
                }
            }
            if (i < raw.length()) {
                String substring2 = raw.substring(i);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                if (StringsKt.startsWith$default(StringsKt.trimStart(substring2).toString(), "|", false, 2, (Object) null)) {
                    arrayList.add(RangesKt.until(i, raw.length()));
                }
            }
            ArrayList arrayList2 = new ArrayList();
            StringBuilder sb = new StringBuilder();
            for (TraeRefParser.Segment segment : parse) {
                if (segment instanceof TraeRefParser.Segment.Text) {
                    sb.append(((TraeRefParser.Segment.Text) segment).getText());
                } else {
                    if (!(segment instanceof TraeRefParser.Segment.Ref)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ArrayList<IntRange> arrayList3 = arrayList;
                    if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                        for (IntRange intRange : arrayList3) {
                            int first = intRange.getFirst();
                            int last = intRange.getLast();
                            int rawStart = ((TraeRefParser.Segment.Ref) segment).getRawStart();
                            if (first <= rawStart && rawStart <= last) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                        for (TraeRefSource traeRefSource : ((TraeRefParser.Segment.Ref) segment).getGroup().getSources()) {
                            sb.append("[" + traeRefSource.getHost() + "](" + traeRefSource.getUrl() + ')');
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        int size = arrayList2.size();
                        arrayList2.add(((TraeRefParser.Segment.Ref) segment).getGroup());
                        sb.append(placeholder(size));
                    }
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return new StripResult(sb2, arrayList2);
        }
    }

    public final Spanned applyOnSpanned(TextView textView, Spanned source, StripResult stripResult) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        if (stripResult != null && stripResult.getHasRefs()) {
            return applyWithPlaceholders(textView, source, stripResult);
        }
        return applyLegacy(textView, source);
    }

    private final Spanned applyWithPlaceholders(TextView textView, Spanned source, StripResult stripResult) {
        int intValue;
        boolean z;
        List list = SequencesKt.toList(Regex.findAll$default(PLACEHOLDER_PATTERN, source.toString(), 0, 2, (Object) null));
        if (list.isEmpty()) {
            return source;
        }
        Object[] spans = source.getSpans(0, source.length(), TableSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList arrayList = new ArrayList(spans.length);
        for (Object obj : spans) {
            TableSpan tableSpan = (TableSpan) obj;
            arrayList.add(new IntRange(source.getSpanStart(tableSpan), source.getSpanEnd(tableSpan)));
        }
        ArrayList arrayList2 = arrayList;
        boolean z2 = !arrayList2.isEmpty();
        TraeRefChipSpan.Style.Companion companion = TraeRefChipSpan.Style.INSTANCE;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TraeRefChipSpan.Style from = companion.from(context);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(source);
        for (MatchResult matchResult : CollectionsKt.asReversed(list)) {
            Integer decodePlaceholderIndex = INSTANCE.decodePlaceholderIndex((String) matchResult.getGroupValues().get(1));
            if (decodePlaceholderIndex != null && (intValue = decodePlaceholderIndex.intValue()) >= 0) {
                if (intValue < stripResult.getGroups().size()) {
                    TraeRefGroup traeRefGroup = stripResult.getGroups().get(intValue);
                    int first = matchResult.getRange().getFirst();
                    int last = matchResult.getRange().getLast() + 1;
                    if (first >= 0) {
                        if (last <= spannableStringBuilder.length()) {
                            ArrayList<IntRange> arrayList3 = arrayList2;
                            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                                for (IntRange intRange : arrayList3) {
                                    if (first <= intRange.getLast() && intRange.getFirst() <= first) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (!z) {
                                if (!z2) {
                                    spannableStringBuilder.replace(first, last, (CharSequence) "￼");
                                    last = first + 1;
                                }
                                spannableStringBuilder.setSpan(new TraeRefChipSpan(traeRefGroup, from), first, last, 33);
                                spannableStringBuilder.setSpan(new TraeRefClickableSpan(traeRefGroup, this.clickListener), first, last, 33);
                            }
                        }
                    }
                }
            }
        }
        if (z2) {
            Iterator it = ArrayIteratorKt.iterator((NoCopySpan[]) source.getSpans(0, source.length(), NoCopySpan.class));
            while (it.hasNext()) {
                NoCopySpan noCopySpan = (NoCopySpan) it.next();
                int spanStart = source.getSpanStart(noCopySpan);
                int spanEnd = source.getSpanEnd(noCopySpan);
                int spanFlags = source.getSpanFlags(noCopySpan);
                if (spanStart >= 0 && spanEnd >= 0) {
                    spannableStringBuilder.setSpan(noCopySpan, spanStart, spanEnd, spanFlags);
                }
            }
        }
        ensureClickable(textView);
        return spannableStringBuilder;
    }

    private final Spanned applyLegacy(TextView textView, Spanned source) {
        if (!StringsKt.contains$default(source.toString(), TraeRefConstants.SPECIAL_TOKEN, false, 2, (Object) null)) {
            return source;
        }
        TraeRefChipSpan.Style.Companion companion = TraeRefChipSpan.Style.INSTANCE;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TraeRefChipSpan.Style from = companion.from(context);
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(source);
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            URLSpan uRLSpan = (URLSpan) obj;
            int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
            if ((spanStart < 0 || spanEnd < 0) ? false : StringsKt.contains$default(spannableStringBuilder.subSequence(spanStart, spanEnd).toString(), TraeRefConstants.SPECIAL_TOKEN, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(spannableStringBuilder.getSpanStart((URLSpan) t2)), Integer.valueOf(spannableStringBuilder.getSpanStart((URLSpan) t)));
            }
        });
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (URLSpan uRLSpan2 : CollectionsKt.asReversed(sortedWith)) {
            int spanStart2 = spannableStringBuilder.getSpanStart(uRLSpan2);
            int spanEnd2 = spannableStringBuilder.getSpanEnd(uRLSpan2);
            if (spanStart2 >= 0 && spanEnd2 >= 0) {
                if (arrayList3.isEmpty()) {
                    Intrinsics.checkNotNull(uRLSpan2);
                    arrayList3.add(uRLSpan2);
                } else if (StringsKt.isBlank(spannableStringBuilder.subSequence(spannableStringBuilder.getSpanEnd(CollectionsKt.last(arrayList3)), spanStart2).toString())) {
                    Intrinsics.checkNotNull(uRLSpan2);
                    arrayList3.add(uRLSpan2);
                } else {
                    arrayList2.add(arrayList3);
                    arrayList3 = CollectionsKt.mutableListOf(new URLSpan[]{uRLSpan2});
                }
            }
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.add(arrayList3);
        }
        for (List list : CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(spannableStringBuilder.getSpanStart(CollectionsKt.first((List) t2))), Integer.valueOf(spannableStringBuilder.getSpanStart(CollectionsKt.first((List) t))));
            }
        })) {
            int spanStart3 = spannableStringBuilder.getSpanStart(CollectionsKt.first(list));
            int spanEnd3 = spannableStringBuilder.getSpanEnd(CollectionsKt.last(list));
            if (spanStart3 >= 0 && spanEnd3 >= 0 && spanStart3 < spanEnd3) {
                List list2 = list;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    String url = ((URLSpan) it.next()).getURL();
                    Intrinsics.checkNotNull(url);
                    arrayList4.add(new TraeRefSource(url, TraeRefParser.INSTANCE.extractHost(url), null, 4, null));
                }
                TraeRefGroup traeRefGroup = new TraeRefGroup(arrayList4);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    spannableStringBuilder.removeSpan((URLSpan) it2.next());
                }
                spannableStringBuilder.replace(spanStart3, spanEnd3, (CharSequence) "￼");
                int i = spanStart3 + 1;
                spannableStringBuilder.setSpan(new TraeRefChipSpan(traeRefGroup, from), spanStart3, i, 33);
                spannableStringBuilder.setSpan(new TraeRefClickableSpan(traeRefGroup, this.clickListener), spanStart3, i, 33);
            }
        }
        String spannableStringBuilder2 = spannableStringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder2, "toString(...)");
        List<TraeRefParser.Segment> parse = TraeRefParser.INSTANCE.parse(spannableStringBuilder2);
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : parse) {
            if (obj2 instanceof TraeRefParser.Segment.Ref) {
                arrayList5.add(obj2);
            }
        }
        for (TraeRefParser.Segment.Ref ref : CollectionsKt.asReversed(arrayList5)) {
            int rawStart = ref.getRawStart();
            int rawEnd = ref.getRawEnd();
            if (rawStart >= 0 && rawEnd <= spannableStringBuilder.length() && rawStart < rawEnd) {
                spannableStringBuilder.replace(rawStart, rawEnd, (CharSequence) "￼");
                int i2 = rawStart + 1;
                spannableStringBuilder.setSpan(new TraeRefChipSpan(ref.getGroup(), from), rawStart, i2, 33);
                spannableStringBuilder.setSpan(new TraeRefClickableSpan(ref.getGroup(), this.clickListener), rawStart, i2, 33);
            }
        }
        ensureClickable(textView);
        return spannableStringBuilder;
    }

    public final Spannable renderPlain(TextView textView, String raw) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        TraeRefChipSpan.Style.Companion companion = TraeRefChipSpan.Style.INSTANCE;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TraeRefChipSpan.Style from = companion.from(context);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (TraeRefParser.Segment segment : TraeRefParser.INSTANCE.parse(raw)) {
            if (segment instanceof TraeRefParser.Segment.Text) {
                spannableStringBuilder.append((CharSequence) ((TraeRefParser.Segment.Text) segment).getText());
            } else {
                if (!(segment instanceof TraeRefParser.Segment.Ref)) {
                    throw new NoWhenBranchMatchedException();
                }
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) "￼");
                TraeRefParser.Segment.Ref ref = (TraeRefParser.Segment.Ref) segment;
                spannableStringBuilder.setSpan(new TraeRefChipSpan(ref.getGroup(), from), length, spannableStringBuilder.length(), 33);
                spannableStringBuilder.setSpan(new TraeRefClickableSpan(ref.getGroup(), this.clickListener), length, spannableStringBuilder.length(), 33);
            }
        }
        ensureClickable(textView);
        SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    private final void ensureClickable(TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod)) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        textView.setHighlightColor(0);
    }
}
