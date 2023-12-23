package com.devkaybee.treyq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReportListAdapter (var reportList: ArrayList<UploadData>): RecyclerView.Adapter<ReportListAdapter.ReportListViewHolder> (){

    inner class  ReportListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        //
        var temp: TextView = itemView.findViewById(R.id.valTemp)
        var pH: TextView = itemView.findViewById(R.id.valPh)
        var turbidity: TextView = itemView.findViewById(R.id.valTurbidity)
        var status: TextView = itemView.findViewById(R.id.valStatus)
        var date: TextView = itemView.findViewById(R.id.valDate)
        var time: TextView = itemView.findViewById(R.id.valTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_report_layout, parent,false)
        return  ReportListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReportListViewHolder, position: Int) {

        holder.apply {

            temp.text= reportList[position].temp.toString()
            pH.text= reportList[position].ph.toString()
            turbidity.text= reportList[position].turbidity.toString()
            status.text= reportList[position].status.toString()
            time.text= reportList[position].time.toString()
            date.text= reportList[position].date.toString()

        }


    }
    override fun getItemCount(): Int {
        return  reportList.size
    }
}