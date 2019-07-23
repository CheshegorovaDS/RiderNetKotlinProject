package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import java.util.ArrayList
import android.support.v4.content.ContextCompat.startActivities
import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.fragments_menu_activity.functions.LikeNews
import com.example.ridernetkotlinproject.presentation.model.news.News
import com.example.ridernetkotlinproject.presentation.showPhoto.ShowPhotoActivity

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.TableViewHolder> {
    var view:View? = null
    internal var list: ArrayList<News>
    lateinit var nextHomepage: NextHomepage
    lateinit var getCurrentPosition: GetCurrentPosition

    constructor() {
        list = ArrayList<News>()
    }

    constructor(list: ArrayList<News>){
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TableViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_news, parent, false)
        return TableViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_news, parent, false))
    }

    override fun getItemCount(): Int { return list.size }

    override fun onBindViewHolder(holder: TableViewHolder, i: Int) {

        downloadPhoto(holder, i )

        holder.imgLike.setImageResource(LikeNews().changeHeart(list.get(i)))
        holder.txtNameUserNews.setText(list[i].user.fullName)
        holder.timeNews.text = list[i].getTimeNews()
        holder.txtUser.setText(list[i].txtUser)
        holder.txtCountLike.setText("${list[i].txtCountLike}")
        holder.txtCommentCount.setText("${list[i].txtCommentCount}")
        holder.txtNik.setText(LikeNews().changeTxtNik(list.get(i)))
        if(list[i].getListLikeUsers().equals(""))holder.txtNik.visibility = View.INVISIBLE
        else holder.txtNik.visibility = View.VISIBLE

        holder.imgLike.setOnClickListener {
            if (list[i].isLike()){ list[i].setLike(0)
            }else{ list[i].setLike(1) }
            val likeNews = LikeNews()
            holder.imgLike.setImageResource(likeNews.changeHeart(list.get(i)))
            holder.txtCountLike.setText(likeNews.changeCountLikes(list.get(i)))
            var txtNik:String = likeNews.changeTxtNik(list.get(i))
            holder.txtNik.setText(txtNik)
            if(txtNik.equals(""))holder.txtNik.visibility = View.INVISIBLE
            else holder.txtNik.visibility = View.VISIBLE
        }

        holder.imgNews?.setOnClickListener(View.OnClickListener { showPhoto(i) })

        holder.imgAvatar.setOnClickListener { goToHomepage(list[i].user.id) }

        if (i == itemCount - 1) {
            getCurrentPosition!!.getPosition(i)
        }
        holder.progressBar.visibility = View.INVISIBLE
    }

    fun downloadPhoto(holder: TableViewHolder, i: Int) {

        list[i].user?.smallAvatar?.let {
            Picasso.with(view!!.context) //передаем контекст приложения
                .load(it)
                .into(holder.imgAvatar) //ссылка на ImageView
        }?: run {
            holder.imgAvatar.setImageResource(R.drawable.ic_user)
        }

        list[i].image?.let {
            Picasso.with(view!!.context)
            .load(list[i].image)
            .into(holder.imgNews)
            holder.imgNews?.setVisibility(View.VISIBLE)
        }?: run{
            holder.imgNews?.setVisibility(View.GONE)
        }
    }

    fun showPhoto(i: Int) {
        val intent = Intent(view?.context, ShowPhotoActivity::class.java)
        intent.putExtra("photo", list[i].image)
        startActivities(view!!.context, arrayOf(intent))
    }

    fun goToHomepage(id: Long) {
        Log.d("userId", id.toString())
        nextHomepage!!.openHomepage(id)
    }

    inner class TableViewHolder @SuppressLint("WrongViewCast")
    constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal val txtNameUserNews: TextView
        internal val timeNews: TextView
        internal val txtUser: TextView
        internal val txtNik: TextView
        internal val txtCountLike: TextView
        internal val txtCommentCount: TextView
        internal val imgAvatar: ImageView
        internal var imgNews: ImageView? = null
        internal val imgLike: ImageView
        internal val progressBar: ProgressBar
        internal val cardView: CardView


        init {
            this.txtNameUserNews = view.findViewById<View>(R.id.txtNameUserNews) as TextView
            this.timeNews = view.findViewById<View>(R.id.txtTimeNews) as TextView
            this.txtUser = view.findViewById<View>(R.id.txtUser) as TextView
            this.txtNik = view.findViewById<View>(R.id.txtNik) as TextView
            this.txtCountLike = view.findViewById<View>(R.id.txtLike) as TextView
            this.txtCommentCount = view.findViewById<View>(R.id.txtcountComment) as TextView
            this.imgAvatar = view.findViewById<View>(R.id.imgAvatar) as ImageView
            this.imgNews = view.findViewById<View>(R.id.imgNews) as ImageView
            this.imgLike = view.findViewById<View>(R.id.imgLike) as ImageView
            this.imgNews = view.findViewById<View>(R.id.imgNews) as ImageView
            this.progressBar = view.findViewById<View>(R.id.progressBarNews) as ProgressBar
            this.cardView = view.findViewById<View>(R.id.card_view_news) as CardView
        }
    }

    interface NextHomepage {
        fun openHomepage(userId: Long?)
    }

    interface GetCurrentPosition {
        fun getPosition(index: Int): Int
    }

}
