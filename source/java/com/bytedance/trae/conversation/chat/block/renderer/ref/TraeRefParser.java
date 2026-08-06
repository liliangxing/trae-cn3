package com.bytedance.trae.conversation.chat.block.renderer.ref;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: TraeRefParser.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;", "", "<init>", "()V", "SINGLE_REF", "Ljava/util/regex/Pattern;", "parse", "", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;", AccountMonitorConstants.CommonParameter.RAW, "", "extractHost", IWeixinService.ResponseConstants.URL, "fallbackHost", "Segment", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRefParser {
    public static final TraeRefParser INSTANCE = new TraeRefParser();
    private static final Pattern SINGLE_REF;

    private TraeRefParser() {
    }

    static {
        Pattern compile = Pattern.compile("\\[\\$TRAE_REF\\]\\((https?://[^)\\s]+)\\)");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        SINGLE_REF = compile;
    }

    /* compiled from: TraeRefParser.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;", "", "<init>", "()V", "Text", "Ref", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class Segment {
        public /* synthetic */ Segment(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: TraeRefParser.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Text extends Segment {
            private final String text;

            public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = text.text;
                }
                return text.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final Text copy(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                return new Text(text);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Text) && Intrinsics.areEqual(this.text, ((Text) other).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "Text(text=" + this.text + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Text(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "text");
                this.text = str;
            }

            public final String getText() {
                return this.text;
            }
        }

        private Segment() {
        }

        /* compiled from: TraeRefParser.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;", "group", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "rawStart", "", "rawEnd", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;II)V", "getGroup", "()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "getRawStart", "()I", "getRawEnd", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Ref extends Segment {
            private final TraeRefGroup group;
            private final int rawEnd;
            private final int rawStart;

            public static /* synthetic */ Ref copy$default(Ref ref, TraeRefGroup traeRefGroup, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    traeRefGroup = ref.group;
                }
                if ((i3 & 2) != 0) {
                    i = ref.rawStart;
                }
                if ((i3 & 4) != 0) {
                    i2 = ref.rawEnd;
                }
                return ref.copy(traeRefGroup, i, i2);
            }

            /* renamed from: component1, reason: from getter */
            public final TraeRefGroup getGroup() {
                return this.group;
            }

            /* renamed from: component2, reason: from getter */
            public final int getRawStart() {
                return this.rawStart;
            }

            /* renamed from: component3, reason: from getter */
            public final int getRawEnd() {
                return this.rawEnd;
            }

            public final Ref copy(TraeRefGroup group, int rawStart, int rawEnd) {
                Intrinsics.checkNotNullParameter(group, "group");
                return new Ref(group, rawStart, rawEnd);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Ref)) {
                    return false;
                }
                Ref ref = (Ref) other;
                return Intrinsics.areEqual(this.group, ref.group) && this.rawStart == ref.rawStart && this.rawEnd == ref.rawEnd;
            }

            public int hashCode() {
                return (((this.group.hashCode() * 31) + Integer.hashCode(this.rawStart)) * 31) + Integer.hashCode(this.rawEnd);
            }

            public String toString() {
                return "Ref(group=" + this.group + ", rawStart=" + this.rawStart + ", rawEnd=" + this.rawEnd + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Ref(TraeRefGroup traeRefGroup, int i, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(traeRefGroup, "group");
                this.group = traeRefGroup;
                this.rawStart = i;
                this.rawEnd = i2;
            }

            public final TraeRefGroup getGroup() {
                return this.group;
            }

            public final int getRawEnd() {
                return this.rawEnd;
            }

            public final int getRawStart() {
                return this.rawStart;
            }
        }
    }

    public final List<Segment> parse(String raw) {
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        String str = raw;
        if ((str.length() == 0) || !StringsKt.contains$default(str, TraeRefConstants.SPECIAL_TOKEN, false, 2, (Object) null)) {
            return str.length() == 0 ? CollectionsKt.emptyList() : CollectionsKt.listOf(new Segment.Text(raw));
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = SINGLE_REF.matcher(str);
        ArrayList arrayList2 = new ArrayList();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = -1;
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group(1);
            String obj = group != null ? StringsKt.trim(group).toString() : null;
            if (obj == null) {
                obj = "";
            }
            String str2 = obj;
            if (start > i) {
                String substring = raw.substring(i, start);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (!((arrayList2.isEmpty() ^ true) && StringsKt.isBlank(substring))) {
                    parse$flushGroup(arrayList2, arrayList, intRef, intRef2);
                    if (substring.length() > 0) {
                        arrayList.add(new Segment.Text(substring));
                    }
                }
            }
            TraeRefSource traeRefSource = new TraeRefSource(str2, extractHost(str2), null, 4, null);
            if (arrayList2.isEmpty()) {
                intRef.element = start;
            }
            arrayList2.add(traeRefSource);
            intRef2.element = end;
            i = end;
        }
        parse$flushGroup(arrayList2, arrayList, intRef, intRef2);
        if (i < raw.length()) {
            String substring2 = raw.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            arrayList.add(new Segment.Text(substring2));
        }
        return arrayList;
    }

    private static final void parse$flushGroup(List<TraeRefSource> list, List<Segment> list2, Ref.IntRef intRef, Ref.IntRef intRef2) {
        if (!list.isEmpty()) {
            list2.add(new Segment.Ref(new TraeRefGroup(CollectionsKt.toList(list)), intRef.element, intRef2.element));
            list.clear();
            intRef.element = -1;
            intRef2.element = -1;
        }
    }

    public final String extractHost(String url) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (StringsKt.isBlank(url)) {
            return "";
        }
        try {
            String host = new URI(StringsKt.contains$default(url, "://", false, 2, (Object) null) ? url : "https://" + url).getHost();
            return host == null ? fallbackHost(url) : StringsKt.removePrefix(host, "www.");
        } catch (Exception unused) {
            return fallbackHost(url);
        }
    }

    private final String fallbackHost(String url) {
        return StringsKt.removePrefix(StringsKt.substringBefore$default(StringsKt.substringBefore$default(StringsKt.substringBefore$default(StringsKt.substringAfter(url, "://", url), "/", (String) null, 2, (Object) null), "?", (String) null, 2, (Object) null), "#", (String) null, 2, (Object) null), "www.");
    }
}
