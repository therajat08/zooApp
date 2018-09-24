package com.example.rajat.zooapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {
    var listOfAnimals = ArrayList<animal>()
    var adapter:animalsAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //loading animals
        listOfAnimals.add(
                animal( "baboon","baboon lives in a scary place",R.drawable.baboon))
        listOfAnimals.add(
                animal( "bulldog","bulldog lives in a scary place",R.drawable.bulldog))
        listOfAnimals.add(
                animal( "panda","panda lives in a scary place",R.drawable.panda))
        listOfAnimals.add(
                animal( "swallow_bird","swallow_bird lives in a scary place",R.drawable.swallow_bird))
        listOfAnimals.add(
                animal( "white_tiger","white_tiger lives in a scary place",R.drawable.white_tiger))
        listOfAnimals.add(
                animal( "zebra","zebra lives in a scary place",R.drawable.zebra))
        adapter = animalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter = adapter
    }
    class animalsAdapter:BaseAdapter{
        var listOfAnimals = ArrayList<animal>()
        var context:Context?=null
        constructor(context:Context,listOfAnimals: ArrayList<animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context=context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal = listOfAnimals[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myview = inflator.inflate(R.layout.animal_ticket,null)
            myview.tvName.text = animal.name!!
            myview.tvDes.text = animal.des!!
            myview.animalImg.setImageResource(animal.image!!)
            return myview
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
