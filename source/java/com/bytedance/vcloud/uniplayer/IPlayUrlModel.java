package com.bytedance.vcloud.uniplayer;

import com.bytedance.vcloud.uniplayer.IUrlModel;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PlayRequest.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/IPlayUrlModel;", "Lcom/bytedance/vcloud/uniplayer/IUrlModel;", "getAELoudness", "", "getAEPeak", "getAudioBitrates", "", "Lcom/bytedance/vcloud/uniplayer/IAudioBitrate;", "getBitrates", "Lcom/bytedance/vcloud/uniplayer/IBitrate;", "getCdnUrlExpiredTS", "", "getCodecType", "", "()Ljava/lang/Integer;", "getFormat", "", "getLogLabel", "getMediaDuration", "getNeedSetToken", "", "getVideoId", "getVideoMetaStr", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IPlayUrlModel extends IUrlModel {
    double getAELoudness();

    double getAEPeak();

    List<IAudioBitrate> getAudioBitrates();

    List<IBitrate> getBitrates();

    long getCdnUrlExpiredTS();

    Integer getCodecType();

    String getFormat();

    String getLogLabel();

    long getMediaDuration();

    boolean getNeedSetToken();

    String getVideoId();

    String getVideoMetaStr();

    /* compiled from: PlayRequest.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static double getAELoudness(IPlayUrlModel iPlayUrlModel) {
            return 0.0d;
        }

        public static double getAEPeak(IPlayUrlModel iPlayUrlModel) {
            return 0.0d;
        }

        public static List<IAudioBitrate> getAudioBitrates(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static List<IBitrate> getBitrates(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static long getCdnUrlExpiredTS(IPlayUrlModel iPlayUrlModel) {
            return 0L;
        }

        public static Integer getCodecType(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static String getFormat(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static long getMediaDuration(IPlayUrlModel iPlayUrlModel) {
            return 0L;
        }

        public static boolean getNeedSetToken(IPlayUrlModel iPlayUrlModel) {
            return false;
        }

        public static String getVideoId(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static String getVideoMetaStr(IPlayUrlModel iPlayUrlModel) {
            return null;
        }

        public static long getDataSize(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getDataSize(iPlayUrlModel);
        }

        public static String getDecryptionKey(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getDecryptionKey(iPlayUrlModel);
        }

        public static String getDecryptionKeyNotEncoded(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getDecryptionKeyNotEncoded(iPlayUrlModel);
        }

        public static String getFileCheckSum(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getFileCheckSum(iPlayUrlModel);
        }

        public static String getFileHash(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getFileHash(iPlayUrlModel);
        }

        public static String getUrlKey(IPlayUrlModel iPlayUrlModel) {
            return IUrlModel.DefaultImpls.getUrlKey(iPlayUrlModel);
        }
    }
}
