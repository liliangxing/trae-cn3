package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.home.solo.task.TaskSearchTextFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: TaskSearchTextFormatter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fJ.\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\n\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fH\u0002J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\f*\b\u0012\u0004\u0012\u00020\u00070\fH\u0002J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\fH\u0002J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J\u0014\u0010\u0015\u001a\u00020\u0016*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;", "", "<init>", "()V", "MAX_PREFIX_CHARS_BEFORE_MATCH", "", "TRUNCATION_PREFIX", "", "format", "text", "query", "highlightKeywords", "", "highlightRanges", "Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;", "highlightTerms", "mapNotBlank", "firstMatchStart", "terms", "visibleStartForMatch", "matchStart", "overlaps", "", "other", "HighlightRange", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskSearchTextFormatter {
    public static final int $stable = 0;
    public static final TaskSearchTextFormatter INSTANCE = new TaskSearchTextFormatter();
    public static final int MAX_PREFIX_CHARS_BEFORE_MATCH = 24;
    private static final String TRUNCATION_PREFIX = "...";

    private TaskSearchTextFormatter() {
    }

    /* compiled from: TaskSearchTextFormatter.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0010\u001a\u00020\u0003H×\u0001J\t\u0010\u0011\u001a\u00020\u0012H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "getEnd", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class HighlightRange {
        public static final int $stable = 0;
        private final int end;
        private final int start;

        public static /* synthetic */ HighlightRange copy$default(HighlightRange highlightRange, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = highlightRange.start;
            }
            if ((i3 & 2) != 0) {
                i2 = highlightRange.end;
            }
            return highlightRange.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        public final HighlightRange copy(int start, int end) {
            return new HighlightRange(start, end);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HighlightRange)) {
                return false;
            }
            HighlightRange highlightRange = (HighlightRange) other;
            return this.start == highlightRange.start && this.end == highlightRange.end;
        }

        public int hashCode() {
            return (Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end);
        }

        public String toString() {
            return "HighlightRange(start=" + this.start + ", end=" + this.end + ')';
        }

        public HighlightRange(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String format$default(TaskSearchTextFormatter taskSearchTextFormatter, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return taskSearchTextFormatter.format(str, str2, list);
    }

    public final String format(String text, String query, List<String> highlightKeywords) {
        int firstMatchStart;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(query, "query");
        List<String> highlightTerms = highlightTerms(query, highlightKeywords);
        if (StringsKt.isBlank(text) || highlightTerms.isEmpty() || (firstMatchStart = firstMatchStart(text, highlightTerms)) < 0 || firstMatchStart <= 24) {
            return text;
        }
        int visibleStartForMatch = visibleStartForMatch(text, firstMatchStart);
        StringBuilder sb = new StringBuilder(TRUNCATION_PREFIX);
        String substring = text.substring(visibleStartForMatch);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return sb.append(substring).toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List highlightRanges$default(TaskSearchTextFormatter taskSearchTextFormatter, String str, String str2, List list, int i, Object obj) {
        if ((i & 4) != 0) {
            list = null;
        }
        return taskSearchTextFormatter.highlightRanges(str, str2, list);
    }

    public final List<HighlightRange> highlightRanges(String text, String query, List<String> highlightKeywords) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(query, "query");
        List<String> highlightTerms = highlightTerms(query, highlightKeywords);
        if (StringsKt.isBlank(text) || highlightTerms.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = text.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        ArrayList arrayList = new ArrayList();
        for (String str : highlightTerms) {
            Locale locale2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
            String lowerCase2 = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            String str2 = lowerCase;
            for (int indexOf$default = StringsKt.indexOf$default(str2, lowerCase2, 0, false, 6, (Object) null); indexOf$default >= 0; indexOf$default = StringsKt.indexOf$default(str2, lowerCase2, indexOf$default + lowerCase2.length(), false, 4, (Object) null)) {
                HighlightRange highlightRange = new HighlightRange(indexOf$default, lowerCase2.length() + indexOf$default);
                ArrayList arrayList2 = arrayList;
                boolean z = true;
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    Iterator it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (INSTANCE.overlaps((HighlightRange) it.next(), highlightRange)) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    arrayList.add(highlightRange);
                }
            }
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.bytedance.trae.home.solo.task.TaskSearchTextFormatter$highlightRanges$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((TaskSearchTextFormatter.HighlightRange) t).getStart()), Integer.valueOf(((TaskSearchTextFormatter.HighlightRange) t2).getStart()));
            }
        });
    }

    private final List<String> highlightTerms(String query, List<String> highlightKeywords) {
        List<String> mapNotBlank = highlightKeywords != null ? mapNotBlank(highlightKeywords) : null;
        List<String> list = mapNotBlank;
        ArrayList arrayList = list == null || list.isEmpty() ? null : mapNotBlank;
        if (arrayList == null) {
            List listOf = CollectionsKt.listOf(StringsKt.trim(query).toString());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : listOf) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = ((String) obj2).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (hashSet.add(lowerCase)) {
                arrayList3.add(obj2);
            }
        }
        return arrayList3;
    }

    private final List<String> mapNotBlank(List<String> list) {
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(list), new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskSearchTextFormatter$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                String mapNotBlank$lambda$6;
                mapNotBlank$lambda$6 = TaskSearchTextFormatter.mapNotBlank$lambda$6((String) obj);
                return mapNotBlank$lambda$6;
            }
        }), new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskSearchTextFormatter$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean mapNotBlank$lambda$7;
                mapNotBlank$lambda$7 = TaskSearchTextFormatter.mapNotBlank$lambda$7((String) obj);
                return Boolean.valueOf(mapNotBlank$lambda$7);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mapNotBlank$lambda$6(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return StringsKt.trim(str).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mapNotBlank$lambda$7(String str) {
        Intrinsics.checkNotNullParameter(str, "it");
        return str.length() > 0;
    }

    private final int firstMatchStart(String text, List<String> terms) {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = text.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<String> list = terms;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str : list) {
            Locale locale2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
            String lowerCase2 = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            arrayList.add(Integer.valueOf(StringsKt.indexOf$default(lowerCase, lowerCase2, 0, false, 6, (Object) null)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) obj).intValue() >= 0) {
                arrayList2.add(obj);
            }
        }
        Integer num = (Integer) CollectionsKt.minOrNull(arrayList2);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final int visibleStartForMatch(String text, int matchStart) {
        int coerceAtLeast = RangesKt.coerceAtLeast(matchStart - 24, 0);
        Integer valueOf = Integer.valueOf(StringsKt.lastIndexOf$default(text, '\n', matchStart - 1, false, 4, (Object) null));
        if (!(valueOf.intValue() >= coerceAtLeast)) {
            valueOf = null;
        }
        Integer valueOf2 = valueOf != null ? Integer.valueOf(valueOf.intValue() + 1) : null;
        return valueOf2 != null ? valueOf2.intValue() : coerceAtLeast;
    }

    private final boolean overlaps(HighlightRange highlightRange, HighlightRange highlightRange2) {
        return highlightRange.getStart() < highlightRange2.getEnd() && highlightRange2.getStart() < highlightRange.getEnd();
    }
}
