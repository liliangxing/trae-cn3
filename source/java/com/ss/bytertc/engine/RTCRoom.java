package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.ForwardStreamInfo;
import com.ss.bytertc.engine.data.SimulcastStreamType;
import com.ss.bytertc.engine.handler.IRTCRoomEventHandler;
import com.ss.bytertc.engine.type.AudioSelectionPriority;
import com.ss.bytertc.engine.type.SubtitleConfig;
import com.ss.bytertc.engine.video.IPanoramicVideo;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class RTCRoom extends RTSRoom {
    @Override // com.ss.bytertc.engine.RTSRoom
    public abstract void destroy();

    public abstract int enableSubscribeLocalStream(boolean enable);

    public abstract IPanoramicVideo getPanoramicVideo();

    public abstract IRangeAudio getRangeAudio();

    public abstract String getRoomId();

    public abstract ISpatialAudio getSpatialAudio();

    public abstract int joinRoom(String token, UserInfo userInfo, boolean userVisibility, RTCRoomConfig roomConfig);

    public abstract int leaveRoom(String extraInfo);

    public abstract int pauseAllSubscribedStreamAudio();

    public abstract int pauseAllSubscribedStreamVideo();

    public abstract int pauseForwardStreamToAllRooms();

    public abstract int publishScreenAudio(boolean publish);

    public abstract int publishScreenVideo(boolean publish);

    public abstract int publishStreamAudio(boolean publish);

    public abstract int publishStreamVideo(boolean publish);

    public abstract int resumeAllSubscribedStreamAudio();

    public abstract int resumeAllSubscribedStreamVideo();

    public abstract int resumeForwardStreamToAllRooms();

    public abstract long sendControlBinaryMessage(String type, String action, byte[] buffer);

    public abstract int setAudioSelectionConfig(AudioSelectionPriority audioSelectionPriority);

    public abstract int setMultiDeviceAVSync(String audioUserId);

    public abstract int setRTCRoomEventHandler(IRTCRoomEventHandler rtcRoomEventHandler);

    public abstract int setRemoteRoomAudioPlaybackVolume(int volume);

    public abstract int setRemoteSimulcastStreamType(String userId, SimulcastStreamType streamType);

    public abstract long setRoomExtraInfo(String key, String value);

    public abstract int setUserVisibility(boolean enable);

    public abstract int startForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos);

    public abstract int startForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos, String roomGroupId);

    public abstract int startSubtitle(SubtitleConfig subtitleConfig);

    public abstract int stopForwardStreamToRooms();

    public abstract int stopSubtitle();

    public abstract int subscribeAllStreamsAudio(boolean subscribe);

    public abstract int subscribeAllStreamsVideo(boolean subscribe);

    public abstract int subscribeScreenAudio(String userId, boolean subscribe);

    public abstract int subscribeScreenVideo(String userId, boolean subscribe);

    public abstract int subscribeStreamAudio(String userId, boolean subscribe);

    public abstract int subscribeStreamVideo(String userId, boolean subscribe);

    public abstract int updateForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos);

    public abstract int updateForwardStreamToRooms(List<ForwardStreamInfo> forwardStreamInfos, String roomGroupId);
}
