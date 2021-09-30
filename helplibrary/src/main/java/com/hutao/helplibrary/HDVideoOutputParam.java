package com.hutao.helplibrary;

import java.util.Objects;

/**
 * @author: hutao
 * @date: 2021/9/30
 */
public class HDVideoOutputParam {
    // 视频宽
    private int dwVideoWidth;
    // 视频高，行为单位,为0表示无信号
    private int dwVideoHeight;
    // 逐行或隔行，TRUE=逐行；FALSE=隔行
    boolean bVideoProgressive;
    // 帧率，逐行时=场频，隔行时=场频/2，即60i=30P,为0表示无信号
    private float dwFrameRate;

    public HDVideoOutputParam(int dwVideoWidth, int dwVideoHeight, boolean bVideoProgressive, float dwFrameRate) {
        this.dwVideoWidth = dwVideoWidth;
        this.dwVideoHeight = dwVideoHeight;
        this.bVideoProgressive = bVideoProgressive;
        this.dwFrameRate = dwFrameRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HDVideoOutputParam that = (HDVideoOutputParam) o;
        return dwVideoWidth == that.dwVideoWidth &&
                dwVideoHeight == that.dwVideoHeight &&
                bVideoProgressive == that.bVideoProgressive &&
                dwFrameRate == that.dwFrameRate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dwVideoWidth, dwVideoHeight, bVideoProgressive, dwFrameRate);
    }

    @Override
    public String toString() {
        return "HDVideoOutputParam{" +
                "dwVideoWidth=" + dwVideoWidth +
                ", dwVideoHeight=" + dwVideoHeight +
                ", bVideoProgressive=" + bVideoProgressive +
                ", dwFrameRate=" + dwFrameRate +
                '}';
    }
}