package com.ss.bytertc.engine.video;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class FovVideoFrameInfo {
    private int destColumn;
    private int destRow;
    private int hdColumn;
    private int hdHeight;
    private int hdRow;
    private int hdWidth;
    private int ldColumn;
    private int ldHeight;
    private int ldRow;
    private int ldWidth;
    private int tileHeight;
    private HashMap<Short, Short> tileMap = new HashMap<>();
    private int tileWidth;

    public static FovVideoFrameInfo genFovVideoFrameInfo() {
        return new FovVideoFrameInfo();
    }

    public HashMap<Short, Short> getTileMap() {
        return this.tileMap;
    }

    public int getHdWidth() {
        return this.hdWidth;
    }

    public int getHdHeight() {
        return this.hdHeight;
    }

    public int getLdWidth() {
        return this.ldWidth;
    }

    public int getLdHeight() {
        return this.ldHeight;
    }

    public int getTileWidth() {
        return this.tileWidth;
    }

    public int getTileHeight() {
        return this.tileHeight;
    }

    public int getHdRow() {
        return this.hdRow;
    }

    public int getHdColumn() {
        return this.hdColumn;
    }

    public int getLdRow() {
        return this.ldRow;
    }

    public int getLdColumn() {
        return this.ldColumn;
    }

    public int getDestRow() {
        return this.destRow;
    }

    public int getDestColumn() {
        return this.destColumn;
    }

    private void putTileMapValue(short key, short value) {
        this.tileMap.put(Short.valueOf(key), Short.valueOf(value));
    }

    private void setHdWidth(int width) {
        this.hdWidth = width;
    }

    private void setHdHeight(int height) {
        this.hdHeight = height;
    }

    private void setLdWidth(int width) {
        this.ldWidth = width;
    }

    private void setLdHeight(int height) {
        this.ldHeight = height;
    }

    private void setTileWidth(int width) {
        this.tileWidth = width;
    }

    private void setTileHeight(int height) {
        this.tileHeight = height;
    }

    private void setHdRow(int row) {
        this.hdRow = row;
    }

    private void setHdColumn(int column) {
        this.hdColumn = column;
    }

    private void setLdRow(int row) {
        this.ldRow = row;
    }

    private void setLdColumn(int column) {
        this.ldColumn = column;
    }

    private void setDestRow(int row) {
        this.destRow = row;
    }

    private void setDestColumn(int column) {
        this.destColumn = column;
    }
}
