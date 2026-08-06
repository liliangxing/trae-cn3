package com.bytedance.trae.conversation.mediachoose.model;

import java.util.List;
import kotlin.Metadata;

/* compiled from: MediaChooseContract.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseContract;", "", "<init>", "()V", "EXTRA_CONFIG", "", "EXTRA_MAIN_COUNT", "EXTRA_MAX_SINGLE_SIZE", "EXTRA_MAX_TOTAL_SIZE", "EXTRA_INITIAL_SELECTED", "EXTRA_PREVIEW_ITEMS", "EXTRA_PREVIEW_INDEX", "EXTRA_PREVIEW_SELECTED_IDS", "EXTRA_PREVIEW_CONFIG", "EXTRA_PREVIEW_KEEP_ORIGIN", "RESULT_BACK", "", "RESULT_BACK_SELECTED_IDS", "RESULT_BACK_KEEP_ORIGIN", "RESULT_SELECTED", "RESULT_KEEP_ORIGIN", "RESULT_HAS_VIDEO", "previewItemsCache", "", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "getPreviewItemsCache", "()Ljava/util/List;", "setPreviewItemsCache", "(Ljava/util/List;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MediaChooseContract {
    public static final String EXTRA_CONFIG = "trae_media_choose_extra_config";
    public static final String EXTRA_INITIAL_SELECTED = "trae_media_choose_extra_initial_selected";
    public static final String EXTRA_MAIN_COUNT = "trae_media_choose_max_count";
    public static final String EXTRA_MAX_SINGLE_SIZE = "trae_media_choose_single_size";
    public static final String EXTRA_MAX_TOTAL_SIZE = "trae_media_choose_max_total_size";
    public static final String EXTRA_PREVIEW_CONFIG = "trae_media_choose_extra_preview_config";
    public static final String EXTRA_PREVIEW_INDEX = "trae_media_choose_extra_preview_index";
    public static final String EXTRA_PREVIEW_ITEMS = "trae_media_choose_extra_preview_items";
    public static final String EXTRA_PREVIEW_KEEP_ORIGIN = "trae_media_choose_extra_preview_keep_origin";
    public static final String EXTRA_PREVIEW_SELECTED_IDS = "trae_media_choose_extra_preview_selected_ids";
    public static final MediaChooseContract INSTANCE = new MediaChooseContract();
    public static final int RESULT_BACK = 2;
    public static final String RESULT_BACK_KEEP_ORIGIN = "trae_media_choose_result_back_keep_origin";
    public static final String RESULT_BACK_SELECTED_IDS = "trae_media_choose_result_back_selected_ids";
    public static final String RESULT_HAS_VIDEO = "trae_media_choose_result_has_video";
    public static final String RESULT_KEEP_ORIGIN = "trae_media_choose_result_keep_origin";
    public static final String RESULT_SELECTED = "trae_media_choose_result_selected";
    private static volatile List<MediaItem> previewItemsCache;

    private MediaChooseContract() {
    }

    public final List<MediaItem> getPreviewItemsCache() {
        return previewItemsCache;
    }

    public final void setPreviewItemsCache(List<MediaItem> list) {
        previewItemsCache = list;
    }
}
