package com.rmaro.friendsflightscanner.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rmaro on 24/04/2017.
 */

public class ReferencesCurrency {

    @SerializedName("Code")
    public String code;

    @SerializedName("Symbol")
    public String symbol;

    @SerializedName("ThousandsSeparator")
    public String thousandsSeparator;

    @SerializedName("DecimalSeparator")
    public String decimalSeparator;

    @SerializedName("DecimalDigits")
    public int decimalDigits;
}
