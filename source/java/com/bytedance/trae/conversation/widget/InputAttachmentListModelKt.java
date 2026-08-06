package com.bytedance.trae.conversation.widget;

import com.bytedance.trae.conversation.mediachoose.model.MediaItem;
import kotlin.Metadata;

/* compiled from: InputAttachmentListModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"toAttachmentItem", "Lcom/bytedance/trae/conversation/widget/AttachmentItem;", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaItem;", "toMediaItem", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputAttachmentListModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AttachmentItem toAttachmentItem(MediaItem mediaItem) {
        return new AttachmentItem(mediaItem.getId(), mediaItem.getId(), mediaItem.getFileName(), mediaItem.getUri(), mediaItem.getMimeType(), mediaItem.getSizeBytes(), true, null, 0, null, null, 1920, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaItem toMediaItem(AttachmentItem attachmentItem) {
        return new MediaItem(attachmentItem.getBucketId(), attachmentItem.getUri(), attachmentItem.getMimeType(), 0L, 0L, "", 0, 0, attachmentItem.getSizeBytes(), false, attachmentItem.getFileName());
    }
}
