package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.news.adapter

import android.content.Intent
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
import com.example.ridernetkotlinproject.presentation.model.news.News
import com.example.ridernetkotlinproject.presentation.showPhoto.ShowPhotoActivity

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.TableViewHolder>{
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

        downloadPhoto(holder, i)

        holder.apply {
            imgLike.setImageResource(changeHeart(list.get(i)))
            txtNameUserNews.setText(list[i].user.fullName)
            timeNews.text = list[i].getTimeNews()
            txtUser.setText(list[i].txtUser)
            txtCountLike.setText("${list[i].txtCountLike}")
            txtCommentCount.setText("${list[i].txtCommentCount}")
            txtNik.setText(changeTxtNik(list.get(i)))
        }

        if(list[i].getListLikeUsers().equals(""))holder.txtNik.visibility = View.INVISIBLE
        else holder.txtNik.visibility = View.VISIBLE

        holder.imgLike.setOnClickListener { putLike(list[i],holder) }

        holder.imgNews?.setOnClickListener{ list[i].image?.let { showPhoto(it) } }
        //it1 -> presenter.openPhoto(view?.context!!, it1)

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

    fun showPhoto(str: String) {
        val intent = Intent(view?.context, ShowPhotoActivity::class.java)
        intent.putExtra("photo", str)
        startActivities(view!!.context, arrayOf(intent))
    }

    fun goToHomepage(id: Long) {
        Log.d("userId", id.toString())
        nextHomepage!!.openHomepage(id)
    }

    fun putLike(news:News, holder: TableViewHolder){
        if (news.isLike()){ news.setLike(0)
        }else{ news.setLike(1) }
        holder.imgLike.setImageResource(changeHeart(news))
        holder.txtCountLike.setText(changeCountLikes(news))
        var txtNik:String = changeTxtNik(news)
        holder.txtNik.setText(txtNik)
        if(txtNik.equals(""))holder.txtNik.visibility = View.INVISIBLE
        else holder.txtNik.visibility = View.VISIBLE
    }

     fun changeHeart(obj: News): Int =  if (obj.isLike()) R.drawable.ic_heart  else  R.drawable.ic_heart2

     fun changeTxtNik(obj: News):String {
        if (obj.txtCountLike >= 10){
            return "Понравилось: ${obj.txtCountLike}"
        }
        var result:String=""
        if(obj.isLike()) { result += "Мне" }
        if (obj.getListLikeUsers().equals("")) { return result }
        if(!result.equals("")){result+=", "}
        result+=obj.getListLikeUsers()
        return  result
    }

     fun changeCountLikes(obj: News): String =
        if (obj.isLike()) {
            obj.setTxtCountLike(++obj.txtCountLike)
            "${obj.txtCountLike}"
        }else {
            obj.setTxtCountLike(--obj.txtCountLike)
            "${obj.txtCountLike}"
        }

    class TableViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNameUserNews = view.findViewById<TextView>(R.id.txtNameUserNews)
        val timeNews = view.findViewById<TextView>(R.id.txtTimeNews)
        val txtUser = view.findViewById<TextView>(R.id.txtUser)
        val txtNik = view.findViewById<TextView>(R.id.txtNik)
        val txtCountLike = view.findViewById<TextView>(R.id.txtLike)
        val txtCommentCount = view.findViewById<TextView>(R.id.txtcountComment)
        val imgAvatar = view.findViewById<ImageView>(R.id.imgAvatar)
        val imgNews = view.findViewById<ImageView>(R.id.imgNews)
        val imgLike = view.findViewById<ImageView>(R.id.imgLike)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBarNews)
    }

    interface NextHomepage {
        fun openHomepage(userId: Long?)
    }

    interface GetCurrentPosition {
        fun getPosition(index: Int): Int
    }

}

