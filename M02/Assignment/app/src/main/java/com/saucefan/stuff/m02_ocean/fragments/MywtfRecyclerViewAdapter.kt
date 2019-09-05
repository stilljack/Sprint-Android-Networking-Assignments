package com.saucefan.stuff.m02_ocean.fragments

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.saucefan.stuff.m02_ocean.R


import com.saucefan.stuff.m02_ocean.fragments.wtfFragment.OnListFragmentInteractionListener
import com.saucefan.stuff.m02_ocean.fragments.dummy.DummyContent.DummyItem
import com.saucefan.stuff.m02_ocean.model.wtf

import kotlinx.android.synthetic.main.fragment_wtf.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MywtfRecyclerViewAdapter(
    private val mValues: List<wtf>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MywtfRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as wtf
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_wtf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mIdView.text = item.name
   //     holder.mContentView.text = item.content

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.tv1
      //  val mContentView: TextView = mView

        override fun toString(): String {
            return super.toString() + " '" + mView.tv1+ "'"
        }
    }
}
