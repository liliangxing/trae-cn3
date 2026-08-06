package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: PureShowWidgetToolcallGroupRenderer.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\f\n\u0000\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0002\u001a \u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002\u001a \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002\u001a\f\u0010\u0012\u001a\u00020\n*\u00020\u0013H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"PURE_SHOW_WIDGET_TOOL", "", "TAG_STYLE", "", "TAG_DIV", "TAG_SCRIPT", "pureShowWidgetPayload", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;", "hasBalancedWidgetTags", "", "html", "widgetTagId", "start", "end", "isSelfClosingTag", "from", "tagEnd", "isAsciiLetter", "", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetToolcallGroupRendererKt {
    private static final String PURE_SHOW_WIDGET_TOOL = "PureShowWidget";
    private static final int TAG_DIV = 2;
    private static final int TAG_SCRIPT = 3;
    private static final int TAG_STYLE = 1;

    private static final boolean isAsciiLetter(char c) {
        if ('a' <= c && c < '{') {
            return true;
        }
        return 'A' <= c && c < '[';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PureShowWidgetPayload pureShowWidgetPayload(AgentContentBlock.PureShowWidgetToolcallGroup pureShowWidgetToolcallGroup) {
        Object obj;
        List<AgentContentBlock> children = pureShowWidgetToolcallGroup.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : children) {
            if (obj2 instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AgentContentBlock.Toolcall) obj).getToolCallInfo().getName(), "PureShowWidget")) {
                break;
            }
        }
        AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) obj;
        if (toolcall == null) {
            return null;
        }
        return PureShowWidgetPayload.INSTANCE.from(toolcall.getToolCallInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a5, code lost:
    
        if (r5 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean hasBalancedWidgetTags(String str) {
        String str2;
        int indexOf$default;
        Integer num;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length() && (indexOf$default = StringsKt.indexOf$default((str2 = str), '<', i, false, 4, (Object) null)) >= 0) {
            if (StringsKt.startsWith$default(str, "<!--", indexOf$default, false, 4, (Object) null)) {
                int indexOf$default2 = StringsKt.indexOf$default(str2, "-->", indexOf$default + 4, false, 4, (Object) null);
                if (indexOf$default2 < 0) {
                    return arrayList.isEmpty();
                }
                i = indexOf$default2 + 3;
            } else {
                i = indexOf$default + 1;
                if (i >= str.length()) {
                    break;
                }
                boolean z = true;
                boolean z2 = str.charAt(i) == '/';
                int i2 = z2 ? i + 1 : i;
                while (i2 < str.length() && CharsKt.isWhitespace(str.charAt(i2))) {
                    i2++;
                }
                int i3 = i2;
                while (i3 < str.length() && isAsciiLetter(str.charAt(i3))) {
                    i3++;
                }
                if (i2 != i3) {
                    int widgetTagId = widgetTagId(str, i2, i3);
                    if (widgetTagId != 0) {
                        ArrayList arrayList2 = arrayList;
                        Integer num2 = (Integer) CollectionsKt.lastOrNull(arrayList2);
                        if (num2 != null) {
                            int intValue = num2.intValue();
                            if (intValue != 1 && intValue != 3) {
                                z = false;
                            }
                        }
                        num2 = null;
                        if (num2 == null || (z2 && widgetTagId == num2.intValue())) {
                            int indexOf$default3 = StringsKt.indexOf$default(str2, '>', i3, false, 4, (Object) null);
                            if (indexOf$default3 < 0) {
                                return false;
                            }
                            if (!z2 && isSelfClosingTag(str, i3, indexOf$default3)) {
                                return false;
                            }
                            if (z2) {
                                if (arrayList.isEmpty() || (num = (Integer) arrayList.remove(CollectionsKt.getLastIndex(arrayList2))) == null || num.intValue() != widgetTagId) {
                                    return false;
                                }
                            } else {
                                arrayList.add(Integer.valueOf(widgetTagId));
                            }
                            i = indexOf$default3 + 1;
                        }
                    }
                    i = i3;
                } else {
                    continue;
                }
            }
        }
        return arrayList.isEmpty();
    }

    private static final int widgetTagId(String str, int i, int i2) {
        int i3 = i2 - i;
        if (i3 != 3) {
            if (i3 == 5) {
                if (StringsKt.regionMatches(str, i, "style", 0, 5, true)) {
                    return 1;
                }
            } else if (i3 == 6 && StringsKt.regionMatches(str, i, "script", 0, 6, true)) {
                return 3;
            }
        } else if (StringsKt.regionMatches(str, i, "div", 0, 3, true)) {
            return 2;
        }
        return 0;
    }

    private static final boolean isSelfClosingTag(String str, int i, int i2) {
        int i3 = i2 - 1;
        while (i3 >= i && CharsKt.isWhitespace(str.charAt(i3))) {
            i3--;
        }
        return i3 >= i && str.charAt(i3) == '/';
    }
}
