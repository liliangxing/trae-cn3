package com.bytedance.trae.conversation.network;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IdeVersionComparator.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0017\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/network/IdeVersionComparator;", "", "<init>", "()V", "isGreaterOrEqual", "", "version", "", "minimum", "parse", "Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;", AccountMonitorConstants.CommonParameter.RAW, "parsePart", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "Version", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IdeVersionComparator {
    public static final IdeVersionComparator INSTANCE = new IdeVersionComparator();

    private IdeVersionComparator() {
    }

    public final boolean isGreaterOrEqual(String version, String minimum) {
        Version parse;
        Intrinsics.checkNotNullParameter(minimum, "minimum");
        Version parse2 = parse(version);
        return (parse2 == null || (parse = parse(minimum)) == null || parse2.compareTo(parse) < 0) ? false : true;
    }

    private final Version parse(String raw) {
        String str = raw;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        List split$default = StringsKt.split$default(StringsKt.trim(str).toString(), new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.isEmpty()) {
            return null;
        }
        List list = split$default;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer parsePart = INSTANCE.parsePart((String) it.next());
            if (parsePart == null) {
                return null;
            }
            arrayList.add(Integer.valueOf(parsePart.intValue()));
        }
        return new Version(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdeVersionComparator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0000H\u0096\u0002J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;", "", "parts", "", "", "<init>", "(Ljava/util/List;)V", "getParts", "()Ljava/util/List;", "compareTo", "other", "component1", "copy", "equals", "", "", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Version implements Comparable<Version> {
        private final List<Integer> parts;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Version copy$default(Version version, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = version.parts;
            }
            return version.copy(list);
        }

        public final List<Integer> component1() {
            return this.parts;
        }

        public final Version copy(List<Integer> parts) {
            Intrinsics.checkNotNullParameter(parts, "parts");
            return new Version(parts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Version) && Intrinsics.areEqual(this.parts, ((Version) other).parts);
        }

        public int hashCode() {
            return this.parts.hashCode();
        }

        public String toString() {
            return "Version(parts=" + this.parts + ')';
        }

        public Version(List<Integer> list) {
            Intrinsics.checkNotNullParameter(list, "parts");
            this.parts = list;
        }

        public final List<Integer> getParts() {
            return this.parts;
        }

        @Override // java.lang.Comparable
        public int compareTo(Version other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int max = Math.max(this.parts.size(), other.parts.size());
            int i = 0;
            while (i < max) {
                List<Integer> list = this.parts;
                Integer num = i >= 0 && i < list.size() ? list.get(i) : 0;
                List<Integer> list2 = other.parts;
                Integer valueOf = Integer.valueOf(ComparisonsKt.compareValues(num, i >= 0 && i < list2.size() ? list2.get(i) : 0));
                if (!(valueOf.intValue() != 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    return valueOf.intValue();
                }
                i++;
            }
            return 0;
        }
    }

    private final Integer parsePart(String raw) {
        int length = raw.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (!Character.isDigit(raw.charAt(i))) {
                raw = raw.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(raw, "substring(...)");
                break;
            }
            i++;
        }
        if (!(raw.length() > 0)) {
            raw = null;
        }
        if (raw != null) {
            return StringsKt.toIntOrNull(raw);
        }
        return null;
    }
}
