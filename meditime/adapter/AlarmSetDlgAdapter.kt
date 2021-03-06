package com.example.meditime.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.meditime.model.NoticeAlarmInfo
import com.example.meditime.R

class AlarmSetDlgAdapter(val items:ArrayList<NoticeAlarmInfo>): RecyclerView.Adapter<AlarmSetDlgAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var alarm_time: TextView = itemView.findViewById(R.id.tv_alarmitem_time)
        var alarm_count: TextView = itemView.findViewById(R.id.tv_alarmitem_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_alarm_setdlg, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val time_list = items[position].set_date.split(" ")[1].split(":")
        val min = time_list[1].toInt()
        val type = items[position].set_type
        var hour = time_list[0].toInt()
        var am_pm = ""
        if(hour>12){
            am_pm = "오후"
            hour -= 12
        } else {
            am_pm = "오전"
        }

        holder.alarm_time.text = "$am_pm ${hour}:${"%02d".format(min)}"
        holder.alarm_count.text = "1일 ${items[position].set_amount}${type} 복용"
    }

}