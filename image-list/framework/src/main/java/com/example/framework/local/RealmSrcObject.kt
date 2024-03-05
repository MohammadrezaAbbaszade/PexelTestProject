package com.example.framework.local

import com.example.domain.Src
import io.realm.RealmObject

open class RealmSrcObject(
    var landscape: String? = null,
    var large: String? = null,
    var large2x: String? = null,
    var medium: String? = null,
    var original: String? = null,
    var portrait: String? = null,
    var small: String? = null,
    var tiny: String? = null
) : RealmObject()


fun RealmSrcObject.srcObjectToRealmSrcObject(src: Src): RealmSrcObject {
    return RealmSrcObject(
        landscape = src.landscape,
        large = src.large,
        large2x = src.large2x,
        medium = src.medium,
        original = src.original,
        portrait = src.portrait,
        small = src.small,
        tiny = src.tiny
    )
}

fun RealmSrcObject.realmSrcObjectToSrc(realmSrcObject: RealmSrcObject): Src {
    return Src(
        landscape = realmSrcObject.landscape?:"",
        large = realmSrcObject.large?:"",
        large2x = realmSrcObject.large2x?:"",
        medium = realmSrcObject.medium?:"",
        original = realmSrcObject.original?:"",
        portrait = realmSrcObject.portrait?:"",
        small = realmSrcObject.small?:"",
        tiny = realmSrcObject.tiny?:""
    )
}