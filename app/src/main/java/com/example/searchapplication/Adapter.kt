package com.example.searchapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_activity.view.*

class Adapter(val dogList: ArrayList<Dog>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val dog = dogList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dog.size
    }

    fun filter(text: String) {
        val dogcopy: ArrayList<Dog> = dog
        var text = text
        var result: ArrayList<Dog> = ArrayList()
        if(text.isEmpty()){
            result = dogcopy
        }
        text = text.toLowerCase()
        for (dog in dogcopy) {
            Log.i("searchInfo:","For")
            if (dog.name.toLowerCase().contains(text)) {
                Log.i("searchInfo:","Equal!")
                result.add(dog)
            }
        }
        dog.clear()
        dog.addAll(result)

        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(dog: Dog) {
            itemView.name.text = dog.name
            itemView.age.text = dog.age.toString()
            itemView.kind.text = dog.kind
            Picasso.get().load(dog.picture).into(itemView.dogImage)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val searchViewHolder: ViewHolder = holder as ViewHolder
        searchViewHolder.bindItem(dog[position])
    }


}