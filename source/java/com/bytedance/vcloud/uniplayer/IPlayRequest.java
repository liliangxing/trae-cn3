package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: PlayRequest.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/IPlayRequest;", "", "getCover", "Lcom/bytedance/vcloud/uniplayer/IUrlModel;", "getLogLabel", "", "getPlayAddr", "Lcom/bytedance/vcloud/uniplayer/IPlayUrlModel;", "getSourceID", "getSourceTye", "Lcom/bytedance/vcloud/uniplayer/PlayContentType;", "getThumbInfo", "Lcom/bytedance/vcloud/uniplayer/IThumbInfoModel;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IPlayRequest {
    IUrlModel getCover();

    String getLogLabel();

    IPlayUrlModel getPlayAddr();

    String getSourceID();

    PlayContentType getSourceTye();

    IThumbInfoModel getThumbInfo();

    /* compiled from: PlayRequest.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static IUrlModel getCover(IPlayRequest iPlayRequest) {
            return null;
        }

        public static IThumbInfoModel getThumbInfo(IPlayRequest iPlayRequest) {
            return null;
        }

        public static PlayContentType getSourceTye(IPlayRequest iPlayRequest) {
            return PlayContentType.Vod;
        }
    }
}
