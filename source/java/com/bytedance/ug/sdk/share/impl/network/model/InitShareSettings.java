package com.bytedance.ug.sdk.share.impl.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes4.dex */
public class InitShareSettings {

    @SerializedName("android12_token_detect_strategy")
    private List<List<String>> android12TokenDetectStrategy;

    @SerializedName("check_and_sign_channel")
    private List<String> checkAndSignChannelList;

    @SerializedName("album_parse_switch")
    private int mAlbumParseSwitch = 1;

    @SerializedName("qrcode_parse_switch")
    private int mQrcodeParseSwitch = 1;

    @SerializedName("hidden_mark_parse_switch")
    private int mHiddenMarkParseSwitch = 1;

    @SerializedName("token_parse_switch")
    private int mTextTokenParseSwitch = 1;

    @SerializedName("video_hidden_mark_switch")
    private int mVideoHiddenMarkSwitch = 1;

    @SerializedName("video_qrcode_switch")
    private int mVideoQrcodeSwitch = 1;

    @SerializedName("use_timon")
    private int useTimon = 0;

    public int getAlbumParseSwitch() {
        return this.mAlbumParseSwitch;
    }

    public void setAlbumParseSwitch(int i) {
        this.mAlbumParseSwitch = i;
    }

    public int getQrcodeParseSwitch() {
        return this.mQrcodeParseSwitch;
    }

    public void setQrcodeParseSwitch(int i) {
        this.mQrcodeParseSwitch = i;
    }

    public int getHiddenMarkParseSwitch() {
        return this.mHiddenMarkParseSwitch;
    }

    public void setHiddenMarkParseSwitch(int i) {
        this.mHiddenMarkParseSwitch = i;
    }

    public int getTextTokenParseSwitch() {
        return this.mTextTokenParseSwitch;
    }

    public void setTextTokenParseSwitch(int i) {
        this.mTextTokenParseSwitch = i;
    }

    public int getVideoHiddenMarkSwitch() {
        return this.mVideoHiddenMarkSwitch;
    }

    public void setVideoHiddenMarkSwitch(int i) {
        this.mVideoHiddenMarkSwitch = i;
    }

    public int getVideoQrcodeSwitch() {
        return this.mVideoQrcodeSwitch;
    }

    public void setVideoQrcodeSwitch(int i) {
        this.mVideoQrcodeSwitch = i;
    }

    public List<String> getCheckAndSignChannelList() {
        return this.checkAndSignChannelList;
    }

    public void setCheckAndSignChannelList(List<String> list) {
        this.checkAndSignChannelList = list;
    }

    public int getUseTimon() {
        return this.useTimon;
    }

    public void setUseTimon(int i) {
        this.useTimon = i;
    }

    public List<List<String>> getAndroid12TokenDetectStrategy() {
        return this.android12TokenDetectStrategy;
    }

    public void setAndroid12TokenDetectStrategy(List<List<String>> list) {
        this.android12TokenDetectStrategy = list;
    }
}
