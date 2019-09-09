package com.saucefan.stuff.m04

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class LargeImage: IntentService(INTENT_SERVICE_DOWNLOAD_IMG) {



    override fun onHandleIntent(intent: Intent?) {

        Thread(Runnable() {

            val bitmap = NetworkAdapter.getBitmapFromUrl(urls(),0,0)

            val intent = Intent(DOWNLOADED_ACTION).apply {
                putExtra(DOWNLOAD_IMAGE,bitmap)
            }

            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            // stopSelf() unecessary since we're using IntentService
        }).start()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        stopSelf()

        super.onDestroy()
    }
    fun urls():String {
        when (pretense) {
            1 -> {
                pretense++
                return IMG_ONE
            }
            2 -> {
                pretense++
                return IMG_TWO
            }
            3 -> {

                pretense = 1
                return IMG_THREE
            }
            else -> return ""

        }
    }
    companion object {
        const val DOWNLOADED_ACTION ="DOWNLOADED_ACTION"
        const val DOWNLOAD_IMAGE = "DOWNLOAD_IMAGE"
        const val IMG_ONE ="https://66.media.tumblr.com/6aed39dfe98e65c4b9f4898013dde997/tumblr_p1cjeqs03I1woyzf7o1_1280.jpg"
        const val IMG_TWO="https://66.media.tumblr.com/b6f655135ddaec2bfeeed3bade109d9e/tumblr_osn0z4KRTU1w6k7kvo1_500.gif"
        const val IMG_THREE="https://66.media.tumblr.com/3317da4b16d28a3dab600775dc806d77/tumblr_olo0q1w8HR1unxnm9o9_1280.jpg"
        const val INTENT_SERVICE_DOWNLOAD_IMG = "INTENT_SERVICE_DOWNLOAD_IMG"
        var pretense = 1

    }
}
