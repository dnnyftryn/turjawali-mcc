package com.aplikasi.mcc.helper

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

class Base64Helper {

    companion object {
        var instance: Base64Helper = Base64Helper()
        val encoded = ArrayList<String>()
    }


    fun getInstance(): Base64Helper? {
        if (instance == null) {
            instance = Base64Helper()
        }
        instance.reset()
        return instance
    }

    fun encode(imageBitmap: Bitmap, asPNG: Boolean, quality: Int): String? {
        val b = ByteArrayOutputStream()
        imageBitmap.compress(
            if (asPNG) Bitmap.CompressFormat.PNG else Bitmap.CompressFormat.JPEG,
            quality,
            b
        )
        return Base64.encodeToString(b.toByteArray(), Base64.DEFAULT)
    }

    fun reset() {
        encoded.clear()
    }
}