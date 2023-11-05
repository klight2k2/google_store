package app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goole_store.R

class AppAdapter(val books: ArrayList<App>)  : RecyclerView.Adapter<AppAdapter.BookViewHolder>()  {

    class BookViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView)  {
        val imgBook= itemView.findViewById<ImageView>(R.id.img_app)
        val rateText=itemView.findViewById<TextView>(R.id.tv_rate)
        val titleText= itemView.findViewById<TextView>(R.id.tv_title)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_app,parent,false)
        return BookViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

            holder.imgBook.setImageResource(books[position].resourceId)
            holder.rateText.text=books[position].rate
            holder.titleText.text=books[position].title
    }
}