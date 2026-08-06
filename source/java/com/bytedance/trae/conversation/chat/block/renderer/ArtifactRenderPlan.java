package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.im.model.ArtifactDiffInfo;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.FileDiffInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactRenderPlan.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ArtifactRenderPlan;", "", "<init>", "()V", "splitChangedCodes", "Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;", "data", "Lcom/bytedance/trae/im/model/ChangedFileData;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactRenderPlan {
    public static final ArtifactRenderPlan INSTANCE = new ArtifactRenderPlan();

    private ArtifactRenderPlan() {
    }

    public final ChangedCodeRenderPlan splitChangedCodes(ChangedFileData data) {
        ChangedFileData changedFileData = null;
        List<FileDiffInfo> fileDiffInfos = data != null ? data.getFileDiffInfos() : null;
        if (fileDiffInfos == null) {
            fileDiffInfos = CollectionsKt.emptyList();
        }
        if (fileDiffInfos.isEmpty()) {
            return new ChangedCodeRenderPlan(CollectionsKt.emptyList(), null);
        }
        List<FileDiffInfo> list = fileDiffInfos;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics.areEqual(((FileDiffInfo) obj).getHtmlRender(), true)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return new ChangedCodeRenderPlan(CollectionsKt.emptyList(), data);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!Intrinsics.areEqual(((FileDiffInfo) obj2).getHtmlRender(), true)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty() && data != null) {
            ArrayList arrayList5 = arrayList4;
            Iterator it = arrayList5.iterator();
            int i = 0;
            while (it.hasNext()) {
                Integer insertLineCount = ((FileDiffInfo) it.next()).getInsertLineCount();
                i += insertLineCount != null ? insertLineCount.intValue() : 0;
            }
            Integer valueOf = Integer.valueOf(i);
            Iterator it2 = arrayList5.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                Integer deleteLineCount = ((FileDiffInfo) it2.next()).getDeleteLineCount();
                i2 += deleteLineCount != null ? deleteLineCount.intValue() : 0;
            }
            changedFileData = data.copy(new ArtifactDiffInfo(null, valueOf, Integer.valueOf(i2), 1, null), arrayList4);
        }
        return new ChangedCodeRenderPlan(arrayList2, changedFileData);
    }
}
