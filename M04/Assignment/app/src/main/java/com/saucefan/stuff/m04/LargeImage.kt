package com.saucefan.stuff.m04

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class LargeImage: IntentService(INTENT_SERVICE_DOWNLOAD_IMG) {

    override fun onHandleIntent(intent: Intent?) {

        Thread(Runnable() {

            val bitmap = NetworkAdapter.getBitmapFromUrl(IMG_ONE,220,220)

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

    companion object {
        const val DOWNLOADED_ACTION ="DOWNLOADED_ACTION"
        const val DOWNLOAD_IMAGE = "DOWNLOAD_IMAGE"
        const val IMG_ONE ="https://66.media.tumblr.com/6aed39dfe98e65c4b9f4898013dde997/tumblr_p1cjeqs03I1woyzf7o1_1280.jpg"
        const val INTENT_SERVICE_DOWNLOAD_IMG = "INTENT_SERVICE_DOWNLOAD_IMG"
    }
}
