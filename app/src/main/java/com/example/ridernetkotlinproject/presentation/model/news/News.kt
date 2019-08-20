package com.example.ridernetkotlinproject.presentation.model.news

import com.example.ridernetproject.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import java.text.DateFormat
import java.util.Date

class News {
    @SerializedName("user")
    @Expose
    var user: User
    @SerializedName("post_id")
    @Expose
    var newsId: Long = 0
    @SerializedName("type")
    @Expose
    private var type: Int = 0
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("text")
    @Expose
    var txtUser: String? = null
    @SerializedName("comment_count")
    @Expose
    var txtCommentCount: Int = 0
    @SerializedName("likes")
    @Expose
    var txtCountLike: Int = 0
    @SerializedName("complaint")
    @Expose
    private var complaint: Int = 0
    @SerializedName("like")
    @Expose
    private var isLike: Int = 0
    @SerializedName("date")
    @Expose
    private var timeNews: Long = 0
    @SerializedName("name_user_of_post")
    @Expose
    var txtNameUserNews: String? = null
    @SerializedName("is_allow_edit")
    @Expose
    private var isAllowEdit: Int = 0
    @SerializedName("image_aspect")
    @Expose
    private var imageAspect: Int = 0
    @SerializedName("image")
    @Expose
    var image: String? = null
    @SerializedName("image_small")
    @Expose
    var imageSmall: String? = null
    @SerializedName("likes_user")
    internal  var listLikeUsers: List<User>? = null


    constructor(newsId: Long, type: Int, title: String, txtUser: String, txtCommentCount: Int,
                txtCountLike: Int, complaint: Int, user: User, timeNews: Long, isLike: Int,
                isAllowEdit: Int, imageAspect: Int, image: String, imageSmall: String, listUsers: List<User>) {
        this.newsId = newsId
        this.type = type
        this.title = title
        this.txtUser = txtUser
        this.user = user
        this.txtNameUserNews = user.fullName
        this.timeNews = timeNews
        this.txtCountLike = txtCountLike
        this.complaint = complaint
        this.txtCommentCount = txtCommentCount
        this.isLike = isLike
        this.isAllowEdit = isAllowEdit
        this.imageAspect = imageAspect
        this.image = image
        this.imageSmall = imageSmall
        this.listLikeUsers = listUsers
    }

    constructor(
        user: User,
        timeNews: Long,
        txtUser: String,
        txtCountLike: Int,
        txtCommentCount: Int,
        isLike: Int
    ) {
        this.user = user
        this.txtNameUserNews = user.fullName
        this.timeNews = timeNews
        this.txtUser = txtUser
        this.txtCountLike = txtCountLike
        this.txtCommentCount = txtCommentCount
        this.isLike = isLike
    }


    fun getTimeNews(): String {
        val date = DateFormat.getDateTimeInstance().format(Date(timeNews * 1000))
        val curDate = DateFormat.getDateTimeInstance().format(Date(System.currentTimeMillis()))
        val arrDate = date.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val arrDateCur = curDate.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val arrTime = arrDate[4].split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (arrDate[0] == arrDateCur[0]) {
            return "сегодня в " + arrTime[0] + ":" + arrTime[1]
        } else if (Integer.parseInt(arrDate[0]) - 1 == Integer.parseInt(arrDateCur[0])) {
            return "вчера в " + arrTime[0] + ":" + arrTime[1]
        }
        return arrDate[0] + " " + arrDate[1] + " " + arrDate[2] + " " + arrTime[0] + ":" + arrTime[1]
    }

    fun setTimeNews(timeNews: Long) {
        this.timeNews = timeNews
    }

    fun getType(): Boolean {
        return if (type == 1) {
            true
        } else false
    }

    fun setType(type: Int) {
        this.type = type
    }

    fun getComplaint(): Boolean {
        return if (complaint == 1) {
            true
        } else false
    }

    fun setComplaint(complaint: Int) {
        this.complaint = complaint
    }

    fun getIsAllowEdit(): Boolean {
        return if (isAllowEdit == 1) {
            true
        } else false
    }

    fun setIsAllowEdit(isAllowEdit: Int) {
        this.isAllowEdit = isAllowEdit
    }

    fun getImageAspect(): Boolean {
        return if (imageAspect == 1) {
            true
        } else false
    }

    fun setImageAspect(imageAspect: Int) {
        this.imageAspect = imageAspect
    }

    fun getListLikeUsers(): String {
        var str = ""
        if (listLikeUsers == null){return ""}
        for (user in listLikeUsers!!) {
            //if(user != null) {
                str += user.fullName!! + ", "
           // }
        }
        return str.substring(0, str.length - 2)
    }

    fun setListLikeUsers(listLikeUsers: List<User>) {
        this.listLikeUsers = listLikeUsers
    }

    override fun toString(): String {
        return "News{" +
                "txtNameUserNews='" + txtNameUserNews + '\''.toString() +
                ", txtUser='" + txtUser + '\''.toString() +
                ", txtCountLike=" + txtCountLike +
                ", txtCommentCount=" + txtCommentCount +
                ", isLike=" + isLike +
                '}'.toString()
    }

    fun isLike(): Boolean {
        return if (isLike == 1) {
            true
        } else false
    }

    fun setLike(like: Int) {
        isLike = like
    }

   internal fun setTxtCountLike(txtCountLike: Int){
        this.txtCountLike = txtCountLike
    }
}