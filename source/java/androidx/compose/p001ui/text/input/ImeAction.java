package androidx.compose.p001ui.text.input;

import androidx.webkit.Profile;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImeAction.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/input/ImeAction;", "", StrategyConstants.VALUE, "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImeAction {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Unspecified = m2290constructorimpl(-1);
    private static final int Default = m2290constructorimpl(1);
    private static final int None = m2290constructorimpl(0);

    /* renamed from: Go */
    private static final int f8Go = m2290constructorimpl(2);
    private static final int Search = m2290constructorimpl(3);
    private static final int Send = m2290constructorimpl(4);
    private static final int Previous = m2290constructorimpl(5);
    private static final int Next = m2290constructorimpl(6);
    private static final int Done = m2290constructorimpl(7);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ImeAction m2289boximpl(int i) {
        return new ImeAction(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m2290constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2291equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2292equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2293hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m2291equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m2293hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    public String toString() {
        return m2294toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2294toStringimpl(int i) {
        return m2292equalsimpl0(i, Unspecified) ? "Unspecified" : m2292equalsimpl0(i, None) ? "None" : m2292equalsimpl0(i, Default) ? Profile.DEFAULT_PROFILE_NAME : m2292equalsimpl0(i, f8Go) ? "Go" : m2292equalsimpl0(i, Search) ? "Search" : m2292equalsimpl0(i, Send) ? "Send" : m2292equalsimpl0(i, Previous) ? "Previous" : m2292equalsimpl0(i, Next) ? "Next" : m2292equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    /* compiled from: ImeAction.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u001d\u0010\u0003\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b \u0010\u0003\u001a\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Landroidx/compose/ui/text/input/ImeAction$Companion;", "", "<init>", "()V", "Unspecified", "Landroidx/compose/ui/text/input/ImeAction;", "getUnspecified-eUduSuo$annotations", "getUnspecified-eUduSuo", "()I", "I", Profile.DEFAULT_PROFILE_NAME, "getDefault-eUduSuo$annotations", "getDefault-eUduSuo", "None", "getNone-eUduSuo$annotations", "getNone-eUduSuo", "Go", "getGo-eUduSuo$annotations", "getGo-eUduSuo", "Search", "getSearch-eUduSuo$annotations", "getSearch-eUduSuo", "Send", "getSend-eUduSuo$annotations", "getSend-eUduSuo", "Previous", "getPrevious-eUduSuo$annotations", "getPrevious-eUduSuo", "Next", "getNext-eUduSuo$annotations", "getNext-eUduSuo", "Done", "getDone-eUduSuo$annotations", "getDone-eUduSuo", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefault-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2296getDefaulteUduSuo$annotations() {
        }

        /* renamed from: getDone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2297getDoneeUduSuo$annotations() {
        }

        /* renamed from: getGo-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2298getGoeUduSuo$annotations() {
        }

        /* renamed from: getNext-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2299getNexteUduSuo$annotations() {
        }

        /* renamed from: getNone-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2300getNoneeUduSuo$annotations() {
        }

        /* renamed from: getPrevious-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2301getPreviouseUduSuo$annotations() {
        }

        /* renamed from: getSearch-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2302getSearcheUduSuo$annotations() {
        }

        /* renamed from: getSend-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2303getSendeUduSuo$annotations() {
        }

        /* renamed from: getUnspecified-eUduSuo$annotations, reason: not valid java name */
        public static /* synthetic */ void m2304getUnspecifiedeUduSuo$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-eUduSuo, reason: not valid java name */
        public final int m2313getUnspecifiedeUduSuo() {
            return ImeAction.Unspecified;
        }

        /* renamed from: getDefault-eUduSuo, reason: not valid java name */
        public final int m2305getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* renamed from: getNone-eUduSuo, reason: not valid java name */
        public final int m2309getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* renamed from: getGo-eUduSuo, reason: not valid java name */
        public final int m2307getGoeUduSuo() {
            return ImeAction.f8Go;
        }

        /* renamed from: getSearch-eUduSuo, reason: not valid java name */
        public final int m2311getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* renamed from: getSend-eUduSuo, reason: not valid java name */
        public final int m2312getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* renamed from: getPrevious-eUduSuo, reason: not valid java name */
        public final int m2310getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* renamed from: getNext-eUduSuo, reason: not valid java name */
        public final int m2308getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* renamed from: getDone-eUduSuo, reason: not valid java name */
        public final int m2306getDoneeUduSuo() {
            return ImeAction.Done;
        }
    }
}
