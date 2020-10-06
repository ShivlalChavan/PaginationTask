package id.mustofa.pagingretrofit.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.paginationtask.R
import com.example.paginationtask.model.User

import kotlinx.android.synthetic.main.item_user_row.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  fun setMovie(user: User?) {
   // val pos = adapterPosition + 1
    itemView.apply {
      var title = user?.firstName ?: "Loading..."
      title = "Name:- $title"
      var useremail = user?.email ?:"Loading..."
       useremail = "Email: $useremail"
      name.text = title
      email.text = useremail
      Glide.with(imgProfile.context).load(user?.profileImage)
        .centerCrop()
        .thumbnail(0.5f)
        .placeholder(R.drawable.place_holder)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(imgProfile)
    }
  }
}