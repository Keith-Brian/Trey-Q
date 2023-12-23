package com.devkaybee.treyq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.devkaybee.treyq.databinding.FragmentReportBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ReportFragment : Fragment(R.layout.fragment_report) {

    private lateinit var reportScreen: FragmentReportBinding
    private lateinit var reportArrayList: ArrayList<UploadData>
    private lateinit var reportReference: DatabaseReference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reportScreen = FragmentReportBinding.bind(view)

        reportScreen.reportRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        reportScreen.reportRecyclerView.setHasFixedSize(true)
        reportArrayList = arrayListOf<UploadData>()
        getData()
    }


    private fun getData(){

        reportReference = FirebaseDatabase.getInstance().getReference("report")
        reportReference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for (reportSnapshot in snapshot.children){
                        val report = reportSnapshot.getValue(UploadData::class.java)

                        reportArrayList.add(report!!)
                    }

                    reportScreen.reportRecyclerView.adapter = ReportListAdapter(reportArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }



}