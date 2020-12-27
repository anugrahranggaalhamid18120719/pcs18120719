package com.appaugmentedreality.app.ui.forum


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appaugmentedreality.app.data.model.Forum
import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appaugmentedreality.app.R
import com.appaugmentedreality.app.databinding.ItemForumBinding
import com.appaugmentedreality.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide
import java.net.CacheResponse

class ForumAdapter(val list: ArrayList<Forum>): RecyclerView.Adapter<ForumAdapter.PostViewHolder>(){
    inner class PostViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(forum: Forum): String {
            with(itemView){
                val text = "name: ${forum.name}\n"+
                        " address:${forum.address}\n" +
                        " region: ${forum.region}\n" +
                        " phone: ${forum.phone}\n" +
                        " province: ${forum.province}\n"
              return text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_forum, parent, false)
        return PostViewHolder(view)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.size
}
/*class ForumAdapter(val context: Context) : BaseAdapter<Forum>(R.layout.item_forum) {
    override fun onBind(binding: ViewDataBinding?, data: Forum) {
       val mBinding = binding as ItemForumBinding
        Glide.with(context).load(data.name).into(mBinding.itemposter)
    }

    override fun onClick(binding: ViewDataBinding?, data: Forum) {
       val intent = Intent(context, ForumActivity::class.java)
        intent.putExtra(ForumActivity.OPEN_FORUM, data)
        context.startActivity(intent)
    }
}*/