package com.appaugmentedreality.app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Forum (
        val name: String= "",
        val address: String= "",
        val region: String= "",
        val phone: String= "",
        val province: String= ""
) : Parcelable