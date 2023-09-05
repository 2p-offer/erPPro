package com.warship.test.pandora.bar;

import java.util.Objects;

/** 宝石按照类型排序的信息 */
public class PerSubTypeSortInfo {
    int perType;
    int subType;
    int level;
    //是否镶嵌
    boolean mosaiced;
    //如果镶嵌，孔位信息
    int hole;

    public PerSubTypeSortInfo(int perType, int subType, int level, boolean mosaiced) {
        this.perType = perType;
        this.subType = subType;
        this.level = level;
        this.mosaiced = mosaiced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PerSubTypeSortInfo that = (PerSubTypeSortInfo) o;
        return perType == that.perType && subType == that.subType && level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(perType, subType, level);
    }

    public int getPerType() {
        return perType;
    }

    public void setPerType(int perType) {
        this.perType = perType;
    }

    public int getSubType() {
        return subType;
    }

    public void setSubType(int subType) {
        this.subType = subType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isMosaiced() {
        return mosaiced;
    }

    public void setMosaiced(boolean mosaiced) {
        this.mosaiced = mosaiced;
    }

    public int getHole() {
        return hole;
    }

    public void setHole(int hole) {
        this.hole = hole;
    }

    @Override
    public String toString() {
        return "PerSubTypeSortInfo{" +
                "perType=" + perType +
                ", subType=" + subType +
                ", level=" + level +
                ", mosaiced=" + mosaiced +
                ", hole=" + hole +
                '}';
    }
}
