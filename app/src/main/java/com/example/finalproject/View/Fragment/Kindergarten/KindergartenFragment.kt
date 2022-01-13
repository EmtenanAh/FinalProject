package com.example.finalproject.View.Fragment.Kindergarten

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.R


class KindergartenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var v = inflater.inflate(R.layout.fragment_neighborhoods, container, false)
//        val viewModel: DhahranViewModel by viewModels()
//        var dhahran_recyclerview = findViewById<RecyclerView>(R.id.dhahran_recyclerview)
////       dhahran_recyclerview.layoutManager = LinearLayoutManager(this)
////        viewModel.getdhahran().observe(this, { list ->
////            dhahran_recyclerview.adapter = DhahranAdapter(list)
////        })
//
//    }
//}
        return v

    }


    }
