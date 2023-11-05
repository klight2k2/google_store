package category

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.AppAdapter
import com.example.goole_store.R

class CategoryAdapter (val categories:ArrayList<Category>,val context:Context ) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView)  {
        val categoryText= itemView.findViewById<TextView>(R.id.tv_category)
        val rcvApp= itemView.findViewById<RecyclerView>(R.id.rcv_book)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.CategoryViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryAdapter.CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        holder.categoryText.text= categories[position].nameCategory

        val linearLayout:LinearLayoutManager= LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        val bookAdapter:AppAdapter= AppAdapter(categories[position].apps)

        holder.rcvApp.layoutManager=linearLayout
        holder.rcvApp.adapter=bookAdapter
    }

    override fun getItemCount(): Int {
        return  categories.size
    }
}