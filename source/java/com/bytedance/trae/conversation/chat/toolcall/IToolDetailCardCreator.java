package com.bytedance.trae.conversation.chat.toolcall;

import android.content.Context;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import kotlin.Metadata;

/* compiled from: IToolDetailCardCreator.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/IToolDetailCardCreator;", "", "createDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IToolDetailCardCreator {
    ToolDetailCard createDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext);

    /* compiled from: IToolDetailCardCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ ToolDetailCard createDetail$default(IToolDetailCardCreator iToolDetailCardCreator, Context context, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDetail");
            }
            if ((i & 4) != 0) {
                planItemContext = null;
            }
            return iToolDetailCardCreator.createDetail(context, parsedToolCallInfo, planItemContext);
        }
    }
}
