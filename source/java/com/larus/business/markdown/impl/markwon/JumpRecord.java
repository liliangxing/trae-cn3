package com.larus.business.markdown.impl.markwon;

import android.text.SpannableStringBuilder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.commonmark.node.Node;

/* compiled from: JumpRecord.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpRecord;", "", "node", "Lorg/commonmark/node/Node;", "depth", "", "id", "parentId", "(Lorg/commonmark/node/Node;III)V", "getDepth", "()I", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "getDirection", "()Ljava/lang/String;", "setDirection", "(Ljava/lang/String;)V", "getId", "getNode", "()Lorg/commonmark/node/Node;", "text", "getText", "setText", "length", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class JumpRecord {
    private static final boolean DEBUG = false;
    private final int depth;
    private String direction;
    private final int id;
    private final Node node;
    private final int parentId;
    private String text;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SPACE = StringsKt.repeat(" ", 2);

    public JumpRecord(Node node, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.node = node;
        this.depth = i;
        this.id = i2;
        this.parentId = i3;
        this.direction = "";
    }

    public final int getDepth() {
        return this.depth;
    }

    public final int getId() {
        return this.id;
    }

    public final Node getNode() {
        return this.node;
    }

    public final String getDirection() {
        return this.direction;
    }

    public final void setDirection(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.direction = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getText() {
        String str = this.text;
        if (str == null || str.length() == 0) {
            return this.id + ':' + JumpAnalyzer.INSTANCE.name$markdown_impl_release(this.node) + this.direction + this.parentId;
        }
        return this.text;
    }

    public final int length() {
        String text = getText();
        if (text != null) {
            return text.length();
        }
        return 0;
    }

    /* compiled from: JumpRecord.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0002\b\fJ\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\u001d\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/JumpRecord$Companion;", "", "()V", "DEBUG", "", "SPACE", "", "logHit", "", "pre", "Landroid/text/SpannableStringBuilder;", "curr", "logHit$markdown_impl_release", "logTree", "node", "Lorg/commonmark/node/Node;", "tag", "logTree$markdown_impl_release", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void logTree$markdown_impl_release(Node pre, Node curr) {
            Intrinsics.checkNotNullParameter(pre, "pre");
            Intrinsics.checkNotNullParameter(curr, "curr");
            boolean unused = JumpRecord.DEBUG;
        }

        public final void logHit$markdown_impl_release(SpannableStringBuilder pre, SpannableStringBuilder curr) {
            Intrinsics.checkNotNullParameter(pre, "pre");
            Intrinsics.checkNotNullParameter(curr, "curr");
            boolean unused = JumpRecord.DEBUG;
        }

        static /* synthetic */ void logTree$default(Companion companion, Node node, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            companion.logTree(node, str);
        }

        private final void logTree(Node node, String tag) {
            Collection arrayDeque = new ArrayDeque();
            arrayDeque.addLast(new JumpRecord(node, 0, 0, 0));
            ArrayList<JumpRecord> arrayList = new ArrayList();
            int i = 1;
            while (!arrayDeque.isEmpty()) {
                JumpRecord jumpRecord = (JumpRecord) arrayDeque.removeFirst();
                arrayList.add(jumpRecord);
                ArrayList arrayList2 = new ArrayList();
                Node node2 = jumpRecord.getNode().firstChild;
                while (node2 != null) {
                    JumpRecord jumpRecord2 = new JumpRecord(node2, jumpRecord.getDepth() + 1, i, jumpRecord.getId());
                    arrayDeque.addLast(jumpRecord2);
                    arrayList2.add(jumpRecord2);
                    node2 = node2.next;
                    i++;
                }
                if (arrayList2.size() == 1) {
                    ((JumpRecord) arrayList2.get(0)).setDirection("↑");
                } else {
                    int size = arrayList2.size() / 2;
                    int i2 = 0;
                    for (Object obj : arrayList2) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        ((JumpRecord) obj).setDirection(i2 < size ? "↗" : "↖");
                        i2 = i3;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("====>" + tag + " tree start");
            int i4 = -1;
            for (JumpRecord jumpRecord3 : arrayList) {
                if (jumpRecord3.getDepth() != i4) {
                    sb.append("\n");
                    i4 = jumpRecord3.getDepth();
                }
                sb.append(jumpRecord3.getText());
                sb.append(JumpRecord.SPACE);
            }
            sb.append("\n" + tag + " tree end<====\n");
        }
    }
}
