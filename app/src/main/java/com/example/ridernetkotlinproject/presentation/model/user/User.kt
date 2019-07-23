package com.example.ridernetproject

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.text.DateFormat
import java.util.Date

class User : Serializable {

    @SerializedName("uid")
    @Expose
    var id: Long = 0
    @SerializedName("name")
    @Expose
    var fullName: String? = null
    @SerializedName("online")
    @Expose
    private var isOnline: Int = 0
    @SerializedName("vip_bg")
    @Expose
    private var vipBG: String? = null
    @SerializedName("verified")
    @Expose
    private var verified: Int = 0
    @SerializedName("user_post_type")
    @Expose
    private var userPostType: Int = 0
    @SerializedName("avatar_date")
    @Expose
    private var avatarDate: Long = 0
    @SerializedName("avatar")
    @Expose
    var bigAvatar: String? = null
    @SerializedName("avatar_small")
    @Expose
    var smallAvatar: String? = null
    private var birthData: Long = 0
    @SerializedName("sex")
    @Expose
    var gender: Int = 0
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("phone")
    @Expose
    private val phone: String? = null
    @SerializedName("friends_count")
    @Expose
    var friendCount: Int = 0
    @SerializedName("unconfirmed_friends_count")
    @Expose
    var subscribesCount: Int = 0
    @SerializedName("posts_count")
    @Expose
    private val postsCount: Int = 0
    @SerializedName("checkin_count")
    @Expose
    var checkinsCount: Int = 0
    @SerializedName("rating")
    @Expose
    var raiting: Long = 0
    @SerializedName("show_on_map")
    @Expose
    private val showOnMap: Int = 0
    @SerializedName("lat")
    @Expose
    private val lat: Double = 0.toDouble()
    @SerializedName("lon")
    @Expose
    private val lon: Double = 0.toDouble()
    @SerializedName("send_push")
    @Expose
    private val sendPush: Int = 0
    @SerializedName("privacy_settings")
    @Expose
    private val privacySettings: Int = 0
    @SerializedName("profile_visible_only_to_friends")
    @Expose
    private val visibleOnlyFriends: Int = 0
    @SerializedName("events_visible_only_to_friends")
    @Expose
    private val eventsVisibleOnlyFriends: Int = 0
    @SerializedName("bot_uid")
    @Expose
    private val botUid: Int = 0
    @SerializedName("admin")
    @Expose
    private val admin: Int = 0
    @SerializedName("vip")
    @Expose
    private val vip: Int = 0
    @SerializedName("identity")
    @Expose
    private val identity: String? = null
    @SerializedName("city_name")
    @Expose
    var cityName: String? = null
    @SerializedName("country_name")
    @Expose
    var countryName: String? = null
    @SerializedName("is_visible")
    @Expose
    private val isVisible: Int = 0

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /*if(Integer.parseInt(arrDateCur[1])<Integer.parseInt(arrDate[1]) ||
                (Integer.parseInt(arrDateCur[1])==Integer.parseInt(arrDate[1]) && Integer.parseInt(arrDateCur[0])<Integer.parseInt(arrDate[0]))){
        Log.d("month",date.toString());
        Log.d("mon","");*/
    val age: Int
        get() {
            //val date = Date(birthData * 1000)
            val birthday = DateFormat.getDateTimeInstance().format(Date(birthData * 1000))

            val curDate = DateFormat.getDateTimeInstance().format(Date(System.currentTimeMillis()))
            val arrDate = birthday.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val arrDateCur = curDate.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val age = Integer.parseInt(arrDateCur[2]) - Integer.parseInt(arrDate[2])
            Log.d("birthday", birthday)
            Log.d("now", curDate)
            return age
        }

    constructor(
        userId: Long,
        fullName: String,
        isOnline: Int,
        vipBG: String,
        verified: Int,
        userPostType: Int,
        avatarDate: Long,
        bigAvatar: String,
        smallAvatar: String,
        birthData: Long,
        gender: Int,
        status: String
    ) {
        this.id = userId
        this.fullName = fullName
        this.vipBG = vipBG
        this.verified = verified
        this.userPostType = userPostType
        this.avatarDate = avatarDate
        this.bigAvatar = bigAvatar
        this.smallAvatar = smallAvatar
        this.birthData = birthData
        this.gender = gender
        this.isOnline = isOnline
        this.status = status
    }

    constructor(
        userId: Long,
        fullName: String,
        isOnline: Int,
        vipBG: String,
        verified: Int,
        userPostType: Int,
        avatarDate: Long,
        bigAvatar: String,
        smallAvatar: String
    ) {
        this.id = userId
        this.fullName = fullName
        this.vipBG = vipBG
        this.verified = verified
        this.userPostType = userPostType
        this.avatarDate = avatarDate
        this.bigAvatar = bigAvatar
        this.smallAvatar = smallAvatar
        this.isOnline = isOnline
    }

    constructor(
        userId: Long,
        fullName: String,
        isOnline: Int,
        vipBG: String,
        verified: Int,
        avatarDate: Long,
        bigAvatar: String,
        smallAvatar: String
    ) {
        this.id = userId
        this.fullName = fullName
        this.vipBG = vipBG
        this.verified = verified
        this.avatarDate = avatarDate
        this.bigAvatar = bigAvatar
        this.smallAvatar = smallAvatar
        this.isOnline = isOnline
    }


    constructor() {
        this.fullName = fullName
    }

    constructor(fullName: String, smallAvatar: String, id: Long) {
        this.fullName = fullName
        this.smallAvatar = smallAvatar
        this.id = id
    }

    fun getBirthData(): String {
        return DateFormat.getDateTimeInstance().format(Date(birthData * 1000))
    }

    fun setBirthData(birthData: Long) {
        this.birthData = birthData
    }

    fun isOnline(): Boolean {
        return if (isOnline == 1) {
            true
        } else false
    }

    fun setOnline(online: Int) {
        isOnline = online
    }

    fun getVerified(): Boolean {
        return if (verified == 1) {
            true
        } else false
    }

    fun setVerified(verified: Int) {
        this.verified = verified
    }

    fun getUserPostType(): Boolean {
        return if (userPostType == 1) {
            true
        } else false
    }

    fun setUserPostType(userPostType: Int) {
        this.userPostType = userPostType
    }

    fun getAvatarDate(): String {
        return DateFormat.getDateTimeInstance().format(Date(avatarDate * 1000))
    }

    fun setAvatarDate(avatarDate: Long) {
        this.avatarDate = avatarDate
    }

    fun getCountryAndCity(): String {
        var result = ""
        if (cityName!= null) {
            result += cityName
        }
        if (countryName != null) {
            if (result != "") {
                result += ", $countryName"
            } else {
                result += countryName
            }
        }
        return result
    }

    override fun toString(): String {
        return "User{" +
                "userId=" + id +
                ", fullName='" + fullName + '\''.toString() +
                ", isOnline=" + isOnline +
                ", vipBG='" + vipBG + '\''.toString() +
                ", verified=" + verified +
                ", userPostType=" + userPostType +
                ", avatarDate=" + avatarDate +
                ", bigAvatar='" + bigAvatar + '\''.toString() +
                ", smallAvatar='" + smallAvatar + '\''.toString() +
                ", birthData='" + birthData + '\''.toString() +
                ", gender=" + gender +
                ", status='" + status + '\''.toString() +
                '}'.toString()
    }
}
