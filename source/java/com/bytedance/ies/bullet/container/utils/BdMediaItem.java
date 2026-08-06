package com.bytedance.ies.bullet.container.utils;

import android.net.Uri;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class BdMediaItem {
    private String album;
    private long albumId;
    private String artist;
    private long dateAdded;
    private long dateToken;
    private long duration;
    private long fileSize;
    private int height;
    private long id;
    private String mimeType;
    private long modify;
    private int musicType;
    private String name;
    private int orientation;
    private String relativePath;
    private String resolution;
    private String title;
    private Uri uri;
    private int width;

    public String toString() {
        return "BdMediaItem{id=" + this.id + ", name='" + this.name + "', modify=" + this.modify + ", dateAdded=" + this.dateAdded + ", mimeType='" + this.mimeType + "', duration=" + this.duration + ", fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ", musicType=" + this.musicType + ", uri=" + this.uri + ", relativePath='" + this.relativePath + "', dateToken=" + this.dateToken + ", orientation=" + this.orientation + ", resolution='" + this.resolution + "', album='" + this.album + "', artist='" + this.artist + "', title='" + this.title + "', albumId=" + this.albumId + AbstractJsonLexerKt.END_OBJ;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getModify() {
        return this.modify;
    }

    public void setModify(long j) {
        this.modify = j;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(long j) {
        this.dateAdded = j;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public long getDateToken() {
        return this.dateToken;
    }

    public void setDateToken(long j) {
        this.dateToken = j;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }
}
