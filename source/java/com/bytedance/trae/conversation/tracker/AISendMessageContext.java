package com.bytedance.trae.conversation.tracker;

import com.bytedance.forest.model.PreloadConfig;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.ss.ttm.utils.AVLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAITracker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\bq\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0005HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u000bHÆ\u0003J\t\u0010c\u001a\u00020\u000bHÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u000bHÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\t\u0010g\u001a\u00020\u000bHÆ\u0003J\t\u0010h\u001a\u00020\u000bHÆ\u0003J\t\u0010i\u001a\u00020\u000bHÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\t\u0010k\u001a\u00020\u000bHÆ\u0003J\t\u0010l\u001a\u00020\u000bHÆ\u0003J\t\u0010m\u001a\u00020\u000bHÆ\u0003J\t\u0010n\u001a\u00020\u000bHÆ\u0003J\t\u0010o\u001a\u00020\u000bHÆ\u0003J\t\u0010p\u001a\u00020\u000bHÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\t\u0010r\u001a\u00020\u000bHÆ\u0003J\t\u0010s\u001a\u00020\u000bHÆ\u0003J\t\u0010t\u001a\u00020\u000bHÆ\u0003J\t\u0010u\u001a\u00020\u000bHÆ\u0003J\t\u0010v\u001a\u00020\u000bHÆ\u0003J\u0097\u0002\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010x\u001a\u00020\u00052\b\u0010y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010z\u001a\u00020\u000bHÖ\u0001J\t\u0010{\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010'\"\u0004\b.\u0010)R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010'\"\u0004\b/\u0010)R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00101\"\u0004\b;\u00103R\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00101\"\u0004\b=\u00103R\u001a\u0010\u0011\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00101\"\u0004\b?\u00103R\u001a\u0010\u0012\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00101\"\u0004\bA\u00103R\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00101\"\u0004\bC\u00103R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00101\"\u0004\bE\u00103R\u001a\u0010\u0015\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00101\"\u0004\bG\u00103R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00101\"\u0004\bI\u00103R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00101\"\u0004\bM\u00103R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00101\"\u0004\bO\u00103R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010#\"\u0004\bQ\u0010%R\u001a\u0010\u001b\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00101\"\u0004\bS\u00103R\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u00101\"\u0004\bU\u00103R\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00101\"\u0004\bW\u00103R\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00101\"\u0004\bY\u00103R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00101\"\u0004\b[\u00103¨\u0006|"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/AISendMessageContext;", "", "envDeployment", "", "hasGit", "", "gitType", "remoteEnv", "isSpecMode", "isPlanMode", "skillCount", "", "rulesCount", "commandType", "fileCount", "folderCount", "fileWithCommentCount", "dataTextCount", "dataTextWithCommentCount", "dataSheetCount", "dataSheetWithCommentCount", "markdownCount", "markdownWithComment", "codeSelectionCount", "webUrlCount", "webElementCount", "mentionType", "logItemCount", DecodeProducer.EXTRA_IMAGE_COUNT, "asrCount", "attachmentCount", "pluginCount", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZZIILjava/lang/String;IIIIIIIIIIIILjava/lang/String;IIIII)V", "getEnvDeployment", "()Ljava/lang/String;", "setEnvDeployment", "(Ljava/lang/String;)V", "getHasGit", "()Z", "setHasGit", "(Z)V", "getGitType", "setGitType", "getRemoteEnv", "setRemoteEnv", "setSpecMode", "setPlanMode", "getSkillCount", "()I", "setSkillCount", "(I)V", "getRulesCount", "setRulesCount", "getCommandType", "setCommandType", "getFileCount", "setFileCount", "getFolderCount", "setFolderCount", "getFileWithCommentCount", "setFileWithCommentCount", "getDataTextCount", "setDataTextCount", "getDataTextWithCommentCount", "setDataTextWithCommentCount", "getDataSheetCount", "setDataSheetCount", "getDataSheetWithCommentCount", "setDataSheetWithCommentCount", "getMarkdownCount", "setMarkdownCount", "getMarkdownWithComment", "setMarkdownWithComment", "getCodeSelectionCount", "setCodeSelectionCount", "getWebUrlCount", "setWebUrlCount", "getWebElementCount", "setWebElementCount", "getMentionType", "setMentionType", "getLogItemCount", "setLogItemCount", "getImageCount", "setImageCount", "getAsrCount", "setAsrCount", "getAttachmentCount", "setAttachmentCount", "getPluginCount", "setPluginCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AISendMessageContext {
    private int asrCount;
    private int attachmentCount;
    private int codeSelectionCount;
    private String commandType;
    private int dataSheetCount;
    private int dataSheetWithCommentCount;
    private int dataTextCount;
    private int dataTextWithCommentCount;
    private String envDeployment;
    private int fileCount;
    private int fileWithCommentCount;
    private int folderCount;
    private String gitType;
    private boolean hasGit;
    private int imageCount;
    private boolean isPlanMode;
    private boolean isSpecMode;
    private int logItemCount;
    private int markdownCount;
    private int markdownWithComment;
    private String mentionType;
    private int pluginCount;
    private String remoteEnv;
    private int rulesCount;
    private int skillCount;
    private int webElementCount;
    private int webUrlCount;

    public AISendMessageContext() {
        this(null, false, null, null, false, false, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 134217727, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEnvDeployment() {
        return this.envDeployment;
    }

    /* renamed from: component10, reason: from getter */
    public final int getFileCount() {
        return this.fileCount;
    }

    /* renamed from: component11, reason: from getter */
    public final int getFolderCount() {
        return this.folderCount;
    }

    /* renamed from: component12, reason: from getter */
    public final int getFileWithCommentCount() {
        return this.fileWithCommentCount;
    }

    /* renamed from: component13, reason: from getter */
    public final int getDataTextCount() {
        return this.dataTextCount;
    }

    /* renamed from: component14, reason: from getter */
    public final int getDataTextWithCommentCount() {
        return this.dataTextWithCommentCount;
    }

    /* renamed from: component15, reason: from getter */
    public final int getDataSheetCount() {
        return this.dataSheetCount;
    }

    /* renamed from: component16, reason: from getter */
    public final int getDataSheetWithCommentCount() {
        return this.dataSheetWithCommentCount;
    }

    /* renamed from: component17, reason: from getter */
    public final int getMarkdownCount() {
        return this.markdownCount;
    }

    /* renamed from: component18, reason: from getter */
    public final int getMarkdownWithComment() {
        return this.markdownWithComment;
    }

    /* renamed from: component19, reason: from getter */
    public final int getCodeSelectionCount() {
        return this.codeSelectionCount;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasGit() {
        return this.hasGit;
    }

    /* renamed from: component20, reason: from getter */
    public final int getWebUrlCount() {
        return this.webUrlCount;
    }

    /* renamed from: component21, reason: from getter */
    public final int getWebElementCount() {
        return this.webElementCount;
    }

    /* renamed from: component22, reason: from getter */
    public final String getMentionType() {
        return this.mentionType;
    }

    /* renamed from: component23, reason: from getter */
    public final int getLogItemCount() {
        return this.logItemCount;
    }

    /* renamed from: component24, reason: from getter */
    public final int getImageCount() {
        return this.imageCount;
    }

    /* renamed from: component25, reason: from getter */
    public final int getAsrCount() {
        return this.asrCount;
    }

    /* renamed from: component26, reason: from getter */
    public final int getAttachmentCount() {
        return this.attachmentCount;
    }

    /* renamed from: component27, reason: from getter */
    public final int getPluginCount() {
        return this.pluginCount;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGitType() {
        return this.gitType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getRemoteEnv() {
        return this.remoteEnv;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSpecMode() {
        return this.isSpecMode;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsPlanMode() {
        return this.isPlanMode;
    }

    /* renamed from: component7, reason: from getter */
    public final int getSkillCount() {
        return this.skillCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRulesCount() {
        return this.rulesCount;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCommandType() {
        return this.commandType;
    }

    public final AISendMessageContext copy(String envDeployment, boolean hasGit, String gitType, String remoteEnv, boolean isSpecMode, boolean isPlanMode, int skillCount, int rulesCount, String commandType, int fileCount, int folderCount, int fileWithCommentCount, int dataTextCount, int dataTextWithCommentCount, int dataSheetCount, int dataSheetWithCommentCount, int markdownCount, int markdownWithComment, int codeSelectionCount, int webUrlCount, int webElementCount, String mentionType, int logItemCount, int imageCount, int asrCount, int attachmentCount, int pluginCount) {
        Intrinsics.checkNotNullParameter(envDeployment, "envDeployment");
        Intrinsics.checkNotNullParameter(gitType, "gitType");
        Intrinsics.checkNotNullParameter(remoteEnv, "remoteEnv");
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        Intrinsics.checkNotNullParameter(mentionType, "mentionType");
        return new AISendMessageContext(envDeployment, hasGit, gitType, remoteEnv, isSpecMode, isPlanMode, skillCount, rulesCount, commandType, fileCount, folderCount, fileWithCommentCount, dataTextCount, dataTextWithCommentCount, dataSheetCount, dataSheetWithCommentCount, markdownCount, markdownWithComment, codeSelectionCount, webUrlCount, webElementCount, mentionType, logItemCount, imageCount, asrCount, attachmentCount, pluginCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AISendMessageContext)) {
            return false;
        }
        AISendMessageContext aISendMessageContext = (AISendMessageContext) other;
        return Intrinsics.areEqual(this.envDeployment, aISendMessageContext.envDeployment) && this.hasGit == aISendMessageContext.hasGit && Intrinsics.areEqual(this.gitType, aISendMessageContext.gitType) && Intrinsics.areEqual(this.remoteEnv, aISendMessageContext.remoteEnv) && this.isSpecMode == aISendMessageContext.isSpecMode && this.isPlanMode == aISendMessageContext.isPlanMode && this.skillCount == aISendMessageContext.skillCount && this.rulesCount == aISendMessageContext.rulesCount && Intrinsics.areEqual(this.commandType, aISendMessageContext.commandType) && this.fileCount == aISendMessageContext.fileCount && this.folderCount == aISendMessageContext.folderCount && this.fileWithCommentCount == aISendMessageContext.fileWithCommentCount && this.dataTextCount == aISendMessageContext.dataTextCount && this.dataTextWithCommentCount == aISendMessageContext.dataTextWithCommentCount && this.dataSheetCount == aISendMessageContext.dataSheetCount && this.dataSheetWithCommentCount == aISendMessageContext.dataSheetWithCommentCount && this.markdownCount == aISendMessageContext.markdownCount && this.markdownWithComment == aISendMessageContext.markdownWithComment && this.codeSelectionCount == aISendMessageContext.codeSelectionCount && this.webUrlCount == aISendMessageContext.webUrlCount && this.webElementCount == aISendMessageContext.webElementCount && Intrinsics.areEqual(this.mentionType, aISendMessageContext.mentionType) && this.logItemCount == aISendMessageContext.logItemCount && this.imageCount == aISendMessageContext.imageCount && this.asrCount == aISendMessageContext.asrCount && this.attachmentCount == aISendMessageContext.attachmentCount && this.pluginCount == aISendMessageContext.pluginCount;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.envDeployment.hashCode() * 31) + Boolean.hashCode(this.hasGit)) * 31) + this.gitType.hashCode()) * 31) + this.remoteEnv.hashCode()) * 31) + Boolean.hashCode(this.isSpecMode)) * 31) + Boolean.hashCode(this.isPlanMode)) * 31) + Integer.hashCode(this.skillCount)) * 31) + Integer.hashCode(this.rulesCount)) * 31) + this.commandType.hashCode()) * 31) + Integer.hashCode(this.fileCount)) * 31) + Integer.hashCode(this.folderCount)) * 31) + Integer.hashCode(this.fileWithCommentCount)) * 31) + Integer.hashCode(this.dataTextCount)) * 31) + Integer.hashCode(this.dataTextWithCommentCount)) * 31) + Integer.hashCode(this.dataSheetCount)) * 31) + Integer.hashCode(this.dataSheetWithCommentCount)) * 31) + Integer.hashCode(this.markdownCount)) * 31) + Integer.hashCode(this.markdownWithComment)) * 31) + Integer.hashCode(this.codeSelectionCount)) * 31) + Integer.hashCode(this.webUrlCount)) * 31) + Integer.hashCode(this.webElementCount)) * 31) + this.mentionType.hashCode()) * 31) + Integer.hashCode(this.logItemCount)) * 31) + Integer.hashCode(this.imageCount)) * 31) + Integer.hashCode(this.asrCount)) * 31) + Integer.hashCode(this.attachmentCount)) * 31) + Integer.hashCode(this.pluginCount);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AISendMessageContext(envDeployment=");
        sb.append(this.envDeployment).append(", hasGit=").append(this.hasGit).append(", gitType=").append(this.gitType).append(", remoteEnv=").append(this.remoteEnv).append(", isSpecMode=").append(this.isSpecMode).append(", isPlanMode=").append(this.isPlanMode).append(", skillCount=").append(this.skillCount).append(", rulesCount=").append(this.rulesCount).append(", commandType=").append(this.commandType).append(", fileCount=").append(this.fileCount).append(", folderCount=").append(this.folderCount).append(", fileWithCommentCount=");
        sb.append(this.fileWithCommentCount).append(", dataTextCount=").append(this.dataTextCount).append(", dataTextWithCommentCount=").append(this.dataTextWithCommentCount).append(", dataSheetCount=").append(this.dataSheetCount).append(", dataSheetWithCommentCount=").append(this.dataSheetWithCommentCount).append(", markdownCount=").append(this.markdownCount).append(", markdownWithComment=").append(this.markdownWithComment).append(", codeSelectionCount=").append(this.codeSelectionCount).append(", webUrlCount=").append(this.webUrlCount).append(", webElementCount=").append(this.webElementCount).append(", mentionType=").append(this.mentionType).append(", logItemCount=").append(this.logItemCount);
        sb.append(", imageCount=").append(this.imageCount).append(", asrCount=").append(this.asrCount).append(", attachmentCount=").append(this.attachmentCount).append(", pluginCount=").append(this.pluginCount).append(')');
        return sb.toString();
    }

    public AISendMessageContext(String envDeployment, boolean z, String gitType, String remoteEnv, boolean z2, boolean z3, int i, int i2, String commandType, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String mentionType, int i15, int i16, int i17, int i18, int i19) {
        Intrinsics.checkNotNullParameter(envDeployment, "envDeployment");
        Intrinsics.checkNotNullParameter(gitType, "gitType");
        Intrinsics.checkNotNullParameter(remoteEnv, "remoteEnv");
        Intrinsics.checkNotNullParameter(commandType, "commandType");
        Intrinsics.checkNotNullParameter(mentionType, "mentionType");
        this.envDeployment = envDeployment;
        this.hasGit = z;
        this.gitType = gitType;
        this.remoteEnv = remoteEnv;
        this.isSpecMode = z2;
        this.isPlanMode = z3;
        this.skillCount = i;
        this.rulesCount = i2;
        this.commandType = commandType;
        this.fileCount = i3;
        this.folderCount = i4;
        this.fileWithCommentCount = i5;
        this.dataTextCount = i6;
        this.dataTextWithCommentCount = i7;
        this.dataSheetCount = i8;
        this.dataSheetWithCommentCount = i9;
        this.markdownCount = i10;
        this.markdownWithComment = i11;
        this.codeSelectionCount = i12;
        this.webUrlCount = i13;
        this.webElementCount = i14;
        this.mentionType = mentionType;
        this.logItemCount = i15;
        this.imageCount = i16;
        this.asrCount = i17;
        this.attachmentCount = i18;
        this.pluginCount = i19;
    }

    public /* synthetic */ AISendMessageContext(String str, boolean z, String str2, String str3, boolean z2, boolean z3, int i, int i2, String str4, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str5, int i15, int i16, int i17, int i18, int i19, int i20, DefaultConstructorMarker defaultConstructorMarker) {
        this((i20 & 1) != 0 ? "" : str, (i20 & 2) != 0 ? false : z, (i20 & 4) != 0 ? "" : str2, (i20 & 8) != 0 ? "" : str3, (i20 & 16) != 0 ? false : z2, (i20 & 32) != 0 ? false : z3, (i20 & 64) != 0 ? 0 : i, (i20 & 128) != 0 ? 0 : i2, (i20 & 256) != 0 ? "" : str4, (i20 & 512) != 0 ? 0 : i3, (i20 & 1024) != 0 ? 0 : i4, (i20 & 2048) != 0 ? 0 : i5, (i20 & 4096) != 0 ? 0 : i6, (i20 & 8192) != 0 ? 0 : i7, (i20 & 16384) != 0 ? 0 : i8, (i20 & 32768) != 0 ? 0 : i9, (i20 & 65536) != 0 ? 0 : i10, (i20 & 131072) != 0 ? 0 : i11, (i20 & 262144) != 0 ? 0 : i12, (i20 & 524288) != 0 ? 0 : i13, (i20 & 1048576) != 0 ? 0 : i14, (i20 & 2097152) != 0 ? "" : str5, (i20 & 4194304) != 0 ? 0 : i15, (i20 & 8388608) != 0 ? 0 : i16, (i20 & 16777216) != 0 ? 0 : i17, (i20 & AVLogger.LEVEL_LOG_INFO) != 0 ? 0 : i18, (i20 & 67108864) != 0 ? 0 : i19);
    }

    public final String getEnvDeployment() {
        return this.envDeployment;
    }

    public final void setEnvDeployment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.envDeployment = str;
    }

    public final boolean getHasGit() {
        return this.hasGit;
    }

    public final void setHasGit(boolean z) {
        this.hasGit = z;
    }

    public final String getGitType() {
        return this.gitType;
    }

    public final void setGitType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gitType = str;
    }

    public final String getRemoteEnv() {
        return this.remoteEnv;
    }

    public final void setRemoteEnv(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.remoteEnv = str;
    }

    public final boolean isSpecMode() {
        return this.isSpecMode;
    }

    public final void setSpecMode(boolean z) {
        this.isSpecMode = z;
    }

    public final boolean isPlanMode() {
        return this.isPlanMode;
    }

    public final void setPlanMode(boolean z) {
        this.isPlanMode = z;
    }

    public final int getSkillCount() {
        return this.skillCount;
    }

    public final void setSkillCount(int i) {
        this.skillCount = i;
    }

    public final int getRulesCount() {
        return this.rulesCount;
    }

    public final void setRulesCount(int i) {
        this.rulesCount = i;
    }

    public final String getCommandType() {
        return this.commandType;
    }

    public final void setCommandType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.commandType = str;
    }

    public final int getFileCount() {
        return this.fileCount;
    }

    public final void setFileCount(int i) {
        this.fileCount = i;
    }

    public final int getFolderCount() {
        return this.folderCount;
    }

    public final void setFolderCount(int i) {
        this.folderCount = i;
    }

    public final int getFileWithCommentCount() {
        return this.fileWithCommentCount;
    }

    public final void setFileWithCommentCount(int i) {
        this.fileWithCommentCount = i;
    }

    public final int getDataTextCount() {
        return this.dataTextCount;
    }

    public final void setDataTextCount(int i) {
        this.dataTextCount = i;
    }

    public final int getDataTextWithCommentCount() {
        return this.dataTextWithCommentCount;
    }

    public final void setDataTextWithCommentCount(int i) {
        this.dataTextWithCommentCount = i;
    }

    public final int getDataSheetCount() {
        return this.dataSheetCount;
    }

    public final void setDataSheetCount(int i) {
        this.dataSheetCount = i;
    }

    public final int getDataSheetWithCommentCount() {
        return this.dataSheetWithCommentCount;
    }

    public final void setDataSheetWithCommentCount(int i) {
        this.dataSheetWithCommentCount = i;
    }

    public final int getMarkdownCount() {
        return this.markdownCount;
    }

    public final void setMarkdownCount(int i) {
        this.markdownCount = i;
    }

    public final int getMarkdownWithComment() {
        return this.markdownWithComment;
    }

    public final void setMarkdownWithComment(int i) {
        this.markdownWithComment = i;
    }

    public final int getCodeSelectionCount() {
        return this.codeSelectionCount;
    }

    public final void setCodeSelectionCount(int i) {
        this.codeSelectionCount = i;
    }

    public final int getWebUrlCount() {
        return this.webUrlCount;
    }

    public final void setWebUrlCount(int i) {
        this.webUrlCount = i;
    }

    public final int getWebElementCount() {
        return this.webElementCount;
    }

    public final void setWebElementCount(int i) {
        this.webElementCount = i;
    }

    public final String getMentionType() {
        return this.mentionType;
    }

    public final void setMentionType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mentionType = str;
    }

    public final int getLogItemCount() {
        return this.logItemCount;
    }

    public final void setLogItemCount(int i) {
        this.logItemCount = i;
    }

    public final int getImageCount() {
        return this.imageCount;
    }

    public final void setImageCount(int i) {
        this.imageCount = i;
    }

    public final int getAsrCount() {
        return this.asrCount;
    }

    public final void setAsrCount(int i) {
        this.asrCount = i;
    }

    public final int getAttachmentCount() {
        return this.attachmentCount;
    }

    public final void setAttachmentCount(int i) {
        this.attachmentCount = i;
    }

    public final int getPluginCount() {
        return this.pluginCount;
    }

    public final void setPluginCount(int i) {
        this.pluginCount = i;
    }
}
