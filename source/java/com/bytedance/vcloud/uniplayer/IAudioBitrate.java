package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.uniplayer.IBitrate;
import kotlin.Metadata;

/* compiled from: PlayRequest.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/IAudioBitrate;", "Lcom/bytedance/vcloud/uniplayer/IBitrate;", "getAudioBitrateMeta", "Lcom/bytedance/vcloud/uniplayer/IAudioBitrateMeta;", "getAudioQuality", "", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IAudioBitrate extends IBitrate {
    IAudioBitrateMeta getAudioBitrateMeta();

    int getAudioQuality();

    /* compiled from: PlayRequest.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static IAudioBitrateMeta getAudioBitrateMeta(IAudioBitrate iAudioBitrate) {
            return null;
        }

        public static int getAudioQuality(IAudioBitrate iAudioBitrate) {
            return 0;
        }

        public static String getDefinition(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getDefinition(iAudioBitrate);
        }

        public static String getFileId(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getFileId(iAudioBitrate);
        }

        public static int getFps(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getFps(iAudioBitrate);
        }

        public static String getGearName(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getGearName(iAudioBitrate);
        }

        public static String getPktOffsetMap(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getPktOffsetMap(iAudioBitrate);
        }

        public static IUrlModel getPlayAddr(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getPlayAddr(iAudioBitrate);
        }

        public static String getQuality(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getQuality(iAudioBitrate);
        }

        public static int getRealBitrate(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getRealBitrate(iAudioBitrate);
        }

        public static String getRelatedAudioFileId(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getRelatedAudioFileId(iAudioBitrate);
        }

        public static String getSubInfo(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.getSubInfo(iAudioBitrate);
        }

        public static Integer isByteVC1(IAudioBitrate iAudioBitrate) {
            return IBitrate.DefaultImpls.isByteVC1(iAudioBitrate);
        }
    }
}
