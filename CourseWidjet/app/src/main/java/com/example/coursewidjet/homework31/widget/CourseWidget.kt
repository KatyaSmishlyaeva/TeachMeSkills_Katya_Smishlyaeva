package com.example.coursewidjet.homework31.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import com.example.coursewidjet.R
import com.example.coursewidjet.homework31.CourseActivity
import java.text.SimpleDateFormat
import java.util.*

class CourseWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle?
    ) {
        updateAppWidget(context, appWidgetManager, appWidgetId)
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {
    val date = SimpleDateFormat("dd/MM/yyyy")
    val currentDate = date.format(Date())

    val views = RemoteViews(context.packageName, R.layout.course_widget)
    val pendingIntent = Intent(context, CourseActivity::class.java)
        .let {
            PendingIntent.getActivity(context, 0, it, 0)
        }

    views.setOnClickPendingIntent(R.id.widget_course, pendingIntent)
    views.setTextViewText(R.id.tv_data, currentDate)

    appWidgetManager.updateAppWidget(appWidgetId, views)
}