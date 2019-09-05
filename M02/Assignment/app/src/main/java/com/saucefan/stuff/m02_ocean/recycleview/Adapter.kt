package com.saucefan.stuff.m02_ocean.recycleview

import com.saucefan.stuff.m02_ocean.R
import com.saucefan.stuff.m02_ocean.model.wtf
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.cards.view.*
import org.w3c.dom.Text


class Adapter(val list: MutableList<wtf>) : RecyclerView.Adapter<Adapter.ViewHolder>() {/*
    internal var callback: OnRecyclerInterfaceListener? = null
  *//*  fun setOnRecyclerInterfaceListener(callback: OnRecyclerInterfaceListener) {
        this.callback = callback
    }*//*
*/
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.cards, parent, false)
    return ViewHolder(viewGroup)

}

    override fun getItemCount(): Int {
        return list.size
    }
/*   interface OnRecyclerInterfaceListener {
       fun onItemSelected(item:Items)
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.tv1 = list[position].name


        //this ain't working cause we're only setting it on the last view created
        holder.ratingView.setidref(position)
        //holder.imageIv.setImageDrawable(holder.imageIv.getContext().getDrawable(shoppingList[position].resourceId))

        val currentSelection = list[position]

        holder.nameTv.setOnClickListener {view ->
            /* callback?.onItemSelected(currentSelection)*/


            val manager = (view.context as AppCompatActivity).supportFragmentManager
            val bundle = Bundle()
            bundle.putInt(ITEM_KEY, position)
            bundle.putString(ITEMTRANSFER,currentSelection.name)
            val fragment = RatingFragment.newInstance(position,currentSelection)
            fragment.setArguments(bundle)
            manager.beginTransaction()
                .add(fragment, "first")
                .addToBackStack("thisbacko")
                .commit()
        }
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv1: TextView = view.tv1
        val tv2: TextView = view.tv2
        val tv3: TextView = view.tv3
        val tv4: TextView = view.tv4

        /*     fun bindModel(currentSelection: Items) {
                 if (currentSelection.ordered) {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.bought))
                 } else {
                     parentView.setBackgroundColor(ContextCompat.getColor(parentView.context, R.color.unbought))
                 }
             }*/
    }


}
