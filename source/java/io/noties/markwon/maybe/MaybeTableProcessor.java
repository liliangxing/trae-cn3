package io.noties.markwon.maybe;

import com.ss.android.update.UpdateDialogNewBase;
import io.noties.markwon.inlineparser.InlineProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Node;

/* compiled from: MaybeTableProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lio/noties/markwon/maybe/MaybeTableProcessor;", "Lio/noties/markwon/inlineparser/InlineProcessor;", "origin", "Ljava/util/concurrent/atomic/AtomicReference;", "", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "parse", "Lorg/commonmark/node/Node;", "specialCharacter", "", "Companion", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class MaybeTableProcessor extends InlineProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String oneLine = "^\\|.*\\|.*$";
    private static final Pattern pattern;
    private static final String twoLine = "^\\|([^\\|\\n]*\\|)+ ?\\n *\\|?[- :\\|]*$";
    private final AtomicReference<String> origin;

    public char specialCharacter() {
        return '|';
    }

    public MaybeTableProcessor(AtomicReference<String> atomicReference) {
        Intrinsics.checkParameterIsNotNull(atomicReference, "origin");
        this.origin = atomicReference;
    }

    protected Node parse() {
        String match;
        String str = this.origin.get();
        Intrinsics.checkExpressionValueIsNotNull(str, "origin.get()");
        String removeSuffix = StringsKt.removeSuffix(str, UpdateDialogNewBase.TYPE);
        String input = this.context.input();
        Intrinsics.checkExpressionValueIsNotNull(input, "context.input()");
        if (!StringsKt.endsWith$default(removeSuffix, input, false, 2, (Object) null) || (match = match(pattern)) == null) {
            return null;
        }
        TableBlock tableBlock = new TableBlock();
        TableHead tableHead = new TableHead();
        TableRow tableRow = new TableRow();
        for (String str2 : INSTANCE.splitCell(match)) {
            TableCell tableCell = new TableCell();
            tableCell.setHeader(true);
            tableCell.setAlignment(TableCell.Alignment.LEFT);
            tableCell.appendChild((Node) text(str2));
            tableRow.appendChild((Node) tableCell);
        }
        tableBlock.appendChild((Node) tableHead);
        tableHead.appendChild((Node) tableRow);
        MaybeNode maybeNode = new MaybeNode(tableBlock);
        maybeNode.appendChild((Node) text(match));
        return maybeNode;
    }

    /* compiled from: MaybeTableProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lio/noties/markwon/maybe/MaybeTableProcessor$Companion;", "", "()V", "oneLine", "", "pattern", "Ljava/util/regex/Pattern;", "pattern$annotations", "getPattern", "()Ljava/util/regex/Pattern;", "twoLine", "splitCell", "", "input", "markwon-maybe_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        public static /* synthetic */ void pattern$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pattern getPattern() {
            return MaybeTableProcessor.pattern;
        }

        public final List<String> splitCell(String input) {
            Intrinsics.checkParameterIsNotNull(input, "input");
            int indexOf$default = StringsKt.indexOf$default(input, '\n', 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                input = input.substring(0, indexOf$default);
                Intrinsics.checkExpressionValueIsNotNull(input, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            List<String> split$default = StringsKt.split$default(input, new char[]{'|'}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (String str : split$default) {
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                arrayList.add(StringsKt.trim(str).toString());
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            if ((!arrayList3.isEmpty()) && StringsKt.isBlank((CharSequence) CollectionsKt.last(arrayList2))) {
                arrayList2.remove(CollectionsKt.getLastIndex(arrayList2));
            }
            if ((true ^ arrayList3.isEmpty()) && StringsKt.isBlank((CharSequence) CollectionsKt.first(arrayList2))) {
                arrayList2.remove(0);
            }
            return arrayList2;
        }
    }

    static {
        Pattern compile = Pattern.compile("^\\|.*\\|.*$|^\\|([^\\|\\n]*\\|)+ ?\\n *\\|?[- :\\|]*$");
        Intrinsics.checkExpressionValueIsNotNull(compile, "Pattern.compile(\"$oneLine|$twoLine\")");
        pattern = compile;
    }
}
