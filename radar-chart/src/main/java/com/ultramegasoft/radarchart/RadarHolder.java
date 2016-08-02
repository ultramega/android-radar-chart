/*
 * The MIT License (MIT)
 * Copyright © 2016 Steve Guidetti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ultramegasoft.radarchart;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Holds the data associated with a data point on a {@link RadarView}.
 * <p>
 * Each instance consists of an immutable name field and a mutable value field.
 *
 * @author Steve Guidetti
 */
public class RadarHolder implements Parcelable {
    public static final Creator<RadarHolder> CREATOR = new Creator<RadarHolder>() {
        @Override
        public RadarHolder createFromParcel(Parcel in) {
            return new RadarHolder(in);
        }

        @Override
        public RadarHolder[] newArray(int size) {
            return new RadarHolder[size];
        }
    };

    /**
     * The name of this item
     * <p>
     * This is rendered as the label of the item on the {@link RadarView}.
     */
    public final String name;

    /**
     * The value of this item
     * <p>
     * This is rendered as the distance of the polygon from the center of the {@link RadarView}.
     */
    public int value;

    /**
     * Construct a new {@link RadarHolder}.
     *
     * @param name  The name of this item
     * @param value The value of this item
     */
    public RadarHolder(String name, int value) {
        this.name = name;
        this.value = value;
    }

    private RadarHolder(Parcel in) {
        this(in.readString(), in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(value);
    }

}
