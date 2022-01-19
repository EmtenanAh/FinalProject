package com.example.finalproject.View.Fragment.Kindergarten

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.View.Dhahran.KindergartenAdapter


class KindergartenFragment : Fragment() {
lateinit var adapter: KindergartenAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      var v = inflater.inflate(R.layout.fragment_kindergarten, container, false)
      val viewModel: KindergartenViewModel by viewModels()
      var RCKindergarten =v.findViewById<RecyclerView>(R.id.RCKindergarten)
        var cardDammam=v.findViewById<ConstraintLayout>(R.id.cardDammam)
        var cardDhahran=v.findViewById<ConstraintLayout>(R.id.cardDhahran)
        var cardAlkhobar=v.findViewById<ConstraintLayout>(R.id.cardAlkhobar)
        cardDammam.setOnClickListener {
            viewModel.getKindergartenBycity("Dammam").observe(this,{
                if (it!=null)
                    RCKindergarten.adapter=KindergartenAdapter(it)
            })
        }
        cardDhahran.setOnClickListener {
            viewModel.getKindergartenBycity("Dhahran").observe(this,{
                if (it!=null)
                    RCKindergarten.adapter=KindergartenAdapter(it)
            })
        }
        cardAlkhobar.setOnClickListener {
            viewModel.getKindergartenBycity("Khobar").observe(this,{
                if (it!=null)
                    RCKindergarten.adapter=KindergartenAdapter(it)
            })
        }
        RCKindergarten.layoutManager = LinearLayoutManager(context)
      viewModel.getkindergarten().observe(this, { list ->
          RCKindergarten.adapter = KindergartenAdapter(list)
      })

        var searchView=v.findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
               adapter.filter.filter(query)
                return false
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                RCKindergarten.adapter=adapter
                return false
            }

        })


        return v

    }


    }
