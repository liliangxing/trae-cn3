package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.im.model.ChangedFileData;
import com.bytedance.trae.im.model.FileDiffInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArtifactRenderPlan.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ChangedCodeRenderPlan;", "", "htmlPreviewFiles", "", "Lcom/bytedance/trae/im/model/FileDiffInfo;", "regularChangedCodes", "Lcom/bytedance/trae/im/model/ChangedFileData;", "<init>", "(Ljava/util/List;Lcom/bytedance/trae/im/model/ChangedFileData;)V", "getHtmlPreviewFiles", "()Ljava/util/List;", "getRegularChangedCodes", "()Lcom/bytedance/trae/im/model/ChangedFileData;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChangedCodeRenderPlan {
    private final List<FileDiffInfo> htmlPreviewFiles;
    private final ChangedFileData regularChangedCodes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChangedCodeRenderPlan copy$default(ChangedCodeRenderPlan changedCodeRenderPlan, List list, ChangedFileData changedFileData, int i, Object obj) {
        if ((i & 1) != 0) {
            list = changedCodeRenderPlan.htmlPreviewFiles;
        }
        if ((i & 2) != 0) {
            changedFileData = changedCodeRenderPlan.regularChangedCodes;
        }
        return changedCodeRenderPlan.copy(list, changedFileData);
    }

    public final List<FileDiffInfo> component1() {
        return this.htmlPreviewFiles;
    }

    /* renamed from: component2, reason: from getter */
    public final ChangedFileData getRegularChangedCodes() {
        return this.regularChangedCodes;
    }

    public final ChangedCodeRenderPlan copy(List<FileDiffInfo> htmlPreviewFiles, ChangedFileData regularChangedCodes) {
        Intrinsics.checkNotNullParameter(htmlPreviewFiles, "htmlPreviewFiles");
        return new ChangedCodeRenderPlan(htmlPreviewFiles, regularChangedCodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChangedCodeRenderPlan)) {
            return false;
        }
        ChangedCodeRenderPlan changedCodeRenderPlan = (ChangedCodeRenderPlan) other;
        return Intrinsics.areEqual(this.htmlPreviewFiles, changedCodeRenderPlan.htmlPreviewFiles) && Intrinsics.areEqual(this.regularChangedCodes, changedCodeRenderPlan.regularChangedCodes);
    }

    public int hashCode() {
        int hashCode = this.htmlPreviewFiles.hashCode() * 31;
        ChangedFileData changedFileData = this.regularChangedCodes;
        return hashCode + (changedFileData == null ? 0 : changedFileData.hashCode());
    }

    public String toString() {
        return "ChangedCodeRenderPlan(htmlPreviewFiles=" + this.htmlPreviewFiles + ", regularChangedCodes=" + this.regularChangedCodes + ')';
    }

    public ChangedCodeRenderPlan(List<FileDiffInfo> htmlPreviewFiles, ChangedFileData changedFileData) {
        Intrinsics.checkNotNullParameter(htmlPreviewFiles, "htmlPreviewFiles");
        this.htmlPreviewFiles = htmlPreviewFiles;
        this.regularChangedCodes = changedFileData;
    }

    public final List<FileDiffInfo> getHtmlPreviewFiles() {
        return this.htmlPreviewFiles;
    }

    public final ChangedFileData getRegularChangedCodes() {
        return this.regularChangedCodes;
    }
}
