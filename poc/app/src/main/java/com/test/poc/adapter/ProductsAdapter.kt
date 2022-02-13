package com.test.poc.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.test.poc.R
import com.test.poc.model.datamodels.ProductDataModel
import com.test.poc.util.Utils
import java.util.*
import kotlin.collections.ArrayList

class ProductsAdapter(private val dataSet: ArrayList<ProductDataModel>):
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>(), Filterable {
    lateinit var context: Context
    private val mThumbIds = arrayListOf(
        R.drawable.ic_range_rover, R.drawable.ic_alpine_roadster, R.drawable.ic_bmw_330i,
        R.drawable.ic_mercedez_benz_glc, R.drawable.ic_tacoma,)
    var filterList = ArrayList<ProductDataModel>()

    init {
        filterList = dataSet
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        context = viewGroup.context
        var view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.icon.setImageResource(mThumbIds[position])
        viewHolder.title.text = filterList[position].make?: "Not Available"
        viewHolder.price.text = Utils.formatPrice(filterList[position].customerPrice)
        val rating = dataSet[position].rating?: 0
        viewHolder.ratingLayout.removeAllViews()
        if (rating > 0) {
            var star_lyt = LinearLayout(viewHolder.itemView.context)
                for (i in 0 until rating)
                {
                    val imagebyCode = ImageView(viewHolder.itemView.context)
                    imagebyCode.setImageResource(R.drawable.star)
                    star_lyt.addView(imagebyCode)
                }
                viewHolder.ratingLayout.addView(star_lyt)
            }

        val pros = dataSet[position].prosList
        if(pros.size>0) {
            viewHolder.prosBulletPoints.removeAllViews()
            viewHolder.pros.visibility = View.VISIBLE
            viewHolder.prosBulletPoints.visibility = View.VISIBLE
            bulletPointsView(viewHolder, viewHolder.prosBulletPoints, pros) }

        val cons = dataSet[position].consList
        if(cons.size>0) {
            viewHolder.consBulletPoints.removeAllViews()
            viewHolder.cons.visibility = View.VISIBLE
            viewHolder.consBulletPoints.visibility = View.VISIBLE
            bulletPointsView(viewHolder, viewHolder.consBulletPoints, cons) }
        }

    private fun bulletPointsView(viewHolder: ViewHolder, linearLayout: LinearLayout, items: ArrayList<String>) {
        var pros_lyt = LinearLayout(viewHolder.itemView.context)
        for (i in 0 until items.size) {
            val pros_rel_lyt = RelativeLayout(viewHolder.itemView.context)
            val prosImagebyCode = ImageView(viewHolder.itemView.context)
            prosImagebyCode.setImageResource(R.drawable.ic_bullet_icon)
            var prosTextByCode = TextView(viewHolder.itemView.context)
            prosTextByCode.setTextColor(context.getResources().getColor(R.color.black))
            prosTextByCode.textSize = 16.0f
            prosTextByCode.setTypeface(Typeface.DEFAULT_BOLD)
            val params: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            params.setMargins(70, 4, 0, 0)
            prosTextByCode.setLayoutParams(params)
            prosTextByCode.text = items[i]
            if(!prosTextByCode.text.isNullOrEmpty()){
            pros_rel_lyt.addView(prosImagebyCode)
            pros_rel_lyt.addView(prosTextByCode)
            }
            pros_lyt.orientation = LinearLayout.VERTICAL
            pros_lyt.addView(pros_rel_lyt)
        }
        linearLayout.addView(pros_lyt)
    }

    override fun getItemCount(): Int  {
        return filterList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView
        val title: TextView
        val price: TextView
        val ratingLayout: LinearLayout
        val pros: TextView
        val cons: TextView
        val consBulletPoints: LinearLayout
        val prosBulletPoints: LinearLayout

        init {
            icon = view.findViewById(R.id.icon)
            title = view.findViewById(R.id.title)
            price = view.findViewById(R.id.price)
            ratingLayout = view.findViewById(R.id.rating_layout)
            pros = view.findViewById(R.id.pros)
            cons = view.findViewById(R.id.cons)
            consBulletPoints = view.findViewById(R.id.cons_bullet_points)
            prosBulletPoints = view.findViewById(R.id.pros_bullet_points)

        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults? {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    filterList = dataSet
                }else{
                    val resultList = ArrayList<ProductDataModel>()
                    for (row in dataSet) {
                        if (row.make!!.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))) {
                            resultList.add(row)
                        }else if(row.model!!.lowercase(Locale.ROOT).contains(charSearch.lowercase(Locale.ROOT))){
                            resultList.add(row)
                        }
                    }
                        filterList = resultList
                }
                    val filterResults = FilterResults()
                    filterResults.values = filterList
                    return filterResults
            }
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<ProductDataModel>
                notifyDataSetChanged()
            }
        }
    }

}
