package com.lastreacts.filteredfeeded.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

fun Context.isConnectedToNetwork(): Boolean {
    try {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.let { cm ->
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                cm.activeNetworkInfo?.let { ni ->
                    return ni.isConnected && (ni.type == ConnectivityManager.TYPE_WIFI || ni.type == ConnectivityManager.TYPE_MOBILE)
                }
            } else {
                cm.activeNetwork?.let { n ->
                    cm.getNetworkCapabilities(n)?.let { nc ->
                        return nc.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(
                            NetworkCapabilities.TRANSPORT_WIFI
                        )
                    }
                }
            }
        }
        return false
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}