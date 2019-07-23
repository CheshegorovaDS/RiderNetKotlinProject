package com.example.ridernetkotlinproject.presentation.fragments_menu_activity.functions

import com.example.ridernetkotlinproject.R
import com.example.ridernetkotlinproject.presentation.model.news.News

class LikeNews: ILike<News> {

    override fun changeHeart(obj: News): Int =  if (obj.isLike()) R.drawable.ic_heart  else  R.drawable.ic_heart2

    override fun changeTxtNik(obj: News):String {
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

    override fun changeCountLikes(obj: News): String =
        if (obj.isLike()) {
            obj.setTxtCountLike(++obj.txtCountLike)
             "${obj.txtCountLike}"
        }else {
            obj.setTxtCountLike(--obj.txtCountLike)
             "${obj.txtCountLike}"
        }
}
