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
import android.util.Log
import kotlinx.android.synthetic.main.cards.view.*
import org.w3c.dom.Text


class Adapter(val mutlist: MutableList<wtf>) : RecyclerView.Adapter<Adapter.ViewHolder>() {/*
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
        return mutlist.size
    }
/*   interface OnRecyclerInterfaceListener {
       fun onItemSelected(item:Items)
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentSelection = mutlist[position]
            holder.tv1.text = currentSelection.name

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
class TextHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
    //2
    private var view: View = v
    private var text: Text? = null

    //3
    init {
        v.setOnClickListener(this)
    }

    //4
    override fun onClick(v: View) {
        Log.d("RecyclerView", "CLICK!")
    }

    companion object {
        //5
        private val TEXT_KEY = "TEXT"
    }
}